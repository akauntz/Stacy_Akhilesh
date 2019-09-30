<%@ page import="edu.osu.cse5234.model.Order" %>
<%@ page import="edu.osu.cse5234.model.Item" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="confirmOrder">

    <%
    Order order = (Order) request.getSession().getAttribute("order");
    for(Item item : order.getItems()) {
    	out.println(item.getName() + "\n");
    	out.println(item.getQuantity() + "\n");
    }
    %>
    		<td colspan="3"><input type="submit" value="Confirm Order"></td>
    
</form:form>

</body>
</html>