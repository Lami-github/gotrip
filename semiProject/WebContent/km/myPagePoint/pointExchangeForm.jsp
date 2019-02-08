<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
		<script src="/jquery.min.js"></script>
			<script src="/js/jquery.scrollex.min.js"></script>
			<script src="/js/skel.min.js"></script>
			<script src="/js/util.js"></script>
			<script src="/js/main.js"></script>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
</head>
<body>
<body>
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>마이페이지</p>
				<h2>환전하기</h2>
			</header>
		</div>
	</section>



 <div align=center>
<div style="width:30%">
 <form method="post" action="/semiProject/km/pointExchangeForm1.do">
 <label class="" for="password">비밀번호 입력</label>
 회원님의 소중한 자산을 보호하기 위해 <b>비밀번호</b>를 다시한번 입력해 주시기 바랍니다.
<hr />
 <input type="password" name="password" id="password" placeholder="비밀번호를 입력해 주세요." required autofocus>
<hr />
 <input type="submit" value="포인트 환전하기"  class="button special icon fa-search" class="col-sm-3 text-center" > 
 <input type="hidden"  name="id" value="${sessionScope.id }">
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