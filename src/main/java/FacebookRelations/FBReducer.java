package FacebookRelations;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class FBReducer extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text k, Iterable<Text> vlist, Context con) throws IOException, InterruptedException {

        //Ravi   <Rani,vani,Veni,Giri>

        StringBuilder flist = new StringBuilder();

        int cnt = 0;

        for (Text v : vlist) {

            flist.append(" ,").append(v.toString());

            cnt++;

        }

        //flist---> ,Rani,Vani,Veni,Giri

        flist = new StringBuilder(flist.substring(2));

        String res = flist + "\t" + cnt;

        con.write(k, new Text(res));

    }

}
