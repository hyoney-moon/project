<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<style type="text/css">
.star_rating {font-size:0; letter-spacing:-4px;}
.star_rating a {
    font-size:22px;
    letter-spacing:0;
    display:inline-block;
    margin-left:5px;
    color:#ccc;
    text-decoration:none;
}
.star_rating a:first-child {margin-left:0;}
.star_rating a.on {color:#777;}
	</style>
	
	<script type="text/javascript">
	$( document ).ready(function() {
		$( ".star_rating a" ).click(function() {
		     $(this).parent().children("a").removeClass("on");
		     $(this).addClass("on").prevAll("a").addClass("on");
		     var starRate = $(this).attr('id');
		     $("#review_star").val(starRate);
		     return false;
		});
	});
	</script>
	
</head>
<body>

	<div class="main">
		<div class="field_head">
			<h3 class="tit">리뷰 수정</h3>
		</div>
	

	<form action="/update" method="post">
		<input type="hidden" name="review_id" value=${review_id }>
		<input type="hidden" name="boardNum" value=${boardNum }>
		
	
	<table border="1" style="width: 80%">
	  <tr>
	  	<td>별점</td>
	  	<td class="star_rating">
    		 <a href="#" class="on" id="1">★</a>
   			 <a href="#" class="on"	id="2">★</a>
    		 <a href="#" class="on"	id="3">★</a>
   			 <a href="#" id="4">★</a>
   			 <a href="#" id="5">★</a>
   			 <input type="hidden" id="review_star" name="review_star" value="3">
		</td>
	  </tr>
	  <tr>
	  	<td>파일 첨부(최대 20MB)</td>
	  	<td><input type="file" name="review_file"></td>
	  </tr>
	  <tr>
	  	<td>*내용</td>
	  	<td>
	  		<textarea rows="5" cols="50" name="review_content"></textarea>
	  	</td>
	  </tr>
	  <tr>
	  	<td colspan="2" style="text-align: center;">		
	  	<input type="submit" value="글 수정" id="btnIns">
	  	<a href="/customer/viewPost/${boardNum}">글 목록</a>
	  	</td>
	  </tr>
	</table>
	</form>
</body>
</html>