<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.FruitShopDAOImpl"%>
<%@page import="model.FruitShopDTO"%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>fruit shop</title>
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
			String s[] = request.getParameterValues("jwelleryid");
			if (s != null && s.length != 0) {
				for (int i = 0; i < s.length; i++) {
					session.setAttribute("jwellery"+i, (String)s[i]);
					System.out.println(s[i] + "\n");
				}
			}
			//System.out.print("data" + session.getAttribute("item0"));
			//System.out.print("data" + session.getAttribute("item1"));

		%>
		<form action="</ActionServletURL/>"
		method="POST">
			<input type="hidden" name="formname" value="fruitshop" />
			<%
				FruitShopDAOImpl fsdl = new FruitShopDAOImpl();
				FruitShopDTO fruitShopDTO1 = fsdl.getFruitShopDTO(0).get(0);
				FruitShopDTO fruitShopDTO2 = fsdl.getFruitShopDTO(0).get(1);
				FruitShopDTO fruitShopDTO3 = fsdl.getFruitShopDTO(0).get(2);		
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
					<td><input type="checkbox" name="fruitid" value="<%=fruitShopDTO1.getItemName() %>"></td>
					<td><%=fruitShopDTO1.getItemId()%></td>
					<td><%=fruitShopDTO1.getItemName()%></td>
					<td><%=fruitShopDTO1.getItemBrand() %></td>
					<td><%=fruitShopDTO1.getPrice() %></td>
					<td><%=fruitShopDTO1.getQuantity() %></td>
					<td><img alt="asd" src="<%=fruitShopDTO1.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="fruitid" value="<%=fruitShopDTO2.getItemName() %>"></td>
					<td><%=fruitShopDTO2.getItemId()%></td>
					<td><%=fruitShopDTO2.getItemName()%></td>
					<td><%=fruitShopDTO2.getItemBrand() %></td>
					<td><%=fruitShopDTO2.getPrice() %></td>
					<td><%=fruitShopDTO2.getQuantity() %></td>
					<td><img alt="asd" src="<%=fruitShopDTO2.getItemImage()%>" width="50" height="60"></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="fruitid" value="<%=fruitShopDTO3.getItemName() %>"></td>
					<td><%=fruitShopDTO3.getItemId()%></td>
					<td><%=fruitShopDTO3.getItemName()%></td>
					<td><%=fruitShopDTO3.getItemBrand() %></td>
					<td><%=fruitShopDTO3.getPrice() %></td>
					<td><%=fruitShopDTO3.getQuantity() %></td>
					<td><img alt="asd" src="<%=fruitShopDTO3.getItemImage()%>" width="50" height="60"></td>
				</tr>		
			</table>
		<button type="submit">continue Shopping....</button>
	</form>	
</body>
</html>
