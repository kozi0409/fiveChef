<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/user_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>공지사항 상세조회</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="table-responsive">
	<table align="center" width="500" border="1" class="table table-bordered">
		<tr>
			<td id="cl" align="center" width="150">제목</td>
			<td>${notice.noticeTitle}</td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">작성일</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${notice.nCreateDate}"/></td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">조회수</td>
			<td>${notice.noticeCount }</td>
		</tr>
		<tr height="300">
			<td id="cl" align="center" width="150">내용</td>
			<td>${notice.noticeContents }
			</td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">첨부파일</td>
			<td>
		 		<img alt="본문이미지" src="/resources/nuploadFiles/${notice.noticeFileRename }" width="300" height="300">
			</td>
		</tr>
		</table>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>