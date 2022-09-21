<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 정보</title>
</head>
<body>
	<h1 align="center">${community.communityNo }번 게시글 상세 보기</h1>
	<br><br>
	<table align="center" width="500" border="1">
		<tr>
				<td>제목</td>
				<td>${community.communityTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${community.communityWriter }</td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${community.cEnrollDate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${community.boardCount }</td>
			</tr>
			<tr height="300">
				<td>내용</td>
				<td>${community.communityContents }
				</td>
			</tr>
			<tr height="300">
				<td>첨부파일</td>
				<td>
					<!--  <img alt="본문이미지" src="/resources/buploadFiles/${board.boardFileRename }" width="300" height="300"> -->
				</td>
			</tr>
			<c:if test="${loginUser.userId eq community.communityWriter}">
			<tr>
				<td colspan="2" align="center">
				<a href="/community/communityModifyView.kh?communityNo=${community.communityNo }&page=${page}">수정</a>
				<a href="#" onclick="communityRemove(${page});">삭제</a>
				</td>
			</tr>
			</c:if>
	</table>
	<script>
		function communityRemove(value) {
			event.preventDefault(); //하이퍼링크 이동 방지
			if(confirm("게시물을 삭제하시겠습니까?")) {
				location.href="/community/communityRemove.kh?page=" + value;
			}
		}
	</script>
</body>
</html>