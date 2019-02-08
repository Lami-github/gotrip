<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>축제관리</title>
<meta name="description"
	content="B
	locksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com" />
<meta name="keywords"
	content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson" />


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<style type="text/css">
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

.content {
	position: relatice;
	width: 90%;
	margin: 0 auto;
}

.content table {
	width: 100%;
}

.grid {
	width: 400px;
	height: 600px;
	padding: 40px;
	background: #fff;
	margin: 50px;
	font-size: 12px;
	float: left;
}

.imgholder {
	height: 70%;
}

.pager {
	position: absolute;
	bottom: 20px;
	display: inline-block;
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
				<a href="/semiProject/NA/tripreView/list.do"><p>여행꿀팁</p></a> <a
					href="/semiProject/JY/FestivalForm.do"><h2>축제정보</h2></a>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="content">
				<table style="text-align: center">
					<c:if test="${count == 0}">
						<table width="700" border="1" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center">게시판에 저장된 글이 없습니다.</td>

							</tr>
						</table>
					</c:if>

					<c:if test="${count > 0}">
						<div id="container">
							<c:forEach var="article" items="${articleList}">
								<a
									href="/semiProject/JY/FestivalDetailForm.do?f_num=${article.f_num }">
									<div class="grid">
										<div class="imgholder">
											<img
												src="${pageContext.request.contextPath}/imgSave/${article.main_img}"
												height="100%" width="100%" />
										</div>
										<strong>${article.f_subject}</strong>

										<div class="meta">${article.f_sdate}~${article.f_edate}</div>
										<div class="meta">${article.f_country}</div>
									</div>
								</a>
							</c:forEach>
						</div>
					</c:if>
					<div align="center">
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
									href="/semiProject/JY/FestivalForm.do?pageNum=${startPage + 10}">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="/semiProject/JY/FestivalForm.do?pageNum=${i}">[${i}]</a>
							</c:forEach>

							<c:if test="${endPage < pageCount}">
								<a
									href="/semiProject/JY/FestivalForm.do?pageNum=${startPage + 10}">[다음]</a>
							</c:if>
						</c:if>


					</div>


				</table>
			</div>

		</div>
	</section>

	<!-- Footer -->
	<tiles:insertDefinition name="mainfooter" />

	<!-- Scripts -->

	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>