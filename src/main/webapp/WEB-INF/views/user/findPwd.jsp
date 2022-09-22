<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
	#find-text {
		width : 200px;
	}
	.btn {
		border: 0;
		background-color : rgb(209, 24, 79);
		color : white;
		border-radius : 10px;
		height : 50px;
		width : 100px;
	}
</style>
</head>
<body>
<br><br><br>
	<div align="center">
	<a href="/" ><img  src="../../../resources/images/logo1.png" alt="" width="200" height="160">
	</a></div>
	<br><br><br><br>
	<h3 align="center">회원님의 아이디와 가입한 이메일을 적어주세요.</h3>
		<br><br><br>
		<form action="/user/findPwd.kh" method="post" align="center">
	             <div>
	             	<div><input type="text" name="userId" id="find-text" placeholder="아이디를 입력해주세요."></div>
	                <div><input type="text" name="userEmail"  id="find-text" placeholder="이메일을 입력해주세요."></div><br>
	                <button type="submit" class="btn" id="findPwd">비밀번호 찾기</button>
	             </div>
	   	</form>
</body>
</html>