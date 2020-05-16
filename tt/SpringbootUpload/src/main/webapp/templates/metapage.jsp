<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="https://raw.githubusercontent.com/twbs/bootstrap/master/docs/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="https://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs/dt-1.10.18/datatables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/responsive/2.2.2/js/dataTables.responsive.min.js"></script>
<script
	src="https://cdn.datatables.net/responsive/2.2.2/js/responsive.bootstrap4.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
<link
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css" />
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&subset=latin-ext"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs/dt-1.10.18/datatables.min.css" />


<style>
html, body {
	margin: 0px;
	padding: 0px;
	max-height: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}


body {
	background-image: linear-gradient(to right, #ff8177 0%, #ff867a 0%, #ff8c7f 21%, #f99185
		52%, #cf556c 78%, #b12a5b 100%);
			overflow: hidden;
}

.blog .carousel-indicators {
	left: 0;
	top: auto;
	bottom: -40px;
}

/* The colour of the indicators */
.blog .carousel-indicators li {
	background: #a3a3a3;
	border-radius: 50%;
	width: 8px;
	height: 8px;
}

.blog .carousel-indicators .active {
	background: #707070;
}

@media screen and (max-width: 480px) {
	.admin-sidebar {
		display: none;
	}
}

@media screen and (min-width: 480px) {
	.admin-tabs {
		display: none;
	}
}

.admin-sidebar {
	max-width: 12%;
}

#sidebar-admin {
	position: fixed;
}

.admin-sidebar-item {
	padding: 1em;
	border-bottom: 1px solid white;
}

.admin-nav {
	background: #49C2B3;
}

.admin-nav-item {
	color: white;
	font-weight: bold;
}

.admin-nav-item:hover {
	color: white;
	background: #41aea1;
}

.admin-nav-item.active {
	background: #53FFE7 !important;
	color: white !important;
}

.admin-header-block {
	background: #434449;
	color: white !important;
	text-align: left;
	border-color: #ddd;
	border-radius: 4px;
	font-weight: bold;
}

.admin-filter-button {
	background: #78B404;
	color: white !important;
	font-weight: bold;
}

.admin-user-card {
	margin-bottom: 10px;
}

.item {
	float: left;
	display: inline-block;
}

#myCarousel .nav a small {
	display: inline-block;
}

#myCarousel .nav {
	background: #eee;
}

.nav-justified>li>a {
	border-radius: 0px;
}

.nav-pills>li[data-slide-to="0"].active a {
	background-color: #16a085;
}

.nav-pills>li[data-slide-to="1"].active a {
	background-color: #e67e22;
}

.nav-pills>li[data-slide-to="2"].active a {
	background-color: #2980b9;
}

.nav-pills>li[data-slide-to="3"].active a {
	background-color: #8e44ad;
}

.navbar, .dropdown-menu {
	background-color: #CC3333;
	/* background: rgba(255, 255, 255, 0.25); */
	border: none;
}

.nav>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover,
	.dropdown-menu>li>a, .dropdown-menu>li {
	border-bottom: 3px solid transparent;
}

.nav>li>a:focus, .nav>li>a:hover, .nav .open>a, .nav .open>a:focus, .nav .open>a:hover,
	.dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover {
	border-bottom: 3px solid transparent;
	background: none;
}

.navbar a, .dropdown-menu>li>a, .dropdown-menu>li>a:focus,
	.dropdown-menu>li>a:hover, .navbar-toggle {
	color: #fff;
}

.dropdown-menu {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.nav li:hover:nth-child(8n+1), .nav li.active:nth-child(8n+1) {
	border-bottom: #C4E17F 3px solid;
}

.nav li:hover:nth-child(8n+2), .nav li.active:nth-child(8n+2) {
	border-bottom: #F7FDCA 3px solid;
}

.nav li:hover:nth-child(8n+3), .nav li.active:nth-child(8n+3) {
	border-bottom: #FECF71 3px solid;
}

.nav li:hover:nth-child(8n+4), .nav li.active:nth-child(8n+4) {
	border-bottom: #F0776C 3px solid;
}

.nav li:hover:nth-child(8n+5), .nav li.active:nth-child(8n+5) {
	border-bottom: #DB9DBE 3px solid;
}

.nav li:hover:nth-child(8n+6), .nav li.active:nth-child(8n+6) {
	border-bottom: #C49CDE 3px solid;
}

.nav li:hover:nth-child(8n+7), .nav li.active:nth-child(8n+7) {
	border-bottom: #669AE1 3px solid;
}

.nav li:hover:nth-child(8n+8), .nav li.active:nth-child(8n+8) {
	border-bottom: #62C2E4 3px solid;
}

.navbar-toggle .icon-bar {
	color: #fff;
	background: #fff;
}
.plate {
	color: hotpink;
	background: #000;
	padding: 5px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 5px;
}

#footer {
	background-color: #696969 !important;
	left: 0;
	bottom: 0;
	width: 100%;
	position: absolute;
}
#footer h5 {
	padding-left: 10px;
	border-left: 3px solid #eeeeee;
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

@media ( max-width :767px) {
	#footer h5 {
		padding-left: 0;
		border-left: transparent;
		padding-bottom: 10px;
		margin-bottom: 10px;
	}
}
</style>
<script>
function footerAlign() {
	  $('footer').css('display', 'block');
	  $('footer').css('height', 'auto');
	  var footerHeight = $('footer').outerHeight();
	  $('body').css('padding-bottom', footerHeight);
	  $('footer').css('height', footerHeight);
	}

	//optional
	$('#blogCarousel').carousel({
		interval : 5000
	});
$( window ).resize(function() {
	  footerAlign();
	});	
	$(document).ready(function() {
		  footerAlign();
		$(".panel").hide(); /*Instead of hiding .panel here you can hide it by using css for first time */
		 $('#admin-communicate').show();
		$("#sidebar-admin a").click(function(e) {
			e.preventDefault();
			var showIt = $(this).attr('href');
			$(".panel").hide();
			$(showIt).show();
		})
	});
</script>
</head>
<body>
	<div class="row" style="padding-top: 2% !important;">
		<div class="col-sm-2 col-xs-2  col-md-2 col-lg-2 admin-sidebar">
			<div
				class="nav flex-column nav-pills text-center text-uppercase admin-nav"
				id="sidebar-admin" role="tablist" aria-orientation="vertical">
				<a class="nav-link active show admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-communicate" role="tab"
					aria-controls="admin-communicate" aria-selected="true">Home</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-requests" role="tab"
					aria-controls="admin-requests" aria-selected="false">Downloads</a>
				<a class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-users" role="tab"
					aria-controls="admin-users" aria-selected="false">Pagination</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-groups" role="tab"
					aria-controls="admin-groups" aria-selected="false">Metadata</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-analytics" role="tab"
					aria-controls="admin-analytics" aria-selected="false">Rank</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-messages" role="tab"
					aria-controls="admin-messages" aria-selected="false">Sort</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-sessions" role="tab"
					aria-controls="admin-sessions" aria-selected="false">Excel Rank</a>
				<a class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-testimonials" role="tab"
					aria-controls="admin-testimonials" aria-selected="false">Team</a> <a
					class="nav-link admin-nav-item admin-sidebar-item"
					data-toggle="pill" href="#admin-changelog" role="tab"
					aria-controls="admin-changelog" aria-selected="false">About</a>
			</div>
		</div>
		<div class="col-sm-12 col-xs-12  col-md-12 col-lg-12   admin-tabs">
			<ul class="nav nav-tabs admin-nav text-uppercase" role="tablist">
				<li class="nav-item"><a class="nav-link admin-nav-item active"
					data-toggle="tab" href="#admin-communicate" role="tab"
					aria-controls="admin-communicate" aria-selected="true">Home</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-requests" role="tab"
					aria-controls="admin-requests" aria-selected="false">Downloads</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-users" role="tab"
					aria-controls="admin-users" aria-selected="false">Pagination</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-groups" role="tab"
					aria-controls="admin-groups" aria-selected="false">Metadata</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-analytics" role="tab"
					aria-controls="admin-analytics" aria-selected="false">Rank</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-messages" role="tab"
					aria-controls="admin-messages" aria-selected="false">Sort</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-sessions" role="tab"
					aria-controls="admin-sessions" aria-selected="false">Excel Rank</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-testimonials" role="tab"
					aria-controls="admin-testimonials" aria-selected="false">Team</a></li>
				<li class="nav-item"><a class="nav-link admin-nav-item"
					data-toggle="tab" href="#admin-changelog" role="tab"
					aria-controls="admin-changelog" aria-selected="false">About</a></li>
			</ul>
		</div>
		<div class="col-sm-10 col-xs-10  col-md-10 col-lg-10 ">
			<div class="tab-content">
				<div class="panel tab-pane  fade active show" id="admin-communicate"
					role="tabpanel" aria-labelledby="admin-communicate-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal</a>
							</h4>
						</li>
					</ul>
					<div class="container" >
						<div class="row blog">
							<div class="container" style="padding-top: 30px;">
								<div class="list-group">
									<a href="home" class="list-group-item list-group-item-success">
										<h4 class="list-group-item-heading">Home</h4>
									</a> <a href="team" class="list-group-item list-group-item-info">
										<h4 class="list-group-item-heading">Team</h4>
									</a> <a href="about"
										class="list-group-item list-group-item-warning">
										<h4 class="list-group-item-heading">About</h4>
									</a> <a href="landInLogin"
										class="list-group-item list-group-item-danger">
										<h4 class="list-group-item-heading">Register N Login</h4>
									</a>
								</div>
							</div>
							<div class="col-md-12" style="padding-top: 2%;">
								<div id="blogCarousel" class="carousel slide"
									data-ride="carousel">
									<ol class="carousel-indicators">
										<li data-target="#blogCarousel" data-slide-to="0"
											class="active"></li>
										<li data-target="#blogCarousel" data-slide-to="1"></li>
										<li data-target="#blogCarousel" data-slide-to="2"></li>
										<li data-target="#blogCarousel" data-slide-to="3"></li>
									</ol>

									<!-- Carousel items -->
									<div class="carousel-inner">

										<div class="carousel-item active">
											<div class="row">
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
											</div>
											<!--.row-->
										</div>
										<!--.item-->

										<div class="carousel-item">
											<div class="row">
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
											</div>
											<!--.row-->
										</div>
										<!--.item-->
										<div class="carousel-item">
											<div class="row">
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
											</div>
											<!--.row-->
										</div>
										<!--.item-->

										<div class="carousel-item">
											<div class="row">
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
												<div class="col-md-3">
													<a href="#"> <img src="http://placehold.it/250x250"
														alt="Image" style="max-width: 100%;">
													</a>
												</div>
											</div>
											<!--.row-->
										</div>
										<!--.item-->


									</div>
									<!--.carousel-inner-->
								</div>
								<!--.Carousel-->


							</div>
						</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-requests"
					role="tabpanel" aria-labelledby="admin-requests-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal - Downloads
									</a>
							</h4>
						</li>
					</ul>
					<div class="container">
						<div class="list-group">
							<a href="downloadFungiSheet"
								class="list-group-item list-group-item-success">
								<h4 class="list-group-item-heading">Save Fungi Metadata
									Sheet</h4>
							</a> <a href="downloadClassifiers"
								class="list-group-item list-group-item-info">
								<h4 class="list-group-item-heading">Save Classifier
									Metadata Sheet</h4>
							</a>
						</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-users" role="tabpanel"
					aria-labelledby="admin-users-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal - Users
									</a>
							</h4>
						</li>
					</ul>
					<div class="container mt-4 mb-5">
						<div class="row">
							<div class="col-md-4">
								<div class="card text-center admin-user-card">
									<div class="card-header">Pagination Rank CAZymes</div>
									<div class="card-block p-3">
										<h4 class="card-title">Name</h4>
										<p class="card-text">Information</p>
										<a href="paginationRankCAZymes" class="btn btn-primary rounded-0 mb-2">Click Here</a>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card text-center admin-user-card">
									<div class="card-header">Pagination Rank Fungi</div>
									<div class="card-block p-3">
										<h4 class="card-title">Name</h4>
										<p class="card-text">Information</p>
										<a href="paginationRankFungiCAZymes" class="btn btn-primary rounded-0 mb-2">Click Here</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Card -->
				</div>
				<div class="panel tab-pane  fade" id="admin-groups" role="tabpanel"
					aria-labelledby="admin-groups-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal - Groups
									</a>
							</h4>
						</li>
					</ul>
					<div class="container">
						<div class="list-group">
							<a href="dashboardClassifier" class="list-group-item list-group-item-success">
								<h4 class="list-group-item-heading">Classifier Dashboard </h4>

							</a> <a href="dashboardFungi" class="list-group-item list-group-item-info">
								<h4 class="list-group-item-heading">Fungi Dashboard</h4>

							</a> 
					</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-analytics"
					role="tabpanel" aria-labelledby="admin-analytics-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal -
									Analytics</a>
							</h4>
						</li>
					</ul>
					<div class="container">
						<div class="list-group">
							<a href="searchClassifier" class="list-group-item list-group-item-success">
								<h4 class="list-group-item-heading">Rank Classifier</h4>

							</a> <a href="searchGenomes" class="list-group-item list-group-item-info">
								<h4 class="list-group-item-heading">Rank Genomes</h4>

							</a>
						</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-messages"
					role="tabpanel" aria-labelledby="admin-messages-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal -
									Messages </a>
							</h4>
						</li>
					</ul>
					<div class="container">
						<div class="list-group">
							<a href="sortNPageClassifier" class="list-group-item list-group-item-success">
								<h4 class="list-group-item-heading">Sort N Page Classifiers</h4>

							</a> <a href="sortNPageGenome" class="list-group-item list-group-item-info">
								<h4 class="list-group-item-heading">Sort N Page Genomes</h4>

							</a>
						</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-sessions"
					role="tabpanel" aria-labelledby="admin-sessions-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal -
									Sessions </a>
							</h4>
						</li>
					</ul>
					<div class="container">
						<div class="list-group">
							<a href="rankingExcelFinalCAZ" class="list-group-item list-group-item-success">
								<h4 class="list-group-item-heading">Ranking Excel Final CAZ</h4>

							</a> <a href="rankingExcelFungi" class="list-group-item list-group-item-info">
								<h4 class="list-group-item-heading">Ranking Excel Fungi</h4>

							</a>
						</div>
					</div>
				</div>
				<div class="panel tab-pane  fade" id="admin-testimonials"
					role="tabpanel" aria-labelledby="admin-testimonials-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal -
									Team</a>
							</h4>
						</li>
					</ul>

					<div id="recipeCarousel" class="carousel slide w-100"
						data-ride="carousel">
						<div class="carousel-inner w-100" role="listbox">
							<div class="carousel-item row no-gutters active">
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/222/fff?text=1">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/444?text=2">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/888?text=3">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/111/fff?text=4">
								</div>
							</div>
							<div class="carousel-item row no-gutters">
								<div class="col-3 float-left">
									<img class="img-fluid" src="http://placehold.it/350x280?text=5">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/555?text=6">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/333/fff?text=7">
								</div>
								<div class="col-3 float-left">
									<img class="img-fluid"
										src="http://placehold.it/350x280/bbb?text=8">
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#recipeCarousel"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#recipeCarousel"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>


				<div class="panel tab-pane  fade" id="admin-changelog"
					role="tabpanel" aria-labelledby="admin-changelog-tab">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">
							<h4>
								<a class="nav-link admin-header-block">Admin Portal -
									Changelog</a>
							</h4>
						</li>
					</ul>


					<div class="container" style="padding-top: 5px;">


						<div class="row">
							<div class="col-6">
								<div class="plate">
									col-6 (L 50%)<img class="card-img"
										src="http://placehold.it/400x500" alt="">
								</div>
								<br>
								<div class="row">
									<div class="col-6">
										<div class="plate">
											col-6 (L 50%)<img class="card-img"
												src="http://placehold.it/400x400" alt="">
										</div>
									</div>
									<div class="col-6">
										<div class="plate">
											col-6 (L 50%)<img class="card-img"
												src="http://placehold.it/400x400" alt="">
										</div>
									</div>
								</div>
							</div>
							<div class="col-6">
								<div class="plate">
									col-6 (R 50%)<img class="card-img"
										src="http://placehold.it/600x400" alt="">
								</div>
								<br>
								<div class="row">
									<div class="col-7">
										<div class="plate">
											R 60%<img class="card-img" src="http://placehold.it/400x400"
												alt="">
										</div>
									</div>
									<div class="col-5">
										<div class="plate">
											R 40%<img class="card-img" src="http://placehold.it/400x605"
												alt="">
										</div>
									</div>
								</div>
								<br>
								<div class="col-12">
									<div class="plate">
										R 100%<img class="card-img" src="http://placehold.it/700x400"
											alt="">
									</div>
								</div>
							</div>

						</div>

					</div>
					<br>
					<!-- 
						<div class="row">
							<div class="col">
								<div class="plate">
									col 100%<img class="card-img" src="http://placehold.it/800x200"
										alt="">Nested columns won't gives you full width to
									access. Reverse is possible
								</div>
							</div>
						</div> -->

				</div>
			</div>
		</div>
	</div>
		<div class="row" style="padding-top: 15% !important;">
		<div class="row">
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" align="center">

			</div>
			<div class="item col-xs-1 col-sm-1 col-md-1 col-lg-1" align="left">
				<div></div>
			</div>
		</div>
		<div class="mx-auto" style="width: 100px;"></div>
	</div>
	
		<div class="row" style="padding-top: 2% !important;">
		<div class="row">
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" align="center">

			</div>
			<div class="item col-xs-1 col-sm-1 col-md-1 col-lg-1" align="left">
				<div></div>
			</div>

		</div>
		<div class="mx-auto" style="width: 100px;"></div>
	</div>
	
</body>
</html>