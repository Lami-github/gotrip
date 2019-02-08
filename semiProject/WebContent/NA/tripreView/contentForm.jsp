<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<tiles:insertDefinition name="mainheader" /> 
<title>멋지고 쿨한 오조.</title>
<meta name="description" content="BlocksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com"/>
<meta name="keywords" content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson"/>
<link rel='stylesheet' href='style.css' media='screen' />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>   
function change1(a){
    var id1="a"+a;
    var id2="b"+a;
    var aa=document.getElementById(id1);
    var bb=document.getElementById(id2);
    
    aa.style.display="none";
    bb.style.display="block";
  }
  
function change2(a){
    var id1="a"+a;
    var id2="b"+a;
    var aa=document.getElementById(id1);
    var bb=document.getElementById(id2);
    
    aa.style.display="block";
    bb.style.display="none";
  }

function blacklistArticle(){
   url="/semiProject/mj/blacklistArticle.do?board_id=1&re_num=${tripreViewContent.t_num}&bl_subject=${tripreViewContent.t_subject}&writer=${tripreViewContent.t_writer}";
   window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}

function blacklistComment(a,b){
   url="/semiProject/mj/blacklistComment.do?board_id=1&re_num=${tripreViewContent.t_num}&re_comment="+a+"&bl_subject=${tripreViewContent.t_subject}&writer="+b;
   window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}
</script>
<style>


a:hover, a:active{
   color:#91DCFF;
}


}
.grid{
   width:300px;
   min-height:100px;
   padding: 15px;
   background:#fff;
   margin:8px;
   font-size:12px;
   
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
   
}

@media screen and (max-width : 1240px) {
   body{
      overflow:auto;
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

   <div>
      <section id="One" class="wrapper style3">
         <div class="inner">
            <header class="align-center">
               <p>여행자게시판</p>
               <h2>여행후기 상세보기</h2>
            </header>
         </div>
      </section>
   </div>
<!-- Header -->


<!-- Content -->
<section id="wrapper">

   <div>
   
   <c:forEach var="a" items="${imgPath}" >


      <img src="${pageContext.request.contextPath}/imgSave/${a}" width="350px" height="300px">

   </c:forEach>
   
            
                  
                  <table align="right">
                     <tr>
                        <td>작성자 : ${tripreViewContent.t_writer}</td>

                        <td><input type=button class="button special" value="신고" onclick="blacklistArticle()">

                     </td>
                     </tr>
                     <tr>
                        <td>작성일 : ${tripreViewContent.t_reg_date}</td><td>조회수 : ${tripreViewContent.t_readcount}
                     </td>
                     <tr>
                        <td>제목 : ${tripreViewContent.t_subject}</td>
                     </tr>
                     <tr>
                        <td>해시태그 : ${tripreViewContent.t_htag}</td>
                     </tr>
                     <tr>
                        <td>내용 : ${tripreViewContent.t_content}</td>
                     </tr>
                  </table>
                  
            </div>
      </section>   
<form action="/semiProject/NA/tripreView/tripreViewContent.do">
      <br>
      댓글
      <br>
<c:if test="${sessionScope.id ne null}" >   
<c:if test="${count eq 0}">
      <input type="text" name="commentText" id="commentText"><input type="submit" value="올리기">
      <input type="hidden" name="t_num" value="${tripreViewContent.t_num}">
      <input type="hidden" name="id" value="${sessionScope.id}">
</c:if>
 </c:if>
</form>
<c:if test="${count > 0 }">
   <c:if test="${sessionScope.id ne null}" >
   <form action="/semiProject/NA/tripreView/tripreViewContentPro.do" method="post">
      <div>
      <input type="text" name="commentText" id="commentText"><input type="submit" value="올리기">
            <input type="hidden" name="t_num" value="${tripreViewContent.t_num}">
            <input type="hidden" name="id" value="${sessionScope.id}">
         </div>
      </form>
      </c:if>
      
      <c:forEach var="tripreViewCommentList" items="${tripreViewCommentList}">
            <form action="/semiProject/NA/tripreView/tripreCommentMoidfyAction.do" name="commentForm">
               <div id="a${tripreViewCommentList.tc_num}">
               <div class="grid">
               작성자 : <strong>${tripreViewCommentList.tc_writer}</strong>
               내용 : ${tripreViewCommentList.tc_comment} <br>
               작성일 : ${tripreViewCommentList.tc_reg_date}<br>
               <span style="float:right">
                <c:if test="${tripreViewContent.t_writer eq sessionScope.id}" >
               <input type="button" value="수정" onclick="change1('${tripreViewCommentList.tc_num}')">
               <input type="button" value="삭제" onclick="location.href='/semiProject/NA/tripreView/tripreCommentDeleteAction.do?tc_num=${tripreViewCommentList.tc_num}&t_num=${tripreViewContent.t_num}'">

               <input type=button value="신고" onclick="blacklistComment('${tripreViewCommentList.tc_num}','${tripreViewCommentList.tc_writer}')">

               </c:if>
               <br></span>
               </div>
               </div>
               <div id="b${tripreViewCommentList.tc_num}" style="display:none">
               <div class="grid">
                  작성자 : <strong><input type="text" name="tc_writer" value="${tripreViewCommentList.tc_writer}" readOnly></strong>
                  내용 : <input type="text" name="tc_comment" value="${tripreViewCommentList.tc_comment}"><br>
                  <span style="float:right">
            
                  <input type="hidden" name="tc_num" value="${tripreViewCommentList.tc_num}">
                  <input type="hidden" name="t_num" value="${tripreViewContent.t_num}">
                  <input type="submit" value="완료" >
                  <input type="button" value="취소" onclick="change2('${tripreViewCommentList.tc_num}')">
                  <br></span>
               </div>
               </div>
               </form>
         </c:forEach>
   
</c:if>
<br><br>
<form action="/semiProject/NA/tripreView/updateForm.do">
   <input type="button" value="목록으로"  class="button special" onclick="document.location.href='/semiProject/NA/tripreView/list.do'">
   <c:if test="${tripreViewContent.t_writer eq sessionScope.id}" >
      <input type="hidden" name="t_num" value="${tripreViewContent.t_num}">
      <input type="hidden" name="t_subject" value="${tripreViewContent.t_subject}">
      <input type="hidden" name="t_content" value="${tripreViewContent.t_content}">
      <input type="hidden" name="t_htag" value="${tripreViewContent.t_htag}">
      <input type="hidden" name="photo_id" value="${tripreViewContent.photo_id}">
   <input type="submit" value="수정하기">
   <input type="button" value="삭제하기" onclick="document.location.href='/semiProject/NA/tripreView/deleteForm.do?t_num=${tripreViewContent.t_num}&photo_id=${tripreViewContent.photo_id}'">
   </c:if> 
</form>    
   <tiles:insertDefinition name="mainfooter" />

   <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
   <script src="<%=request.getContextPath() %>/js/util.js"></script>
   <script src="<%=request.getContextPath() %>/js/main.js"></script>

</body>
</html>
