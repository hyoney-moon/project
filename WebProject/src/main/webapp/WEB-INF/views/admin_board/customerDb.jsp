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
		url : "/customerinfo/customerList",
		method :"GET",
		dataType : "JSON",
		success : function(result){
			console.dir(result);
			grid.resetData(result);
		} 
	});
	var grid = new tui.Grid({
	    el: document.getElementById('grid'),
	    scrollX: false,
	    scrollY: false,
	    columns: [
	      {
	        header: 'custId(desc)',
	        name: 'custId',
	        sortingType: 'desc',
	        sortable: true
	      },
	      {
	        header: 'nickname(asc)',
	        name: 'nickname',
	        sortingType: 'asc',
	        sortable: true
	      },
	      {
	        header: 'gender',
	        name: 'gender'
	      },
	      {
	        header: 'age',
	        name: 'age'
	      },
	      {
	        header: 'totalSpend(asc)',
	        name: 'totalSpend',
	        sortingType: 'asc',
	        sortable: true
	      }
	    ]
	  });
};


</script>
<body>
<a href="excelDown">엑셀로 내려받기</a>
<div id="grid"></div>
</body>
</html>