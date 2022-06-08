package UseCase

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{col, explode}

class Operations {
  def blowUp(df: DataFrame, str : String, function: UserDefinedFunction) : DataFrame = {
    df.withColumn(str, function(col(str)))
      .withColumn(str, explode(col(str)))
  }


}