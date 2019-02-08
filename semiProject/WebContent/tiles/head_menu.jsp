<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
<script src="<%=request.getContextPath()%>/js/util.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<head>
<title>여행가좌 by 멋지고 쿨한 오조.</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css" />

</head>
<body>

	<!-- Header -->
	<header id="header" class="alt">

		<div class="logo">
			<a href="<%=request.getContextPath()%>/main.jsp">tripgajwa <span>by
					CoolEunB</span></a>
		</div>
		<c:if test="${empty sessionScope.id}">
			<a href="/semiProject/km/loginForm.do">logon</a>
		</c:if>
		<c:if test="${!empty sessionScope.id}">
			<a href="/semiProject/km/logout.do">logout</a>
		</c:if>
		<a href="#menu">Menu</a>

	</header>

	<!-- Nav -->
	<nav id="menu">
		<ul class="links">

			<li><a href="#">여행꿀팁</a></li>
			<li class="n">
				<ul class="links">
					<li class="m"><a href="/semiProject/NA/tripreView/list.do">여행후기</a></li>
				</ul>
				<ul class="links">
					<li class="m"><a href="/semiProject/JY/FestivalForm.do">축제정보</a></li>
				</ul>
			</li>

			<li><a href="#">직구할까?</a></li>
			<li class="n">
				<ul class="links">
					<li class="m"><a href="/semiProject/NA/buyer/list.do">구매자페이지</a></li>
				</ul>
				<ul class="links">
					<li class="m"><a href="/semiProject/NA/traveler/list.do">여행자페이지</a></li>
				</ul>
			</li>
			<li><a href="#">고객센터</a></li>
			<li class="n">
				<ul class="links">
					<li class="m"><a href="/semiProject/JY/NoticeForm.do">공지사항</a></li>
				</ul>
				<ul class="links">
					<li class="m"><a href="/semiProject/JY/QnaForm.do">QnA</a></li>
				</ul> <c:if test="${!empty sessionScope.id}">
					<ul class="links">
						<li class="m"><a href="/semiProject/JY/PQWriteForm.do">1:1
								문의</a></li>
					</ul>
				</c:if>


			</li>
			<c:if test="${!empty sessionScope.id}">
				<li><a href="/semiProject/km/myPagePoint.do">마이페이지</a></li>
				<li class="n">
					<ul class="links">
						<li class="m"><a href="/semiProject/km/myPagePoint.do">내
								포인트 관리</a></li>
					</ul>
					<ul class="links">
						<li class="m"><a href="/semiProject/mj/myboardMain.do">내가
								쓴글</a></li>
					</ul>
					<ul class="links">
						<li class="m"><a href="/semiProject/mj/question.do">1:1문의내역
								확인</a></li>
					</ul>
					<ul class="links">
						<li class="m"><a href="/semiProject/km/tradeNow.do">거래현황</a></li>
					</ul>
					<ul class="links">
						<li class="m"><a href="/semiProject/km/changeMemberInfoForm.do">회원정보 수정</a>
						</li>
					</ul>
			

					<ul class="links">
						<li class="m"><a href="/semiProject/km/deleteMemberForm.do">회원탈퇴
						</a></li>
					</ul>
			</c:if>

		</ul>
	</nav>