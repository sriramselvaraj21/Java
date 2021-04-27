package com.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.PaytmDetailPojo;
import com.paytm.pg.merchant.PaytmChecksum;
import com.service.InvoiceServiceImpl;
import com.service.RegisterService;
import com.utils.email.SendEmail;
import com.utils.pdfutil.PdfWriterNew;
import com.utils.sms.SendSms;

@Controller
public class PaymentController {
	
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private Environment env;

	 @PostMapping(value = "/submitPaymentDetail")
	    public ModelAndView getRedirect(HttpServletRequest request) throws Exception {
		 	HttpSession session = request.getSession();
	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
//	        System.out.println(session.getAttribute("invno"));
	        parameters.put("ORDER_ID", String.valueOf(session.getAttribute("invno")));
	        parameters.put("TXN_AMOUNT", String.valueOf(session.getAttribute("total")));
	        parameters.put("CUST_ID", String.valueOf(session.getAttribute("username")));
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    }	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        String paytmChecksum = "";
	        for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
	            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
	                paytmChecksum = requestParamsEntry.getValue()[0];
	            } else {
	            	parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
	            }
	        }
	        String result="";

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        HttpSession session = request.getSession();
	        session.setAttribute("parameters", parameters);
	        model.addAttribute("parameters",parameters);
	        return "report";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,
	                paytmDetailPojo.getMerchantKey(), paytmChecksum);
	    }


	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetailPojo.getMerchantKey());
	}
	
	@Autowired
	private InvoiceServiceImpl ig;
	@Autowired
	private RegisterService rs;
	
	public synchronized final InvoiceServiceImpl getIg() {
		return ig;
	}

	public synchronized final void setIg(InvoiceServiceImpl ig) {
		this.ig = ig;
	}

	
	 @PostMapping(value = "/submitReceipt")
	public ModelAndView payment(ModelAndView mv,HttpServletRequest request) throws Exception{
			HttpSession session=request.getSession();
			int invno=Integer.parseInt(String.valueOf(session.getAttribute("invno")));
			System.out.println("Invo"+invno);
			PdfWriterNew createpdf=new PdfWriterNew();
			createpdf.convert(ig.getInvoice(invno), "invoice"+Integer.toString(invno)+"PDF");
			int customerid=(Integer)session.getAttribute("id");
			SendEmail.send(rs.getEmail(customerid), "C:\\eclipse\\eclipse-workspace"+"invoice"+Integer.toString(invno)+"PDF.pdf");
			session.setAttribute("email", rs.getEmail(customerid));
			SendSms.SendMessage(ig.getInvoice(invno));
			mv.addObject("InvoiceData",ig.getInvoice(invno));
			mv.setViewName("InvoiceTable");
			return mv;
	}
}