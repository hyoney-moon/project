<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>책 검색</title>
</head>
<body>
<form action="searchBook">
	책 검색 : <input id="bookname" name="bookname" placeholder="책 이름을 입력하세요">
	<input type="button" value="검색" id="mybtn">
</form>
<div id="result"></div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#mybtn").click(function(){
		let bookname =  $("#bookname").val();
		let url = "searchBook/"+bookname
	
		$.ajax({
			url : url,
			dataType: "json"
		}).done(function(data){
			$("#result").html("["+data.bookname+"] 의 검색 결과<br>")
			 for(let i = 0; i < data.list.length; i++){
				$("#result").append(data.list[i].bookname +" / "+data.list[i].publisher+" / "+data.list[i].price+"<br>");
			 } 
		}).fail(function(jqXHR, textStatus, errorThrown){
			console.log("error");
		});    
		
	})
});
</script>
</body>
</html>