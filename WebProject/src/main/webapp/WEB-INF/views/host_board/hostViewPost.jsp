<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.spaceName }</title>
<title>상세보기</title>
<!-- 폰트 css -->
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
.star_rating {font-size:0; letter-spacing:-4px;}
.star_rating span {
    font-size:22px;
    letter-spacing:0;
    display:inline-block;
    margin-left:5px;
    color:#ccc;
    text-decoration:none;
    }
.star_rating span.on {color:#8258FA;}
</style>
</head>
<!-- Q&A -->
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
                      "<img class='profileImg' src=" + args[num].profile + "></img>" +
                      //"<img class='profileImg' src=/img/profileImage.png></img>" +
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
                      "<img class='profileImg' src=" + args[num].profile + "></img>" +
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
					profile : "${customer.profile}",
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
<body style="background-color: #f6f6f6;">
	<header>
		<%@ include file="../publicCSS/hostheader.jsp"%>
	</header>
	<div class="container-sm w-50">
		<h1 class="display-4 fw-normal">${view.spaceName }</h1>
		<h5 class="lead fs-4 mb-3">${view.contentOneline }</h5>
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
		<nav id="navbar-example2" class="navbar navbar-light bg-light px-3">
			<ul class="nav">
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#scrollspyHeading1">공간 소개</a></li>
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#scrollspyHeading2">이용 안내</a></li>
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#scrollspyHeading3">주의 사항</a></li>
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#qna">Q&A</a></li>
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#review">리뷰</a></li>
				<li class="nav-item"><a
					style="color: #656565; text-decoration: none; font-weight: bold;"
					class="nav-link" href="#location">위치</a></li>
			</ul>
		</nav>
<!-- 네비정보 -->
<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="0" class="scrollspy-example" tabindex="0">
   <h4 id="scrollspyHeading1">공간 소개</h4>
         <p>
         ${view.content }
         </p>
   <h4 id="scrollspyHeading2">이용 안내</h4>
         <p>
         ${view.direction }
         </p>
    <h4 id="scrollspyHeading3">주의 사항</h4>
         <p>
         ${view.caution }</p>


		<!-- Q&A -->
		<div>
			<h1 id="qna">Q&A</h1>
			<!-- 질문하기 모달 버튼 -->
			<div id="modal-open" class="button">
				<a
					style="position: absolute; color: #fff; padding: 5px 12px 5px; font-size: 1.2em; border-radius: 100px; background-color: #704de4; cursor: pointer; text-decoration: none;"
					class="btn_qna_write"> <span style="font-weight: bold;">✍
						질문 작성하기</span>
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
								<div class="body-titlebox">※질문은 전체 공개됩니다</div>
								<div class="body-contentbox">
									<textarea id="question" name="content" rows="6" cols="43"
										placeholder="질문을 작성하세요."></textarea>
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
								<div class="body-titlebox">※답변은 전체 공개됩니다</div>
								<div class="body-contentbox">
									<textarea id="answer" name="content" rows="6" cols="43"
										placeholder="답변을 작성하세요."></textarea>
								</div>
							</div>
						</div>
						<div class="popup-foot">
							<input type="hidden" value="" id="modalQnaNum"> <span
								class="pop-btn confirm" id="confirm">등록</span> <span
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
		<br>
		<br>
		<!-- Review  -->
		<div>
			<div id="s_review" class="text_box msimple">
			<h1 class="h_intro" id="review">리뷰</h1>
			</div>
			<div>
				<table class="table w-100">
					 <thead>
						<tr>
							<th scope="col">글번호</th>
							<th scope="col">내용</th>
							<th scope="col">작성자</th>
							<th scope="col">평점</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reviewDto}" var="re">
							<tr>
								<td>${re.review_id}</td>
								
								<td style="width: 400px;"><img class="w-50" src="${re.review_img }"> ${re.review_content}</td>
								<td>${re.custId}</td>
								<td><c:if test="${re.review_star==1 }">
                              <div class="star_rating">
                               <span class="on">★</span>
                               <span>★</span>
                               <span>★</span>
                               <span>★</span>
                               <span>★</span>
                               </div>
                            </c:if>
                            <c:if test="${re.review_star==2 }">
                              <div class="star_rating">
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span>★</span>
                               <span>★</span>
                               <span>★</span>
                               </div>
                            </c:if>
                            <c:if test="${re.review_star==3 }">
                              <div class="star_rating">
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span>★</span>
                               <span>★</span>
                               </div>
                            </c:if>
                            <c:if test="${re.review_star==4 }">
                              <div class="star_rating">
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span>★</span>
                               </div>
                           </c:if>
                           <c:if test="${re.review_star==5 }">
                              <div class="star_rating">
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               <span class="on">★</span>
                               </div>
                           </c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br><br><br><br>
		
		<h1 class="h_intro" id="location">위치</h1>
         <div class="map-group" id="map-group">
         <p style="color: black; font-size: 24px;">${view.address }</p>
         <p style="color: #656565;">${view.zipcode }</p>
         <div id="map"></div>
         </div>
      </div>


		
<script>
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