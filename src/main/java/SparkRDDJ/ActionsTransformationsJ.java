package SparkRDDJ;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class ActionsTransformationsJ {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf()
                .setAppName("javaApp")
                .setMaster("local");
        JavaSparkContext scjava = new JavaSparkContext(sparkConf);

        // You can read and parallelize data in RDD
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        JavaRDD<Integer> distData = scjava.parallelize(data);

        // You can read files from a path
        JavaRDD<String> pathRDD = scjava.textFile("/Users/Octavalo/Documents/sparkFiles/hello.txt");

        // we can do some operations (transformations in RDD) like
        JavaRDD<Integer> mapRDD = pathRDD.map(str -> str.length());
        Integer totalLenght = mapRDD.reduce((a, b) -> a + b);

        // and see our results
        System.out.println(mapRDD.collect());
        System.out.println(totalLenght);

        // if we want to use some variable later you can persist de info. Memory levels:
        // -- MEMORY_ONLY()
        // -- MEMORY_AND_DISK
        // -- MEMORY_AND_DISK_SER()
        // -- MEMORY_ONLY_SER()
        // -- DISK_ONLY()
        // -- MEMORY_ONLY_2(), MEMORY_AND_DISK_2()
        //mapRDD.persist(StorageLevel.MEMORY_ONLY())
        

        
    }

}
