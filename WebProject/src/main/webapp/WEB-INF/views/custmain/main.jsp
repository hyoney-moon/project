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
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
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
a {text-decoration:none !important }
</style>
</head>
<div class="container">
	<!-- 헤더영역 -->
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>
	<main>
		<img class="z w-100" src="../images/mainImg/custmainimgs.jpg" />
		<div class="zIndex">
			<h2 class="maintext">
				우리들의 공간 <br> <strong>Bang Bang</strong><br> 여러분들의 필요 공간을 <br>제공하고
				있습니다.
			</h2>
		</div>
		<section class="mt-5">
		<h2>카테고리별 검색</h2>
		<div class="row">
		<c:forEach items="${category}" var="cate">
			<div class="col mw-100">
				<div class="card">
					<div class="card-body">
					<a href="/bookingpage/${cate.category}"><h5 class="card-title">${cate.category }</h5></a>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		</section>
		
		<section class="mt-5">
		<h2>오늘의 추천 공간</h2>
		<div class="row row-cols-1 row-cols-md-2 g-4">
		<c:forEach items="${board }" var="board" begin="0" end="3">
			<div class="col" id="${board.boardNum }">
				<div class="card" >
					<div class="img"></div>
						<div class="card-body">
							<h5 class="card-title">${board.spaceName }</h5>
							<p class="card-text">${board.contentOneline }</p>
						</div>
				</div>
				</div>
			</c:forEach>
			</div>
</main>
<footer>
	<%@ include file="../publicCSS/footer.jsp"%>
</footer>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function(){
		$("div").each(function(){
			var id = $(this).attr("id")
			if(id != undefined){
			var tr = $(" .img", this)
			//
			$.ajax({
				url: "/customer/getImgs",
				data: "boardNum=" + id,
				dataType: "JSON"
			}).done(function(data){
				
				var str = "<div class='list_item'> <div id='carouselExampleControls' class='carousel slide' data-bs-ride='carousel'><div class='carousel-inner'>"
				str += "<div class='carousel-item active'><img src="+data[0].filePath +" class='d-block w-100 list_img' alt='...'></div>"
				for(var i = 1; i< data.length; i++){
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