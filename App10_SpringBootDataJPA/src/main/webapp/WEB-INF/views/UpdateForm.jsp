<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
	<div class="row">
		<div class="col"></div>
		<div class="col">
			<h1>Update Form</h1>
			<br></br>

		</div>
		<div class="col"></div>
	</div>

	<div class="row">
		<div class="col"></div>
		<div class="col">
			<h2>Update Application</h2>
			<br></br>

			<form:form   action="/updateInfo"  method="post"   modelAttribute="personDetails">
				
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>ID</label>
						<form:input path="personId" />
					</div>
					<div class="col"></div>
				</div>
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>Name</label>
						<form:input path="personName" />
					</div>
					<div class="col"></div>
				</div>
				
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>Age</label>
						<form:input path="age" />
					</div>
					<div class="col"></div>
				</div>
				
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>Contact</label>
						<form:input path="contact" />
					</div>
					<div class="col"></div>
				</div>
				
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>Gender</label>
						<form:input path="gender" />
					</div>
					<div class="col"></div>
				</div>
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<label>Address</label>
						<form:input path="address" />
					</div>
					<div class="col"></div>
				</div>
				<br></br>
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<button class="btn btn-primary"> Update</button>
					</div>
					<div class="col"></div>
				</div>
			</form:form>




		</div>
		<div class="col"></div>

	</div>


</body>
</html>