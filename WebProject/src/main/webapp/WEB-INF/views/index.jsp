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

<form action="/questions/QnaResult" method="get">
<input type="hidden" name="board_num" value="1">
<input type="submit" value="글번호 전송">
</form>
</body>
</html>