<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지회원 목록</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<div class="container" style="width: 80%; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		<h1>홈페이지회원 목록</h1>
			<table class="table table-striped table-hover">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>등록날짜</th>
					<th>상태</th>	
					<th>수정</th>
					<th>삭제</th>			
				</tr>
				<c:if test="${!empty uList }">
					<c:forEach items="${uList }" var="user" varStatus="i">
						<tr>
							<td>${i.count }</td>
							<td><a href="/admin/userDetail.kh?userId=${user.userId }&page=${currentPage }">${user.userId }</a></td>
							<td>${user.userPwd }</td>
							<td>${user.userName }</td>
							<td>${user.userEmail }</td>
							<td>${user.uEnrollDate }</td>
							<c:if test="${user.uStatus eq 'Y'}">
							<td>가입</td>
							</c:if>
							<c:if test="${user.uStatus eq 'N'}">
							<td>탈퇴</td>
							</c:if>
							<td><button type="button" class="btn btn-primary btn-sm" style="background-color: #4d61fb;" onclick ="location.href = '/user/detail.kh?userId=${user.userId }&page=${currentPage }';">수정</button></td>
							<td><button type="button" class="btn btn-secondary btn-sm" style="background-color: #fb4d7e;" onclick="deleteCheck('${user.userId }',${currentPage })">삭제</button></td>
						</tr>
					</c:forEach>
							<tr align="center" height="20">
							<td colspan="11">
								<c:if test="${currentPage != 1 }">
									<a href="/admin/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[이전]</a>
								</c:if>
								<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
									<c:if test="${currentPage eq p }">
										<b>${p }</b>
									</c:if>
									<c:if test="${currentPage ne p }">
										<a href="/admin/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a>
									</c:if>
								</c:forEach>
								<c:if test="${maxPage > currentPage }">
									<a href="/admin/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[다음]</a>
								</c:if>
							</td>
						</tr>
					</c:if>
					<c:if test="${empty uList }">
			<tr>
				<td colspan="10" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
			</c:if>
			<tr>
				<td colspan="10" align="center">
					<form action="/admin/search.kh" method="get">
						<div style= "display: inline-block">
						<select name="searchCondition">
							<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
							<option value="userId" <c:if test="${searchCondition eq 'userId' }">selected</c:if>>아이디</option>
							<option value="userName" <c:if test="${searchCondition eq 'userName' }">selected</c:if>>이름</option>
							<option value="userPhone" <c:if test="${searchCondition eq 'userAddr' }">selected</c:if>>전화번호</option>
						</select>
						</div>
						<div style= "display: inline-block">
						<input type="text" name="searchValue" value="${searchValue }">
						</div>
						<div style= "display: inline-block">
						<input type="submit" value="검색">
						</div>
					</form>
				</td>
			</tr>
		</table>
		</div>
	</div>
</div>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>
<script>
	function deleteCheck(userId, currentPage) {
		if(confirm("삭제하시겠습니까?")) {
			location.href = "/admin/deleteUser.kh?userId="+userId +"&page="+currentPage;
		}
	}
</script>
</body>
</html>