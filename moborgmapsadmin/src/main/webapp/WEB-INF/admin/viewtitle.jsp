<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Mobiquity | Admin</title>
<!-- Title Logo  -->
<link rel="icon" href="resources/img/mob-logo-small.png"
	type="image/x-icon">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link href="resources/css/dashboard.css" rel="stylesheet">
<link href="resources/css/jPushMenu.css" rel="stylesheet">
<style>
.filter-table .quick {
	margin-left: 0.5em;
	font-size: 0.8em;
	text-decoration: none;
}

.fitler-table .quick:hover {
	text-decoration: underline;
}

td.alt {
	background-color: #ffc;
	background-color: rgba(255, 255, 0, 0.2);
}

@media ( max-width : 480px) {
	.hide-sm {
		display: none;
	}
}
</style>
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
				<a class="navbar-brand" href="#"><img alt="" style="width: 12%"
					src="resources/img/transp-logo.png"><img alt=""
					src="resources/img/mobiquity-font.png"> </a>
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
					<li><a href="#">Manage Employee</a></li>
					<li><a href="#">Reports</a></li>
					<li class="active"><a
						href="<%=request.getContextPath()%>/title">Manage Title</a></li>
					<li><a href="<%=request.getContextPath()%>/officelocations">Manage
							Office Location</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div
				class="col-sm-4 col-xs-6 col-sm-offset-3 col-md-3 col-md-offset-2 main">
				<div class="input-group">
					<span class="input-group-addon"><span
						class=" glyphicon glyphicon-search"></span></span> <input id="filter"
						type="text" class="form-control" placeholder="Enter Keywords">

				</div>
			</div>
			<div class="col-sm-4 col-xs-6 col-sm-offset-3 col-md-3 col-md-offset-2 main" style=" float: right">
				<div class="input-group">
					<button class="btn btn-primary addButoon "
						data-toggle="modal" data-target="#myModal1">+ Add Title</button>
				</div>
			</div>
		</div>
		<!-- <div class="row">
			<div
				class="col-sm-4 col-xs-6 col-sm-offset-3 col-md-3 col-md-offset-2 main">
				<div class="input-group">
					<button class="btn btn-primary addButoon btn-lg"
						data-toggle="modal" data-target="#myModal">Add</button>
				</div>
			</div>
		</div> -->

		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Titles</th>
								<th>Edit Option</th>
								<th>Delete Option</th>
							</tr>
						</thead>
						<tbody class="searchable">
							<c:forEach var="title" items="${titleList}">
								<tr id="${title.titleId}">
									<td class="title">${title.titleName}</td>
									<td><button class="btn btn-success editbutton"
											data-toggle="modal" data-target="#myModal">Edit</button></td>
									<td><button class="btn btn-danger deletebutton"
											name="delete">delete</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Edit Title</h4>
				</div>
				<form action="<%=request.getContextPath()%>/editTitle" method="post">
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="titleId" id="titleId" value="">
							<label class="hide-sm">Title</label> <input type="text"
								class="form-control" id="title" name="titleName"
								placeholder="Enter Title" required>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Title</h4>
				</div>
				<form action="<%=request.getContextPath()%>/addTitle" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label class="hide-sm">Title</label> <input type="text"
								class="form-control" id="title" name="titleName"
								placeholder="Enter Title" required>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save
							changes</button>
					</div>
				</form>
			</div>
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
	<script type="text/javascript">
		$(document).ready(function() {
			(function($) {
				$('#filter').keyup(function() {
					var rex = new RegExp($(this).val(), 'i');
					$('.searchable tr').hide();
					$('.searchable tr').filter(function() {
						return rex.test($(this).text());
					}).show();
				})
			}(jQuery));

		});
	</script>
	<script type="text/javascript">
	$('.editbutton').click(function () {
	    var currentId = $(this).parent().parent();
	    $("#titleId").val(currentId.attr('id'));
	    $("#title").val(currentId.find('.title').html());

	});
	$('.deletebutton').click(function () {
		var x =confirm("You are about to delete the Title.");
			if(x == true){
		    var currentId = $(this).parent().parent();
		    $.post("deletetitle?titleId=" + currentId.attr('id'), function (success) {
		        if (success == "Deleted") { 
		        	/* alert("Data: " + success + "\nStatus: " + status); */
		            window.location = "<%=request.getContextPath()%>/title";
		        } else {
		            alert("\t\t\t\t\tThis Title Can't be deletd.\n\nPlease delete appropriate employees having this Title to delete this Title");
		        }
		    });
			}
	});
	</script>
</body>
</html>