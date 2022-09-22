<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="table-responsive">
	<form action="/notice/register.kh" method="post" enctype="multipart/form-data">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td align="center" width="500">제목</td>
				<td><input type="text" name="noticeTitle" style="width:950px; border:none"></td>
			</tr>
			<tr>
				<td align="center" width="500">작성자</td>
				<td><input type="text" name="noticeWriter" value="${loginAdmin.adminName }" style="width:950px; border:none" readonly></td>
			</tr>
			<tr>
				<td align="center" width="500">내용</td>
				<td><textarea cols="140" rows="20" name="noticeContents" style="border:none"></textarea></td>
			</tr>
			<tr>
				<td align="center" width="500">첨부파일</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="right">
					<button type="submit" class="btn btn-info">등록</button>
					<button type="reset" class="btn btn-danger">취소</button>
				</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>