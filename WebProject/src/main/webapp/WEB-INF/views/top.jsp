<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/top.css">
</head>
<body>
	<header>
			<div class="list_menu">
				<div class="menu menu_join">
					<a href="signup" class="link_menu" aria-label="Go to registeration page">회원가입</a>
				</div>
				<%
				if(session.getAttribute("user_id") != null){
					out.print("<div class='menu'><a href='logout' class='link_menu center' aria-label='Go to login page'>로그아웃</a></div>");
				} else {
					out.print("<div class='menu'><a href='login' class='link_menu center' aria-label='Go to login page'>로그인</a></div>");
				}
				%>
				<div class="menu">
					<a class="link_menu" aria-label="Go to service center ">고객센터</a>
				</div>
				<div class="menu">
					<a href="admin" class="link_menu" aria-label="Go to service center " >관리자</a>
				</div>
			</div>
			<div class="bottom">
				<a href="index.jsp"><img src="resources/images/kurly.jpg" alt="logo" /></a>
			</div>
		</header>
		<nav>
			<div class="dropdown">
				<button class="dropbtn">전체 카테고리</button>
				<div class="dropdown-content">
					<a href="#">채소</a> <a href="#">과일*견과*쌀</a> <a href="#">수산*해산*건어물</a>
					<a href="#">정육*계란</a>
				</div>
			</div>
			<ul class="list">
				<li><a href="goodsList" aria-label="New products">신상품</a></li>
				<li><a href="#" aria-label="Best products">베스트</a></li>
				<li><a href="#" aria-label="Wise Consumption">알뜰쇼핑</a></li>
				<li id="last"><a href="#" aria-label="Benefits of the week">금주의
						혜택</a></li>
			</ul>
			<div class="tools">
				<div id="search" class="search">
					<form>
						<input type="text" />
					</form>
				</div>
				<div>
					<img src="resources/images/gps.png" alt="package GPS" />
				</div>
				<div class="cart">
					<a href="cartGoods" class="cart" aria-label="Go to cart"> <img
						src="resources/images/cart.png" alt="”장바구니”" /></a>
				</div>
			</div>
		</nav>

</body>
</html>