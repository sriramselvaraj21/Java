<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JewellerShopDAOImpl"%>
<%@page import="model.JewellerShopDTO"%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>jwellery shop</title>
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
		<form action="</ActionServletURL/>"
		method="POST">
			<input type="hidden" name="formname" value="jwelleryshop" />
			<%
				JewellerShopDAOImpl jsdi = new JewellerShopDAOImpl();
				JewellerShopDTO jewellerShopDTO1 = jsdi.getJewellerShopDTO(0).get(0);
				JewellerShopDTO jewellerShopDTO2 = jsdi.getJewellerShopDTO(0).get(1);
				JewellerShopDTO jewellerShopDTO3 = jsdi.getJewellerShopDTO(0).get(2);		
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
					<td><input type="checkbox" name="jwelleryid" value="<%=jewellerShopDTO1.getItemName() %>"></td>
					<td><%=jewellerShopDTO1.getItemId()%></td>
					<td><%=jewellerShopDTO1.getItemName()%></td>
					<td><%=jewellerShopDTO1.getItemBrand() %></td>
					<td><%=jewellerShopDTO1.getPrice() %></td>
					<td><%=jewellerShopDTO1.getQuantity() %></td>
					<td><img alt="asd" src="<%=jewellerShopDTO1.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="jwelleryid" value="<%=jewellerShopDTO2.getItemName() %>"></td>
					<td><%=jewellerShopDTO2.getItemId()%></td>
					<td><%=jewellerShopDTO2.getItemName()%></td>
					<td><%=jewellerShopDTO2.getItemBrand() %></td>
					<td><%=jewellerShopDTO2.getPrice() %></td>
					<td><%=jewellerShopDTO2.getQuantity() %></td>
					<td><img alt="asd" src="<%=jewellerShopDTO2.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="jwelleryid" value="<%=jewellerShopDTO3.getItemName() %>"></td>
					<td><%=jewellerShopDTO3.getItemId()%></td>
					<td><%=jewellerShopDTO3.getItemName()%></td>
					<td><%=jewellerShopDTO3.getItemBrand() %></td>
					<td><%=jewellerShopDTO3.getPrice() %></td>
					<td><%=jewellerShopDTO3.getQuantity() %></td>
					<td><img alt="asd" src="<%=jewellerShopDTO3.getItemImage()%>" width="50" height="60"></td>
				</tr>		
			</table>
		<button type="submit">continue Shopping....</button>
	</form>
	
</body>
</html>
