<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<meta http-equiv="Refresh" content="1;url=/semiProject/km/myPagePoint.do">
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
				<h2>환전완료</h2>
			</header>
		</div>
	</section>
<body>
<h2 style="text-align:center;"><b >환전신청이 완료되었습니다.</b></h2>

</body>
<div>
<tiles:insertDefinition name="mainfooter" />
</div>

<!-- Scripts -->

	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</html>