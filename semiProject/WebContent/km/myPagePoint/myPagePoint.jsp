<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="/jquery.min.js"></script>
			<script src="/js/jquery.scrollex.min.js"></script>
			<script src="/js/skel.min.js"></script>
			<script src="/js/util.js"></script>
			<script src="/js/main.js"></script>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
</head>

<body>
<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>마이페이지</p>
				<h2>포인트 관리</h2>
			</header>
		</div>
	</section>

 <header>
 <p style="text-align:center;"></p>
 <hr />
<h3 class="sub-header" style=text-align:center;>안녕하세요!! * ${sessionScope.id } * 님. 현재 보유하고 계신 포인트는 * ${point }point  *  입니다.</h3>
<hr />
<p style="text-align:center;">포인트사용내역</p>
</header>
<table>
<c:choose>
<c:when test="${empty member}">

<tr>
<td colspan="5">포인트 이용내역이 없습니다.</td></tr>
</c:when>
<c:otherwise>

<tr height="30" >
            <td align="center" width="50">번 호</td>
            <td align="center" width="250">이용날짜</td>
            <td align="center" width="100">결제방식</td>
            <td align="center" width="150">결제포인트</td>            
            <td align="center" width="150">보유포인트</td>
</tr>
<c:forEach var="item" items="${member }">
<tr height="30">
<td align="center" width="50">${item.num}</td>
<td align="center" width="50">${item.update_date }</td>
<td align="center" width="50">${item.type }</td>
<td align="center" width="50">${item.update_point }</td>
<td align="center" width="50">${item.after_point }</td>

</tr> 
</c:forEach>

</c:otherwise>
</c:choose>
</table>     
<div style="height:30%; text-align:center;">
<input type="button" value="포인트 충전하기" class="btn-btn" onclick="document.location.href='/semiProject/EB/Main_Payment.do'">
<input type="button" value="포인트 환전하기" class="btn-btn" onclick="document.location.href='/semiProject/km/pointExchangeForm.do'">
</div>
<div class="push">
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
      