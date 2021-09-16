<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>주문하기</title>
</head>
<body>
주문 내역을 입력하세요.
	<form action="order">
		<select name="custid">
			<c:forEach items="${cList}" var ="cust">
				<option value="${cust.custid}">${cust.name}</option>
			</c:forEach>
		</select>
		<select name="bookid">
			<c:forEach items="${bList}" var ="book">
				<option value="${book.bookid}">${book.bookname}(${book.publisher})</option>
			</c:forEach>
		</select>
		<input name="saleprice" placeholder="가격 입력">
		<input type="submit" value="주 문">
	</form>
</body>
</html>











