<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A관리</title>
<meta name="description"
	content="B
	locksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com" />
<meta name="keywords"
	content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson" />
<link rel='stylesheet' href='../css/festival.css' media='screen' />

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		//vendor script
		$('#header').css({
			'top' : -50
		}).delay(1000).animate({
			'top' : 0
		}, 800);

		$('#footer').css({
			'bottom' : -15
		}).delay(1000).animate({
			'bottom' : 0
		}, 800);

		//blocksit define
		$(window).load(function() {
			$('#container').BlocksIt({
				numOfCol : 5,
				offsetX : 8,
				offsetY : 8
			});
		});

		//window resize
		var currentWidth = 1100;
		$(window).resize(function() {
			var winWidth = $(window).width();
			var conWidth;
			if (winWidth < 660) {
				conWidth = 440;
				col = 2
			} else if (winWidth < 880) {
				conWidth = 660;
				col = 3
			} else if (winWidth < 1100) {
				conWidth = 880;
				col = 4;
			} else {
				conWidth = 1100;
				col = 5;
			}

			if (conWidth != currentWidth) {
				currentWidth = conWidth;
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol : col,
					offsetX : 8,
					offsetY : 8
				});
			}
		});
	});
</script>
<link rel="shortcut icon"
	href="http://www.inwebson.com/wp-content/themes/inwebson2/favicon.ico" />
<link rel="canonical"
	href="http://www.inwebson.com/demo/blocksit-js/demo2/" />
<style type="text/css">

div.pager{
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
					<li class="action active"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

	<!-- Content -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>Q&A 관리</i>
		</h1>
		<b>글 목록(전체 글: ${count})</b>
		<table  width="700" align="center">
			<tr>
				<td align="right">
					<a href="/semiProject/JY/QnaWriteForm.admin">글쓰기</a>
				</td>
			</tr>
		</table>
		
		<c:if test="${count == 0 }">
			<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td>게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${count > 0}">
			<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
				<tr height="30">
					<td align="center" width="50">글번호</td>
					<td align="center" width="250">제목</td>
					<td align="center" width="150">작성일</td>
					<td align="center" width="50">조회수</td>
				</tr>
				
				<c:forEach var="article" items="${articleList}"> <!-- items 콜렉션..... -->
					<tr height="30">
						<td align="center" width="50">
							<c:out value="${number}" />
							<c:set var="number" value="${number -1}" />
						</td>
						<td width="250">
							<a href="/semiProject/JY/NoticeDetailForm.admin?num=${article.q_num}&pageNum=${currentPage}">
								${article.q_subject}
							</a>
							
						</td>
						<td align="center" width="150">${article.q_reg_date}</td>
						<td align="center" width="50">${article.q_readcount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div style="text-align:center">
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
					<a href="/semiProject/JY/QnaForm.admin?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
			
		</div>
	</div>


	<!-- Footer -->

</body>
</html>