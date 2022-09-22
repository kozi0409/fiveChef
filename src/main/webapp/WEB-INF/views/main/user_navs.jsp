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
    	.user {
    		font-size : 20px;
    		text-decoration : none;
			color : rgb(209, 24, 79);	
    	}
    </style>
</head>

<body>

<!-- header start -->
<header id="header" class="hoc clear"> 
    <section>
        <div>
            &nbsp;&nbsp;&nbsp;
          </div>
      <div>
        <h1 id="logo"><a href="#"><img src="../resources/images/logo.png"></a></h1>
      </div>
      <div>
         <div>
        <c:if test="${sessionScope.loginUser eq null }">
      		<a href="/user/loginView.kh" class="user">LOGIN</a>
   		</c:if>
   		<c:if test="${not empty loginUser}">
      		<div>${sessionScope.loginUser.userId }</div><br>
      		<span><a href="/user/logout.kh" class="user">LOGOUT</a></span>
      		<span><a href="/recipe/writeView.kh" class="user">WRITE</a></span>
   		</c:if>
      	</div>
      </div>
    </section>
</header>

<!-- header End -->

<!-- NavBar Start -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #d21853;">
        <div class="container-xl">
          <a class="navbar-brand" href="#">Click Here</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/recipe/recipeList.kh">RECEIPE</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/fridge/myFridge.kh">FRIDGE</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/user/myPage.kh">MY PAGE</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  COMMUNITY
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="/community/communityList.kh">자유 게시판</a></li>
                  <li><a class="dropdown-item" href="#">할인정보 게시판</a></li>
                </ul>
              </li>
            </ul>
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
      
<br>



</body>
</html>