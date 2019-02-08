<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>게시판</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootshape.css"
	rel="stylesheet">

<style>
.detaillayout {
	width: 100%;
	height: 60%;
}

.imgdiv {
	width: 60%;
	height: 100%;
	display: inline-block;
	margin-right: 20;
}

.tablediv {
	width: 30%;
	height: 51%;
	display: inline-block;
}

.detaildiv {
	height: 30%;
	width: 100%;
}

.detail {
	height: 90%;
}

.tablediv table {
	width: 100%;
	height: 100%;
}

.tablediv tr {
	width: 100%;
	height: 20%;
}

.tablediv td {
	padding: 10;
}

*{box-sizing:border-box}

/* Slideshow container */
.slideshow-container {
  width: 500px;
  height:520px;
  position: relative;
  margin: auto;
  float: left;
}

/* Hide the images by default */
.mySlides {
    display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}
</style>
</head>

<body bgcolor="${bodyback_c}">
	<!-- Header -->
	<tiles:insertDefinition name="adminheader" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="action"><a href="/semiProject/JY/StateForm.admin"><b>통계관리</b> <span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>회원관리</b></a></li>
					<li class="action" ><a href="/semiProject/JY/MnMForm.admin"> - 회원</a></li>
					<li class="action"><a href="/semiProject/JY/BLForm.admin">
							- 블랙리스트</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action" ><a href="/semiProject/JY/PQForm.admin"><b>문의
								내역 관리</b> <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>결제관리</b></a></li>
					<li class="action" ><a href="/semiProject/JY/PaymentForm.admin">
							- 결제 내역 관리</a></li>
					<li class="action" ><a href="/semiProject/JY/ExForm.admin">
							- 환전 관리</a></li>
					<li class="action" ><a href="/semiProject/JY/AdForm.admin"> - 광고관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action"><a href="/semiProject/JY/BoardForm.admin"><b>게시판 관리 </b><span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a><b>고객센터 관리</b></a></li>
					<li class="action"><a href="/semiProject/JY/NoticeForm.admin"> - 공지사항 관리</a></li>
					<li class="action"><a href="/semiProject/JY/QnaForm.admin"> - Q&A 관리</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="action active"><a href="/semiProject/JY/FestivalForm.admin"><b>축제정보 관리 </b><span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			</div>
			</div>

	<!-- Content -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">
			<i>축제정보 관리</i>
		</h1>
		<div class="detaillayout">
			<div class="right2">
				<div class="slideshow-container">
					<c:forTokens items="${photoList}" delims=" " var="photo">
						<div class="mySlides fade">
							<img src="${pageContext.request.contextPath}/imgSave/${photo}"
								style="width: 500px; height: 500px;"></img>
						</div>
					</c:forTokens>
					<!-- Next and previous buttons -->
					<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
						class="next" onclick="plusSlides(1)">&#10095;</a>
					<c:forEach varStatus="status" begin="1" end="${length}">
						<span class="dot" onclick="currentSlide(${status.current})"></span>
					</c:forEach>
				</div>
				<div class="tablediv">
					<table>
						<tr>
							<td>조회수:</td>
							<td>${article.f_readcount }</td>
						</tr>
						<tr>
							<td>축제 이름:</td>
							<td>${article.f_subject }</td>
						</tr>
						<tr>
							<td>축제 기간:</td>
							<td>${article.f_sdate }<br> ~ ${article.f_edate }
							</td>
						</tr>
						<tr>
							<td>축제 나라:</td>
							<td>${article.f_country }</td>
						</tr>

						<tr>
							<td>축제 위치:</td>
							<td></td>
						</tr>
						<tr>
							<td colspan=2>${article.f_loc }</td>
						</tr>
						<tr>
							<td>홈페이지 주소:</td>
							<td></td>
						</tr>

						<tr>
							<td colspan=2>http://www.naver.com${article.f_url }</td>
						</tr>

					</table>
				</div>
				<div class="detaildiv">
					<h4>
						<b>상세정보</b>
					</h4>
					<div class="detail">${article.f_content }</div>
					<div class="detailbutton">
						<table style="text-align: right">
							<tr>
								<td><input type="button" value="글수정"
									onclick="document.location.href='/semiProject/JY/FestivalModifyForm.admin?num=${article.f_num}'">
									&nbsp; <input type="button" value="글삭제"
									onclick="document.location.href='/semiProject/JY/FestivalDeletePro.admin?num=${article.f_num}&photo_id=${article.photo_id}'">
									&nbsp; <c:if test="${article.f_num-1 ne 0}">
										<input type="button" value="<< PRE "
											onclick="document.location.href='/semiProject/JY/FestivalDetailForm.admin?f_num=${article.f_num-1}'">
									</c:if> <input type="button" value="목록"
									onclick="document.location.href='/semiProject/JY/FestivalForm.admin'">
									<input type="button" value="NEXT >>"
									onclick="document.location.href='/semiProject/JY/FestivalDetailForm.admin?f_num=${article.f_num+1}'"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
</body>


</html>