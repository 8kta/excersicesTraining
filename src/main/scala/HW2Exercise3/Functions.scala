package HW2Exercise3

object Functions {

  def countOccurrences[A](list1: List[A]): Map[A, Int] =
    list1.groupBy(el => el).map(e => (e._1, e._2.length))


}
