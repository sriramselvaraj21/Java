
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Summary</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
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

.container-fluid {
	background: #f2f2f2; 
}

.card-text p {
	font-family: 'Courgette', cursive;
}
.user_card {
			width: auto;
			margin-top: 100px;
			margin-bottom: auto;
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding: 50px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			border-radius: 5px;

		}
	.text-center h3 {
		font-family: 'Rubik', sans-serif;
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
    		<button class="nav-link btn btn-dark">Welcome <%=session.getAttribute("username")%></button>		
        </li>
		<li class="nav-item active">
          	<form action="../logout/" method="get">
  				<button class="nav-link btn btn-dark" type="submit" >Logout</button>
			</form>
        </li>
		<li class="nav-item active">
			<form action="../loadshop/shop1" method="get">
				<button class="nav-link btn btn-dark" type="submit">Shop</button>
			</form>
        </li>
        
	</ul>
	</div>
</div>
</nav>
<div class="user_card">
	<div class="container">
	<div style="padding:1%">
		<figure class="text-center">
			<blockquote class="blockquote">
				<h3>Export Options</h3>
			</blockquote>
		</figure>
		</div>
		<form action="../generate/getinvoice" method="post">
			<input type="hidden" name="formid" value="download">
			<div class="row row-cols-1 row-cols-md-2 g-4">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Print Invoice to PDF</h5>
							<p class="card-text">Generate Invoice as PDF File</p>
							<input class="btn btn-primary" type="submit" value="Generate PDF" name="pdf">
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Print Invoice to Excel</h5>
							<p class="card-text">Generate Invoice as an Excel File</p>
							<input class="btn btn-primary" type="submit"
								value="Generate Excel" name="excel">
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Send The Invoice as Email</h5>
							<p class="card-text">Generate Email of the invoice</p>
							<input class="btn btn-primary" type="submit" value="Send Email"
								name="email">
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Send The Invoice as SMS</h5>
							<p class="card-text">Generate invoice details as SMS</p>
							<input class="btn btn-primary" type="submit" value="Send SMS"
								name="sms">
						</div>
					</div>
				</div>
			</div>
		</form>
		<div style="padding:1%">
				<figure class="text-center">
			<blockquote class="blockquote">
				<h3><kbd>Invoice Receipt</kbd></h3>
			</blockquote>
		</figure>
		</div>
		<mytags:getinvoicetable />
	</div>
</div>
</body>
</html>