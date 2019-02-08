<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<head>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
<link href="/semiProject_eunB/WebContent/main" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />



<script type="text/javascript">
	setTimeout(function(){
		location.href="<%=request.getContextPath() %>/main/index.do";
	}, 3000)
	//메인 경로를 넣어 주세용
</script>
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
<br/>
<br/>
<br/>
<br/>
<br/>
<p align="center"><h3>결제가 완료되었습니다 자동으로 메인페이지로 이동합니다.<br/>
 즐거운 직구 되세요!.</h3></p>
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