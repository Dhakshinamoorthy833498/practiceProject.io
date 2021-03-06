<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies List Customer</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/moviecruiser-logo.jpg"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1 class="head">Movies</h1>
	<c:if test="${addFavoritesStatus}">
		<div class="success-message">Movie added to Favorites
			Successfully</div>
	</c:if>
	<table>
		<tr>
			<th id="headrow">Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${moviesList}" var="movies">
			<tr style="text-align: center">
				<td id="headrow">${movies.title}</td>
				<td><fmt:formatNumber type="currency" value='${movies.gross}'
						pattern="$###.###" /></td>
				<td>${movies. genre}</td>
				<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
						test="${!movies.hasTeaser}">No</c:if></td>
				<td><a href="AddToFavorites?id=${movies.id}">Add to
						Favorites</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright � 2019</h3>
	</div>
</body>
</html>