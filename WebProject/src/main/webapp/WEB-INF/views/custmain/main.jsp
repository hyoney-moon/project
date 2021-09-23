<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>space 공간 얍얍</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
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
body {
	padding-top: 40px;
}

img {
	position: relative;
}

div.zIndex {
	position: absolute;
	top: 25%;
	right: 10%;
}

h2.maintext {
	text-align: right;
}

table {
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: white;
	width: 150px;
}

table a {
	margin: 10px auto;
}
</style>
</head>
<!-- Wrapper -->
<div class="container">
	<!-- 헤더영역 -->
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>
	<main>
		<img class="z w-100" src="../images/mainImg/custmainimgs.jpg" />
		<div class="zIndex">
			<h2 class="maintext">
				우리들의 공간 <br> <strong>Bang Bang</strong><br> 여러분들의 필요 공간을 <br>제공하고
				있습니다.
			</h2>
		</div>
		<h2>오늘의 추천 공간</h2>
		<div class="card-group">
			<div class="card">
				<img src="${bList.frontImg }" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">공간이름</h5>
					<p class="card-text">한줄소개</p>
				</div>
			</div>
			<div class="card">
				<img src="${bList.frontImg }" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">공간이름</h5>
					<p class="card-text">한줄소개</p>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">공간이름</h5>
					<p class="card-text">한줄소개</p>
				</div>
			</div>
		</div>
	</main>
</div>
<footer>
	<%@ include file="../publicCSS/footer.jsp"%>
</footer>
</body>
</html>