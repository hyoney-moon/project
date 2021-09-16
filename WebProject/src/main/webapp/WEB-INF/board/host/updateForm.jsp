<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>Update Form</h3>
<form method="post" name="form">
	ID : ${member.id}<br>
	PW : <input name="password"><br>
	NAME : <input name="name"><br>
	E-MAIL : <input name="email"><br>
	<input type="submit" value="UPDATE"><br>
</form><br>

<h3>Member Withdrawal</h3>
<form action="deleteMember" name="form">
	ID : ${member.id}<br>
	PW : <input name="password"><br>
	<input type="submit" value="DELETE"><br>
</form>
<script type="text/javascript">
	
</script>
</body>
</html>