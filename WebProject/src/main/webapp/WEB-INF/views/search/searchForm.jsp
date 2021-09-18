<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
body {
	padding-top: 40px;
}
.headText{
	padding: 50px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<%@ include file = "../publicCSS/custheader.jsp" %>
	</header>

	<div class="container">
		<form action="searchBoard" method="post">
			<!-- <div class="row g-3">
				<div class="col">
					<input type="text" class="form-control" placeholder="First name"
						aria-label="First name">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Last name"
						aria-label="Last name">
				</div>
			</div> -->
			<select name="search_option"
				class="form-select form-select-lg mb-3 w-25"
				aria-label=".form-select-lg example">
				<option selected value="0">Select</option>
				<option value="1">공간명</option>
				<option value="2">카테고리</option>
				<option value="3">지역별</option>
			</select>
			<input name="search" class="form-control form-control-lg" type="text" placeholder="검색어를 입력하세요."
				aria-label=".form-control-lg example">
				<input type="submit" value="검 색"><br>
		<c:forEach items="${boardList }" var="boardlist">
			${boardlist.hostId } / ${boardlist.category } / ${boardlist.spaceName }<br>
		</c:forEach>
		</form>
		<section>
		<%@ include file = "../custmain/boardList.jsp" %>
		</section>
		
	</div>
</body>
</html>