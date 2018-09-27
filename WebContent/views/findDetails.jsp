<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> ${status} </h1>
<table border="2">
	<tr>
		<th>Id</th>
		<th>The bike UserName</th>
		<th>The bike Contact Number</th>
		<th>Status</th>
	</tr>
	
		 <c:forEach items="${interestList}" var="i">
             <tr>

	            <td>${i.getId()}</td>
	            <td>${i.getLocation().getUser().getUserName()}</td>
	              <td>${i.getLocation().getUser().getMobileNumber()}</td>
	            <td>${i.getStatus()}</td>
       		 </tr>
    </c:forEach>
</table>
<a href="login.do">logout</a>
</body>
</html>