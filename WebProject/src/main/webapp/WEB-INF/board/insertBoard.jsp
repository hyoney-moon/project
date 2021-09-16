<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>글 작성</title>
<style>
	.orange{background-color: orange;}
	table{border-collapse : collapse;}
</style>
</head>
<body>
<form method="post">
	<table border="1">
		<tr>
			<td class="orange">제목</td>
			<td><input name="title"/></td>
		</tr>
		<tr>
			<td class="orange">작성자</td>
			<td>${member.id }</td>
		</tr>
		<tr>
			<td class="orange">내용</td>
			<td><textarea name="content" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="새글 등록"> 
			</td>
		</tr>
	</table>
</form>
</body>
</html>