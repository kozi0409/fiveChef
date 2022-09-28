<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자회원 목록</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<c:if test="${not empty loginAdmin}">
<div class="container" style="width: 80%;">
	<div class="row">
		<div class="col-sm-12 text-center" >
			<p style="color: #a57625; font-size:34px; font-family:malgun gothic;">[ 관리자회원 목록 ]</p></h1>
			<table class="table table-striped table-hover">
				<!--  검색 바 Start -->
				<tr>
					<td colspan="11" align="center">
						<form action="/admin/searchAdmin.kh" method="get">
							<div style= "display: inline-block">
							<select name="searchCondition">
								<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
								<option value="Id" <c:if test="${searchCondition eq 'Id' }">selected</c:if>>아이디</option>
								<option value="Name" <c:if test="${searchCondition eq 'Name' }">selected</c:if>>이름</option>
							</select>
							</div>
							<div style= "display: inline-block">
							<input type="text" name="searchValue" value="${searchValue }">
							</div>
							<div style= "display: inline-block">
							<input type="submit" value="검색">
							</div>
							<div style= "display: inline-block">
							<input type="button" value="전체목록" onclick="location = '/admin/adminlist.kh?page=${page}'">
							</div>
						</form>
					</td>
				</tr>
				<!--  검색 바 End -->
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>등록날짜</th>
					<th>최종수정일</th>
					<th>관리자권한</th>	
					<th>관리자업무</th>	
					<th>수정</th>
					<th>삭제</th>			
				</tr>
			<c:if test="${!empty aList }">
				<c:forEach items="${aList }" var="admin" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td><a href="/admin/adminDetail.kh?adminId=${admin.adminId }&page=${currentPage }">${admin.adminId }</a></td>
						<td>${admin.adminPwd }</td>
						<td>${admin.adminName }</td>
						<td>${admin.regdate }</td>
						<td>${admin.updateDate }</td>
						<td>${admin.adminCode }</td>
						<td>${admin.adminScope }</td>
						<td><button type="button" class="btn btn-dark btn-sm" style="background-color: #e79327;" onclick ="location.href = '/admin/adminDetail.kh?adminId=${admin.adminId }&page=${currentPage }';">수정</button></td>
						<td><button type="button" class="btn btn-dark btn-sm" style="background-color: #386a94;" onclick="deleteCheck('${admin.adminId }',${currentPage })">삭제</button></td>
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
			<c:if test="${empty aList }">
			<tr>
				<td colspan="11" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
			</c:if>
			
		</table>
		</div>
	</div>
</div>
<br>
</c:if>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>
<script>
	function deleteCheck(adminId, currentPage) {
		if(confirm("삭제하시겠습니까?")) {
			location.href = "/admin/delete.kh?adminId="+adminId +"&page="+currentPage;
		}
	}
</script>
</body>
</html>