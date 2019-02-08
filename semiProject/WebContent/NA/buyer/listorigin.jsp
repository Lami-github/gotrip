<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>BlocksIt.js Demonstration #2 - Pinterest Dynamic Grid Layout with CSS3 Transitions</title>
<meta name="description" content="BlocksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com"/>
<meta name="keywords" content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson"/>
<link rel='stylesheet' href='style.css' media='screen' />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="../blocksit.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
	
</script>
<style>
body{
   margin:0;
   padding:0;
   background:url(../bg.gif) 0 0 repeat #f7f5f5;
   color:#333;
   font-family:Cambria, Georgia, serif;
   font-size:15px;
   overflow-x:hidden;
}
header, section, footer, hgroup{
   display:block;
}
a {
   color:#35BFFF;
   text-decoration:none;
}
a:hover, a:active{
   color:#91DCFF;
}

/* Header */
#header{
   width:100%;
   background:#000;
   background:rgba(0, 0, 0, 0.8);
   padding:5px 0;
   letter-spacing:1px;
   margin-bottom:20px;
   position:fixed;
   top:0;
   left:0;
   z-index:99;
}
#header h1{
   padding:0 20px;
   margin:5px 0;
   text-shadow:2px 1px 1px #333, 2px 2px 1px #888;
   color:#EAEAEA;
   float:left;
   font-size:27px;
}
#backlinks{
   float:right;
   padding:0 20px;
   line-height:22px;
   font-weight:bold;
   font-size:13px;
}
#backlinks a{
   text-align:right;
   display:block;
}

/* Footer */
#footer{
   width:100%;
   position:fixed;
   padding-left:20px;
   bottom:0;
   left:0;
   line-height:20px;
   color:#888;
   font-size:13px;
   background:rgb(0, 0, 0);
   background:rgba(0, 0, 0, 0.8);
   z-index:99;
}
#footer span{
   display:block;
}

/* clearfix */
.clearfix {
   clear:both;
}

/* wrapper css */
#wrapper{
   margin-top:70px;
   width:100%;
}
#wrapper hgroup{
   text-align:center;
}
#wrapper h2{
   margin:5px 0;
   color:#FF6D99;
   text-shadow:1px 1px 2px #A50031;
   font-size:33px;
   font-family:Arial Narrow, Arial, sans-serif;
}
#wrapper h3{
   font-style:italic;
   font-weight:normal;
   font-size:18px;
   text-shadow:1px 1px 0 #fff;
   color:#888;
   margin:5px 0;
}

#container{
   position:relative;
   width:1100px;
   margin:0 auto 25px;
   padding-bottom: 10px;
   
}
.grid{
   width:188px;
   min-height:100px;
   padding: 15px;
   background:#fff;
   margin:8px;
   font-size:12px;
   float:left;
   box-shadow: 0 1px 3px rgba(34,25,25,0.4);
   -moz-box-shadow: 0 1px 3px rgba(34,25,25,0.4);
   -webkit-box-shadow: 0 1px 3px rgba(34,25,25,0.4);
   
   -webkit-transition: top 1s ease, left 1s ease;
   -moz-transition: top 1s ease, left 1s ease;
   -o-transition: top 1s ease, left 1s ease;
   -ms-transition: top 1s ease, left 1s ease;
}

.grid strong {
   border-bottom:1px solid #ccc;
   margin:10px 0;
   display:block;
   padding:0 0 5px;
   font-size:17px;
}
.grid .meta{
   text-align:right;
   color:#777;
   font-style:italic;
}
.grid .imgholder img{
   max-width:100%;
   background:#ccc;
   display:block;
}

@media screen and (max-width : 1240px) {
   body{
      overflow:auto;
   }
}
@media screen and (max-width : 900px) {
   #backlinks{
      float:none;
      clear:both;
   }
   #backlinks a{
      display:inline-block;
      padding-right:20px;
   }
   #wrapper{
      margin-top:90px;
   }
}

 .radiotable th, .radiotable td { border:0.5px solid gray;}
 .radiotable { width: 100%; height: 80px; }
 #radiodiv { border:0.5px solid gray; width:70%; }
</style>
<link rel="shortcut icon" href="http://www.inwebson.com/wp-content/themes/inwebson2/favicon.ico" />
<link rel="canonical" href="http://www.inwebson.com/demo/blocksit-js/demo2/" />
</head>
<body>

<!-- Header -->


<!-- Content -->
<section id="wrapper">


<h2>구매자 페이지</h2>
	<hr>
	<br>
	<b>글목록(전체 글:${count}) </b>
	<form action="list.do">
		<table>
			<tr>
				<td><select name="n">
						<option value="0">제목</option>
						<option value="1">나라명</option>
						<option value="2">상품명</option>
				</select></td>
				<td><input id="aa" type="text" name="search"></td>
				<td rowspan="2">
				<button type="submit"
					style="width:80pt; height:auto;"><img src="../../img/search.png" width=80pt height="auto"></button></td>
			</tr>
		</table>
		<br>
	</form>
	<div>
	<c:if test="${count eq 0}">
		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${count > 0 }">

			<c:forEach var="buyerBoard" items="${buyerBoardList}">
				<div class="grid">
					<div class="imgholder"><a href="/semiProject/NA/buyer/buyerBoardContent.do?pageNum=${currentPage}&b_num=${buyerBoard.b_num}&id=${sessionScope.id}">
						<c:choose>
						<c:when test="${buyerBoard.firstImagePath eq null}">
							<img src="../../img/2513B53E55DB206927.png"></c:when>
						<c:when test="${buyerBoard.firstImagePath ne null}">
							<img src="${pageContext.request.contextPath}/imgSave/${buyerBoard.firstImagePath}"></c:when>
						</c:choose>
						</a>
					</div>
					${buyerBoard.b_country}<br>
	
					<strong>${buyerBoard.b_subject}</strong>
					</a>
					${buyerBoard.b_item}<br>
					${buyerBoard.b_count} &nbsp;&nbsp;&nbsp;&nbsp; ${buyerBoard.b_price}
				</div>
			</c:forEach>
	</c:if>
	</div>
	<c:if test="${count > 0 }">
		<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${5}" />
		<fmt:parseNumber var="result" value="${currentPage / 5}" integerOnly="true" />
		<c:set var="startPage" value="${result * 5 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}" />
		</c:if>
	
	
		<c:if test="${startPage > 5 }">
		<a href="/semiProject/NA/buyer/list.do?pageNum=${startPage - 5}">[이전]</a>
		</c:if>
	
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/semiProject/NA/buyer/list.do?pageNum=${i}">[${i}]</a>
		</c:forEach>
	
		<c:if test="${endPage < pageCount}">
		<a href="/semiProject/NA/buyer/list.do?pageNum=${startPage + 5}">[다음]</a>
		</c:if>
	
</c:if>
	<c:if test="${sessionScope.id ne null}">
	<button onclick="location.href='/semiProject/NA/buyer/writeForm.jsp'">글쓰기</button>
	</c:if>
</section>
</body>
</html>

