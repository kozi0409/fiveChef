<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<h3>회원님의 아이디와 가입한 이메일을 적어주세요.</h3>
		<br>
		<form action="/user/findPwd.kh" method="post">
	             <div>
	             	<div><input type="text" name="userId" placeholder="아이디를 입력해주세요."></div>
	                <div><input type="text" name="userEmail" placeholder="이메일을 입력해주세요."></div>
	                <button type="submit" class="btn" id="findPwd">비밀번호 찾기</button>
	             </div>
	   	</form>
</body>
</html>