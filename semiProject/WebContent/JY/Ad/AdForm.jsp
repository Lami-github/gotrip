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
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

<script>

	function insert(userinput) {
		if(!userinput.ad_loc.value){
			alert("광고위치를 입력해주세요.")
			return false;
		}
		if(!userinput.ad_sdate.value){
			alert("계약날짜를 입력해주세요.")
			return false;
		}
		if(!userinput.ad_edate.value){
			alert("만료날짜를 입력해주세요.")
			return false;
		}
		if(!userinput.ad_company.value){
			alert("광고회사를 입력해주세요.")
			return false;
		}
		if(!userinput.ad_price.value){
			alert("거래금액을 입력해주세요.")
			return false;
		}
		userinput.check.value="insert";
		userinput.submit();
	}
	function del(userinput) {
		if(!userinput.ad_id.value){
			alert("광고id를 입력해주세요.")
			return false;
		}
		userinput.check.value="delete";
		userinput.submit();
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
					<li class="action" ><a href="/semiProject/JY/PaymentForm.admin">
							- 결제 내역 관리</a></li>
					<li class="action" ><a href="/semiProject/JY/ExForm.admin">
							- 환전 관리</a></li>
					<li class="action active" ><a href="/semiProject/JY/AdForm.admin"> - 광고관리</a></li>
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
					<li class="action"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

    
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"><i>결제 관리</i></h1>
          <h3 class="sub-header">3.광고 관리</h3>
          <p>관리자 - 광고주 결제 내역</p>
          <form name=PointUpdatePro action="/semiProject/JY/AdUpdatePro.admin">
          <input type="text" name="ad_id" placeholder="광고id" size =5>
          <input type="text" name="ad_loc" placeholder="광고위치" size =5>
          <input type="text" name="ad_sdate" placeholder="계약날짜(yyyy/mm/dd)" size =15>
          <input type="text" name="ad_edate" placeholder="만료날짜(yyyy/mm/dd)" size =15>
          <input type="text" name="ad_company" placeholder="광고회사" size=10>
          <input type="text" name="ad_price" placeholder="거래금액" size=10>
          <input type="hidden" name="check" value="insert">
          <input type="button" value="입력" onclick="insert(this.form)">
          <input type="button" value="삭제" onclick="del(this.form)">
          </form>

			<b>광고 계약목록(계약수:${count})</b>
			

			<c:if test="${p_count == 0}">
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
						<td align="center" width="50">광고id</td>
						<td align="center" width="50">광고위치</td>
						<td align="center" width="100">계약날짜</td>
						<td align="center" width="100">계약만료</td>
						<td align="center" width="100">광고회사</td>
						<td align="center" width="50">거래금액(만)</td>
						
					</tr>

					<c:forEach var="ad" items="${adList}">
						<tr height="30">
							<td align="center" width="50">${ad.ad_id}</td>
							<td align="center" width="50">${ad.ad_loc}</td>
							<td align="center" width="100">${ad.ad_sdate}</td>
							<td align="center" width="100">${ad.ad_edate}</td>
							<td align="center" width="100">${ad.ad_company}</td>
							<td align="center" width="50">${ad.ad_price}</td>
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
						href="/semiProject/JY/AdForm.admin?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/semiProject/JY/AdForm.admin?pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="/semiProject/JY/AdForm.admin?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
			
			<br>
			<br>
			
			<form name=AdSearchPro
				action="/semiProject/JY/AdSearchPro.admin">
				<select name="searchn">
					<option value="0">광고위치</option>
					<option value="1">광고회사</option>
					<option value="2">계약날짜</option>
					<option value="3">만료날짜</option>
				</select> <input type="text" name="search" size="15" maxlength="50" /> <input
					type="submit" value="검색" />
			</form>
		</div>

		
	</div>
</body>
</html>
