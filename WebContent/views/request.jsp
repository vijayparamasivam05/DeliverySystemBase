<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RequestList</title>
</head>
<body>
<table border="2">
 <tr>
 	<th>UserName</th>
 	<th>Contact Number</th>
 	<th>Options</th>
 </tr>
 <tr>
 	<c:forEach items="${list}" var="u">
             <tr>
	            <td>${u.getInterest().getUser().getUserName()}</td>
	            <td>${u.getInterest().getUser().getMobileNumber()}</td>
	            <td><form action="accept.do"><input type="submit" value="Accept"></form></td>
 				<td><form action="deny.do"><input type="submit" value="Deny"></form></td>
       		 </tr>
    </c:forEach> 	
 </tr>
</table>
<a href="login.do">logout</a>
</body>
</html>