<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check!=1 }">
<script>
alert("질문이나 답변이 잘못되었습니다.");    
history.go(-1);

</script>
</c:if>

<c:if test="${check==1 }">
<html>
<head>
<title>비밀번호찾기</title>
<style>
body{
padding-top: 40px;
background-color: #eee;
line-height: 1.42857143;
margin:0;
}
.container{
/* border: 1px solid gray; */
padding-right: 900px;
padding-left:900px;
margin-right: auto;
margin-left: auto;
}
.form_findpwd3{
width:400px;
padding:15px;
margin:0 atuo;
margin-bottom: -1px;
border-bottom-right-radius: 0;
border-bottom-left-raduius: 0;
}
.form_findpwd3 .form_control{
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
.btn{
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
function checkIt(){
	if(userinput.password.value!= userinput.password2.value){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div class="container">
<form name="userinput" class="form_findpwd3" method="post" action="/semiProject/km/changePwd.do" onSubmit="return checkIt()">
<h2>비밀번호 찾기</h2>
<label class="label" for="password"></label>
<input type="password" name="password" id="password" class="form_control" placeholder="변경할 비밀번호를 입력해주세요." required autofocus>
<label class="label" for="psssword2"></label>
<input type="password" name="password2" id="password2" class="form_control" placeholder="변경하신 비밀번호를 다시한번 입력해주세요.">
<input type="hidden" name="id" value="${sessionScope.id }">
<button class="btn" type="submit">비밀번호 변경</button>
</form>
</div>
</body>
</html>
</c:if>
