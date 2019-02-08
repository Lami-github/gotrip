<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function writeSave(){


	if(document.write.b_subject.value==""){
	  alert("제목을 입력하십시요.");
	  document.write.b_subject.focus();
	  return false;
	}
	if(document.write.b_country.value==""){
		  alert("나라를 입력하십시요.");
		  document.write.b_country.focus();
		  return false;
		}
	
	if(document.write.b_item.value==""){
		  alert("상품명을 입력하십시요.");
		  document.write.b_item.focus();
		  return false;
		}
	if(document.write.b_count.value==""){
		  alert("개수을 입력하십시요.");
		  document.write.b_count.focus();
		  return false;
		}
	if(document.write.b_price.value==""){
		  alert("총금액을 입력하십시요.");
		  document.write.b_price.focus();
		  return false;
		}
	if(document.write.b_content.value==""){
		  alert("내용을 입력하십시요.");
		  document.write.b_content.focus();
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
 	//첨부파일 추가
    var rowIndex = 1;
               
    function addFile(form){
        if(rowIndex > 4) return false;

        rowIndex++;
        var getTable = document.getElementById("insertTable");
	var oCurrentRow = getTable.insertRow(getTable.rows.length);
        var oCurrentCell = oCurrentRow.insertCell(0);
        oCurrentCell.innerHTML = "<tr><td colspan=2><INPUT TYPE='FILE' onchange='fileCheck(this)' NAME='filename" + rowIndex + "' accept='image/gif,image/jpeg,image/png,image/jpg' size=25></td></tr>";
    }
   
	//첨부파일 삭제
    function deleteFile(form){
        if(rowIndex<2){
            return false;
        }else{
        	rowIndex--;
			var getTable = document.getElementById("insertTable");
			getTable.deleteRow(rowIndex);
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
<title>구매자페이지 글쓰기</title>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>직구할까?</p>
					<h2>구매자 글쓰기</h2>
				</header>
			</div>
		</section>
	</div>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
						<form action="/semiProject/NA/buyer/buyerBoardWrite.do" name="write" method="post" enctype="multipart/form-data">
							제목 <input type="text" name="b_subject" id="b_subject"> 
							<div class="row uniform">
								<div class="2u 12u$(xsmall)">
									나라명 
								</div>
								<div class="4u 12u$(xsmall)">
									<input type="text" name="b_country" id="b_country">
								</div>
								<div class="2u 12u$(xsmall)">
									상품명
								</div> 
								<div class="4u 12u$(xsmall)">
									<input type="text" name="b_item" id="b_item"> 
								</div>
							</div>
							<div class="row uniform">
								<div class="4u 12u$(xsmall)">	
									개수 <input type="number" id="b_count" name="b_count" min="1" max="10000" style="width:150px">
								</div>
								<div class="4u 12u$(xsmall)">
									총금액 <input type="number" name="b_price" id="b_price" min="1000" max="100000000" style="width:150px"> 원 <br>
								</div>
							</div>
							<br>	
							<textarea name="b_content" id="b_content" style="width:70%; height:30%;"></textarea><br>
							<br>
							<br>
						     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
						        <tr><td rowspan="5">사진선택</td>
						        	<td valign=bottom>
						        		<INPUT type='file' onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png,image/jpg" maxLength='100' name='filename1' size='25' />
						        	</td>
						        	<td width=100>
						        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
						        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
						        	</td>
						        </tr>
						    </table><br>
						    
						    <div class="12u 12u$(small)" align=right>
						  	 	 <input type="checkbox" name="check" id="check"><label for=check>거래 성립시 여행자에게 기본 정보를 제공하는 것에 동의합니다.</label>
						    </div>
						    <input type="hidden" name="id" value="${sessionScope.id}">
						    <br>
						    <div align=right>
							    <input type="button" value="목록으로" onclick="window.location='list.do'">
						 	   <input type="submit" value="글쓰기" onclick="return writeSave()">
							</div>
						</form>    

				</div>
			</div>
		</div>
	</section>			

<%-- 
<form action="/semiProject/NA/buyer/buyerBoardWrite.do" name="write" method="post" enctype="multipart/form-data">
	제목 <input type="text" name="b_subject" id="b_subject"> 나라명 <input type="text" name="b_country" id="b_country"><br>
	상품명 <input type="text" name="b_item" id="b_item"> 개수 <input type="number" id="b_count" name="b_count" min="1" max="10000" style="width:150px">
	총금액 <input type="number" name="b_price" id="b_price" min="1" max="100000000" style="width:150px"> 원 <br>
	<textarea name="b_content" id="b_content" style="width:70%; height:30%;"></textarea><br>
	<br>
	<br>
     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
        <tr><td rowspan="5">사진선택</td>
        	<td valign=bottom>
        		<INPUT type='file' onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png,image/jpg" maxLength='100' name='filename1' size='25' />
        	</td>
        	<td width=100>
        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
        	</td>
        </tr>
    </table><br>
    
    
    <input type="hidden" name="id" value="${sessionScope.id}">
    <br>
    <input type="button" value="목록으로" onclick="window.location='list.do'">
    <input type="submit" value="글쓰기" onclick="return writeSave()">
</form>     --%>

<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>

</body>
</html>