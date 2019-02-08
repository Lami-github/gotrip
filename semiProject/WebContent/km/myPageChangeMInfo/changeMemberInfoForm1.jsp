<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${check==1 }">
	<html>
<head>
<title>회원정보수정</title>
<style>
.readonly {
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
<div>
	<tiles:insertDefinition name="mainheader" />
</div>
<style>
input[type="tel"] {
	-moz-appearance: none;
	-webkit-appearance: none;
	-ms-appearance: none;
	appearance: none;
	border-radius: 2px;
	border: none;
	border: solid 1px;
	color: inherit;
	display: block;
	outline: 0;
	padding: 0 1rem;
	text-decoration: none;
	width: 100%;
	background: rgba(144, 144, 144, 0.075);
	border-color: rgba(144, 144, 144, 0.25);
}
</style>
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
<body>

	<div class="container-inputform"
		style="width: 50%; margin: 60px auto 0 auto;">
		<fieldset class="">
			<legend class=""></legend>
			<form method="post" action="/semiProject/km/changeMemberInfoPro1.do"
				onSubmit="return checkIt()" name="userinput">

				아이디 <input readonly="readonly" type="text" id="id"
					value="${sessionScope.id }"> <br /> 비밀번호 변경 <input
					type="password" name="password" class="form-control"
					value="${article.password }"><br /> 비밀번호 재확인<input
					type="password" name="password2" id="password2"
					value="${article.password }"><br /> 이름 <input
					readonly="readonly" type="text" name="name" id="name"
					value="${article.name }"><br />


				<!-- *************************************************************************************************************************** -->
				<!-- *************************************************************************************************************************** -->

				이름 <input readonly="readonly" type="text" name="email" id="email"
					value="${article.email }"><br />

				<!-- *************************************************************************************************************************** -->
				<!-- *************************************************************************************************************************** -->

				전화번호 <input type="tel" name="phonenumber" id="phonenumber"
					value="${article.phonenumber}" onkeyPress="if ((event.keyCode<48) || (event.keyCode>57)) event.returnValue=false;"><br /> 우편번호
				<div class="row uniform">
					<div class="9u 12u$(small)">
						<input type="text" name="zipcode" size="7" class="form-control"
							value="${article.zipcode }" readonly="readonly" />

					</div>
					<div class="3u$ 12u$(small)">
						<input class="button special fit small" type="button"
							value="우편번호 찾기" onclick="zipCheck()" class="zip-btn" />
					</div>
				</div>


				주소<input type="text" name="address" id="address"
					value="${article.address }" readonly="readonly"><br /> 상세주소<input
					type="text" name="address1" id="address1" class="form-control"
					value="${article.address1 }"><br />

				<td>비밀번호 찾기 질문</td>
				<td><select name="pwdquiz">
						<c:forEach var="article1" items="${article1 }">
							<option value="${article1.pquiz_num}" selected>${article1.quiz}</option>
						</c:forEach>
						<c:forEach var="list" items="${elseQuizList}">
							<option value="${list.pquiz_num }">${list.quiz}</option>
						</c:forEach>
				</select></td> 답변 <input type="text" name="pwdanswer" value="${article.pwdanswer}"><br />

				<input type="hidden" value="${sessionScope.id }" name="id">
				<div class="12u$">
					<ul class="actions" style="text-align: center;">
						<li><input type="submit" value="정보수정 확인"
							class="button special small" /></li>
						<li><input type="button" value="돌아가기"
							class="button special  small"
							onclick="document.location.href='/semiProject/km/myPagePoint.do'" /></li>
					</ul>
				</div>
	</div>
	</form>
	</fieldset>
	</div>
	<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>
	
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