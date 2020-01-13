<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script src="js/script.js"></script>
<title>Cart</title>
</head>
<body>
	<div>MenuItem</div>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<c:if test="${deleteCartStatus}">
		<h2 class="t1">Item deleted from cart successfully</h2>
	</c:if>
	<h1 class="res1">Menu Items</h1>
	<table>
		<tr style="width: 60%">
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr style="text-align: center">

				<td>${menuItem.name}</td>
				<td><c:if test="${menuItem.freeDelivery}">yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td><fmt:setLocale value="en_IN" scope="request" /> <fmt:formatNumber
						value="${menuItem.price}" type="currency" /></td>
				<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>Total</td>
			<td><fmt:setLocale value="en_IN" scope="request" /> <fmt:formatNumber
					value="${cart.total}" type="currency" /></td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>