<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form name="question" method="post" action="/questions/insertQna">
	<input type="hidden" name="qna_num" value="${result.qna_num}">
	<input type="hidden" name="reg_date" value="${result.reg_date}">
	<input type="hidden" name=profile" value="profile">
	<input type="hidden" name="cust_id" value="${customer.cust_id}"> <!--value="${cust_id}"-->
	<input type="hidden" name="board_num" value="1"> <!-- value="${number}" -->
	<textarea name="content" rows="5" cols="5"></textarea>
	<input type="submit" value="등록">
</form>
</body>
</html>