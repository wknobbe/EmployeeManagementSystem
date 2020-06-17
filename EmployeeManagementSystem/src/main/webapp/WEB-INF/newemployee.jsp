<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee Form</title>
</head>
<body>
	<div class="container">
		<h1>Enter A New Employee</h1>
		<form:form action="/employee/create" method="post" modelAttribute="employee">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="yearsofservice">Years of Service</form:label>
				<form:errors path="yearsofservice"/>
				<form:input path="yearsofservice"/>
			</p>
			<p>
				<form:label path="role">Role</form:label>
				<form:errors path="role"/>
				<form:input path="role"/>
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>