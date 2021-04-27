	package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.InvoiceService;
import com.service.RegisterService;
import com.utils.ExcelWriter.ExcelWriter;
import com.utils.email.SendEmail;
import com.utils.pdfutil.PdfWriterNew;
//import com.utils.sms.SendSms;


@Controller
@RequestMapping("generate")
public class InvoiceActionController {
	
	@Autowired
	private InvoiceService ig;
	@Autowired
	private RegisterService rs;
	
	public synchronized final InvoiceService getIg() {
		return ig;
	}

	public synchronized final void setIg(InvoiceService ig) {
		this.ig = ig;
	}

	@RequestMapping(value="/getinvoice",method=RequestMethod.POST)
	public ModelAndView getInvoice(HttpServletRequest request,ModelAndView mandv) {
		try {
			String sms=request.getParameter("sms");
			String email=request.getParameter("email");
			String pdf=request.getParameter("pdf");
			String excel=request.getParameter("excel");
			HttpSession session=request.getSession();
			int invno=Integer.parseInt((String)session.getAttribute("invno"));
			
			ArrayList<ArrayList<String>> finalData=ig.getInvoice(invno);
			
			 
			if(pdf!=null) {
				
				PdfWriterNew createpdf=new PdfWriterNew();
				createpdf.convert(finalData, "invoice"+Integer.toString(invno)+"PDF");
			}
			if(excel!=null) {
				ExcelWriter ew= new ExcelWriter();
				ew.convert(finalData,"invoice"+Integer.toString(invno)+"Excel");
			}
			if(email!=null) {
				int customerid=(Integer)session.getAttribute("id");
				String customeremail=rs.getEmail(customerid);
				String Custemail = (String)session.getAttribute("email");
				SendEmail.send(Custemail,String.valueOf(finalData));
			}if(sms!=null) {
//				int customerid=(Integer)session.getAttribute("id");

			}
			mandv.addObject("InvoiceData",ig.getInvoice(invno));
			mandv.setViewName("InvoiceTable");
		}catch(Exception e) {
			e.printStackTrace();
		}

		return mandv;
	}
}
