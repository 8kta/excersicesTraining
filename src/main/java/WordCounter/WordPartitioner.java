package WordCounter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordPartitioner extends Partitioner<Text, IntWritable> {
    @Override
    public int getPartition(Text key, IntWritable value, int numpartitions) {
        if (numpartitions == 2){
            String partitionkey = key.toString();
            if (partitionkey.charAt(0) == 'h'){
                //return one partition file
                return 0;
            } else {
                //another partition file
                //we can get any number of partitions
                return 1;
            }
        }
        return 0;
    }
}
