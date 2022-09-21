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
		<h1 align="center">${qna.questionNo }번 게시글 상세 보기</h1>
	<br><br>
	<table align="center" width="500" border="1">
		<tr>
				<td>제목</td>
				<td>${qna.questionTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${qna.questionWriter }</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${qna.qEnrollDate }</td>
			</tr>
			<tr height="300">
				<td>내용</td>
				<td>${qna.questionContents }
				</td>
			</tr>
			<tr height="50">
				<td>첨부파일</td>
				<td>
			<!--  <img alt="본문이미지" src="/resources/buploadFiles/${board.boardFileRename }" width="300" height="300">  -->
				</td>
			</tr>
			<tr>
			<c:if test="${!empty qna.answerContents }">
				<td>답변내용</td>
				<td>${qna.answerContents }</td>
			</c:if>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="/qna/list.kh">목록으로</a>
				</td>
			</tr>
	</table>

</body>
</html>