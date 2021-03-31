<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@page import="model.InvoiceAction"%>
<%@page import="model.InvoiceDTO"%>
<%
	int totalAmount = 0; 
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>invoice</title>
	</head>
	<style>
		body {
			text-align: center;
		}
	</style>
	<body>
		<form action="http://localhost:8080/eyshoppingapp/ActionServlet"
			method="POST">
			<input type="hidden" name="formname" value="signout" />
	
			<button type="submit">SIGN OUT</button>
		</form>
		<%
			String s[] = request.getParameterValues("groceryid");
			if (s != null && s.length != 0) {
				for (int i = 0; i < s.length; i++) {
					session.setAttribute("grocery"+i, (String)s[i]);
				}
			}
			System.out.println("Invoice called");
		%>
		<br>
		<br>
		<br>
		<h1>Invoice new</h1>
		<h2 align="left"> Customer Name : <%=session.getAttribute("username")%></h2>
		<table border="1">
			<tr>
				<td>Item Number</td>
				<td>Item Name</td>
				<td>Item Brand</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>image</td>
			</tr>
			<%
				InvoiceAction ia = new InvoiceAction();
				ArrayList<InvoiceDTO> ivdto = ia.getInvoice(request, response);
				int i = ia.getInvoice(request, response).size();
				for(int k=0;k<i;k++){
					totalAmount += ivdto.get(k).getPrice(); 
			%>
				<tr>
					<td><%=ivdto.get(k).getItemId() %></td>		
					<td><%=ivdto.get(k).getItemName() %></td>
					<td><%=ivdto.get(k).getItemBrand() %></td>
					<td><%=ivdto.get(k).getPrice() %></td>
					<td><%=ivdto.get(k).getQuantity() %></td>
					<td><img alt="asd" src="<%=ivdto.get(k).getItemImage()%>" width="50" height="60"></td>
				</tr>
			<%
				System.out.println(totalAmount);
				session.setAttribute("grandTotal", totalAmount);	
				System.out.println("session grand total"+session.getAttribute("grandTotal"));

				}
			%>
		</table>
		<form action="http://localhost:8080/eyshoppingapp/ActionServlet"
			method="POST">
			<input type="hidden" name="formname" value="sendSMS" />
			<button type="submit">SendSMS</button>
		</form>
		<br>

		<form action="http://localhost:8080/eyshoppingapp/ActionServlet"
			method="POST">
			<input type="hidden" name="formname" value="sendMAIL" />
			<button type="submit">SendEmail</button>
		</form>
		<br>

		<form action="http://localhost:8080/eyshoppingapp/ActionServlet"
			method="POST">
			<input type="hidden" name="formname" value="generatePDF" />
			<button type="submit">GeneratePDF!</button>
		</form>
		
	</body>
</html>