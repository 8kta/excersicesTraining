package Exercise7

object TypeInference extends App {
  val list = List(1, "abc", 3.1415, List(1, 2), Vector(1, 2), "Hello", "Word")

  list.foreach {
    case s: String => println("This is a string")
    case i: Int => println("This is a integer")
    case f: Double => println("This is a double")
    case v: Vector[Int] => println("This is a Vector of integers")
    case _ => println("Another type.")
  }

}
