package HW2Exercise2

import scala.util.Random

object Exercise2 extends App {
  val listRandom = Seq.fill(10)(Random.nextInt(100))
  println(listRandom)

  print("Min is: ")
  println(listRandom.min)
  print("Max is: ")
  println(listRandom.max)

}
