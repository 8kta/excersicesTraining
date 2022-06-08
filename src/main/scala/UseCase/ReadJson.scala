package UseCase


import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{col, explode, udf}

object ReadJson extends App {
  val conf: SparkConf = new SparkConf().setAppName("sparkbyexamples.com").setMaster("local[1]")
  val sc: SparkContext = new SparkContext(conf)
  val spark: SparkSession = SparkSession
    .builder()
    .appName("NewTry")
    .master("local")
    .getOrCreate()

  /*
  var rddJson: RDD[String] = sc.textFile("/home/alonso/IdeaProjects/test/src/main/resources/test.json")

  rddJson.flatMap(_.)*/


  val jsonDF: DataFrame = spark
    .read
    .option("multiline", "true")
    .json("/home/alonso/IdeaProjects/test/src/main/resources/test.json")

  val function: UserDefinedFunction = udf((str: String) => {
    str.split(", ")
  })


  jsonDF.withColumn("Interest", function(col("Interest")))
    .withColumn("Interest", explode(col("Interest")))
    .show(false)


  jsonDF.withColumn("Interest", function(col("Interest")))
    .withColumn("Interest", explode(col("Interest")))
    .groupBy("Interest", "ZIP")
    .count()
    .alias("Count")
    .show(false)

}

