package Functions;

import org.apache.hadoop.hive.ql.udf.UDFSubstr;
import org.apache.hadoop.io.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindStrOccurance extends UDFSubstr {
    //hello  how are  you hello  , hello => 2
    public Integer evaluate(Text word, int search_word){

        if(word == null || search_word == null) {
            return null;
        }

        int count = 0;

        Pattern pattern = Pattern.compile(search_word);
        Matcher matcher = pattern.matcher( word );

        while (matcher.find()){
            count += 1;
        }

        return count;
    }
}
