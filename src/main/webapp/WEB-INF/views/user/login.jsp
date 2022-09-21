<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style>
	.find_wrap li {
		color : black;
		text-decoration : none;
		padding_left: 28px;
		position : relative;
		display : inline-block;
	}
	
	.btn {
		border : 0;
		background-color : rgb(209, 24, 79);
		color : white;
		font-size : 11px;
		padding : 12px 17px;
		border-radius : 10px;
	}
	
	[id^=find] {
		text-decoration : none;
		color : gray;		
	}
	
	.find_wrap {
		align : center;
	}
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
      		<a target="_blank" href="/user/findPwdView.kh" class="find_pwd" id ="find_pwd">비밀번호 찾기</a>
      	</li>
      </ul>
    </div>
   </div>
   <script>
      function joinUser() {
         location.href = "/user/userJoinView.kh";
      }
      
   </script>
</body>
</html>