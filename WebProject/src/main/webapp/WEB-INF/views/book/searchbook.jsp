<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>책 검색 결과</title>
</head>
<body>
[${bookname }] 의 검색 결과입니다. <br>
<c:forEach items="${list}" var="book">
${book.bookname } / ${book.publisher } / ${book.price }<br>

</c:forEach>
</body>
</html>