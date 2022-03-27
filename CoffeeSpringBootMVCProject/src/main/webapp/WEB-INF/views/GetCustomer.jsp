<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Customer Name</title>
    <link href="css/getCustomer.css" rel="stylesheet">
</head>
<body>
<h1>Coffee Heaven</h1>
<h2>${greet } !</h2>
<h4>${message }!!</h4>

<div class="customerPhone">
<spring:form method="post" action="./getCustomer" modelAttribute="customer">
 	Phone Number &nbsp; : &nbsp;<spring:input path="phone" readonly="true" />
 	<br>
 	Customer Name : <spring:input path="customerName" />
		<br><br>
	<div class="btnPos">
 		<input class="btn" type="submit" value="Add Customer">
 	</div>
</spring:form>
</div>


</body>
</html>