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

public class CurrencyMap extends Mapper<LongWritable, Text, LongWritable, Text> {
    ArrayList<String> stopWords = null;

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, LongWritable, Text>.Context context)
            throws IOException, InterruptedException {

        super.map(key, value, context);
    }


    public void setup(Context context) throws IOException,
            InterruptedException {
        stopWords = new ArrayList<String>();

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
                    String[] words = line.split(" ");

                    for (int i = 0; i < words.length; i++) {
                        // add the words to ArrayList
                        stopWords.add(words[i]);
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Unable to read the File");
                System.exit(1);
            }
        }
    }
}
