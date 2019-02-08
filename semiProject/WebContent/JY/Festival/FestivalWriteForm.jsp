<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript">
$(function() {
    $( "#Datepicker" ).datepicker({
    	changeMonth: true, 
        changeYear: true,
        showButtonPanel: true,
        dateFormat: "yyyy/mm/dd"
    });
});
</script>
<script>

   var rowIndex = 1;

   function addFile(form) {
      if (rowIndex > 4)
         return false;

      rowIndex++;

      var getTable = document.getElementById("insertTable");
      var oCurrentRow = getTable.insertRow(getTable.rows.length);
      var oCurrentCell = oCurrentRow.insertCell(0);
      oCurrentCell.innerHTML = "<tr><td colspan=6><INPUT TYPE='FILE' NAME='filename" + rowIndex + "'></td></tr>";
   }
   function deleteFile(form){
	   if(rowIndex<2){
		   return false;
	   }else{
		   rowIndex--;
		   
	   }

	   var getTable = document.getElementById("insertTable");
	   getTable.deleteRow(rowIndex);
   }
   function writesubmit(writeForm){
	   if(!writeForm.f_subject.value){
		   alert("축제이름을 입력해주세요");
		   return false;
	   }
	   if(!writeForm.f_country.value){
		   alert("나라를 입력해주세요");
		   return false;
	   }
	   if(!writeForm.f_loc.value){
		   alert("축제지역을 입력해주세요");
		   return false;
	   }
	   if(!writeForm.f_sdate.value){
		   alert("축제시작날짜를 입력해주세요");
		   return false;
	   }
	   if(!writeForm.f_edate.value){
		   alert("축제마감날짜를 입력해주세요");
		   return false;
	   }
	   if(!writeForm.filename1.value){
		   alert("축제관련사진를 업로드해주세요");
		   return false;
	   }
	   writeForm.index.value = rowIndex;

	   writeForm.submit(); 
   }
   function modifysubmit(modifyForm){
	   if(!modifyForm.f_subject.value){
		   alert("축제이름을 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.f_country.value){
		   alert("나라를 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.f_loc.value){
		   alert("축제지역을 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.f_sdate.value){
		   alert("축제시작날짜를 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.f_edate.value){
		   alert("축제마감날짜를 입력해주세요");
		   return false;
	   }
	   if(!modifyForm.filename1.value){
		   alert("축제관련사진를 업로드해주세요");
		   return false;
	   }
	   modifyForm.index.value = rowIndex;

	   modifyForm.submit(); 
	 
   }
</script>
</head>

<body bgcolor="${bodyback_c}">
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
					<li class="action"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action active"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

	<!-- Content -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>축제정보 관리</i>
		</h1>
		
		<c:if test="${modify == 0  }">
		<h3 class="sub-header">축제정보 작성하기</h3>
		<form name="write" action="/semiProject/JY/FestivalWritePro.admin"  method="post" enctype="multipart/form-data">
		<input type="hidden" name="index" value="0">
			<table width="640" border="0" cellspacing="0" cellpadding="0"
				align="center">



				<tr height="30">
					<td width="80" align="center">제목</td>
					<td width="280" colspan="3"><input name="f_subject"
						type="text" size="40"></td>
					<td width="80" align="center">홈페이지</td>
					<td width="200"><input name="f_url" type="text"></td>
				</tr>
				<tr height="30">
					<td width="80" align="center">나라</td>
					<td width="100"><input name="f_country" type="text" size="12">
					<td width="80" align="center">위치</td>
					<td width="100"><input name="f_loc" type="text" size="12">
					<td width="80" align="center">기간</td>
					<td width="200"><input name="f_sdate" type="text" size="10" id="Datepicker">~<input
						name="f_edate" type="text" size="10" id="Datepicker"></td>
				</tr>
				<tr height="300">
					<td width="80" align="center">상세내용</td>
					<td colspan="5"><textarea name="f_content" rows="18" cols="80"></textarea></td>
				</tr>
				<tr height="60">
					<td width="80" align="center">사진첨부</td>
					<td colspan=5 width="580"><table width="100%" id="insertTable">
							<tr>
								<td valign=bottom><INPUT type='file' maxLength='100'
									name='filename1' size='15'></td>
								<td width=100><input type="button" value="추가"
									onClick="addFile(this.form)" border=0 style='cursor: hand'>
									<input type="button" value="삭제" onClick='deleteFile(this.form)'
									border=0 style='cursor: hand'></td>
							</tr>

						</table></td>

				</tr>
				<tr>
				</tr>
				<tr height="30">
					<td colspan=6 align="right">
						<input type="button" value="글목록"
						onclick="document.location.href='/semiProject/JY/FestivalForm.admin'">
						&nbsp;
						&nbsp;
						<input type="button" value="완료" onclick="writesubmit(this.form)">
					</td>
				</tr>

			</table>
		</form>
		</c:if>
		<c:if test="${modify == 1 }">
		<h3 class="sub-header">축제정보 수정하기</h3>
		<form name="modify" method="post" action="/semiProject/JY/FestivalModifyPro.admin?num=${f_num}" enctype="multipart/form-data">
			<table width="640" border="0" cellspacing="0" cellpadding="0"
				align="center">

				<tr height="30">
					<td width="80" align="center">제목</td>
					<td width="280" colspan="3"><input name="f_subject"
						type="text" size="40" value="${article.f_subject }"></td>
					<td width="80" align="center">홈페이지</td>
					<td width="200"><input name="f_url" type="text" value="${article.f_url }"></td>
				</tr>
				<tr height="30">
					<td width="80" align="center">나라</td>
					<td width="100"><input name="f_country" type="text" size="12" value="${article.f_country }">
					<td width="80" align="center">위치</td>
					<td width="100"><input name="f_loc" type="text" size="12" value="${article.f_loc }">
					<td width="80" align="center">기간</td>
					<td width="200"><input name="f_sdate" type="text" size="10" value="${article.f_sdate }">~<input
						name="f_edate" type="text" size="10" value="${article.f_edate }"></td>
				</tr>
				<tr height="300">
					<td width="80" align="center">상세내용</td>
					<td colspan="5"><textarea name="f_content" rows="18" cols="80">${article.f_content }</textarea></td>
				</tr>
				<tr height="60">
					<td width="80" align="center">사진첨부</td>
					<td colspan=5 width="580"><table width="100%" id="insertTable">
					<c:forEach var="photo" items="${photoList}">
							<tr>
								<td valign=bottom><a href="${pageContext.request.contextPath}${photo.img }" >${photo.img }</a></td>
								
							</tr>
					</c:forEach>
						</table></td>

				</tr>
				<tr>
				</tr>
				<tr height="30">
					<td colspan=6 align="right">
						<input type="button" value="글목록"
						onclick="document.location.href='/semiProject/JY/FestivalForm.admin'">
						&nbsp;
						&nbsp;
						<input type="button" value="완료"
						onclick="modifysubmit(this.form)">
					</td>
				</tr>

			</table>
		</form>
		</c:if>
	</div>
</body>
</html>