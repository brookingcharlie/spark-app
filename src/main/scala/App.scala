import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object App {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)

    val textFile = "file:///opt/spark/README.md"
    val textData = sc.textFile(textFile, 2).cache()
    val numAs = textData.filter(line => line.contains("a")).count()
    val numBs = textData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
