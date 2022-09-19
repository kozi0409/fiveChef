<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1 align="center">공지사항 등록 페이지</h1>
	<form action="/notice/register.kh" method="post" enctype="multipart/form-data">
		<table align="center" border="1">
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="noticeTitle" style="width:758px;"></td>
			</tr>
			<tr>
				<td align="center">작성자</td>
				<td><input type="text" name="noticeWriter" value="" style="width:758px;" readonly></td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td><textarea cols="100" rows="20" name="noticeContents"></textarea></td>
			</tr>
			<tr>
				<td align="center">첨부파일</td>
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
</body>
</html>