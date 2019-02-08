<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<script type='text/javascript'>
     opener=self;
     setTimeout('self.close()',3000);
     
 function javascript(){
    	 self.close();  
    	}
</script>
</head>
<body>
<div>
<form style=" text-align: center; ">
<h2>비밀번호 찾기.</h2>

<img src="mail.JPG" style="margin-top: 120;">
<h5 style="text-align:center;">해당 이메일로 비밀번호가 발송되었습니다.</h5>
<h5 style="text-align:center;">해당 이메일에서 비밀번호 확인후 로그인 하시기 바랍니다</h5>
<input type='button' onclick='javascript()' value='닫기' style="text-align:center;"/>
</form>
</div>

</body>
</html>