<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoffeeShop</title>
    <link href="css/customer.css"
        rel="stylesheet">
</head>
<body>
<h1>Welcome to Coffee Heaven</h1>
<br>
<h4>A Lot Can Happen Over Coffee!</h4>
<div class="customerPhone">

	<spring:form method="post" action="./orderCoffee" modelAttribute="customer">
	<div class="input">
	 Enter Phone Number : <spring:input path="phone" placeholder="phone number" />
	</div>
	
		<br><br>
		<div class="btnPos">
			 <input class="btn" type="submit" value="Check Customer">
		</div>
	
</spring:form>
</div>


</body>
</html>