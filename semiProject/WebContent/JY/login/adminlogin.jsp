<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Admin Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/adminsignin.css" rel="stylesheet">
    
   	<script language="javascript">
     
       function begin(){
         document.adminform.id.focus();
       }
       function checkIt(){
         if(!document.adminform.id.value){
           alert("이름을 입력하지 않으셨습니다.");
           document.adminform.id.focus();
           return false;
         }
         if(!document.adminform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.adminform.passwd.focus();
           return false;
         }
         
       }
    
   </script>
  </head>

  <body onload="begin()">

    <div class="container">

      <form name = "adminform" class="form-signin" action="/semiProject/JY/login/loginPro.admin" >
        <h2 class="form-signin-heading">Admin Login</h2>
        <input type="text" name="id" class="form-control" placeholder="ID" required autofocus>
        <input type="password" name="passwd" class="form-control" placeholder="Password" required>
        
        <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> -->
        <input type="submit" value="Sign in" class="btn btn-lg btn-primary btn-block">
      </form>

    </div> <!-- /container -->

  </body>
</html>
