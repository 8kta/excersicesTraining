package HW2Exercise1

object ObjectMain extends App {
  val functions = new RequestedFunctions()

  val lst = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)

  print("Sum is: ")
  println(functions.sumAll(lst))
  print("Prod is: s")
  println(functions.prodAll(lst))

  lst.foreach(println)
}
