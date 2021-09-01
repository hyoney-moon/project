<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- <form action="/questions/QnaForm" method="get">
	<input type="button" value="질문하기">
</form> -->

소개 : ${board.content}<br>
글번호 : ${board.board_num}<br>


Q&A
<a href="/questions/QnaForm" role="button">질문하기</a>

<c:forEach items="${qna}" var="result">
cust_id : ${result.customer.cust_id}<br>
board_num : ${result.board.number}<br>
content : ${result.content}<br>	

</c:forEach>

</body>
</html>