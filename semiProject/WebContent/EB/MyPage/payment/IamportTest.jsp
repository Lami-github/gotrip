<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
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
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>    

	
	
	
var IMP = window.IMP;
IMP.init('imp10827131');
IMP.request_pay({
    pg : 'inicis',
    pay_method : 'card', 
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '${p_name}',
    amount : '${pay_price}',
    buyer_email : '${email}',
    buyer_name :  '${name}',
    buyer_tel : '${phone}',
    m_redirect_url : 'InsertSuccess.jsp'
    
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
        alert(msg);
        
        setTimeout(location.href="/semiProject/MyPage/payment/InsertImp_uid.do?imp_uid="+rsp.imp_uid+"&pay_no="+${pay_no}, 0);
        
    } else {
    	  
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg; 
        setTimeout(location.href="/semiProject/MyPage/payment/InsertImp_uid.do?imp_uid="+rsp.imp_uid+"&pay_no="+${pay_no}, 0);
    }
});
</script>
<div>
		<tiles:insertDefinition name="mainfooter" />
	</div>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
	
</body>
</html>
