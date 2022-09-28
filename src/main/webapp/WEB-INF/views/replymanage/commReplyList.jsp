<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>댓글 관리 페이지</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<c:if test="${not empty loginAdmin}">
<body>
	<div class="container">
	<div class="table-responsive">
	<p align="center" style="color: #46D2D2; font-size:34px; font-family:malgun gothic;">[ 커뮤니티 댓글 관리 ]<p>
	<table align="center" border="1" width="" class="table table-striped table-hover">
		<tr>
			<td colspan="7" align="center">
				<form action="/communityreplymanage/search.kh" method="get">
				<div align="center">
					<div style="display:inline-block;">
						<select name="searchCondition" class="btn btn-info">
							<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
							<option value="writer" <c:if test="${searchCondition eq 'writer' }">selected</c:if>>작성자</option>
							<option value="contents" <c:if test="${searchCondition eq 'contents' }">selected</c:if>>내용</option>
						</select>
					</div>
					<div style="display:inline-block;">
						<input style="width:300px; height:33px;" type="text" name="searchValue" value="${searchValue}">
					</div>
					<div style="display:inline-block;">
						<input type="submit" value="검색" class="btn btn-info">
					</div>
					</div>
				</form>
			</td>
		</tr>
		<tr align="center">
			<th width="70">번호</th>
			<th width="80">게시판</th>
			<th width="80">원글</th>
			<th width="120">댓글내용</th>
			<th width="80">댓글작성자</th>
			<th width="80">작성일</th>
			<th width="80">댓글삭제</th>
		</tr>
	<c:if test="${!empty cList }">
	<c:forEach items="${cList }" var="cReply" varStatus="i">
		<tr align="center">
			<td>${i.count }</td>
			
			<td>
			<c:if test="${cReply.cBoardCode eq 'free'}">
				자유게시판
			</c:if>
			<c:if test="${cReply.cBoardCode eq 'sale'}">
				할인정보게시판
			</c:if>
			</td>
			<td>
			<a href="/communityreplymanage/detail.kh?communityNo=${cReply.refCommunityNo }&page=${currentPage }">원글 본문보기</a>
			</td>

			<td>${cReply.replyContents }</td>
			<td>${cReply.replyWriter }</td>
			
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${cReply.rCreateDate }"/> </td>
			
			<c:if test="${loginAdmin.adminName eq '관리자'}">
			<td><button onclick="removeReply('${cReply.replyNo}');" class="btn btn-danger">삭제</button></td>
			</c:if>
			
		</tr>
		</c:forEach>
		<tr align="center" height="20">
			<td colspan="7">
				<c:if test="${currentPage != 1 }">
					<a href="/communityreplymanage/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-primary"><</a>
				</c:if>
				<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
					<c:if test="${currentPage eq p }">
						<b class="btn btn-primary">${p }</b>
					</c:if>
					<c:if test="${currentPage ne p }">
						<a href="/communityreplymanage/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-light">${p }</a>
					</c:if>
				</c:forEach>
				<c:if test="${maxPage > currentPage }">
					<a href="/communityreplymanage/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-primary">></a>
				</c:if>
			</td>
		</tr>
		</c:if>
		<c:if test="${empty cList}">
			<tr>
				<td colspan="7" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
	</table>
	
	<script>
	function removeReply(replyNo) {
		event.preventDefault();
		if(confirm("(관리자) 댓글을 정말 삭제하시겠습니까?")) {
			var $delForm = $("<form>");
			$delForm.attr("action", "/communityreplymanage/removeReply.kh");
			$delForm.attr("method", "post");
			$delForm.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
			$delForm.appendTo("body");
			$delForm.submit();
		}
	}
	</script>
	</div>
	</div>
	</c:if>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>