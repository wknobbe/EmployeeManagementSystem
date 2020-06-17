<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Employees</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Employee Id</th>
					<th>Department</th>
					<th>Role</th>
					<th>Years of Service</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.name}"/></td>
						<td><c:out value="${employee.employeeid}"/></td>
						<td><c:out value="${employee.department}"/></td>
						<td><c:out value="${employee.role}"/></td>
						<td><c:out value="${employee.yearsofservice}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>