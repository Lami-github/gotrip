<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
<link href="/semiProject_eunB/WebContent/main" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/css/main.css" />
					<script src="/jquery.min.js"></script>
			<script src="/js/jquery.scrollex.min.js"></script>
			<script src="/js/skel.min.js"></script>
			<script src="/js/util.js"></script>


</head>
<body>
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>마이페이지</p>
				<h2>결제하기</h2>
			</header>
		</div>
	</section>
<!-- 결제 폼 시작 -->
<form name="Request_Insert" action="/semiProject/Mypage/payment/Insert.do" method="post">
<!-- pay_list테이블에 값을 저장하는 Insert.do -->
<table border="1" cellpadding="0" cellspacing="1">
	<tr height="40">
		<td><label for="total_price" class="col-md-4 col-xs-4">&nbsp;&nbsp;결제이름</label></td>
		<td><input type="text" name="p_name" id="p_name" value="포인트" class="col-md-8 col-xs-8" readonly/></td>
	</tr>
	<tr height="40">
		<td><label for="pg">&nbsp;&nbsp;지원 PG사</label></td>
		<td align="center">
			<select name="pg" id="pg">
				<option value="kakao">카카오페이</option>
				<option value="html5_inicis" selected>KG이니시스(웹표준결제)</option>
				<option value="inicis">KG이니시스(기존모듈)</option>
				<option value="uplus">LG유플러스</option>
				<option value="nice">나이스정보통신</option>
				<option value="jtnet">JTNet</option>
				<option value="danal">다날-휴대폰소액결제전용</option>
				<option value="paypal">페이팔-ExpressCheckout</option>
            </select>
		</td>
	</tr>
	<tr height="40">
		<td width="200"><label for="pay_method">&nbsp;&nbsp;결제수단</label></td>
		<td align="center"><select name="pay_method" id="pay_method" class="col-md-8 col-xs-8">
		<option value="card">신용카드</option></select>
		</td>
	</tr>
	<tr height="40">
		<td><label for="pay_price" class="col-md-4 col-xs-4">&nbsp;&nbsp;금액</label></td>
		<td><input type="text" name="pay_price" id="pay_price"  class="col-md-8 col-xs-8" /></td>
	</tr>
	<tr height="40">
		<td><label for="email" class="col-md-4 col-xs-4">&nbsp;&nbsp;이메일주소</label></td>
		<td><input type="text" name="email" value="${member.email }"  class="col-md-8 col-xs-8"/></td>
	</tr>
	<tr height="40">
		<td><label for="name" class="col-md-4 col-xs-4">&nbsp;&nbsp;성함</label></td>
		<td><input type="text" name="name" value="${member.name }"  class="col-md-8 col-xs-8"/></td>
	</tr>
	<tr height="40">
		<td><label for="phone" class="col-md-4 col-xs-4">&nbsp;&nbsp;전화번호</label></td>
		<td><input type="tel" name="phone" value="${member.phonenumber }"  class="col-md-8 col-xs-8"/></td>
	<tr height="40">
		<td><label for="address" class="col-md-4 col-xs-4">&nbsp;&nbsp;주소</label></td>
		<td><input type="text" name="address" value="${member.address }"  class="col-md-8 col-xs-8"/></td>
	</tr>
	<tr height="40">
		<td><label for="zipcode" class="col-md-4 col-xs-4">&nbsp;&nbsp;우편번호</label></td>
		<td><input type="text" name="zipcode" value="${member.zipcode }" class="col-md-8 col-xs-8"/></td>
	</tr>
<tr height="40">
		<td colspan="2" align="center"><input type="submit" value="포인트 결제하기" ></td>
	</tr>
</table>
</form>
<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>
<!-- 결제폼 끝 -->
<br>
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>