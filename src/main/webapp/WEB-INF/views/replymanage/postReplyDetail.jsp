<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>관리자 게시판 상세 조회</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	#cl { background-color: #F9FFFF; }
</style>
</head>
<body>
<div class="container">
<div class="table-responsive">
	<table align="center" width="500" border="1" class="table table-bordered">
		<tr>
			<td id="cl" align="center" width="150">제목</td>
			<td>${community.communityTitle }</td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">게시판</td>
			<td>
			<c:if test="${community.cBoardCode eq 'free'}">
				자유게시판
			</c:if>
			<c:if test="${community.cBoardCode eq 'sale'}">
				할인정보게시판
			</c:if>
			</td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">작성자</td>
			<td>${community.communityWriter }</td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">작성일</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${community.cEnrollDate }"/></td>
		</tr>
		<tr>
			<td id="cl" align="center" width="150">조회수</td>
			<td>${community.boardCount }</td>
		</tr>
		<tr height="300">
			<td id="cl" align="center" width="150">내용</td>
			<td>${community.communityContents }
			</td>
		</tr>
	</table>
	
	<form action="/postreplymanage/addReply.kh" method="post">
		<input type="hidden" name="refCommunityNo" value="${community.communityNo }">
		<input type="hidden" name="page" value="${page }">
		<table align="center" width="500" border="1" class="table table-bordered">
		<c:if test="${loginAdmin.adminName eq '관리자'}">
			<tr>
			<td id="cl" align="center" width="150">${loginAdmin.adminId}</td>
				<td>
					<textarea rows="3" cols="120" name="replyContents"></textarea>
				</td>
				<td>
						<input type="submit" value="등록하기" class="btn btn-info">
				</td>
			</tr>
		</c:if>
		</table>
		
	<p style="color: #46D2D2; font-size:20px; font-family:malgun gothic;">[ 댓글 목록 ]<p>
	<table align="center" width="500" border="1" class="table table-bordered">
		<c:forEach items="${cList }" var="cReply">
			<tr>
				<td id="cl" align="center" width="150">${cReply.replyWriter }</td>
				<td colspan="2">${cReply.replyContents }</td>
				<td align="center" width="130">${cReply.rUpdateDate }</td>
				<c:if test="${loginAdmin.adminName eq '관리자'}">
						<td align="center" width="130">
							<button onclick="modifyView(this, '${cReply.replyContents }', ${cReply.replyNo });" class="btn btn-info">수정</button>
							<button onclick="removeReply('${cReply.replyNo}');" class="btn btn-danger">삭제</button>
						</td>
				</c:if>
				</tr>
		</c:forEach>
	</table>
	</form>
	<script>
		
		function removeReply(replyNo) {
			event.preventDefault();
			if(confirm("(관리자) 댓글을 정말 삭제하시겠습니까?")) {
				var $delForm = $("<form>");
				$delForm.attr("action", "/postreplymanage/removeReply.kh");
				$delForm.attr("method", "post");
				$delForm.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
				$delForm.appendTo("body");
				$delForm.submit();
			}
		}
		
		function modifyView(obj, replyContents, replyNo) {
			event.preventDefault();
			var $tr = $("<tr>");
			$tr.append("<td colspan= '3'><input type='text' size='50' value='"+replyContents+"'></td>");
			$tr.append("<td><button onclick='modifyReply(this,"+replyNo+");'>수정</button></td>");
			$(obj).parent().parent().after($tr);
		}
		
		function modifyReply(obj, replyNo) {
			event.preventDefault();
		if(confirm("(관리자) 댓글을 정말 수정하시겠습니까?")) {
			var inputTag = $(obj).parent().prev().children();
 			var replyContents = inputTag.val();
			var $form = $("<form>");
			$form.attr("action", "/postreplymanage/modifyReply.kh");
			$form.attr("method", "post");
			$form.append("<input type='hidden' value='"+replyContents+"' name='replyContents'>");
			$form.append("<input type='hidden' value='"+replyNo+"'name='replyNo'>");
			$form.appendTo("body");
			$form.submit();
			}
		}
	</script>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>