<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>회원정보 수정</h3>
<form action="update"method="post" enctype="multipart/form-data" name="form">
	아이디 : ${customer.custId}<br>
	비밀번호 : <input name="password"><br>
	프로필 사진 : <input type='file' name="profile2"><br>
	닉네임 : <input name="nickName"><br>
	이메일 : <input name="email"><br>
	상세주소 : <input name="addressDetail"><br>
	주소 : <input name="address"><br>
	우편번호 : <input name="zipcode"><br>
	<input type="submit" value="회원정보 수정"><br>
</form>

<h3>회원 탈퇴</h3>
<form action="delete" method="post" name="form">
	아이디 : ${customer.custId}<br>
	비밀번호 : <input type="password" name="password"><br>
	<input type="submit" value="회원 탈퇴"><br>
</form>
</body>
</html>