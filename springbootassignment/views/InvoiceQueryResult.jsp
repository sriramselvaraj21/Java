
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InvoiceQueryResult</title>
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
				<h3>
					<kbd>Invoices</kbd>
				</h3>
			</blockquote>
		</figure>


		<mytags:getinvoiceresult/>


		<form action="/manager/invoice"
			method="post">


			<div class="d-grid gap-2 col-6 mx-auto">
				<div class="col-md-12">
					<label for="inputEmail4" class="form-label">Please Enter The Invoice Number</label> 
					<input type="text" class="form-control" id="inputEmail4"
						name="invno">
				</div>
				<button class="btn btn-primary" type="submit">Show Invoice</button>
			</div>
		
		</form>
	</div>
</body>
</html>