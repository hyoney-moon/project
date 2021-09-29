<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<style>
body {
	padding-top: 40px;
}

.headText {
	padding: 50px;
	text-align: center;
}

#page {
	text-decoration: none;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}
</style>
</head>
<body>
	<header>
		<%@ include file="../publicCSS/hostheader.jsp"%>
	</header>

	<div class="container-sm w-50">
		<div class="row row-cols-1 row-cols-md-2 g-4">
			<div class="card">
				<div class="card-body">
					<c:forEach var="booking" items="${booking }">
						<div class="col" id="${booking.bookNum } ">
							<c:if test="${booking.permit == 0}">
								<div>
									고객아이디::<a href="viewPost/${booking.custId }"><div
											class="img"></div></a> 예약 시작날짜:
									<p>
										<fmt:formatDate value="${booking.startDate}"
											pattern="yyyy-MM-dd" />
									</p>
									예약 종료날짜:
									<p>
										<fmt:formatDate value="${booking.endDate}"
											pattern="yyyy-MM-dd" />
									</p>
									예약 날짜:
									<p>
										<fmt:formatDate value="${booking.regDate}"
											pattern="yyyy-MM-dd" />
									</p>
									예약 인원수:
									<p>${booking.people}</p>
									예약 금액:
									<p>${booking.price}</p>
									글번호
									<p>${booking.bookNum }</p>
									<div class="btn btn-outline-secondary" id="permit"
										value="${booking.bookNum }">승인</div>
									<div class="btn btn-outline-secondary" id="reject"
										value="${booking.bookNum}">취소</div>

									<%-- <a href="/host/bookPermin/${booking.bookNum}" class="btn btn-outline-secondary"
                     id="permit" value="${booking.bookNum }">승인</a>
                     <a href="/host/bookReject/${booking.bookNum}">
                     <div class="btn btn-outline-secondary"
                     id="button-addon2">취소</div></a><hr> --%>
								</div>
							</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function() {
		// 승인
		$("#permit").click(function() {
			var bookNum = $(this).attr('value');
			var param = "bookNum=" + bookNum; // bookNum=숫자
			/* this.fadeOut() */
			$.ajax({
				url : "/host/bookPermit",
				data : param
			}).done(function(data) {
				location.reload();
			})
		});
		// 거절
		$("#reject").click(function() {
			var bookNum2 = $(this).attr('value');
			var param2 = "bookNum=" + bookNum2;
			/* this.fadeOut() */
			$.ajax({
				url : "/host/bookReject",
				data : param2
			}).done(function(args) {
				location.reload();
			})
		});

	});
</script>

</html>