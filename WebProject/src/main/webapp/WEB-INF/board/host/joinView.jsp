<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
<style>
	#input , #result{ display: none;}
</style>
</head>
<body>
<h1>회원 가입</h1>
<form action="/join" method="post" id="joinForm">
	<table >
		<tr><td>id</td><td><input name="id" id="id"><input type="button" id="id_check" value="중복 확인">
		<div id="id_msg"></div></td></tr>
		<tr><td>password</td><td><input name="password" type="password" id="password">
		<div id="pw_msg"></div></td></tr>
		<tr><td>name</td><td><input name="name" id="name">
		<div id="name_msg"></div></td></tr>
		<tr><td>email</td><td><input name="email" id="email">
		<div id="emailresult"></div>
		<input type="button" id="mail_ck" value="메일 인증">
		<div id="input"><input id="ck_num"> <input type="button" id="ck_b" value="인증 확인"></div>
		<div id="result"></div>
		</td></tr>
		<tr><td colspan="2"><input type="submit" value="가입"></td></tr>
	</table>
	
</form>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	let num ="";
	$(function(){
		
		$("#id_check").click(function(){
			let id = $("#id").val();	
			if(!id){
				$("#id_msg").html("아이디를 입력하세요");
				return false;
			}
			$.ajax({url:"/check_id",
			 	data:"id="+id,
				dataType:"text"}
			).done(function(data){
				if(data == ""){
					$("#id_msg").html("사용할 수 있는 아이디 입니다.")
					$("#id_msg").append("<input type='hidden' id='id_ck' value='1'>");
				}else{
					$("#id_msg").html("이미 사용중인 아이디 입니다.")
				}
			})
		});
		 $("#mail_ck").click(function(){
			 let email = $("#email").val();
			if(!email){
					$("#result").css("display","block").html("메일 주소를 입력하세요");
					
					return false;
				} 
		 $.ajax({url:"/send",
			 	data:"emailAddress="+email,
				dataType:"json"}
			).done(function(data){
				if(eval(data[1])){
					num = data[0];
					alert("메일이 전송되었습니다. 인증번호를 입력하세요.")
					$("#input,#result").css("display","block");
				}
			}); 
		}) 
		$("#ck_b").click(function(){
			let ck_num = $("#ck_num").val();
			if(ck_num == num){
				$("#result").html("인증이 확인되었습니다.")
				$("#result").append("<input type='hidden' id='ck' value='1'>");
			}else{
				$("#result").html("인증 실패했습니다. 다시 확인하세요.");
			}
		})
		
		$("#joinForm").submit(function(){
			if(!$("#id").val()){
				$("#id_msg").html("아이디를 입력해야 합니다.")
				return false;
			}if(!$("#password").val()){
				$("#pw_msg").html("비밀번호를 입력해야 합니다.")
				return false;
			}if(!$("#name").val()){
				$("#name_msg").html("이름를 입력해야 합니다.")
				return false;
			}if(!$("#email").val()){
				$("#emailresult").html("이메일을 입력해야 합니다.")
				return false;
			}if($("#id_ck").val() != 1){
				$("#id_msg").html("아이디 중복 체크 하셔야 합니다.")
				return false;
			}if($("#ck").val() != 1){
				$("#result").html("이메일 인증을 입력해야 합니다.")
				return false;
			}
		})
	})

</script>

</body>
</html>