<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1 }">
<c:set var="id" value="${id }" scope="session"/>
<meta http-equiv="Refresh" content="0;url=/semiProject/km/findpwdForm1.do"/>
</c:if>
<c:if test="${check==0 }">
<script>
alert("아이디가 없습니다");
history.go(-1);
</script>
</c:if><!--아이디값을 받아서 db에서 0과 1의 값을 주는 명령어생성.  -->
