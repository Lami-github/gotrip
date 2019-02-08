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
					<li class="action active" ><a href="/semiProject/JY/ExForm.admin">
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
					<li class="action"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>결제 관리</i>
		</h1>
		<h3 class="sub-header">
			2.환전 게시판 상세
		</h3>
	<form>
		<table width="500" border="1" cellspacing="0" cellpadding="0"
			align="center">
			<tr height="30">
				<td align="center" width="125" >글제목</td>
				<td align="center" width="375" align="center" colspan="3">${article.ex_subject}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" >글번호</td>
				<td align="center" width="125" align="center">${article.ex_num}</td>
				<td align="center" width="125" >조회수</td>
				<td align="center" width="125" align="center"></td>
			</tr>
			<tr height="30">
				<td align="center" width="125" >작성자</td>
				<td align="center" width="125" align="center">${article.ex_writer}</td>
				<td align="center" width="125" >작성일</td>
				<td align="center" width="125" align="center">${article.ex_reg_date}</td>
			</tr>

			<tr height="120">
				<td align="left" width="125" colspan="4">
				<pre> 이름: ${article.ac_holder} </pre>
				<pre> 계좌번호: ${article.ac_number}</pre>
				<pre> 은행: ${article.bankname} </pre>
				<pre> 포인트: ${article.ex_point} </pre>
				</td>
			</tr>
			<tr height="30">
				<td colspan="4" bgcolor="${value_c}" align="right"><input
					type="button" value="환전완료"
					onclick="document.location.href='/semiProject/JY/ExchangePro.admin?num=${article.ex_num}&point=${article.ex_point }'">

					<input type="button" value="목록"
					onclick="document.location.href='/semiProject/JY/ExForm.admin'">

				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>