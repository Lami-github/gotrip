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
float: left;
}
.form_findpwd1{
max-width:330px;
padding:15px;
margin:0 atuo;
margin-bottom: -1px;
border-bottom-right-radius: 0;
border-bottom-left-raduius: 0;
float: left;
}
.form_findpwd1{
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

</style>
<title>비밀번호찾기방법 선택</title>
</head>
<body>
<div class="container">
<form class="form_findpwd1" method=post action="/semiProject/km/findpwdForm2.do">
<h2>비밀번호 찾기</h2>
<label class="label" for="img1">1</label>
<!-- <a href="/semiProject/km/findpwdForm2.do" id="img1"><img src="question.JPG"  ></a>
<a href="/semiProject/km/findpwdForm2.do" id="img1">질문으로 찾기</a> -->
<input type="hidden" name=id value="${sessionScope.id }">
<input type="image" src="<%=request.getContextPath() %>/img/question.JPG" name=submit value="submit"><br>
<input type="submit" value="질문으로 찾기">
</form>

<form class="form_findpwd1" method=post action="/semiProject/km/findpwdForm4.do">
<label class="label" for="img2">2</label>
<!-- <a href="/semiProject/km/findpwdForm4.do" id="img2"><img src="mail.JPG"  ></a>
<a href="/semiProject/km/findpwdForm4.do" id="img2">메일로 비밀번호 받기</a> -->
<input type="hidden" name=id value="${sessionScope.id }">
<input type="image" src="<%=request.getContextPath() %>/img/mail.JPG" name=submit value="submit"><br>
<input type="submit" value="메일로 비밀번호 받기">
</form>
</div>

</body>
</html>