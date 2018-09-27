<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<form action="loginCheck.do">
	<input type="text" name="un" placeholder="Enter Username">
	<input type="password" name="pw" placeholder="Enter Password">
	<input type="submit" value="Login">
	<p>Don't you have account?<a href="sign.do">Click here to signup....</a></p>
</form>
</body>
</html>