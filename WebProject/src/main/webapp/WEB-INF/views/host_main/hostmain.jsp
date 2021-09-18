<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 메인</title>
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
	<%@ include file = "../publicCSS/hostheader.jsp" %>
</header>
<div style="text-align: center">
<h1 class="headText">호스트 메인 페이지</h1>
<a href="viewBoard">호스트 마이페이지</a><br>
<a href="login/index">카카오테스트</a><br>
<a href="hostLoginForm">호스트로그인폼</a><br>
<a href="insertBoardForm">공간등록</a><br>
</div>

</body>
</html>