<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Refresh" content="1;url=/semiProject/km/myPagePoint.do"/>
<html>
<head>
<link rel='stylesheet' href='../css/festival.css' media='screen' />

<link href="../main/css/bootstrap.min.css" rel="stylesheet">
<link href="../main/css/dashboard.css" rel="stylesheet">
<tiles:insertDefinition name="mainheader" />
   
</head>
<body>

<div>
	<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>마이페이지</p>
					<h2>거래현황 </h2>
				</header>
			</div>
	</section>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-color: fff; text-align:center;">
거래가 취소되었습니다.
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