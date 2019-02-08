<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A</title>
<meta name="description"
	content="B
	locksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com" />
<meta name="keywords"
	content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<style>
.mainimg {
	width: 100%;
	height: 400px;
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



						<c:if test="${count == 0 }">
							<table width="700" border="1" cellpadding="0" cellspacing="0"
								align="center">
								<tr>
									<td>게시판에 저장된 글이 없습니다.</td>
								</tr>
							</table>
						</c:if>

						<c:if test="${count > 0}">
							<table border="1" width="540" cellpadding="0" cellspacing="0"
								align="center">
								<tr height="30">
									<td align="center" width="70">글번호</td>
									<td align="center" width="250">제목</td>
									<td align="center" width="150">작성일</td>
									<td align="center" width="70">조회수</td>
								</tr>

								<c:forEach var="article" items="${articleList}">
									<!-- items 콜렉션..... -->
									<tr height="30">
										<td align="center" width="70"><c:out value="${number}" />
											<c:set var="number" value="${number -1}" /></td>
										<td width="250"><a
											href="/semiProject/JY/QnaDetailForm.do?num=${article.q_num}&pageNum=${currentPage}">
												${article.q_subject} </a></td>
										<td align="center" width="150">${article.q_reg_date}</td>
										<td align="center" width="70">${article.q_readcount}</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<div style="text-align: center">
							<c:if test="${count > 0}">
								<c:set var="pageCount"
									value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
								<c:set var="pageBlock" value="${10}" />
								<fmt:parseNumber var="result" value="${currentPage / 10}"
									integerOnly="true" />
								<c:set var="startPage" value="${result * 10 + 1}" />
								<c:set var="endPage" value="${startPage + pageBlock-1}" />
								<c:if test="${endPage > pageCount}">
									<c:set var="endPage" value="${pageCount}" />
								</c:if>

								<c:if test="${startPage > 10}">
									<a
										href="/semiProject/JY/QnaForm.admin?pageNum=${startPage - 10 }">[이전]</a>
								</c:if>

								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<a href="/semiProject/JY/QnaForm.admin?pageNum=${i}">[${i}]</a>
								</c:forEach>

								<c:if test="${endPage < pageCount}">
									<a
										href="/semiProject/JY/QnaForm.admin?pageNum=${startPage + 10}">[다음]</a>
								</c:if>
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</div>

	</section>


	<!-- Footer -->
	<tiles:insertDefinition name="mainfooter" />

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>

</body>
</html>