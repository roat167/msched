<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<div style="margin: 0 auto; width: 300px">
		<br /> <br />
<br>
<span class="PageTitle">&nbsp; Login</span>
		<br /> <br />
		<form action="/login" method="post">
			<div>
				<label for="username">UserName</label> <input class="form-control" type="text"
					name="username" id="username" required autofocus>
			</div>
			<br />
			<div>
				<label for="password">Password</label> <input class="form-control" type="password"
					name="password" id="password" required>
			</div>
			<br />
			<input type="hidden"       
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
			<div class="row">				
				<button class="btn btn-default" style="margin-left: 118px" type="submit">Sign in</button>
				<!-- | 
				 <a class="btn btn-default" href="/signUp" style="background-color: orange; color:#ffffff">New User.? SignUp</a> -->
				
			</div>
		</form>
		
		</div>

</body>
</html>