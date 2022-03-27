<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Customer Name</title>
</head>
<body>
<h1>Welcome to AAA Coffee Shop</h1>
<h2>${greet } !</h2>
<h4>${message }!!</h4>
<spring:form method="post" action="./getCustomer" modelAttribute="customer">
 Phone Number : <spring:input path="phone" readonly="true" />
 <br><br>
 Customer Name : <spring:input path="customerName" />
		<br><br>
 <input type="submit" value="Add Customer">
</spring:form>

</body>
</html>