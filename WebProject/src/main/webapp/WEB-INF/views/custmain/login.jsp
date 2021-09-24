<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../publicCSS/custheader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지 입니다.</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="login-box well">

					
<form accept-charset="UTF-8" role="form" method="post"
	action="/login">
	<legend>로그인 페이지 입니다</legend>
	<div class="form-group">
		<label for="userid-custId">아이디</label> 
		<input name="custId" placeholder="ID 를 입력하세요"" />
	</div>
	<div class="form-group">
		<label for="pw">비밀번호</label>
		<input name="password" placeholder="비밀번호를 입력하세요"  class="form-control" />
	</div>
	<div class="form-group">
		<input type="submit" value="로그인" />
	</div>

<!--					
	<div class="form-group">
<a href="register" class="btn btn-warning btn-block m-t-md">회원가입</a>
</div>

<div class="form-group">
<a href="../" class="btn btn-success btn-block m-t-md">메인으로</a>
</div>
-->
</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>
<%@include file="../publicCSS/footer.jsp"%>
