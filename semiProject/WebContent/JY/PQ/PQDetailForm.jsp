<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>게시판</title>

<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">

<style>

.mainimg{
	width:100%;
	height:35%;
}
.detaildiv{
	wdith:60%;
}

.imgdiv{
	width: 40%;
    height: 50%;
    display: inline-block;
    margin-right: 20;
}
.contentdiv{
	width: 50%;
    height: 50%;
    display: inline;
}
.tablediv{
	width:60%;
	margin: 0 auto;
}
.tablediv table{
	width:100%;
	
}

</style>
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
					<li class="action active" ><a href="/semiProject/JY/PQForm.admin"><b>문의
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
<div class=mainimg>
	<img width=100% height=100% src="titleimage.png">
</div>

<div class=tablediv>

<div class=tablediv>
<h1 class="sub-header">
			<i>문의내역 상세보기</i>
		</h1>
<table  border=1 align="center" text-aling="center">
	<tr height=50px>
		<td width="10%">문의분류</td>
		<td>${article.type }</td>
		<td width="10%">제목</td>
		<td>${article.pq_subject}</td>
	</tr>
	<tr height=50px>
		<td width="10%">작성자</td>
		<td>${article.writer }</td>
		<td width="10%">등록일</td>
		<td>${article.pq_reg_date }</td>
		
	</tr>
</table>
<div class="imgdiv">
				<%-- <div class="carousel-inner">
					<c:forEach var=photo items=${photoList }>
						<div class="item active">
							<img
								src="${pageContext.request.contextPath}/imgSave/${photo.img}"
								alt="">
							<div class="carousel-caption"></div>
						</div>
					</c:forEach>

				</div> --%>
				<img width=100% height=100% src="titleimage.png" alt="">
			</div>
	<div class=contentdiv>
		asdfdsagadsjlk
		미ㅏ널이ㅏㅓㄴ미ㅏ러;ㅣㄴㅁ
		ㅁ넝리ㅏㅓㄴ미ㅓ리ㅏ
			${article.pq_content}
	</div>
</div>
	

<form>
<table width="500" border="0" cellspacing="0" cellpadding="0" align="center"> 
  <tr height="30">     
    <td colspan="4" bgcolor="${value_c}" align="right" >
      <input type="button" value="목록"
       onclick="document.location.href='/semiProject/JY/PQForm.admin'">
      <input type="button" value="답글쓰기"
       onclick="document.location.href='/semiProject/JY/PQWriteForm.admin?pq_num=${article.pq_num}&writer=${article.writer}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">

    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>