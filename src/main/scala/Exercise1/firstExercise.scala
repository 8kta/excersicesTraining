package Exercise1

object firstExercise extends App {

  // Example of matching pattern
  def showIfSent(sentAction: SendAction, state: Boolean): String = {
    sentAction match {
      case e: Email => e.isSent(state)
      case sms: SMS => sms.isSent(state)
      case v: VoiceRecording => v.isSent(state)
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "Mom", "voicerecording.org/id/123")
  val someEmail = Email("sender@mail.com", "TitleEx", "The body is here")

  println(showIfSent(someSms, true))
  println(showIfSent(someVoiceRecording, false))
  println(showIfSent(someEmail, true))
  println(showIfSent(someEmail, false))
}
