<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact us</title>
</head>
<body>
<jsp:include page="Header.jsp"/>

<h2 class="text-center">Contact Us!</h2><br />
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-4"></div>
		<div class="col-xs-4">
			<div class="jumbotron">
				<form action="mailto:bhimani.8@osu.edu">
				  <div class="form-group">
				    <label for="email">Email address:</label>
				    <input type="email" class="form-control" id="email">
				  </div>
				  <div class="form-group">
				    <label for="name">Name:</label>
				    <input type="text" class="form-control" id="name">
				  </div>
				  <div class="form-group">
				    <label for="msg">Message:</label>
				    <textarea rows=10 class="form-control" id="msg"></textarea>
				  </div>
				  <div class="text-center">
				  <button type="submit" class="btn btn-default">Submit</button></div>
				</form>	
			</div>
		</div>
		<div class="col-xs-4"></div>
	</div>
</div>
<jsp:include page="Footer.jsp"/>

</body>
</html>