<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${check==1 }">
<html>
<head>
<title>회원정보수정</title>
<style>
.readonly{
background-color: gray;
}
</style>
<script>
function zipCheck(){
   
   url="/semiProject/km/ZipCheck.do?check=y";
   
   window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}
function checkIt(){

     if(userinput.password.value != userinput.password2.value)
       {
           alert("비밀번호를 동일하게 입력하세요");
           return false;
       }
     return true;
}

</script>
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<div>
      <tiles:insertDefinition name="mainheader" />
   </div>
</head>

<body>
   <section id="One" class="wrapper style3">
      <div class="inner">
         <header class="align-center">
            <a href="/semiProject/km/myPagePoint.do"><p>마이페이지</p></a>
            <a href="/semiProject/km/changeMemberInfoForm.do"><h2>회원정보수정</h2></a>
         </header>
      </div>
   </section>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

<div>
<form method="post"   action="/semiProject/km/changeMemberInfoPro1.do" onSubmit="return checkIt()" name="userinput">
<table style="border-spacing: 5px;
    border-collapse: separate;">
<tr>
<td>아이디</td>
<td class="readonly">${sessionScope.id }</td></tr>
<tr>
<td>비밀번호 변경</td>
<td><input type="password" name="password" value="${article.password }" ></td></tr>
<tr>
<td>비밀번호 재확인</td>
<td><input type="password" name="password2" value="${article.password }" ></td></tr>
<tr>
<td>이름</td>
<td class="readonly">${article.name }</td></tr>
<tr>
<td>이메일</td>
<td class="readonly">${article.email }</td>
<tr>
<td>휴대전화</td>
<td><input type="tel" name="phonenumber" value="${article.phonenumber}">
</td></tr>
<tr>
<td>우편번호</td>
<td><input type="text" name="zipcode" size="7" class="form-control" value="${article.zipcode }" readonly></td>
<td><input type="button" value="우편번호 찾기" onclick="zipCheck()" class="zip-btn" style="
    margin-left:  10px;
"></td></tr>
<tr>
<td>주소</td>
<td><input type="text" name="address" id="address" value="${article.address }" class="form-control" readonly ></td></tr>
<tr>
<td>주소지 상세</td>
<td><input type="text" name="address1" value="${article.address1 }"></td></tr>
<tr>
<td>비밀번호 찾기 질문</td>
<td><select name="pwdquiz" >
<option value="${article.pwdquiz }">${article1.quiz}</option>

</select></td>
<tr>
<td></td>
<td><input type="text" name="pwdanswer" value="${article.pwdanswer}"></td>
</tr>
</table>
<input type="hidden" value="${sessionScope.id }" name="id">
   <div class="12u$">
   <ul class="actions" style=text-align:center;>
   <li><input type="submit" value="정보수정 확인" /></li>
   <li><input type="button" value="돌아가기"  onclick="document.location.href='/semiProject/km/myPagePoint.do'" /></li>
   </ul>
   </div>



</form>
</div>
</div>
<div>
      <tiles:insertDefinition name="mainfooter" />
   </div>
   
   <!-- Scripts -->

	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>
</c:if>
<c:if test="${check==0 }">
<script>
alert("비밀번호가 잘못되었습니다.");
history.go(-1);
</script>
</c:if>