<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index</title>
</head>
<body>
index�Դϴ�.

<a href="/customer/loginForm">ȸ�� �α���</a>
<a href="/host/loginForm">ȣ��Ʈ �α���</a>
<a href="/board/boardList">�Խ��� ���</a>

<form action="/questions/QnaResult" method="get">
<input type="hidden" name="boardNum" value="1">
<input type="submit" value="�۹�ȣ ����">
</form>
</body>
</html>