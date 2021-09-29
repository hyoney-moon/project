<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
카카오페이 결제가 정상적으로 완료되었습니다.
 
결제일시:     		[[${book.regDate}]]<br/>
주문번호:    		[[${book.bookNum}]]<br/>
 공간명:    		[[${boardNum.spaceName}]]
결제금액:    		[[${book.price}]]<br/>
대여 시작일:    	[[${book.startDate}]]<br/>
대여 종료일:   	[[${book.endDate}]]<br/>
사용하는 인원:		[[${book.people }]]<br/>
<a href="customer/main">예약완료</a>
 
 
 
</body>
</html>
