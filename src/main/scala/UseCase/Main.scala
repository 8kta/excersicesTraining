package UseCase

//import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{col, udf}

object Main extends App {

  val spark: SparkSession = SparkSession.builder()
    .appName("Exercise")
    .master("local[1]")
    .getOrCreate()

  val jsonDF: DataFrame = spark.read.option("multiline", "true").json(args(0))

  val function: UserDefinedFunction = udf((str: String) => {
    str.split(", ")
  })

  val operations = new Operations()

  val columna = args(2)
  val blowed : DataFrame = operations.blowUp(jsonDF, columna, function)

  def caseMatch(x : Int) : Unit = {
    x match {
      case 1 => blowed
        .filter(col("id").equalTo(args(3).toInt))
        .show(false)
      case 2 => blowed
        .groupBy(columna, args(4))
        .count()
        .alias("Count")
        .show(false)

    }
  }

  val req = args(1)
  caseMatch(req.toInt)
