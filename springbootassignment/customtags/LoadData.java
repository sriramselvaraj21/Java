package com.utils.customtags;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.model.ItemDetailsMasterDto;


@SuppressWarnings("serial")
public class LoadData extends TagSupport {
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int doEndTag() throws JspException { 
				JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			@SuppressWarnings("unchecked")
			ArrayList<ItemDetailsMasterDto> data = (ArrayList<ItemDetailsMasterDto>)request.getAttribute("shopdata");
			for (int i = 0; i <= data.size()+1; i += 2) {
				if(i<data.size()) {
				String outofstock = "";
				if(data.get(i).getItemunits() <= 0) {
					outofstock  = " (OUT OF STOCK)";
				}

				out.println("		<div class=\"row gx-5\">");
				out.println("			<div class=\"col-6\">");
				out.println("				<div class=\"p-5\">");
				out.println("					<div class=\"card\" style=\"width: 20rem;\">");
				out.println("						<img");
				out.println("							src=\"" + data.get(i).getImageurl() + " \" ");
				out.println("							class=\"card-img-top\" alt=\"...\">");
				out.println("						<div class=\"card-body\">");
				out.println("							<h5 class=\"card-title\">" + data.get(i).getItemdescription() +""+outofstock + "</h5>");
				out.println("							<p class=\"card-text\">Units :" + data.get(i).getItemunits()
						+ "\nPrice : " + data.get(i).getItemprice() + "</p>");
				out.println("                           <label for=\"" + data.get(i).getItemno()
						+ "\" class=\"form-label\">Select Quantity</label>");
				out.println(
						"							<input type=\"range\" onchange=\"document.getElementById('basic-addon"
								+ Integer.toString(i)
								+ "').innerHTML=this.value; \" class=\"form-range\" min=\"0\" max=\""+ data.get(i).getItemunits() + "\" step=\"1\" value=\"0\" name=\""
								+ data.get(i).getItemno() + "\"> ");
				out.println(" Selected Quantity : <span class=\"input-group-text\" id=\"basic-addon"
						+ Integer.toString(i) + "\">0</span>");
				out.println("						</div>");
				out.println("					</div>");
				out.println("				</div>");
				out.println("</div>");
				if((i+1)<data.size()) {
					String outofstock1 = "";
					if(data.get(i+1).getItemunits() <= 0) {
						outofstock1  = " (OUT OF STOCK)";
					}
				out.println("			<div class=\"col-6\">");
				out.println("				<div class=\"p-5\">");
				out.println("					<div class=\"card\" style=\"width: 20rem;\">");
				out.println("						<img");
				out.println("							src=\"" + data.get(i + 1).getImageurl() + " \" ");
				out.println("							class=\"card-img-top\" alt=\"...\">");
				out.println("						<div class=\"card-body\">");
				out.println(
						"							<h5 class=\"card-title\">" + data.get(i + 1).getItemdescription() +""+ outofstock1 +"</h5>");
				out.println("							<p class=\"card-text\">Units :" + data.get(i + 1).getItemunits()
						+ "\nPrice : " + data.get(i + 1).getItemprice() + "</p>");
				out.println("                           <label for=\"" + data.get(i + 1).getItemno()
						+ "\" class=\"form-label\">Select Quantity</label>");
				out.println(
						"							<input type=\"range\" onchange=\"document.getElementById('basic-addon"
								+ Integer.toString(i + 1)
								+ "').innerHTML=this.value; \" class=\"form-range\" min=\"0\" max=\""+ data.get(i+1).getItemunits()+ "\" value=\"0\" step=\"1\" name=\""
								+ data.get(i + 1).getItemno() + "\"> ");
				out.println("Selected Quantity :  <span class=\"input-group-text\" id=\"basic-addon"
						+ Integer.toString(i + 1) + "\">0</span>");
				out.println("						</div>");
				out.println("					</div>");
				out.println("				</div>");
				out.println("			</div>");
				}
				out.println("		</div>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
