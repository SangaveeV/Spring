<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
<h5>Hello ${customer}</h5>
<h3>Your Order Details</h3>
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
	<br><br>
	<h3>Invoice</h3>
<table>
	<tr>
		<td>Bill Date</td>
		<td>:</td>
		<td>${bill.billDate }</td>
	</tr>
	<tr>
		<td>Amount</td>
		<td>:</td>
		<td>${bill.amount }</td>
	</tr>
		<tr>
		<td>Discount</td>
		<td>:</td>
		<td>${bill.discount }</td>
	</tr>
	<tr>
		<td>Net Value</td>
		<td>:</td>
		<td>${bill.netValue }</td>
	</tr>
	<tr>
		<td>GST</td>
		<td>:</td>
		<td>${bill.gst }</td>
	</tr>
	<tr>
		<td>Service Tax </td>
		<td>:</td>
		<td>${bill.serviceTax }</td>
	</tr>
		<tr>
		<td>Total Amount</td>
		<td>:</td>
		<td>${bill.totalAmount }</td>
	</tr>	
</table>

<h5>Thank you! Have a Nice Day!!</h5>

</body>
</html>