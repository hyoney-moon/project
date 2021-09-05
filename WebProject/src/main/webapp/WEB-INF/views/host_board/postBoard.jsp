<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<body>
	<header>
		<div class="postion-relateive mt-5">
			<h3
				class="position-absolute d-inline top-50 start-50 translate-middle">로고</h3>
			<nav class="position-absolute top-50 end-0 translate-middle-y">
				메뉴바 검색</nav>
		</div>
	</header>
	<p>
	<div class="container">
		<form action="boardList" method="post">
			공간명<br> <input class="form-control" type="text"
				placeholder="Default input" aria-label="default input example">
			</p>

			공간유형<br>
			<div class="row justify-content-between mb-3">
				<div class="col">
					<select class="form-select" aria-label="Default select example">
						<option selected>대분류</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>
				<div class="col">
					<select class="form-select width-50%"
						aria-label="Default select example">
						<option selected>소분류</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>
			</div>


			공간 한줄 소개 <input class="form-control mb-3" type="text"
				placeholder="내 귀염 뽀짝한 공간을 한줄로 표현한다면?"
				aria-label="default input example">

			<div class="mb-3 ">
				<label for="exampleFormControlTextarea1" class="form-label">공간소개</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3"></textarea>
			</div>

			시설안내<br> <input class="form-control" type="text"
				placeholder="내 귀염 뽀짝한 공간을 한줄로 표현한다면?"
				aria-label="default input example"> 예약시 주의사항<br> <input
				class="form-control" type="text" placeholder="Default input"
				aria-label="default input example"> 웹사이트<br> <input
				class="form-control" type="text" placeholder="Default input"
				aria-label="default input example">

			<div class="mb-3">
				<label for="formFile" class="form-label">대표이미지</label> <input
					class="form-control" type="file" id="formFile">
			</div>
			<div class="mb-5">
				<label for="formFile" class="form-label">이미지</label> <input
					class="form-control" type="file" id="formFile">
			</div>
			<input type="submit" value="내 마음속에 저장 ❤"
				class="w-100 btn btn-outline-danger mb-5" style="height: 50px;">
		</form>
	</div>

</body>
</html>