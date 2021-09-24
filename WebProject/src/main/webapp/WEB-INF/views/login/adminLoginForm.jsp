<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
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
</style>
<body>
<header>
		<%@ include file = "../publicCSS/adminheader.jsp" %>
	</header>
		<div class="position-absolute top-50 start-50 translate-middle">
			<div class="container">
				<form method="post" action="/adminLogin/login">
					<div class="form-floating mb-3">
						<input name="adminId" class="form-control" type="text" aria-label="default input example" placeholder="아이디">
						<label for="floatingInput">아이디</label>
					</div>
					<div class="form-floating mb-3">
						<input name="password" class="form-control" type="password" aria-label="default input example" placeholder="비밀번호">
						<label for="floatingPassword">비밀번호</label>
					</div>
					<input type="submit" value="로그인"
						class="w-100 btn btn-outline-danger mb-5" style="height: 50px;">
				</form>
			</div>	
		</div>
</body>
</html>