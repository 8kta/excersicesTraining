package MapSideJoinCurrency;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyMap extends Mapper<LongWritable, Text, LongWritable, Text> {
    Map<Integer, String> currency = null;

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line[] = value.toString().split(",");
        String transLine = line[1] + "," + line[2] + "," + line[3] + "," + currency.get(Integer.parseInt(line[4]));
        context.write(new LongWritable(Integer.parseInt(line[0])), new Text(transLine));
    }


    public void setup(Context context) throws IOException,
            InterruptedException {
        //stopWords = new Map<>();
        Map<Integer, String> currency = new HashMap<>();

        URI[] cacheFiles = context.getCacheFiles();

        if (cacheFiles != null && cacheFiles.length > 0) {
            try {

                String line = "";
                // Create a FileSystem object and pass the
                // configuration object in it. The FileSystem
                // is an abstract base class for a fairly generic
                // filesystem. All user code that may potentially
                // use the Hadoop Distributed File System should
                // be written to use a FileSystem object.
                FileSystem fs = FileSystem.get(context.getConfiguration());
                Path getFilePath = new Path(cacheFiles[0].toString());

                // We open the file using FileSystem object,
                // convert the input byte stream to character
                // streams using InputStreamReader and wrap it
                // in BufferedReader to make it more efficient
                BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(getFilePath)));


                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(",");

                    currency.put(Integer.parseInt(words[0]), words[1]);
                }
            } catch (Exception e) {
                System.out.println("Unable to read the File");
                System.exit(1);
            }
        }
    }
}
