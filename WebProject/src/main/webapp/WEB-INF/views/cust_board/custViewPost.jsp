<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.spaceName }</title>
<!-- 폰트 css -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<style>
* {
font-family: 'Nanum Gothic', sans-serif;
}
</style>

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
.nav{
	position: pixed;
}
#spaceName{
	bottom: 20px;
	margin-bottom: 20px;
}
#map-group{
	margin-bottom: 30px;
	color: gray;
	
}
#contentOneline{
	margin-bottom: 30px;
	bottom: 100px;
}
/* 네비바고정 */
#navbar-example2{
	position: top;
	
}
.h1{
	margin-bottom: 50px;
}
.h4{
	color: gray;
	margin: 20px;
}
body {
	padding-top: 40px;
	background-color: #f6f6f6;
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
<!-- Q&A css, jquery -->
<link rel="stylesheet" href="/css/modal.css" type="text/css">
<script>
$(function(){
	var board = "board.boardNum";
    var question = $("#question");
    var answer = $("#answer");
    //var hostId = "${host.hostId}"; // ${host.hostId}
    getcommentList();
    
 // 댓글 출력
	function getcommentList(){
		let params = "boardNum="+ ${boardNum}
		$.ajax({
			type: "get",
			url: "/qna/getQna", // /board/comment
			data: params,
			dataType: "json"
		}).done(function(args){
			$("#getComment").empty();
			for(var num=0; num < args.length; num++){
				var reply = args[num].hostContent;
				var replyDate = args[num].replyDate;
				if(reply == null){ // 답변이 달리지 않았다면
					reply = "*호스트의 답변을 기다리고 있습니다";
					replyDate = "";
				}
				
				if(${!empty sessionScope.host}){ // 호스트 로그인을 한 경우 
					$("#getComment").append(
							"<ul class='qnaUl'>"+
							"<li class='qnaLi'>"+
							"<div class='custQuestion'>" +
							"<span class='profile'>" +
							"<img class='profileImg' src=/img/profileImage.png></img>" +
							"</span>" +
							"<strong>" + args[num].nickName + "</strong>" +
							"<p class='content'>" + args[num].content + "</p>" +
							"<div class='content'>" + args[num].commentDate + "</div>" +
							"</div>" +
							
							"<div class='hostAnswer'>" +
							"<p class='hostReplyTitle'>"+
							"호스트의 답글" +"</p>" +
							"<p class='hostReplyContent'>" +
							reply + "</p>" +
							"<div class='content'>" + replyDate + "</div>" +
							
							"<button id='" + "popupAnswer'" + 
							" value='" + args[num].qnaNum + "'>답변하기</button>" +
							"</div>" +
							"</li>" + 
							"</ul>"
					);
				} else { // 호스트로 로그인하지 않은 경우
					$("#getComment").append(
							"<ul class='qnaUl'>"+
							"<li class='qnaLi'>"+
							"<div class='custQuestion'>" +
							"<span class='profile'>" +
							"<img class='profileImg' src=/img/profileImage.png></img>" +
							"</span>" +
							"<strong>" + args[num].nickName + "</strong>" +
							"<p>" + args[num].content + "</p>" +
							"<div>" + args[num].commentDate + "</div>" +
							"</div>" +
							
							"<div class='hostAnswer'>" +
							"<p class='hostReplyTitle'>"+
							"호스트의 답글" +"</p>" +
							"<p class='hostReplyContent'>" +
							reply + "</p>" +
							"<div>" + replyDate + "</div>"
							)
				}
			} //for문 종료
		}) // done 종료
	} // getcommentList() 종료
    
 	  // 질문작성 클릭 이벤트
	  $("#confirm").click(function(){
		  $.ajax({
				url: "/qna/question",
				type: "POST",
				dataType: "CustQna",
				data: {
					board : ${boardNum},
					profile : "custprofile",
					content : $("#question").val(),
					nickName : "${customer.nickName}",
				},
				complete : function(){
					modalClose(); // modal 닫기
					question.val("");
					$("#getComment").empty();
					getcommentList();
				}
			})
	  });
		// 답변하기 버튼 클릭 이벤트(모달창 띄우기)
		$('#getComment').on('click', '#popupAnswer', function() {
			qnaNumber = $(this).attr('value');
			document.getElementById("modalQnaNum").value=qnaNumber;
		$("#popupAnswer").css('display','flex').hide().show();
		});
		
		// 질문하기 클릭 이벤트 모달창 띄우기
	  $("#modal-open").click(function(){
		  //$("#popup").show();
	      $("#popup").css('display','flex').hide().show();
	      //팝업을 flex속성으로 바꿔준 후 hide()로 숨기고 다시 show()으로 효과
	  });
	
		// 취소 클릭 이벤트 모달창 닫기
	  $("#close").click(function(){
	      modalClose(); //모달 닫기 함수 호출
	  });
		
		// 답변 취소 클릭 이벤트 모달창 닫기 
		$('#popupAnswer').on('click', "#close", function(){
			modalClose();
	  })
	  // 답변 등록 클릭 이벤트 
		$('#popupAnswer').on('click', "#confirm", function(){
			$.ajax({
				url:"/qna/answer",
				type: "POST",
				dataType: "CustQna",
				data: {
					qnaNum : $("#modalQnaNum").val(),
					hostContent : $("#answer").val(),
					hostId : "${host.hostId}",
				},
				complete : function(){
					modalClose();
					answer.val("");
					$("#answer").empty();
					getcommentList();
				}
			}) 
	  })
	  
		// 모달창 닫기 함수
	  function modalClose(){
	      $("#popup").hide();
	      $("#popupAnswer").hide();
	  }
		
	});
</script>
<script>


/* function navigo (){
	  const header = document.querySelector('header'); //헤더부분획득
	  const header2 = document.querySelector('img'); // 상단이미지
	  const headerheight = header.clientHeight + hearder2.clientHeight;//헤더높이
	document.addEventListener('scroll', onScroll, { passive: true });//스크롤 이벤트
	 function onScroll () {
	     const scrollposition = pageYOffset;//스크롤 위치
	   const nav = document.querySelector('nav');//네비게이션
	   if (headerheight<=scrollposition){//만약 헤더높이<=스크롤위치라면
	     nav.classList.add('fix')//fix클래스를 네비에 추가
	   }
	   else {//그 외의 경우
	     nav.classList.remove('fix');//fix클래스를 네비에서 제거
	   }
	 } 
	  
	}
	navigo() */
</script>
</head>
<body style="background-color: #f6f6f6;">
	<header>
		<%@ include file="../publicCSS/custheader.jsp"%>
	</header>
	<div class="container">
	<h1>${board.spaceName }</h1>
	<h5>${board.contentOneline }</h5>
		<div id="carouselExampleControls" class="carousel slide w-100"
			data-bs-ride="carousel">
			<div class="carousel-inner list_item w-100" id="img">
				<c:forEach items="${fis }" var="fis" begin="0" end="0">
					<div class="carousel-item active w-100">
						<img src="${fis.filePath }" class="d-block w-500 list_img"
							alt="...">
					</div>
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
				</c:forEach>
				<c:forEach items="${fis }" var="fis" begin="1" end="${fisize }">
					<div class="carousel-item">
						<img src="${fis.filePath }" class="d-block w-500 list_img"
							alt="...">
					</div>
				</c:forEach>
			</div>
					<!-- 네비바 -->

<nav id="navbar-example2" class="navbar navbar-light bg-light px-3">
  <a class="navbar-brand" href="#">위치추적</a>
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link" href="#scrollspyHeading1">공간정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#scrollspyHeading2">Second</a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Dropdown</a>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#scrollspyHeading3">Third</a></li>
        <li><a class="dropdown-item" href="#scrollspyHeading4">Fourth</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#scrollspyHeading5">Fifth</a></li>
      </ul>
    </li>
  </ul>
</nav>
<!-- 네비정보 -->
<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="0" class="scrollspy-example" tabindex="0">
	<h4 id="scrollspyHeading1">공간 소개</h4>
			<p>
			<h1>공간소개</h1>
			${board.content }
			</p>
	<h4 id="scrollspyHeading2">이용 안내</h4>
			<p>
			<h1>이용안내</h1>
			${board.direction }
			</p>
	 <h4 id="scrollspyHeading3">주의 사항</h4>
			<p>
			<h1>주의사항</h1>
			${board.caution }</p>

<!-- Q&A -->
	<h4 id="scrollspyHeading4">Q&A</h4>
		<div>
			<h1 id="qna">Q&A</h1>
			<!-- 질문하기 모달 버튼 -->
			<div id="modal-open" class="button">
				<a
					style="position: absolute; color: #fff; padding: 5px 12px 5px; font-size: 1.2em; border-radius: 100px; background-color: #704de4; cursor: pointer; text-decoration: none;"
					class="btn_qna_write"> <span
					style="font-weight: bold;">✍ 질문 작성하기</span>
				</a>
			</div>
			<!-- 질문하기 modal  -->
			<div class="container">
				<div class="popup-wrap" id="popup">
					<div class="popup">
						<div class="popup-head">
							<span class="head-title">질문 작성하기</span>
						</div>
						<div class="popup-body">
							<div class="body-content">
								<div class="body-titlebox">
								※질문은 전체 공개됩니다
								</div>
								<div class="body-contentbox">
									<textarea id="question" name="content" rows="6" cols="43" placeholder="질문을 작성하세요."></textarea>
								</div>
							</div>
						</div>
						<div class="popup-foot">
							<span class="pop-btn confirm" id="confirm">등록</span> <span
								class="pop-btn close" id="close">취소</span>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 답변하기 modal -->
			<div class="container">
				<div class="popup-wrap" id="popupAnswer">
					<div class="popupAnswer">
						<div class="popup-head">
							<span class="head-title">답변 작성하기</span>
						</div>
						<div class="popup-body">
							<div class="body-content">
								<div class="body-titlebox">
								※답변은 전체 공개됩니다
								</div>
								<div class="body-contentbox">
									<textarea id="answer" name="content" rows="6" cols="43" placeholder="답변을 작성하세요."></textarea>
								</div>
							</div>
						</div>
						<div class="popup-foot">
							<input type="hidden" value="" id="modalQnaNum">
							<span class="pop-btn confirm" id="confirm">등록</span> <span
								class="pop-btn close" id="close">취소</span>
						</div>
					</div>
				</div>
			</div>


			<!-- 답변하기 modal -->
			<!-- The Modal -->
			<div id="myModal2" class="modal">
				<div class="modal-content">
					<span class="close">&times;</span>
					<p>
						<strong>답변하기</strong>
					</p>
					<textarea id="content2" name="content" rows="15" cols="40"></textarea>
					<input type="hidden" value="" id="modalQnaNum">
					<button id="cmtCnt-btn2">작성</button>
				</div>
			</div>

			<br> <br>
			<div id=getComment></div>
		</div>
		<br><br><br><br><br><br><br><br><br><br><br><br>
		<!-- Review  -->
		<div>
			<div class="board">
				<div class="board_tit">
					<h3>REVIEW</h3>
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

 
 
  
</div>
</div>
  <h4 id="scrollspyHeading5">예약하기</h4>
  <!-- booking -->
		<div>
			<form method="post" action="/kakaoPay" id="paybutton">
				<div class="input-group" style="width: 250px;">
					<select class="form-select form-select-sm" name="count"
						aria-label=".form-select-sm example">
						<option selected>총원수</option>
						<c:forEach begin="1" end="${board.headcnt}" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</div>
				<div class="input-group">
 					<span class="input-group-text" style="color: white; background-color: #704de4;">예약</span> 
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
			<div class="map-group" id="map-group">
			<p style="color: black; font-size: 24px;">${board.address }</p>
			<p style="color: #656565;">${board.zipcode }</p>
			<div id="map"></div>
			</div>
		</div>

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