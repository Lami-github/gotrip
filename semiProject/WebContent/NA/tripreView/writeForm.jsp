<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function writeSave(){


	if(document.write.t_subject.value==""){
	  alert("제목을 입력하십시요.");
	  document.write.t_subject.focus();
	  return false;
	}

	if(document.write.t_content.value==""){
	  alert("내용을 입력하십시요.");
	  document.write.t_content.focus();
	  return false;
	}
	       
	if(document.write.t_htag.value==""){
	  alert("해시태그를 입력하십시요.");
	  document.write.t_htag.focus();
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
	
	function hashtag(){
		url = "/semiProject/NA/tripreView/tripreViewWriteHashTag.do";

		window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");

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
	$(document).ready(function(){
	    //reset 을 클릭했을때의 함수
	    $("#reset").click(function () {
	        $( "#t_htag" ).each( function () {
	        	$('input[name="t_htag"]').val("");
	        }); 
	    });
	});

</script>
<title>여행후기 글쓰기</title>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>직구할까?</p>
					<h2>여행후기 글쓰기</h2>
				</header>
			</div>
		</section>
	</div>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
					<form action="/semiProject/NA/tripreView/tripreViewWrite.do" name="write" method="post" enctype="multipart/form-data">
						제목 <input type="text" name="t_subject" id="t_subject"><br>
						<textarea name="t_content" rows="18" cols="80"></textarea><br>
						
						<div class="row uniform">
							<div class="8u 12u$(xsmall)">
								<input type="text" name="t_htag" id="t_htag" readonly>
							</div>
							<div class="2u 12u$(xsmall)" align=right>
								<input type="button" value="해시태그" onclick="hashtag()">
							</div>
							<div class="2u 12u$(xsmall)" align=center>
								<input id="reset" type="button" name="reset" value = "Reset">
							</div>
						</div>		
						<br>
						<br>
					     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
					        <tr><td rowspan="5">사진첨부</td>
					        	<td valign=bottom>
					        		<INPUT type='file' onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png,image/jpg" maxLength='100' name='filename1' size='25' />
					        	</td>
					        	<td style="align:right;">
					        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
					        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
					        	</td>
					        </tr>
					    </table>
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

<h2>여행후기 글쓰기</h2>
	<hr>
	<br>
<form action="/semiProject/NA/tripreView/tripreViewWrite.do" name="write" method="post" enctype="multipart/form-data">
	제목 <input type="text" name="t_subject" id="t_subject"><br>
	<textarea name="t_content" rows="18" cols="80"></textarea><br>
	
	<input type="text" name="t_htag" id="t_htag" readonly><input type="button" value="해시태그" onclick="hashtag()"><input id="reset" type="button" name="reset" value = "Reset">
	<br>
	<br>


     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
        <tr><td rowspan="5">사진첨부</td>
        	<td valign=bottom>
        		<INPUT type='file' onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png,image/jpg" maxLength='100' name='filename1' size='25' />
        	</td>
        	<td width=100>
        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
        	</td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${sessionScope.id}">
    <br>
    <input type="button" value="목록으로" onclick="window.location='tripreViewList.do'">
    <input type="submit" value="글쓰기" onclick="return writeSave()">
</form>     --%>
</body>
</html>