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
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col">
		
		<div></div>
		</div>
		<div class="col">
		<h1>Search Functionality</h1><br></br>
		
		
		<div>
		
		<form:form>
		Name: <form:input type="text"  path="personName"/> <br></br>
		<button>Search By Name</button>
		</form:form>
		
		
		</div>
		
		
		<form:form  modelAttribute="regDetails">

		<div>
			<label>Name:</label>
			<form:input type="text" path="personName" />
		</div>

		<div>
			<label>Contact:</label>
			<form:input type="text" path="contact" />
		</div>
		<div>
			<label>Age:</label>
			<form:input type="text" path="personAge" />

		</div>
		<div>
			<label>Email:</label>
			<form:input type="text" path="email" />
		</div>
		<div>
			<button>Click Here</button>
		</div>
	</form:form>
		
		</div>
		<div class="col"></div>

	</div>


</body>
</html>