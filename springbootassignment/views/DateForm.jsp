<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Invoice</title>
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
<div class="container" >
				<figure class="text-center" style="padding:3% 3% 1% 3%;">
			<blockquote class="blockquote">
				<h3><kbd>Search Invoice</kbd></h3>
			</blockquote>
		</figure>
		<form class="row g-3" action="/manager/invoicebydate"
		method="post">
		<div style="padding:0% 1% 1% 25%">
			<div class="col-md-9" >
				<label for="inputEmail4" class="form-label">Invoice Start Date</label> 
				<input
					type="date" class="form-control" id="inputEmail4" name="sdate">
			</div>
			<div class="col-md-9">
				<label for="inputPassword4" class="form-label">Invoice End Date</label> 
				<input
					type="date" class="form-control" id="inputPassword4" name="edate">
			</div>

			</div>
					<div class="d-grid gap-2 col-3 mx-auto">
				<button class="btn btn-primary" type="submit" name="search">Search Invoice</button>
			</div>
		</form>
	</div>
</body>
</html>