<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script src="/js/tui-grid.js"></script>
<link rel="stylesheet" href="/css/tui-grid.css" type="text/css">
</head>
<script>

window.onload = function(){
	$.ajax({
		url : "/permit/getBoardList",
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
	        header: 'boardNum',
	        name: 'boardNum',
	      },
	      {
	        header: 'spaceName',
	        name: 'spaceName',
	      },
	      {
	        header: 'price',
	        name: 'price'
	      },
	      {
	        header: 'regDate',
	        name: 'regDate',
	      }
	    ]
	  });
	
	// 공간등록 허가 클릭 이벤트
$(document).on("click","#permission", function(){
	let board = grid.getCheckedRows();
	$.ajax({
		url : "/permit/update",
		method : "POST",
		dataType : "JSON",
		contentType: 'application/json',
		data : JSON.stringify(board),
	}).done(function(){
	});
	location.reload();
});// click 종료

// 공간 등록 전 게시글 삭제 이벤트
$(document).on("click","#delete",function(){
	let board = grid.getCheckedRows();
	
	$.ajax({
		url : "/permit/deletePermitBoard",
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
<div id="grid"></div>
<button id="permission">공간등록 허가</button>
<button id="delete">삭제</button>

</body>
</html>