package MapSideJoinCurrency;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.GenericOptionsParser;

public class CurrencyDriver {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        if (otherArgs.length != 2)
        {
            System.err.println("Error: Give only two paths for <input> <output>");
            System.exit(1);
        }

        Job job = Job.getInstance(conf, "Distributed Cache");

        job.setJarByClass(CurrencyDriver.class);
        job.setMapperClass(CurrencyMap.class);
        job.setReducerClass(CurrencyReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        try {

            // the complete URI(Uniform Resource
            // Identifier) file path in Hdfs
            job.addCacheFile(new URI("hdfs://localhost:9000/cached_Geeks/stopWords.txt"));
        }
        catch (Exception e) {
            System.out.println("File Not Added");
            System.exit(1);
        }

    }
}
