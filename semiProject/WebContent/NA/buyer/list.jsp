<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
      <head>
      <tiles:insertDefinition name="mainheader" />
      <title>여행가좌 by 멋지고 쿨한 오조.</title>
      <meta charset="utf-8" />
       <meta name="viewport" content="width=device-width, initial-scale=1" /> 
      <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
             
      
   </head>     
   <style>


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


 .radiotable th, .radiotable td { border:0.5px solid gray;}
 .radiotable { width: 100%; height: 80px; }
 #radiodiv { border:0.5px solid gray; width:70%; }
</style>
   
   <body >
      <!-- One -->
         <section id="One" class="wrapper style3">
            <div class="inner">
               <header class="align-center">
                  <p>직구할까?</p>
                  <h2>구매자 페이지</h2>
               </header>
            </div>
         </section>

      <!-- Two -->
         <section id="two" class="wrapper style2">
            <div class="inner">
               <div class="box">
                  <div class="content">
                     <header class="align-center">
                     
                     </header>
                     <p>
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
               style="width:80pt; height:auto;"></button>
                              <ul class="actions">  
                           <li><a href="#" class="button special icon fa-search">검색</a></li>
                        </ul>
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
               <div class="imgholder"><a href="/semiProject/NA/buyer/buyerBoardContent.do?
               pageNum=${currentPage}&b_num=${buyerBoard.b_num}&id=${sessionScope.id}">
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
   <button onclick="location.href='/semiProject/NA/buyer/writeForm.jsp'">글쓰기</button>
</section>

      <div>
      <tiles:insertDefinition name="mainfooter" />
   </div>
         <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/js/slide.js"></script>
   </body>
</html>
