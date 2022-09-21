<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1 align="center">${community.communityNo }번 게시글 수정</h1>
	<br>
	<form action="/community/communityModify.kh" method="post">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" name="communityNo" value="${community.communityNo }">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="communityTitle" value="${community.communityTitle }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="communityWriter"value="${community.communityWriter }" readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="7" name="communityContents">${community.communityContents }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<a href="/community/communityList.kh">목록으로</a>
					<a href="javascript:history.go(-1);">이전 페이지</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>