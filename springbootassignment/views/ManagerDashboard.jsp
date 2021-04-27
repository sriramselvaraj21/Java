<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Dashboard</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<style>
	.navbar-light .navbar-brand {
  color: #fff;
  font-size: 25px;
  text-transform: uppercase;
  font-weight: bold;
  letter-spacing: 2px;
}

.navbar-light .navbar-nav .active > .nav-link, .navbar-light .navbar-nav .nav-link.active, .navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show > .nav-link {
  color: #fff;
}

.navbar-light .navbar-nav .nav-link {
  color: #fff;
}

.navbar-toggler {
  background: #fff;
}

.navbar-nav {
  text-align: center;
}

.nav-link {
  padding: .2rem 1rem;
}

.nav-link.active,.nav-link:focus{
  color: #fff;
}

.navbar-toggler {
  padding: 1px 5px;
  font-size: 18px;
  line-height: 0.3;
}

.navbar-light .navbar-nav .nav-link:focus, .navbar-light .navbar-nav .nav-link:hover {
  color: #fff;
}

.outer {
	height: 50%;
	width: auto;
	background:#d1d1d1;
	padding-bottom: 2%;
}

.outer-2 {
	background: #f5f5f5;
	padding: 4%;
	height: 100%;
}

.card {
	background: #333030;
	margin-left: 50px;
}

.card-text, .card-title {
	color: white;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg fixed-top bg-dark navbar-dark">
	
  <div class="container">
    <a class="navbar-brand" href="#">Fresh Basket </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
		
		<li class="nav-item active">
          	<form action="../logout/" method="get">
  				<button class="nav-link btn btn-dark" type="submit" >Logout</button>
			</form>
        </li>
		
        
	</ul>
	</div>
</div>
</nav>
<div class="outer">
	<div class="container" style="padding-top: 120px;">
		<div style="padding: 1%">
			<figure class="text-center">
			<blockquote class="blockquote">
				<h3>
					Welcome to Manager Dashboard
				</h3>
			</blockquote>
		</figure>
		</div>
		<div align="center" style="padding: 1% 25%">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td align="center"><strong>Name</strong></td>
						<td align="center"><%=session.getAttribute("username")%></td>
					</tr>
					<tr>
						<td align="center"><strong>Manager Id</strong></td>
						<td align="center"><%=session.getAttribute("id")%></td>
					</tr>
					<tr>
						<td align="center"><strong>Date</strong></td>
						<td align="center"><%=LocalDate.now().toString()%></td>
					</tr>
				</tbody>
			</table>
		</div>
		</div>
	</div>
	
	<div class="outer-2">
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<form action="/manager/getAddAdmin" method="get">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Add Admin</h5>
							<p class="card-text">Add New Admin User Here!</p>
							<input class="btn btn-danger" type="submit" value="Add Admin"
								name="add">

						</div>
					</div>
				</div>
				</form>
				<form action="/manager/checkItem" method="post">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Inventory Report</h5>
							<p class="card-text">Check the stock of all items here!</p>
							<input class="btn btn-danger" type="submit" value="Check Item"
								name="modify">
						</div>
					</div>
				</div>
				</form>
				<form action="/manager/getItemID" method="post">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Inventory Report</h5>
							<p class="card-text">Search Item using Item ID!</p>
							<input class="btn btn-danger" type="submit" value="Generate" name="delete">
						</div>
					</div>
				</div>
				</form>
				<form action="/manager/getInvoiceDate" method="get">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Invoice Report</h5>
							<p class="card-text">Search Invoice by Date</p>
							<input class="btn btn-danger" type="submit" value="Generate" name="delete">
						</div>
					</div>
				</div>
			</form>
			<form action="/manager/getInvoiceCustId" method="post">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Invoice Report</h5>
							<p class="card-text">Search Invoice by Customer ID!</p>
							<input class="btn btn-danger" type="submit" value="Generate" name="delete">
						</div>
					</div>
				</div>
			</form>
			<form action="/manager/getInvoiceID" method="post">
				<div class="col-sm-9">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Invoice Report</h5>
							<p class="card-text">Search Invoice using Invoice ID!</p>
							<input class="btn btn-danger" type="submit" value="Generate" name="delete">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>