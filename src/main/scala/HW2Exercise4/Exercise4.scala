package HW2Exercise4

import scala.util.Random

object Exercise4 extends App {
  val listRandom = Seq.fill(10)(Random.nextInt(100))
  println(listRandom)

  Numbers.printNature(listRandom)
}
