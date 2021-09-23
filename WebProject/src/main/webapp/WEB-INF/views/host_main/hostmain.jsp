<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 메인</title>
<style>

body {
	padding-top: 20px;
}
main{margin-top: 30px;}

a{text-decoration: none;}
img{position:relative;}
.zIndex{position: absolute; top: 65%;}
</style>
</head>
<body>
	<header>
		<%@ include file="../publicCSS/hostheader.jsp"%>
	</header>
	<main>
	<img class="z w-100" src="../images/mainImg/hostmainimgs.jpg"/>
	<div class="container">
		<div class="zIndex">
			<h1><b>지금 고객들을 위한 <br>공간 비즈니스를 시작해보세요.</b></h1><br>
			<a href="insertBoardForm"><button type="button" class="btn btn-primary btn-lg">공간 등록하기</button></a>
			<a href="viewBoard"><button type="button" class="btn btn-secondary btn-lg">내 공간 관리</button></a>
		</div>
	</div>		
	</main>
	<footer>
		<%@ include file="../publicCSS/footer.jsp"%>
	</footer>
	
</body>
</html>