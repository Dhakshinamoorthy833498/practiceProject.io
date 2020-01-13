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
<title>Edit Menu Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
		name="menuItemForm" method="post">
		<h2>edit menu item</h2>
		<div class="body-content-color">
			<div class="form-field-spacing">
				<label for="name">Name</label> <input type="text"
					class="text-box text-box-title" name="name" id="name"
					value="${menuItem.name}">
			</div>
			<div class="form-field-spacing">
				<label for="price">Price(Rs.)</label> <input type="text"
					class="text-box" name="price" id="price" value="${menuItem.price}">
			</div>
			<div class="form-field-spacing">
				<label for="inStock">Active</label>
				<div>
					Yes<input type="radio" name="active" value="yes"
						<c:if test="${menuItem.active eq 'true'}">Checked</c:if>>
					No<input type="radio" name="active" value="no"
						<c:if test="${menuItem.active eq 'false'}">Checked</c:if>>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Launch</label> <input type="text"
					class="text-name" name="dateOfLaunch"
					value=<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}"/>>
			</div>
			<div class="form-field-spacing">
				<label for="category">Category</label> <select name="category"
					class="dropdown">
					<option value="${menuItem.category}">${menuItem.category}</option>
					<option value="starters">Starters</option>
					<option value="main course">Main Course</option>
					<option value="dessert">Dessert</option>
					<option value="drinks">Drinks</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<label for="freeDelivery">Free Delivery</label>
				<div>
					<input type="checkbox" name="freeDelivery"
						<c:if test="${menuItem.freeDelivery eq 'true'}">Checked</c:if>
						<c:if test="${menuItem.freeDelivery eq 'false'}"></c:if>>
				</div>
			</div>
		</div>
		<div>
			<input type="hidden" name="id" value="${menuItem.id}">
		</div>
		<div>
			<input type="submit" class="button success-button" value="save">
		</div>
	</form>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>