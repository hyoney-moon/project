<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="content">
	<!-- 회원가입 -->
	<form action="/join" id="registerform" enctype="multipart/form-data" method="post"
	onsubmit="return check()">
		<p align="center">
		<table border="1" width="50%" height="80%" align='center'>
			<tr>
				<td colspan="3" align="center"><h2>회원 가입</h2></td>
			</tr>
			
			
			<!-- 프로필 사진 첨부 -->
			<tr>
				<td rowspan="6" align="center">	<p></p>
				<img id="img" width="100" height="100" border="1" /> <br />
				<br /> <input type='file' id="profile" name="profile" /><br /></td>
			</tr>
			
			

			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;아이디</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input name="custId"	id="custId" size="30" maxlength=50" onblur="confirmId()" required="required" />
				</td>
				<div id="custIdDiv"></div>
			</tr>
			
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;닉네임</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input name="nickName" size="20" 
				pattern="([a-z, A-Z, 가-힣]){2,}" required="required"
					title="닉네임은 문자 2자 이상입니다."/>
				</td>
			</tr>
			
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50
					required="required" />
					<div id="emailDiv"></div>
				</td>
			</tr>
			
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" name="password" id="pw"
					size="20" required="required" />
					<div id=passwordDiv"></div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" id="password"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;상세주소</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="addressDetail" name="addressDetail"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;주소</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="address" name="address"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;우편번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="zipcode" name="zipcode"
					size="20" required="required" />
				</td>
			</tr>
			
			<tr>
         		<td col style="background:papayawhip"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;성별</font></td>
         		<td>&nbsp;&nbsp;&nbsp;
         		<input type="radio" name="gender" 
         		size="20" required="required" value="m" checked="checked"/>
         		남자
         		<input type="radio" name="gender" value="w"/>
         		여자
         		</td>
      	 	</tr>
			
			<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="회원가입"/>
					<input type="button" value="메인으로" class="btn btn-success"
					onclick="javascript:window.location='../'">
					<p></p>
				</td>
			</tr>
			
		</table>
	</form>
	<br />
	<br />
</section>




<script>
//프로필사진 미리보기를 위한 스크립트임
let filename = ''
	//change 이벤트가 발생하면 readURL 호출
	//change - 내용이 변경되면 호출되는 이벤트
	document.getElementById("profile").addEventListener('change', function() {
		readURL(this);
	});
	
	// 이미지 파일을 선택했을 때 미리보기를 수행하는 메소드
	function readURL(input) {
		if (input.files && input.files[0]) {
			filename = input.files[0].name;
			let ext = filename.substr(filename.length - 3, filename.length);
			let isCheck = false;
			if ((ext.toLowerCase() == "jpg" || ext.toLowerCase() == "gif" || 
				 ext.toLowerCase() == "png")) {
				isCheck = true;
			}
			
			if (isCheck == false) {
				alert("jpg, gif, png 형식의 이미지 파일만 업로드 가능합니다.");
				return;
			}
			let reader = new FileReader();

			reader.onload = function(e) {
				document.getElementById('img').src = e.target.result;
			}
			reader.readAsDataURL(input.files[0]);
		}
	};
	
	// custId 중복 검사 여부를 저장할 변수
	// 이 변수의 값이 false 인 경우 중복 검사를 통과하지 못한 것이다
	let idcheck= false;

	function confirmId() {
		let addr = "idcheck";
		// custId 란의 값을 가져오기
		let custId = document.getElementById("custId").value;
		// custId 값을 가지고 중복 검사를 위한 ajax 요청
		$.ajax({
			url : addr,
			data : {
				'custId' : custId
			},
			dataType : "json",
			success : function(data) {
				if (data.result == true) {
					document.getElementById("custIdDiv").innerHTML = "사용 가능한 아이디입니다.";
					document.getElementById("custIdDiv").style.color='blue';
					idcheck = true;
				} else {
					document.getElementById("custIdDiv").innerHTML = "사용 불가능한 아이디입니다.";
					document.getElementById("custIdDiv").style.color='red';
					idcheck = false
				}
			}
		});
	}
	
	// 유혀성 검사를 위한 스크립트
	// 전송 버튼을 눌렀을 경우 수행
	function check(){
		if(idcheck == false){
			document.getElementById("custIdDiv").innerHTML = "ID 중복검사를 수행해 주세요";
			document.getElementById("custIdDiv").style.color='red';
			document.getElementById("custIdDiv").focus();
			return false;
		}
		let password = document.getElementById("password").value;
		let passwordconfirm = document.getElementById("passwordconfirm").value;
		if(password != passwordconfirm){
			document.getElementById("passwordDiv").innerHTML = "2개의 비밀번호가 일치하지 않습니다.";
			document.getElementById("passwordDiv").style.color='red';
			document.getElementById("password").focus();
			return false;
		}
		
		let pattern1 = /[0-9]/;	// 숫자 let
		pattern2 = /[a-zA-Z]/;	// 문자 let
		pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
		if(!pattern1.test(password) || !pattern2.test(password) || !pattern3.test(password) || password.length < 8) {
			alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성되어야 합니다.");
			return false;
		} 
	}

</script>

