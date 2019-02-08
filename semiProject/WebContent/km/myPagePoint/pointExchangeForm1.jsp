<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${check==1 }">
<html>
<head>
<head>
<script src="/jquery.min.js"></script>
			<script src="/js/jquery.scrollex.min.js"></script>
			<script src="/js/skel.min.js"></script>
			<script src="/js/util.js"></script>
			<script src="/js/main.js"></script>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
</head>


<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>마이페이지</p>
				<h2>계좌출금</h2>
			</header>
		</div>
	</section>

<style>
.bigbox{
position: absolute;
background-color:rgb(189, 226, 251);
weight: 100px;
height: 200px;
}
</style>

<script>
function checkIt(){
	var userinput = eval("document.userinput");

	if(userinput.update_point.value < userinput.point.value){
		alert("환전할 포인트가 보유 포인트보다 많습니다!");
		return false;
	}	
	if(userinput.bankname.value==0){
		alert("거래은행을 선택해주세요!");
		return false;
	}
	if(!userinput.ac_number.value){
		alert("계좌번호를 입력해주세요!");
		return false;
	}
	if(!userinput.ac_holder.value){
		alert("예금주를 입력해주세요!");
		return false;
	}
	if(!uesrinput.update_point.value){
		alert("환전할 금액을 입력해 주세요!");
		return false;
	}
	
	
	
}
</script>
</head>

<body>

<div class="container-inputform" style="width: 50%;
    margin: 60px auto 0 auto;">
<form name="userinput" method="post" action="/semiProject/km/pointExchangePro1.do" onSubmit="return checkIt()" >
		
		
		환불받으실 은행<select name="bankname">
<option value="0" selected>아래은행에서 선택해주세요.</option>
<option value="1" >하나은행</option>
<option value="2">카카오뱅크</option>
<option value="3">국민은행</option>
<option value="4">비씨카드</option>
<option value="5">농협은행</option>
<option value="6">기업은행</option>
<option value="7">慇悲은행</option>
</select><br/>

	계좌번호<input type="text"  name="ac_number" placeholder="-를 빼고 입력해주세요." onkeyPress="if ((event.keyCode<48) || (event.keyCode>57)) event.returnValue=false;"> <br/>

예금주<input type="text" name="ac_holder" placeholder="예금주명을 입력해주세요"><br/>

현재 포인트<input type="text" name="point" value="${point}" readonly="readonly"><br/>
환전할 포인트<input type="text" name="update_point" placeholder="환전할 포인트를 입력해주세요" onkeyPress="if ((event.keyCode<48) || (event.keyCode>57)) event.returnValue=false;"><br/>
<input type="hidden" value="${sessionScope.id }" name="id">
<input type="submit" value="포인트환전 신청하기">


</form>
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


<c:if test="${check==0}">
<script>
alert("비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>
