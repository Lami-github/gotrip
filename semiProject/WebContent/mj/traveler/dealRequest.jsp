<%@ page contentType="text/html; charset=UTF-8"%>
         <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/util.js"></script>
         <script src="<%=request.getContextPath() %>/js/main.js"></script>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
<title>거래신청 폼</title>
<script>
	function checkIt(){
		var checkbox = document.trade.agreement.checked;
		
		if(document.trade.trade_item.value==""){
			alert("상품명을 입력해주세요");
			return false;
		}
		if(document.trade.trade_count.value==""){
			alert("개수를 입력해주세요");
			return false;
		}
		if(document.trade.trade_point.value==""){
			alert("금액을 입력해주세요");
			return false;
		}
		
		if(!checkbox){
			alert("정보 제공 동의를 체크해주세요");
			return false;
		}
		
		return true;
	}

</script>
</head>
<body>
<div>
<form method=post name=trade action="/semiProject/mj/TradeAction.do" onsubmit="return checkIt()">
<table>
<tr><td colspan=2> 거래신청 </td></tr>
<tr>
<td>
여행자 id :
</td>
<td> ${traveler} <input type="hidden" id=traveler name=traveler value="${traveler }">
				<input type=hidden id=tr_num name=tr_num value="${tr_num }">
</td>
</tr>
<tr>
<td>
상품명 : 
</td>
<td>
	<input type="text" id=trade_item name=trade_item maxlength=50>
</td>
</tr>
<tr>
<td>
개수 : 
</td>
<td>
<input type=number id=trade_count name=trade_count min=1 max=50 step=1>
</td>
</tr>
<tr>
<td>
금액 : 
</td>
<td><input type="text" id=trade_point name=trade_point >
</td>
</tr>
<tr>
<td colspan=2>
<input type="checkbox" id="agreement" name="agreement" value="agreement"><label for="agreement">여행자에게 기본 정보를 제공하는 것을 동의합니다.<br>기본정보 : 이름, 주소, 전화번호</label>
</td>
</tr>
<tr>
<td colspan=2 align=right>
<input type=submit value="거래신청"  class="button special">
</td>
</tr>
</table>
</form>
</div>
</body>
</html>