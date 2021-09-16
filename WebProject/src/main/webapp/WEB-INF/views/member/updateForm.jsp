<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>회원정보 수정</h3>
<form action="/update"method="post" name="form">
	아이디 : ${customer.custId}<br>
	비밀번호 : <input name="password"><br>
	이름 : <input name="name"><br>
	닉네임 : <input name="nickName">
	이메일 : <input name="email"><br>
	<input type="submit" value="회원정보 수정"><br>
</form>

<h3>회원 탈퇴</h3>
<form action="/delete" method="post" name="form">
	아이디 : ${customer.custId}<br>
	비밀번호 : <input name="password"><br>
	<input type="submit" value="회원 탈퇴"><br>
</form>
</body>
</html>