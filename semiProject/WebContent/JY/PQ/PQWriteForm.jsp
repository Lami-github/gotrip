<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>1:1 문의</title>

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


<div class=tablediv>
<h1 class="sub-header">
			<i>문의내역 답변작성</i>
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

			${article.pq_content}
	</div>
</div>
<div class=tablediv>
<h4 class="sub-header">
			<i>답변</i>
		</h4>
<form method ="post" name="writeform" action="/semiProject/JY/PQWritePro.admin?pq_type=admin">
<input type="hidden" name="pq_num" value="${pq_num}">
<input type="hidden" name="search" value="${writer}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">
<input type="hidden" name="re_level" value="${re_level}">

<table  border="1" cellspacing="0" cellpadding="0"  align="center">
	<tr>
		<td  width="20%" align="center">제 목</td>
		<td  width="80%">
			<c:if test="${pq_num == 0}">
        		<input type="text" size="100%" maxlength="50" name="pq_subject"></td>
        	</c:if>
        	<c:if test="${pq_num != 0}">
        		<input type="text" size="100%" maxlength="50" name="pq_subject" value="${article.pq_subject }"></td>
        	</c:if>
	</tr>

	<tr>
		<td  width="20%"   align="center" >내 용</td>
		<td  width="80%" >
		<textarea name="pq_content" rows="20%" cols="100%" >${article.pq_content }</textarea> 
		</td>
	</tr>
  <tr>
  	<td colspan=2 align="right">
  	<input type="submit" value="글쓰기" > 
  	<input type="reset" value="다시작성">
  	<input type="button" value="목록" OnClick="window.location='/semiProject/JY/PQForm.admin'">
  	
  	</td>
  </tr>
</table>   
</form>  
</div>   
</body>
</html>      
