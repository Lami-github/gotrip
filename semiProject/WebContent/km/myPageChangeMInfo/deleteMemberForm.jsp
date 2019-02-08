<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>회원탈퇴</title>
<style>
.texttext {
	text-align: center;
}
section#two{
	background-color:white;
}
</style>
<script type="text/javascript">
	function checkBox() {
		var chk1 = document.getElementById("checkbox").checked;

		if (!chk1) {
			alert("탈퇴 안하실꺼죠?");
			return false;
		}
	}
</script>



<tiles:insertDefinition name="mainheader" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
</head>
<body>
	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<a href="/semiProject/km/myPagePoint.do"><p>마이페이지</p></a> <a
					href="/semiProject/km/deleteMemberForm.do"><h2>회원탈퇴</h2></a>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="content">
				<div align=center>
					<div style="width: 30%;">
						<h3>비밀번호입력</h3>
						<h4 class="texttext">회원님의 개인정보 보호를 위해 비밀번호를 다시한번 입력해 주시기
							바랍니다.</h4>
						<form name="userinput" class="texttext" method="post"
							action="/semiProject/km/deleteMemberPro.do"
							onSubmit="return checkBox()">

							<input type="password" name="password" required autofocus><br />
							<div class="6u 12u$(small)" style="width: 100%">
								<input type="checkbox" id="checkbox" name="checkbox"> <label
									for="checkbox">정말 탈퇴하시려면 체크박스를 체크후 회원탈퇴를 클릭해주세요. </label>
							</div>

							<br> <input type="hidden" value="${sessionScope.id}"
								name="id">
							<ul class="actions small">
								<li><input class="button special fit small" type="submit"
									value="회원탈퇴"></li>
							</ul>

						</form>
					</div>
				</div>
			</div>
		</div>

	</section>

	<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>


	<!-- Scripts -->

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>

</body>
</html>
