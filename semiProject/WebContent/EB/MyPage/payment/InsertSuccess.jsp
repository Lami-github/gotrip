<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>마이페이지</p>
				<h2>결제하기</h2>
			</header>
		</div>
	</section>
<script type="text/javascript">
/* var response = new HttpServletResponse(); */
setTimeout(function(){
	location.href="/semiProject/EB/MyPage/payment/After_Payment.jsp";}, 3000);
</script>
<title>Insert title here</title>
</head>
<body>
<img src="<%=request.getContextPath() %>/img/loading.gif" style=image-align:center width=100px height=100px>
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