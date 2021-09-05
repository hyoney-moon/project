<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	#center{width:700px; margin-left: auto; margin-right: auto;}
	table{width: 700px; border-collapse : collapse;}
	th{ background-color: white; width: 150px;}
	a{margin: 10px auto;}
	#page{text-align: center;}
</style>
</head>
<body>
<div id="center">
<h1>게시글 목록</h1>
<div align="right" id="loginid"><a href="/logout">로그아웃</a></div>

<table border="1">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
	<c:forEach items="${blist}" var="board">
		<tr><td>${board.boardNum}</td>
			<td><a href="/board/content/${board.boardNum}">${board.spaceName}</a></td>
			<td>글쓴이</td>
			<td><fmt:formatDate value="${board.regDate}" pattern="MM.dd"/> </td>
		</tr>	
	</c:forEach>
</table>
<div id="page">
<c:if test="${begin > 2 }">
	<a href="/getBoardList?p=${begin-1}">[이전]</a>
</c:if>
	<c:forEach begin="${begin}" end="${end}" var ="i">
		<a href="/getBoardList?p=${i}">[${i}]</a>
	</c:forEach>
<c:if test="${end < totalPage}">
	<a href="/getBoardList?p=${end+1}">[다음]</a>
</c:if>
</div>
</div>
</body>
</html>