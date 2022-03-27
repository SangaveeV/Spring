<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Coffee</title>
   <link href="css/coffee.css" rel="stylesheet">
</head>
<body>
<h4>Coffee Heaven</h4>
<div class="table">
<h3>Coffee Menu</h3>
	<table border=1 id="coffeeList">
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
</div>
	<br>
<div class="coffee">
	<spring:form action="./getCoffee" method="post" modelAttribute="coffee">
	Select Coffee Name &nbsp;: <spring:select path="coffeeName">
		<spring:options items="${coffeeName }"/>
	</spring:select>
	<br>
	Select Coffee Size&nbsp;&nbsp;&nbsp;: &nbsp;<spring:select path="coffeeSize">
		<spring:options items="${coffeeSize }"/>
	</spring:select>
	<br><br>
		<input class="btn" type="submit" value="Select Coffee" name="selectCoffee">
		<input class="btn" type="submit" value="Check Out" name="checkOut">
		<input class="btn" type="submit" value="Add AddOn" name="addOn">
</spring:form>
</div>

</body>
</html>