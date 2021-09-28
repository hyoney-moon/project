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
a{text-decoration: none;}
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
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
				class="form-select form-select-lg mb-2"
				aria-label=".form-select-lg example">
				<option selected>Select</option>
				<option value="1">공간명</option>
				<option value="2">카테고리</option>
				<option value="3">지역별</option>
<<<<<<< HEAD
			</select> <input id="search" name="search" class="form-control form-control-lg"
				type="text" placeholder="검색어를 입력하세요."
				aria-label=".form-control-lg example"> <input type="button"
				value="검 색" id="searchbtn"><br>
				<table border="1" class="w-100 mt-5" id="searchList">
					<tr>
						<th>작성자</th>
						<th>카테고리</th>
						<th>이미지</th>
						<th>공간명</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="${bList }" var="blist">
						<tr id="${blist.boardNum }">
							<td>${blist.hostId }</td>
							<td>${blist.category }</td>
							<td class="img">
								
							</td>
							<td><a href="viewPost/${blist.boardNum }">${blist.spaceName }</a></td>
							<td><fmt:formatDate value="${blist.regDate}" pattern="MM.dd" /></td>
							<td>${blist.readcount }</td>
						</tr>
					</c:forEach>
				</table>
				<div id="page">
					<c:if test="${begin > 2 }">
						<a href="searchForm?p=${begin-1}">[이전]</a>
					</c:if>
					<c:forEach begin="${begin }" end="${end}" var="i">
						<a href="searchForm?p=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${end < totalCount }">
						<a href="searchForm?p=${end+1}">[다음]</a>
					</c:if>
=======
			</select>
			
			<div class="input-group mb-5 col">
			<input id="search" name="search" type="text"
					class="form-control form-control-lg " placeholder="검색어를 입력하세요."
					aria-label="Recipient's username" aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2">검색</button>
			</div>	
			
		<section class="mb-5">
		<div class="row row-cols-1 row-cols-md-2 g-4" id="searchList">
		<c:forEach items="${bList }" var="blist" >
			<div class="col" id="${blist.boardNum }" >
				<div class="card" >
					<a href="viewPost/${blist.boardNum }"><div class="img" ></div></a>
						<div class="card-body">
							<a href="viewPost/${blist.boardNum }"><h5 class="card-title">${blist.spaceName }</h5></a>
							<p class="card-text">${blist.contentOneline }</p>
						</div>
				</div>
>>>>>>> 6a66f65c0132eb8e60ca1b4568f30fa6f6198e04
				</div>
			</c:forEach>
			</div>
		</section>		
		</form>
	</div>
	<footer>
	<%@ include file="../publicCSS/footer.jsp"%>
</footer>
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
<<<<<<< HEAD
	$(function(){
		/* $("#search").keypress(function(){
			$('#searchbtn').click();
		}); */
		
		$("#searchbtn").click(function(){
=======
		$("#button-addon2").click(function(){
>>>>>>> 6a66f65c0132eb8e60ca1b4568f30fa6f6198e04
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
<<<<<<< HEAD
							"<tr> <th>작성자</th> <th>카테고리</th> <th>이미지</th> <th>공간명</th> <th>작성일</th> <th>조회수</th> </tr>"+
							"<tr id=" + data[i].boardNum + "><td>"+data[i].hostId+"</td>"+
							"<td>"+data[i].category+"</td>"+
							"<td class='img'></td>" +
							"<td>"+data[i].spaceName+"</td>"+
							"<td>"+data[i].regDate + "</td>"+
							"<td>"+data[i].readcount+"</td></tr>"
					)}
				get();
			});
			function get(){
				
			
			$("tr").each(function(){
=======
							"<div class='col' id=" +data[i].boardNum+ "><div class='card' ><a href='viewPost/" + data[i].boardNum +"'><div class='img'></div></a><div class='card-body'>"+
										"<a href='viewPost/" + data[i].boardNum +"'><h5 class='card-title'>" +data[i].spaceName+ "</h5></a><p class='card-text'>"+data[i].contentOneline+ "</p></div></div></div>"
					)}//for
				get();
			})//done
			});//click
		function get(){
			$("div").each(function(){
>>>>>>> 6a66f65c0132eb8e60ca1b4568f30fa6f6198e04
				var id = $(this).attr("id")
				if(id != undefined){
				var tr = $(" .img", this)
				//
				$.ajax({
<<<<<<< HEAD
					url: "/customer/getSearchImgs",
					data: "boardNum=" + id,
					dataType: "JSON"
				}).done(function(args){
					var str = "<div class='list_item'> <div id='carouselExampleControls' class='carousel slide' data-bs-ride='carousel'><div class='carousel-inner'>"
					str += "<div class='carousel-item active'><img src="+args[0].filePath +" class='d-block w-100 list_img' alt='...'></div>"
					for(var i = 1; i< args.length; i++){
					str += "<div class='carousel-item'> <img src="+ args[i].filePath + " class='d-block w-100 list_img' alt='...'> </div>"
=======
					url: "/customer/getImgs",
					data: "boardNum=" + id,
					dataType: "JSON"
				}).done(function(data){
					
					var str = "<div class='list_item'> <div id='carouselExampleControls' class='carousel slide' data-bs-ride='carousel'><div class='carousel-inner'>"
					str += "<div class='carousel-item active'><img src="+data[0].filePath +" class='d-block w-100 list_img' alt='...'></div>"
					for(var i = 1; i< data.length; i++){
					str += "<div class='carousel-item'> <img src="+ data[i].filePath + " class='d-block w-100 list_img' alt='...'> </div>"
>>>>>>> 6a66f65c0132eb8e60ca1b4568f30fa6f6198e04
					}
					str += "</div> </div> </div>"
					
					$(tr).append(str);
					
<<<<<<< HEAD
				})
				}
			})
			}
		})
		$("tr").each(function(){
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
</body>
</html>
=======
					})//done
				}//if
				})//each
			}//get 
 
	</script>
</html>
>>>>>>> 6a66f65c0132eb8e60ca1b4568f30fa6f6198e04
