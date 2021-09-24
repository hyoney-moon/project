<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
body {
	padding-top: 40px;
}

.headText {
	padding: 50px;
	text-align: center;
}
</style>
</head>
<body>
회원 탈퇴
<header>
	<%@include file="../publicCSS/custheader.jsp"%>
</header>
<c:if test="${insert != null }">
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
		$(function() {
			$("#dialog-confirm").dialog({
				resizable : false,
				height : "auto",
				width : 400,
				modal : true,
				buttons : {
					"닫기" : function() {
						$(this).dialog("close");
					},
				}
			});
		});
	</script>
</c:if>
<div id="dialog-confirm" title="회원탈퇴" style="display: none">
	<p>
		<span class="ui-icon ui-icon-alert"
			style="float: left; margin: 12px 12px 20px 0;"></span>
			회원 탈퇴가 완료되었습니다.
	</p>
</div>
</body>
</html>
<%@include file="../publicCSS/footer.jsp"%>