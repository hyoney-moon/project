<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
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

#page {
	text-decoration: none;
	text-align: center;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
}
</style>
<link rel="stylesheet" href="/css/modal.css" type="text/css">
</head>
<body>
	<header>
		<%@ include file="../publicCSS/hostheader.jsp"%>
	</header>
	<div class="container-sm w-50 mb-5">
		<div class="row row-cols-1 row-cols-md-2 g-4">
			<c:forEach items="${bList }" var="board" begin="0" end="3">
				<div class="col" id="${board.boardNum }">
					<div class="card">
						<a href="viewPost/${board.boardNum }"><div class="img"></div></a>
						<div class="card-body">
							<a href="/host/viewPost/${board.boardNum }"><h5
									class="card-title">${board.spaceName }</h5></a>
							<p class="card-text">${board.contentOneline }</p>

							<a onclick="" class="btn_delete_post"><button
									class="btn btn-outline-secondary" type="button"
									id="button-addon2">삭제</button></a>
									<a
								href="hostBookingList/${board.boardNum }"><button
									class="btn btn-outline-secondary" type="button"
									id="button-addon2">예약현황</button></a> <a
								href="modifyPost/${board.boardNum }"><button
									class="btn btn-outline-secondary" type="button"
									id="button-addon2">수정</button></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div id="page">
			<c:if test="${begin > 2 }">
				<a href="viewBoard?p=${begin-1}">[이전]</a>
			</c:if>
			<c:forEach begin="${begin }" end="${end}" var="i">
				<a href="viewBoard?p=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${end < totalCount }">
				<a href="viewBoard?p=${end+1}">[다음]</a>
			</c:if>
		</div>
	</div>
	<footer>
		<%@ include file="../publicCSS/footer.jsp"%>
	</footer>
</body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function() {
		$("div")
				.each(
						function() {
							var id = $(this).attr("id")
							if (id != undefined) {
								var tr = $(" .img", this)
								$
										.ajax({
											url : "/host/getImgs",
											data : "boardNum=" + id,
											dataType : "JSON"
										})
										.done(
												function(data) {
													var str = "<div class='list_item'> <div id='carouselExampleControls' class='carousel slide' data-bs-ride='carousel'><div class='carousel-inner'>"
													str += "<div class='carousel-item active'><img src="+data[0].filePath +" class='d-block w-100 list_img' alt='...'></div>"
													for (var i = 1; i < data.length; i++) {
														str += "<div class='carousel-item'> <img src="+ data[i].filePath + " class='d-block w-100 list_img' alt='...'> </div>"
													}
													str += "</div> </div> </div>"

													$(tr).append(str);

												})
							}
						})

	})
</script>
</html>