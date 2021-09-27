<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.spaceName }</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript">var disabledDays = ${dateList};</script>
  <script type="text/javascript" 
src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c04294f72056d3a53a87841b928c58e6&libraries=services"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<style>
#map {
	width:500px; 
	height:400px;
	padding: 10px;
	margin-top: 30px;
	margin-bottom: 30px;
}
body {
	padding-top: 40px;
}

.list_item {
	display: inline-block;
	width: 800px;
	margin: 2px;
	overflow: hidden;
}

.list_img {
	display: inline-block;
	width: 100%;
	height: 500px;
	overflow: hidden;
	object-fit: cover;
}

.w-100 {
	width: 100%;
}


</style>
</head>
<body>
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>
	<div class="container">
	<h1 class="display-4 fw-normal">${board.spaceName }</h1>
	<h5 class="lead fs-4 mb-3">${board.contentOneline }</h5>
		<div id="carouselExampleControls" class="carousel slide w-100"
			data-bs-ride="carousel">
			<div class="carousel-inner list_item w-100">
				<c:forEach items="${fis }" var="fis" begin="0" end="0">
					<div class="carousel-item active w-100">
						<img src="${fis.filePath }" class="d-block w-500 list_img"
							alt="...">
					</div>
				</c:forEach>
				<c:forEach items="${fis }" var="fis" begin="1" end="${fisize }">
					<div class="carousel-item">
						<img src="${fis.filePath }" class="d-block w-500 list_img"
							alt="...">
					</div>
				</c:forEach>
			</div>
			<p class="lead">
			<h1 class="display-6">공간소개</h1>
			${board.content }
			</p>
			<p>
			<h1 class="display-6">이용안내</h1>
			${board.direction }
			</p>
			<p>
			<h1 class="display-6">주의사항</h1>
			${board.caution }
			</p>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<!-- Review  -->
		<div>
			<div class="board">
				<div class="board_tit">
					<h2>REVIEW</h2>
					<a href="/insertReview/${boardNum }">작성</a> <a href="/chat">채팅</a>
					<div class="sort-wrap clearfix">
						<ul>
							<li>상품에 대한 후기를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로
								이동될 수 있습니다.</li>
						</ul>
						<div id="review"></div>
					</div>
				</div>

			</div>

			<table border="1">
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>별점</th>
				</tr>
				<c:forEach items="${reviewDto}" var="re">
					<tr>
						<td>${re.review_id}</td>
						<td><a href="view_content">${re.review_content}</a></td>
						<td>${re.cust_id}</td>
						<td>${re.review_star}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- booking -->
		<div>
			<form method="post" action="/kakaoPay" id="paybutton">
				<div class="input-group">
					<select class="form-select form-select-sm" name="count"
						aria-label=".form-select-sm example">
						<option selected>총원수</option>
						<c:forEach begin="1" end="${board.headcnt}" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</div>
				<div class="input-group">
					<span class="input-group-text">예약</span>
					<div class="bookingdate" id="Datepicker">
						<input type="text" id="startDatepicker" name="startDatepicker"
							aria-label="First name" class="form-control" value="start">
						<input type="text" id="endDatepicker" name="endDatepicker"
							aria-label="Last name" class="form-control" value="end">
						<input type="hidden" name="boardNum" value="${board.boardNum}">
					</div>
				</div>


				<input type="image" id="payimg"
					src="../../../images/fulls/kakaoPay.png" />
			</form>
			<div id="map"></div>
			<h1>${board.address }</h1>
			<h2>${board.zipcode }</h2>
		</div>




		<script>
// 달력datePicker 건들면안되용  -->
$(function(){
	$("#startDatepicker").datepicker({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    minDate : '0',
	    showMonthAfterYear: true,
	    changeMonth: true,
	    changeYear: true,   
	    yearSuffix: '년',
	    beforeShowDay: disableSomeDay 
	});// 제외할 날짜

	
})

function disableSomeDay(date) {
    var month = date.getMonth();
    var dates = date.getDate();
    var year = date.getFullYear();
    
         
    // 배열에 해당하는 날짜는 0번째 index에 false를 담아 리턴해준다.
    for (i = 0; i < disabledDays.length; i++) {
        if($.inArray(year + '-' +(month+1) + '-' + dates, disabledDays) != -1) {
            return [false];
        }
    }
    return [true];
    
}
    $(function(){
    	$("#endDatepicker").datepicker({
    	    dateFormat: 'yy-mm-dd',
    	    prevText: '이전 달',
    	    nextText: '다음 달',
    	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	    dayNames: ['일','월','화','수','목','금','토'],
    	    dayNamesShort: ['일','월','화','수','목','금','토'],
    	    dayNamesMin: ['일','월','화','수','목','금','토'],
    	    minDate : '0',
    	    showMonthAfterYear: true,
    	    changeMonth: true,
    	    changeYear: true,   
    	    yearSuffix: '년',
    	    beforeShowDay: disableSomeDay 
    	});// 제외할 날짜

    	
    })

    function disableSomeDay(date) {
        var month = date.getMonth();
        var dates = date.getDate();
        var year = date.getFullYear();
        
             
        // 배열에 해당하는 날짜는 0번째 index에 false를 담아 리턴해준다.
        for (i = 0; i < disabledDays.length; i++) {
            if($.inArray(year + '-' +(month+1) + '-' + dates, disabledDays) != -1) {
                return [false];
            }
        }
        return [true];
}  
    

 // 카카오 API부분 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
var address = '${board.address}';
geocoder.addressSearch(address, function(result, status) {
//'경기도 고양시 덕양구 원당동 372-2'${board.address}
// 정상적으로 검색이 완료됐으면 
 if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: coords
    });

    // 인포윈도우로 장소에 대한 설명을 표시합니다
    // 해당 공간명 입력
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;">${board.spaceName}</div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
} 
});   

</script>
	</div>
	<footer>
		<%@ include file="../publicCSS/footer.jsp"%>
	</footer>
</body>
</html>