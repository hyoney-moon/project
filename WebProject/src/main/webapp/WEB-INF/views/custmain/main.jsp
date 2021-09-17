<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
		<title>space 공간 얍얍</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		
</head>
	<!-- Wrapper -->
			<div id="wrapper">
				
				<!-- Header -->
					<header id="header">
					<nav class="navbar navbar-light bg-light fixed-top">
 <!--  상단 네비바 customer정보바 -->
  <div class="container-fluid">
    <a class="navbar-brand" href="#">우리들이 만들어가는 공간</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="offcanvasNavbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            </a>
            <ul class="dropdown-menu" aria-labelledby="offcanvasNavbarDropdown">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </div>
  </div>
</nav>
		<h1>안녕하세요 <strong>우리들의 공간</strong>여러분들의 필요 공간을 제공하고 있습니다.</h1>

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
</div>

				<!-- 하단 정보 공유창 -->
					<footer id="footer">
						<p id="text">&copy; 이곳에 회사정보 등을 입력 해두면된다.: <a href="http://templated.co">TEMPLATED</a> 503_프로젝트 반짝반짝: <a href="http://unsplash.com">Unsplash</a>.</p>
					</footer>


		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/main.js"></script>
	
</body>
</html>