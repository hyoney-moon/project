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
	<table id="table">
		<tr>
			<td>글제목 : </td>
			<td>${board.spaceName}</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td>등록일 : </td>
			<td><fmt:formatDate value="${board.regDate}" type="date"
					dateStyle="long" /></td>
		</tr>
	</table>
<hr>
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
			<button id="cmtCnt-btn2">작성</button>
		</div>
	</div>

	<br>
	<br>
	<div id=getComment></div>
	<div id=replyComment></div>


<script>
$(function(){
	var qnaNumber ="";
	
	var modal2 = document.getElementById('myModal2');
	var span2 = document.getElementsByClassName("close")[0];
	var btn2 = document.getElementById("replyBtn");
	
	getcommentList();
	// 댓글 출력
	function getcommentList(){
		let params = "boardNum="+ ${board.boardNum}
		$.ajax({
			type: "post",
			url: "/board/comment",
			data: params,
			dataType: "json"
		}).done(function(args){
			for(var num=0; num < args.length; num++){
			$("#getComment").append(
					"고객이름 : " + args[num].custId + "<br>" +
					"댓글내용 : " + args[num].content + "<br>" +
					
					"<buttion id='" + "replyBtn'" + 
					" value='" + args[num].qnaNum +"'>ㄴ답변하기</button>" + 
					
					"<div id='" + "replyComment'>" + "</div>" + 
					"<br><br>"
			);
			} //for문 종료
		}) // done 종료
	} // getcommentList() 종료
	

	//답변하기 버튼 클릭 이벤트
	$('#getComment').on('click', '#replyBtn', function() {
		qnaNumber = $(this).attr('value');
		console.log(qnaNumber);
		modal2.style.display = "block";
	})
	
	$('#myModal2').on('click', ".close", function(){
		modal2.style.display = "none";
	})

	var board = "board.boardNum";
    var qnaNum = "custQna.qnaNum";
    var comment = $("#content");
    var comment2 = $("#content2")
    
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
				let params = "boardNum="+ ${board.boardNum}
				$.ajax({
					type: "post",
					url: "/board/comment",
					data: params,
					dataType: "json"
				}).done(function(args){
					
					for(var num=0; num < args.length; num++){
					$("#getComment").append(
							"<strong>고객 문의</strong><br>" +
							"아이디 : " + args[num].custId + "<br>" +
							"문의사항 : " + args[num].content + "<br>" +
							
							"<buttion id='" + "replyBtn'" + 
							" value='" + args[num].qnaNum +"'>ㄴ답변하기</button>" + 
							
							"<div id='" + "replyComment'>" + "</div>" + 
							"<br><br>"
					);
					}
				})
			}
		})
	}) // click
// 호스트 답변달기
	$("#cmtCnt-btn2").click(function(){
		//var qnaNumber = $(this).attr('value');
		console.log(qnaNumber);
		$.ajax({
			url:"/questions/insertHostQna",
			type: "POST",
			dataType: "HostQna",
			data: {
				board : ${boardNum},
				profile : "hostprofile",
				content : $("#content2").val(),
				hostId : "${host.hostId}",
				reQnaNum: qnaNumber
			},
			complete : function(){
				modal2.style.display = "none";
				comment2.val("");
				$("#replyComment").empty();
				let params2 = "boardNum="+ ${board.boardNum}
				
				$.ajax({
					type: "post",
					url: "/board/replyComment",
					data: params2,
					dataType: "json"
				}).done(function(args){
					for(var num=0; num < args.length; num++){
						$("#replyComment").append(
						"<br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>호스트 답변</strong><br>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+args[num].content + "<br>"
						)
					}
				}) 
			}
		}) 
	}) // click 종료
}) // ready function 종료
</script>

<script>
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

/* window.addEventListener("click", function(event) {
	if (event.target == modal2) {
        modal2.style.display = "none";
    }
}); */

</script>
</html>