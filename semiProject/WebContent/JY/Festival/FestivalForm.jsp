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
<link rel='stylesheet' href='../css/festival.css' media='screen' />

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/dashboard.css" rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<link rel="shortcut icon"
	href="http://www.inwebson.com/wp-content/themes/inwebson2/favicon.ico" />
<link rel="canonical"
	href="http://www.inwebson.com/demo/blocksit-js/demo2/" />
<style type="text/css">
.grid{
	width: 250px;
    height: 300px;
    padding: 15px;
    background: #fff;
    margin: 8px;
    font-size: 12px;
    float: left;
}
.imgholder{
	height:50%;
}
</style>
</head>

<body>

	<!-- Header -->
	<tiles:insertDefinition name="adminheader" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="action"><a href="/semiProject/JY/StateForm.admin"><b>통계관리</b> <span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>회원관리</b></a></li>
					<li class="action" ><a href="/semiProject/JY/MnMForm.admin"> - 회원</a></li>
					<li class="action"><a href="/semiProject/JY/BLForm.admin">
							- 블랙리스트</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action" ><a href="/semiProject/JY/PQForm.admin"><b>문의
								내역 관리</b> <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>결제관리</b></a></li>
					<li class="action" ><a href="/semiProject/JY/PaymentForm.admin">
							- 결제 내역 관리</a></li>
					<li class="action" ><a href="/semiProject/JY/ExForm.admin">
							- 환전 관리</a></li>
					<li class="action" ><a href="/semiProject/JY/AdForm.admin"> - 광고관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action"><a href="/semiProject/JY/BoardForm.admin"><b>게시판 관리 </b><span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>고객센터 관리</b></a></li>
					<li class="action"><a href="/semiProject/JY/NoticeForm.admin"> - 공지사항 관리</a></li>
					<li class="action"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action active"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

	<!-- Content -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>축제정보 관리</i>
		</h1>
		<table align="left">
				<tr>
				<td>
				축제수: "${count}"
				</td>
				<td>
				<input type="button" value="글쓰기"
						onclick="document.location.href='/semiProject/JY/FestivalWriteForm.admin'">
				</td>
				</tr>
		</table>
		<br>
		<br>
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
				<a href="/semiProject/JY/FestivalDetailForm.admin?f_num=${article.f_num }">
					<div class="grid">
						<div class="imgholder">
							<img
								src="${pageContext.request.contextPath}/imgSave/${article.main_img}"
								width="100%"
								height="100%"/>
						</div>
						<strong>${article.f_subject}</strong>

						<div class="meta">${article.f_sdate} ~ ${article.f_edate}</div>
						<div class="meta">${article.f_country}</div>
					</div>
				</a>
				</c:forEach>
			</div>
		</c:if>

		<div class="pager" style="text-align: center">
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
						href="/semiProject/JY/FestivalForm.admin?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/semiProject/JY/FestivalForm.admin?pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a
						href="/semiProject/JY/FestivalForm.admin?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
			

		</div>
	</div>

	<!-- Footer -->
</body>
</html>