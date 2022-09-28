<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../main/user_navs.jsp"></jsp:include>
<meta charset="UTF-8">
<title>공지사항 상세 조회</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	#btn-1 {
		border : 0;
        color: white;
        background-color:  rgb(209, 24, 79);
        border-radius : 5px;
	}
	#btn-2{
		border : 0;
		color: rgb(209, 24, 79);
		border-radius : 5px;
	}
</style>
</head>
<body>

	<!-- navs bar -->
<div class="container">
<div class="table-responsive">
	<table align="center" width="500" border="1" class="table table-bordered">
		<tr>
			<td align="center" width="150">제목</td>
			<td>${community.communityTitle }</td>
		</tr>
		<tr>
			<td align="center" width="150">게시판</td>
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
			<td align="center" width="150">작성자</td>
			<td>${community.communityWriter }</td>
		</tr>
		<tr>
			<td align="center" width="150">작성일</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${community.cEnrollDate }"/></td>
		</tr>
		<tr>
			<td align="center" width="150">조회수</td>
			<td>${community.boardCount }</td>
		</tr>
		<tr height="300">
			<td align="center" width="150">내용</td>
			<td>${community.communityContents }
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td align="center" width="150">첨부파일</td> -->
<!-- 			<td> -->
<%-- 		 		<img alt="본문이미지" src="/resources/cuploadFiles/${community.communityFileRename }" width="300" height="300"> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
		<c:if test="${loginUser.userId eq community.communityWriter}">
		<tr>
			<td colspan="2" align="center">
			<div style="display : inline-block">
				<button onclick="location.href='/community/communityModifyView.kh?communityNo=${community.communityNo }&page=${page}';" id="btn-1">수정</button>
			</div>
			<div style="display : inline-block">
				<button onclick="communityRemove(${page});" id="btn-2">삭제</button>
			</div>
		</tr>
		</c:if>
	</table>

    <form action="/community/addReply.kh" metohd="post">
        <table align="center" width="500" border="1" class="table table-bordered">
            <c:forEach items="${rList}" var="cReply">
                <tr>
                    <td width="70">${cReply.replyWriter}</td>
                    <td colspan="2">${cReply.replyContents}</td>
                    <td width="50">${cReply.rUpdateDate}</td>
                    <c:if test="${loginUser.userId eq cReply.replyWriter }">
                    	<td width="115">
                    		<div style="display : inline-block">
                    			<button type="button" id="btn-1" onclick="modifyView(this, '${cReply.replyContents }', ${cReply.replyNo });">수정</button>
                    		</div>
                    		<div style="display : inline-block">
                    			<button type="button" id="btn-2" onclick="removereply('${cReply.replyNo}');">삭제</button>
                    		</div>
                    	</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

        <input type="hidden" name="refCommunityno" value="${community.communityNo}">
        <input type="hidden" name="page" value="${page}">
        <c:if test="${not empty loginUser }">
	        <table align="center" width="500" border="1" class="table table-bordered">
	            <tr>
	                <td>
	                    <textarea rows="3" cols="150" name="replyContents"></textarea>
	                </td>
	                <td>
	                    <input type="submit" id="btn-1" value="등록하기">
	                </td>
	            </tr>
	        </table>
        </c:if>

    </form>
	<script>
		function communityRemove(page) {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("해당 게시글을 삭제하시겠습니까?")) {
				location.href="/community/communityRemove.kh?page="+page;
			}
		}

        function modifyView(obj, replyContents, replyNo) {
            event.preventDefault();
            var $tr = $("<tr>");
                $tr.append("<td colspan='3'><input type='text' size='50' value='"+replyContents+"'></td>");
                $tr.append("<td><button onclick='modifyReply(this,"+replyNo+");'>수정</button></td>");
                $(obj).parent().parent().after($tr);
        }

        function modifyReply(obj,replyNo) {
            event.preventDefault();
            var inputTag = $(obj).parent().prev().children();
            var replyContents = inputTag.val();
            var $form = $("<form>");
                $form.attr("action", "/community/modifyReply.kh");
                $form.attr("method", "post");
                $form.append("<input type='hidden' value='"+replyContents+"' name='replyContents'>");
                $form.append("<input type='hidden' value='"+replyNo+"' name='replyNo'>");
                $form.appenTo("body");
                $form.submit();
        }

        function removeReply(replyNo) {
            event.preventDefault();
            if(comfirm("정말 삭제하시겠습니까?")) {
                var $delForm = $("<form>");
                    $delForm.attr("action", "/community/removeReply.kh");
                    $delForm.attr("method", "post");
                    $delForm.append("<input type='hidden' name='replyNo' value='"+replyNo+"'>");
                    $delForm.appendTo("body");
                    $delForm.submit();
            }
        }
	</script>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>