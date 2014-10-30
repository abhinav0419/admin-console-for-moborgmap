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
<!-- Title Logo  -->
<link rel="icon" href="resources/img/mob-logo-small.png"
	type="image/x-icon">
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
					<li  class="active"><a href="<%=request.getContextPath()%>/search">Manage
							Employee</a></li>
					<li><a href="#">Reports</a></li>
					<li><a href="<%=request.getContextPath()%>/title">Manage
							Title</a></li>
					<li><a
						href="<%=request.getContextPath()%>/officelocations">Manage
							Office Location</a></li>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Employee List</h1>

			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<td><b>Employee Name</b></td>
								<td><b>Delete Employee</b></td>
								<td><b>Edit Employee</b></td>
							</tr>
						</thead>
						<c:forEach var="employee" items="${employeeNameList}"
							varStatus="status">
							<tbody>
								<tr id="${employee.userId}">
									<td class="mainEmailId" style="display: none;">${employee.emailId}</td>
									<td class="mainFullName">${employee.fullName}</td>
									<td class="mainTitle" style="display: none;">${titleNameList[status.index]}</td>
									<td class="mainOfficeLocation" style="display: none;">${officeLocationNamesList[status.index]}</td>
									<td class="mainResourceManager" style="display: none;">${resourceManagerNamesList[status.index]}</td>
									<td class="mainContactNo" style="display: none;">${employee.contactNo}</td>
									<td class="mainOfficeContactNo" style="display: none;">${employee.officeContactNo}</td>
									<td><c:choose>
											<c:when test="${employee.active eq true}">
												<input type="hidden" id="${employee.userId}"
													value="${employee.resourceManager}" class="me">
												<div class="btn-group btn-toggle" id="${employee.userId}">
													<button class="btn btn-sm active btn-primary" value="ON">Active</button>
													<button class="btn btn-sm btn-default" value="OFF">Deactivate</button>
												</div>
											</c:when>
											<c:otherwise>
												<input type="hidden" id="${employee.userId}"
													value="${employee.resourceManager}" class="me">
												<div class="btn-group btn-toggle" id="${employee.userId}">
													<button class="btn btn-sm btn-default" value="ON">Active</button>
													<button class="btn btn-sm btn-primary active" value="OFF">Deactivate</button>
												</div>
											</c:otherwise>
										</c:choose></td>
									<td><button class="btn btn-success editbutton"
											id="${employee.userId}" data-toggle="modal"
											data-target="#myModal">Edit</button></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	<!-- 	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<button class="btn btn-primary btn-lg" data-toggle="modal"
				data-target="#myModal">Launch demo modal</button>
		</div> -->
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Edit Employee
							Details</h4>
					</div>
					<form action="<%=request.getContextPath()%>/editEmployeeDetails"
						method="post">
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" name="userID" id="userID" value="">
								<label class="hide-sm">Email ID</label> <input type="text"
									class="form-control" id="emailId" name="emailId"
									placeholder="Enter Email ID" readonly="true">
							</div>
							<div class="form-group">
								<label class="hide-sm">Full Name</label> <input type="text"
									class="form-control" id="fullName" name="fullName"
									placeholder="Enter Full Name" required>
							</div>
							<div class="form-group">
								<label class="hide-sm">Title</label> <select id="titleName" name="titleName"
									class="form-control">
									<option value="">Title</option>
									<c:forEach items="${titleList}" var="name">
										<option value="${name.titleName}">${name.titleName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="hide-sm">Office Location</label> <select
									id="officeLocation" name ="officeLocation" class="form-control">
									<option value="">Office Location</option>
									<c:forEach items="${officeLocationList}" var="name">
										<option value="${name.addressLine1}">${name.addressLine1}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="hide-sm">Resource Manager</label>
								<select
									id="resourceManager" name = "resourceManager" class="form-control">
									<option value="">Resource Manager</option>
									<c:forEach items="${managerList}" var="name">
										<option value="${name.fullName}">${name.fullName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="hide-sm">Contact Number</label> <input type="text"
									class="form-control" id="contactNumber" name="contactNumber"
									placeholder="Enter Contact Number" required>
							</div>
							<div class="form-group">
								<label class="hide-sm">Office Contact Number</label> <input
									type="text" class="form-control" id="officeContactNumber"
									name="officeContactNumber"
									placeholder="Enter Office Contact Number" required>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
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
			});

			/* 	function callback(value) {
				    if (value) {
				        alert("Confirmed");
				    } else {
				        alert("Rejected");
				    }
				}
			 */
			$('.btn-toggle')
					.click(
							function() {

								$defaultId = $(this).attr('id');

								var res = $(this).prev().val();
								console.log(res);

								if ($(this).find('.btn').attr('class') == "btn btn-sm btn-default") {
									$(this).find('.btn').toggleClass('active');
									alert("Activated");
									$
											.ajax({
												url : "/orgchart/activetoggle?userId="
														+ $defaultId
														+ "&status=active",
												success : function(result) {
												}
											});

								} else {
									$(this).find('.btn').toggleClass('active');
									console.log("inside deactivate" + res);
									if (res != "false") {
										alert("You can not Deactivate this Employee.\nPlease reassign direct reports before deactivating the Employee.");
										$(this).find('.btn').toggleClass(
												'active');
										if ($(this).find('.btn-primary').size() > 0) {
											$(this).find('.btn').toggleClass(
													'btn-primary');
										}
										$(this).find('.btn').toggleClass(
												'btn-default');
									} else {
										//fnOpenNormalDialog();
										var x = confirm("Are you sure you want to deactivate the Employee?");
										if(x == true){
											$
											.ajax({
												url : "/orgchart/activetoggle?userId="
														+ $defaultId
														+ "&status=inactive",
												success : function(result) {
												}
											});
											alert("Deactivated");
										}
										else{
											$(this).find('.btn').toggleClass('active');
											if ($(this).find('.btn-primary').size() > 0) {
												$(this).find('.btn').toggleClass(
														'btn-primary');
											}
											$(this).find('.btn').toggleClass('btn-default');
										}
									
									}

								}
								if ($(this).find('.btn-primary').size() > 0) {
									$(this).find('.btn').toggleClass(
											'btn-primary');
								}
								$(this).find('.btn').toggleClass('btn-default');

							});
			 
			 $('.editbutton').click(
						function() {
							var currentId = $(this).parent().parent();
							$("#userID").val(currentId.attr('id'));
							$("#emailId").val(
									currentId.find('.mainEmailId').html());
							$("#fullName").val(
									currentId.find('.mainFullName').html());
							$("#titleName").val(
									currentId.find('.mainTitle').html());
							$("#officeLocation").val(currentId.find('.mainOfficeLocation').html());
							$("#resourceManager")
									.val(currentId.find('.mainResourceManager').html());
							$("#contactNumber").val(currentId.find('.mainContactNo').html());
							$("#officeContactNumber").val(currentId.find('.mainOfficeContactNo').html());
							/* $("#country").val(currentId.find('.mainCountry').html());
							$("#zipcode").val(currentId.find('.mainZip').html());
							$("#officeContactNo").val(
									currentId.find('.mainOfficeContact').html()); */
							/* 			$("#officeContactNo").val(currentId.find('.mainOfficeContact').val()); */

							/* alert("lolv"+currentId.find(".mainOfficeName").text()); */
						});
		</script>
</body>
</html>
