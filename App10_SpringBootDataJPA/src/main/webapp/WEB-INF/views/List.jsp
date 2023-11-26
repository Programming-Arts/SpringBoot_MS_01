<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<h1>Person Catalog</h1>
			<br></br>

		</div>
		<div class="col"></div>
	</div>

	<div class="row">
		<div class="col"></div>
		<div class="col">

			<table>
				<thead>
					<th>ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Contact</th>
					<th>Address</th>
					<th>Gender</th>
					<th>Edit</th>
					<th>Delete</th>
				</thead>
				<tbody>
				
				<c:forEach items="${persons}" var="perObj">
				<tr>
				<td>${perObj.personId}</td>
				<td>${perObj.personName}</td>
				<td>${perObj.age}</td>
				<td>${perObj.contact}</td>
				<td>${perObj.address}</td>
				<td>${perObj.gender}</td>
				<td><a  href="http://localhost:7090/getPersonById/${perObj.personId}" >Edit</a>
				<td><a  href="http://localhost:7090/deleteById?perID=${perObj.personId}" >Delete</a>
				
						
				</tr>				
				</c:forEach>
				
				
				</tbody>

			</table>

		</div>
		<div class="col"></div>

	</div>


</body>
</html>