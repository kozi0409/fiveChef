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
	margin-left: 10%;
	margin-right: 10%;
}

#recipe-main{
	/* position: relative; */
	height: 400px;

}
#recipe-main div{
	/* position: relative; */
	/* height: 100%; */

}
div{
	border: 1px solid #ccc;
}
#thumbnailzone{
	
width: 400px;
height: 400px;

}
#thumbnailzone img{
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
	#likezone{
		height: 10%;
		padding: 2%;
		
	}
/* #title-zone{
	height: 100px;
} */
</style>
</head>
<body class="bg-light vsc-initialized">
	<main>	
		<div class="row g-5" id="main-form">
			<div class="col-md-12 col-lg-12" >
				<div class="row" id="recipe-main">
					<div class="col-md-7 ">
						<div class="row align-items-center justify-content-center">
							
							<div class="col-md-12" id="thumbnailzone">
								<img alt="본문이미지"
				src="/resources/ruploadFiles/${recipe.thumbnailRename }">
							</div>
							
						</div>
					</div>
					<div class="col-md-5" >
						
						<div class="col-12" id="likezone">
							<span>ddfdf</span>
						</div>
						<div class="col-12" height="50%">
							df	
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</main>


	<h1 align="center">${recipe.recipeNo }번게시글상세보기</h1>
	<br>
	<br>
	<table align="center" width="1200" border="1">
		<tr>
			<td>제목</td>
			<td>${recipe.recipeTitle }</td>
			<td rowspan="10" width=300><img alt="본문이미지"
				src="/resources/ruploadFiles/${recipe.thumbnailRename }" width=300
				height=300></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${recipe.userId }
            </td>
			
		</tr>
		
		<tr>
			<td>작성날짜</td>
			<td>${recipe.rCreateDate }</td>
			
		</tr>
		<tr>
			<td>조회수 **${result }**${like.userId }</td>
			<td colspan="">${recipe.recipeCount }
			
			</td>
		</tr>
		<tr>
			<td>좋아요수</td>
			<td colspan="">${recipe.recipeLikeCount }
			<form method="post" name="form">
				<input type="hidden" name="category" value="${listValue }">
				<input type="hidden" name="page" value="${page }">
				<input type="hidden" name="recipeNo" value="${recipe.recipeNo }">
				<!-- 아이디 session으로 바꿔줘야함 -->
				<input type="hidden" name="userId" value="${like.userId }">
				<button type="submit" id="likeup" onclick="javascript: form.action='/recipe/recipeLike.kh'">좋아요</button>
			</form></td>
			
		</tr>
		<tr>
			<td>카테고리</td>
			<td colspan="">${recipe.typeCategory }</td>
		</tr>
		<tr>
			<td>방법</td>
			<td colspan="">${recipe.wayCategory }</td>
		</tr>
		<tr>
			<td>난이도</td>
			<td colspan="">${recipe.recipeLevel }</td>
		</tr>
		<tr>
			<td>조리시간</td>
			<td colspan="">${recipe.recipeTime }</td>
		</tr>
		<tr>
			<td>인원</td>
			<td colspan="">${recipe.recipePerson }</td>
		</tr>
		<tr height="300">
			<td>요리소개</td>
			<td colspan="2">${recipe.recipeIntro }</td>
			
		</tr>
		<tr>
			<td>${bundle }재료</td>
			<td colspan="2"><c:forEach items="${iList }" var="ingradient" varStatus="i">
			<p>
			<input type="text" name="largeCatName" value="${ingradient.largeCatName }" readonly="readonly">
			<input type="text" name="smallCatName" value="${ingradient.smallCatName }" readonly="readonly">
			<input type="text" value="${ingradient.ingAmount }" readonly="readonly">
			</p>
			</c:forEach></td>
		</tr>
		<tr>
			<td colspan="3">요리순서</td>
			
		</tr>
		<c:forEach items="${oList }" var="order" varStatus="i">
		<tr>
			<td>STEP ${i.count }</td>
			<td >${order.recipeContents }</td>
			<td ><img alt="본문이미지"
				src="/resources/ruploadFiles/${order.orderPhotoRename }" width=300
				height=300></td>
		</tr>
		</c:forEach>
		<tr height="300">
			<td>완성사진</td>
			<td colspan="2">
			<c:forEach items="${cList }" var="comPhoto" varStatus="i">
			<img alt="본문이미지"
				src="/resources/ruploadFiles/${comPhoto.comPhotoRename }" width=200
				height=200>
			</c:forEach>	
				</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<%-- ${sessionScope.loginUser.memberId } --%> <c:if
					test=""></c:if>
				<a
				href="/recipe/recipeModifyView.kh?recipeNo=${recipe.recipeNo }&page=${page}">수정페이지로</a>
				<a href="#" onclick="boardRemove(${page})">삭제하기</a> <a
				href="/recipe/${urlVal }.kh?page=${page }&category=${listValue }">리스트</a>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
        var likecheck = ${result}
        $(document).ready(function() {
            if(likecheck > 0){
                $("#likeup").attr("onclick","javascript: form.action='/recipe/recipeLikeDel.kh'")
            }
        });

        $(document).ready(function() {
            if(likecheck > 0){
            $("#likeup").html("좋아요 취소");
            }
	});
        

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