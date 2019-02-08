<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>관리자 회원관리</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/dashboard.css" rel="stylesheet">


</head>

<body>
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
					<li class="action active"><a href="/semiProject/JY/BoardForm.admin"><b>게시판 관리 </b><span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>고객센터 관리</b></a></li>
					<li class="action"><a href="/semiProject/JY/NoticeForm.admin"> - 공지사항 관리</a></li>
					<li class="action"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>


	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>게시판 관리</i>
		</h1>


		<b>게시판(게시글수:${count})</b> 
		<select name="type" onchange="location.href=this.value">
			<option>분류선택</option>
			<option value="/semiProject/JY/BoardForm.admin?select=tripreview">이용후기</option>
			<option value="/semiProject/JY/BoardForm.admin?select=traveler">여행자게시판</option>
			<option value="/semiProject/JY/BoardForm.admin?select=buyer">구매자게시판</option>
			
		</select>



		<c:if test="${count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="700" cellpadding="0" cellspacing="0"
				align="center">
				<tr height="30" bgcolor="${value_c}">
					<td align="center" width="50">글번호</td>
					<td align="center" width="150">분류</td>
					<td align="center" width="300">제목</td>
					<td align="center" width="100">작성자</td>
					<td align="center" width="100">작성일</td>


				</tr>

				<c:forEach var="article" items="${ArticleList}">
					<c:choose>
						<c:when test="${select eq 'tripreview'}">
							<tr height="30">
							<td align="center" width="50">${article.t_num}</td>
							<td align="center" width="150">여행후기</td>
							<td align="center" width="300">
							<a href="/semiProject/JY/PQDetailForm.admin?num=${article.t_num}&pageNum=${currentPage}">
								${article.t_subject} </a> 
							</td>
							<td align="center" width="100">${article.t_writer}</td>
							<td align="center" width="100">${article.t_reg_date}</td>
							</tr>
						</c:when>

						<c:when test="${select eq 'traveler'}">
							<tr height="30">
						<td align="center" width="50">${article.tr_num}</td>
						<td align="center" width="150">여행자게시판</td>
						<td align="center" width="300">
							<a href="/semiProject/JY/PQDetailForm.admin?num=${article.tr_num}&pageNum=${currentPage}">
								${article.tr_subject} </a> 
						</td>
						<td align="center" width="100">${article.tr_writer}</td>
						<td align="center" width="100">${article.tr_reg_date}</td>

					</tr></c:when>
						<c:when test="${select eq 'buyer'}">
							<tr height="30">
						<td align="center" width="50">${article.b_num}</td>
						<td align="center" width="150">구매자게시판</td>
						<td align="center" width="300">
							<a href="/semiProject/JY/PQDetailForm.admin?num=${article.b_num}&pageNum=${currentPage}">
								${article.b_subject} </a> 
						</td>
						<td align="center" width="100">${article.b_writer}</td>
						<td align="center" width="100">${article.b_reg_date}</td>

					</tr></c:when>
					</c:choose>
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
						href="/semiProject/JY/BoardForm.admin?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/semiProject/JY/BoardForm.admin=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="/semiProject/JY/BoardForm.admin=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
			
			<form name=BoardSearchPro
				action="/semiProject/JY/BoardForm.admin?select=${select}">
				<select name="searchn">
					<option value="0">제목</option>
					<option value="1">작성자</option>
					<option value="2">내용</option>
				</select> <input type="text" name="search" size="15" maxlength="50" /> <input
					type="submit" value="검색" />
			</form>
			
		</div>
	</div>
</body>
</html>
