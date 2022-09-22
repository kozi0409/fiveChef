<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 정보</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
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
					<%-- <img alt="본문이미지" src="/resources/cuploadFiles/${community.communityFileRename }" width="300" height="300"> --%>
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
	
	<form action="/community/addReply.kh" method="post">
		<input type="hidden" name="refCommunityNo" value="${community.communityNo }">
		<input type="hidden" name="page" value="${page }">
		<table align="center" width="500" border="1">
			<tr>
				<td>
					<textarea rows="3" cols="55" name="replyContents"></textarea>
				</td>
				<td>
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
		
	<table align="center" width="500" border="1">
		<c:forEach items="${rList }" var="cReply">
			<tr>
				<td width="100">${cReply.replyWriter }</td>
				<td colspan="2">${cReply.replyContents }</td>
				<td>${cReply.rUpdateDate }</td>
				<c:if test="${loginUser.userId eq cReply.replyWriter}">
						<td>
						<a href="#" onclick="modifyView(this, '${cReply.replyContents }', ${cReply.replyNo });">수정</a>
						<a href="#" onclick="removeReply('${cReply.replyNo}');">삭제</a>
						</td>
				</c:if>
				</tr>
		</c:forEach>
	</table>
	</form>
	<script>
		function communityRemove(value) {
			event.preventDefault(); //하이퍼링크 이동 방지
			if(confirm("게시물을 삭제하시겠습니까?")) {
				location.href="/community/communityRemove.kh?page=" + value;
			}
		}
		
		function modifyView(obj, replyContents, replyNo) {
			event.preventDefault();
			var $tr = $("<tr>");
			$tr.append("<td colspan= '3'><input type='text' size='50' value='"+replyContents+"'></td>");
			$tr.apeend("<td><button onclick='modifyReply(this,"+replyNo+");'>수정</button></td>");
			$(obj).parent().parent().after($tr);
		}
		
		function modifyReply(obj, rNo) {
			var inputTag = $(obj).parent().prev().children();
			var replyContents = inputTag.val();
			var $form = $("<form>");
			$form.attr("action", "/community/modifyReply.kh");
			$form.attr("method", "post");
			$form.append("<input type='hidden' value='"+replyContents+"' name='replyContents'>");
			$form.append("<input typr='hidden' value='"+rNo"'name='replyNo'>");
			console.log($form[0]);
			$form.appendTo("body");
			$form.submit();
		}
		function removeReply(replyNo) {
			event.preventDefault();
			if(confirm("정말 삭제하시겠습니까?")) {
				var $delForm = $("<form>");
				$delForm.attr("action", "/community/removeReply.kh");
				$delForm.attr("method", "post");
				$delForm.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
				$delForm.appendTo("body");
				$delForm.submit();
			}
		}
	</script>
</body>
</html>