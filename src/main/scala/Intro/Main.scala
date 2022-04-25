package Intro

import scala.util.control.Breaks

object MainObject {
  def main(args: Array[String]): Unit =
    val saludo = new Salute()
    saludo.sayHi("Alonso")

    val loop = new Breaks;

    loop.breakable {
      for (a <- 1 to 5) {
        println("Value of a: " + a);

        if (a == 4) {
          loop.break;
        }
      }
    }
    println("Out of loop")
}
