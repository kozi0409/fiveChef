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
<div class="container" style="width: 1200px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		<h1>관리자 목록</h1>
			<table class="table table-striped table-hover">
				<tr>
					<th>번호</th>
					<th>관리자아이디</th>
					<th>관리자비밀번호</th>
					<th>관리자이름</th>
					<th>관리자이메일</th>
					<th>관리자주소</th>
					<th>관리자등록날짜</th>
					<th>관리자권한</th>	
					<th>관리자엄무</th>	
					<th>수정</th>
					<th>삭제</th>			
				</tr>
				<c:forEach items="${aList }" var="admin" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td><a href="/admin/myPage.kh?adminId=${admin.adminId }">${admin.adminId }</a></td>
						<td>${admin.adminPwd }</td>
						<td>${admin.adminName }</td>
						<td>${admin.adminEmail }</td>
						<td>${admin.adminAddr }</td>
						<td>${admin.regdate }</td>
						<td><a href="">${admin.adminCode }</a></td>
						<td><a href="">${admin.adminScope }</a></td>
						<td><button type="button" class="btn btn-primary btn-sm" style="background-color: #4d61fb;" onclick ="location.href = '/admin/myPage.kh?adminId=${admin.adminId }';">수정</button></td>
						<td><button type="button" class="btn btn-secondary btn-sm" style="background-color: #fb4d7e;">삭제</button></td>
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