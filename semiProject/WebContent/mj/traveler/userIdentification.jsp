<%@ page contentType="text/html; charset=UTF-8"%>
         <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/util.js"></script>
         <script src="<%=request.getContextPath() %>/js/main.js"></script>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
<title>본인확인</title>
<script>
	function checkIt(userinput){
		if(userinput.password.value ==""){
			alert("패스워드를 입력해주세요");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<br><br><br>
<div align=center>
		패스워드를 입력해주세요<br>
<form method=post action="/semiProject/mj/userIdentification.do" name=userIdentification onSubmit="return checkIt()">
<input type=hidden id=tr_num name=tr_num value="${tr_num}">
<div class="10u 12u$(xsmall)">
<input type=password id=password name=password><br><input type=submit value="확인">
</div>
</form>
</div>
</body>
</html>