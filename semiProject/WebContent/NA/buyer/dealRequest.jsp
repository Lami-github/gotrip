<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check!=1 }">
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check==1 }">
	<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css" />
<title>거래신청폼</title>
<script>
	function checkIt() {
		var checkbox = document.trade.agreement.checked;
		if (!checkbox) {
			alert("정보 제공 동의를 체크해주세요");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<div>
		<table>
			<form method=post name=trade
				action="/semiProject/mj/TradeActionBuyer.do"
				onsubmit="return checkIt()">
				<tr>
					<td>구매자 id :</td>
					<td>${b_writer}</td>
					<input type="hidden" id=b_writer name=b_writer value="${b_writer }">
				</tr>
				<tr>
					<td>나라명 :</td>
					<td><input type="text" id=trade_country name=trade_country
						value="${trade_country }" readonly></td>
				</tr>
				<tr>
					<td>상품명 :</td>
					<td><input type="text" id=trade_item name=trade_item
						value="${trade_item }" readonly></td>
				</tr>
				<tr>
					<td>개수 :</td>
					<td><input type=text id=trade_count name=trade_count
						value="${trade_count }" readonly></td>
				</tr>
				<tr>
					<td>금액 :</td>
					<td><input type="text" id=trade_point name=trade_point
						value="${trade_point }" readonly></td>
				</tr>
				<tr>
					<td colspan=2><input type="checkbox" id="agreement"
						name="agreement" value="agreement"><label for="agreement">구매자에게
							기본 정보를 제공하는 것을 동의합니다.<br>기본정보 : 이름, 전화번호
					</label></td>
				</tr>
				<tr>
					<td colspan=2 align="right"><input type=submit value="거래신청"
						class="button special"></td>
				</tr>
			</form>
		</table>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
	</html>
</c:if>