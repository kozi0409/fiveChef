<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
<!-- navs bar -->
<jsp:include page="../main/user_navs.jsp"></jsp:include>
<br><br><br>
	<h2 align="center">자유 게시판</h2><br><br>
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
			</td>
		</tr>
		<tr>
		<td colspan="4" align="center">
			<form action="/community/communitySearch.kh" method="get">
				<select name="searchCondition">
					<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
					<option value="writer" <c:if test="${searchCondition eq 'writer' }">selected</c:if>>작성자</option>
					<option value="title" <c:if test="${searchCondition eq 'title' }">selected</c:if>>제목</option>
					<option value="contents" <c:if test="${searchCondition eq 'contents' }">selected</c:if>>내용</option>
				</select>
				<input type="text" name="searchValue" value="${searchValue }">
				<input type="submit" value="검색">
			</form>
		</td>
	</tr>
	</table>
	<button id="write_btn" onclick="communityWrite()">글쓰기</button>
	
	<script>
		function communityWrite() {
			location.href = "/community/communityWrite.kh";
		}
	</script>
</body>
</html>