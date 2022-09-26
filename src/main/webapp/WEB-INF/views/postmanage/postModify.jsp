<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>관리자 커뮤니티 게시판 수정</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	#cl { background-color: #F9FFFF; }
</style>
</head>
<body>
<div class="container">
<div class="table-responsive">
	<form action="/postmanage/modify.kh" method="post">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="communityNo" value="${community.communityNo}">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td id="cl" align="center" width="200">제목</td>
				<td><input type="text" name="communityTitle" value="${community.communityTitle }" style="width:100%;"></td>
			</tr>
			<tr>
				<td id="cl" align="center" width="200">작성자</td>
				<td><input type="text" name="communityWriter" value="${community.communityWriter }" style="width:100%; border:none" readonly></td>
			</tr>
			<tr>
				<td id="cl" align="center" width="200">내용</td>
				<td><textarea cols="140" rows="20" name="communityContents">${community.communityContents }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info">수정 완료</button>
					<button type="button" onclick="location.href='/postmanage/list.kh';" class="btn btn-secondary">목록으로</button>
					<button type="button" onclick="location.href='javascript:history.go(-1)';" class="btn btn-danger">이전 페이지로</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>