<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/bootshape.js"></script>
<link href="<%=request.getContextPath() %>/css/bootshape.css" rel="stylesheet">
<html>
<head>
<title>같이...여행갈래요?</title>

</head>
<body>

<!-- Header -->
	<tiles:insertDefinition name="mainheader" />
	
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
	
	<table border=1 width=600 cellpadding=0 cellspacing=0 align=center>
<tr height="30">
      <td align="center"  width="50"  >글번호</td>
      <td align="center"  width="50" >분   류</td>
      <td align="center"  width="430" >제   목</td>
      <td align="center"  width="70"  >날   짜</td>
    </tr>
<c:choose>
	<c:when test="${q_list==null}">
		<tr>
			<td align="center"><br>문의한 내용이 없습니다.</td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr>
			<td align="center"></td>
		</tr>
		<c:forEach var="list" items="${q_list}">
			<tr>
				<td><c:out value="${list.pq_num}"/></td>
				<td><c:out value="${list.pq_type}" />
				<td><a href="/semiProject/mj/questionContent.do?pq_num=<c:out value="${list.pq_num}"/>&pq_type=<c:out value="${list.pq_type}"/>&writer=<c:out value="${list.writer}"/>"><c:out value="${list.pq_subject}"/></a></td>
				<td><c:out value="${list.pq_reg_date}" /></td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</table>
<c:if test="${count>0 }">
	<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1) }"/>
	<c:set var="pageBlock" value="${10 }"/>
	<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
	<c:set var="startPage" value="${result * 10 +1 }"/>
	<c:set var="endPage" value="${startPage + pageBlock-1 }"/>
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}"/>
	</c:if>
		<c:if test="${startPage > 10}">
		<a href="/semiProject/mj/question.do?pageNum=${startPage - 10}" >[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/semiProject/mj/question.do?pageNum=${i}" >[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
		<a href="/semiProject/mj/question.do?pageNum=${startPage + 10}" >[다음]</a>
	</c:if>
</c:if>

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