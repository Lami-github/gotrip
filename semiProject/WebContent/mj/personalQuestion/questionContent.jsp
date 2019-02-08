<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<link href="css/bootstrap.css" rel="stylesheet">
<html>
<head>
<title>같이...여행갈래요?</title>

</head>
<body>
	<div>
		<tiles:insertDefinition name="mainheader" />
	</div>
	
<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<a href="/semiProject/NA/tripreView/list.do"><p>마이페이지</p></a> <a
					href="/semiProject/JY/FestivalForm.do"><h2>1:1문의내역 확인</h2></a>
			</header>
		</div>
	</section>
<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="content">
<div class="body_header">

	
	<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr height="30">
			<td align="center" width="125" >글번호</td>
			<td align="center" width="125" align="center">${QuestionContent.pq_num}</td>
			<td align="center" width="125" >분   류</td>
			<td align="center" width="125" align="center">${QuestionContent.pq_type}</td>
		</tr>
		<tr height="30">
			<td align="center" width="125" >작성자</td>
			<td align="center" width="125" align="center">${QuestionContent.writer}</td>
			<td align="center" width="125" >작성일</td>
			<td align="center" width="125" align="center">${QuestionContent.pq_reg_date}</td>
		</tr>
		<tr height="30">
			<td align="center" width="125" >글제목</td>
			<td align="center" width="375" align="center" colspan="3">${QuestionContent.pq_subject}</td>
		</tr>
		<tr>
			<td align="center" width="125" >글내용</td>
			<td align="left" width="375" colspan="3"><pre>${QuestionContent.pq_content}</pre></td>
		</tr>
	</table>
	<input type="button" value="글목록" onclick="document.location.href=/semiProject/mj/question.do">
	
	
	</div>
</div>
</div>
</section>

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