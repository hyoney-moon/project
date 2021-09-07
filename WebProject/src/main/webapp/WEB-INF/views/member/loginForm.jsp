<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center">
<h1>일반회원 로그인</h1>
</div>
<form action="login" method="post">
<table align="center" border="1" cellpadding="0" cellspacing="0">				
	<tr>
		<td bgcolor="orange" >아이디</td>
		<td><input name="custId" type="text" size="10"></td>
	</tr>
	<tr>
		<td bgcolor="orange" >비밀번호</td>
		<td><input name="password" type="password" size="10"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<a href="/joinView">회원 가입</a>
		</td>
	</tr>
</table>
</form>	
</body>
</html>