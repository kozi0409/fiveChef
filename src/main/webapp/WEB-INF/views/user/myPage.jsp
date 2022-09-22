<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h1 align="center">
	 <a href="/home.kh">냉장고 Chef</a></h1>
	<h3>${sessionScope.loginUser.userId }님 환영합니다.</h3>
	<br>
	<h5>회원정보</h5>
	<div class="">
			<form action="/user/modify.kh" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" id="userId" name="userId" value="${user.userId }" readonly>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="userPwd" value="${user.userPwd }">
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input type="text" name="userName" value="${user.userName }" readonly>
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>
							<input type="text" name="userPhone" value="${user.userPhone }">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="userEmail" value="${user.userEmail }" readonly>
						</td>
					</tr>	
					<tr>
						<td> 생년월일</td>
						<td>
							<input type="text" name="userBirth" value="${user.userBirth }" readonly>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="수정하기">
							<button type="button" onclick="removeMember()">탈퇴하기</button>
							<!--  button에 type을 적어줘야 오류가 나지 않음!! -->
						</td>
					</tr>
				</table>
			</form>
		</div>
		<script>
			function removeMember() {
				if(confirm("탈퇴 하시겠습니까?")) {
					location.href = "/user/remove.kh";
				}
			}
		</script>
</body>
</html>