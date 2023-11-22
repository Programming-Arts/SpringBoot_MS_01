<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Records</h1>

	<div class="row">

		<div class="col"></div>
		<div class="col">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Age</th>
						<th scope="col">Contact</th>
						<th scope="col">Email</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${detailsList}" var="detail">
						<tr>
							<td>${detail.personID}</td>
							<td>${detail.personName}</td>
							<td>${detail.personAge}</td>
							<td>${detail.contact}</td>
							<td>${detail.email}</td>
							<td><a href="http://localhost:7090/getDetails/${detail.personID}">See Details</a></td>
							<td><a href="http://localhost:7090/deleteById/${detail.personID}">Delete/Remove</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="col"></div>
	</div>

</body>
</html>
