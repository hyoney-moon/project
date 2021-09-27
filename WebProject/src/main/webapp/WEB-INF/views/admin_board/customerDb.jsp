<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<style>
* {
font-family: 'Nanum Gothic', sans-serif;
}
#grid {
	width: 900px;
	margin: auto;
	margin-top: 10px; 
}
.excelDown {
	color: #fff;
	margin-left: 400px;
	padding: 5px 12px 5px; 
	font-size: 1em; 
	border-radius: 100px; 
	background-color: #009432; 
	text-decoration: none;
}
.excelDown:hover {
	color: #fff;
}
</style>
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
	        name: 'nickName',
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
		    sortingType: 'desc',
	        sortable: true
		  }
	    ]
	  });
};


</script>
<body>
<header>
		<%@ include file="../publicCSS/adminheader.jsp"%>
</header>
<br><br>
<h1 style= "text-align: center;">일반회원 정보</h1>
<a href="excelDown" class="excelDown">엑셀로 내려받기</a>
<div id="grid"></div>
</body>
</html>