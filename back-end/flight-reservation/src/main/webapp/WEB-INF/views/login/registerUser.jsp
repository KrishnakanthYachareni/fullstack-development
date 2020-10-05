<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/registerUser"
		method="post">
		<pre>
		<h2>User Registration:</h2>
		First Name: <input type="text" name="firstName" /> 
		Last Name: <input type="text" name="LastName" />
		User Name: <input type="text" name="email" />
		Password: <input type="password" name="password" />
		Confirm Password: <input type="password" name="confirmPassword" />
		<input type="submit" value="register" />
		</pre>
	</form>
</body>
</html>