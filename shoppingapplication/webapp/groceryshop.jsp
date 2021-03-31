<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.GroceryShopDAOImpl"%>
<%@page import="model.GroceryShopDTO"%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Grocery shop</title>
	</head>
	<style>
		body {
			text-align: center;
		}
	</style>
	<body>
		<form action="</ActionServletURL/>"
			method="POST">
			<input type="hidden" name="formname" value="signout" />
	
	
			<button type="submit">SIGN OUT</button>
		</form>
		<br>
		<br>
		<br>
		<br>
		<%
			String s[] = request.getParameterValues("fruitid");
			if (s != null && s.length != 0) {
				for (int i = 0; i < s.length; i++) {
					session.setAttribute("fruit"+i, (String)s[i]);
					System.out.println(s[i] + "\n");
				}
			}
		%>
		<form action="</ActionServletURL/>"
		method="POST">
			<input type="hidden" name="formname" value="groceryshop" />
			<%
				GroceryShopDAOImpl gsdl = new GroceryShopDAOImpl();
				GroceryShopDTO groceryShopDTO1 = gsdl.getGroceryShopDTO(0).get(0);
				GroceryShopDTO groceryShopDTO2 = gsdl.getGroceryShopDTO(0).get(1);
				GroceryShopDTO groceryShopDTO3 = gsdl.getGroceryShopDTO(0).get(2);		
			%>
			<table border="1">
				<tr>
					<td>checked</td>
					<td>Item Number</td>
					<td>Item Name</td>
					<td>Item Brand</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>image</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="groceryid" value="<%=groceryShopDTO1.getItemName() %>"></td>
					<td><%=groceryShopDTO1.getItemId()%></td>
					<td><%=groceryShopDTO1.getItemName()%></td>
					<td><%=groceryShopDTO1.getItemBrand() %></td>
					<td><%=groceryShopDTO1.getPrice() %></td>
					<td><%=groceryShopDTO1.getQuantity() %></td>
					<td><img alt="asd" src="<%=groceryShopDTO1.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="groceryid" value="<%=groceryShopDTO2.getItemName() %>"></td>
					<td><%=groceryShopDTO2.getItemId()%></td>
					<td><%=groceryShopDTO2.getItemName()%></td>
					<td><%=groceryShopDTO2.getItemBrand() %></td>
					<td><%=groceryShopDTO2.getPrice() %></td>
					<td><%=groceryShopDTO2.getQuantity() %></td>
					<td><img alt="asd" src="<%=groceryShopDTO2.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="groceryid" value="<%=groceryShopDTO3.getItemName() %>"></td>
					<td><%=groceryShopDTO3.getItemId()%></td>
					<td><%=groceryShopDTO3.getItemName()%></td>
					<td><%=groceryShopDTO3.getItemBrand() %></td>
					<td><%=groceryShopDTO3.getPrice() %></td>
					<td><%=groceryShopDTO3.getQuantity() %></td>
					<td><img alt="asd" src="<%=groceryShopDTO3.getItemImage()%>" width="50" height="60"></td>
				</tr>		
			</table>
		<button type="submit">continue Shopping....</button>
	</form>
	
</body>
</html>
