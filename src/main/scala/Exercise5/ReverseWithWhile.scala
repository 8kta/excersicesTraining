package Exercise5

class ReverseWithWhile(var num: Int) {
  def reverseWithWhile() : Int =
    var reversed = 0


  // run loop until num becomes 0
    while ( num != 0) {

    val digit = num % 10

    reversed = reversed * 10 + digit

    // remove the last digit from num
    num = num/10
  }
    reversed
}
