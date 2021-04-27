<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=RocknRoll+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Italianno&family=Sansita+Swashed:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<style>
		.user_card {
			height: 500px;
			width: 450px;
			opacity: 0.8;
			margin-top: 100px;
			margin-bottom: auto;
			margin-left: 450px;
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding: 10px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			border-radius: 5px;

		}
		.background {
			background: url('https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=931&q=80');
			image-rendering: auto;
  			image-rendering: crisp-edges;
  			image-rendering: pixelated;
			height: 100vh;
			width: 100vw;
  			-webkit-background-size: cover;
  			-moz-background-size: cover;
  			-o-background-size: cover;
		  	background-size: 100% 100%;
		  	display: flex;
  			align-items: center;
  			justify-content: center;
  			
		}
		.text-center {
			font-weight: bold;
  			color: #000000;
  			padding-top: 10px;
  			text-align: center;
		}
		.form-select select {
  			font-size: 1.5em;
  			padding: 2em 0.25em;
  			background-color: #ebeef0;
  			border: 1px solid black;
  			outline: none;
  			border-radius: 5px;
  			color: #fff;
  			font-weight: bold;
  			
		}
		.form-select {
			margin: 30px 90px;
		}
		.brand_logo_container {
			position: absolute;
			height: 170px;
			width: 170px;
			top: -75px;
			border-radius: 50%;
			background: ffff;
			padding: 10px;
			text-align: center;
		}
		.brand_logo {
			height: 150px;
			width: 150px;
			border-radius: 50%;
			border: 2px solid white;
		}
		.slogan {
			font-family: 'Courgette', cursive;
			padding: 3%;
			text-align: center;
		}
		.btn {
			margin-top: 5px;
			margin-left: 135px;
		}
		.heading {
			font-family: 'RocknRoll One', sans-serif;
			padding-top: 15px;
		}
	</style>
</head>
<body>
	<div class="background">
	<div class="user_card">
	<div class="container" style="padding: 8%;">
		<div class="d-flex justify-content-center">
		<div class="brand_logo_container">
			<img src="https://image.freepik.com/free-vector/supermarket-logo_23-2148490225.jpg" class="brand_logo" alt="Logo">
		</div>
		</div>
		<figure class="text-center">
			<blockquote class="blockquote">
				<h3 class="heading">Fresh Basket</h3>
			</blockquote>
		</figure>
		<div class="slogan">
			Only the fresh! Feed your family the best!
		</div>
		<div>
		<h6 class="text-center">
			Select your preferred language
		</h6>
		</div>
		<form action="../language/load" method="post">
				<select	name="language" class="form-select col-sm-6" aria-label="Default select example">
					<option value="en">English</option>
					<option value="ta">Tamil</option>
					<option value="te">Telugu</option>
					<option value="hi">Hindi</option>
				</select>
			<div style="padding: 2%;"></div>
			
			<button type="submit" class="btn btn-danger">Continue</button>
		</form>
	</div>
	</div>
	</div>
</body>
</html>