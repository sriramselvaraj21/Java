package com.utils.customtags;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.model.InvoiceMasterDto;
import com.model.ItemDetailsMasterDto;

@SuppressWarnings("serial")
public class InvoiceResult extends TagSupport {

	@SuppressWarnings("unchecked")
	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			//if (session.getAttribute("invno") != null) {
				ArrayList<InvoiceMasterDto> data = (ArrayList<InvoiceMasterDto>) request.getAttribute("invoiceData");
	//			out.println("<form action=\"/SpringMvcShoppingPage/removeitems/remove\" method=\"post\">");
				out.println("<input type=\"hidden\"  name=\"formid\" value=\"Delete\">");
				out.println("<table class=\"table table-striped\">");
				out.println("  <thead>");
				out.println("    <tr>");
				out.println("       <th scope=\"col\">#</th>");
				out.println("      <th scope=\"col\">Invoice Number</th>");
				out.println("      <th scope=\"col\">Invoice Date</th>");
				out.println("      <th scope=\"col\">Customer Number</th>");
				out.println("    </tr>");
				out.println("  </thead>");
				out.println("  <tbody>");
				for (int i = 0; i < data.size(); i++) {
					out.println("    <tr>");
					out.println("      <th scope=\"row\">" + (i + 1) + "</th>");
					out.println("      <td>" + data.get(i).getInvno() + "</td>");
					out.println("      <td>" + data.get(i).getInvDate() + "</td>");
					out.println("      <td>" + data.get(i).getCustomerno() + "</td>");
//					out.println("      <td> <button type=\"submit\" class=\"btn-close\" aria-label=\"Close\" name=\""
//							+ (i + 1) + "\" ></button></td>");
					out.println("    </tr>");
				}
				out.println("  </tbody>");
	//			out.println("  </form>");
				out.println("</table>");
			//}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
