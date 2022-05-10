package WordCounter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException {

        String s = value.toString();

        for (String word : s.split(" ")) {
            con.write(new Text(word), new IntWritable(1));
        }
    }
}
