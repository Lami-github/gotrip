<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
 	
	

function hashtag(){
	url = "/semiProject/NA/tripreView/tripreViewWriteHashTag.do";

	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");

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
<title>여행후기 글 수정하기</title>
<tiles:insertDefinition name="mainheader" />
</head>
<body>

<div>
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>여행꿀팁</p>
					<h2>글 수정하기</h2>
				</header>
			</div>
		</section>
	</div>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
						<form action="/semiProject/NA/tripreView/updateFormPro.do" name="write" method="post">
							제목 <input type="text" name="t_subject" id="t_subject" value="${t_subject}"><br>
							<textarea name="t_content" rows="18" cols="80" value="${t_content}">${t_content}</textarea><br>
							<div class="row uniform">
								<div class="8u 12u$(xsmall)">
									<input type="text" name="t_htag" id="t_htag" value="${t_htag}" readonly>
								</div>
								<div class="2u 12u$(xsmall)">
									<input type="button" value="해시태그" onclick="hashtag()" >
								</div>
								<div class="2u 12u$(xsmall)" align=center>
									<input id="reset" type="button" name="reset" value = "Reset">
									<input type="hidden" name="t_num" id="t_num" value="${t_num}">
								</div>
							</div>	
							<br>
							<br>
							<div>
							<div style="float:left">사진파일</div>
							<div>
								<c:forEach var="photo" items="${photo}">
											<c:if test="${photo ne null}">
												<tr><td><c:out value="${photo}" /><br>
									</c:if>
								</c:forEach>
							</div>
							</div>
						   
						    <br><br><br>
						    <div align=right>
							    <input type="button" value="목록으로" onclick="window.location='tripreViewList.do?t_num=${t_num}'">
							    <input type="submit" value="수정하기" onclick="return writeSave()">
						    </div>
						</form>    

				</div>
			</div>
		</div>
	</section>		
</body>
</html>