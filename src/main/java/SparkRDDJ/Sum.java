package SparkRDDJ;

import org.apache.spark.api.java.function.Function2;

class Sum implements Function2<Integer, Integer, Integer> {
    public Integer call(Integer a, Integer b) {
        return a + b;
    }
}
