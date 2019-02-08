<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chatting</title>
</head>
<body>
<fieldset>
	<textarea id="messageWindow" rows="10" cols="50" readonly>
<c:forEach var="chat_list" items="${chatlist}"><c:out value="${chat_list}" />
</c:forEach>
	</textarea>
	<br /> 
	<input id="name" type=text value="${sessionScope.id}" readonly /> : <input id="inputMessage" type="text" onkeypress="if(event.keyCode==13) {send();}" />
	<input id="trade_num" type=hidden value="${trade_num }" /> <input id="id2" type=hidden value="${id2 }" />
	<input type="submit" value="send" onclick="send()" />
</fieldset>
</body>
<script type="text/javascript">
	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://192.168.40.53:8088/semiProject/broadcasting'); /* 192.168.40.38 */
	var inputMessage = document.getElementById('inputMessage');
	var username = document.getElementById('name');
	var trade_num = document.getElementById('trade_num');
	var id2 = document.getElementById('id2');
	
	function addZeros(num, digit) { // 자릿수 맞춰주기
		  var zero = '';
		  num = num.toString();
		  if (num.length < digit) {
		    for (i = 0; i < digit - num.length; i++) {
		      zero += '0';
		    }
		  }
		  return zero + num;
	}
	
	webSocket.onerror = function(event) { //접속 에러일 경우 
		onError(event)
	};
	webSocket.onopen = function(event) { //접속일 경우
		onOpen(event)
	};
	webSocket.onmessage = function(event) { //메세지를 받앗을 때
		onMessage(event)
	};
	function onMessage(event) { //서버로부터 메세지를 받았을 때 불리는 함수
		textarea.value += event.data + "\n";
		textarea.scrollTop = textarea.scrollHeight;
	}
	function onOpen(event) { //접속
		textarea.value += "연결 성공\n";
	}
	function onError(event) { //접속 에러
		alert(event.data);
	}
	function send() { //메세지 전송 함수
		var currentDate = new Date();
		var currentHours = addZeros(currentDate.getHours(),2); 
		var currentMinute = addZeros(currentDate.getMinutes() ,2);
		var amPm = 'AM';
		
		if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
		 	amPm = 'PM';
		   	currentHours = addZeros(currentHours - 12,2);
		}
		var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() + " / "+ amPm + " " + currentHours +":"+ currentMinute// 현재 날짜
		textarea.value += username.value + " : " + inputMessage.value + "\t [" + calendar + "]" + "\n";
		webSocket.send(username.value + " : " + inputMessage.value + "\t [" + calendar + "]"+" | "+ trade_num.value);
		inputMessage.value = "";
		textarea.scrollTop = textarea.scrollHeight; //textarea 자동 스크롤
	}
</script>
</html>

<%-- 

버튼

<form method=post action="/semiProject/chat/chatContent.do" name=chat_start>
	<input type=hidden name="id2" value="bb"><input type=hidden name="trade_num" value="123" >																								<!-- room_number -->
							<!-- 상대방 id -->					<!-- room_num -->
	<input type=submit value="채팅하기">
</form>
 --%>