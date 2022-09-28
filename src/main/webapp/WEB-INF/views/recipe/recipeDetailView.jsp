<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<script src="../../../resources/js/jquery-3.6.1.min.js"></script>
<jsp:include page="/WEB-INF/views/main/user_navs.jsp"></jsp:include>
<style type="text/css">
#main-form {
	position: relative;
	/* height: 2000px; */
	margin-left: 10%;
	margin-right: 10%;
}

#recipe-main div {
	position: relative;
	/* height: 100%; */
}

#thumbnailzone {
height: 400px;	
}

#thumbnailzone img {
	position: relative;
	width: 100%;
	height: 100%;
	object-fit: cover;
	/* border-radius: 5%; */
	/* top: 50%;
	left: 50%; */
	/* margin-top: 0; */
	/* transform: translate(-50%, -50%); */
}

.bline {
	padding: 2%;
	border-bottom: 1px solid #ccc;
}

#personalzone img {
	width: 60px;
	height: 60px;
}

.per {
	height: 100%;
	text-align: center;
}

.likebutton {
	height: auto;
	border-bottom: 1px solid #ccc;
}

.likebutton form {
	margin-right: 5%;
	float: right;
}

.likebutton button {
	/* position: absolute; */
	margin: 10%;
	width: 100px;
}

.orderzone div{
	border-radius: 3%;
	border-top: 1px solid #aaa;
}
.orderzone img {
	position: relative;
	width: 100%;
	height: 250px;
	object-fit: cover;
	/* border-radius: 5%; */
	/* top: 50%;
	left: 50%; */
	/* margin-top: 0; */
	/* transform: translate(-50%, -50%); */
}
#ordertext{
	margin-top: 2%;
	margin-left: 2%;
}

#cutline {
	visibility: hidden;
}
.carousel-item{
	height: 400px;
}

.carousel-item img{
	height: 100%;
	object-fit: cover;

}
#btn-2 {
	width: 200px;
	height: 40px;
	border: 0;
	color: white;
	background-color: rgb(209, 24, 79);
}

#btn-2 {
	color: #fff;
	background-color: rgb(209, 24, 79);
	border-color: rgb(209, 24, 79)
}

#btn-2:hover {
	color: #fff;
	background-color: rgb(216, 50, 100);
	border-color: rgb(216, 50, 100)
}

.btn-outline-primary {
	color: rgb(209, 24, 79);
	border-color: rgb(209, 24, 79)
}

.btn-outline-primary:hover {
	color: #fff;
	background-color: rgb(209, 24, 79);
	border-color: rgb(209, 24, 79)
}
.list{
	text-align: center;
}

</style>
</head>
<body class="bg-light vsc-initialized">
	<br>
	<br>
	<main>
		<div class="row" id="main-form">
			<div class="col-md-12 col-lg-12">
				<div class="container">
					<div class="row" id="recipe-main">
						<div class="col-md-7 ">
							<div class="row">

								<div class="col-md-12 align-items-center justify-content-center"
									id="thumbnailzone">
									<img class="img-fluid img-thumbnail" alt="본문이미지"
										src="/resources/ruploadFiles/${recipe.thumbnailRename }">
								</div>

							</div>
						</div>
						<div class="col-md-5">
							<div class="row">
								<div class="bline col-md-8" id="likezone">
									<span>조회수: ${recipe.recipeCount } </span><span>| 좋아요:
										${recipe.recipeLikeCount }</span>
								</div>
								<div class="bline col-md-4" id="likezone">
									<span> 등록일: ${recipe.rCreateDate }</span>

								</div>
							</div>
							<div class="bline col-md-12" id="titlezone">
								<div class="col-md-12">
									<p class="fs-2">
										<b>${recipe.recipeTitle }</b>
									</p>
									<p class="fs-5">${recipe.recipeIntro }</p>
								</div>
							</div>
							<div class="bline col-md-12" id="personalzone">
								<div class="per row align-items-center justify-content-center">
									<div class="col-4">
										<img src="/resources/images/people-fill.svg">
									<c:forEach items="${wList }" var="wList" varStatus="i">
									<c:if test="${recipe.recipePerson eq wList.whatNo}">
									<p><b>${wList.typeName}</b></p>
									</c:if>
								</c:forEach>
										<!-- ${recipe.recipePerson } -->
									</div>
									<div class="col-4">
										<img src="/resources/images/alarm.svg">
										<c:forEach items="${wList }" var="wList" varStatus="i">
									<c:if test="${recipe.recipeTime eq wList.whatNo}">
									<p><b>${wList.typeName}</b></p>
									</c:if></c:forEach>
										<!-- ${recipe.recipeTime } -->

									</div>
									<div class="col-4">
										<img src="/resources/images/star-half.svg">
										<c:forEach items="${wList }" var="wList" varStatus="i">
									<c:if test="${recipe.recipeLevel eq wList.whatNo}">
									<p><b>${wList.typeName}</b></p>
									</c:if></c:forEach>
										<!-- ${recipe.recipeLevel } -->
									</div>

								</div>

							</div>

						</div>
						<div class="container">
							
							<div
								class="likebutton row align-items-center justify-content-center">
								<div class="col-md-12">
									<form method="post" name="form">
										<input type="hidden" name="category" value="${listValue }">
										<input type="hidden" name="page" value="${page }"> <input
											type="hidden" name="recipeNo" value="${recipe.recipeNo }">
										<!-- 아이디 session으로 바꿔줘야함 -->
										<input type="hidden" name="userId" value="${like.userId }">
										<button class="btn btn-danger" type="submit" id="likeup"
											onclick="javascript: form.action='/recipe/recipeLike.kh'">좋아요</button>
									</form>
								</div>
							</div>
						</div>
						<div class="container ">
							<div class="row g-3">
								<hr id="cutline">
								<p class="fs-2 mb-3">
									<b>${bundle }재료</b>
								</p>
								<div class="col-md-12">
									<div class="row">
										<c:forEach items="${iList }" var="ingradient" varStatus="i">
											<div class="col-md-2">
												<input class="form-control" type="text" name="largeCatName"
													value="${ingradient.largeCatName }" readonly="readonly">
											</div>
											<div class="col-md-2">
												<input class="form-control" type="text" name="smallCatName"
													value="${ingradient.smallCatName }" readonly="readonly">
											</div>
											<div class="col-md-2">
												<input class="form-control" type="text"
													value="${ingradient.ingAmount }" readonly="readonly">
											</div>
											<div class="col-md-2">
											<a class="btn btn-outline-secondary" href="https://www.coupang.com/np/search?component=&q=${ingradient.smallCatName }" target="_blank">구매링크</a>
											</div>
											<hr id="cutline">
										</c:forEach>
									</div>
									<hr id="cutline">
								</div>
								<hr>

							</div>
						</div>
						<p class="fs-2 mb-3">
							<b>${bundle } 요리방법</b>
						</p>
						<div class="container">
							<div class="orderzone bline row g-3">
								<c:forEach items="${oList }" var="order" varStatus="i">
									<tr>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<div class="col-md-2 align-items-center justify-content-center" align="center"><p class="fs-3 mb-3"><b>STEP ${i.count }</b></p></div>
									<div class="col-md-6"><p class="fs-4 mb-3" id="ordertext">${order.recipeContents }</p></div>
									<div class="col-md-4"><img class="img-fluid img-thumbnail" alt="본문이미지"
											src="/resources/ruploadFiles/${order.orderPhotoRename }"
											></div>
								</c:forEach>

							</div>

						</div>
						<hr id="cutline">
						<p class="fs-2 mb-3">
							<b>완성사진</b>
						</p>
						<div class="container">
							<div class="bline row">
							<div id="carouselExampleIndicators" class="carousel slide col-md-6 offset-md-3" data-bs-ride="carousel">
								<div class="carousel-inner">
									<c:forEach items="${cList }" begin="0" end="0" var="comPhoto" varStatus="i">
								  <div class="carousel-item active">
									<img src="/resources/ruploadFiles/${comPhoto.comPhotoRename }" class="d-block w-100" alt="...">
								  </div></c:forEach>
								  <c:forEach items="${cList }" begin="1" var="comPhoto" varStatus="i">
								  <div class="carousel-item">
									<img src="/resources/ruploadFiles/${comPhoto.comPhotoRename }" class="d-block w-100" alt="...">
								  </div>
								  </c:forEach>
								</div>
								<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
								  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
								  <span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
								  <span class="carousel-control-next-icon" aria-hidden="true"></span>
								  <span class="visually-hidden">Next</span>
								</button>
							  </div>
							</div>
							</div>
						</div>
						<hr id="cutline">
						
							<div class="list row">
							 <div class="col-12">
							<c:if test="${loginUser.userId eq recipe.userId }">
							<a class="btn btn-primary btn-lg col-md-4" id="btn-2" href="/recipe/recipeModifyView.kh?recipeNo=${recipe.recipeNo }&page=${page}&loginId=${sessionScope.loginUser.userId}">수정페이지로</a>
							<a class="btn btn-primary btn-lg col-md-4" id="btn-2" onclick="recipeRemove()" href="/recipe/recipeRemove.kh?recipeNo=${recipe.recipeNo }">삭제하기</a>
							</c:if> 
							<a class="btn btn-primary btn-lg col-md-4" id="btn-2" href="/recipe/${urlVal }.kh?page=${page }&category=${listValue }">리스트</a>
							</div>
							</div>
						
					</div>

				</div>
			</div>
		</div>

	</main>
	<script type="text/javascript">
		var likecheck = ${result}
		$(document).ready(function() {
			if (likecheck > 0) {
				$("#likeup").attr("onclick","javascript: form.action='/recipe/recipeLikeDel.kh'")
			}
		});

		$(document).ready(function() {
			if (likecheck > 0) {
				$("#likeup").html("좋아요 취소");
			}
		});
		
		function recipeRemove() {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("해당 게시글을 삭제하시겠습니까?")) {
				location.href="/recipe/recipeRemove.kh?recipeNo=${recipe.recipeNo }";
			}
		}

		// $(document).ready(function() {
		//     alert('Hello Dexter!');
		// });
		//window.onload=function(){
		// 페이지 로딩시 접근한 아이디가 좋아요를 누른적이 있다면 1출력 delete페이지로 
		/* var likecheck = ${result}
		 console.log(document.getElementById("likeup").getAttribute("onclick"));
		 console.log(document.getElementById("likeup").getAttribute("onclick"));
		if(likecheck < 1){
		    document.querySelector("likeup").innerHTML ="좋아요 취소";
			 document.getElementById("likeup").setAttribute("onclick","javascript: form.action='/add'");
		}
		}
		 */
	</script>
	<footer>

		<jsp:include page="/WEB-INF/views/main/footer.jsp"></jsp:include>
	</footer>
</body>
</html>