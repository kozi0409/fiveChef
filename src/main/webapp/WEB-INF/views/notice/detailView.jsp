<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 align="center">${notice.noticeNo }번 공지사항 상세 보기</h1>
	<br><br>
	<table align="center" width="500" border="1">
		<tr>
			<td>제목</td>
			<td>${notice.noticeTitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${notice.noticeWriter }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${notice.nCreateDate}"/></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${notice.noticeCount }</td>
		</tr>
		<tr height="300">
			<td>내용</td>
			<td>${notice.noticeContents }
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
		 		<img alt="본문이미지" src="/resources/nuploadFiles/${notice.noticeFileRename }" width="300" height="300">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="/notice/modifyView.kh?noticeNo=${notice.noticeNo }&page=${page}">수정</a>
				<!--  작성자본인만 수정할수있게 -->
				<a href="#" onclick="noticeRemove(${page});">삭제</a> <!-- #링크 밑 script에 -->
			</td>
		</tr>
	</table>
	<script>
		function noticeRemove(page) {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("공지사항을 삭제하시겠습니까?")) {
				location.href="/notice/remove.kh?page="+page;
			}
		}
	</script>
</body>
</html>