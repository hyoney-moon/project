<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello WebSocket</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

   <!--  <script src="webjars/app.js" charset="UTF-8"></script> -->
   <script>
   var stompClient = null;

   function setConnected(connected) {
       $("#connect").prop("disabled", connected);
       $("#disconnect").prop("disabled", !connected);
       $("#send").prop("disabled", !connected);
       if (connected) {
           $("#conversation").show();
       }
       else {
           $("#conversation").hide();
       }
       $("#msg").html("");
   }

   function connect() {
       var socket = new SockJS('/ws');
       stompClient = Stomp.over(socket);
       stompClient.connect({}, function (frame) {
           setConnected(true);
           console.log('Connected: ' + frame);
           stompClient.subscribe('/topic/public', function (message) {
               showMessage("받은 메시지: " + message.body); //서버에 메시지 전달 후 리턴받는 메시지
           });
       });
   }

   function disconnect() {
       if (stompClient !== null) {
           stompClient.disconnect();
       }
       setConnected(false);
       console.log("Disconnected");
   }

   function sendMessage(message) {
       //let message = $("#msg").val()
       showMessage("보낸 메시지: " + message);

       stompClient.send("/app/sendMessage", {}, JSON.stringify(message)); //서버에 보낼 메시지
   }

   function showMessage(message) {
       $("#communicate").append("<tr><td>" + message + "</td></tr>");
   }

   $(function () {
       $("form").on('submit', function (e) {
           e.preventDefault();
       });
       $( "#connect" ).click(function() { connect(); });
       $( "#disconnect" ).click(function() { disconnect(); });
       $( "#send" ).click(function() { sendMessage(); });
   });
   
   function host(){
	   sendMessage("호스트");
   }
   
   function guest(){
	   sendMessage("게스트");
   }
   
   function host1(){
	   sendMessage("공간등록문의");
   }
   
   function host2(){
	   sendMessage("공간검수문의");
   }
   
   function host3(){
	   sendMessage("예약취소문의");
   }
   
   function guest1(){
	   sendMessage("공간이용문의");
   }
   
   function guest2(){
	   sendMessage("예약취소문의");
   }
   
   function guest3(){
	   sendMessage("결제오류문의");
   }
 
   </script>
</head>
<body>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">문의하기:</label>
                    <button id="connect" class="btn btn-default" type="submit">시작</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">종료
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="msg">문의사항</label>
                    <!-- <input type="text" id="msg" class="form-control" placeholder="내용을 입력하세요...."> -->
                </div>
                <!-- <button id="send" class="btn btn-default" disabled type="submit">보내기</button> -->
                <button id="send" onclick="host()">호스트</button>
                <button id="send" onclick="guest()">게스트</button>
                <button id="send" onclick="host1()">공간 등록 문의</button>
                <button id="send" onclick="host2()">공간 검수 문의</button>
                <button id="send" onclick="host3()">예약 취소 문의</button>
                <button id="send" onclick="guest1()">공간 이용 문의</button>
                <button id="send" onclick="guest2()">예약 취소 문의</button>
                <button id="send" onclick="guest3()">결제 오류 문의</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>메세지</th>
                </tr>
                </thead>
                <tbody id="communicate">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>