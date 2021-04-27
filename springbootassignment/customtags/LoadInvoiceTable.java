package com.utils.customtags;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class LoadInvoiceTable extends TagSupport {

	@SuppressWarnings("unchecked")
	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			//if (session.getAttribute("invno") != null) {
				ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>)request.getAttribute("InvoiceData");

				out.println("<table class=\"table table-striped\">");
				out.println("  <thead>");
				out.println("    <tr>");
				out.println("       <th scope=\"col\">#</th>");
				out.println("      <th scope=\"col\">Item Number</th>");
				out.println("      <th scope=\"col\">Item Description</th>");
				out.println("      <th scope=\"col\">Item Units</th>");
				out.println("      <th scope=\"col\">Item Price</th>");
				out.println("      <th scope=\"col\">Item Quantity</th>");
				out.println("      <th scope=\"col\">Amount</th>");
				out.println("    </tr>");
				out.println("  </thead>");
				out.println("  <tbody>");
				ArrayList<String> a = data.remove((data.size() - 1));
				int h[] = new int[a.size()];
				for (int i = 0; i < a.size(); i++) {
					h[i] = Integer.parseInt(a.get(i));
				}
				for (int i = 5; i < h[h.length - 1]; i++) {
					out.println("    <tr>");
					out.println("      <th scope=\"row\">" + (i - 4) + "</th>");
					out.println("      <td>" + data.get(i).get(0) + "</td>");
					out.println("      <td>" + data.get(i).get(1) + "</td>");
					out.println("      <td>" + data.get(i).get(2) + "</td>");
					out.println("      <td>" + data.get(i).get(3) + "</td>");
					out.println("      <td>" + data.get(i).get(4) + "</td>");
					out.println("      <td>" + data.get(i).get(5) + "</td>");
					out.println("    </tr>");
				}
				out.println("    <tr>");
				out.println("      <th scope=\"row\">" + " " + "</th>");
				out.println("      <td>" + " " + "</td>");
				out.println("      <td>" + " " + "</td>");
				out.println("      <td>" + " " + "</td>");
				out.println("      <td>" + " " + "</td>");
				out.println("      <td><strong>" + "Total " + "</strong></td>");
				out.println("      <td><strong>" + data.get(data.size() - 1).get(0) + "</strong></td>");
				out.println("    </tr>");
				out.println("  </tbody>");
				out.println("</table>");
				session.setAttribute("total", data.get(data.size() - 1).get(0));
			//}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
