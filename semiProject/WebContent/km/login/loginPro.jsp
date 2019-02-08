<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1 }">
<c:set var="id" value="${id}" scope="session"/>
<meta http-equiv="Refresh" content="0;url=/semiProject/main/index.do"/>
</c:if>
<c:if test="${check==0 }">
<script>
alert("아이디 혹은 비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>
<c:if test="${check== -1 }">
<script>
alert("당신은 블랙리스트입니다. 신고내역이 궁금하면 사이트 하단에 표시된 전화번호로 전화주시기 바랍니다.");
history.go(-1);
</script>
</c:if>