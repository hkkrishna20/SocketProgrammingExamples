<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ page language="java" import="com.pnc.wco.SpringBootUploadExample.*" %> 
<head>

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/js/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="${pageContext.request.contextPath}/resources/js/bootstrap-glyphicons.css"
	rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->


<link rel="icon" type="image/vnd.microsoft.icon"
	href="${pageContext.request.contextPath}/resources/js/favicon.ico">
<link rel="shortcut icon" type="image/vnd.microsoft.icon"
	href="${pageContext.request.contextPath}/resources/js/favicon.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-com.fancyBox.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-com.browser-upgrade.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-foundation.webfonts.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-com.print.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-com.main.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/pnc-com.hpg.min.css"
	type="text/css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/personal-banking.css"
	type="text/css" />
<style>
/* layout.css Style */
.upload-drop-zone {
	height: 200px;
	border-width: 2px;
	margin-bottom: 20px;
}

/* skin.css Style*/
.upload-drop-zone {
	color: #ccc;
	border-style: dashed;
	border-color: #ccc;
	line-height: 200px;
	text-align: center
}

.upload-drop-zone.drop {
	color: #222;
	border-color: #222;
}

.image-preview-input {
	position: relative;
	overflow: hidden;
	margin: 0px;
	color: #333;
}

.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
}

.image-preview-input-title {
	margin-left: 2px;
}

.navbar-inner {
	/*height: 90px*/
	min-height: 60px
}

.navbar .brand {
	padding: 0 10px;
}

.navbar .nav>li>a {
	padding: 20px 15px;
	/*padding: 35px 15px;*/
}

.navbar .btn-navbar {
	/*margin-right: 0px;*/
	margin-top: 15px;
}

.brand img {
	margin-top: 5px
}

@media ( max-width :768px) {
	.brand img {
		margin-bottom: 5px
	}
	.navbar .btn-navbar {
		/*margin-right: -15px;*/
		
	}
	.navbar .nav>li>a {
		padding: 10px 15px;
	}
}

@media screen and (min-width:768px) {
	.navbar-brand-centered {
		position: absolute;
		left: 50%;
		display: block;
		width: 160px;
		text-align: center;
	}
	.navbar>.container .navbar-brand-centered, .navbar>.container-fluid .navbar-brand-centered
		{
		margin-left: -80px;
	}
}

.navbar {
	background-color: #336699;
}

.navbar-header {
	background-color: #FF4500;
}

.nav {
	background-color: #FFFFFF;
}
</style>
<script>
	function getSchedule() {
		$.ajax({
			type : "GET",
			url : 'lecturerSchedule',
			dataType : "json",
			complete : [
					function(response, ev) {
						$("#scheduleTable").find("tr:not(:first)").remove();
						<%
						List<Lesson> session_val = (List<Lesson>)request.getSession().getAttribute("products");
						System.out.println(session_val.toString());
						%>
						var trHTML = '';
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						success : function(data) {
															$("#click").attr(
																	"disabled",
																	false);
															var result = jQuery
																	.parseJSON(JSON
																			.stringify(data));
															/*                       for (i=0;i<=result.length;i++) {
															 for (n in result[i]) {
															 $('#table > tbody').append('<tr><th>' + n + '</th><td>' + result[i][n] +  '</td></tr>');
															 }
															 }
															 */var col = [];
															for (var i = 0; i < result.length; i++) {
																for ( var key in result[i]) {
																	if (col
																			.indexOf(key) === -1) {
																		col
																				.push(key);
																	}
																}
															}
															var table = document
																	.createElement("table");
															// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
															var thead = document
																	.createElement("thead");
															var tr = table
																	.insertRow(-1); // TABLE ROW.
															for (var i = 0; i < col.length; i++) {
																var th = document
																		.createElement("th");
																if (i == 0) {
																	th
																			.setAttribute(
																					'class',
																					'fixed-side');
																}
																var string = col[i];
																var newString = string
																		.indexOf('_') == 0 ? string
																		.substring(1)
																		: string;
																th.innerHTML = newString;
																tr
																		.appendChild(th);
															}
															// ADD JSON DATA TO THE TABLE AS ROWS.
															for (var i = 0; i < result.length; i++) {
																tr = table
																		.insertRow(-1);
																for (var j = 0; j < col.length; j++) {
																	var tabCell = tr
																			.insertCell(-1);
																	if (j == 0) {
																		tr
																				.setAttribute(
																						'class',
																						'fixed-side');
																	}
																	tabCell.innerHTML = result[i][col[j]];
																}
															}
															// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
															var divContainer = document
																	.getElementById("ajaxGetUserServletResponse");
															divContainer.innerHTML = "";
															divContainer
																	.appendChild(table);
														}
													});
						
						
						
						
						debugger;
							<%
							if(null==session_val)
							{
							}else {%>
								var session_obj= '<%=session_val%>';
								var lenght= '<%=session_val.size()%>'
								alert("session_obj"+session_obj);
								<%System.out.println("session_val"+session_val);
							    for(Lesson info: session_val)
							    {%>
							    	trHTML += '<tr><td><label>' + '<%=info.name%>'
											+ '</label></td><td>' + '<%=info.id%>'
											+ '</td></tr>';
							    <%}
							    session_val.clear();
							}
							
							
							%>
							/* <div class="list-group">
							<a href="#" class="list-group-item list-group-item-success"><span
								class="badge alert-success pull-right">Success</span>image-01.jpg</a>
							<a href="#" class="list-group-item list-group-item-success"><span
								class="badge alert-success pull-right">Success</span>image-02.jpg</a>
						</div> */
						
						debugger;
						$("#scheduleTable tbody").append(trHTML);

					},

			]
		});
	}
</script>
</head>
<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-brand-centered">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="navbar-brand navbar-brand-centered">
					<img
						src="${pageContext.request.contextPath}/resources/images/pnc_logo_rev.svg"
						alt="logo">
				</div>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-brand-centered">
				<ul class="nav navbar-nav">
					<li><a href="#">Link</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container-fluid">
		<div class="col-md-2"></div>
		<div class="col-md-8"
			style="padding-top: 20px; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; border-right: double; border-left: double; border-top: double; border-bottom: double;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-7">
						<div class="panel panel-default">
							<form id="js-upload-form" name="upload" action="upload"
								method="post" enctype="multipart/form-data">

								<div class="panel-heading">
									<strong>Upload files</strong> <small> </small>
								</div>
								<div class="panel-body">
									<div class="input-group image-preview">
										<input placeholder="" type="text"
											class="form-control image-preview-filename"
											disabled="disabled">
										<!-- don't give a name === doesn't send on POST/GET -->
										<span class="input-group-btn"> <!-- image-preview-input -->
											<div class="btn btn-default image-preview-input">
												<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">Browse</span> <input
													type="file" name="file" id="file"
													accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />
												<!-- rename it -->
											</div> <input type="submit" value="Upload" name="uploadsubmit"
											class="btn btn-labeled btn-default btn-label glyphicon glyphicon-upload">
										</span>
									</div>
								</div>
							</form>

							<!-- Drop Zone -->
							<h4>Or drag and drop files below</h4>
							<div class="upload-drop-zone" id="drop-zone">Just drag and
								drop files here</div>

							<!-- Progress Bar -->
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="60"
									aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
									<span class="sr-only">60% Complete</span>
								</div>
							</div>

							<!-- Upload Finished -->
							<div class="js-upload-finished">
								<h3>Processed files</h3>
								<div class="list-group">
									<a href="#" class="list-group-item list-group-item-success"><span
										class="badge alert-success pull-right">Success</span>image-01.jpg</a>
									<a href="#" class="list-group-item list-group-item-success"><span
										class="badge alert-success pull-right">Success</span>image-02.jpg</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-5">
						<form name="downloadticketpdf" action="downloadticketpdf"
							method="get">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>Download files</strong> <small> </small>
								</div>
								<div class="panel-body">
									<div class="row" style="padding-left: 5px">
										<div class="col-6">
											Ticket Number: <input id="ticket" name="ticket" type="text" />
										</div>
										<div class="col-6">
											<input type="submit" name="somethingelse"
												value="Download Ticket"
												class="btn btn-labeled btn-primary glyphicon glyphicon-download btn-label" />

										</div>

									</div>
									<br />
								</div>
							</div>
						</form>
					</div>


				</div>
			</div>

			<!-- /container -->
		</div>
		<div class="col-md-2">
			<div class=row>
				<button type ="button" class="primary" onclick="getSchedule()">Schedule</button>
				<div class="panel">
					<table id="scheduleTable" align="left" class="order-table"
						style="width: 50%">
						<thead>
							<tr>
								<th align="left">Subject</th>
								<th align="left">Date</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<script>
		
	</script>
	<a href="#" aria-label="Back to Top" class="back-top visible"></a>
	
	
</body>
</html>
