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
Order #1234 Confirmed!
Order Items:
    <%
    Order order = (Order) request.getSession().getAttribute("order");
    for(Item item : order.getItems()) {
    	out.println(item.getName() + "\n");
    	out.println(item.getQuantity() + "\n");
    }
    %>    
</body>
</html>