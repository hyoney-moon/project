<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html xmlns: th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>성공 페이지</title>
</head>
<body>
카카오페이 결제가 성공 하였습니다.

결제 일 : ${info.approved_at }<br>
주문 번호 : ${info.partner_order_id }<br>
상품명 :	${info.item_name }<br>
상품 수량 : ${info.quantity }<br>
결제 금액 : ${info.amount.total }<br>
결제 방법 : ${info.payment_method_type }<br>

<h2>[[${info}]]</h2>

</body>
</html>