<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!--
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheets" id="bootstrap-css1">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
 -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--
 <script src="//code.jquery.com/jquery-1.11.1.min.js" class="__web-inspector-hide-shortcut__"></script> -->
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
@import
	url('https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css')
	;

html, body {
	display: flex;
	flex-direction: column;
	margin: 0px;
	padding: 0px;
	max-height: 100%;
	height: 100%;
}
/* .myspan {
    display: inline-block !important;
}
.button {
    display: inline-block !important;
} */
body {
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	/* 	background-image: url("images/loginbg.jpg"); */
	background-image: linear-gradient(to right, #ff8177 0%, #ff867a 0%, #ff8c7f 21%, #f99185
		52%, #cf556c 78%, #b12a5b 100%);
	padding-top: 8%;
	font: 16px Arial;
	background-repeat: no-repeat;
	background-size: 100%;
	background-position: center top;
}

#container {
	max-height: 100%;
	position: absolute;
}

section .section-title {
	text-align: center;
	color: #007b5e;
	text-transform: uppercase;
}

/* .panel-default {
	opacity: 0.9;
	margin-top: 30px;
} */
.form-group.last {
	margin-bottom: 0px;
}

/* .panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
	box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
} */
.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align: center;
}

.panel-heading a {
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-heading a.active {
	color: #029f5b;
	font-size: 18px;
}

.panel-heading hr {
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -ms-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
	background-image: -o-linear-gradient(left, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
}

.panel-body input[type="text"], .panel-body input[type="email"],
	.panel-body input[type="password"] {
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}

.panel-body input:hover, .panel-login input:focus {
	outline: none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}

.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	text-transform: uppercase;
	border-color: #59B2E6;
	overflow: hidden;
}

.btn-login:hover, .btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}

.forgot-password {
	text-decoration: underline;
	color: #888;
}

.forgot-password:hover, .forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn:hover {
	background-image: none !important;
	background-color: #ff00ff !important;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 10%;
	text-transform: uppercase;
	border-color: #1CB94A;
	overflow: hidden;
}

.btn-register:hover, .btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}

button:focus {
	background: olive;
}

#register-form-link {
	width: 50%;
}

#login-form-link {
	width: 50%;
}

button:active {
	background: red;
}

.navbar, .dropdown-menu {
	background: rgba(255, 255, 255, 0.25);
	border: none;
}
/* TOP HEADER
-------------------------------------------------- */
.navbar.top-bar {
	border-radius: 0;
	padding: 16px 0;
	z-index: 16;
	background-color: #CC3333;
}

.navbar-toggler {
	border: 1px solid #fff;
	color: #eee;
	position: absolute;
	right: 21px;
}

.sps {
	padding: 1em .5em;
	position: fixed;
	top: 0;
	left: 0;
	transition: all 0.25s ease;
	width: 100%;
}

.sps--abv {
	background-color: transparent;
	color: #000;
}

.sps--blw {
	background-color: #fff;
	color: #fff;
}

.top-bar a.navbar-brand {
	color: #fff;
	font-size: 26px;
	font-weight: 800;
	padding: 5px 0 0 10px;
	text-transform: uppercase;
}

.sps--blw.top-bar a.navbar-brand {
	color: #000;
}

.top-bar a.navbar-brand span {
	color: #0297ff;
}

.top-bar .nav-link {
	color: #fff;
	font-size: 16px;
	font-weight: 500;
	padding: 12px 18px !important;
}

.sps--blw.top-bar .nav-link {
	color: #000
}

.top-bar .navbar-nav .nav-item {
	margin: 0
}

.top-bar .nav-link:hover, .top-bar .nav-item.active a {
	color: #fff;
	border-bottom: 2px solid #fff;
	border-radius: 0;
}

.sps--blw.top-bar .nav-link:hover, .sps--blw.top-bar .nav-item.active a
	{
	color: #0297ff;
	border-bottom: none;
	border-radius: 0;
}

#footer {
	background-color: #696969 !important;
	width: 100%;
	height: 30%;
	margin-top: 30%;
	position: fixed;
	right: 0;
	bottom: 0;
	left: 0;
}

#footer h5 {
	/* 	border-left: 3px solid #eeeeee;
 */
	padding-bottom: 6px;
	margin-bottom: 20px;
	color: #ffffff;
}

#footer a {
	color: #ffffff;
	text-decoration: none !important;
	background-color: transparent;
	-webkit-text-decoration-skip: objects;
}

#footer ul.social li {
	padding: 3px 0;
}

#footer ul.social li a i {
	margin-right: 5px;
	font-size: 25px;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.social li:hover a i {
	font-size: 30px;
	margin-top: -10px;
}

#footer ul.social li a, #footer ul.quick-links li a {
	color: #ffffff;
}

#footer ul.social li a:hover {
	color: #eeeeee;
}

#footer ul.quick-links li {
	padding: 3px 0;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.quick-links li:hover {
	padding: 3px 0;
	margin-left: 5px;
	font-weight: 700;
}

#footer ul.quick-links li a i {
	margin-right: 5px;
}

#footer ul.quick-links li:hover a i {
	font-weight: 700;
}

@media () {
	#footer h5 {
		padding-left: 0;
		border-left: transparent;
		padding-bottom: 0px;
		margin-bottom: 10px;
	}
}
</style>

<script>
	$(document).ready(function() {
		 footerAlign();
		$("#login-alert").show();
		$("#register-alert").hide();
		$(function() {
			$('#login-form-link').click(function(e) {
				$("#login-form").delay(100).fadeIn(100);
				$("#register-form").fadeOut(100);
				$('#register-form-link').removeClass('active');
				$(this).addClass('active');
				$("#login-alert").show();
				$("#register-alert").hide();
				e.preventDefault();
			});
			$('#register-form-link').click(function(e) {
				$("#register-form").delay(100).fadeIn(100);
				$("#login-form").fadeOut(100);
				$('#login-form-link').removeClass('active');
				$(this).addClass('active');
				$("#login-alert").hide();
				$("#register-alert").show();
				e.preventDefault();
			});
		});
		$("#login-submit").click(function() {
			$("#login-form").submit(); // Form submission.
		});

		$("#register-submit").click(function() {
			var password = $("#registerPassword").val();
			var confirmPassword = $("#registerConfirm").val();
			if (password == confirmPassword) {
				$("#register-form").submit();
				return true;
			} else {

				return false;
			}
			// Form submission.
		});

	});
	$(function() {
		$('#login-form-link').click(function(e) {
			$("#login-form").delay(100).fadeIn(100);
			$("#register-form").fadeOut(100);
			$('#register-form-link').removeClass('active');
			$(this).addClass('active');
			$("#login-alert").show();
			$("#register-alert").hide();
			e.preventDefault();
		});
		$('#register-form-link').click(function(e) {
			$("#register-form").delay(100).fadeIn(100);
			$("#login-form").fadeOut(100);
			$('#login-form-link').removeClass('active');
			$(this).addClass('active');
			$("#login-alert").hide();
			$("#register-alert").show();
			e.preventDefault();
		});
	});
	$( window ).resize(function() {
		  footerAlign();
		});	
	function footerAlign() {
		  $('footer').css('display', 'block');
		  $('footer').css('height', 'auto');
		  var footerHeight = $('footer').outerHeight();
		  $('body').css('padding-bottom', footerHeight);
		  $('footer').css('height', footerHeight);
		}


</script>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg mb-4 top-bar navbar-static-top sps sps--abv">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarCollapse1"
			aria-controls="navbarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand mx-auto" href="home">Ranking<span>Enzymes</span></a>
		<div class="collapse navbar-collapse" id="navbarCollapse1">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="#myCarousel">Home <span class="sr-only">(current)</span></a>
				</li>

				<li class="nav-item"><a class="nav-link" href="about">Blog</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row panel-heading"
			style="display: flex; justify-content: space-around; background-color: transparent !important;">
			<div class="btn-group  col-xs-4 col-sm-4 col-md-4 col-lg-4"
				align="right"
				style="float: right !important; background-color: transparent !important;">
			</div>
			<div
				class="btn-group  col-xs-2 col-sm-2 col-md-2 col-lg-2 col-md-offset-1 col-xs-offset-1 col-sm-offset-1 col-lg-offset-1"
				align="center"
				style="display: flex; justify-content: space-around; float: right !important; background-color: transparent !important;">
				<a href="#" class="btn btn-primary  btn-block active"
					id="login-form-link"> <font face="verdana" color="white"><span
						class="myspan">Login</span></font></a>
				<!-- <input type="button" class="btn btn-success btn-block active"
									id="login-form-link" value="Login"> -->
			</div>
			<div class="btn-group col-xs-3 col-sm-3 col-md-3 col-lg-3"
				align="left"
				style="display: flex;  justify-content: flex-start;  float: left !important; background-color: transparent !important;">
				<a href="#" class="btn btn-primary btn-block"
					id="register-form-link"><font face="verdana" color="white"><span
						class="myspan">Register</span></font></a>
				<!-- 	<input type="button" class="btn btn-success btn-block"
									id="register-form-link" value="Register"> -->
			</div>
			<div class="btn-group col-xs-3 col-sm-3 col-md-3 col-lg-3 "
				align="left"
				style="float: left !important; background-color: transparent !important;">
			</div>

		</div>

		<div class="panel-body" style="padding-top: 2% !important">
			<div class="row">
				<div class="col-lg-12" align="center">
					<div id="login-alert" class="col-lg-6 active" align="right">
						<form id="login-form" name="login-form" action="doLogin"
							method="post" role="form">
							<div class="form-group">
								<input type="text" name="loginUserId" id="loginUserId"
									tabindex="1" placeholder="Username" value=""
									class=" form-control">
							</div>
							<div class="form-group">
								<input type="password" name="loginPassword" id="loginPassword"
									tabindex="2" placeholder="Password" class=" form-control">
							</div>
							<div class="form-group text-center">
								<input type="checkbox" tabindex="3" name="remember"
									id="remember"> <label for="remember"> <font
									face="verdana" color="green">Remember Me</font>
								</label>
							</div>
							<div class="form-group">
								<div class="row" align="center">
									<input type="submit" name="login-submit" id="login-submit"
										tabindex="4" class="form-control btn btn-login" value="Log In">
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-lg-12">
										<div class="text-center">
											<a href="/recoverPassword" tabindex="5"
												class="forgot-password"><font face="verdana"
												color="green">Forgot Password?</font></a>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-lg-6" id="register-alert" name="register-alert"
						align="left">
						<form id="register-form" name="register-form"
							action="registerProcess" method="post" role="form">
							<div class="form-group">
								<input type="text" name="registerName" id="registerName"
									tabindex="1" placeholder="Name" class="form-control" value="">
							</div>
							<div class="form-group">
								<input type="text" name="registerUserId" id="registerUserId"
									class="form-control" tabindex="2" placeholder="Username"
									value="">
							</div>

							<div class="form-group">
								<input type="email" name="registerEmail" id="registerEmail"
									tabindex="3" class="form-control" placeholder="Email Address"
									value="">
							</div>
							<div class="form-group">
								<input type="password" name="registerPassword"
									id="registerPassword" tabindex="4" class="form-control"
									placeholder="Password">
							</div>
							<div class="form-group">
								<input type="password" name="registerConfirm"
									class="form-control" id="registerConfirm" tabindex="5"
									placeholder="Confirm Password">
							</div>
							<div class="form-group">
								<div class="row" align="center">
									<input type="submit" name="register-submit"
										id="register-submit" tabindex="6"
										class="form-control btn btn-login" value="Register Now">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<footer>
	<section id="footer" class="footer">
		<div class="container footer_contents">
			<div class="row text-center text-xs-center text-sm-left text-md-left">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
			</div>

			<div class="row" align="center">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"></div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<div class="row" align="center">
						<ul class="list-unstyled list-inline social text-center">
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-facebook"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-twitter"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-instagram"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-google-plus"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"
								target="_blank"><i class="fa fa-envelope"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"></div>
			</div>
		</div>

	</section>
	</footer>
</body>
</html>