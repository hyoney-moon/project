<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<title>index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
	integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
	crossorigin="anonymous"></script>
<style>
html, body {
	height: 100%;
}
a {
	text-decoration: none
}
img:hover {transform: scale(1.1); }
.card-body:hover {transform: scale(1.1); }
h5, p {color: #2d2d2d;}
</style>
</head>
<body>
<div class="container h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="position-relative">
				<div class="position-absolute top-50 start-50 translate-middle">
					<div class="card-group">
						
							<div class="card">
							<a href="host/hostmain">
								<img src="../images/icon/hostMain.png" class="card-img-top"
									alt="...">
								<div class="card-body">
									<h5 class="card-title">호스트</h5>
									<p class="card-text">호스트용<br> 페이지입니다.</p>
								</div>
							</a>	
							</div>
						
						
						<div class="card">
						<a href="customer/main">
							<img src="../images/icon/customerMain.png" class="card-img-top"
								alt="...">
							<div class="card-body">
								<h5 class="card-title">회원</h5>
								<p class="card-text">나만의 공간을<br> 대여하세요.</p>
							</div>
							</a>
						</div>
						
						
						<div class="card">
						<a href="admin/main">
							<img src="../images/icon/adminMain.png" class="card-img-top"
								alt="...">
							<div class="card-body">
								<h5 class="card-title">관리자</h5>
								<p class="card-text">관리자 <br>페이지입니다.</p>
							</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
<div style="text-align: center">
<br><br>
<h2><a href="/main">메인으로</a></h2>
<h2><a href="/board/boardList">게시판 목록</a></h2>
<h2><a href="/customerinfo/getCustomerList">일반회원 DB 조회</a></h2>
<h2><a href="/customerinfo/getCustomerInfo">일반회원 통계 조회</a></h2>
<h2><a href="/permit/loading">관리자 게시글 허가</a></h2>
<a href="login/index">카카오테스트</a><br>
<a href="login/hostlogin">호스트로그인폼</a><br>
<a href="search">검색 기능</a><br>
<a href="postBoard">공간등록</a><br>
<a href="loginForm">호스트 로그인</a><br>
<a href="viewBoard">호스트 마이페이지</a><br>
<a href="searchForm">검색</a>
</div>
</body>
</html>