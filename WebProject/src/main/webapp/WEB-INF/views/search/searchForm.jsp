<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<style>
body {
	padding-top: 40px;
}

.headText {
	padding: 50px;
	text-align: center;
}
table{border-collapse : collapse; text-align: center;}
th{ background-color: white; width: 150px;}
a{margin: 10px auto;}
#page{text-align: center;}
</style>
</head>
<body>
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>

	<div class="container ">
		<form action="searchBoard" method="post">
			<select name="search_option"
				class="form-select form-select-lg mb-3 w-25"
				aria-label=".form-select-lg example">
				<option selected>Select</option>
				<option value="1">공간명</option>
				<option value="2">카테고리</option>
				<option value="3">지역별</option>
			</select>
			<input name="search" class="form-control form-control-lg"
				type="text" placeholder="검색어를 입력하세요."
				aria-label=".form-control-lg example">
				<input type="submit" value="검 색" onclick="getSearchList()"><br>
				<%-- <table border="1" class="w-100 mt-5">
					<tr>
						<th>작성자</th> <th>카테고리</th> <th>이미지</th> <th>공간명</th> <th>작성일</th> <th>조회수</th>
					</tr>
					<c:forEach items="${boardList }" var="blist">
						<tr>
							<td>${blist.hostId }</td>
							<td>${blist.category }</td>
							<td>
								<div class="list_item">
									<div id="carouselExampleControls" class="carousel slide"
										data-bs-ride="carousel">
										<!-- 이미지가 안 뜸 ㅜㅜ -->
										<div class="carousel-inner">
											<c:forEach items="${blist.frontimg }" var="fis" begin="0"
												end="0">
												<div class="carousel-item active">
													<img src="${fis.filePath }" class="d-block w-100 list_img"
														alt="...">
												</div>
											</c:forEach>
											<c:forEach items="${blist.frontimg }" var="fis" begin="1"
												end="${blist.frontimg.size() }">
												<div class="carousel-item">
													<img src="${fis.filePath }" class="d-block w-100 list_img"
														alt="...">
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</td>
							<td><a href="viewPost/${blist.boardNum }">${blist.spaceName }</a></td>
							<td><fmt:formatDate value="${blist.regDate}" pattern="MM.dd" /></td>
							<td>${blist.readcount }</td>
						</tr>
					</c:forEach>
				</table>
				<div id="page">
					<c:if test="${begin > 2 }">
						<a href="/searchBoard?p=${begin-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${begin }" end="${end}" var="i">
						<a href="/searchBoard?p=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${end < totalCount }">
						<a href="/searchBoard?p=${end+1}">[다음]</a>
					</c:if>
				</div> --%>
		</form>
	</div>
	<script>
		$(function(){
			let 
		})
	</script>
</body>

</html>