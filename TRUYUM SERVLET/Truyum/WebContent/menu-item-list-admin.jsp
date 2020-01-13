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
<title>Admin</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h1 class="res1">Menu Items</h1>
	<table>
		<tr style="width: 60%">
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${ menuItemList}" var="menuItem">
			<tr style="text-align: center">
				<td>${menuItem.name}</td>
				<td><fmt:setLocale value="en_IN" scope="request" /> <fmt:formatNumber
						value="${menuItem.price}" type="currency" /></td>
				<td><c:if test="${menuItem.active}">Yes</c:if> <c:if
						test="${!menuItem.active}">No</c:if></td>
				<td><fmt:formatDate value="${menuItem.dateOfLaunch}"
						type="date" pattern="dd/MM/yyyy" /></td>
				<td>${menuItem.category}</td>
				<td><c:if test="${menuItem.freeDelivery}">yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td><a href="ShowEditMenuItem?id=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>