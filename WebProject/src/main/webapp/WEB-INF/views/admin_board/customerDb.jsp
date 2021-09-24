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
		url : "/adminCustomerDb/getCustomerDb",
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
	        header: '아이디',
	        name: 'custId',
	        sortingType: 'desc',
	        sortable: true
	      },
	      {
	        header: '닉네임',
	        name: 'nickname',
	        sortingType: 'asc',
	        sortable: true
	      },
	      {
	        header: '성별',
	        name: 'gender'
	      },
	      {
	        header: '나이',
	        name: 'age'
	      },
	      {
	        header: '총 지출액',
	        name: 'totalSpend',
	        sortingType: 'asc',
	        sortable: true
	      },
	      {
		    header: '보유 포인트',
		    name: 'cash',
		    sortingType: 'asc',
		    sortable: true
		  },
	      {
		    header: '가입일',
		    name: 'joinDate',
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