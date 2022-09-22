<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    

    

<link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


    <style>

	  .form-control {
	  	height : 60px;
		width : 30%;
		margin : auto;
	  }
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

	  [id^=find] {
		text-decoration : none;
		color : gray;	
	  }

	  .btn-1 {
		border: 0;
		background-color : rgb(209, 24, 79);
		color : white;
		border-radius : 10px;
		height : 50px;
		width : 100px;
	}

	.btn-2 {
		border: 0;
		color : rgb(209, 24, 79);
		background-color : rgb(217, 209, 209);
		border-radius : 10px;
		height : 50px;
		width : 100px;
	}
<<<<<<< HEAD
    </style>

    
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
  <br><br><br><br>
<main class="form-signin w-100 m-auto">
  <form action="/user/login.kh" method="post" >
    <a href="/"><img class="mb-4" src="../../../resources/images/logo1.png" alt="" width="200" height="160"></a>
    <br><br><br>
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating-center">
      <input type="text" class="form-control" id="floatingInput"  name="user-id" placeholder="ID">

</style>
</head>
<body>

   <div class="login-area">
   	<div class = "header">
	   <h1 align="center">
	   <br><br>
	      <a href="home.kh">냉장고 Chef</a>
	   </h1>
   	</div>
   	<div class = "body" align="center" width="300">
      <form action="/user/login.kh" method="post">
          <div class="login_box">
             <div>
                <div><input type="text" name="user-id" placeholder="아이디"></div>
             </div>
             <div>
                <div><input type="password" name="user-pwd" placeholder="비밀번호"></div>
             </div>
          </div>
                <div>
                	<button type="submit" class="btn" id="login">로그인</button>
                	<button type="button" class="btn" id="join" onclick="joinUser()">회원가입</button>
                </div>
      </form>
      <ul class="find_wrap">
      	<li>
      		<a target="_blank" href="/user/findIdView.kh" class="find_id" id ="find_id">아이디 찾기</a>
      	</li>
      	<li>
      		<a target="_blank" href="#" class="find_pwd" id ="find_pwd">비밀번호 찾기</a>
      	</li>
      </ul>

    </div>

    <div class="form-floating-center">
      <input type="password" class="form-control" id="floatingPassword" name="user-pwd" placeholder="Password">
    </div>

    <div class="checkbox mb-3">
		<a target="_blank" href="/user/findIdView.kh" class="find_id" id ="find_id">아이디 찾기</a>
		<a target="_blank" href="/user/findPwdView.kh" class="find_pwd" id ="find_pwd">비밀번호 찾기</a>
    </div>
	<div>
		<button type="submit" class="btn-1" id="login">로그인</button>
		<button type="button" class="btn-2" id="join" onclick="joinUser()">회원가입</button>
	</div>
    <p class="mt-5 mb-3 text-muted">&copy; Copyright 2022- All right Reserved - 팀 요리조리</p>
  </form>
</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
	function joinUser() {
	   location.href = "/user/userJoinView.kh";
	}
 </script>

   </div>
   <script>
      function joinUser() {
         location.href = "/user/userJoinView.kh";
      }
      
   </script>
</body>

</html>