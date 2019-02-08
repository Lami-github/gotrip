<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Email인증</title>
</head>
<body>
<input type=hidden id=certnum value="${certnum}">
인증번호 : <input type="text" id=emailCert name=emailCert size=5 maxlength=4><input type=button name=check value=확인 onclick='check()'>
</body>
<script>
	function check(){
		var certnum = document.getElementById('certnum').value;
		var emailCert = document.getElementById('emailCert').value;
		
		if(certnum != emailCert){
			alert("인증에 실패하셨습니다.");
		}
		
		else{
			alert("인증에 성공하였습니다.");
			opener.document.userinput.check.value='인증완료';
			self.close();
			
		}
	}
</script>
</html>