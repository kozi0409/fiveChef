<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 <link rel="stylesheet" href="../resources/plugins/bootstrap/css/bootstrap.min.css">
</head>
<body>
<%-- <jsp:include page="/admin.kh"></jsp:include> --%>
<div align="center">
	<h1 align="center">회원정보 수정</h1>
	<img class="../resources/images/team-1.jpg" src="../resources/images/team-1.jpg">
					<h4>Jonathon Andrew</h4>
					<p>Founder</p>
	<div class="">
		<form action="/admin/modify.kh" method="post">
			<table>
				<tr>
					<th> * 아이디</td>
					<td>
						<input type="text" id="adminId" name="adminId" value="${admin.adminId }"  readonly>
					</td>
				</tr>
				<tr>
					<th> * 비밀번호</td>
					<td>
						<input type="password" name="adminPwd">
					</td>
				</tr>
				<tr>
					<th> * 이름</td>
					<td>
						<input type="text" name="adminName" value="${admin.adminName }" readonly>
					</td>
				</tr>				
				<tr>
					<th> * 이메일</td>
					<td>
						<input type="text" name="adminEmail" value="${admin.adminEmail }">
					</td>
				</tr>	
				<tr>
					<th> * 전화번호</td>
					<td>
						<input type="text" name="adminPhone" value="${admin.adminPhone }">
					</td>
				</tr>
				<tr>
					<th>우편번호</td>
					<td>
						<input type="text" name="post" class="postcodify_postcode5" value="${addrInfos[0] }">
						<button type="button" id="postcodify_search_button">검색</button><br />
					</td>
				</tr>
				<tr>
					<th>도로명 주소</td>
					<td>
						<input type="text" name="address1" class="postcodify_address" value="${addrInfos[1] }">
					</td>
				</tr>
				<tr>
					<th>상세주소</td>
					<td>
						<input type="text" name="address2" class="postcodify_details" value="${addrInfos[2] }">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기">
						<button type="button" onclick="removeAdmin();">탈퇴하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<!-- 실제 데이터가 들어있는 라이브러리 -->
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		function removeAdmin() {
			if(confirm("탈퇴하시겠습니까?")) {
				location.href = "/admin/remove.kh";
			}
		}
		$("#postcodify_search_button").postcodifyPopUp();
	</script>
</body>
</html>