<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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
		<%@ include file="../publicCSS/adminheader.jsp"%>
	</header>
	<main>
	<img class="z w-100" src="../images/mainImg/hostmainimgs.jpg"/>
	<div class="container">
		<div class="zIndex">
			<h1><b>관리자 페이지입니다 <br>공간 비즈니스를 관리해보세요.</b></h1><br>
			<a href="/adminPermitBoard/preBoard"><button type="button" class="btn btn-primary btn-lg">공간등록 관리</button></a>
			<a href="#"><button type="button" class="btn btn-secondary btn-lg">공지사항 작성</button></a>
		</div>
	</div>		
	</main>
	<footer>
		<%@ include file="../publicCSS/footer.jsp"%>
	</footer>

</body>
</html>