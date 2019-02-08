<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check1==-1 }">
<script>
alert("거래신청을 실패하였습니다. 관리자에게 문의하세요.");
history.go(-1);
</script>
</c:if>
<c:if test="${check1==1 }">
<script>
alert("거래신청이 완료되었습니다.");
opener.location.reload();
window.close();
</script>
</c:if>