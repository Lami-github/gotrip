<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function writeSave(){


	if(document.write.tr_subject.value==""){
	  alert("제목을 입력하십시요.");
	  document.write.tr_subject.focus();
	  return false;
	}
	if(document.write.begin_country.value==""){
		  alert("출발나라를 입력하십시요.");
		  document.write.begin_country.focus();
		  return false;
		}
	
	if(document.write.arrived_country.value==""){
		  alert("도착나라를 입력하십시요.");
		  document.write.arrived_country.focus();
		  return false;
		}
	if(document.write.begin_day.value==""){
		  alert("출발날짜를 입력하십시요.");
		  document.write.begin_day.focus();
		  return false;
		}
	if(document.write.arrived_day.value==""){
		  alert("도착날짜를 입력하십시요.");
		  document.write.arrived_day.focus();
		  return false;
		}
	if(document.write.limit_money.value==""){
		  alert("한도금액을 입력하십시요.");
		  document.write.limit_money.focus();
		  return false;
		}
	if(document.write.tr_content.value==""){
		  alert("내용을 입력하십시요.");
		  document.write.tr_content.focus();
		  return false;
		}
	if(document.write.filename1.value==""){
		  alert("사진을 첨부하십시요.");
		  return false;
		}
	var check = document.write.check.checked;
	if(!check){
		  alert("체크박스를 체크 하십시요.");
		  return false;
	}
}   

function fileCheck(obj){
		pathpoint = obj.value.lastIndexOf('.');
		filepoint = obj.value.substring(pathpoint+1,obj.length);
		filetype = filepoint.toLowerCase();
		if(filetype=='jpg'||filetype=='gif'||filetype=='png'||filetype=='jpeg'){
		}else{
			alert('이미지 파일만 선택할 수 있습니다.');	
			obj.value="";
			return false;
		}
		
	}
	
</script>
<title>여행자 페이지 글쓰기</title>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
	<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>직구할까?</p>
					<h2>여행자 글쓰기</h2>
				</header>
			</div>
		</section>
	</div>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
					<form action="travelerBoardWrite.do" name="write" method="post" enctype="multipart/form-data">
						
						제목 <input type="text" name="tr_subject" id="tr_subject"><br>
						<div class="row uniform">
						<div class="6u 12u$(xsmall)">
						출발나라 <input type="text" name="begin_country" id="begin_country">
						</div>
						<div class="6u 12u$(xsmall)">
						도착나라 <input type="text" name="arrived_country" id="arrived_country" ><br>
						</div>
						<div class="3u 12u$(xsmall)">
						출발날짜 <input type="date" name="begin_day" id="begin_day" >
						</div>
						<div class="3u 12u$(xsmall)">
 						도착날짜 <input type="date" id="arrived_day" name="arrived_day" > <br>
						</div>
						<div class="3u 12u$(xsmall)" align="right">
						한도금액
						</div>
						<div class="3u 12u$(xsmall)">
						<input type="text" name="limit_money" id="limit_money" placeholder="원">
						</div>
						</div>
						<br>
						<input type="textarea" name="tr_content" id="tr_content" style="width:100%; height:30%;"><br>
						<br>
						<br>
					     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
					        <tr><td rowspan="5">사진선택</td>
					        	<td valign=bottom>
					        		<INPUT type='file' onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png,image/jpg" maxLength='100' name='filename1' size='25' />
					        	</td>
					        </tr>
					    </table><br><br>
					    <div class="12u 12u$(small)" align=right>
					    <input type="checkbox" name="check" id="check"><label for=check>거래 성립시 구매자에게 기본 정보를 제공하는 것에 동의합니다.</label>
					    </div>
					    <input type="hidden" name="id" value="${sessionScope.id}">
					    <div align=right>
					    <input type="button" value="목록으로" onclick="window.location='list.do'">
					    <input type="submit" value="완료" onclick="return writeSave()">
						</div>
					</form>  
				</div>
			</div>
		</div>
	</section>
	
	<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>
</body>
</html>