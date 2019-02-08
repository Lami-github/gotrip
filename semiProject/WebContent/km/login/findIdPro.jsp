<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${dbid=='' }">
<script>
alert("아이디나 이메일이 잘못되었습니다.");
history.go(-1);
</script>
</c:if>
<c:if test="${dbid!=''}">


<html>
<head>
<script type='text/javascript'>
     opener=self;
     setTimeout('self.close()',3000);
     
 function javascript(){
    	 self.close();   //자기자신창을 닫습니다.
    	}
</script>
<title>아이디찾기</title>
</head>
<body style="text-align:center; margin-top:200px;">
<h3>요청하신 아이디는 이메일로 발송되었습니다.
잠시후 창이 종료됩니다.</h3>
<input type='button' onclick='javascript()' value='닫기' style="text-align:center;"/>


</body>
</html>
</c:if>