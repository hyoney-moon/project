<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>���� ������</title>
<link rel="stylesheet" href="assets/css/booking.css" />
<!-- �޷�  -->
</head>
<body>
<div class="container">
	<a href="">
	<img src="../../../images/fulls/01.jpg">
	</a>
	<h2>�����ϴ� ������</h2>
	<form action="bookingpay">
		<div class="input-group">
			<select class="peoplecount">
				<option selected>�ѿ���</option>
				<option value="1">1��</option>
				<option value="2">2��</option>
				<option value="3">3��</option>
				<option value="4">4��</option>
				<option value="5">5��</option>
				<option value="6">6��</option>
			</select>
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button">�ο���</button>
			</div>
			<br>
			<div class="bookingdate">
				<input type="date"> 
				<a href="bookingPay">����</a>
				<input type="submit" id="bookingcall"value="�����ϱ�" >
			</div>
		</div>
	</form>
</div>
</body>
</html>