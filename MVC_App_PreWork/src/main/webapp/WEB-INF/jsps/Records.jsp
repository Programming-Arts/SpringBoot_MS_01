<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<h2>All Records</h2>
			</div>
			<div class="col"></div>
		</div>

		<div class="row">
			<div class="col"></div>

			<div class="col">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Age</th>
							<th scope="col">Email</th>
							<th scope="col">Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.personID}</td>
								<td>${item.personName}</td>
								<td>${item.personAge}</td>
								<td>${item.email}</td>
								<td>${item.contact}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col"></div>
		</div>
		<br></br>



		<div class="row">
			<div class="col"></div>
			<div class="col">
				<h2>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<c:forEach begin="0" end="10" var="i">
								<li class="page-item"><a class="page-link"
									href="http://localhost:7090/mvc/pagination/${i}/10">${i+1}</a></li>

							</c:forEach>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</nav>
				</h2>
			</div>
			<div class="col"></div>
		</div>

	</div>



</body>
</html>