<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1 }">
<script>
alert("회원탈퇴 되었습니다");
</script>
<c:remove var="id" scope="session"/>
<meta http-equiv="Refresh" content="0;url=/semiProject/main/index.do"/>
</c:if>
<c:if test="${check==0 }">
<script>
alert("비밀번호가 틑립니다! 본인이 맞으신가요?")
history.go(-1);
</script>
</c:if>
