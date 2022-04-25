package Exercise1

trait SendAction {
  def isSent(x: Boolean): String

}

case class Email(sender: String, title: String, body: String) extends SendAction {
  override def isSent(x: Boolean): String =
    if (x) {
      "Email sent by" + sender
    } else {
      "Could not send Email by" + sender + ". Try again"
    }
}

case class SMS(sender: String, message: String) extends SendAction {
  override def isSent(x: Boolean): String =
    if (x) {
      sender + " has sent a SMS"
    } else {
      "Could not sent the SMS. Try again"
    }
}

case class VoiceRecording(sender: String, contactName: String, link: String) extends SendAction {
  override def isSent(x: Boolean): String =
    if (x) {
      sender + " has sent a voice recording to" + contactName
    } else {
      "Unable to listen."
    }
}
