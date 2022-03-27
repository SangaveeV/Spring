<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoffeeShop</title>
</head>
<body>
<h1>Welcome to AAA Coffee Shop</h1>

<spring:form method="post" action="./orderCoffee" modelAttribute="customer">
 Enter Phone Number : <spring:input path="phone" />
		<br><br>
 <input type="submit" value="CheckCustomer">
</spring:form>

</body>
</html>