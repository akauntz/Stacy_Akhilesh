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
<title>Order Confirmation</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<form:form method="post" action="confirmOrder" class="text-center">
<h4 class="text-center">
    <%
    Order order = (Order) request.getSession().getAttribute("order");
    for(Item item : order.getItems()) {
    	if (!item.getQuantity().equals("")){
    		out.println(item.getName() + "\n");
    		out.println(item.getQuantity() + "\n");
    	}
    }
    %>
</h4>
 <br />  <br />
 	<div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Confirm Order"></div>
     <h5 class="text-center">Please click on Confirm Order to confirm your order. Order once placed cannot be cancelled.</h5>
     
</form:form>
<jsp:include page="Footer.jsp"/>
</body>
</html>