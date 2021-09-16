<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
	table{ border-collapse : collapse;}
</style>
</head>
<body>
<table border="1">
	<tr><td>제목</td><td>${board.title }</td></tr>
	<tr><td>작성자</td><td>${board.writer }</td></tr>
	<tr><td>내용</td><td>${board.content }</td></tr>
	<tr><td>등록일</td><td><fmt:formatDate value="${board.createDate }" pattern="MM.dd"/> </td></tr>
	<tr><td>조회수</td><td>${board.cnt }</td></tr>
	<tr><td colspan="2">
	<a href="/updateform/${board.num}">글 수정</a>	
	<a href="/delete/${board.num}">글 삭제</a>
	<a href="/getBoardList">글 목록</a>
	</td></tr>
</table>
</body>
</html>