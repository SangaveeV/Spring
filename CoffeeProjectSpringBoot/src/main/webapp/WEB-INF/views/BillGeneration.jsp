<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
</head>
<body>
<h5>Cart</h5>
	<table border=1>
		<tr>
			<th>Item Name</th>
			<th>Size</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${billCoffeeList }" var="coffee">
			<tr>
				<td>${coffee.coffeeName }</td>
				<td>${coffee.coffeeSize }</td>
				<td>${coffee.price }</td>
			</tr>
		</c:forEach>
		<c:forEach items="${billAddOnList }" var="addOn">
		<tr>
			<td>${addOn.addOnName }</td>
			<td></td>
			<td>${addOn.price }</td>
		</tr>
	</c:forEach>
	</table>
	<br>

<form action="./getBill" method="post">
	Do you have any Discount Voucher:
	 <input type="text" name="voucher"> 
	<br><br>
	Proceed to Bill &nbsp; &nbsp;
	<input type="submit" value="Check Out" name="displayBill">
	<br> <br>
	
</form>

</body>
</html>