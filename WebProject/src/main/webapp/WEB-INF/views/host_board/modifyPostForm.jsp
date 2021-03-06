<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Board</title>
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
	padding-top: 70px
}

div.msg {color: red;}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
	<div class="container">
	
		<form action="/host/modifyPost" method="post" id="postBoardCheck" enctype="multipart/form-data">
		<input type="hidden" name="boardNum" value="${view.boardNum }">
			공간명<br>
				<h1 class="display-5 fw-normal">${view.spaceName }</h1>
				공간유형<br>
			<div class="row justify-content-between mb-3">
				<div class="col">
					<select id="category" name="category" class="form-select"
						aria-label="Default select example">
						<c:forEach items="${cList}" var="clist">
							<option value="${clist.category }">${clist.category }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			최대 인원<br>
			<input id="headcnt" name="headcnt" class="form-control mb-3"
				type="text" placeholder="최대 인원"
				aria-label="default input example">

			공간 한줄 소개 <input id="contentOneline" name="contentOneline" class="form-control mb-3"
				type="text" placeholder="내 귀염 뽀짝한 공간을 한줄로 표현한다면?"
				aria-label="default input example">
				<div id="contentOneline_msg" class="mb-3"></div>

			<div class="mb-3 ">
				<label for="exampleFormControlTextarea1" class="form-label">공간소개</label>
				<textarea id="content" name="content" class="form-control"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<div id="content_msg" class="mb-3"></div>

			<div class="mb-3">
				시설안내 <input id="direction" name="direction" class="form-control" type="text"
					placeholder="내 귀염 뽀짝한 공간을 한줄로 표현한다면?"
					aria-label="default input example">
			</div>
			<div id="direction_msg" class="mb-3"></div>

			<div class="mb-3 ">
				<label for="exampleFormControlTextarea1" class="form-label">예약시
					주의사항</label>
				<textarea id="caution" name="caution" class="form-control"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<div id="caution_msg" class="mb-3"></div>

			<div class="mb-3">
				웹사이트 <input id="website" name="website" class="form-control" type="text"
					placeholder="웹사이트" aria-label="default input example">
			</div>

			<div class="mb-3">
				우편번호
				<div class="input-group mb-3">
					<input id="zipcode" name="zipcode" id="postcode" type="text"
						class="form-control" placeholder="주소"
						aria-label="Recipient's username" aria-describedby="button-addon2">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon2" onclick="sample6_execDaumPostcode()">검색</button>
				</div>
				주소 <input name="address" id="address" class="form-control"
					type="text" placeholder="주소" aria-label="default input example">
				<input name="addressDetail" id="detailAddress" class="form-control"
					type="text" placeholder="상세주소" aria-label="default input example">
			</div>
			<div id="address_msg" class="mb-3"></div>

			<div class="mb-3">
				<label for="formFile" class="form-label">대표이미지</label> <input
					multiple="multiple" name="frontImg" class="form-control"
					type="file" id="formFile">
			</div>
			<div id="frontImg_msg" class="mb-3"></div>

			<div class="mb-3">
				<label for="formFile" class="form-label">이미지</label> <input
					multiple="multiple" name="image" class="form-control" type="file"
					id="formFile">
			</div>
			<div id="image_msg" class="mb-3"></div>

			<div class="mb-3">
				대여 금액 /일<br>
				<div class="input-group mb-3 w-25">
					<span class="input-group-text">₩</span>
					<input name="price" id="price" class="form-control"
					placeholder="금액" aria-label="default input example">
				</div>
			</div>
			<div id="price_msg" class="mb-3"></div>

			<input type="submit" value="글 수정"
				class="w-100 btn btn-outline-danger mb-5" style="height: 50px;">
		</form>
	</div>
</body>
</html>







