<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="tripreview.TripreviewDBBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function(){
		$("#writeradiotable").change(function(){
			var htag1 =$('input[name="hashTag1"]:checked').val();
			var htag2 =$('input[name="hashTag2"]:checked').val();
			var htag3 =$('input[name="hashTag3"]:checked').val();
			
			if(undefined == htag1){
				var htag1 ="";}
			if(undefined == htag2){
				var htag2 ="";}
			if(undefined == htag3){
				var htag3 ="";}
			
			
			$('input[name="t_htag"]').val(htag1+htag2+htag3);
		})
	})
	
  function sendHashtag(){
	opener.document.write.t_htag.value=document.getElementById("t_htag").value;
	self.close();
		}
	
</script>
<html>
<head>
<title>해시태그 설정</title>
</head>
<body>
<h2>해시태그 설정</h2>
<hr>
<form>
<table class="writeradiotable" id="writeradiotable">
			<tr>
				<td>
					<c:forEach var="country" items = "${countryList}">
						<input type="radio" name="hashTag1" value="${country.h_name} ">${country.h_name} <br>
					</c:forEach>
				</td>
				<td>
					<c:forEach var="season" items = "${seasonList}">
						<input type="radio" name="hashTag2" value="${season.h_name} ">${season.h_name} <br>
					</c:forEach>
				</td>
				<td>
					<c:forEach var="thema" items = "${themaList}">
						<input type="radio" name="hashTag3" value="${thema.h_name} ">${thema.h_name} <br>
					</c:forEach>
				</td>
			</tr>
		</table>
		
		<input type="text" id="t_htag" name="t_htag" readonly><br>
		<button onclick="sendHashtag()">완료</button>
</form>
</body>
</html>