package FacebookRelations;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FBMapper extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable k, Text v, Context con) throws IOException, InterruptedException {

        String line = v.toString();

        String[] w = line.trim().split(",");

        String user = w[0];

        String friend = w[1];

        con.write(new Text(user), new Text(friend));

        con.write(new Text(friend), new Text(user));

    }

}

