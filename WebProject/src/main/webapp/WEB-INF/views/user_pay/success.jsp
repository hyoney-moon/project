<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html xmlns: th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>���� ������</title>
</head>
<body>
īī������ ������ ���� �Ͽ����ϴ�.

���� �� : ${info.approved_at }<br>
�ֹ� ��ȣ : ${info.partner_order_id }<br>
��ǰ�� :	${info.item_name }<br>
��ǰ ���� : ${info.quantity }<br>
���� �ݾ� : ${info.amount.total }<br>
���� ��� : ${info.payment_method_type }<br>

<h2>[[${info}]]</h2>

</body>
</html>