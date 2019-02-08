<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<title>마이페이지</title>
<style>
.mymain {
   position: absolute;
   top: 51px;
   bottom: 0;
   left: 16.66666667%;
   z-index: 1000;
   display: block;
   padding: 20px;
   overflow-x: hidden;
   overflow-y: auto;
}

.main-width {
   width: 73.33333337%;
   float: left;
   min-height: 1px;
}
.asd {
	background-color: white;
}
</style>
</head>
<body>
   <tiles:insertDefinition name="mainheader" />

   <section id="One" class="wrapper style3">
      <div class="inner">
         <header class="align-center">
            <a href="/semiProject/km/myPagePoint.do"><p>마이 페이지</p></a>
            <a href="semiProject/mj/myboardMain.do"><h2>내가 쓴 댓글</h2></a>
         </header>
      </div>
   </section>


   <section id="two" class="wrapper style2">
      <div class="inner">
         <div class="box">
            <div class="content">
               <table border="0" align="center">

                  <tr  align=right>
                     <td class="asd">
                        <div class="row uniform">
                           <div class="9u 12u$(small)">
                              <select onchange="if(this.value) location.href=(this.value);">
                                 <option value="">---게시판 분류---</option>
                                 <option
                                    value="/semiProject/mj/myboardMain.do?option=tripreview&pageNum=1">여행후기</option>
                                 <option
                                    value="/semiProject/mj/myboardMain.do?option=buyer&pageNum=1">구매자게시판</option>
                                 <option
                                    value="/semiProject/mj/myboardMain.do?option=traveler&pageNum=1">여행자게시판</option>
                              </select>
                           </div>
                           <div class="3u$ 12u$(small)">
                              <input type=button
                                 onclick="location.href='/semiProject/mj/myboardMain.do'"
                                 value="내가 쓴 글" />
                           </div>
                        </div>


                     </td>
                  </tr>
                  <tr align=center>
                     <td>
                        <table border=1 width=740 cellpadding=0 cellspacing=0
                           style="text-align:center;">
                           <tr height="30">
                              <td align="center" width="70">글번호</td>
                              <td align="center" width="50">분 류</td>
                              <td align="center" width="430">내 용</td>
                              <td align="center" width="70">작성일</td>
                              <td align="center" width="70">작성자</td>
                           </tr>
                           <c:choose>
                              <c:when test="${comment eq null}">
                                 <tr>
                                    <td colspan=6 align="center"><br>작성한 글이 없습니다.</td>
                                 </tr>
                              </c:when>
                              <c:otherwise>
                                 <tr>
                                    <td align="center"></td>
                                 </tr>
                                 <c:forEach var="comment" items="${comment}">
                                    <tr>
                                       <td><c:out value="${comment.commentnum}" /></td>
                                       <td>${option}</td>
                                       <td><c:if test="${option eq 'buyer'}">
                                             <a
                                                href="/semiProject/NA/buyer/buyerBoardContent.do?pageNum=${currentPage}&b_num=${comment.articlenum}"><c:out
                                                   value="${comment.comment}" /></a>
                                          </c:if> <c:if test="${option eq 'traveler'}">
                                             <a
                                                href="/semiProject/mj/travelerDetail.do?pageNum=${currentPage}&tr_num=${comment.articlenum}"><c:out
                                                   value="${comment.comment}" /></a>
                                          </c:if> <c:if test="${option eq 'tripreview'}">
                                             <a
                                                href="/semiProject/NA/tripreView/tripreViewContent.do?pageNum=${currentPage}&t_num=${comment.articlenum}"><c:out
                                                   value="${comment.comment}" /></a>
                                          </c:if></td>
                                       <td><c:out value="${comment.date}" /></td>
                                       <td><c:out value="${comment.writer }" /></td>
                                    </tr>
                                 </c:forEach>
                              </c:otherwise>
                           </c:choose>
                        </table>
                     </td>
                  </tr>
                  <c:if test="${count>0 }">
                     <tr  align="center">
                        <td class="asd"><c:set var="pageCount"
                              value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1) }" />
                           <c:set var="pageBlock" value="${10 }" /> <fmt:parseNumber
                              var="result" value="${currentPage / 10}" integerOnly="true" />
                           <c:set var="startPage" value="${result * 10 +1 }" /> <c:set
                              var="endPage" value="${startPage + pageBlock-1 }" /> <c:if
                              test="${endPage > pageCount}">
                              <c:set var="endPage" value="${pageCount}" />
                           </c:if> <c:if test="${startPage > 10}">
                              <a
                                 href="/semiProject/mj/myboardcommentMain.do?option=${option}&pageNum=${startPage - 10}">[이전]</a>
                           </c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}">
                              <a
                                 href="/semiProject/mj/myboardcommentMain.do?option=${option}&pageNum=${i}">[${i}]</a>
                           </c:forEach> <c:if test="${endPage < pageCount}">
                              <a
                                 href="/semiProject/mj/myboardcommentMain.do?option=${option}&pageNum=${startPage + 10}">[다음]</a>
                           </c:if></td>
                     </tr>
                  </c:if>
               </table>
            </div>
         </div>
      </div>

   </section>

   <tiles:insertDefinition name="mainfooter" />


   <!-- Scripts -->
   <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/util.js"></script>
   <script src="<%=request.getContextPath() %>/js/main.js"></script>

   </div>
</body>
</html>