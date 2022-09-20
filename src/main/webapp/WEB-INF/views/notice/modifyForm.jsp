<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1 align="center">${notice.noticeNo }번 게시글 수정하기</h1>
	<br>
	<form action="/notice/modify.kh" method="post" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<input type="hidden" name="noticeFilename" value="${notice.noticeFilename }">
		<input type="hidden" name="noticeFileRename" value="${notice.noticeFileRename }">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle" value="${notice.noticeTitle }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="noticeWriter" value="${notice.noticeWriter }" readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="7" name="noticeContents">${notice.noticeContents }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="reloadFile">
					<a href="#">${notice.noticeFilename }</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<a href="/notice/list.kh">목록으로</a>
					<a href="javascript:history.go(-1);">이전 페이지로</a> <!-- function으로 할거면 history.go(-1)만 -->
				</td>
			</tr>
		</table>
	</form>
</body>
</html>