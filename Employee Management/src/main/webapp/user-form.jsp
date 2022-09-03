<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="user-list.jsp" class="navbar-brand">Employee Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post" enctype="mutlipart/form-data">
				</c:if>

				<caption>
					<h3>
						<c:if test="${user != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${user == null}">
            			Add New Employee
            		</c:if>
					</h3>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				
				<div class="row">
				<div class="col">
				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${user.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>
					</div>
					<div class="col">
					<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${user.lname}' />" class="form-control"
						name="lname">
				</fieldset>
					</div>
				</div>
				<fieldset class="form-group">
					<label>Salary</label> <input type="text"
						value="<c:out value='${user.salary}' />" class="form-control"
						name="salary">
				</fieldset>
				<div class="row">
				<div class="col">
				<fieldset class="form-group">
					<label>Department</label> <input type="text"
						value="<c:out value='${user.department}' />" class="form-control"
						name="department">
				</fieldset>
				</div>
				<div class="col">
			   <fieldset class="form-group">
					<label>Position</label> <input type="text"
						value="<c:out value='${user.position}' />" class="form-control"
						name="position">
				</fieldset>
				</div>
				</div>
				<fieldset class="form-group">
					<label>User Email</label> <input type="email"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>
					
				<fieldset class="form-group">
					<label>Mob no</label>
					<input type="text" name="mobno" pattern="[7-9]{1}[0-9]{9}" 
       				title="Phone number should start with 7-9 and remaing 9 digit with 0-9" value="<c:out value='${user.mobno}' />" 
       				class="form-control">						
					 
				</fieldset>
				
				
				
				<div class="container text-center" style="padding: 10px;">
				<button type="submit" class="btn btn-outline-success">Save</button>
				<input class="btn btn-outline-danger" type="reset" value="Reset">
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>
