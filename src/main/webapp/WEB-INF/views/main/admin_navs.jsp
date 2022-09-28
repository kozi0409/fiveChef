<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
   
    <link href="../resources/css/layout.css"" rel="stylesheet">
    <link href="../resources/css/bootstrap.min.css"" rel="stylesheet">
    <style>
	body{
	  font-family: "Helvetica Nene", Helvetica, Arial, 맑은 고딕;,"malgun gothic", sans-serif;
	  
	  .d-block w-100 {
	  	resize: both;
	  	height: 200px;
	  	width: 100%;
	  }
	}
	
	@keyframes blink-effect {
		50% {
		    opacity: 0;
		}
	}
		
	.blink {
	 	animation: blink-effect 1s step-end infinite;
	 }
	</style>
</head>
<body>
<a name="Top"></a>
<!-- header start -->
<header id="header" class="hoc clear"> 
    <section>
		<div>
		    <a href="/" style="text-decoration-line: none;"><p style="color: #ed436d; font-size:20px; font-weight: bold;" "font-family:malgun gothic;">냉장고Chef Home</p></a>
		</div>
	<c:if test="${sessionScope.loginAdmin eq null }">
		<div>
		  <a href="/admin.kh"><img src="../resources/images/logo2.png"></a>
		</div>
		<div>
         <div>
      		<a href="/admin/loginView.kh" style="text-decoration-line: none;"><p class="blink" style="color: #ed436d; font-size:20px; font-weight: bold;">관리자만 사용할 수 있습니다.<br> LOGIN하세요.</p></a>
   	</c:if>
   	<c:if test="${not empty loginAdmin}" >
   		<div>
		  <a href="/home.kh"><img src="../resources/images/logo2.png"></a>
		</div>
		<div>
      		<div><p p style="color: #202c87; font-size:20px; font-weight: bold;" "font-family:malgun gothic;">${sessionScope.loginAdmin.adminId } 님이 로그인하셨습니다.</p></div><br>
      		<span><a href="/admin/logout.kh" class="user">로그아웃</a></span>
      		<span><a href="/admin/myPage.kh" class="user">정보수정</a></span>
      	</div>
   	</c:if>
      </div>
    </section>
</header>
<!-- header End -->

<!-- NavBar Start -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #202c87;">
	<div class="container-xl">
		<a class="navbar-brand" href="/admin/adminlist.kh">fiveChef</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/admin/userlist.kh" >회원관리</a>
				</li>
				<li class="nav-item">
				  	<a class="nav-link active" aria-current="page" href="/notice/list.kh">공지사항관리</a>
				</li>
				<li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                 게시판관리
                </a>
                <ul class="dropdown-menu  active" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="/communitymanage/list.kh">커뮤니티 게시판관리</a></li>
                  <li><a class="dropdown-item" href="/recipemanage/list.kh">레시피 게시판관리</a></li>
                </ul>
              </li>
              <li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  댓글관리
                </a>
                <ul class="dropdown-menu  active" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="/communityreplymanage/list.kh">커뮤니티 댓글관리</a></li>
                  <li><a class="dropdown-item" href="/recipereplymanage/list.kh">레시피 댓글관리</a></li>
                </ul>
              </li>
				<li class="nav-item">
					<a class="nav-link active" href="/admin/qnalist.kh">Q&A</a>
				</li>
			</ul>
			<!-- Search Start  -->
			<!-- <form class="d-flex">
			  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			  <button class="btn btn-outline-success" type="submit">Search</button>
			</form> -->
			<!-- Search End -->
		</div>
	</div>
</nav>
<!-- NavBar End -->
<!-- slide image Start -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
		<div class="carousel-item active">
	         <img src="../resources/images/slider/slider-4.jpg" class="d-block w-100" alt="..." >
	          <div class="carousel-caption d-none d-md-block">
	              <h1>First slide label</h1>
	              <p>Some representative placeholder content for the first slide.</p>
	          </div>
        </div>
        <div class="carousel-item">
	         <img src="../resources/images/slider/slider-5.jpg" class="d-block w-100" alt="...">
	          <div class="carousel-caption d-none d-md-block">
	              <h1>Second slide label</h1>
	              <p>Some representative placeholder content for the second slide.</p>
	          </div>
        </div>
        <div class="carousel-item">
	         <img src="../resources/images/slider/slider-6.jpg" class="d-block w-100" alt="...">
	          <div class="carousel-caption d-none d-md-block">
	              <h1>Third slide label</h1>
	              <p>Some representative placeholder content for the third slide.</p>
	          </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<!-- slide image End -->
<br>


</body>
</html>