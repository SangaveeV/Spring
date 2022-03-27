<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coffee</title>
</head>
<body>

	<h2>Coffee Menu</h2>
	
	<table border=1>
		<tr>
			<th>Coffee Name</th>
			<th>Size</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${coffeeList }" var="coffee">
			<tr>
				<td>${coffee.coffeeName }</td>
				<td>${coffee.coffeeSize }</td>
				<td>${coffee.price }</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
<spring:form action="./getCoffee" method="post" modelAttribute="coffee">
	Select Coffee Name: <spring:select path="coffeeName">
		<spring:options items="${coffeeName }"/>
	</spring:select>
	<br><br>
	Select Coffee Size: <spring:select path="coffeeSize">
		<spring:options items="${coffeeSize }"/>
	</spring:select>
	<br><br>
	<input type="submit" value="Select Coffee" name="selectCoffee">
	<br><br>
	Continue to Bill &nbsp; &nbsp;
	<input type="submit" value="Check Out" name="checkOut">
	<br><br>
	Do you want to add AddOn? &nbsp;
	<input type="submit" value="Add AddOn" name="addOn">
	<br>
	
</spring:form>
	
<br><br>
<a href="./Last">Cancel</a>
</body>
</html>