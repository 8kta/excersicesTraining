package Exercise2

class ReverseWord {
  def reverse(word: String): IndexedSeq[Char] = for (i <- 1 to word.length) yield word.charAt(word.length - i)

}

object ReverseWord {
  def getReversedWord(word: String): String = {
    val reverseClass = new ReverseWord
    reverseClass.reverse(word).mkString
  }
}
