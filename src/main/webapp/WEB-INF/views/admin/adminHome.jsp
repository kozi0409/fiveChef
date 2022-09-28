<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>냉장고Chef 관리자홈입니다.</title>
<style>
/* 	div p {
	  overflow: hidden;
	  text-overflow: ellipsis;
	  white-space: nowrap;
	  width: 150px;
	  height: 20px;
	} */
</style>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<c:if test="${not empty loginAdmin}">
<div class="container" style="aligen:center";>
 	<div class="row">
	  <div class="row g-4">
	  
	  <!-- 문의 게시판  -->
	    <div class="col-lg-6 col-md-12">
	      <div class="p-4 border bg-light">
	      	<p style="color: #8ba525; font-size:28px; font-family:malgun gothic; text-align: center;">[ 문의 게시판 ]</p>
				<table class="table table-striped table-hover">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>답변</th>
						<th>작성일</th>
					</tr>
				<c:if test="${!empty qList }">
					<c:forEach items="${qList }" var="qna" varStatus="j">
						<td>${j.count }</td>
						<td><a href="/admin/qnaDetail.kh?questionNo=${qna.questionNo }&page=${currentPage }">${qna.questionWriter }</a></td>
						<td><a href="/admin/qnaDetail.kh?questionNo=${qna.questionNo }&page=${currentPage }">${qna.questionWriter }${qna.questionTitle }</a></td>
						<td>
							<c:if test="${qna.answerStatus eq 'Y' }">
								<b style="color: #2d532c;">대기</b>
							</c:if>
							<c:if test="${qna.answerStatus eq 'N' }">
								<b style="color: #d21853;">완료</b>
							</c:if>
						</td>
						<td>${qna.qEnrollDate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
	      </div>
	    </div>
	<!-- 문의 게시판  -->
	    
	<!-- 레시피 게시판  -->
	    <div class="col-lg-6 col-md-12">
	      <div class="p-4 border bg-light">
	      	<p style="color: #d21853; font-size:28px; font-family:malgun gothic; text-align: center;">[ 레시피 게시판 ]</p>
				<table class="table table-striped table-hover">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				<c:if test="${!empty rList }">
					<c:forEach items="${rList }" var="rcp" varStatus="i">
						<td>${i.count }</td>
						<td><a href="/recipemanage/detail.kh?recipeNo=${rcp.recipeNo }&page=${currentPage }&category=${listValue }">${rcp.userId }</a></td>
						<td><a href="/recipemanage/detail.kh?recipeNo=${rcp.recipeNo }&page=${currentPage }&category=${listValue }">${rcp.recipeTitle }</a></td>
						<td>${rcp.recipeLikeCount }</td>
						<td>${rcp.rCreateDate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
	      </div>
	    </div>
	 <!-- 문의 게시판  -->   
	   
	 <!-- 커뮤니티 게시판  -->
	    <div class="col-lg-6 col-md-12">
	      <div class="p-4 border bg-light">
	      	<p style="color: #ea61bc; font-size:28px; font-family:malgun gothic; text-align: center;">[ 가입 회원 ]</p>
				<table class="table table-striped table-hover">
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>가입날짜</th>
					</tr>
				<c:if test="${!empty uList }">
					<c:forEach items="${uList }" var="user" varStatus="l">
						<td>${l.count }</td>
						<td><a href="/admin/userDetail.kh?userId=${user.userId }&page=${currentPage }">${user.userId }</a></td>
						<td><a href="/admin/userDetail.kh?userId=${user.userId }&page=${currentPage }">${user.userName }</a></td>
						<td>${user.userPhone }</td>
						<td>${user.uEnrollDate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
	      </div>
	    </div>
	<!-- 커뮤니티 게시판  -->
	
	<!-- 회원관리 게시판  -->
	    <div class="col-lg-6 col-md-12">
	      <div class="p-4 border bg-light">
	      	<p style="color: #43b2ea; font-size:28px; font-family:malgun gothic; text-align: center;">[ 커뮤니티 게시판 ]</p>
				<table class="table table-striped table-hover">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>종류</th>
						<th>작성일</th>
					</tr>
				<c:if test="${!empty cList }">
					<c:forEach items="${cList }" var="comm" varStatus="k">
						<td>${k.count }</td>
						<td><a href="/communitymanage/detail.kh?communityNo=${comm.communityNo }&page=${currentPage }">${comm.communityWriter }</a></td>
						<td><a href="/communitymanage/detail.kh?communityNo=${comm.communityNo }&page=${currentPage }">${comm.communityTitle }</a></td>
						<td>${comm.cBoardCode }</td>
						<td>${comm.cEnrollDate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
	      </div>
	    </div>
	 <!-- 회원관리 게시판  -->
	</div>       
</div>
<br>
</c:if>

</body>
</html>