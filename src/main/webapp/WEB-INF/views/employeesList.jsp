<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>check routine</h1>
	
	<table border="1">
	
		<tr> 
			<th>Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Date of Birth</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach items="${emp}" var="e">
			<tr>
				<td> ${e.name} </td>
				<td> ${e.gender } </td>
				<td> ${e.department } </td>
				<td> ${e.dob } </td>		
				<td> <a href="${pageContext.request.contextPath}/employee?id=${e.id}">Edit</a> | <a href="${pageContext.request.contextPath}/delete/${e.id}">Delete</a> </td>		
			</tr>
		</c:forEach>
	
	</table>
	
	<button onclick="window.location.href = '${pageContext.request.contextPath}/showEmployeeForm'" >navigate</button>
	
</body>
</html>