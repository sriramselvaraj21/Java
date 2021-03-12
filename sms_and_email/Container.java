package sms_and_email;

public class Container {

	// Email
	public static SendEmail getSendEmail() throws Exception {
		SendEmail obj;
		obj = SendEmail.createObject().getClonedObject();
		return obj;
	}

	// Message
	public static SendMessage getSendMessage() throws Exception {
		SendMessage obj;
		obj = SendMessage.createObject().getClonedObject();
		return obj;
	}
}
