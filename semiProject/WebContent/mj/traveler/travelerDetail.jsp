<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<html>
<head>
<title>같이...여행갈래요?</title>
<script>
	function UserIdentification() {

		url = "/semiProject/mj/UserIdentificationFormAction.do?tr_num=${tr_num}";

		window
				.open(
						url,
						"post",
						"toolbar=no ,width=500 ,height=500,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	function blacklistArticle() {
		url = "/semiProject/mj/blacklistArticle.do?board_id=3&re_num=${tr_num}&bl_subject=${article.tr_subject}&writer=${article.tr_writer}";
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	function blacklistComment(a, b) {
		url = "/semiProject/mj/blacklistComment.do?board_id=3&re_num=${tr_num}&re_comment="
				+ a + "&bl_subject=${article.tr_subject}&writer=" + b;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	function change1(a) {
		var id1 = a;
		var id2 = "edit" + a;
		var aa = document.getElementById(id1);
		var bb = document.getElementById(id2);

		aa.style.display = "none";
		bb.style.display = "block";
	}

	function change2(a) {
		var id1 = a;
		var id2 = "edit" + a;
		var aa = document.getElementById(id1);
		var bb = document.getElementById(id2);

		aa.style.display = "block";
		bb.style.display = "none";
	}
</script>
<style>
</style>
<tiles:insertDefinition name="mainheader" />
</head>
<body>
<div>
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>직구할까?</p>
				<h2>여행자페이지 상세보기</h2>
			</header>
		</div>
	</section>
</div>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center"></header>
					<div  align=center>
					<!-- 	<table> -->
					<table>
					<tr>
					<td>
					<div>
							<div style="width:50%; height:50%; align:left; float:left;">
								<img src="${pageContext.request.contextPath}/imgSave/${photo.img}" width="300px" height="400px" />
							</div>
							<div style="width:50%; align:left; float:left;">
							${article.begin_country} -> ${article.arrived_country}
							</div>
							<div style="width:50%; align:left; float:left;">
							${article.begin_day } ~ ${article.arrived_day }
							</div>
							<div style="width:50%; align:left; float:left;">
								한도금액 : ${article.limit_money } 원
							</div>
							<div style="width:50%; align:left; float:left;">
								내용 : ${article.tr_content }
							</div>
					</div>
					</td></tr>
					<tr>
					<td>
					<div>
						<div style="width:50%; height:10%; align:left; float:left;">
							${article.tr_writer}&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${!empty sessionScope.id}">
								<a href="javascript:blacklistArticle()" class="button special small">신고</a>
							</c:if>			
							조회수 : ${article.tr_readcount }&nbsp;&nbsp;&nbsp;&nbsp;등록일 : ${article.tr_reg_date }
						</div>
					
						<div style="width:50%; height:10%; align:right; float:left;">
									<c:if test="${empty sessionScope.id && sessionScope.id eq article.tr_writer}">
										<input type=button value="거래신청" onclick="UserIdentification()" class="button special small" disable>
									</c:if>
									<c:if test="${!empty sessionScope.id && sessionScope.id ne article.tr_writer}">
										<input type=button value="거래신청" onclick="UserIdentification()" class="button special small">
									</c:if>
					
						</div>
						<hr>
						<div>
						
							<div style="align:right; width:16.6%; float:right;">
							<hr />
								<c:if test="${sessionScope.id eq article.tr_writer}">
										<!-- ******************************************************************************  -->
										<!-- ******************************************************************************  -->
										<!-- ******************************************************************************  -->
									<input type="button" value="글수정" onclick="location.href='/semiProject/NA/traveler/writeForm.do?'">
								</c:if>
							</div>
							<div style="align:right; width:16.6%; float:right;">
								<input type="button" value="목록" onclick="location.href='/semiProject/NA/traveler/list.do'">
							</div>
							<div style="align:right; width:16.6%; float:right;">
								<input type="button" value="NEXT >>" onclick="location.href='/semiProject/mj/travelerDetail.do?tr_num=${tr_num+1}&pageNum=${pageNum }'">
							</div>		
						</div>
					</div>
					</td>
					</tr>	
					<tr>
					<td>
					댓글
					<div>
						<div>
							<c:if test="${!empty sessionScope.id}">
								<form method=post action="/semiProject/mj/travelerComment.do">
									<input type=hidden name=tr_num value="${tr_num}"> 
									<input type=hidden name=pageNum value="${pageNum }">
									<div class="row uniform">
										<div class="10u 12u$(small)">
											<input type="text" name="trc_comment" class="form-control" />
												</div>
										<div class="2u$ 12u$(small)">
											<input class="button special fit small" type="submit" value="등록" />
										</div>
									</div>
								</form>
							</c:if>
						</div>
						<div>
							<c:forEach var="comment" items="${comment}">
								<div id="${comment.trc_num}">
								<ul class="actions small">
									<li><c:out value="${comment.trc_writer}" /></li>
									<li><c:out value="${comment.trc_comment}" /></li>
									<li><c:out value="${comment.trc_reg_date}" /></li>
									<c:if test="${sessionScope.id eq comment.trc_writer}">
										<li><a href="javascript:change1('${comment.trc_num}')"  class="button small">수정</a></li>
										<li><a href="/mj/TravelerCommentDelete.do?trc_num=${comment.trc_num}"  class="button small">삭제</a></li>
									</c:if>
									<c:if test="${!empty sessionScope.id}">
										<li><a href="javascript:blacklistComment('${comment.trc_num}','${comment.trc_writer}')" class="button special small">신고</a></li>
									</c:if>
								</ul>
								</div>
								
								
								<div id="edit${comment.trc_num}" style="display: none">
									<div>
										<ul class="actions small">
											<form method=post	action="/semiProject/mj/travelerCommentedit.do">
												<input type="hidden" name="trc_num" value="${comment.trc_num}">
												<input type="hidden" name="pageNum" value="${pageNum}">
												<input type="hidden" name="tr_num" value="${tr_num}">
												<div class="row uniform">
													<div class="2u 12u$(small)">
													<input type="text" name="trc_writer"	value="${comment.trc_writer}" readOnly> 
													</div>
													<div class="7u 12u$(small)">
													<input type=text name="trc_comment_edit" value="${comment.trc_comment}">
													</div>
													<div class="2u 12u$(small)">
														<input type="submit" value="수정완료" class="button special">
													</div>
											</form>        
												<div class="1u 12u$(small)">
													<input type="button" value="취소" class="button alt" onclick="change2('${comment.trc_num}')"> <br>
												</div>
										</ul>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					</td>
					</tr>
					</table>
				</div>
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