<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>고객 정보</title>
</head>
<body>
<c:forEach items="${custlist }" var="cust" >
	<span class="cust" id="${cust.custid}">${cust.name}</span> /${cust.address}/ ${cust.phone} 
	<div></div>
</c:forEach> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$(".cust").click(function(){
			let span = $(this);
			let id =  $(this).attr("id");
			let url = "orderList/"+id
		
			$.ajax({
				url : url,
				dataType: "json"
			}).done(function(data){
				if($("+ div", span).html() == ""){
				$("+ div", span).html("<hr>")
				 for(let i = 0; i < data.length; i++){
					$("+ div", span).append(data[i].book.bookname +" / "+data[i].saleprice+" / "+data[i].orderdate+"<br>");
				 } 
				 $("+ div", span).append("<hr>")
				}else{
					$("+ div", span).html("");
				}
				
			}).fail(function(jqXHR, textStatus, errorThrown){
				console.log("error");
			});    
			
		})
	});
</script>
</body>
</html>