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
</head>
<body>

<!-- header start -->
<header id="header" class="hoc clear"> 
    <section>
        <div>
            <a href="/"><h3 style="font-family:Nanum Gothic;">5Chef Home</h1></a>
         </div>
      <div>
        <h1 id="logo"><a href="/admin.kh"><img src="../resources/images/logo2.png"></a></h1>
      </div>
      <div>
      <div align="center">
		<div>
		<c:if test="${sessionScope.loginAdmin eq null }">
			<form action="/admin/login.kh" method="post">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" name="adminId"></td>
						<td rowspan="2">
							<input type="submit" value="로그인">
						</td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" name="adminPwd"></td>
						
					</tr>
					<tr>
						<th colspan="3"><a href="/admin/adminJoinView.kh">회원가입</a></th>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${not empty loginAdmin }">
		<table align="right">
				<tr>
					<td colspan="2">${sessionScope.loginAdmin.adminName }님이 로그인했습니다.</td>
<!-- 					<td></td> -->
				</tr>
				<tr>
					<td><a href="/admin/myPage.kh">정보수정</a></td>
					<td><a href="/admin/logout.kh">로그아웃</a></td>
				</tr>
			</table>
		</c:if>	
		</div>
		</h1>
       </div>
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
                <a class="nav-link dropdown-toggle active" aria-current="page" href="/admin/userlist.kh" >회원관리</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/notice/list.kh">공지사항관리</a>
              </li>
              <li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                 게시판관리
                </a>
                <ul class="dropdown-menu  active" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="/postmanage/list.kh">커뮤니티 게시판관리</a></li>
                  <li><a class="dropdown-item" href="/recipemanage/list.kh">레시피 게시판관리</a></li>
                </ul>
              </li>
              <li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  댓글관리
                </a>
                <ul class="dropdown-menu  active" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
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