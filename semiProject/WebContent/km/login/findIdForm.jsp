<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<style>
body{
padding-top: 40px;
background-color: #eee;
line-height: 1.42857143;
margin:0;
}
.container{
/* border: 1px solid gray; */

margin-right: auto;
margin-left: auto;
}
.form_findId{

padding:15px;
margin:0 atuo;
margin-bottom: -1px;
border-bottom-right-radius: 0;
border-bottom-left-raduius: 0;
}
.form_findId .form_control{
width:100%;
position: relative;
height: auto;
box-sizing: border-box;
padding: 10px;
font-size: 14px;
}
.label{
position: absolute;
width: 1px;
height: 1px;
padding: 0;
margin: -1px;
overflow: hidden;
border:0;
}
.form_control{

display: block;
width: auto;
border: 1px solid #ccc;
}
.btn1{
display:block;
width:100%;
padding: 10px 16px;
font-size: 18px;
line-height: 1.3333333;
border-radius:6px;
    color: #fff;
    background-color: #337ab7;
    border-color: #2e6da4;
    overflow:visible;
}
</style>

<script>
function checkId(){
	if(!document.formIdCheck.name.value){
		alert("이름을 입력하지 않으셨습니다.");
		document.formIdCheck.name.focus();
		return false;
	}
	if(!document.formIdCheck.email.value){
		alert("비밀번호를 입력하지 않으셨습니다.");
		document.formIdCheck.email.focus();
		return false;
	}
}


</script>
<title>아이디 찾기</title>

</head>
<body>
<div class="container">
<form name="formIdCheck" class="form_findId" method="post" action="/semiProject/km/findIdPro.do"   onsubmit="return checkId()">
<h2 class="form_findId_header">아이디 찾기</h2>
<label class="label" for="name">이름을 입력하십쇼</label>
<input type="text" name="name" id="name" placeholder="이름을 입력하세요." class="form_control" >
<label class="label" for="email">E-Mail을 입력하세요.</label>
<input type="email" name="email" id="email" placeholder="email을 입력하세요." class="form_control" >
<h5 align="center">등록하신 이메일로 아이디가 발송됩니다.</h5>
<button class="btn1" type="submit">확인</button>
</form>
</div>
</body>
</html>