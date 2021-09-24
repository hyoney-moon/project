<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>예약 페이지</title>

 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript">var disabledDays = ${dateList};</script>
  <script type="text/javascript" 
src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c04294f72056d3a53a87841b928c58e6&libraries=services"></script> 
<style>
#map {width:500px; height:400px;padding: 10px;margin-top: 30px;margin-bottom: 30px;}
#paybutton{margin-top: 20px;}
</style>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>예약 페이지</title>
<link rel="stylesheet" href="assets/css/booking.css" />
<script>

</script>

</head>
<body>
<div class="container">
<form>
	<h1>${board.contentOneline }</h1>
	<img src="../../../images/fulls/01.jpg" alt="..." class="img-thumbnail">
	<h2>${board.content }</h2>
	<h1>${board.address }</h1>
	<h1>${board.price }</h1>
</form>
	<h2>결제하는 페이지</h2>
	<form method="post" action="/kakaoPay" id="paybutton">
		<div class="input-group">
			<select class="peoplecount" name="count">
				<option selected>총원수</option>
				 <c:forEach begin="1" end="${board.headcnt}" var="i">
				<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</div>
			<div class="bookingdate" id="Datepicker">
				<input type="text" id="startDatepicker" name="startDatepicker">start
				<input type="text" id="endDatepicker" name="endDatepicker">end
				<input type="hidden" name="boardNum" value="${board.boardNum}">
		</div>
	
	
	<input type="image" id="payimg" src="../../../images/fulls/kakaoPay.png"/>
	</form>
 <div id="map"></div> 
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
</body>
</html>