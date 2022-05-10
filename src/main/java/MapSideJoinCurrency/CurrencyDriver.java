package MapSideJoinCurrency;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.net.URI;

public class CurrencyDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Error: Give only two paths for <input> <output>");
            System.exit(1);
        }

        Job job = Job.getInstance(conf, "Distributed Cache");

        job.setJarByClass(CurrencyDriver.class);
        job.setMapperClass(CurrencyMap.class);
        //job.setReducerClass(CurrencyReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        try {

            // the complete URI(Uniform Resource
            // Identifier) file path in Hdfs
            job.addCacheFile(new URI("hdfs://127.0.0.1:9000/user/cache/currency.log"));
            //job.addCacheFile(new URI("/home/alonso/IdeaProjects/excersicesTraining/src/main/resources/currency.log"));
        } catch (Exception e) {
            System.out.println("File Not Added");
            System.exit(1);
        }
        FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // throws ClassNotFoundException, so handle it
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}
