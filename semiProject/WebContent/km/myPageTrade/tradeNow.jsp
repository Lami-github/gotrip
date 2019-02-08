<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>거래 현황</title>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
	<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>마이페이지</p>
					<h2>거래현황</h2>
				</header>
			</div>
		</section>
	</div>
	
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
					<h3>1.구매자</h3>
					<div class="buyer-table">
						<div style="height: 30%">
							<c:if test="${b_count==0 }">
								<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td align="center">게시글이 존재하지 않습니다.</td>
									</tr>
								</table>
							</c:if>
							<c:if test="${b_count > 0 }">
								<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
								<tr height="30">
									<td align="center" width="50">글번호</td>
									<td align="center" width="50">상품명</td>
									<td align="center" width="50">거래금액</td>
									<td align="center" width="50">송장번호</td>
									<td align="center" width="50">배송현황</td>
								</tr>
								<c:forEach var="item" items="${b_tradeList}">
								<tr height="30">
									<td align="center" width="50"><a href="/semiProject/km/buyerPage.do?trade_num=${item.trade_num }">${item.trade_num}</a></td>
									<td align="center" width="50">${item.trade_item}</td>
									<td align="center" width="50">${item.trade_point}</td>
									<td align="center" width="50">${item.invoice_num}</td>
									<td align="center" width="50">${item.del_state}</td>
								</tr>
								</c:forEach>
								</table>
							</c:if>
							<c:if test="${b_count > 0 }">
								<c:set var="b_pageCount" value="${b_count/b_pageSize +(b_count%b_pageSize == 0 ? 0 : 1)}" />
								<c:set var="b_pageBlock" value="${5 }" />
								<fmt:parseNumber var="b_result" value="${b_currentPage/5 }" integerOnly="true" />
								<c:set var="b_startPage" value="${b_result*5+1 }" />
								<c:set var="b_endPage" value="${b_startPage + b_pageBlock -1 }" />
								<c:if test="${b_endPage > b_pageCount }">
									<c:set var="b_endPage" value="${b_pageCount }" />
								</c:if>
								<center>
									<c:if test="${b_startPage >10 }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&b_pageNum=${b_startPage-10 }">[이전]</a>
									</c:if>
									<c:forEach var="i" begin="${b_startPage }" end="${b_endPage }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&b_pageNum=${i }">${i }</a>
									</c:forEach>
									<c:if test="${b_endPage < b_pageCount }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&b_pageNum=${b_startPage+10 }">[다음]</a>
									</c:if>
								</center>
							</c:if>
						</div>
					</div>
					<h3 class="sub-header">2.판매자</h3>
					<div class="travler-table">
						<div style="height: 30%">
							<c:if test="${tr_count==0 }">
								<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td align="center">게시글이 존재하지 않습니다.</td>
									</tr>
								</table>
							</c:if>
							<c:if test="${tr_count > 0 }">
								<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
									<tr height="30">
										<td align="center" width="50">글번호</td>
										<td align="center" width="50">상품명</td>
										<td align="center" width="50">거래금액</td>
										<td align="center" width="50">송장번호</td>
										<td align="center" width="50">배송현황</td>
									</tr>
									<c:forEach var="item" items="${tr_tradeList }">
									<tr height="30">
										<td align="center" width="50"><a href="/semiProject/km/travelerPage.do?trade_num=${item.trade_num }">${item.trade_num}</a></td>
										<td align="center" width="50">${item.trade_item}</td>
										<td align="center" width="50">${item.trade_point}</td>
										<td align="center" width="50">${item.invoice_num}</td>
										<td align="center" width="50">${item.del_state}</td>
									</tr>
									</c:forEach>
								</table>
							</c:if>
							<c:if test="${tr_count > 0 }">
								<c:set var="tr_pageCount" value="${tr_count/tr_pageSize +(tr_count%tr_pageSize == 0 ? 0 : 1)}" />
								<c:set var="tr_pageBlock" value="${5 }" />
								<fmt:parseNumber var="tr_result" value="${tr_currentPage/5 }" integerOnly="true" />
								<c:set var="tr_startPage" value="${tr_result*5+1 }" />
								<c:set var="tr_endPage" value="${tr_startPage + tr_pageBlock -1 }" />
								<c:if test="${tr_endPage > tr_pageCount }">
									<c:set var="tr_endPage" value="${tr_pageCount }" />
								</c:if>
								<center>
									<c:if test="${tr_startPage >10 }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&tr_pageNum=${tr_startPage-10 }">[이전]</a>
									</c:if>
									<c:forEach var="i" begin="${tr_startPage }" end="${tr_endPage }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&tr_pageNum=${i }">${i }</a>
									</c:forEach>
									<c:if test="${tr_endPage < tr_pageCount }">
										<a href="/semiProject/km/tradeNow.do?id=${sessionScope.id }&tr_pageNum=${tr_startPage+10 }">[다음]</a>
									</c:if>
								</center>
							</c:if>
						</div>
					</div>
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