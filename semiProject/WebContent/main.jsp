<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
   <head>
      <title>여행가좌 by 멋지고 쿨한 오조.</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />

   </head>    
   <body>      

   <tiles:insertDefinition name="mainheader" />
        

   <!-- Banner -->
         <section class="banner full">
            <article>
            <a href="/NA/tripreView/tripreViewContent.do?tr_num=${tr_num[0]}"><img src="<%=request.getContextPath() %>/img/travel-2604981_1920.jpg" alt="" /></a>
            
               <div class="inner">
                  <header>
                     <p>별이 박힌 하늘과 여름의 끝자락 밤 by <a href="#">trip ga-jwa</a></p>
                     <h2>in pursuit of perfection</h2>
                  </header>
               </div>
            </article>
            <article>
               <img src="<%=request.getContextPath() %>/img/architecture-1845689_1920.jpg" alt="" />
               <div class="inner">
                  <header>
                     <p>그리스에서의 꿈만 같은 휴가는 어떠신가요?</p>
                     <h2>Rest in Greece</h2>
                  </header>
               </div>
            </article>
            <article>
               <img src="<%=request.getContextPath() %>/img/dublin-1049403_1920.jpg"  alt="" />
               <div class="inner">
                  <header>
                     <p>아름다운 야경과 더블린 더할나위 없는 휴가입니다</p>
                     <h2>A day of Dublin</h2>
                  </header>
               </div>
            </article>
            <article>
               <img src="<%=request.getContextPath() %>/img/slide04.jpg"  alt="" />
               <div class="inner">
                  <header>
                     <p>오로라 보는 팁, 어렵지만 좋은 추억이 될 거에요</p>
                     <h2>the beauty of aurora<h2>
                  </header>
               </div>
            </article>
            <article>
               <img src="<%=request.getContextPath() %>/img/sunset-2699553_1920.jpg"  alt="" />
               <div class="inner">
                  <header>
                     <p>일상에 지치신 분들은 지금 영국! 해가 저물어 가는 다리는 어떠세요?</p>
                     <h2>sutset, bridge</h2>
                  </header>
               </div>
               
            </article>
            
         </section>  

      <!-- One -->
         <section id="one" class="wrapper style2">
            <div class="inner">
               <div class="grid-style">

                  <div>
                     <div class="box">
                        <div class="image fit">
                        <a href="/NA/tripreView/tripreViewContent.do?t_num=${t_num[0]}"><img src="<%=request.getContextPath() %>/img/pic02.jpg" alt="" /></a>      
                        </div>
                        <div class="content">
                           <header class="align-center">  
                              <p>지금 주목할만한 이 곳</p>
                              <h2>어디냐구</h2>  
                           </header>
                           <p> 나만이 아는 곳을 공유하기란 여간 쉬운 일은 아닙니다. 본인만이 아는 곳을 알려준다는건 큰 선물을 받는 것 같은 기분일거에요. 
                           여행가좌 회원님들을 위해 준비한 오키나와의 비밀스러운 여행지! 아직 아는 사람이 많이 없어 프라이빗한 느낌을 주는 이 곳, 확인하세요  </p>
                           <footer class="align-center">
                              <a href="/NA/tripreView/tripreViewContent.do?t_num=${t_num[0]}" class="button alt">Learn More</a>
                           </footer>
                        </div>
                     </div>
                  </div>

                  <div>
                     <div class="box">
                        <div class="image fit">
                        <a href="/semiProject/JY/FestivalDetailForm.do?f_num=1"><img src="<%=request.getContextPath() %>/img/진달래축제.jpg" alt="" /></a>
                        </div>
                        <div class="content">
                           <header class="align-center">
                              <p>인스타 감성사진을 누구보다 잘 찍고싶다면?</p>
                              <h2>종이크래프트 하나!</h2>
                           </header>
                           <p>어딘가를 여행하고 나서 추억을 돌이켜 보았을때 시간이 지나면 흐릿한 경우가 많습니다.
                            하지만 그 지나간 추억을 다시 한번 회귀 시켜주는건 사진이라고 합니다. 
                            중요한 일이 있곤 할때마다 가족들이 들고오던 사진기 처럼 평범하고 지루했던 오늘을 추억으로, 또 사진으로 아름답게 남겨보세요</p>
                           <footer class="align-center">
                              <a href="/JY/FestivalDetailForm.do?f_num=${f_num[0]}" class="button alt">Learn More</a>
                           </footer>
                        </div>
                     </div>
                  </div>

               </div>
            </div>
         </section>

      <!-- Two -->
         <section id="two" class="wrapper style3">
            <div class="inner">
               <header class="align-center">
                  <p>여기 숨쉬는 이 시간은 </p>
                  <h2>나를 어데로 데려갈까 그리고 이 곳은 광고 자리 </h2>
               </header>
            </div>
         </section>

      <!-- Three -->
         <section id="three" class="wrapper style2">
            <div class="inner">
               <header class="align-center">
                  <p class="special">Nam vel ante sit amet libero scelerisque facilisis eleifend vitae urna</p>
                  <h2>지금 주목할 만한 회원들의 직구!</h2>
               </header>
               <div class="gallery">
                  <div>
                     <div class="image fit">
                        <a href="/mj/travelerDetail.do?t_num=${tr_num[0]}"><img src="<%=request.getContextPath() %>/img/hiker-1149898_1920.jpg" alt="" /></a>
                     </div>
                  </div>
                  <div>
                     <div class="image fit">
                        <a href="/mj/travelerDetail.do?t_num=${tr_num[1]}"><img src="<%=request.getContextPath() %>/img/forest-868715_1920.jpg" alt="" /></a>
                     </div>
                  </div>
                  <div>
                     <div class="image fit">
                        <a href="/mj/travelerDetail.do?t_num=${tr_num[0]}"><img src="<%=request.getContextPath() %>/img/fall-1072821_1920.jpg" alt="" /></a>
                     </div>
                  </div>
                  <div>
                     <div class="image fit">
                        <a href="/mj/travelerDetail.do?t_num=${tr_num[1]}"><img src="<%=request.getContextPath() %>/img/charles-bridge-2819533_1920.jpg" alt="" /></a>
                     </div>
                  </div>
               </div>
            </div>
         </section>


      <!-- Footer -->
   <tiles:insertDefinition name="mainfooter" />

      <!-- Scripts --> 
      
         <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
         <script src="<%=request.getContextPath() %>/js/util.js"></script>
         <script src="<%=request.getContextPath() %>/js/main.js"></script>
         
         

   </body>
</html>