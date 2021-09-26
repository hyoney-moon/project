<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<style type="text/css">
* {
font-family: 'Nanum Gothic', sans-serif;
}
#grid {
	width: 900px;
	margin: auto;
	margin-bottom: 10px; 
}

.permit {
	color: #fff;
	margin-left: 400px;
	padding: 5px 12px 5px; 
	font-size: 1em; 
	border-radius: 100px; 
	background-color: #704de4; 
	cursor: pointer;
	text-decoration: none;
}
.reject {
	color: #fff;
	margin-left: 10px; 
	padding: 5px 12px 5px; 
	font-size: 1em; 
	border-radius: 100px; 
	background-color: #4d4d4d; 
	cursor: pointer; 
	text-decoration: none;
}


</style>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/js/tui-grid.js"></script>
<link rel="stylesheet" href="/css/tui-grid.css" type="text/css">

</head>

<script>
window.onload = function(){
	// 승인전 게시글 조회
	$.ajax({
		url : "/adminPermitBoard/getPreBoard",
		method :"GET",
		dataType : "JSON",
		success : function(result){
			grid.resetData(result);
		}
	});
	var grid = new tui.Grid({
	    el: document.getElementById('grid'),
	    scrollX: false,
	    scrollY: false,
	    rowHeaders: ['checkbox'],
	    columns: [
	      {
	        header: '글번호',
	        name: 'boardNum',
	      },
	      {
		    header: '호스트ID',
		    name: 'hostId',
		      },
	      {
	        header: '공간이름',
	        name: 'spaceName',
	      },
	      {
	        header: '가격',
	        name: 'price'
	      },
	      {
	        header: '게시일',
	        name: 'regDate',
	      }
	    ]
	  });
	
// 공간등록 허가 클릭 이벤트
$(document).on("click","#permit", function(){
	let board = grid.getCheckedRows();
	$.ajax({
		url : "/adminPermitBoard/permitBoard",
		method : "POST",
		dataType : "JSON",
		contentType: 'application/json',
		data : JSON.stringify(board),
	}).done(function(){
	});
	location.reload();
});// click 종료

// 공간 등록 전 게시글 삭제 이벤트
$(document).on("click","#reject",function(){
	let board = grid.getCheckedRows();
	
	$.ajax({
		url : "/adminPermitBoard/rejectBoard",
		method : "POST",
		dataType : "JSON",
		contentType : 'application/json',
		data : JSON.stringify(board),
	}).done(function(){
	})
	location.reload();
});



};
</script>
<body>
	<header>
		<%@ include file="../publicCSS/adminheader.jsp"%>
	</header>
	<br><br>
<h1 style= "text-align: center;">공간등록 허가</h1>
<br>
<div id="grid"></div>
<span id="permit" class="permit">공간등록 허가</span>
<span id="reject" class="reject">공간등록 거절</span>

<!-- <button style= "margin-left: 25%; margin-top: 10px;"class="button" id="permit">공간등록 허가</button>
<button class="button" id="reject">공간등록 거절</button> -->



</body>
</html>