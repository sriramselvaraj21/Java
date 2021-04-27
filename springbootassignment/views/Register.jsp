<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register Page</title>
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
	<style type="text/css">
				@import url("//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
.login-block{
    background: black;  /* fallback for old browsers */
background: -webkit-linear-gradient(to bottom, #c3d4db, #dce3e6);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right,  #c3d4db, #dce3e6); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
float:left;
width:100%;
padding : 50px 0;
}
.banner-sec{background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}
.container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
.login-sec{padding: 50px 30px; position:relative;}
.login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
.login-sec .copy-text i{color:#FEB58A;}
.login-sec .copy-text a{color:#E36262;}
.login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #DE6262;}
.login-sec h2:after{content:" "; width:100px; height:5px; background:#FEB58A; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
.btn-login{background: #DE6262; color:#fff; font-weight:600;}
.banner-text{width:70%; position:absolute; bottom:40px; padding-left:20px;}
.banner-text h2{color:#fff; font-weight:600;}
.banner-text h2:after{content:" "; width:100px; height:5px; background:#FFF; display:block; margin-top:20px; border-radius:3px;}
.banner-text p{color:#fff;}
	</style>
</head>
<body>

<section class="login-block">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec">
		    <h2 class="text-center">Register</h2>
		    <form class="login-form" action="../register/adduser" method="post">
  				<div class="form-group">
   	 				<label for="exampleInputEmail1" class="text-uppercase">Username</label>
    				<input type="text" class="form-control" placeholder="" name="uname">
   				</div>
  				<div class="form-group">
    				<label for="exampleInputPassword1" class="text-uppercase">Password</label>
    				<input type="password" class="form-control" placeholder=""  name="upass">
  				</div>
      			<div class="form-group">
				<label for="inputAddress" class="form-label">Address</label> 
				<input
					type="text" class="form-control" id="inputAddress"
					placeholder="1234 Main St" name="address">
			</div>
			<div class="form-group">
				<label for="inputAddress2" class="form-label">Phone Number</label> 
				<input
					type="text" class="form-control" id="inputAddress2"
					placeholder="Please enter phone number...." name="phone">
			</div>
			<div class="form-group" >
				<label for="inputCity" class="form-label">Email</label> 
				<input
					type="email" class="form-control" id="inputCity" name="email">
			</div>
				<div>
    				<button type="submit" class="btn btn-login float-right">Submit</button>
  				</div>
			</form>
		</div>
			<div class="col-md-8 banner-sec">
           		 <img class="d-block img-fluid" src="https://images.unsplash.com/photo-1541596993953-970dd2ffdbdb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1049&q=80" >
            </div>	   
		    
	</div>
	</div>
</section>
</body>
</html>