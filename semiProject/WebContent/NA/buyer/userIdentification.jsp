<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>본인확인</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css" />
<script>
	function checkIt(userinput) {
		if (userinput.password.value == "") {
			alert("패스워드를 입력해주세요");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<div align=center>
		패스워드를 입력해주세요 : <br>
		<form method=post action="/semiProject/mj/userIdentificationBuyer.do"
			name=userIdentification onSubmit="return checkIt()">
			<input type=hidden id=b_num name=b_num value="${b_num}"> <input
				type=hidden id=b_writer name=b_writer value="${b_writer}"> <input
				type=hidden id=trade_count name=trade_count value="${trade_count}">
			<input type=hidden id=trade_item name=trade_item
				value="${trade_item}"> <input type=hidden id=trade_point
				name=trade_point value="${trade_point}"> <input type=hidden
				id=trade_country name=trade_country value="${trade_country}">
			<div class="10u 12u$(xsmall)">
				<input type=password id=password name=password>
			</div>
			<input type=submit value="확인">
		</form>
	</div>
</body>
</html>