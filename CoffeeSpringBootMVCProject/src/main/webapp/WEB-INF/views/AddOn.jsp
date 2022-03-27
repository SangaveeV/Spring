<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddOn</title>
  <link href="css/addon.css" rel="stylesheet">
</head>
<body>
<h4>Coffee Heaven</h4>
<div class="coffee">
	<b>Selected Coffee</b>
	<br>
	Coffee Name :&nbsp; ${coffeeName }
	<br>
	Coffee Size &nbsp;&nbsp;: &nbsp;${coffeeSize }
</div>
<div class="table">
<h5>Add On Menu</h5>
<table id="addonList">
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
</div>
<div class="addon">
<spring:form action="./getAddOn" method="post" modelAttribute="addOn">
	Select AddOns: <spring:select path="addOnName">
		<spring:options items="${addOnName }"/>
	</spring:select>
	<br><br>
	<input  class="btn" type="submit" value="Select Add On" name="anotherAddOn">
	<input  class="btn" type="submit" value="Order Coffee" name="coffeeOrder">
	<input  class="btn" type="submit" value="Check Out" name="addOnCheckOut">
	
</spring:form>

</div>
</body>
</html>