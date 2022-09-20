<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 문의글</title>
</head>
<body>
	<h1>${loginUser.userId}님의 문의 글</h1>
	<h2 align="center">게시글 목록</h2><br><br>
	<table align = "center" border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>답변상태</th>
		</tr>
		<c:if test="${empty bList }">
			<tr>
				<td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
		<c:if test="${!empty qList }">
			<c:forEach items="${qList }" var="qna" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td><a href="/qna/detail.kh?questionNo=${qna.questionNo }&page=${currentPage }">${qna.questionTitle }</a></td>
					<td>${qna.questionWriter }</td>
					<td>${qna.qEnrollDate }</td>
					<td>
						<c:if test="${qna.answerStatus != 'Y' }">
							답변완료
						</c:if>
						<c:if test="${qna.answerStatus == 'Y' }">
							답변대기
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>