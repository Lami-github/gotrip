<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<title>게시판</title>


</head>

<body bgcolor="${bodyback_c}">
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
					<li class="action active"><a href="/semiProject/JY/NoticeForm.admin"> - 공지사항 관리</a></li>
					<li class="action"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>공지사항 관리</i>
		</h1>
	<form>
		<table width="500" border="1" cellspacing="0" cellpadding="0"
			align="center">
			<tr height="30">
				<td align="center" width="125" >글제목</td>
				<td align="center" width="375"  colspan="3">${article.n_subject}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125">글번호</td>
				<td align="center" width="125" >${article.n_num}</td>
				<td align="center" width="125" >조회수</td>
				<td align="center" width="125" >${article.n_readcount}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" >작성자</td>
				<td align="center" width="125" >관리자</td>
				<td align="center" width="125" >작성일</td>
				<td align="center" width="125" >${article.n_reg_date}</td>
			</tr>

			<tr height="120">
				<td align="left" width="125" colspan="4">
					${article.n_content}
				</td>
			</tr>
			<tr height="30">
				<td colspan="4" bgcolor="${value_c}" align="right">
						<input type="button" value="글수정" onclick="document.location.href='/semiProject/JY/NoticeModifyForm.admin?num=${article.n_num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="글삭제" onclick="document.location.href='/semiProject/JY/NoticeDeletePro.admin?num=${article.n_num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="글목록" onclick="document.location.href='/semiProject/JY/NoticeForm.admin?pageNum=${pageNum}'">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>