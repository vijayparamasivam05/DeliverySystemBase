<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>offer</title>
</head>
<body>
<form action="insert.do">
	<input type="text" name="src" placeholder="Enter source">
	<input type="text" name="des" placeholder="Enter destination">
	<input type="submit" value="Offer">
</form>
<h1> ${status} </h1>
<form action="request.do">
<input type="submit" value="Request bookings">
</form>
<a href="login.do">logout</a>
</body>
</html>