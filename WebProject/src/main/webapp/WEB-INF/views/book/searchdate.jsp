<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>구매 내역</title>
</head>
<body>
<fmt:formatDate value="${start}" pattern="yyyy.MM.dd"/>부터
<fmt:formatDate value="${end }" pattern="yyyy.MM.dd"/>까지의 검색 결과 입니다.<br>

<c:forEach items="${olist }" var="order">

	${order.cust.name} / ${order.book.bookname } 
	/ ${order.saleprice } / <fmt:formatDate value="${order.orderdate }" pattern="yyyy.MM.dd"/><br>
</c:forEach>
</body>
</html>




