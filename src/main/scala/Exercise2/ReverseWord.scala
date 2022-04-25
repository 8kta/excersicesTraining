package Exercise2

class ReverseWord {
  def reverse(word: String): IndexedSeq[Char] = for (i <- 1 to word.length) yield word.charAt(word.length - i)

  def appendFromIndexed(vector: IndexedSeq[Char]): String = {
    var revString: String = ""
    for (i <- vector) {
      revString = revString + i
    }
    return revString
  }


}

object ReverseWord {
  def getReversedWord(word: String): String = {
    val reverseClass = new ReverseWord
    return reverseClass.reverse(word).mkString
  }
}
