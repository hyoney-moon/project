<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form name="question" method="post" action="/questions/QnaResult">
	<input type="hidden" value="cust_id"> <!--value="${cust_id}"-->
	<input type="hidden" value="number"> <!-- value="${number}" -->
	<textarea rows="5" cols="5"></textarea>
	<input type="submit" value="등록">
</form>
</body>
</html>