<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Mobiquity | Admin</title>
<!-- jQuery Version 1.11.0 -->
<script src="resources/js/jquery-1.11.0.js"></script>
<!-- Title Logo  -->
<link rel="icon" href="resources/img/mob-logo-small.png"
	type="image/x-icon">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/ui-darkness/jquery-ui.min.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link href="resources/css/dashboard.css" rel="stylesheet">
<link href="resources/css/jPushMenu.css" rel="stylesheet">
<link href="resources/css/search.css" rel="stylesheet">
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
					<li class="active"><a
						href="<%=request.getContextPath()%>/search">Manage Employee</a></li>
					<li><a href="#">Reports</a></li>
					<li><a href="<%=request.getContextPath()%>/title">Manage
							Title</a></li>
					<li><a href="<%=request.getContextPath()%>/officelocations">Manage
							Office Location</a></li>
				</ul>

			</div>
			<br>
			<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Employee List</h1>

			</div> -->
            <form name="searchForm" action="searchcontroller" method="get">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<h2>Search MObOrgMap</h2>
					<br>
					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input type="text" class="  search-query form-control"
								placeholder="Search By Employee Name" id="searchbyemployee" />
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" >
									<span class=" glyphicon glyphicon-search" id="seacrhicon"></span>
								</button>
							</span>
						</div>
						<input id="employeenamehidden" style="display:none" name="hiddenemployeeid"></input>
					</div>
				</div>
				<br>
				<div class="row">
					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input type="text" class="  search-query form-control"
								placeholder="Search By Employee Title" id="searchbydesignation" />
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" >
									<span class=" glyphicon glyphicon-search" id="seacrhicon"></span>
								</button>
							</span>
						</div>
						<input id="employeetitlehidden" style="display:none" name="hiddentitleid"></input>
					</div>
				</div>
				<br>
				<div class="row">
					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input type="text" class="  search-query form-control"
								placeholder="Search By Office Location"
								id="searchbyofficelocation" /> <span class="input-group-btn">
								<button class="btn btn-primary" type="button" >
									<i class=" glyphicon glyphicon-search" id="seacrhicon"></i>
								</button>
							</span>
						</div>
						<input id="employeeofficehidden" style="display:none" name="hiddenofficeid"></input>
					</div>
				</div>
				
				<br>
								<div class="row">
					<input class="btn btn-primary" type="submit" id="nehal" ></input>
				</div>
				
			</div>
			</form>
		</div>
		
		
		
		<!-- 	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<button class="btn btn-primary btn-lg" data-toggle="modal"
				data-target="#myModal">Launch demo modal</button>
		</div> -->

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->

		<!-- Latest JQuery -->

		<!-- Latest compiled and minified JavaScript -->
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/docs.min.js"></script>
		<script src="resources/js/ie-emulation-modes-warning.js"></script>
		<script src="resources/js/ie10-viewport-bug-workaround.js"></script>

		<script>
			/* function fnOpenNormalDialog() {
			    $('.btn-toggle').prev().prev().html("Are you sure you want to Deavtivate this employee?");

			    // Define the Dialog and its properties.
			    $('.btn-toggle').prev().prev().dialog({
			        resizable: false,
			        modal: true,
			        title: "Modal",
			        height: 250,
			        width: 400,
			        buttons: {
			            "Yes": function () {
			                $(this).dialog('close');
			                callback(true);
			            },
			                "No": function () {
			                $(this).dialog('close');
			                callback(false);
			            }
			        }
			    });
			} */
			$(document).ready(function() {
				
				
				/* function reset() {  */
					document.searchForm.hiddenemployeeid.value=""; 
					document.searchForm.hiddentitleid.value=""; 
					document.searchForm.hiddenofficeid.value=""; 
					//}
				
				$(function() {

					$("#searchbydesignation").autocomplete({
						max : 10,
						minLength : 2,
						/* source: data, */
						source : function(request, response) {
							$.ajax({
								url : "searchControllerDesignation",
								type : "GET",
								/* data : request, */
								data : {
									term : request.term
								},
								dataType : "json",
								success : function(data) {

									response(data.nameListTitle);

								}
							});
						},
						focus : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox
							$('#searchbydesignation').val(ui.item.label);
						},
						select : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox and hidden field
							$('#employeetitlehidden').val(ui.item.value);
							console.log(ui.item.value);
							/*  $('#autocomplete2').val(ui.item.label); */

						}
					});
					
					


					$("#searchbyemployee").autocomplete({
						max : 10,
						minLength : 2,
						/* source: data, */
						source : function(request, response) {
							$.ajax({
								url : "searchControllerEmployee",
								type : "GET",
								/* data : request, */
								data : {
									term : request.term
								},
								dataType : "json",
								success : function(data) {

									response(data.nameList);

								}
							});
						},
						focus : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox
							$('#searchbyemployee').val(ui.item.label);
						},
						select : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox and hidden field
							$('#employeenamehidden').val(ui.item.value);
							console.log(ui.item.value);
							/*  $('#autocomplete2').val(ui.item.label); */

						}
					});
					

					$("#searchbyofficelocation").autocomplete({
						max : 10,
						minLength : 2,
						/* source: data, */
						source : function(request, response) {
							$.ajax({
								url : "searchControllerOfficeLocation",
								type : "GET",
								/* data : request, */
								data : {
									term : request.term
								},
								dataType : "json",
								success : function(data) {

									response(data.nameListOffice);

								}
							});
						},
						focus : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox
							$('#searchbyofficelocation').val(ui.item.label);
						},
						select : function(event, ui) {
							// prevent autocomplete from updating the textbox
							event.preventDefault();
							// manually update the textbox and hidden field
							$('#employeeofficehidden').val(ui.item.value);
							var demo=$('#employeeofficehidden').val();
							console.log(demo);
							/*  $('#autocomplete2').val(ui.item.label); */

						}
					});
					
				});
				
				

				

			});
		</script>
</body>
</html>
