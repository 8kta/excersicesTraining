package HW2Exercise4

object Numbers {
  def printNature(lst: Seq[Int]): Unit =
    lst.foreach{
      case x if x % 2 == 0 => println("Even")
      case x if x % 2 != 0 => println("Odd")
    }

}
