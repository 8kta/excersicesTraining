package WordCounter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException {
        /*
         * Hello 1,1,1,1,1
         * Hai 1,1,1
         */
        int total = 0; // 0+1 = 1 + 1 = 2 , 5
        while (values.iterator().hasNext()) {
            IntWritable i = values.iterator().next();
            int i1 = i.get();
            total += i1;
        }

        con.write(key, new IntWritable(total));
        //hello 5
        //hai 3
    }
}
