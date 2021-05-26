<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Book detail</h1>
	<div class="container">
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr>
					<th>NAME</th>
					<th>AUTHOR</th>
					<th>PUBLISHYEAR</th>
					<th>RATING</th>
					<th>IMAGE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${book.name }</td>
					<td>${book.author }</td>
					<td>${book.publishYear }</td>
					<td>${book.rating }/10</td>
					<td><img src="data:image/jpg;base64, ${book.image }" style="width: 50px; height: 50px"> </td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>