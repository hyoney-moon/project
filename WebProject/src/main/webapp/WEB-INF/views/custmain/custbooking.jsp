<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>예약 페이지</title>
<link rel="stylesheet" href="assets/css/booking.css" />
<!-- 달력  -->
</head>
<body>
<div class="container">
	<a href="">
	<img src="../../../images/fulls/01.jpg">
	</a>
	<h2>결제하는 페이지</h2>
	<form action="bookingpay">
		<div class="input-group">
			<select class="peoplecount">
				<option selected>총원수</option>
				<option value="1">1명</option>
				<option value="2">2명</option>
				<option value="3">3명</option>
				<option value="4">4명</option>
				<option value="5">5명</option>
				<option value="6">6명</option>
			</select>
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button">인원수</button>
			</div>
			<br>
			<div class="bookingdate">
				<input type="date"> 
				<a href="bookingPay">결제</a>
				<input type="submit" id="bookingcall"value="예약하기" >
			</div>
		</div>
	</form>
</div>
</body>
</html>