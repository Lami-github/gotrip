<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==-1 }">
<script>
alert("보유 포인트가 부족합니다. 포인트를 충전해주세요");
history.go(-1);
</script>
</c:if>
<c:if test="${check==1 }">
<meta http-equiv="Refresh" content="0;url=/semiProject/NA/buyer/list.do">
</c:if>