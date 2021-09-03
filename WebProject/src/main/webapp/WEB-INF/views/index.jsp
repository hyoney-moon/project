<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index</title>
</head>
<body>
index입니다.

<a href="/customer/loginForm">회원 로그인</a>
<a href="/host/loginForm">호스트 로그인</a>
<a href="/board/boardList">게시판 목록</a>

<form action="/questions/QnaResult" method="get">
<input type="hidden" name="boardNum" value="1">
<input type="submit" value="글번호 전송">
</form>
</body>
</html>