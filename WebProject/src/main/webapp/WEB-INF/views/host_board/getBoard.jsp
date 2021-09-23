<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
/**/
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

#table {
	margin: auto;
}

#getComment, #replyComment, #qna {
	text-align: center;
}

div.button{
	margin: auto;
	width: 5%;
}
</style>
</head>

<body>
	<h2 id="qna">QnA</h2>
	<!-- 질문하기 modal -->
	<div class="button"><button id="myBtn">질문하기</button></div>
	<div id="myModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<p><strong>질문하기</strong></p>
			<textarea id="content" name="content" rows="15" cols="40"></textarea>
			<button id="cmtCnt-btn">작성</button>
		</div>
	</div>

	<!-- 답변하기 modal -->
	<!-- The Modal -->
	<div id="myModal2" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<p><strong>답변하기</strong></p>
			<textarea id="content2" name="content" rows="15" cols="40"></textarea>
			<input type="hidden" value="" id="modalQnaNum">
			<button id="cmtCnt-btn2">작성</button>
		</div>
	</div>

	<br>
	<br>
	<div id=getComment></div>


<script>
$(function(){
	var qnaNumber ="";
	
	var modal2 = document.getElementById('myModal2');
	var span2 = document.getElementsByClassName("close")[0];
	var btn2 = document.getElementById("replyBtn");
	
	var hostId = "hostId"; // ${host.hostId}
	
	getcommentList();
	// 댓글 출력
	function getcommentList(){
		let params = "boardNum="+ ${board.boardNum}
		$.ajax({
			type: "post",
			url: "/comment", // /board/comment
			data: params,
			dataType: "json"
		}).done(function(args){
			$("#getComment").empty();
			for(var num=0; num < args.length; num++){
				var reply = "";
				if(args[num].hostContent != undefined){
					 reply = args[num].hostContent
					 }
				if(hostId != null){
					$("#getComment").append(
							"고객이름 : " + args[num].custId + "<br>" +
							"댓글내용 : " + args[num].content + "<br>" +
							
							"<strong>호스트 답변</strong><br>" +
							reply + "<br>" +
							
							"<button id='" + "replyBtn'" + 
							" value='" + args[num].qnaNum + "'>답변하기</button><br><br>"
					);
				} else {
					$("#getComment").append(
							"고객이름 : " + args[num].custId + "<br>" +
							"댓글내용 : " + args[num].content + "<br>" +
							
							"<strong>호스트 답변</strong><br>" +
							reply + "<br>"
							)
				}
			
			} //for문 종료
		}) // done 종료
	} // getcommentList() 종료
	
	// 질문작성 클릭 이벤트
	$("#cmtCnt-btn").click(function(){
$.ajax({
	url: "/questions/insertCustQna",
	type: "POST",
	dataType: "CustQna",
	data: {
		board : ${boardNum},
		profile : "custprofile",
		content : $("#content").val(),
		custId : "${customer.custId}",
	},
	complete : function(){
		modal.style.display = "none";
		comment.val("");
		$("#getComment").empty();
		getcommentList();
	}
})
}) // click

	//답변하기 버튼 클릭 이벤트(모달창 띄우기)
	$('#getComment').on('click', '#replyBtn', function() {
		qnaNumber = $(this).attr('value');
		document.getElementById("modalQnaNum").value=qnaNumber;
		modal2.style.display = "block";
	})
	
	$('#myModal2').on('click', ".close", function(){
		modal2.style.display = "none";
	})

	var board = "board.boardNum";
    var comment = $("#content");
    var comment2 = $("#content2");
	
	// 호스트 답변달기 클릭 이벤트(db 저장)
	$("#cmtCnt-btn2").click(function(){
		$.ajax({
			url:"/questions/updateCustQna",
			type: "POST",
			dataType: "CustQna",
			data: {
				qnaNum : $("#modalQnaNum").val(),
				hostContent : $("#content2").val(),
				//hostId : "${host.hostId}",
			},
			complete : function(){
				modal2.style.display = "none";
				comment2.val("");
				$("#replyComment").empty();
				getcommentList();
			}
		}) 
	}) // click 종료
}) // ready function 종료	
</script>
</body>

<script>
var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var modal = document.getElementById('myModal');
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

//When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}	

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

</script>
</html>