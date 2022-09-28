<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1게시판 목록</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<c:if test="${not empty loginAdmin}">
<div class="container" style="width: 80%;">
	<div class="row">
		<div class="col-sm-12 text-center" >
		<p style="color: #8ba525; font-size:34px; font-family:malgun gothic;">[ 회원 문의 게시판 목록 ]<p>
			<table class="table table-striped table-hover">
				<!--  검색 Start -->
				<tr>
					<td colspan="10" align="center">
						<form action="/admin/searchQna.kh" method="get">
							<div style= "display: inline-block">
							<select name="searchCondition">
								<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
								<option value="QWriter" <c:if test="${searchCondition eq 'QWriter' }">selected</c:if>>작성자</option>
								<option value="QTitle" <c:if test="${searchCondition eq 'QTitle' }">selected</c:if>>제목</option>
								<option value="QContents" <c:if test="${searchCondition eq 'QContents' }">selected</c:if>>내용</option>
							</select>
							</div>
							<div style= "display: inline-block">
							<input type="text" name="searchValue" value="${searchValue }">
							</div>
							<div style= "display: inline-block">
							<input type="submit" value="검색">
							</div>
							<div style= "display: inline-block">
							<input type="button" value="전체목록" onclick="location = '/admin/qnalist.kh?page=${page}'">
							</div>
						</form>
					</td>
				</tr>
				<!--  검색 End -->
				<tr>
					<th>번호</th>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>등록날짜</th>
					<th>상태</th>	
					<th>수정</th>
				</tr>
		<c:if test="${!empty qList }">
			<c:forEach items="${qList }" var="qna" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${qna.questionNo }</td>
					<td>${qna.questionWriter }</td>
					<td><a href="/admin/qnaDetail.kh?questionNo=${qna.questionNo }&page=${currentPage }">${qna.questionTitle }</a></td>
					<td>${qna.qEnrollDate }</td>
					<td>
						<c:if test="${qna.answerStatus eq 'Y' }">
							<b style="color: #2d532c;">대기</b>
						</c:if>
						<c:if test="${qna.answerStatus eq 'N' }">
							<b style="color: #d21853;">답변완료</b>
						</c:if>
					</td>
					<td><button type="button" class="btn btn-dark btn-sm" style="background-color: #9fc312;" onclick ="location.href = '/admin/qnaDetail.kh?questionNo=${qna.questionNo }&page=${currentPage }';">답변</button></td>
				</tr>
			</c:forEach>
				<tr align="center" height="20">
					<td colspan="7">
						<c:if test="${currentPage != 1 }">
							<a href="/admin/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[이전]</a>
						</c:if>
						<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
							<c:if test="${currentPage eq p }">
								<b>${p }</b>
							</c:if>
							<c:if test="${currentPage ne p }">
								<a href="/admin/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a>
							</c:if>
						</c:forEach>
						<c:if test="${maxPage > currentPage }">
							<a href="/admin/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[다음]</a>
						</c:if>
					</td>
				</tr>
		</c:if>
		<c:if test="${empty qList }">
				<tr>
					<td colspan="7" align="center"><b>데이터가 존재하지 않습니다.</b></td>
				</tr>
		</c:if>
			</table>
		</div>
	</div>
</div>
</c:if>
<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>

</body>
</html>