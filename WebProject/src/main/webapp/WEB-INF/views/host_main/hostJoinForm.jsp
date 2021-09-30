<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>호스트 회원가입</title>
<style>
header {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	hegiht: 70px;
	padding: 2px;
	background: white;
	align-items: center;
}

body {
	padding-top: 140px;
}

footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
}

.box {
	width: 150px;
	height: 150px;
	border-radius: 70%;
	overflow: hidden;
}

.img {
	width: 100%;
	height: 100%;
	border-radius: 70%;
	object-fit: cover;
}
</style>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				let addr = ''; // 주소 변수
				let extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('zipcode').value = data.zonecode;
				document.getElementById("address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
	}
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
	integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
</head>

<body>
	<!-- 헤더영역 -->
	<header>
		<%@ include file="../publicCSS/hostheader.jsp"%>
	</header>

	<div class="container-sm w-25">
		<form action="hostJoin" method="post" enctype="multipart/form-data"
			enctype="multipart/form-data" onsubmit="return check()">
			<img id="img" width="100" height="100" border="1"> <input
				class="form-control mb-2" type='file' id="profile" name="profile2">
			
			<div class="input-group mb-1">
			<input id="hostId" name="hostId" type="text"
					class="form-control" placeholder="아이디"
					aria-label="Recipient's username" aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2" onclick="confirmId()">중복확인</button>
			</div>	
			<div id="hostIdDiv" class="mb-2"></div>	
			<input name="nickName" id="nickName"
				class="form-control form-floating mb-2 w-100" type="text"
				aria-label="default input example" placeholder="닉네임"
				pattern="([a-z, A-Z, 가-힣]){2,}" required="required"
				title="닉네임은 문자 2자 이상입니다.">
				
				<input name="email" id="email"
				class="form-control mb-2" type="text"
				aria-label="default input example" placeholder="이메일"
				required="required">
				
				<input type="password" name="pw"
				id="pw" class="form-control mb-2" type="text"
				aria-label="default input example" placeholder="비밀번호"
				required="required">
				
				<input type="password" name="password"
				id="password" class="form-control" type="text"
				aria-label="default input example" placeholder="비밀번호 확인"
				onblur="confirmId()" required="required">
			<div id="passwordDiv" class="mb-2"></div>

			<div class="input-group mb-1">
				<input id="zipcode" name="zipcode" id="postcode" type="text"
					class="form-control" placeholder="우편번호"
					aria-label="Recipient's username" aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2" onclick="sample6_execDaumPostcode()">검색</button>
			</div>
			<input name="address" id="address" class="form-control mb-1"
				type="text" placeholder="주소" aria-label="default input example">
			<input name="addressDetail" id="detailAddress"
				class="form-control mb-2" type="text" placeholder="상세주소"
				aria-label="default input example">
			<input class="mb-2" type="radio" name="gender" size="20" required="required" value="m" checked="checked" /> 남자
			<input class="mb-2" type="radio" name="gender" value="w" /> 여자
	<input type="submit" value="호스트 회원가입"
		class="w-100 btn btn-outline-danger mb-5" style="height: 50px;">
	</form>
	</div>
	<footer>
		<%@ include file="../publicCSS/footer.jsp"%>
	</footer>
</body>
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
		let addr = "/host/idcheck";
		// custId 란의 값을 가져오기
		let hostId = document.getElementById("hostId").value;
		// custId 값을 가지고 중복 검사를 위한 ajax 요청
		$.ajax({
			url : addr,
			data : {
				'hostId' : hostId
			},
			dataType : "json",
			success : function(data) {
				data.result
				if (data.result == true) {
					document.getElementById("hostIdDiv").innerHTML = "사용 가능한 아이디입니다.";
					document.getElementById("hostIdDiv").style.color='blue';
					idcheck = true;
				} else {
					document.getElementById("hostIdDiv").innerHTML = "사용 불가능한 아이디입니다.";
					document.getElementById("hostIdDiv").style.color='red';
					idcheck = false
				}
			}
		});

	}
	// alert("custId" + custId + :: + date.result + "date.result");
	
	// 유혀성 검사를 위한 스크립트
	// 전송 버튼을 눌렀을 경우 수행
	
	function check(){
		
		if(idcheck == false){
			document.getElementById("hostIdDiv").innerHTML = "ID 중복검사를 수행해 주세요";
			document.getElementById("hostIdDiv").style.color='red';
			document.getElementById("hostId").focus();
			return false;
		}
		
		var p1 = document.getElementById("pw").value;
		var p2 = document.getElementById("pwconfirm").value;
		if(p1 != p2){
			/*
			document.getElementById("pwDiv").innerHTML = "2개의 비밀번호가 일치하지 않습니다.";
			document.getElementById("pwDiv").style.color='red';
			document.getElementById("password").focus();
			*/
			alert("2개의 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		let pattern1 = /[0-9]/;	// 숫자 let
			pattern2 = /[a-zA-Z]/;	// 문자 let
			pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
		if(!pattern1.test(p1) || !pattern2.test(p1) || !pattern3.test(p1) || p1.length < 8) {
			alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성되어야 합니다.");
			return false;
		} 
	}
	
</script>
</html>







