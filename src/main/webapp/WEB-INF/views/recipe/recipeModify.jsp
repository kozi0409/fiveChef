<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../../../resources/js/jquery-3.6.1.min.js"></script>
<jsp:include page="/WEB-INF/views/main/user_navs.jsp"></jsp:include>
<title>냉장고 셰프 레시피 수정</title>
<style>
#main-form {
	margin-left: 10%;
	margin-right: 10%;
}

textarea.form-controls {
	min-height: calc(1.5em + 2rem + 2px);
	border: #333;
	border: 1px solid #ced4da;
	border-radius: .25rem;
}

.form-controls:focus {
	color: #212529;
	background-color: #fff;
	border-color: #86b7fe;
	outline: 0;
	box-shadow: 0 0 0 .25rem rgba(13, 110, 253, .25)
}

#btn-2 {
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

#cutline {
	visibility: hidden;
}

#thumbnailzone {
	position: relative;
	width: auto;
	height: 200px;
	border: 1px solid #aaa;
	border-radius: .25rem;
}

#thumbnailzone img {
	position: absolute;
	width: 100%;
	height: 100%;
	object-fit: cover;
	/* border-radius: 5%; */
	top: 50%;
	left: 50%;
	margin-top: 0;
	transform: translate(-50%, -50%);
	!
	important
}

#thumbnailzone .form-label {
	width: 100%;
}

#thumbnailzone input {
	position: relative;
	width: 100%;
}

#ingHidden {
	visibility: hidden;
	height: 0px;
	width: 0px;
}
</style>
<script>
	
</script>
</head>
<body class="bg-light vsc-initialized">

	<div class="container">
		<main>
			<div class="py-5 text-center">
				<h2>레시피 수정</h2>
			</div>

			<div class="row g-5" id="main-form">
				<div class="col-md-12 col-lg-12">
					<h4 class="mb-3">
						<b>레시피 정보를 수정해 주세요</b>
					</h4>
					<form class="needs-validation" action="/recipe/recipeModify.kh"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="page" value="${page }"> <input
							type="hidden" name="recipeNo" value="${recipe.recipeNo }">
						<input type="hidden" name="thumbnailName"
							value="${recipe.thumbnailName }"> <input type="hidden"
							name="thumbnailRename" value="${recipe.thumbnailRename }">


						<div class="row g-3">
							<div class="row g-3">
								<div class="col-md-8">
									<div class="row g-3">
										<div class="col-md-7">
											<label for="firstName" class="form-label">레시피 제목</label> <input
												type="text" class="form-control" id="firstName"
												name="recipeTitle" placeholder="예) 둘이 먹다 하나가 죽어도 모를 김치찌개"
												value="${recipe.recipeTitle}" required="">
											<div class="invalid-feedback">Valid recipeTitle is
												required.</div>
										</div>

										<div class="col-md-4">
											<label for="lastName" class="form-label">작성자 아이디</label> <input
												type="text" class="form-control" id="lastName"
												placeholder="" name="userId" value="${recipe.userId }"
												required="" readonly>
											<div class="invalid-feedback">Valid last name is
												required.</div>
										</div>
										<div class="row g-3">
											<div class="input-group col-12" id="int-form">
												<span class="input-group-text">레시피 소개</span>
												<textarea class="form-controls" cols="75" rows="5"
													aria-label="With textarea" name="recipeIntro"
													placeholder=" 맛있는 레시피의 소개를 적어주세요!">${recipe.recipeIntro }</textarea>
											</div>
										</div>
									</div>
									<hr id="cutline">
									<div class="row g-3">
										<div class="col-md-3">
											<label for="typeCategory" class="form-label">종류별 카테고리</label>
											<select class="form-select" name="typeCategory"
												id="typeCategory" required="">
												<option value="">종류별</option>
												<c:forEach items="${wList }" var="whatRecipe" varStatus="i">
													<c:if test="${whatRecipe.typeCode eq 'TYPE' }">
														<option value="${whatRecipe.whatNo }"
															<c:if test="${recipe.typeCategory eq whatRecipe.whatNo}">selected</c:if>>${whatRecipe.typeName }</option>
													</c:if>
												</c:forEach>
											</select>
											<div class="invalid-feedback">Please select a valid
												typeCategory.</div>
										</div>

										<div class="col-md-3">
											<label for="wayCategory" class="form-label">방법별 카테고리</label>
											<select class="form-select" name="wayCategory"
												id="wayCategory" required="">
												<c:forEach items="${wList }" var="whatRecipe" varStatus="i">
													<c:if test="${whatRecipe.typeCode eq 'WAY' }">
														<option value="${whatRecipe.whatNo }"
															<c:if test="${recipe.typeCategory eq whatRecipe.whatNo}">selected</c:if>>${whatRecipe.typeName }</option>
													</c:if>
												</c:forEach>
											</select>
											<div class="invalid-feedback">Please select a valid
												wayCategory.</div>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<label for="thumbnail" class="form-label">썸네일 사진 선택</label>
									<div id="thumbnailzone">
										<label for="thumbnail" class="form-label"> <img
											onerror="this.src='../resources/images/logo.png'"
											src="/resources/ruploadFiles/${recipe.thumbnailRename }">
											<input type="file" name="reuploadFile" class="form-control"
											id="thumbnail" accept="image/jpeg, image/png, image/jpg"
											onchange="imgView(this);">
										</label>
									</div>

								</div>
								<div class="row g-3">
									<div class="col-md-2">
										<label for="recipePerson" class="form-label">인원수</label> <select
											class="form-select" name="recipePerson" id="recipePerson"
											required="">
											<c:forEach items="${wList }" var="whatRecipe" varStatus="i">
												<c:if test="${whatRecipe.typeCode eq 'PERSON' }">
													<option value="${whatRecipe.whatNo }"
														<c:if test="${recipe.typeCategory eq whatRecipe.whatNo}">selected</c:if>>${whatRecipe.typeName }</option>
												</c:if>
											</c:forEach>
										</select>
										<div class="invalid-feedback">Please select a valid
											recipePerson.</div>
									</div>
									<div class="col-md-2">
										<label for="recipeTime" class="form-label">요리시간</label> <select
											class="form-select" name="recipeTime" id="recipeTime"
											required="">
											<c:forEach items="${wList }" var="whatRecipe" varStatus="i">
												<c:if test="${whatRecipe.typeCode eq 'TIME' }">
													<option value="${whatRecipe.whatNo }"
														<c:if test="${recipe.typeCategory eq whatRecipe.whatNo}">selected</c:if>>${whatRecipe.typeName }</option>
												</c:if>
											</c:forEach>
										</select>
										<div class="invalid-feedback">Please select a valid
											recipeTime.</div>
									</div>
									<div class="col-md-2">
										<label for="recipeLevel" class="form-label">난이도</label> <select
											class="form-select" name="recipeLevel" id="recipeLevel"
											required="">
											<c:forEach items="${wList }" var="whatRecipe" varStatus="i">
												<c:if test="${whatRecipe.typeCode eq 'LEVEL' }">
													<option value="${whatRecipe.whatNo }"
														<c:if test="${recipe.typeCategory eq whatRecipe.whatNo}">selected</c:if>>${whatRecipe.typeName }</option>
												</c:if>
											</c:forEach>
										</select>
										<div class="invalid-feedback">Please select a valid
											recipeLevel.</div>
									</div>
								</div>
								<br>
								<hr class="my-4">
								<br>
								<div class="row g-3">
									<div class="col-md-2">
										<label for="ingBundleName" class="form-label"><h4
												class="mb-3">
												<b>요리명</b>
											</h4></label> <input type="text" class="form-control-lg"
											name="ingBundleName" id="ingBundleName" placeholder="예) 김치찌개"
											required="" value="${bundle}">
										<div class="invalid-feedback">Please enter your shipping
											address.</div>
									</div>
								</div>



								<div class="col-12">
									<p class="fw-bolder ">재료등록</p>
								</div>
								<!-- 여기서부터 append -->
								<div id="mainDiv" class="row g-1">
									<c:forEach items="${iList }" var="iList" varStatus="k">
										<div id="ing-app" class="ingapp row g-1">
											<div class="col-md-2">
												<%-- ${i.count } --%>
												<%-- ${fn:length(lList) -12} --%>
												<select class="form-select" name="largeCatId"
													id="largeCatId${k.index +1}" onchange="setOpt(this)"
													required="">
													<option value="" selected="selected">대분류 선택</option>
													<c:forEach items="${lList }" var="largeCat" varStatus="i">
														<option id="largeCatOpt" value="${largeCat.largeCatId }"
															<c:if test="${iList.largeCatId eq largeCat.largeCatId }">selected</c:if>>${largeCat.largeCatName }</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Please select a valid
													country.</div>
											</div>

											<div class="col-md-2">
												<select class="form-select" name="smallCatId"
													id="smallCatId${k.index +1}" required="">
													<option value="" selected>재료선택</option>
													<c:forEach items="${sList }" var="smallCat" varStatus="i">
														<option value="${smallCat.smallCatId }"
															class="${smallCat.largeCatId }"
															<c:if test="${iList.smallCatId eq smallCat.smallCatId }">selected</c:if>>${smallCat.smallCatName }</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Please select a valid
													country.</div>
											</div>
											<div class="col-md-2">
												<input type="text" class="form-control" name="ingAmount"
													id="ingAmount" placeholder="예) 300g"
													value=${iList.ingAmount } required="">
												<div class="invalid-feedback">Please enter your
													shipping address.</div>
											</div>
										</div>
										<input type="hidden" name="ingNo" value="${iList.ingNo }">
										<input type="hidden" name="recipeNo"
											value="${iList.recipeNo }">
									</c:forEach>

								</div>
								<div id="ingHidden">
									<select class="form-select" name="largeCatId" id="largeCatId"
										onchange="setOpt(this)" >
										<option value="" selected="selected">대분류 선택</option>
										<c:forEach items="${lList }" var="largeCat" varStatus="i">
											<option id="largeCatOpt" value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
										</c:forEach>
									</select> <select class="form-select" name="smallCatId" id="smallCatId"
										>
										<option value="" selected>재료선택</option>
										<c:forEach items="${sList }" var="smallCat" varStatus="i">
											<option value="${smallCat.smallCatId }"
												class="${smallCat.largeCatId }">${smallCat.smallCatName }</option>
										</c:forEach>
									</select>
								</div>

								<!-- -- -->
								<div class="btn-group col-md-3" role="group"
									aria-label="Basic radio toggle button group">
									<input type="radio" class="btn-check" name="btnradio"
										id="ing-add"></input> <label class="btn btn-outline-primary"
										for="btnradio2" onclick="adding()">추가</label> <input
										type="radio" class="btn-check" name="btnradio" id="ing-del"
										autocomplete="off"> <label
										class="btn btn-outline-primary" for="btnradio3"
										onclick="deling()">삭제</label>
								</div>



								<hr class="my-4">

								<!-- 여기서부터  order-->
								<div class="col-12">
									<p class="fw-bolder ">
									<h4>
										<b>요리순서</b>
									</h4>
								</div>
								<c:forEach items="${oList }" var="oList" varStatus="i">
									<div id="orderDiv">
										<div id="order-app" class="orderapp row g-3">
											<div class="row g-3">
												<div class="col-md-8 ">
													<div class="input-group col-md-4 ">
														<span class="input-group-text">Step</span>
														<textarea class="form-controls" cols="83" rows="7"
															aria-label="With textarea" name="recipeContents"
															placeholder="요리 방법을 적어주세요!">${oList.recipeContents }</textarea>
													</div>
												</div>
												<div class="col-md-4 ">
													<div id="thumbnailzone">
														<label class="form-label"> <img
															onerror="this.src='../resources/images/logo.png'"
															src="/resources/ruploadFiles/${oList.orderPhotoRename }">
															<input type="file" name="reouploadFile"
															class="form-control"
															accept="image/jpeg, image/png, image/jpg"
															onchange="imgView(this);">
														</label>
													</div>
												</div>
											</div>

										</div>
									</div>
									<input type="hidden" name="orederNo" value="${oList.orederNo }">
									<input type="hidden" name="recipeNo" value="${oList.recipeNo }">
									<input type="hidden" name="orderPhotoName"
										value="${oList.orderPhotoName }">
									<input type="hidden" name="orderPhotoRename"
										value="${oList.orderPhotoRename }">
									<input type="hidden" name="orderPhotopath"
										value="${oList.orderPhotopath }">
								</c:forEach>

								<!-- -- -->
								<div class="btn-group col-md-3" role="group"
									aria-label="Basic radio toggle button group">
									<input type="radio" class="btn-check" name="btnradio"
										id="order-add"></input> <label class="btn btn-outline-primary"
										for="btnradio2" onclick="addorder()">추가</label> <input
										type="radio" class="btn-check" name="btnradio" id="order-del"
										autocomplete="off"> <label
										class="btn btn-outline-primary" for="btnradio3"
										onclick="delorder()">삭제</label>
								</div>
							</div>

							<hr class="my-4">
							<br>
							<div class="col-12">
								<p class="fw-bolder ">
								<h4>
									<b>완성사진등록</b>
								</h4>
							</div>
							<br> <br>
							<div class="row g-3">
								<c:forEach items="${cList }" var="cList" varStatus="i">
									<c:if test="${cList.comPhotoName ne null }">
										<div class="col-md-3">
											<label>완성사진${i.count }</label>
											<div id="thumbnailzone">
												<label class="form-label"> <img
													onerror="this.src='../resources/images/logo.png'"
													src="/resources/ruploadFiles/${cList.comPhotoRename }">
													<input type="file" name="recuploadFile"
													class="form-control"
													accept="image/jpeg, image/png, image/jpg"
													onchange="imgView(this);">
												</label>
											</div>
										</div>
									</c:if>
									<input type="hidden" name="comPhotoNo"
										value="${cList.comPhotoNo }">
									<input type="hidden" name="recipeNo" value="${cList.recipeNo }">

								</c:forEach>
							</div>
							<br>

							<hr class="my-4">
							<div class="row">
								<button class="btn btn-primary btn-lg col-md-6" id="btn-2"
									type="submit">레시피 수정</button>
								<button class="btn btn-primary btn-lg col-md-6" id="btn-2"
									type="reset"
									onclick="location.href ='/recipe/recipeDetailView.kh?recipeNo=${recipe.recipeNo }'">취소</button>
							</div>

							<br> <br> <br>
					</form>
				</div>
			</div>
		</main>

	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/main/footer.jsp"></jsp:include>

	</footer>
	<script>
		//재료선택 반응창
		var malls = false;
		var k = "";
		/* $(document).ready(function() {
					for (var i = 0; i < 100; i++) {
						
						$("#smallCatId" + i).find("option[value!=0]").detach();}
						
				}); */
		function setOpt(a) {
			k = $(a).attr("id").charAt($(a).attr("id").length - 1);
// 			malls = $("#smallCatId" + k).find("option[value!=0]");
			console.log(k);
			console.log($("#smallCatId" + k).find("option[value!=0]"));

			// "#smallCatId1" "#smallCatId${i.count}"하고 다르게 인식함 자료형차이인지 모르겠음 
			$("#smallCatId" + k).find("option[value!=0]").detach();
			$("#smallCatId" + k).append(malls.filter("." + event.target.value));
			// console.log($(a).attr("id").charAt($(a).attr("id").length-1))
			//  var idx = el.options.selectedIndex;
			// console.log(idx)
		}
		$(function() {
			malls = $("#smallCatId"+k).find("option[value!=0]");
			console.log(0)
		});

		// 				function update_selected() {
		// 					$("#smallCatId2").val(0);
		// 					console.log(1)
		// 					$("#smallCatId2").find("option[value!=0]").detach();
		// 					$("#smallCatId2").append(malls.filter("." + $(this).val()));
		// 				}
		// 				// console.log($(this).val())
		// 				$(function() {
		// 					malls = $("#smallCatId2").find("option[value!=0]");
		// 					malls.detach();
		// 					$("#largeCatId2").change(update_selected);
		// 					$("#largeCatId2").trigger("change");
		// 				});

		var ingNode = document.querySelector('#ing-app');
		function adding() {
			console.log(ingNode)
			mainDiv.appendChild(ingNode.cloneNode(true));
		}

		function deling() {
			var ingNodeClass = document.querySelectorAll('.ingapp');
			console.log(ingNodeClass[0])
			ingNodeClass[0].remove();
		}

		var orderNode = document.querySelector('#order-app');
		function addorder() {
			console.log(orderNode)
			orderDiv.appendChild(orderNode.cloneNode(true));
		}

		function delorder() {
			var orderNodeClass = document.querySelectorAll('.orderapp');
			console.log(orderNodeClass[0])
			orderNodeClass[0].remove();
		}
		$(document).ready(function() {

		});
		//이미지 교체
		function imgView(obj) {

			var imgid = obj.previousElementSibling;

			imgid.src = URL.createObjectURL(event.target.files[0]);
			imgid.onload = function() {
				URL.revokeObjectURL(imgid.src);// free memory

			}
			imgCheck()

		};

		// function loadFile(input) {
		// 	var file = input.files[0];	//선택된 파일 가져오기

		//     //미리 만들어 놓은 div에 text(파일 이름) 추가
		//     var name = document.getElementById('fileName');
		//     name.textContent = file.name;
		//   //새로운 이미지 div 추가
		//     var newImage = document.createElement("img");
		//     newImage.setAttribute("class", 'img');

		//     //이미지 source 가져오기
		//     newImage.src = URL.createObjectURL(file);   

		//     newImage.style.width = "70%";
		//     newImage.style.height = "70%";
		//     newImage.style.visibility = "visible";   //버튼을 누르기 전까지는 이미지를 숨긴다
		//     newImage.style.objectFit = "contain";

		//     //이미지를 image-show div에 추가
		//     var container = document.getElementById('image-show');
		//     container.appendChild(newImage);
		// }
	</script>

</body>
</html>