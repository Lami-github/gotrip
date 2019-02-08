<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check!=1 }">
<script>
alert("비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>
<c:if test="${check==1 }">
<meta http-equiv="Refresh" content="0;url=/semiProject/mj/dealRequest.do?tr_num=${tr_num}"/>
</c:if>