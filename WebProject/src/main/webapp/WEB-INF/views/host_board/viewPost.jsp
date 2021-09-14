<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<style>
body {background-color: black;}
.list_item {
    display: inline-block;
    width: 800px;
    margin: 2px;
    overflow: hidden;
}

.list_img {
    display: inline-block;
    width: 100%;
    height: 400px;
    overflow: hidden;
    object-fit: cover;
}
</style>
</head>
<body>
<div class="container">
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner list_item">
				<c:forEach items="${fis }" var="fis" begin="0" end="0">
				<div class="carousel-item active">
					<img src="${fis.filePath }" class="d-block w-500 list_img"
						alt="...">
				</div>
				</c:forEach>
				<c:forEach items="${fis }" var="fis" begin="1" end="${fisize }">
				<div class="carousel-item">
					<img src="${fis.filePath }" class="d-block w-500 list_img"
						alt="...">
				</div>
				</c:forEach>
			</div>
			
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
</div>
</body>
</html>