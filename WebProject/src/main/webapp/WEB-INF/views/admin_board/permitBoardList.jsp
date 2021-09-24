<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
#grid {
	width: 900px;
	margin: auto;
}

</style>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script src="/js/tui-grid.js"></script>
<link rel="stylesheet" href="/css/tui-grid.css" type="text/css">
</head>

<script>
window.onload = function(){
	$.ajax({
		url : "/permit/getPreBoard",
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
	        header: '가격(인당)',
	        name: 'price'
	      },
	      {
	        header: '게시날짜',
	        name: 'regDate',
	      }
	    ]
	  });
	
// 공간등록 허가 클릭 이벤트
$(document).on("click","#permit", function(){
	let board = grid.getCheckedRows();
	$.ajax({
		url : "/permit/permitBoard",
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
		url : "/permit/rejectBoard",
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
<h1 style= "text-align: center;">관리자 게시글 허가</h1>
<br>
<div id="grid"></div>
<button style= "margin-left: 25%; margin-top: 10px;"class="button" id="permit">공간등록 허가</button>
<button class="button" id="reject">삭제</button>
</body>
</html>