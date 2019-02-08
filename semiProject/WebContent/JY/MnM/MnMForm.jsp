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

<!-- <script>
	var rowIndex = 1;

	function addFile(form) {
		if (rowIndex > 4)
			return false;

		rowIndex++;
		var getTable = document.getElementById("insertTable");
		var oCurrentRow = getTable.insertRow(getTable.rows.length);
		var oCurrentCell = oCurrentRow.insertCell(0);
		oCurrentCell.innerHTML = "<tr><td colspan=2><INPUT TYPE='FILE' NAME='filename" + rowIndex + "' size=25></td></tr>";
	}
</script> -->


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
					<li class="action active" ><a href="/semiProject/JY/MnMForm.admin"> - 회원</a></li>
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
					<li><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>
	
	

    
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"><i>회원 관리</i></h1>
          <h3 class="sub-header"><i>1.회원 내역</i></h3>
          
      <!--     <form name="write">
     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
        <tr>
        	<td valign=bottom>
        		<INPUT type='file' maxLength='100' name='filename1' size='25'>
        	</td>
        	<td width=100>
        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
        	</td>
        </tr>
    </table>
    <input type="hidden" name="rowCount" value="1">
    <input type="submit">
</form>
          --> 
          <form name=MnMModifyPro action="/semiProject/JY/MnMModifyPro.admin">
          <input type="text" name="id" placeholder="id" size =10>
          <input type="text" name="point" placeholder="포인트" size =10>
          <input type="text" name="warn" placeholder="경고횟수" size =10>
          <input type="text" name="blacklist" placeholder="블랙리스트" size =10>
          <input type="text" name="grade" placeholder="등급" size =10>
          <input type="submit" value="수정">
          </form>

			<b>회원목록(회원수:${count})</b>
			

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
						<td align="center" width="100">id</td>
						<td align="center" width="100">이름</td>
						<td align="center" width="100">휴대폰</td>
						<td align="center" width="150">이메일</td>
						<td align="center" width="50">포인트</td>
						<td align="center" width="50">경고횟수</td>
						<td align="center" width="50">블랙리스트</td>
						<td align="center" width="100">등급</td>
					</tr>

					<c:forEach var="member" items="${memberList}">
						<tr height="30">
							<td align="center" width="100">${member.id}</td>
							<td align="center" width="100">${member.name}</td>
							<td align="center" width="100">${member.phonenumber}</td>
							<td align="center" width="150">${member.email}</td>
							<td align="center" width="50">${member.point}</td>
							<td align="center" width="50">${member.warn}</td>
							<td align="center" width="50">${member.blacklist}</td>
							<td align="center" width="100">${member.grade}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

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
			<center>
				<c:if test="${startPage > 10}">
					<a href="/semiProject/JY/MnMForm.admin?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/semiProject/JY/MnMForm.admin?pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="/semiProject/JY/MnMForm.admin?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
				
				<br>
				<br>
				<form name=MnMSearchPro action="/semiProject/JY/MnMSearchPro.admin">
					<select name="searchn">
						<option value="0">아이디</option>
						<option value="1">이름</option>
						<option value="2">경고횟수</option>
						<option value="3">등급</option>
					</select> <input type="text" name="search" size="15" maxlength="50" /> <input
						type="submit" value="검색" />
				</form>
			</center>
		</c:if>
	</div>
</body>
</html>
