<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="login-box well">

					
<form accept-charset="UTF-8" role="form" method="post"
	action="loginForm">
	<legend>로그인</legend>
	<div style='color:red'>${msg}</div>
	<div class="form-group">
		<label for="userid-custId">아이디</label> 
		<input type="custId" name="custId" id="custId" required="required"placeholder="ID 를 입력하세요" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pw">비밀번호</label>
		<input type="pw" name="password" id="password"
		placeholder="비밀번호를 입력하세요"  class="form-control" />
	</div>
	<div class="form-group">
		<input type="submit"
		class="btn btn-primary btn-login-submit btn-block m-t-md"
		value="로그인" />
	</div>
						
					<div class="form-group">
<a href="register" class="btn btn-warning btn-block m-t-md">회원가입</a>
</div>

<div class="form-group">
<a href="../" class="btn btn-success btn-block m-t-md">메인으로</a>
</div>
</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
					