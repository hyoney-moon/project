<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>예약 페이지</title>

<!-- 달력 기능 사용 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript">var disabledDays = ${dateList};</script>

<style>
.img{
		padding: 40px;
		size: 2px;
	}
</style>
<!-- 달력  -->
</head>
<body>
<div class="container">
<form>
	<h1>${board.title }</h1>
	<img src="../../../images/fulls/01.jpg">
	<h2>${board.content }</h2>
	<h1>${board.address }</h1>
	<h1>${board.price }</h1>
</form>
	<h2>결제하는 페이지</h2>
	<form method="post" name="pay_form">
		<div class="input-group">
			<select class="peoplecount" name="count">
				<option selected>총원수</option>
				 <c:forEach begin="1" end="${board.headcnt}" var="i">
				<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<div class="input-group-append">
			</div>
			<br>
			<div class="bookingdate">
				<input type="text" id="datepicker" name="datepicker"> 
				<a href="bookingPay">결제</a>
				<input type="submit" id="bookingcall"value="예약하기" >
			</div>
		</div>
	</form>
</div>

<script>
$(function(){
	$("#datepicker").datepicker({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    minDate : '0',
	    showMonthAfterYear: true,
	    changeMonth: true,
	    changeYear: true,   
	    yearSuffix: '년',
	    beforeShowDay: disableSomeDay 
	});// 제외할 날짜

	
})

function disableSomeDay(date) {
    var month = date.getMonth();
    var dates = date.getDate();
    var year = date.getFullYear();
    
         
    // 배열에 해당하는 날짜는 0번째 index에 false를 담아 리턴해준다.
    for (i = 0; i < disabledDays.length; i++) {
        if($.inArray(year + '-' +(month+1) + '-' + dates, disabledDays) != -1) {
            return [false];
        }
    }
    return [true];
}  
</script>
</body>
</html>