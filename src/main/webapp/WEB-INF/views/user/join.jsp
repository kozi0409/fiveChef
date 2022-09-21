<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 본인인증</title>
</head>
<body>
<!-- nevi bar를 넣어주세요-->
<%-- <jsp:include page=" "></jsp:include> --%>
<!-- nevi bar -->
<br>
	<h1 align="center">
		<a href="home.kh">냉장고 Chef</a>
	</h1>
	<br>
	<form id="join_form" method="post" action="/user/register.kh" >
		<label>아이디</label>
		<div class="id-box">
			<input type="text" id="userId" name="userId" placeholder="영문 숫자 조합 6~20자" maxlength="20">
		</div>
		<br>
		<label>비밀번호</label>
		<div class="password-box">
			<input type="password" id="userPwd" name="userPwd" placeholder="영문 숫자 조합 6~20자" maxlength="20">
		</div>
		<br>
		<label>이름</label>
		<div class="name-box">
			<input type="text" id="userName" name="userName">
		</div>
		<br>
		<label>전화번호</label>
		<div class="phone-box">
			<input type="text" id="userPhone" name="userPhone" placeholder="'-'을 제외한 숫자만 입력">
		</div>
		<br>
		<label>이메일</label>
		<div class="email-box">
			<input type="text" id="userEmail" name="userEmail" >
			<a href="#" class="btn" role="button">
				<span class>인증번호 받기</span>
			</a>
		</div>
		<br>
		<label>생년월일</label>
		<div class="birth-box">
			<input type="text" id="userBirth" name="userBirth" placeholder="ex)2000-01-01">
		</div>
		
		<br>
		<button type="submit">가입하기</button>
	</form>
<br>
<!-- footer를 넣어주세요. -->
<jsp:include page="../main/footer.jsp"></jsp:include>
<!-- footer를 넣어주세요. -->
</body>
</html>