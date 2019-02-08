<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>구매정보</title>
<script>
function chat(tr_num){
	
	var popup = document.chatting;
	var url = "/semiProject/mj/chatContent.do";
	window.open("","popupopen", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,height=270");

	popup.action = url;
	popup.target="popupopen";
	popup.method="post";
	popup.trade_num.value=tr_num;
	popup.submit();
}

</script>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
<div>
	<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>마이페이지</p>
					<h2>거래현황 - 구매자</h2>
				</header>
			</div>
	</section>
</div>
	
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
					<h3><strong>구매정보</strong></h3>
					<table>
						<tr>
							<td>물품 이름</td>
							<td colspan=3><input type="text" name="b_item" value="${member.trade_item }" readonly></td></tr>
						<tr>
							<td>구매가격</td>
							<td><input type="text" name="b_price" value="${member.trade_point }" readonly></td>
							<td>개수</td><td><input type="text" name="trade_count" value="${member.trade_count }" readonly></td>
						</tr>
					</table>
					<h3><strong>판매자정보</strong></h3>
					<table>
						<tr>
							<td>판매자이름</td>
							<td>
								<input type="text" name="id" value="${member1.name }" readonly>
							</td>
							<td width=20%>
								<form name="chatting">
									<input type="hidden" name=trade_num>
								</form>
								<input type="button" value="1:1채팅신청" onclick="chat(${trade_num})" style="margin-left: 10px;">
							</td>
						</tr>
						<tr>
							<td>판매자 전화번호</td>
							<td colspan=2><input type="text" name="phonenumber" value="${member1.phonenumber}" readonly></td></tr>
						<tr>
							<td>송장번호</td>
							<td colspan=2><input type="text" name="invoice_num" value="${member.invoice_num }" readonly></td>
						</tr>
					</table>
					<table>
					<tr>
					<td align=center>
						<form method="post" action="/semiProject/km/buyerSubmit.do">
							<input type="submit" value="물품 인수확인">
							<input type="hidden" name="trade_num" value="${trade_num }">
						</form>
					</td>
					</tr>	
					</table>
				</div>
			</div>
		</div>
	</section>	
<div>
<tiles:insertDefinition name="mainfooter" />
</div>

<!-- Scripts -->

	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>