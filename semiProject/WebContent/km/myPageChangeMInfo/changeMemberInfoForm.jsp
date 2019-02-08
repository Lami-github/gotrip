<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>



<style>
.texttext {
	text-align: center;
}
</style>




</head>
<body>
<div>
	<tiles:insertDefinition name="mainheader" />
</div>
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<a href="/semiProject/km/myPagePoint.do"><p>마이페이지</p></a>
				<a href="/semiProject/km/changeMemberInfoForm.do"><h2>회원정보수정</h2></a>
			</header>
		</div>
	</section>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1></h1>
		<div align=center>
		<div style="width:30%; text-align:center;">
				<h3>비밀번호입력</h3>
			<h4 class="texttext">회원정보 수정전 비밀번호를 입력해주세요.</h4>
			<form class="texttext" method="post"
				action="/semiProject/km/changeMemberInfoForm1.do">
				
				<input type="password" name="password" required autofocus> <input
					type="hidden" value="${sessionScope.id}" name="id">
				<!-- <input type="submit" value="회원정보 수정하기"> -->
				<ul class="actions small">
					<li><input class="button special fit small" type="submit"
						value="회원정보 수정하기"></li>
				</ul>


			</form>
			</div>
		</div>
	</div>
	<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>