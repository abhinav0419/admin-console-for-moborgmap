<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Mobiquity | Admin</title>
<!-- Title Logo  -->
<link rel="icon" href="resources/img/mob-logo-small.png"type="image/x-icon">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link href="resources/css/dashboard.css" rel="stylesheet">
<link href="resources/css/jPushMenu.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- class="navbar-toggle collapsed" -->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img alt="" style="width: 12%" src="resources/img/transp-logo.png"><img alt="" src="resources/img/mobiquity-font.png">	</a>
			</div>
			<div class="navbar-collapse collapse">
				<!-- <div class="collapse navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="bs-example-navbar-collapse-1"> -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Logout</a></li>
				</ul>
				<!-- <form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form> -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="<%=request.getContextPath()%>/search">Manage
							Employee</a></li>
					<li><a href="#">Reports</a></li>
					<li><a href="<%=request.getContextPath()%>/title">Manage Title</a></li>
					<li><a href="<%=request.getContextPath()%>/officelocations">Manage Office Location</a></li>
				</ul>
				<!-- <ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul> -->
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Dashboard</h1>
				<!-- <div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div> -->
				<h2 class="sub-header">Section title</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1,001</td>
								<td>Lorem</td>
								<td>ipsum</td>
								<td>dolor</td>
								<td>sit</td>
							</tr>
							<tr>
								<td>1,002</td>
								<td>amet</td>
								<td>consectetur</td>
								<td>adipiscing</td>
								<td>elit</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="form-group">
                    <label for="InputName">Enter Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Enter Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="InputEmailFirst" name="InputEmail" placeholder="Enter Email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Confirm Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="InputEmailSecond" name="InputEmail" placeholder="Confirm Email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputMessage">Enter Message</label>
                    <div class="input-group">
                        <textarea name="InputMessage" id="InputMessage" class="form-control" rows="5" required></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- Latest JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/docs.min.js"></script>
	<script src="resources/js/ie-emulation-modes-warning.js"></script>
	<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
