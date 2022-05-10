package FacebookRelations;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FBDriver {

    public static void main(String[] args) throws Exception {

        Configuration c = new Configuration();
        Job j = new Job(c, "myfirstjob");
        j.setJarByClass(FBDriver.class);
        j.setMapperClass(FBMapper.class);
        j.setReducerClass(FBReducer.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(Text.class);


        Path p1 = new Path(args[0]);
        Path p2 = new Path(args[1]);

        FileInputFormat.addInputPath(j, p1);
        FileOutputFormat.setOutputPath(j, p2);
        p2.getFileSystem(c).delete(p2);

        System.exit(j.waitForCompletion(true) ? 0 : 1);
    }
}

