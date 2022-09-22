<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%-- 	<h1 align="center">${notice.noticeNo }번 게시글 수정하기</h1> --%>
<!-- 	<br> -->
<div class="container">
<div class="table-responsive">
	<form action="/notice/modify.kh" method="post" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<input type="hidden" name="noticeFilename" value="${notice.noticeFilename }">
		<input type="hidden" name="noticeFileRename" value="${notice.noticeFileRename }">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td align="center" width="200">제목</td>
				<td><input type="text" name="noticeTitle" value="${notice.noticeTitle }" style="width:950px; border:none"></td>
			</tr>
			<tr>
				<td align="center" width="200">작성자</td>
				<td><input type="text" name="noticeWriter" value="${notice.noticeWriter }" style="width:950px; border:none" readonly></td>
			</tr>
			<tr>
				<td align="center" width="200">내용</td>
				<td><textarea cols="140" rows="20" name="noticeContents" style="border:none">${notice.noticeContents }</textarea></td>
			</tr>
			<tr>
				<td align="center" width="200">첨부파일</td>
				<td><input type="file" name="reloadFile">
					<a href="#">${notice.noticeFilename }</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
<!-- 					<input type="submit" value="수정"> -->
					<button type="submit" class="btn btn-info">수정</button>
					<button type="button" onclick="location.href='/notice/list.kh';" class="btn btn-secondary">목록으로</button>
					<button type="button" onclick="location.href='javascript:history.go(-1)';" class="btn btn-danger">이전 페이지로</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>