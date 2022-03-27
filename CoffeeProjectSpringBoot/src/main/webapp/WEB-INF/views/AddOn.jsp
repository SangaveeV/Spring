<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddOn</title>
</head>
<body>
Selected Coffee
<br>
Coffee Name : ${coffeeName }
<br>
Coffee Size : ${coffeeSize }

<h4>Add On Menu</h4>

<table>
	<tr>
		<th>AddOn Name</th>
		<th>Price</th>
	</tr>
	<c:forEach items="${addOnList }" var="addOn">
		<tr>
			<td>${addOn.addOnName }</td>
			<td>${addOn.price }</td>
		</tr>
	</c:forEach>
</table>

<spring:form action="./getAddOn" method="post" modelAttribute="addOn">
	Select AddOns: <spring:select path="addOnName">
		<spring:options items="${addOnName }"/>
	</spring:select>
	<br><br>
	<input type="submit" value="Select Add On" name="anotherAddOn">
	<br><br>
	Do you want to buy another coffee?  
	<input type="submit" value="Order Coffee" name="coffeeOrder">
	<br> <br>
	Proceed to Billing
	<input type="submit" value="Check Out" name="addOnCheckOut">
	<br>
	
</spring:form>


</body>
</html>