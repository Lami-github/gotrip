<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
margin: auto;


}
.form_findpwd{
margin-bottom: -1px;
border-bottom-right-radius: 0;
}
.form_findpwd .form_control{
position: relative;
height: auto;
box-sizing: border-box;
padding: 10px;
font-size: 16px;
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
width: 100%;
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

h2{
	text-align : center;
}

</style> 
<script>
function checkId(){
	if(!document.myform.id.value){
		alert("아이디를 입력하지 않으셨습니다.");
		document.myform.id.focus();
		return false;
	}
	}
</script>
<title>Insert title here</title>

</head>
<body>
<div class="container">
<form class="form_findpwd" action="/semiProject/km/findpwdPro0.do" method="post" onsubmit="return checkId()">
<h2>비밀번호 찾기</h2>
<label class="label" for="id">아이디를 입력하세요~</label>
<input type="text" name="id" id="id" class="form_control" placeholder="아이디를 입력하세요." required autofocus>
<button class="btn1" type="submit">확인</button>
</form>
</div>

</body>
</html>