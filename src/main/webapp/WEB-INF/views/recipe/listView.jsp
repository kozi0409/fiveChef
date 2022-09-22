<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/main/user_navs.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/rcss/listView.css">
<style type="text/css">

.page_bar {
	width: fit-content;
	height: 10px;
	/* /* font-size: 20px; */
	margin: auto;
	/* position: relative; */
	/* position: absolute; */ 
	/* padding-bottom: 1%; */
	/* padding-top: 20%; */
	/* border:1px solid #ccc; */
}
#bar-bar {
	visibility: hidden;
	padding-bottom: 1%;
}

</style>
</head>
<body class="bg-light vsc-initialized">
<input type="hidden" name="userId" value="${sessionScope.loginUser.userId }">
	<div class="wrap">
		<div><h2> 총 <span style="border: #ccc">${totalCount }</span>개의 레시피가 있습니다.<div class="r">
			<form action="/recipe/recipeList.kh" method="get">
				<button class="listView" name="category" value="">전체보기</button>
				<button class="listView" name="category" value="countView">조회수순</button>
				<button class="listView" name="category" value="likeView">좋아요순 </button>
			</form>
			
		</div></h2>
		</div>
		</span>
		<div class="fixed_img_col" align="center">
			<ul>
				<c:forEach items="${rList }" var="recipe" varStatus="i">
				<!-- userId 못불러옴 -->
					<li><a href="/recipe/recipeDetailView.kh?recipeNo=${recipe.recipeNo }&page=${currentPage }&category=${listValue }"><span class="thumb"><img
								onerror="this.src='../resources/images/logo.png'"
								src="/resources/ruploadFiles/${recipe.thumbnailRename }" alt="">
								<em>Click</em></span><strong>${recipe.recipeTitle }</strong></a>
						<p>${recipe.userId }</p>
						<p>좋아요: ${recipe.recipeLikeCount } 조회수: ${recipe.recipeCount }</p>
						<p>🕓: ${recipe.recipeTime}분</p></li>
				</c:forEach>
				
			</ul>
		</div>
		<hr id="bar-bar">
		<div class="page_bar">
				<c:if test="${currentPage > 1 }">
						<a class="btn btn-primary1" href="/recipe/${urlVal }.kh?page=${currentPage -1 }&category=${listValue }"><</a>
				</c:if>
				<c:forEach var="p" begin="${startNavi }" end="${endNavi}">
				
						<a class="btn btn-primary1" href="/recipe/${urlVal }.kh?page=${p }&category=${listValue }">${p }</a>

				</c:forEach>
				<c:if test="${currentPage < maxPage }">
						<a class="btn btn-primary1" href="/recipe/${urlVal }.kh?page=${currentPage +1 }&category=${listValue }">></a>
				</c:if>
		</div>
		<br><br><br>
	</div>
<!-- class="btn btn-primary" -->

</body>
</html>