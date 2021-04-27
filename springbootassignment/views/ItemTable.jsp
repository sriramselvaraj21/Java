
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Table</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="Logout.jsp"></jsp:include>
	<div class="container">
		<figure class="text-center">
			<blockquote class="blockquote">
				<h3><kbd>Item Report</kbd></h3>
			</blockquote>
		</figure>

		
		<mytags:getitemtable  />
		
		
	<form action="/manager/getDash" method="get">
			

			<div class="d-grid gap-2 col-6 mx-auto">
				<button class="btn btn-primary" type="submit">Back to DashBoard</button>
			</div>
</form>
</div>
</body>
</html>