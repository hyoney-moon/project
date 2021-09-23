<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script src="/js/tui-grid.js"></script>
<link rel="stylesheet" href="/css/tui-grid.css" type="text/css">
</head>
<script>
window.onload = function(){
	
	$.ajax({
		url: "/admin/hostList",
		method: "Get",
		dataType: "JSON",
		success: function(result){
			console.dir(result);
			grid.resetData(result);
		}
	});
	let grid = new tui.Grid({
		el: document.getElementById('grid'),
		scrollX: false,
		scrollY: false,
		columns: [
			{
				header: 'hostId(desc)',
				name: 'hostId',
				sortingType: 'desc',
				sortable: true
			},
			{
				header: 'nickName(asc)',
				name: 'nickName',
				sortingType: 'asc',
				sortable: true
			},
			{
				header: 'gender',
				name: 'gender',
			},
			{
				header: 'age',
				name: 'age',
				sortingType: 'asc',
				sortable: true
			}
		]
	})
}
</script>
<body>
<a href="excelDown">엑셀로 내려받기</a>
<div id="grid"></div>
</body>
</html>