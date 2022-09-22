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
            &nbsp;&nbsp;&nbsp;
          </div>
      <div>
        <h1 id="logo"><a href="#"><img src="../resources/images/logo.png"></a></h1>
      </div>
      <div>
         <div>
        <c:if test="${sessionScope.loginUser eq null }">
      <a href="/user/loginView.kh">LOGIN</a>
   </c:if>
   <c:if test="${not empty loginUser}">
      <div>${sessionScope.loginUser.userId }</div><br>
      <span><a href="/user/myPage.kh">My Page</a></span><br>
      <span><a href="/user/logout.kh">logout</a></span><br>
   </c:if>

      </div>
      </div>
    </section>
</header>

<!-- header End -->

<!-- NavBar Start -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #d21853;">
        <div class="container-xl">
          <a class="navbar-brand" href="#">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
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