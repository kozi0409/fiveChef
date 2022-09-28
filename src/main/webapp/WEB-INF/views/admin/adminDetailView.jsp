<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<c:if test="${not empty loginAdmin}">
<div class="container" style="width: 700px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		    <p style="color: #a57625; font-size:34px; font-family:malgun gothic;">[ 마스터 관리자 정보 수정 ]</p>
			<form action="/admin/modify.kh" method="post">
				<input type="hidden" name="page" value="${page }">
				<table class="table table-boardered">
					<tr>
						<th colspan=2 height="1px"></th>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" class="form-control" id="adminId" name="adminId" value="${admin.adminId }"  readonly></td>		
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" class="form-control" name="AdminPwd" value="${admin.adminPwd }"></td>		
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" class="form-control" name="adminName" value="${admin.adminName }" readonly></td>		
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" class="form-control" name="adminEmail" value="${admin.adminEmail }"></td>		
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" class="form-control" name="adminPhone" value="${admin.adminPhone }"></td>		
					</tr>
					
					<tr>
						<th>우편번호</th>
						<td>
							<div style="float:left;">
							<input type="text" name="post" class="form-control postcodify_postcode5" value="${addrInfos[0] }">
							</div>
							<div style="float:left;">
							<button type="button" id="postcodify_search_button">검색</button>
							</div>
						</td>		
					</tr>
					<tr>
						<th>도로명 주소</th>
						<td>
							<input type="text" name="address1" class="form-control postcodify_address" value="${addrInfos[1] }">
						</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td>
							<input type="text" name="address2" class="form-control postcodify_details" value="${addrInfos[2] }">
						</td>
					</tr>
					<tr>
						<th>최종수정일</th>
						<td><input type="text" class="form-control" name="updateDate" value="${admin.updateDate }"></td>		
					</tr>
					<tr>
						<th>관리자코드</th>
						<td><input type="text" class="form-control" name="adminCode" value="${admin.adminCode }"></td>		
					</tr>
					<tr>
						<th>관리자권한</th>
						<td><input type="text" class="form-control" name="adminScope" value="${admin.adminScope }"></td>		
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" class="btn btn-dark" style="background-color: #e79327;" value="수정">
							<button type="button" class="btn btn-dark" style="background-color: #386a94;" onclick="location.href='/admin/adminlist.kh?page=${page}'">목록</button>
						</td>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>
</div>
</c:if>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!-- 실제 데이터가 들어있는 라이브러리 -->
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>
function deleteCheck(adminId, currentPage) {
	if(confirm("삭제하시겠습니까?")) {
		location.href = "/admin/delete.kh?adminId="+adminId +"&page="+currentPage;
		}
	}
	$("#postcodify_search_button").postcodifyPopUp();
</script>
</body>
</html>