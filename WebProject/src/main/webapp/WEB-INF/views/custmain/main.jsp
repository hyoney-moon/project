<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.headText{
	padding: 50px;
	text-align: center;
}
</style>
</head>
<!-- Wrapper -->
<div class="container">
	<div id="wrapper">
	<!-- 헤더영역 -->
	<header>
	<%@ include file = "../publicCSS/custheader.jsp" %>
	</header>
		<h3 class="headText">
			안녕하세요 <strong>우리들의 공간</strong>여러분들의 필요 공간을 제공하고 있습니다.
		</h3>

		<!-- Main카테고리 -->
		<section class="thumbnails">
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/01.jpg"> <img src="images/thumbs/01.jpg"
					alt="" />
				</a>
				<!-- 상세페이지 넘어가는 페이지 -->
				<a href="images/fulls/02.jpg"> <img src="images/thumbs/02.jpg"
					alt="" />
				</a>
				<!-- 상세페이지 넘어가는 페이지 -->
				<a href="images/fulls/02.jpg"> <img src="images/thumbs/02.jpg"
					alt="" />
				</a>
			</div>
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/03.jpg"> <img src="images/thumbs/03.jpg"
					alt="" />
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/04.jpg"> <img src="images/thumbs/04.jpg"
					alt="" />
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/05.jpg"> <img src="images/thumbs/05.jpg"
					alt="" />
				</a>
			</div>
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/06.jpg"> <img src="images/thumbs/06.jpg"
					alt="" />
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/07.jpg"> <img src="images/thumbs/07.jpg"
					alt="" />
				</a>
				<!-- 상세페이지 넘어가는 페이지 -->
				<a href="images/fulls/02.jpg"> <img src="images/thumbs/02.jpg"
					alt="" />
				</a>
			</div>
		</section>
		<!-- 메인 공간이미지  -->
		<hr>
		<h1>오늘의 추천공간</h1>
		<br>
		<h3>오늘만 추천합니다.</h3>
		<hr>
		<section class="thumbnails">
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/01.jpg"> <img src="images/thumbs/01.jpg"
					alt="" />
					<h3>첫번째 상세페이지로 넘어가는 페이지</h3>
				</a>
				<!-- 상세페이지 넘어가는 페이지 -->
				<a href="images/fulls/02.jpg"> <img src="images/thumbs/02.jpg"
					alt="" />
					<h3>두번째 상세페이지로 넘어가는 페이지</h3>
				</a>
			</div>
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/03.jpg"> <img src="images/thumbs/03.jpg"
					alt="" />
					<h3>세번째 상세페이지로 넘어가는 페이지</h3>
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/04.jpg"> <img src="images/thumbs/04.jpg"
					alt="" />
					<h3>네번째 상세페이지로 넘어가는 페이지</h3>
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/05.jpg"> <img src="images/thumbs/05.jpg"
					alt="" />
					<h3>다섯번째 상세페이지로 넘어가는 페이지</h3>
				</a>
			</div>
			<div>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/06.jpg"> <img src="images/thumbs/06.jpg"
					alt="" />
					<h3>여섯번째 상세페이지로 넘어가는 페이지</h3>
				</a>
				<!-- 상세페이지로 넘어가는 페이지 -->
				<a href="images/fulls/07.jpg"> <img src="images/thumbs/07.jpg"
					alt="" />
					<h3>일곱번째 상세페이지로 넘어가는 페이지</h3>
				</a>
			</div>
		</section>
	</div>
	<!-- 하단 정보 공유창 -->
	<footer id="footer">
		<p id="text">
			&copy; 이곳에 회사정보 등을 입력 해두면된다.: <a href="http://templated.co">TEMPLATED</a>
			503_프로젝트 반짝반짝: <a href="http://unsplash.com"></a>.
		</p>
	</footer>


	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.poptrox.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/main.js"></script>
</div>
</body>
</html>