<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
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
		<!-- Main카테고리1번줄 -->
		<section class="thumbnails">
			<div>
				<c:forEach items="${category}" var="cate" begin="0" end="1">
					<a href="/bookingpage/${cate.category}"> <img
						src="images/thumbs/02.jpg" alt="" />
						<h3>${cate.category}</h3>
					</a>

<<<<<<< HEAD
				<!-- Main카테고리1번줄 -->
				<section class="thumbnails">
								<div >
								<c:forEach items="${category}" var="cate" begin="0" end="1">
									<a href="/bookingpage/${cate.category}">
										<img src="images/thumbs/02.jpg" alt="" />
										<h3>${cate.category}</h3>
									</a>
									
								</c:forEach>
								</div>
								<!-- Main카테고리2번줄 -->
									<div >
								<c:forEach items="${category}" var="cate" begin="2" end="4">
									<a href="/bookingpage/${cate.category}">
										<img src="images/thumbs/03.jpg" alt="" />
										<h3>${cate.category}</h3>
									</a>
								</c:forEach>
								</div>
									<!-- Main카테고리3번줄 -->
								<c:forEach items="${category}" var="cate" begin="5" end="6">
									<a href="/bookingpage/${cate.category}">
										<img src="images/thumbs/04.jpg" alt="" />
										<h3>${cate.category}</h3>
									</a>
								</c:forEach>
								</div>
				</section>
						<!-- 메인 공간이미지  -->
						<hr><h1>오늘의 추천공간</h1><br>
							<h3>오늘만 추천합니다.</h3><hr>
							<section class="thumbnails">
								<!-- 상세페이지로 넘어가는 페이지 -->
								<div >
								<c:forEach items="${board}" var="board" begin="0" end="3">
									<a href="/bookingpage/${board.boardNum}">
									<${board. }
										<img src="images/thumbs/01.jpg" alt="" />
										<h3>${board.content}</h3>
									</a>
									
								</c:forEach>
								</div>
								<div >
								<c:forEach items="${board}" var="board" begin="4" end="7">
									<a href="/bookingpage/${board.boardNum}">
										<img src="images/thumbs/02.jpg" alt="" />
										<h3>${board.content}</h3>
									</a>
									
								</c:forEach>
								</div>
								<div >
								<c:forEach items="${board}" var="board" begin="8" end="10">
									<a href="/bookingpage/${board.boardNum}">
									
										<img src="images/thumbs/07.jpg" alt="" />
										<h3>${board.content}</h3>
									</a>
									
								</c:forEach>
								</div>
							</section>
<div style="text-align: center">
<h2><a href="/customer/loginForm">회원 로그인</a></h2>
<h2><a href="/customer/hostLoginForm">호스트 로그인</a><br></h2>
<br><br>
<h2><a href="/board/boardList">게시판 목록</a></h2>
<a href="login/index">카카오테스트</a><br>
<a href="login/hostlogin">호스트로그인폼</a><br>
<a href="search">검색 기능</a><br>
<a href="postBoard">공간등록</a><br>
<a href="loginForm">호스트 로그인</a><br>
<a href="viewBoard">호스트 마이페이지</a><br>
<a href="searchForm">검색</a>
=======
				</c:forEach>
			</div>
			<!-- Main카테고리2번줄 -->
			<div>
				<c:forEach items="${category}" var="cate" begin="2" end="4">
					<a href="/bookingpage/${cate.category}"> <img
						src="images/thumbs/03.jpg" alt="" />
						<h3>${cate.category}</h3>
					</a>
				</c:forEach>
			</div>
			<!-- Main카테고리3번줄 -->
			<c:forEach items="${category}" var="cate" begin="5" end="6">
				<a href="/bookingpage/${cate.category}"> <img
					src="images/thumbs/04.jpg" alt="" />
					<h3>${cate.category}</h3>
				</a>
			</c:forEach>
>>>>>>> f8aa98ca050cbae97bcc4c9431de0c5cdf469203
</div>
</section>
<!-- 메인 공간이미지  -->
<hr>
<h1>오늘의 추천공간</h1>
<br>
<h3>오늘만 추천합니다.</h3>
<hr>
<section class="thumbnails">
	<!-- 상세페이지로 넘어가는 페이지 -->
	<div>
		<c:forEach items="${board}" var="board" begin="0" end="3">
			<a href="/bookingpage/${board.boardNum}"> <img
				src="images/thumbs/01.jpg" alt="" />
				<h3>${board.content}</h3>
			</a>

		</c:forEach>
	</div>
	<div>
		<c:forEach items="${board}" var="board" begin="4" end="7">
			<a href="/bookingpage/${board.boardNum}"> <img
				src="images/thumbs/02.jpg" alt="" />
				<h3>${board.content}</h3>
			</a>

		</c:forEach>
	</div>
	<div>
		<c:forEach items="${board}" var="board" begin="8" end="10">
			<a href="/bookingpage/${board.boardNum}"> <img
				src="images/thumbs/07.jpg" alt="" />
				<h3>${board.content}</h3>
			</a>

		</c:forEach>
	</div>
</section>
</main>
<footer>
	<%@ include file="../publicCSS/footer.jsp"%>
</footer>
</body>
</html>