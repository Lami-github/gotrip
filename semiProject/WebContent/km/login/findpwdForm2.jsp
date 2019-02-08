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
padding-right: 900px;

margin-right: auto;
margin-left: auto;
}
.form_findpwd2{
width:500px;
padding:15px;
margin:0 atuo;
margin-bottom: -1px;
border-bottom-right-radius: 0;
border-bottom-left-raduius: 0;
}
.form_findpwd2 .form_control{
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
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form class="form_findpwd2" action="/semiProject/km/findpwdPro2.do">
<h2>비밀번호찾기</h2>
<label class="label" for="question"></label>
<select name="pwdquiz" class="form_control" id="question">
<option value="0" selected>질문을 골라주세요.</option>
<option value="1">당신이 살던 동네는 어디입니까?</option>
<option value="2">좋아하는 음식은 무엇입니까?</option>
<option value="3">부먹 찍먹?</option>
</select>
<input type="text" name="pwdanswer" id="question" placeholder="내용을 입력해주세요." class="form_control">
<input type="hidden" name=id value="${id }">
<button class="btn" type="submit">확인</button>

</form>
</div>

</body>
</html>