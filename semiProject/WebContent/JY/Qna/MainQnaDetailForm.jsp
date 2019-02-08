<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<title>Q&A</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/dashboard.css" rel="stylesheet">
<style>
.mainimg {
	width: 100%;
	height: 400px;
}

}
.detaildiv {
	wdith: 60%;
}

.imgdiv {
	width: 40%;
	height: 50%;
	display: inline-block;
	margin-right: 20;
}

.contentdiv {
	width: 50%;
	height: 50%;
	display: inline;
}

.tablediv {
	width: 60%;
	margin: 0 auto;
}

.tablediv table {
	width: 100%;
}
</style>
</head>

<body>
	<!-- Header -->
	<tiles:insertDefinition name="mainheader" />

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<a href="/semiProject/JY/NoticeForm.do"><p>고객센터</p></a> <a
					href="/semiProject/JY/QnaForm.do"><h2>Q&A</h2></a>
			</header>
		</div>
	</section>
	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<div class=tablediv>
						<form>
							<table width="500" border="1" cellspacing="0" cellpadding="0"
								align="center">
								<tr height="30">
									<td align="center" width="125">글제목</td>
									<td align="center" width="375" colspan="3">${article.q_subject}</td>
								</tr>
								<tr height="30">
									<td align="center" width="125">글번호</td>
									<td align="center" width="125">${article.q_num}</td>
									<td align="center" width="125">조회수</td>
									<td align="center" width="125">${article.q_readcount}</td>
								</tr>
								<tr height="30">
									<td align="center" width="125">작성자</td>
									<td align="center" width="125">관리자</td>
									<td align="center" width="125">작성일</td>
									<td align="center" width="125">${article.q_reg_date}</td>
								</tr>

								<tr height="120">
									<td align="left" width="125" colspan="4">
										${article.q_content}</td>
								</tr>
								<tr height="30">
									<td colspan="4" bgcolor="${value_c}" align="right"><input
										type="button" value="글목록"
										onclick="document.location.href='/semiProject/JY/QnaForm.do?pageNum=${pageNum}'">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>


	</section>

	<tiles:insertDefinition name="mainfooter" />

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>

</body>
</html>