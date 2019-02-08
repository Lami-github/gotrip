<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>BlocksIt.js Demonstration #2 - Pinterest Dynamic Grid Layout with CSS3 Transitions</title>
<meta name="description"
   content="B
   locksIt.js jQuery plugin Demonstration #2 Pinterest dynamic grid with CSS3 Transitions by inWebson.com" />
<meta name="keywords"
   content="demonstration,demo,jquery,blocksit.js,css3,dynamic,grid,layout,inwebson" />
<script
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<style>
.mainimg {
   width: 100%;
   height: 400px;
}

.detaildiv {
   wdith: 60%;
}

.imgdiv {
   width: 40%;
   height: 50%;
   display: inline-block;
   margin-right: 20;
}

.contentdiv {
   width: 50%;
   height: 50%;
   display: inline;
}

.tablediv {
   width: 60%;
   margin: 0 auto;
}

.tablediv table {
   width: 100%;
}
</style>
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
</script>

<script>

function UserIdentification(trade){
   
   var url = "/semiProject/mj/UserIdentificationFormActionBuyer.do";
   window.open("","openPopEvent","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
   
   trade.target = "openPopEvent";
   trade.action = url;
   trade.method="post";
   trade.submit();
}
function blacklistArticle(){
   url="/semiProject/mj/blacklistArticle.do?board_id=2&re_num=${buyerBoardContent.b_num}&bl_subject=${buyerBoardContent.b_subject}&writer=${buyerBoardContent.b_writer}";
   window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}

function blacklistComment(a,b){
   url="/semiProject/mj/blacklistComment.do?board_id=2&re_num=${buyerBoardContent.b_num}&re_comment="+a+"&bl_subject=${buyerBoardContent.b_subject}&writer="+b;
   window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}

 
</script>
</head>
<body>

<!-- Header -->
<tiles:insertDefinition name="mainheader" />


<!-- Content -->
<section id="One" class="wrapper style3">
      <div class="inner">
         <header class="align-center">
            <a href="/semiProject/NA/buyer/list.do"><p>직구할까?</p></a> <a
               href="/semiProject/NA/buyer/list.do"><h2>구매자페이지</h2></a>
         </header>
      </div>
   </section>
<!-- two -->

<section id="two" class="wrapper style2">
      <div class="inner">
         <div class="box">
            <div class="content">
               <div class=tablediv style="width:100%;">
<h2>구매자 페이지 상세보기</h2>
   <hr>
   <br>
   <div>
   
   

      <img src="titleimage.PNG" width="350px" height="300px">


   
            <div>
                  <div>
                  <table align="right" style="margin-top:-308px; width:60%;">
                     <tr>
                        <td>작성자 : ${buyerBoardContent.b_writer}</td>
                        <td>
                        <input type=button value="신고" onclick="blacklistArticle()">
                        
                     </td>
                     </tr>
                     <tr>
                        <td>작성일 : ${buyerBoardContent.b_reg_date}</td><td>조회수 : ${buyerBoardContent.b_readcount}
                     </td>
                     <tr>
                        <td>제목 : ${buyerBoardContent.b_subject}</td>
                     </tr>
                     <tr>
                        <td>나라명 : ${buyerBoardContent.b_country}</td>
                     </tr>
                     <tr>
                        <td>상품명 : ${buyerBoardContent.b_item}</td>
                     </tr>
                     <tr>
                        <td>개수 : ${buyerBoardContent.b_count}</td>
                     </tr>
                     <tr>
                        <td>총금액 : ${buyerBoardContent.b_price}</td>
                     </tr>
                     <tr>
                        <td>제목 : ${buyerBoardContent.b_subject}</td>
                     </tr>
                     <tr>
                        <td>내용 : ${buyerBoardContent.b_content}</td>
                     </tr>
                     <tr>
                        <td>
                           <c:if test="${!empty sessionScope.id}">
                           <form name=trade>
                              <input type="hidden" id=b_num name=b_num value="${buyerBoardContent.b_num}">
                              <input type="hidden" id=b_writer name=b_writer value="${buyerBoardContent.b_writer}">
                               <input type="hidden" id=trade_country name=trade_country value="${buyerBoardContent.b_country}">
                               <input type="hidden" id=trade_item name=trade_item value="${buyerBoardContent.b_item}">
                               <input type="hidden" id=trade_count name=trade_count value="${buyerBoardContent.b_count}">
                               <input type="hidden" id=trade_point name=trade_point value="${buyerBoardContent.b_price}">
                               <input type=button value="거래신청" onclick="javascript:UserIdentification(this.form);">
                                 </form>
                                 </c:if>
                              </td>
                     </tr>
                  </table>
                  
            </div>
   
<form action="/semiProject/NA/buyer/buyerBoardContentPro.do">
      <br>
      댓글
      <br>
<c:if test="${sessionScope.id ne null}" > >       
<c:if test="${count eq 0}">
      <input type="text" name="commentText" id="commentText"><input type="submit" value="올리기">
      <input type="hidden" name="b_num" value="${buyerBoardContent.b_num}">
      <input type="hidden" name="id" value="${sessionScope.id}">
</c:if>
</c:if>
</form>
<c:if test="${count > 0 }">
   <c:if test="${sessionScope.id ne null}" >
         <form action="/semiProject/NA/buyer/buyerBoardCommentModify.do" name="commentForm">
               <input type="text" name="commentText" id="commentText"><input type="submit" value="올리기">
            <input type="hidden" name="pageNum" value="${pageNum}">
            <input type="hidden" name="b_num" value="${buyerBoardContent.b_num}">
            <input type="hidden" name="id" value="${sessionScope.id}">
   </form>
   </c:if>
   <c:forEach var="buyerBoardCommentList" items="${buyerBoardCommentList}">
            <form action="/semiProject/NA/buyer/buyerBoardCommentModify.do" name="commentForm">
               <div>
               <div class="grid" id="a${buyerBoardCommentList.bc_num}">
               작성자 : <strong>${buyerBoardCommentList.bc_writer}</strong>
               내용 : ${buyerBoardCommentList.bc_comment} <br>
               작성일 : ${buyerBoardCommentList.bc_reg_date}<br>
               <span style="float:right">
                <c:if test="${buyerBoardContent.b_writer eq sessionScope.id}" >
               <input type="button" value="수정" onclick="change1('${buyerBoardCommentList.bc_num}')">
               <input type="button" value="삭제" onclick="location.href='/semiProject/NA/buyer/buyerBoardCommentDelete.do?bc_num=${buyerBoardCommentList.bc_num}&b_num=${buyerBoardContent.b_num}'">
               <input type=button value="신고" onclick="blacklistComment('${buyerBoardCommentList.bc_num}','${buyerBoardCommentList.bc_writer}')">
               </c:if>

               <br></span>
               </div>
               </div>
               <div id="b${buyerBoardCommentList.bc_num}" style="display:none">
               <div class="grid">
                  작성자 : <strong><input type="text" name="bc_writer" value="${buyerBoardCommentList.bc_writer}" readOnly></strong>
                  내용 : <input type="textarea" name="bc_comment" value="${buyerBoardCommentList.bc_comment}"><br>
                  <span style="float:right">
                  <input type="hidden" name="bc_num" value="${buyerBoardCommentList.bc_num}">
                  <input type="hidden" name="b_num" value="${buyerBoardContent.b_num}">
                  <input type="submit" value="수정완료" >
                  <input type="button" value="취소" onclick="change2('${buyerBoardCommentList.bc_num}')">
                  
                  <br></span>
               </div>
               </div>
            </form>
         </c:forEach>
</c:if>
<br><br>
<form action="/semiProject/NA/buyer/updateForm.do">
   <input type="button" value="목록으로" onclick="document.location.href='/semiProject/NA/buyer/list.do?'">
<c:if test="${buyerBoardContent.b_writer eq sessionScope.id}" >
   <input type="submit" value="수정하기">
   <input type="hidden" name="b_num" value="${buyerBoardContent.b_num}">
   <input type="hidden" name="pageNum" value="${pageNum}">
   <input type="button" value="삭제하기" onclick="document.location.href='/semiProject/NA/buyer/buyerBoardDeleteForm.do?b_num=${buyerBoardContent.b_num}&photo_id=${buyerBoardContent.photo_id}'">
</c:if>
</form>
</div>
               </div>
               
            </div>
         </div>
         </div>
   </section>
   <tiles:insertDefinition name="mainfooter" />

   <script src="/js/jquery.min.js"></script>
   <script src="/js/jquery.scrollex.min.js"></script>
   <script src="/js/skel.min.js"></script>
   <script src="/js/util.js"></script>
   <script src="/js/main.js"></script>
</body>
</html>
