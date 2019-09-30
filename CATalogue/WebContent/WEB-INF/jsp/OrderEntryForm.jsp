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
<form:form modelAttribute="order" method="post" action="purchase/submitItems">

    <table border = "1" width="400">
	    <th>Available Items for Purchase</th>
	    <th>Price</th>
	    <th>Quantity</th>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].price" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="3"><input type="submit" value="Purchase"></td>
	  </tr>
	

    </table>
</form:form>

</body>
</html>