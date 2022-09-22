<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<div class="container" style="width: 800px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		<h1>회원 목록</h1>
			<table class="table table-striped table-hover">
				<tr>
					<th>번호</th>
					<th>회원아이디</th>
					<th>회원비밀번호</th>
					<th>회원이름</th>
					<th>회원이메일</th>
					<th>회원주소</th>
					<th>회원등록날짜</th>
					<th>회원상태</th>				
				</tr>
				<c:forEach items="${uList }" var="user" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td><a href="">${user.userId }</a></td>
						<td>${user.userPwd }</td>
						<td>${user.userName }</td>
						<td>${user.userEmail }</td>
						<td>주소</td>
						<td>${user.uEnrollDate }</td>
						<c:if test="${user.uStatus eq 'Y'}">
						<td>가입</td>
						</c:if>
						<c:if test="${user.uStatus eq 'N'}">
						<td>탈퇴</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>