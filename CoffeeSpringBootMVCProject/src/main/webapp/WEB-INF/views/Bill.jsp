<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
 <link href="css/bill.css" rel="stylesheet">
</head>
<body>
<h4>Coffee Heaven</h4>
<h5>Hello ${customer}</h5>
<div class="table">
	<h3>Your Order Details</h3>
	<table border=1 id="carts">
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

	<h3>Invoice</h3>
<table id="invoice">
	<tr>
		<th>Bill Date</th>
		<td>${bill.billDate }</td>
	</tr>
	<tr>
		<th>Amount</th>
		<td>${bill.amount }</td>
	</tr>
	<tr>
		<th>Discount</th>
		<td>${bill.discount }</td>
	</tr>
	<tr>
		<th>Net Value</th>
		<td>${bill.netValue }</td>
	</tr>
	<tr>
		<th>GST</th>
		<td>${bill.gst }</td>
	</tr>
	<tr>
		<th>Service Tax </th>
		<td>${bill.serviceTax }</td>
	</tr>
	<tr>
		<th>Total Amount</th>
		<td>${bill.totalAmount }</td>
	</tr>	
</table>
</div>
	
<p><b>Thank you! Have a Nice Day!!</b></p>

</body>
</html>