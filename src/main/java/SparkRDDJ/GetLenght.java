package SparkRDDJ;


import org.apache.spark.api.java.function.Function;

public class GetLenght implements Function<String, Integer> {

    public Integer call(String s) {
        return s.length();
    }
}
