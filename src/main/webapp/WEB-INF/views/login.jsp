<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	
	
<div class="container">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">
			
			<form:form modelAttribute="user" method="post"  class="form-horizontal" >
			
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							
				  <form:input path="username" type="text" class="form-control" placeholder="username or email"/>
				  
				</div>
				
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
						
				  <form:input path="password" type="password" class="form-control" placeholder="password"/>
							
				</div>
				
				<c:if error!=null >
   					   ${error}
				</c:if>


				<div style="margin-top: 10px" class="form-group" align='center'>
						<!-- Button -->

						<div class="col-sm-12 controls">
							<form:button  type='success' class="btn btn-success">Login </form:button>
						</div>
				</div>

				</form:form>
		</div>
		</div>
	</div>
</div>
	
	
</body>
</html>