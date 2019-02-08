<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>로그인</title>
<script>
	function checkId() {
		if (!document.forrm.id.value) {
			alert("이름을 입력하지 않으셨습니다.");
			document.form.id.focus();
			return false;
		}
		if (!document.forrm.password.value) {
			alert("비밀번호를 입력하지 않으셨습니다.");
			document.form.password.focus();
			return false;
		}
	}
	function findId() {

		url = "/semiProject/km/findIdForm.do";

		window
				.open(
						url,
						"post",
						"toolbar=no,location=yes,status=yes,menubar=no,scrollbars=no,resizable=no,width=600,height=600,directories=no");
	}
	function findPwd() {
		url = "/semiProject/km/findpwdForm0.do";

		window
				.open(
						url,
						"post",
						"toolbar=no,location=yes,status=yes,menubar=no,scrollbars=no,resizable=no,width=600,height=600,directories=no");

	}
</script>



</head>
<body>
	<tiles:insertDefinition name="mainheader" />
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center"> 
				
			</header>
		</div>
	</section>

	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<form class="form-signin" name="forrm"
						action="/semiProject/km/loginPro.do" method="post"
						onsubmit="return checkId()"
						style="width: 35%; margin: auto; text-align: center;">
						<fieldset class="">
							<h2 class="form-signin-heading">로그인</h2>
							<input type="text" name="id" id="id" placeholder="아이디를 입력하세요"
								class="form-control"><br /> <input type="password"
								name="password" id="password" placeholder="비밀번호를 입력하세요"
								class="form-control"><br /> <input type="submit"
								value="로그인" class="btn btn-lg btn-primary btn-block"
								style="margin-bottom: 5px;">
						</fieldset>

						<input type="button" class="loginform-btn" value="아이디찾기"
							name="confirm" OnClick="findId(this.form)"
							style="border: 0;  background-color: fff; color:black !important;"> <input
							type="button" class="loginform-btn" value="비밀번호찾기"
							onclick="findPwd(this.form)"
							style="border: 0; background-color: fff;color:black !important;"> <input
							type="button" class="loginform-btn" value="회원가입"
							onclick="document.location.href='/semiProject/km/inputForm.do'"
						style="border: 0; background-color: fff;color:black !important;">
					</form>
				</div>
			</div>
		</div>
	</section>
	<div style="text-align: center;">
		<tiles:insertDefinition name="mainfooter" />
	</div>
	
	<!-- Scripts -->

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/js/slide.js"></script>
</body>
</html>