<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
	<div>
	<table>
		<tr>
			<th>작성자</th>
			<th>카테고리</th>
			<th>공간명</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${bList }" var="blist">
		<tr>
			<td>${blist.hostid }</td>
			<td>${blist.category }</td>
			<td><a href="viewPost/${boardNum }">${blist.spaceName }</a></td>
			<td><fmt:formatDate value="${blist.regdate}" pattern="MM.dd" /></td>
			<td>${blist.readcount }</td>
		</tr>
		</c:forEach>
		</table>
		<div id="page">
			<c:if test="${begin > 2 }">
				<a href="/getBoardList?p=${begin-1}">[이전]</a>
			</c:if>
			<c:forEach begin="${begin }" end="${end}" var="i">
				<a href="/getBoardList?p=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${end < totalCount }">
				<a href="/getBoardList?p=${end+1}">[다음]</a>
			</c:if>
		</div>
	</div>
	<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/Users/hyoneymoon/project/WebProject/src/main/webapp/WEB-INF/img/frontImg/1631439738318_42.PNG" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/Users/hyoneymoon/project/WebProject/src/main/webapp/WEB-INF/img/frontImg/1631264504757_13.PNG" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/Users/hyoneymoon/project/WebProject/src/main/webapp/WEB-INF/img/frontImg/1631264426447_30.PNG" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</body>
</html>