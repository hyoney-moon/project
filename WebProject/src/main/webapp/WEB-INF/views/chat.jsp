<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
               showMessage("���� �޽���: " + message.body); //������ �޽��� ���� �� ���Ϲ޴� �޽���
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

   function sendMessage() {
       let message = $("#msg").val()
       showMessage("���� �޽���: " + message);

       stompClient.send("/app/sendMessage", {}, JSON.stringify(message)); //������ ���� �޽���
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
       $("#send2").click(function() { sendMessage(); });
   });
   </script>
</head>
<body>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">������ ����:</label>
                    <button id="connect" class="btn btn-default" type="submit">����</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">����
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="msg">���ǻ���</label>
                    <input type="text" id="msg" class="form-control" placeholder="������ �Է��ϼ���....">
                </div>
                <button id="send" class="btn btn-default" disabled type="submit">������</button>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="msg">���ǻ���</label>
                    <input type="text" id="msg" class="form-control" placeholder="������ �Է��ϼ���....">
                </div>
                <button id="send2" class="btn btn-default" disabled type="submit">������</button>
               	
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>�޼���</th>
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