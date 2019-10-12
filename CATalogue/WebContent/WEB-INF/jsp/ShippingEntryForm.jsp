<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Details</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
	<form:form modelAttribute="shippingInfo" method="post" action="submitShipping">
		<div class="container">
<h3 class="text-center">Enter Shipping Address</h3><br /><br />
<div class="row">
<div class="col-xs-4"></div>
<div class="col-xs-4">
	    <table class="table table-striped table-bordered" style="font-size: 15px">
    		<tr> 
    			<td><form:label path="name">Name</form:label></td>   	
				<td><form:input path="name" /></td>
			</tr>
			<tr>
			    <td><form:label path="addressLine1">Address Line One</form:label></td>   	
				<td><form:input path="addressLine1" /></td>
			</tr>
			<tr>
		  		<td><form:label path="addressLine2">Address Line Two</form:label></td> 
				<td><form:input path="addressLine2" /></td>
			</tr>
			<tr>
			    <td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
			    <td><form:label path="state">State</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td><form:label path="zip">Zip Code</form:label></td>
				<td><form:input path="zip" /></td>
			</tr>

		</table>
		</div>
<div class="col-xs-4"></div>
</div>
</div>
    <br />
		<div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Submit"></div>
		
	</form:form>
<jsp:include page="Footer.jsp"/>
</body>
