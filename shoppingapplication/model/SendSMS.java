package shoppingapplication.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SendSMS extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Send SMS Action called");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try {
			HttpSession session = request.getSession();

			String customerName = null;
			//String totalAmount = null;
			String billdate = null;
			
			customerName = (String) session.getAttribute("username");
			//totalAmount = (String) session.getAttribute("grandTotal");
			billdate = (String) dtf.format(now);
			session.setAttribute("billdate", billdate);
			String customMessage = "Hi..." + customerName + "!, your total bill amount is : " + session.getAttribute("grandTotal")
					+ ", purchased on : " + billdate + " \n Thankyou so much!!!";

			System.out.println(customMessage);


		} catch (Exception e) {
			System.out.println("Error SMS " + e);
		} finally {
			System.out.println("message sent");
		}
		return "sendsms.success";
	}

}
