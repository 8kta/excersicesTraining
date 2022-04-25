package Exercise6

import scala.util.control.Breaks

object Exercise6 extends App {
  val loop = new Breaks

  loop.breakable {
    for (a <- 1 to 10) {
      println("Value of a: " + a)

      if (a == 4) {
        loop.break
      }
    }
  }
}
