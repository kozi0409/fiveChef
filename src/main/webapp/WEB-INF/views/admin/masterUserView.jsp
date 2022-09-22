<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터페이지</title>
 <link rel="stylesheet" href="../resources/plugins/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<div class="container" style="width: 600px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		    <h2>홈페이지회원 정보 수정</h2>
			<form action="/admin/userModify.kh" method="post">
				<input type="hidden" name="page" value="${page }">
				<table class="table table-boardered">
					<tr>
						<th>아이디</th>
						<td><input type="text" class="form-control" id="userId" name="userId" value="${user.userId }"  readonly></td>		
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" class="form-control" name="userPwd" value="${user.userPwd }"></td>		
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" class="form-control" name="userName" value="${user.userName }" ></td>		
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" class="form-control" name="userEmail" value="${user.userEmail }"></td>		
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" class="form-control" name="userPhone" value="${user.userPhone }"></td>		
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="text" class="form-control" name="userCode" value="${user.userBirth }" readonly></td>		
					</tr>
					<tr>
						<th>회원상태</th>
						<c:if test="${user.uStatus eq 'Y'}">
							<td><input type="text" class="form-control" name="" value="가입" readonly></td>
						</c:if>
						<c:if test="${user.uStatus eq 'N'}">
							<td><input type="text" class="form-control" name="" value="탈퇴" readonly></td>	
						</c:if>	
					</tr>
					<tr>
						<th>등록날짜</th>
						<td><input type="text" class="form-control" name="uStatus" value="${user.uEnrollDate }" readonly></td>		
					</tr>		
					<tr>
						<td colspan="2">
							<input type="submit" class="btn btn-primary" value="수정하기">
							<button type="button" class="btn btn-danger" onclick="deleteCheck('${user.userId }',${currentPage })">삭제하기</button>
						</td>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>
</div>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!-- 실제 데이터가 들어있는 라이브러리 -->
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>
function deleteCheck(userId, currentPage) {
	if(confirm("삭제하시겠습니까?")) {
		location.href = "/admin/delete.kh?userId="+userId +"&page="+currentPage;
		}
	}
	$("#postcodify_search_button").postcodifyPopUp();
</script>
</body>
</html>