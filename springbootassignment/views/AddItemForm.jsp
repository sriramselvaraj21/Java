<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Items</title>
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
</head>
<style>
	.user_card {
		margin-left: 30%;
			height: 550px;
			width: 650px;
			margin-top: 100px;
			margin-bottom: auto;
			 background-color: #ffffff;
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding-top: 5px;
			padding-bottom: 5px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			border-radius: 5px;
			
		}
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

.card {
	background: #333030;
	margin-left: 50px;
}

.card-text, .card-title {
	color: white;
}

.login-block{
    background: black;  /* fallback for old browsers */
background: -webkit-linear-gradient(to bottom, #d1cfcf, #f5f5f5);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right,  #d1cfcf, #f5f5f5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
float:left;
width:100%;
padding : 50px 0;
}

</style>
<body>
	<nav class="navbar navbar-expand-lg fixed-top bg-dark navbar-dark">
	
  <div class="container">
    <a class="navbar-brand" href="#">Tesla </a>
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
<section class="login-block">
<div class="user_card">
<div class="container" >
				<figure class="text-center" style="padding:3% 3% 1% 3%;">
			<blockquote class="blockquote">
				<h3 style="font-family: 'Rubik', sans-serif; font-weight: bold;">Item Inventory Management</h3>
			</blockquote>
		</figure>
		<form class="row g-3" action="../item/applychanges" method="post">
		<div style="padding:0% 1% 1% 25%">
			<div class="col-md-9" >
				<label for="inputEmail4" class="form-label">Item Name</label> 
				<input
					type="text" class="form-control" id="inputEmail4" name="itemname">
			</div>
			<div class="col-md-9">
				<label for="inputPassword4" class="form-label">Image Url</label> 
				<input
					type="text" class="form-control" id="inputPassword4" name="imageurl">
			</div>
			<div class="col-9">
				<label for="inputAddress" class="form-label">Item Units</label> 
				<input
					type="text" class="form-control" id="inputAddress" name="itemunits">
			</div>
			<div class="col-9">
				<label for="inputAddress2" class="form-label">Shop Name</label> 		
				<select class="form-select" id="inputAddress2" name="shopname">
					<!-- <option selected>Choose...</option> -->
					<option value="1">Fruits Shop </option>
					<option value="2">Vegetable Shop</option>
					<option value="3">Snacks Shop</option>
				</select>
			</div>
			<div class="col-md-9">
				<label for="inputCity" class="form-label">Price</label> 
				<input
					type="text" class="form-control" id="inputCity" name="itemprice">
			</div>
			</div>
			<div class="d-grid gap-2 col-6 mx-auto" style="padding-bottom: 3%;">
				<button class="btn btn-danger" type="submit" name="register">Apply Changes</button>
			</div>
		</form>
	</div>
</div>
</section>
</body>
</html>