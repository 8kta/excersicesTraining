package HW2Exercise1


// Write a Scala program to iterate over a list to print the elements and calculate the sum
// and product of all elements of this list


class RequestedFunctions {
  def sumAll(lst: List[Any]): Int =
    var sum = 0
    lst.foreach(sum+=_)
    sum

  def prodAll(lst: List[Any]): Int =
    var prod = 1
    lst.foreach(prod*=_)
    prod


}
