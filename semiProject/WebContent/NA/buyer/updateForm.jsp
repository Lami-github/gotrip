<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	
}   
 	
	
</script>
<title>구매자페이지 정보수정</title>
</head>
<body>
<h2>구매자페이지 정보수정</h2>
	<hr>
	<br>
<form action="/semiProject/NA/buyer/updateFormPro.do" name="write" method="post">
	제목 <input type="text" name="b_subject" id="b_subject" value="${buyerBoard.b_subject}"> 나라명 <input type="text" name="b_country" id="b_country" value="${buyerBoard.b_country}"><br>
	상품명 <input type="text" name="b_item" id="b_item" value="${buyerBoard.b_item}"> 개수 <input type="number" id="b_count" name="b_count" value="${buyerBoard.b_count}" min="1" max="10000" style="width:150px">
	총금액 <input type="number" name="b_price" id="b_price" value="${buyerBoard.b_price}" min="1000" max="100000000" style="width:150px">원 <br>
	<textarea name="b_content" rows="18" cols="80" value="${buyerBoard.b_content}">${buyerBoard.b_content}</textarea><br>
	<br>
	<br>
     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
        <tr><td>사진선택</td><td>${buyerBoard.firstImagePath}</td>
        </tr>
    </table><br>
    
    <input type="hidden" name="b_num" id="b_num" value="${b_num}">
    <br>
    <input type="button" value="목록으로" onclick="window.location='list.do?b_num=${b_num}'">
    <input type="submit" value="글쓰기" onclick="return writeSave()">
</form> 
   
</body>
</html>