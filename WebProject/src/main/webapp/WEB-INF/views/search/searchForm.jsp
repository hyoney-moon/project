<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
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
header {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	hegiht: 70px;
	padding: 2px;
	background: white;
	align-items: center;
}

body {
	padding-top: 70px
}
</style>
</head>
<body>
	<header>
		<div class="postion-relateive mt-5">
			<h3 class="position-absolute d-inline top-50 start-50 translate-middle">로고</h3>
			<nav class="position-absolute top-50 end-0 translate-middle-y"> 메뉴바 검색</nav>
		</div>
	</header>
	<div class="container">
	<form action="searchBoard" method="post">
		<div class="row g-3">
  		<div class="col">
		<input type="text" class="form-control" placeholder="First name" aria-label="First name">
		</div>
		<div class="col">
 		<input type="text" class="form-control" placeholder="Last name" aria-label="Last name">
		</div>
		</div>
			<select class="form-select form-select-lg mb-3 w-25" aria-label=".form-select-lg example">
				<option selected>Open this select menu</option>
				<option value="1">공간명</option>
				<option value="2">카테고리</option>
				<option value="3">지역별</option>
			</select>
			<input class="form-control form-control-lg" type="text" placeholder=".form-control-lg" aria-label=".form-control-lg example">
	</form>
	</div>
</body>
</html>