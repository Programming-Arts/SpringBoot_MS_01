<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
</head>
<body>
	<h1>Registration Updation</h1>

	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				
				<form:form action="/update" method="post" modelAttribute="regDetails">
				
				<form:hidden  path="personID" />
				<table>
				<tr>
				<td><label>Name:</label></td>
				<td><form:input type="text" path="personName" /></td>
				</tr>
				
				<tr>
				<td><label>Contact:</label></td>
				<td><form:input type="text" path="contact" /></td>
				</tr>
				
				<tr>
				<td><label>Age:</label>
						</td>
				<td><form:input type="text" path="personAge" /></td>
				</tr>
				
				<tr>
				<td><label>Email:</label>
						</td>
				<td><form:input type="text" path="email" /></td>
				</tr>
				<tr>
				<td></td>
				<td><button>Submit</button></td>
				</tr>
				
				</table>
				</form:form>

				

				
			</div>
			<div class="col"></div>

		</div>

	</div>
</body>
</html>