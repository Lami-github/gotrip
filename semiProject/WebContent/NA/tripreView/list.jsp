<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<tiles:insertDefinition name="mainheader" />
<title>여행가좌 by 멋지고 쿨한 오조.</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<script
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>
   $(function() {
      $("#htagOpen").click(function() {
         if ($("#radiodiv").css("display") == "none")
            $("#radiodiv").show();
         else
            $("#radiodiv").hide();
      })
   })

   $(function() {
      $("#radiotable").change(function() {
         var htag1 = $('input[name="hashTag1"]:checked').val();
         var htag2 = $('input[name="hashTag2"]:checked').val();
         var htag3 = $('input[name="hashTag3"]:checked').val();

         if (undefined == htag1) {
            var htag1 = "";
         }
         if (undefined == htag2) {
            var htag2 = "";
         }
         if (undefined == htag3) {
            var htag3 = "";
         }

         $('input[name="hashTagText"]').val(htag1 + htag2 + htag3);
      })
   })
</script>
<style>
.grid {
   width: 23.5%;
   min-height: 100px;
   padding: 15px;
   background: #fff;
   margin: 8px;
   font-size: 12px;
   float: left;
   box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
   -moz-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
   -webkit-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
   -webkit-transition: top 1s ease, left 1s ease;
   -moz-transition: top 1s ease, left 1s ease;
   -o-transition: top 1s ease, left 1s ease;
   -ms-transition: top 1s ease, left 1s ease;
}

.grid strong {
   border-bottom: 1px solid #ccc;
   margin: 10px 0;
   display: block;
   padding: 0 0 5px;
   font-size: 17px;
}

.grid .meta {
   text-align: right;
   color: #777;
   font-style: italic;
}

.grid .imgholder img {
   max-width: 100%;
   background: #ccc;
   display: block;
}

@media screen and (max-width : 1240px) {
   body {
      overflow: auto;
   }
}
</style>


<script>
   $(function() {
      $("#htagOpen").click(function() {
         if ($("#radiodiv").css("display") == "none")
            $("#radiodiv").show();
         else
            $("#radiodiv").hide();
      })
   })

   $(function() {
      $("#radiotable").change(function() {
         var htag1 = $('input[name="hashTag1"]:checked').val();
         var htag2 = $('input[name="hashTag2"]:checked').val();
         var htag3 = $('input[name="hashTag3"]:checked').val();

         if (undefined == htag1) {
            var htag1 = "";
         }
         if (undefined == htag2) {
            var htag2 = "";
         }
         if (undefined == htag3) {
            var htag3 = "";
         }

         $('input[name="hashTagText"]').val(htag1 + htag2 + htag3);
      })
   })
   function hashtagopen(){
      if(document.getElementById("radiotable").style.display == "none")
      document.getElementById("radiotable").style.display="";
      else
         document.getElementById("radiotable").style.display="none";
   }
</script>

</head>


<body>
   <!-- One -->
   <section id="One" class="wrapper style3">
      <div class="inner">
         <header class="align-center">
            <p>여행꿀팁</p>
            <h2>여행후기</h2>
         </header>
      </div>
   </section>

   <!-- Two -->
   <section id="two" class="wrapper style2">
      <div class="inner">
         <div class="box">
            <div class="content">
               
               <br> <b>글목록(전체 글:${count}) </b>
               <form action=/semiProject/NA/tripreView/list.do>
                  <table>
                     <tr>
                        <td><select name="n">
                              <option value="0">제목</option>
                              <option value="1">내용</option>
                        </select></td>
                        <td><input id="aa" type="text" name="search"></td>
                        <td rowspan="2">
                           <button type="submit" style="width: 100pt; height: auto;"> 검색</button>
                             
                          
                        </ul>
                           
                        </td>
                     </tr>
                     <tr>
                     
                        
                           <div class="row uniform">
               <div class="9u 12u$(small)">
               <input type="text" class="form-control"  name="hashTagText" readonly> 
               </div>
               <div class="3u$ 12u$(small)">
               <input class="button special fit small"  type="button" value="해시태그검색"  id="htagOpen" onclick="hashtagopen()" />
               </div>
            </div>
                         
                         
                     
                        
                        </td>
                     </tr>
                  </table>
                  
                  <div id="radiodiv">
                     <table class="radiotable" id="radiotable" style="display:none">
                        <tr>
                           <td><c:forEach var="country" items="${countryList}">
                           <div class="4u 12u$(small)">
                                 <input type="radio" id="${country.h_name}" name="hashTag1"
                                       value="${country.h_name} ">
                                 <label for="${country.h_name}">${country.h_name}</label>
                              </div>
                                 
                              </c:forEach></td>
                           <td><c:forEach var="season" items="${seasonList}">
                           <div class="4u 12u$(small)">
                                 <input type="radio" id="${season.h_name}" name="hashTag2"
                                       value="${season.h_name} ">
                                 <label for="${season.h_name}">${season.h_name}</label>
                              </div>
                                 
                              </c:forEach></td>
                           <td><c:forEach var="thema" items="${themaList}">
                           <div class="4u 12u$(small)">
                                 <input type="radio" id="${thema.h_name}" name="hashTag3"
                                       value="${thema.h_name} ">
                                 <label for="${thema.h_name}">${thema.h_name}</label>
                              </div>
                                 
                              </c:forEach></td>
                        </tr>
                     </table>
                  </div>




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
<div><table align=center>
                     <c:forEach var="tripreView" items="${tripreViewList}">
<a href="/semiProject/NA/tripreView/tripreViewContent.do?pageNum=${currentPage}&t_num=${tripreView.t_num}&id=${sessionScope.id}">
                        <div class="grid">
                           <div class="imgholder">
                  
                                 <img
                                 src="${pageContext.request.contextPath}/imgSave/${tripreView.imagePath}">
                          
                           </div>
                        
                              <strong>${tripreView.t_subject}</strong>
                           
                           <div class="meta">${tripreView.t_htag}</div>
                        </div>
                     </c:forEach>
                     </table>
                     </div>
                    </div>
                  </c:if>
            
               <div align="center">
               <c:if test="${count > 0 }">
                  <c:set var="pageCount"
                     value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
                  <c:set var="pageBlock" value="${5}" />
                  <fmt:parseNumber var="result" value="${currentPage / 5}"
                     integerOnly="true" />
                  <c:set var="startPage" value="${result * 5 + 1}" />
                  <c:set var="endPage" value="${startPage + pageBlock-1}" />
                  <c:if test="${endPage > pageCount}">
                     <c:set var="endPage" value="${pageCount}" />
                  </c:if>


                  <c:if test="${startPage > 5 }">
                     <a
                        href="/semiProject/NA/tripreView/list.do?pageNum=${startPage - 5}">[이전]</a>
                  </c:if>

                  <c:forEach var="i" begin="${startPage}" end="${endPage}">
                     <a href="/semiProject/NA/tripreView/list.do?pageNum=${i}">[${i}]</a>
                  </c:forEach>

                  <c:if test="${endPage < pageCount}">
                     <a
                        href="/semiProject/NA/tripreView/list.do?pageNum=${startPage + 5}">[다음]</a>
                  </c:if>

               </c:if>

               <button
                  onclick="location.href='/semiProject/NA/tripreView/writeForm.jsp'">글쓰기</button>
                  </div>
   </div>
   </div>
   </section>
   


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



