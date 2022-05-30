package SparkRDDJ;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class Functions {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf()
                .setAppName("javaApp")
                .setMaster("local");
        JavaSparkContext scjava = new JavaSparkContext(sparkConf);

        JavaRDD<String> pathRDD = scjava.textFile("/Users/Octavalo/Documents/sparkFiles/hello.txt");

        //You can pass funtions
        JavaRDD<Integer> mapWithFunc = pathRDD.map(new Function<String, Integer>() {
            public Integer call(String s) {
                return s.length();
            }
        });

        int mapWithFunc2 = mapWithFunc.reduce(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer a, Integer b) {
                return a + b;
            }
        });


        JavaRDD<Integer> mapWithClassLenght = pathRDD.map(new GetLenght());
        int mapWithClassSum = mapWithClassLenght.reduce(new Sum());

        System.out.println(mapWithFunc.collect());
        System.out.println(mapWithFunc2);
        System.out.println(mapWithClassLenght.collect());
        System.out.println(mapWithClassSum);


    }

}
