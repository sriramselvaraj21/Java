package sms_and_email;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import excel_and_pdf.Invoice;

public class SendMessage implements Sender, Cloneable {
	public static SendMessage object = null;

	public SendMessage() {
	}

	public static SendMessage createObject() {
		if (object == null) {
			object = new SendMessage();
		}
		return object;
	}

	public SendMessage getClonedObject() throws Exception {
		return (SendMessage) super.clone();
	}

	@Override
	public void doSend(String filePath) {

		try {

			SAXBuilder builder = new SAXBuilder();
			Document jdomDoc;

			jdomDoc = (Document) builder.build(filePath);
			Element root = jdomDoc.getRootElement();
			List<Element> listOfInvoices = root.getChildren("invoice");
			List<Invoice> invoiceList = new ArrayList<>();

			for (Element element : listOfInvoices) {
				Invoice invoice = new Invoice();
				invoice.setId(Integer.parseInt((element.getAttributeValue("id"))));
				invoice.setInvdate(element.getChildText("invdate"));
				invoice.setCustomername(element.getChildText("customername"));
				invoice.setCustomernumber(element.getChildText("customernumber"));
				invoice.setAmount(element.getChildText("amount"));
				invoiceList.add(invoice);
			}
			String customerName = null;
			String totalAmount = null;
			String billdate = null;
			for (Invoice il : invoiceList) {
				customerName = il.getCustomername();
				totalAmount = il.getAmount();
				billdate = il.getInvdate();

				String customMessage = "Hi..." + customerName + "!, your total bill amount is : " + totalAmount
						+ ", purchased on : " + billdate + " \n Thankyou so much!!!";

				// System.out.println(customMessage);

				String apiKey = "apikey=" + "";// API key
				String message = "&message=" + customMessage;
				String sender = "&sender=" + "TXTLCL";
				String numbers = "&numbers=" + ""; // mobile number

				// Send data
				HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?")
						.openConnection();
				String data = apiKey + numbers + message + sender;
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
				conn.getOutputStream().write(data.getBytes("UTF-8"));
				final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				final StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = rd.readLine()) != null) {
					stringBuffer.append(line);
				}
				rd.close();

				System.out.println(stringBuffer.toString());

			}
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
		} finally {
			System.out.println("message sent");
		}

	}
}
