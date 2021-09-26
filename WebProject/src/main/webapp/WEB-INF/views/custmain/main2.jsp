<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
	integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
<style>
body {
	padding-top: 40px;
}

img {
	position: relative;
}

div.zIndex {
	position: absolute;
	top: 25%;
	right: 10%;
}

h2.maintext {
	text-align: right;
}

table {
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: white;
	width: 150px;
}

table a {
	margin: 10px auto;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}
#textalign{text-align: center;}
</style>
</head>
<div class="container">
	<!-- 헤더영역 -->
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>
	<img class="z w-100" src="../images/mainImg/custmainimgs.jpg" />
	<div class="zIndex">
		<h2 class="maintext">
			우리들의 공간 <br> <strong>Bang Bang</strong><br> 여러분들의 필요 공간을 <br>제공하고
			있습니다.
		</h2>
	</div>

	<!-- Main카테고리1번줄 -->
	<section class="row mt-5">
	<c:forEach items="${category}" var="cate">
		<div class="col mw-100">
				<a href="/bookingpage/${cate.category}">
				<img src="../images/icon/studyroom.png" class="col mw-100" />
					<h5 id="textalign">${cate.category}</h5>
				</a>
			</div>	
		</c:forEach>
	</section>
	
	<!-- 추천 공간이미지  -->
	<hr>
	<h1 class="display-6 fw-normal mb-1">오늘의 추천공간</h1>
	<h3 class="lead fs-3 mb-3">오늘만 추천합니다.</h3>
	<hr>
	<section class="thumbnails">
		<!-- 상세페이지로 넘어가는 페이지 -->
		<div>
			<c:forEach items="${board}" var="board" begin="0" end="3">
				<a href="/bookingpage/${board.boardNum}"> <img
					src="../images/thumbs/01.jpg" alt="" />
					<h3 class="fs-4">${board.spaceName}</h3>
					<h5 class="lead fs-4 mb-3">${board.contentOneline }</h5>
				</a>

			</c:forEach>
		</div>
		<div>
			<c:forEach items="${board}" var="board" begin="4" end="7">
				<a href="/bookingpage/${board.boardNum}"> <img
					src="images/thumbs/02.jpg" alt="" />
					<h3 class="fs-4">${board.spaceName}</h3>
					<h5 class="lead fs-4 mb-3">${board.contentOneline }</h5>
				</a>

			</c:forEach>
		</div>
		<div>
			<c:forEach items="${board}" var="board" begin="8" end="10">
				<a href="/bookingpage/${board.boardNum}"> <img
					src="../images/thumbs/07.jpg" alt="" />
					<h3 class="fs-4">${board.spaceName}</h3>
					<h5 class="lead fs-4 mb-3">${board.contentOneline }</h5>
				</a>

			</c:forEach>
		</div>
	</section>
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
								//
								$
										.ajax({
											url : "/customer/getImgs",
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