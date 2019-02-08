<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>여행가좌 by 멋지고 쿨한 오조.</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />

<style>
.grid {
	width: 23.5%;
	min-height: 100px;
	padding: 15px;
	background: #fff;
	margin: 8px;
	font-size: 12px;
	float: left;
	box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-moz-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-webkit-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-webkit-transition: top 1s ease, left 1s ease;
	-moz-transition: top 1s ease, left 1s ease;
	-o-transition: top 1s ease, left 1s ease;
	-ms-transition: top 1s ease, left 1s ease;
}

.grid strong {
	border-bottom: 1px solid #ccc;
	margin: 10px 0;
	display: block;
	padding: 0 0 5px;
	font-size: 17px;
}

.grid .meta {
	text-align: right;
	color: #777;
	font-style: italic;
}

.grid .imgholder img {
	max-width: 100%;
	background: #ccc;
	display: block;
}

@media screen and (max-width : 1240px) {
	body {
		overflow: auto;
	}
}

.asd {
	background-color: white;
}
</style>
</head>
<body>

	<!-- Header -->
	<tiles:insertDefinition name="mainheader" />

	<!-- Content -->
	<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>직구할까?</p>
					<h2>여행자페이지</h2>
				</header>
			</div>
		</section>
	</div>


	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"> </header>
					<hr>
					<br> <b>글목록(전체 글:${count}) </b>
					<form action="/semiProject/NA/traveler/list.do">
						<table>
							<tr>
								<td><select name="n">
										<option value="0">작성자</option>
										<option value="1">출발나라</option>
										<option value="2">도착나라</option>
								</select></td>
								<td align=center><input id="aa" type="text" name="search">
								</td>
								<td align=center width=10%>
									<button type="submit" class="button special icon fa-search">
									</button>
								</td>
							</tr>
						</table>
						<br>
					</form>
					<div>
						<c:if test="${count eq 0}">
							<table width="700" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center">게시판에 저장된 글이 없습니다.</td>
								</tr>
							</table>
						</c:if>

						<c:if test="${count > 0 }">
							<table align=center>
								<c:forEach var="travelerBoard" items="${travelerBoardList}">
									<a
										href="/semiProject/mj/travelerDetail.do?pageNum=${currentPage}&tr_num=${travelerBoard.tr_num}">
										<div class="grid">
											<div class="imgholder">
												<img
													src="${pageContext.request.contextPath}/imgSave/${travelerBoard.imgPath}" />
												<strong>유저이름 : ${travelerBoard.tr_writer}</strong><br>
											</div>
											${travelerBoard.begin_country} &nbsp;-->&nbsp;
											${travelerBoard.arrived_country}<br>
											${travelerBoard.begin_day} &nbsp;-->&nbsp;
											${travelerBoard.arrived_day}<br> <br> 한도금액 :
											${travelerBoard.limit_money}원
										</div>
									</a>
								</c:forEach>
							</table>
						</c:if>
					</div>
					<div align="center">
						<c:if test="${count > 0 }">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<c:set var="pageBlock" value="${5}" />
							<fmt:parseNumber var="result" value="${currentPage / 5}"
								integerOnly="true" />
							<c:set var="startPage" value="${result * 5 + 1}" />
							<c:set var="endPage" value="${startPage + pageBlock-1}" />
							<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>


							<c:if test="${startPage > 5 }">
								<a
									href="/semiProject/NA/traveler/list.do?pageNum=${startPage - 5}">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="/semiProject/NA/traveler/list.do?pageNum=${i}">[${i}]</a>
							</c:forEach>

							<c:if test="${endPage < pageCount}">
								<a
									href="/semiProject/NA/traveler/list.do?pageNum=${startPage + 5}">[다음]</a>
							</c:if>

						</c:if>
						<c:if test="${sessionScope.id ne null}">
							<button
								onclick="location.href='/semiProject/NA/traveler/writeForm.jsp'">글쓰기</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>

	<tiles:insertDefinition name="mainfooter" />

	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>

</body>
</html>

