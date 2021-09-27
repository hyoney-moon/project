<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지 입니다.</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>
header {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	hegiht: 70px;
	padding: 2px;
	background: white;
	align-items: center;
}

body {
	padding-top: 70px
}
footer {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;

}
</style>
</head>
<body>
	<header>
		<%@ include file = "../publicCSS/custheader.jsp" %>
	</header>
	<main>
	<div class="container">
		<div class="position-absolute top-50 start-50 translate-middle">
			<div class="container">
				<form method="post" action="login">
					<div class="form-floating mb-3">
						<input name="custId" class="form-control" type="text" aria-label="default input example" placeholder="아이디">
						<label for="floatingInput">아이디</label>
					</div>
					<div class="form-floating mb-3">
						<input name="password" class="form-control" type="password" aria-label="default input example" placeholder="비밀번호">
						<label for="floatingPassword">비밀번호</label>
					</div>
					<input type="submit" value="회원 로그인"
						class="w-100 btn btn-outline-danger mb-5" style="height: 50px;">
				</form>
			</div>	
		</div>
	</div>
	</main>
	<footer>
	<%@ include file = "../publicCSS/footer.jsp" %>
	</footer>
</body>
</html>
