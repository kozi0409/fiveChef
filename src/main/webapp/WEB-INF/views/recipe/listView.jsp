<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/rcss/listView.css">
<!-- <link rel="stylesheet" href="../resources/css/bootstrap.min.css"> -->
<style type="text/css">

</style>
</head>
<body>
	<div class="wrap">
		<!-- <input type="hidden" name="listValue" value=""> -->
		<div><h2> 총 <span style="border: #ccc">${totalCount }</span>개의 레시피가 있습니다.<div class="r">
			<form action="/recipe/recipeList.kh" method="get">
				<button name="category" value="">전체보기</button>
				<button name="category" value="countView">조회수순</button>
				<button name="category" value="likeView">좋아요순 </button>
			</form>
			
		</div></h2>
		</div>
		</span>
		<div class="fixed_img_col" align="center">
			<ul>
				<c:forEach items="${rList }" var="recipe" varStatus="i">
					<li><a href="#"><span class="thumb"><img
								onerror="this.src='../resources/images/logo.png'"
								src="/resources/ruploadFiles/${recipe.thumbnailRename }" alt="">
								<em>Click</em></span><strong>${recipe.recipeTitle }</strong></a>
						<p>${recipe.userId }</p>
						<p>좋아요: ${recipe.recipeLikeCount } 조회수: ${recipe.recipeCount }</p>
						<p>조리시간: ${recipe.recipeTime}분</p></li>
				</c:forEach>
			</ul>
		</div>
	</div>


</body>
</html>