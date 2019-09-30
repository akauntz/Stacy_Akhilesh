<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Payment</title>
</head>
<body>
	<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">
	    <table border = "1" width="300">
   			<tr>
		  		<td><form:label path="cardHolder">Card Holder</form:label></td> 
				<td><form:input path="cardHolder" /></td>
			</tr>
    		<tr> 
    			<td><form:label path="creditCardNumber">Credit Card Number</form:label></td>   	
				<td><form:input path="creditCardNumber" /></td>
			</tr>
			<tr>
			    <td><form:label path="expirationDate">Expiration Date</form:label></td>   	
				<td><form:input path="expirationDate" /></td>
			</tr>
			<tr>
		  		<td><form:label path="cvvCode">Cvv Code</form:label></td> 
				<td><form:input path="cvvCode" /></td>
			</tr>
			<tr>
				<input type="submit" value="Submit">
			</tr>
		</table>
	</form:form>

</body>
