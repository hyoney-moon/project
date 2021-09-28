<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
.ms-1 {
	margin-left: 10px;
}

.navicon {
	margin-right: 10px;
	float: right;
}

.offcanvas-header {
	background-color: #582BD3;
}

a {
	text-decoration: none
}

.dropdown-divider {
	border-color: gray;
}

.dropdown-menu {
	border: none;
}
</style>
</head>
<body>
	<header>
		<div class="postion-relateive mt-5">
			<!-- navbar -->
			<nav class="navbar navbar-light bg-white fixed-top">
				<div class="container-fluid">
					<!-- searchIcon -->
					<a class="navbar-brand" href="searchForm"></a>
					<!-- Logo -->
					<div
						class="position-absolute d-inline top-50 start-50 translate-middle">
						<a href="logoClick"><img style="width: 150px;"
							src="/images/icon/Logo.png" /></a>
					</div>
					<!-- navbar Icon -->
					<button class="navbar-toggler" type="button"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
						aria-controls="offcanvasNavbar">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="offcanvas offcanvas-end" tabindex="-1"
						id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
						<div class="offcanvas-header h-25">
							<c:if test="${empty sessionScope.host }">
								<a class="textStyle" href="hostLoginForm">
									<h3
										class="offcanvas-title text-white position-absolute top-0 
									start-0 px-4 pt-4"
										id="offcanvasNavbarLabel">호스트 로그인</h3>
								</a>
							</c:if>
							<c:if test="${!empty sessionScope.host}">
								<h3
									class="offcanvas-title text-white position-absolute top-0 
									start-0 px-4 pt-4"
									id="offcanvasNavbarLabel">${host.nickName}님<br>
									당신의 <strong>공간을</strong><br>
									공유해보세요.
								</h3>
							</c:if>
							<button type="button"
								class="btn-close text-reset position-absolute top-0 end-0 px-4 pt-5"
								data-bs-dismiss="offcanvas" aria-label="Close"></button>
						</div>
						<div class="offcanvas-body">
							<ul class="navbar-nav justify-content-end flex-grow-1 pe-4 fs-5">
								<li><a class="dropdown-item" href="#">마이페이지</a></li>
								<li><a class="dropdown-item" href="#">프로필수정</a></li>
								<li><a class="dropdown-item" href="#">예약현황</a></li>
								<li><a class="dropdown-item" href="#">리뷰 관리</a></li>
								<li><a class="dropdown-item" href="#">Q&A 관리</a></li>
								<li><a class="dropdown-item" href="viewBoard">내공간관리</a>
								<c:if test="${!empty sessionScope.host }">
									<li><a class="dropdown-item" href="hostLogout">로그아웃</a></li>
								</c:if>
							</ul>
							<hr class="dropdown-divider">
							<ul class="navbar-nav justify-content-end flex-grow-1 pe-3 fs-5">
								<li><a class="dropdown-item" href="#">공지사항</a></li>
								<li><a class="dropdown-item" href="/">메인페이지</a></li>
								<li><a class="dropdown-item" href="#">리뷰</a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</header>
</body>
</html>