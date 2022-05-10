package Functions;


import org.apache.hadoop.hive.ql.udf.UDFSubstr;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Upper extends UDFSubstr {

    public Text evaluate(Text word, IntWritable index){

        String res="";
        String wordStr = word.toString();
        if(word!=null) {
            String st = String.valueOf(wordStr.charAt(0)).toUpperCase();
            res = st.concat(wordStr.substring(1));
            //res = word.toUpperCase();
        }else{
            return new Text(wordStr);
        }
        return new Text(res);
    }

}
