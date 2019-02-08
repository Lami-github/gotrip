<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 관리</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">

<script>
   function writesubmit(writeForm){
	   if(!writeForm.q_subject.value){
		   alert("제목을 입력해주세요");
		   return false;
	   }
	   if(!writeForm.q_content.value){
		   alert("내용을 입력해주세요");
		   return false;
	   }

	   writeForm.submit(); 
   }
   function modifysubmit(modifyForm){
	   if(!modifyForm.q_subject.value){
		   alert("제목을 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.q_content.value){
		   alert("내용을 입력해주세요");
		   return false;
	   }

	   modifyForm.submit(); 
	 
   }
</script>
</head>

<body >
	<!-- Header -->
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
					<li class="action"><a href="/semiProject/JY/NoticeForm.admin"> - 공지사항 관리</a></li>
					<li class="action active"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

	<!-- Content -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>Q&A 관리</i>
		</h1>
		
		<c:if test="${modify == 0  }">
		<h3 class="sub-header">Q&A 작성하기</h3>
		<form name="write" action="/semiProject/JY/QnaWritePro.admin"  method="post">
			<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">
			<tr>
				<td width="70" align="center">제목</td>
				<td width="330"><input type="text" size="40" maxlength="50" name="q_subject"></td>
			</tr>
			<tr>
				<td colspan="2" width="330" align="center">
					<textarea name="q_content" rows="13" cols="40" placeholder="내용을 입력해주세요."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="목록보기" OnClick="window.location='/semiProject/JY/QnaForm.admin?pageNum=${pageNum}'">
					<input type="button" value="완료" onclick="writesubmit(this.form)" >
				</td>
			</tr>
		</table>
		</form>
		</c:if>
		<c:if test="${modify == 1  }">
		<h3 class="sub-header">Q&A 수정하기</h3>
		<form name="modify" method="post" action="/semiProject/JY/QnaModifyPro.admin?num=${q_num}">
			<input type="hidden" name="num" value="${q_num}">
			
			<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td width="70" align="center">제목</td>
					<td align="left" width="330">
						<input type="text" size="40" maxlength="50" name="q_subject" value="${article.q_subject}">
					</td>
				</tr>
				<tr>
					<td width="70" align="center">내용</td>
					<td align="center" width="330">
						<textarea name="q_content" rows="13" cols="40">${article.q_content}</textarea>
					</td>
				</tr>
				<tr>     
					<td colspan=2 align="center">
						<input type="button" value="완료" onclick="modifysubmit(this.form)">
						<input type="button" value="취소" onclick="document.location.href='/semiProject/JY/QnaForm.admin?pageNum=${pageNum}'">
					</td>
				</tr>
			</table>
		</form>
		</c:if>
	</div>
</body>
</html>