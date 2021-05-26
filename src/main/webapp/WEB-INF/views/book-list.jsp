<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header" style="height: 100px; width: 100%; color: blue">
		<h1>readANYbook.com</h1>
	</div>
	<div class="container">
		<div class="col-lg-9 col-md-9 col-sm-9 col-9">
			<c:forEach var="b" items="${books}">
				<div class="col-lg-4 col-md-6 col-sm-6 col-6">
					<div class="col-lg-6 col-md-8 col-sm-8 col-8">
						<img alt="a" src="data:image/jpg;base64, ${b.image}"
							style="width: 100% ; height: 300px">
					</div>
					<div class="col-lg-6 col-md-4 col-sm-4 col-4">
						<p><strong>${b.name } </strong></p>
						<p><strong>${b.author } </strong></p>
						<p><strong>${b.publishYear } </strong></p>
						<p><strong>${b.rating } /10</strong></p>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-3">
			<h5>Link</h5>
			<h5><a href="add">Add</a> </h5>
			<h5><a href="manager">Manager</a> </h5>
			<h5><a href="list">List book</a> </h5>
			<h5>@Copyright LaiVanVuong</h5>
		</div>
	</div>
</body>
</html>