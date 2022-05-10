package MapSideJoins;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class UserActivityMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    // user map to keep the userId-userName
    private Map<Integer, String> userMap = new HashMap<>();

    @Override
    protected void map(LongWritable key, Text value,
                       Mapper<LongWritable, Text, IntWritable, Text>.Context context)
            throws IOException, InterruptedException {
        String[] columns = value.toString().split("\t");
        String str = Integer.parseInt(columns[1]) + "\t" + columns[2] + "\t" + columns[3] + "\t" + userMap.get(Integer.parseInt(columns[1]));
		/*if (columns != null && columns.length > 2) {
			UserActivityVO userActivityVO = new UserActivityVO();
			userActivityVO.setUserId(Integer.parseInt(columns[1]));
			userActivityVO.setComments(columns[2]);
			userActivityVO.setPostShared(columns[3]);
			userActivityVO.setUserName(userMap.get(userActivityVO.getUserId()));
			// writing into context
			//context.write(new IntWritable(userActivityVO.getUserId()), str);
		}*/
        context.write(new IntWritable(Integer.parseInt(columns[1])), new Text(str));
    }

    protected void setup(Mapper<LongWritable, Text, IntWritable, Text>.Context context)
            throws IOException, InterruptedException {
        // loading user map in context
        loadUserInMemory(context);
    }

    private void loadUserInMemory(Mapper<LongWritable, Text, IntWritable, Text>.Context context) {
        // currency.log is in distributed cache
        try (BufferedReader br = new BufferedReader(new FileReader("currency.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String columns[] = line.split("\t");
                userMap.put(Integer.parseInt(columns[0]), columns[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
