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
	<h2 align="center">게시글 목록</h2><br><br>
	<table align = "center" border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:if test="${!empty cList }">
			<c:forEach items="${cList }" var="community" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td><a href="/community/communityDetail.kh?communityNo=${community.communityNo }&page=${currentPage }">${community.communityTitle }</a></td>
					<td>${community.communityWriter }</td>
					<td>${community.cEnrollDate }</td>
					<td>${community.boardCount }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty cList }">
		<tr>
			<td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td>
		</tr>
	</c:if>
		<tr align="center" height="20">
			<td colspan = "6">
			<c:if test="${currentPage !=1 }">
				<a href="/community/${urlVal }.kh?page=${currentPage - 1 }">[이전]</a>
				</c:if>
				<c:forEach var= "p" begin ="${startNavi }" end="${endNavi }">
					<c:if test="${currentPage eq p }">
						<b>${p }</b>
					</c:if>
					<c:if test="${currentPage ne p }">
						<a href="/community/${urlVal }.kh?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">${p }</a>
					</c:if>
				</c:forEach>
			<c:if test="${currentPage < maxPage }">
			<a href="/community/${urlVal }.kh?page=${currentPage + 1 }">[다음]</a> 
			</c:if>
	</table>
</body>
</html>