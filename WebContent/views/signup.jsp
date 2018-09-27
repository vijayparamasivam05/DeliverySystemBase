<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
<h1>${status}</h1>
<form action="signup.do">
	<input type="text" name="un" placeholder="Enter Username">
	<input type="password" name="pw" placeholder="Enter Password">
	<input type="text" name="mn" placeholder="Enter Mobile Number">
	<input type="submit" value="SignUp">
	<p>Already an user?<a href="login.do">Click here to login....</a></p>
</form>
</body>
</html>