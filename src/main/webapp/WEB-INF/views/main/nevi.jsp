<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
  
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="../resources/css/style.css">
    <!-- Themefisher Icon font -->
    <link rel="stylesheet" href="../resources/plugins/themefisher-font/style.css">
    <!-- bootstrap.min css -->
    <!-- <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css"> -->
    <!-- Slick Carousel -->
    <link rel="stylesheet" href="../resources/plugins/slick/slick.css">
    <link rel="stylesheet" href="../resources/plugins/slick/slick-theme.css">
</head>
<body id="top">

<!-- header start -->
<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <section>
      <div>
        <h1 id="logo"><a href="home.kh"><img src="../resources/images/logo1.png"></a></h1>
      </div>
      <div>
        <form class="clear" method="post" action="#">
          <fieldset>
            <legend>Search:</legend>
            <input type="search" value="" placeholder="Search Here&hellip;">
            <button class="fas fa-search" type="submit" title="Search"><em>Search</em></button>
          </fieldset>
        </form>
      </div>
      <div align="center">
        <h1 id="logo">
           <c:if test="${sessionScope.loginUser eq null }">
             <a href="/user/loginView.kh">LOGIN</a>
          </c:if>
          <c:if test="${not empty loginUser}">
             <div>${sessionScope.loginUser.userId }</div><br>
             <span><a href="/user/myPage.kh">My Page</a></span><br>
             <span><a href="/user/logout.kh">logout</a></span><br>
          </c:if>
      </h1>
      </div>
    </section>
  </header>
</div>
<!-- header End -->

<!-- NavBar Start -->
<div class="wrapper row2">
  <nav id="mainav" class="hoc clear"> 
    
    <ul class="clear">
      <li class="active"><a href="home.kh">Home</a></li>
      <li><a class="drop" href="#">Recipe</a>
        <ul>
          <li><a href="pages/gallery.html">Gallery</a></li>
          <li><a href="pages/full-width.html">Full Width</a></li>
          <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
          <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
          <li><a href="pages/basic-grid.html">Basic Grid</a></li>
          <li><a href="pages/font-icons.html">Font Icons</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">My 냉장고</a>
        <ul>
          <li><a href="#">Level 2</a></li>
          <li><a class="drop" href="#">Level 2 + Drop</a>
            <ul>
              <li><a href="#">Level 3</a></li>
              <li><a href="#">Level 3</a></li>
              <li><a href="#">Level 3</a></li>
            </ul>
          </li>
          <li><a href="#">Level 2</a></li>
        </ul>
      </li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">고객센터</a></li>
      <!-- <li><a href="#">Link Text</a></li>
      <li><a href="#">Long Link Text</a></li> -->
    </ul>
  </nav>
</div>
<!-- NavBar End -->



<!-- slide image Start -->

<div class="hero-slider">
  <div class="slider-item th-fullpage hero-area" style="background-image: url(../resources/images/slider/slider-1.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-center">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">My recipe</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Soul Food,<br>Nothing beats home cooking.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.html">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(../resources/images/slider/slider-2.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-left">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">My recipe</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Mom can cook a mean breakfast.<br> There’s nothing like a homemade meal.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.html">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(../resources/images/slider/slider-3.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-right">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">My recipe</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">I'm an absolutely brilliant cook.<br>These recipes and tips are great!</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.html">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(../resources/images/slider/slider-4.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-left">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">My recipe</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">You’ve got to try this recipe. <br> It’s delicious.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.html">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(../resources/images/slider/slider-5.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-right">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">My recipe</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">I really enjoy cooking these days.<br>Let's have a cook!</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.html">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- slide image End -->

<!-- top으로 올리기  -->
<a id="backtotop" href="#top"><i class="fas fa-chevron-up"></i></a>

<!-- JAVASCRIPTS -->
<script src="../resources/layout/scripts/jquery.min.js"></script>
<script src="../resources/layout/scripts/jquery.backtotop.js"></script>
<script src="../resources/layout/scripts/jquery.mobilemenu.js"></script>

<!-- Main Slide -->
<script src="../resources/plugins/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Touchpin -->
<script src="../resources/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
<!-- Count Down Js -->
<script src="../resources/plugins/syo-timer/build/jquery.syotimer.min.js"></script>
<!-- slick Carousel -->
<script src="../resources/plugins/slick/slick.min.js"></script>
<script src="../resources/plugins/slick/slick-animation.min.js"></script>
<!-- Main Js File -->
<script src="../resources/js/script.js"></script>
</body>
</html>