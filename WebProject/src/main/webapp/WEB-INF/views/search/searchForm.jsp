<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

table {
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: white;
	width: 150px;
}

a:link{text-decoration: none;}
a:visited {text-decoration: none;}

#page {
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>

	<div class="container ">
		<form action="searchBoard" method="post">
			<select name="search_option" id ="search_option"
				class="form-select form-select-lg mb-3 w-25"
				aria-label=".form-select-lg example">
				<option selected>Select</option>
				<option value="1">공간명</option>
				<option value="2">카테고리</option>
				<option value="3">지역별</option>
			</select>
			<input id="search" name="search" class="form-control form-control-lg"
				type="text" placeholder="검색어를 입력하세요."
				aria-label=".form-control-lg example">
				<input type="button" value="검 색" id="searchbtn" class="mb-5"><br>
				
		<section id="searchList">
		<div class="row row-cols-1 row-cols-md-2 g-4">
		<c:forEach items="${bList }" var="blist">
			<div class="col" id="${blist.boardNum }">
				<div class="card" >
					<a href="viewPost/${blist.boardNum }"><div class="img"></div></a>
						<div class="card-body">
							<a href="viewPost/${blist.boardNum }"><h5 class="card-title">${blist.spaceName }</h5></a>
							<p class="card-text">${blist.contentOneline }</p>
						</div>
				</div>
				</div>
			</c:forEach>
			</div>
		</section>		
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function(){
		
		//searchForm 들어오자 마자 화면에 이미지 출력
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
	<script>
		$("#searchbtn").click(function(){
			var search_option = $("#search_option").val();
			var search = $("#search").val(); 
			$.ajax({
				url: "/customer/searchBoard",
				method: "POST",
				data:"search_option="+search_option+"&search="+search,
				dataType: "JSON"
			}).done(function(data){
				$("#searchList").empty();
				for(var i = 0; i < data.length; i++){
					$("#searchList").append(
							"<div class='col' id=" +data[i].boardNum+ "><div class='card' ><div class='img'></div><div class='card-body'>"+
										"<h5 class='card-title'>" +data[i].spaceName+ "</h5><p class='card-text'>"+data[i].contentOneline+ "</p></div></div></div>"
					)}
				get();
			});
			function get(){
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
