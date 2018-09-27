<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>find</title>
</head>
<body>
<form action="search.do">
	<input type="text" name="src" placeholder="Enter source">
	<input type="text" name="des" placeholder="Enter destination">
	<input type="submit" value="Find">
</form>
<h1> ${status} </h1>
<table border="2">
	<tr>
		<th>UserName</th>
		<th>Contact Number</th>
		<th>From</th>
		<th>To</th>
		<th>Request</th>
	</tr>
	
		 <c:forEach items="${list}" var="l">
             <tr>
	            <td>${l.getUser().getUserName()}</td>
	            <td>${l.getUser().getMobileNumber()}</td>
	            <td>${l.getSource()}</td>
	            <td>${l.getDestination()}</td>
	            <td>
	            <form action="view.do">
	            	<input type="hidden" name="userId" value="${l.getUser().getId()}" >
	            	<input type="submit" value="I am Interested">
	            </form>
	            </td>
       		 </tr>
    </c:forEach>
</table>
	
<form action="mybooking.do">
	<input type="submit" value="My bookings">
</form>
<a href="login.do">logout</a>
</body>
</html>