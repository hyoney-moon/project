<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><h1>Kakao Login Test</h1></title>
</head>
<body>
<c:if test="${userId==null}">
	<span>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=67cc6a45d587b4681e133d99bdf346ba&redirect_uri=http://localhost:8088/login&response_type=code">
			<img src = "img/kakao_login_medium_narrow.png">
		</a>
	</span>
</c:if>
<c:if test="${userId!=null}">
	<span>
		<form name="logout" action="http://localhost:8088/logout">
			<input type="submit" value="로그아웃">
		</form>
	</span>
</c:if>


</body>
</html>


</body>
</html>