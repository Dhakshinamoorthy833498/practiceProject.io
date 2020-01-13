<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script src="js/script.js" type="text/javascript"></script>

<title>Cart Empty</title>
</head>
<body>
	<div>
		<div class="topnav">
			<div class="home">truyum</div>
			<img src="images/truyum-logo-dark.png"> <a href="ShowCart">Cart</a>
			<a href="ShowMenuItemListCustomer">Menu</a>
		</div>
		<div>
			<h1>Cart</h1>
			<h2 class="">
				No items in Cart.Use 'Add to Cart' in <a
					href="ShowMenuItemListCustomer">MenuItemList</a>
			</h2>
		</div>
		<div class="footer">
			<h3>Copyright © 2019</h3>
		</div>
	</div>
</body>
</html>