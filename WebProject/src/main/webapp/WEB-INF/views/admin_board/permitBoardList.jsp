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
	
$(document).on("click","#permission", function(){
	let board = grid.getCheckedRows();
	alert(board);
	$.ajax({
		url : "/permit/update",
		method : "POST",
		dataType : "JSON",
		contentType: 'application/json',
		data : JSON.stringify(board),
	}).done(function(data){
		alert("정상 등록됐습니다"); // 완료 후 화면 새로고침 구현 필요
	})
	
});// click 종료

$(document).on("click","#delete",function(){
	let boardNum = grid.getColumnValues("boardNum");
	console.log(boardNum);
	
	$.ajax({
		url : "/permit/delete",
		method : "POST",
		dataType : "JSON",
		contentType : 'application/json',
		data : //boardNum,
			JSON.stringify(boardNum),
	}).done(function(data){
		grid.resetData(result); // 완료 후 화면 새로고침 필요
	})
})

};
</script>
<body>
<div id="grid"></div>
<button id="permission">공간등록 허가</button>
<button id="delete">삭제</button>

</body>
</html>