package sms_and_email;

public class Handler {
	public static void main(String[] args) throws Exception {

		String pdfFilePath = "C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\sax_output.pdf";
		String xmlFilePath = "C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\src\\sms_and_email\\invoice.xml";
		// Sending Email
		Sender sendemail = Container.getSendEmail();
		sendemail.doSend(pdfFilePath);

		// Sending Message
		Sender sendmessage = Container.getSendMessage();
		sendmessage.doSend(xmlFilePath);
	}
}
