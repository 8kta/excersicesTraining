package Exercise3

import scala.util.Random

object exercise3 extends App {
  val listRandom = Seq.fill(10)(Random.nextInt(100))
  println(listRandom)
  var sum = 0
  listRandom.foreach(sum+=_)
  println(sum)
}
