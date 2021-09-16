<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>목록 보기</title>
<style>
	#center{width:700px; margin-left: auto; margin-right: auto;}
	table{width: 700px; border-collapse : collapse;}
	th{ background-color: orange; width: 150px;}
	a{margin: 10px auto;}
	#page{text-align: center;}
</style>
</head>
<body>
<div id="center">
<h1>게시글 목록</h1>
<div align="right" id="loginid">${member.id} 로그인 중 <a href="updateForm">회원수정</a> <a href="/logout">로그아웃</a></div>
<div align="right"><a href="updateForm">회원수정</a><a href="insertBoard">새글 등록</a> <a href="getBoardList">전체 글 목록</a></div>
<c:if test="${ total != 0}">
<table border="1">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>
	<c:forEach items="${blist}" var="board">
		<tr><td>${board.num}</td>
			<td><a href="/content/${board.num}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td><fmt:formatDate value="${board.createDate}" pattern="MM.dd"/> </td>
			<td>${board.cnt}</td>
		</tr>	
	</c:forEach>
</table>

<div id="page">
<c:if test="${search == null }"> 
<c:if test="${begin > 2 }">
	<a href="/getBoardList?p=${begin-1}">[이전]</a>
</c:if>
	<c:forEach begin="${begin }" end="${end}" var ="i">
		<a href="/getBoardList?p=${i}">[${i}]</a>
	</c:forEach>
<c:if test="${end < totalPage }">
	<a href="/getBoardList?p=${end+1}">[다음]</a>
</c:if>
 </c:if> 
<c:if test="${search != null }">
<c:if test="${begin > 2 }">
	<a href="/getBoardList?p=${begin-1}&search=${search}&searchn=${searchn}">[이전]</a>
</c:if>
	<c:forEach begin="${begin }" end="${end}" var ="i">
		<a href="/getBoardList?p=${i}&search=${search}&searchn=${searchn}">[${i}]</a>
	</c:forEach>
<c:if test="${end < totalPage }">
	<a href="/getBoardList?p=${end+1}&search=${search}&searchn=${searchn}">[다음]</a>
</c:if>
</c:if> 

</div>
</c:if>
<c:if test="${total == 0}">
	검색 결과가 없습니다.
</c:if>
<form>
<select name="searchn">
<option value="0">제목</option>
<option value="1">내용</option>
<option value="2">작성자</option>
</select>

<input type="text" name="search" size="15" maxlength="50" /> 
<input type="submit" value="검색" />
</form>	
</div>
</body>
</html>




