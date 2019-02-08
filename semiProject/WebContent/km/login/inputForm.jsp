<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>회원가입</title>

   <section id="One" class="wrapper style3">
      <div class="inner">
         <header class="align-center">
            <p>여행가좌</p>
            <h2>회원가입</h2>
         </header>
      </div>
   </section>
<!-- *************************************************************************************************************************** -->
<!-- *************************************************************************************************************************** -->
<script>
function checkIt(){
   var userinput = eval("document.userinput");
   
    if(!userinput.id.value) {
           alert("ID를 입력하세요");
           return false;
       }
      
       if(!userinput.password.value ) {
           alert("비밀번호를 입력하세요");
           return false;
       }
       if(userinput.password.value != userinput.password2.value)
       {
           alert("비밀번호를 동일하게 입력하세요");
           return false;
       }
            
       if(!userinput.name.value) {
           alert("사용자 이름을 입력하세요");
           return false;
       }
       
       if(!userinput.check.value) {
           alert("이메일 인증을 완료해주세요");
           return false;
       }
       
       if(!userinput.phonenumber.value) {
           alert("휴대폰 번호를 입력하세요");
           return false;
       }
         if(!userinput.zipcode.value || !userinput.address.value) {
           alert("주소를 입력하세요");
           return false;
       } 
       if(!userinput.address1.value) {
           alert("상세 주소를 입력하세요");
           return false;
       }
       
       if(!userinput.pwdquiz.value || !userinput.pwdanswer.value) {
           alert("비밀번호 찾기 질문 및 답변을 입력하세요");
           return false;
       }
       
       if(userinput.idcheck.value != 1){
         alert("아이디 중복확인을 해주세요");
         return false;
      }
       
       return true;
   }


   function checkEmail(userinput){
      if(userinput.email.value == ""){
         alert("이메일을 입력하세요");
         return;
      }
       url = "/semiProject/km/InputemailCert.do?email=" + userinput.email.value;   
       // 새로운 윈도우를 엽니다.
       open(url, "InputemailCert", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700,height=200");   
   }

   function zipCheck(){
      
      url="/semiProject/km/ZipCheck.do?check=y";
      
      window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
   }
   
   function openConfirmid(userinput) {
       // 아이디를 입력했는지 검사
       if (userinput.id.value == "") {
           alert("아이디를 입력하세요");
           return;
       }
       // url과 사용자 입력 id를 조합합니다.
       url = "/semiProject/km/confirmId.do?id=" + userinput.id.value + "&idcheck=" + userinput.idcheck.value;
      
       // 새로운 윈도우를 엽니다.
       open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
   }

</script>

<tiles:insertDefinition name="mainheader" />
<style>
.container-inputfrom{
       width: 50%;
    margin: 60px auto 0 auto;
}
body{
   backgroud:black;
}
input[type="tel"]{
   -moz-appearance: none;
      -webkit-appearance: none;
      -ms-appearance: none;
      appearance: none;
      border-radius: 2px;
      border: none;
      border: solid 1px;
      color: inherit;
      display: block;
      outline: 0;
      padding: 0 1rem;
      text-decoration: none;
      width: 100%;
      background: rgba(144, 144, 144, 0.075);
      border-color: rgba(144, 144, 144, 0.25);
      height: 2.75rem;
}
</style>
</head>
<body>

<div class="container-inputform" style="width: 50%;
    margin: 60px auto 0 auto;">
<fieldset class="">
<legend class=""></legend>

<form method="post" action="/semiProject/km/inputPro.do" name="userinput" onSubmit="return checkIt()">
            아이디<div class="row uniform">
               <div class="9u 12u$(small)">
                  <input type="text" name="id" id="id" class="form-control"
                     placeholder="아이디를 입력해주세요"><input type="hidden"
                     name="idcheck" value=-1 />
               </div>
               <div class="3u$ 12u$(small)">
                  <input class="button special fit small"
                     OnClick="openConfirmid(this.form)" type="button"
                     name="confirm_id" value="ID중복확인" />
               </div>
            </div>



비밀번호 <input type="password" name="password" id="password" class="form-control" placeholder="비밀번호를 입력해주세요"><br/>
비밀번호 재확인<input type="password" name="password2" id="password2" class="form-control" placeholder="비밀번호를 확인해주세요"><br/>
이름 <input type="text" name="name" id="name" class="form-control" placeholder="이름을 적어주세요"><br/>


<!-- *************************************************************************************************************************** -->
<!-- *************************************************************************************************************************** -->

      이메일<div class="row uniform">
               <div class="9u 12u$(small)">
                  <input type="email" name="email" id="email" class="form-control" placeholder="이메일을 작성해주세요"/>
                  
               </div>
               <div class="3u$ 12u$(small)">
               <input class="button special fit small" type=button name=cert value=인증번호받기 onclick="checkEmail(this.form)" > <input type=text name=check size=5 readonly><br/> 
</div>
            </div>

      

<!-- *************************************************************************************************************************** -->
<!-- *************************************************************************************************************************** -->
   
전화번호 <input type="tel" name="phonenumber" id="phonenumber" class="form-control" placeholder="전화번호를 작성해주세요" onkeyPress="if ((event.keyCode<48) || (event.keyCode>57)) event.returnValue=false;"><br/>

 



            우편번호<div class="row uniform">
               <div class="9u 12u$(small)">
                  <input type="text" name="zipcode" size="7" class="form-control" readonly/>
                  
               </div>
               <div class="3u$ 12u$(small)">
               <input class="button special fit small"  type="button" value="우편번호 찾기" onclick="zipCheck()" class="zip-btn"/>
               </div>
            </div>


주소<input type="text" name="address" id="address" class="form-control" readonly><br/>
상세주소<input type="text" name="address1" id="address1" class="form-control" placeholder="주소를 적어주세요."><br/>
비밀번호찾기 질문<select name="pwdquiz">
<option value="0" selected>질문을 선택해주세요.</option>
<option value="1" >당신이 태어난 동네는?</option>
<option value="2">좋아하는 음식은?</option>
<option value="3">부먹? 찍먹?</option>
</select><br/>
답변 <input type="text" name="pwdanswer" class="form-control" placeholder="질문에 대한 답을 작성해주세요"><br/>
<!-- <input type="submit" name="confirm" value="가입하기"> -->
<input type="hidden" name="warn" value="0">
<input type="hidden" name="grade" value="normal">
<input type="hidden" name="point" value="0">
<input type="hidden" name="blacklist" value='F'>
 <ul class="actions fit small">
<li><input class="button special fit small" type="submit" name="confirm" value="여행가좌와 함께하기!"></a></li>
</ul>


</div>
</form>
</fieldset>

   <div>
      <tiles:insertDefinition name="mainfooter" />
   </div>
   
   <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/util.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>