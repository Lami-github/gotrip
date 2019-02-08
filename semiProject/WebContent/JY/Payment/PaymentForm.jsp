<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../css/dashboard.css" rel="stylesheet">



<script>

	function insert(userinput) {
		userinput.check.value="insert";
		userinput.submit();
	}
	function del(userinput) {
		userinput.check.value="delete";
		userinput.submit();
	}
	function standby(num) {
		if(document.getElementById("del").value == '배송전'){
			alert("배송중이 아닐때는 보류할 수 없습니다.")
			return false;
		}
		location.href="/semiProject/JY/TradeStandbyPro.admin?trade_num="+num;
	}
	
	
</script>

</head>

  <body >
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
					<li class="action active" ><a href="/semiProject/JY/PaymentForm.admin">
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
					<li><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

    
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"><i>결제 관리</i></h1>
          <h3 class="sub-header">1.회원-관리자 결제 내역</h3>
          
          <form name=PointUpdatePro action="/semiProject/JY/PointUpdatePro.admin">
          <input type="text" name="num" placeholder="num" size =10>
          <input type="text" name="id" placeholder="id" size =10>
          <input type="text" name="point" placeholder="포인트" size =10>
          <input type="text" name="type" placeholder="결제/환전" size =15>
          <input type="text" name="date" placeholder="yyyy/mm/dd" size =10>
          <input type="hidden" name="check" value="insert">
          <input type="button" value="입력" onclick="insert(this.form)">
          <input type="button" value="삭제" onclick="del(this.form)">
          </form>

			<b>포인트 결제목록(결제수:${p_count})</b>
			

			<c:if test="${p_count == 0}">
				<table width="700" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center">게시판에 저장된 글이 없습니다.</td>
					</tr>
				</table>
			</c:if>

			<c:if test="${p_count > 0}">
				<table border="1" width="700" cellpadding="0" cellspacing="0"
					align="center">
					<tr height="30" bgcolor="${value_c}">
						<td align="center" width="50">num</td>
						<td align="center" width="100">Id</td>
						<td align="center" width="50">Point</td>
						<td align="center" width="50">Type</td>
						<td align="center" width="100">Date</td>
						
					</tr>

					<c:forEach var="point" items="${pointList}">
						<tr height="30">
							<td align="center" width="50">${point.num}</td>
							<td align="center" width="100">${point.id}</td>
							<td align="center" width="50">${point.update_point}</td>
							<td align="center" width="50">${point.type}</td>
							<td align="center" width="100">${point.update_date}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

		<c:if test="${p_count > 0}">
			<c:set var="p_pageCount"
				value="${p_count / pageSize + ( p_count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="p_pageBlock" value="${10}" />
			<fmt:parseNumber var="p_result" value="${p_currentPage / 10}"
				integerOnly="true" />
			<c:set var="p_startPage" value="${p_result * 10 + 1}" />
			<c:set var="p_endPage" value="${p_startPage + p_pageBlock-1}" />
			<c:if test="${p_endPage > p_pageCount}">
				<c:set var="p_endPage" value="${p_pageCount}" />
			</c:if>
			<center>
				<c:if test="${p_startPage > 10}">
					<a href="/semiProject/JY/PaymentForm.admin?p_pageNum=${p_startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${p_startPage}" end="${p_endPage}">
					<a href="/semiProject/JY/PaymentForm.admin?p_pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${p_endPage < p_pageCount}">
					<a href="/semiProject/JY/PaymentForm.admin?p_pageNum=${p_startPage + 10}">[다음]</a>
				</c:if>
				
				<br>
				<br>
				<form name=PointSearchPro action="/semiProject/JY/PointSearchPro.admin">
					<select name="searchn">
						<option value="0">ID</option>
						<option value="1">DATE</option>
					</select> <input type="text" name="search" size="15" maxlength="50" /> <input
						type="submit" value="검색" />
				</form>
			</center>
		</c:if>
		<br>
		<br>

		<h3 class="sub-header">2.회원-회원 결제 내역</h3>
			<b>포인트 결제목록(결제수:${tr_count})</b>
			

			<c:if test="${tr_count == 0}">
				<table width="700" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center">게시판에 저장된 글이 없습니다.</td>
					</tr>
				</table>
			</c:if>

			<c:if test="${tr_count > 0}">
				<table border="1" width="700" cellpadding="0" cellspacing="0"
					align="center">
					<tr height="30" bgcolor="${value_c}">
						<td align="center" width="100">구매자ID</td>
						<td align="center" width="100">여행자ID</td>
						<td align="center" width="50">결제상태</td>
						<td align="center" width="50">포인트</td>
						<td align="center" width="200">기간</td>
						<td align="center" width="100" colspan="2">보류</td>
						
					</tr>

				<c:forEach var="trade" items="${tradeList}">
					<tr height="30">
						<td align="center" width="100">${trade.b_id}</td>
						<td align="center" width="100">${trade.tr_id}</td>
						<td align="center" width="50" id="del" >${trade.del_state}</td>
						<td align="center" width="50">${trade.trade_point}</td>
						<td align="center" width="200" >
							<c:if test="${trade.trade_sdate ne null}">
								${trade.trade_sdate}<br>~${trade.trade_edate}
							</c:if>
						</td>
						<td align="center" width="50">
							<c:if
								test="${trade.standby eq 'T'}">보류
							</c:if>
						</td>
						<td align="center" width="50">
							<input type="button" value="보류"onclick="standby('${trade.trade_num}')" />
						</td>

					</tr>

				</c:forEach>
			</table>
			</c:if>

		<c:if test="${tr_count > 0}">
			<c:set var="tr_pageCount"
				value="${tr_count / pageSize + ( tr_count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="tr_pageBlock" value="${10}" />
			<fmt:parseNumber var="tr_result" value="${tr_currentPage / 10}"
				integerOnly="true" />
			<c:set var="tr_startPage" value="${tr_result * 10 + 1}" />
			<c:set var="tr_endPage" value="${tr_startPage + tr_pageBlock-1}" />
			<c:if test="${tr_endPage > tr_pageCount}">
				<c:set var="tr_endPage" value="${tr_pageCount}" />
			</c:if>
			<center>
				<c:if test="${tr_startPage > 10}">
					<a href="/semiProject/JY/PaymentForm.admin?tr_pageNum=${tr_startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${tr_startPage}" end="${tr_endPage}">
					<a href="/semiProject/JY/PaymentForm.admin?tr_pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${tr_endPage < tr_pageCount}">
					<a href="/semiProject/JY/PaymentForm.admin?tr_pageNum=${tr_startPage + 10}">[다음]</a>
				</c:if>
				
				<br>
				<br>
				<form name=TradeSearchPro action="/semiProject/JY/TradeSearchPro.admin">
					<select name="searchn">
						<option value="0">ID</option>
						<option value="1">DATE</option>
					</select> <input type="text" name="search" size="15" maxlength="50" /> <input
						type="submit" value="검색" />
				</form>
			</center>
		</c:if>
	</div>
	
</body>
	
</html>
