<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시글 등록 페이지</h1>
	<br><br>
	<form action="/community/commRegist.kh" method="post">
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="communityTitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="communityWriter" value="${loginUser.userId }" readonly></td>
			</tr>
			<tr>
				<td>게시판 유형</td>
				<td>
					<select name="cBoardCode" class="code-select">
						<option value="free">자유게시판</option>
						<option value="sale">할인정보게시판</option>
					</select>
				</td>
			</tr>
			<tr>
			
				<td>할인가격</td>
				<td><input type="text" name="communityPrice">
				판매 사이트
				<input type="text" name="communitySalePage"></td>	
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="20" name="communityContents"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<script>
		
	</script>
</body>
</html>