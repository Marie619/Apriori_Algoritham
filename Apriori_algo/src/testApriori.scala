


import scala.io.Source
import Array._
import sun.security.util.Length

object testApriori {
  def main(args: Array[String]) {
    println("Hello World")
    var RawTriplets = Source.fromFile("D:\\MSCS data\\Machine Learning\\Apriori_algoritham\\src\\data.txt").getLines.toList // Get file from directory and store in String List
    println(RawTriplets)
    println(RawTriplets.distinct.length)
    var support = RawTriplets(0)
    println(support)
    var confidence = RawTriplets(1)
    println(confidence)
    var Triplets: List[(String, String, String)] = List()
    for (i <- 2 to RawTriplets.length - 1) // Convert Raw Strings to Triplets
    {
      var temp = RawTriplets(i).split(",").toList
      var triplet = (temp(0).trim(), temp(1).trim(), temp(2).trim())
      Triplets = triplet :: Triplets
    }
    var count = Triplets.map(x => List(x._1, x._2, x._3)).flatten.groupBy(identity).map(x => (x._1, x._2.size)).toList
    count.foreach(println)


  }
}


