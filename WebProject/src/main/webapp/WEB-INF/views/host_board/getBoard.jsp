<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
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
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
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
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
</style>
</head>
<body>
<table>
	<tr><td>제목</td><td>${board.spaceName}</td></tr>
	<tr><td>내용</td><td>${board.content}</td></tr>
	<tr><td>등록일</td><td><fmt:formatDate value="${board.regDate}" type="date" dateStyle="long" /></td></tr>
</table>

<h2>QnA</h2>
<table border="1">
<tr><td></td></tr>

<c:forEach items="${qna}" var="qna">
고객 아이디 : ${qna.custId}<br>
고객 댓글 : ${qna.content}
<hr>
	&nbsp&nbsp&nbsp 호스트 답변 : ${qna.content}
<hr>
</c:forEach>

</table>
	<!-- Trigger/Open The Modal -->
    <button id="myBtn">질문하기</button>
 
    <!-- The Modal -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>
        <p>질문 작성하기</p>
        <form action="/questions/insertQna" method="post">
        	<textarea name="content" rows="15" cols="40"></textarea>
        	<input type="hidden" name="board.boardNum" value="${boardNum}">
        	<input type="hidden" name="profile" value="profile2">
        	<!-- <input type="hidden" name="commentDate" value="${board.regDate}">  -->
        	<input type="hidden" name="custId" value="${customer.custId}">
        	<input type="submit" value="작성">
        	<!-- Qna 엔티티가 조인으로 사용하는 컬럼에 insert 해야함 -->
        </form>
      </div>
    </div>
</body>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
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