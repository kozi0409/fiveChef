<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <jsp:include page="/admin.kh"></jsp:include> --%>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<div class="container" style="width: 600px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		    <h2>회원가입</h2>
			<form action="/admin/adminRegister.kh" method="post">
				<table class="table table-boardered">
					<tr>
						<th>아이디</th>
						<td><input type="text" class="form-control" name="adminId" placeholder="id를 넣으세요"></td>		
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" class="form-control" name="AdminPwd" placeholder="비밀번호는 영문만 넣어주세요"></td>		
					</tr>
					<tr>
						<th>패스워드확인</th>
						<td><input type="password" class="form-control" name=""></td>		
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" class="form-control" name="adminName"></td>		
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" class="form-control" name="adminEmail"></td>		
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" class="form-control" name="adminPhone"></td>		
					</tr>
					
					<tr>
						<th>우편번호</th>
						<td>
							<div style="float:left;">
							<input type="text" name="post" class="form-control postcodify_postcode5" value="">
							</div>
							<div style="float:left;">
							<button type="button" id="postcodify_search_button">검색</button>
							</div>
						</td>		
					</tr>
					<tr>
						<th>도로명 주소</th>
						<td>
							<input type="text" name="address1" class="form-control postcodify_address" value="">
						</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td>
							<input type="text" name="address2" class="form-control postcodify_details" value="">
						</td>
					</tr>
		
					
					<tr>
						<td colspan="2">
						<input type="submit" class="btn btn-primary" value="전송">
						<input type="reset" class="btn btn-danger" value="취소">
						</td>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>
</div>

<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>

	<jsp:include page="../main/footer.jsp"></jsp:include>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- 실제 데이터가 들어있는 라이브러리 -->
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script> 
		$(function() { 
			$("#postcodify_search_button").postcodifyPopUp(); 
		}); 
	</script>
</body>
</html>