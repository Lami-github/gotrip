<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>우편번호검색</title>
<script language="javascript">
	function dongCheck() {
		if (document.zipForm.area4.value == "") {
			alert("동이름을 입력하세요");
			document.zipForm.area4.focus();
			return;
		}
		document.zipForm.submit();
	}

	function sendAddress(zipcode, area1, area2, area3, area4) {
		var address = area1 + " " + area2 + " " + area3 + " " + area4;
		
		opener.document.userinput.zipcode.value = zipcode;
		opener.document.userinput.address.value = address;
		self.close();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
	<b>우편번호 찾기</b>
	<table>
		<form name="zipForm" method="post" action="/semiProject/km/ZipCheck.do">
			<tr>
				<td><br> 도로명 주소 입력 : <input name="area4" type="text">
					<input type="button" value="검색" onclick="dongCheck();"></td>
			</tr>
			<input type="hidden" name="check" value="n">
		</form>
		<c:if test="${check.equals('n')}">
		<c:choose>
			<c:when test="${zipcodeList==null}">
				<tr>
					<td align="center"><br>검색된 결과가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center"><br> ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
				</tr>
					<c:forEach var="zipBean" items="${zipcodeList}">
						<tr><td><a	href="javascript:sendAddress('<c:out value="${zipBean.zipcode}"/>','<c:out value="${zipBean.area1}"/>','<c:out value="${zipBean.area2}"/>','<c:out value="${zipBean.area3}"/>','<c:out value="${zipBean.area4}"/>')">
							<c:out value="${zipBean.zipcode}"/>&nbsp;<c:out value="${zipBean.area1}"/>&nbsp;<c:out value="${zipBean.area2}"/>&nbsp;<c:out value="${zipBean.area3}"/>&nbsp;<c:out value="${zipBean.area4}"/></a><br>
					</td></tr>
					</c:forEach>
			</c:otherwise>	
			</c:choose>
		</c:if>
		<tr>
			<td align="center"><br> <a href="javascript:this.close();">닫기</a></td>
		<tr>
	</table>
</body>
</html>