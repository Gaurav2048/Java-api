<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/save" modelAttribute="employee">
	
		Enter Name: <form:input path="name"/> <br/>
		Select Gender: <form:radiobutton path="gender" value="male"/>Male &nbsp;
					   <form:radiobutton path="gender" value="female"/> Female					 
		<br>
		Select Delartment : <form:select path="department">
			<form:option value="Development4">Development4</form:option>
			<form:option value="Development3">Development3</form:option>
   			<form:option value="Development2">Development2</form:option>
			<form:option value="Development1">Development1</form:option>
		</form:select> <br>
		Date of Birth: <form:input path="dob" type="date" />	<br/>
		<form:hidden path="id" />
		<button type="submit"  >Submit</button>
	</form:form>
	
</body>
</html>