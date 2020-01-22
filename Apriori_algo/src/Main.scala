import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.reflect.io.File


object Main {


  def main(args: Array[String]): Unit = {


    //    val readme: Iterator[String] = Source.fromResource("data_sample").getLines()
    //
    //   val path = getClass.getResource("/data_sample.txt")
    //
    //   println(Source.fromURL(getClass.getResource("data_sample.txt")))

    var path = Source.fromFile("D:\\MSCS data\\Machine Learning\\Apriori_Algoritham\\Apriori_algo\\src\\data.txt")

    //display the file content
    //    for (line <- path.getLines())
    //      {
    //        println(line)
    //      }

    var list = path.getLines().toList
    // println(list)

    //To check how many members have unique value in the list
    //println(list.distinct.length)


    //Dispaly the whole list
    //        for( lines <- list){
    //
    //          println(lines)
    //        }

    var support = list(0).toInt
    var confidence = list(1)

    //This gives the whole collection in a single list
    // list=list.takeRight(list.length-2)

    var trio: List[(String, String, String)] = List()


    for (i <- 2 to list.length - 1) // Convert Raw Strings to Triplets
    {
      var temp = list(i).split(",").toList
      var triplet = (temp(0).trim(), temp(1).trim(), temp(2).trim())
      trio = triplet :: trio
    }

    //Before frequent itesmset

    println("The list of the transactions")
    println(list.takeRight(list.length-2))

    //Afer one frequent itemset
    println("Min support for transaction : "+support)
    println("After applying First Frequent itemset we get")
    var count = trio.map(x => List(x._1, x._2, x._3)).flatten.groupBy(identity).map(x => (x._1, x._2.size))
      .filter(_._2 >= support).keySet.toList.sorted
    count.foreach(println)

    //After frequent itemset


    //    var transaction1 = list(2)
    //    var transaction2 = list(3)
    //    var transaction3 = list(4)
    //
    //
    //
    //    var transactions  = new ListBuffer[String]()
    //
    //    transactions += transaction1
    //    transactions += transaction2
    //    transactions += transaction3

    //  println(transactions)


    //    for (i <-0 to frequent.length-1){
    //
    //        if(frequent(i)< support)
    //    }


  }


}
