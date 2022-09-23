<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../../../resources/js/jquery-3.6.1.min.js"></script>
<jsp:include page="/WEB-INF/views/main/user_navs.jsp"></jsp:include>
<title>냉장고 셰프 레시피 작성</title>
<style>
	
	#main-form{
		margin-left: 10%;
		margin-right: 10%;
	}
	textarea.form-controls{
		min-height:calc(1.5em + 2rem + 2px);
		border: #333;
		border:1px solid #ced4da;
		border-radius:.25rem;
	}
	.form-controls:focus{
		color:#212529;background-color:#fff;
		border-color:#86b7fe;outline:0;
		box-shadow:0 0 0 .25rem rgba(13,110,253,.25)
	}
	#btn-2 {
        border : 0;
        color: white;
        background-color:  rgb(209, 24, 79);
      }
	#btn-2{
		color:#fff;
		background-color:rgb(209, 24, 79);
		border-color:rgb(209, 24, 79)
	}
	#btn-2:hover{
		color:#fff;background-color:rgb(216, 50, 100);
		border-color:rgb(216, 50, 100)
	}
	.btn-outline-primary{
		color:rgb(209, 24, 79);
		border-color:rgb(209, 24, 79)
	}
	.btn-outline-primary:hover{
		color:#fff;background-color:rgb(209, 24, 79);
		border-color:rgb(209, 24, 79)
	}
	#cutline {
	visibility: hidden;
	}

</style>
<script>
	
</script>
</head>
<body class="bg-light vsc-initialized">
    
	<div class="container">
	  <main>
		<div class="py-5 text-center">
		  <h2>레시피 작성</h2>
		</div>
	
		<div class="row g-5" id="main-form">
		  <div class="col-md-12 col-lg-12">
			<h4 class="mb-3"><b>레시피 정보를 입력해 주세요</b></h4>
			<form class="needs-validation" action="/recipe/recipeRegister.kh" method="post" enctype="multipart/form-data">

			  <div class="row g-3" >

				<div class="col-md-5">
				  <label for="firstName" class="form-label">레시피 제목</label>
				  <input type="text" class="form-control" id="firstName" name="recipeTitle" placeholder="예) 둘이 먹다 하나가 죽어도 모를 김치찌개" value="" required="">
				  <div class="invalid-feedback">
					Valid first name is required.
				  </div>
				</div>
	
				<div class="col-md-3">
				  <label for="lastName" class="form-label">작성자 아이디</label>
				  <input type="text" class="form-control" id="lastName" placeholder=""  name="userId" value="${loginUser.userId }" required="" readonly>
				  <div class="invalid-feedback">
					Valid last name is required.
				  </div>
				</div>
				
				<div class="col-md-4">
					<label for="thumbnail" class="form-label">썸네일 사진 선택</label>
					<input type="file" class="form-control" id="thumbnail" name="uploadFile" accept="image/*">
				</div>
				  
				<div class="input-group col-md-4">
					<span class="input-group-text">레시피 소개</span>
					<textarea class="form-controls" cols="83" rows="5" aria-label="With textarea" name="recipeIntro" placeholder=" 맛있는 레시피의 소개를 적어주세요!"></textarea>
				</div>		
			  
				<div class="row g-3" >
				<div class="col-md-2">
					<label for="typeCategory" class="form-label">종류별 카테고리</label>
					<select class="form-select" name="typeCategory" id="typeCategory" required="">
						<option value="" selected>종류별</option>
						<option value="1">일식</option>
						<option value="2">중식</option>
						<option value="3">한식</option>
						<option value="4">양식</option>
					</select>
					<div class="invalid-feedback">
					  Please select a valid country.
					</div>
				</div>

				<div class="col-md-2">
					<label for="wayCategory" class="form-label">방법별 카테고리</label>
					<select class="form-select" name="wayCategory" id="wayCategory" required="">
						<option value="" selected>방법별</option>
						<option value="5">볶음</option>
						<option value="6">찜</option>
						<option value="7">끓이기</option>
						<option value="8">기타</option>
					</select>
					<div class="invalid-feedback">
					  Please select a valid country.
					</div>
				</div>
				</div>


				<div class="row g-3" >
					<div class="col-md-2">
						<label for="recipePerson" class="form-label">인원수</label>
						<select class="form-select" name="recipePerson" id="recipePerson" required="">
							<option value="" selected>인원</option>
							<option value="1">1인분</option>
							<option value="2">2인분</option>
							<option value="3">3인분</option>
							<option value="4">4인분</option>
							<option value="5">5인분</option>
							<option value="6">6인분</option>
							<option value="7">6인분이상</option>
						</select>
						<div class="invalid-feedback">
					  	Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<label for="recipeTime" class="form-label">요리시간</label>
						<select class="form-select" name="recipeTime" id="recipeTime" required="">
							<option value="" selected>시간</option>
							<option value="5">5분이내</option>
							<option value="10">10분이내</option>
							<option value="30">30분이내</option>
							<option value="60">60분이내</option>
							<option value="90">90분이내</option>
							<option value="120">2시간이내</option>
							<option value="150">2시간이상</option>
						</select>
						<div class="invalid-feedback">
					  	Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<label for="recipeLevel" class="form-label">난이도</label>
						<select class="form-select" name="recipeLevel" id="recipeLevel" required="">
							<option value="" selected>난이도</option>
							<option value="1">★☆☆☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="3">★★★☆☆</option>
							<option value="4">★★★★☆</option>
							<option value="5">★★★★★</option>
						</select>
						<div class="invalid-feedback">
						  Please select a valid country.
						</div>
					</div>
				</div>
				<br>
				<hr class="my-4">
				<br>
				<div class="row g-3">
					<div class="col-md-2">
					<label for="ingBundleName" class="form-label"><h4 class="mb-3"><b>요리명</b></h4></label>
					<input type="text" class="form-control-lg" name="ingBundleName"  id="ingBundleName" placeholder="예) 김치찌개" required="">
					<div class="invalid-feedback">
						Please enter your shipping address.
					</div>
					</div>
				</div>

				<div class="col-12"><p class="fw-bolder ">재료등록</p></div>
				
				<!-- 여기서부터 append -->
				<div id="mainDiv" class="row g-1" >
				<div id="">
				<div id="" class=" row g-1" >
					<div class="col-md-2">
						<select class="form-select" name="largeCatId" id="largeCatId" required="">
							<option value="" selected="selected">대분류 선택</option>
						   <c:forEach items="${lList }" var="largeCat"  varStatus="i">
							<option id="largeCatOpt" value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
				
					<div class="col-md-2">
						<select class="form-select" name="smallCatId" id="smallCatId" required="">
							<option value="" selected>재료선택</option>
   						<c:forEach items="${sList }" var="smallCat"  varStatus="i">
							<option value="${smallCat.smallCatId }" class="${smallCat.largeCatId }">${smallCat.smallCatName }</option>
						</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" name="ingAmount" id="ingAmount" placeholder="예) 300g" required="">
						<div class="invalid-feedback">
							Please enter your shipping address.
						</div>
					</div>
				</div>
				

				</div>
				<div id="">
				<div id="" class=" row g-1" >
					<div class="col-md-2">
						<select class="form-select" name="largeCatId" id="largeCatId" required="">
							<option value="" selected="selected">대분류 선택</option>
						   <c:forEach items="${lList }" var="largeCat"  varStatus="i">
							<option id="largeCatOpt" value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
				
					<div class="col-md-2">
						<select class="form-select" name="smallCatId" id="smallCatId" required="">
							<option value="" selected>재료선택</option>
   						<c:forEach items="${sList }" var="smallCat"  varStatus="i">
							<option value="${smallCat.smallCatId }" class="${smallCat.largeCatId }">${smallCat.smallCatName }</option>
						</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" name="ingAmount" id="ingAmount" placeholder="예) 300g" required="">
						<div class="invalid-feedback">
							Please enter your shipping address.
						</div>
					</div>
				</div>
				

				</div>
				<div id="">
				<div id="" class=" row g-1" >
					<div class="col-md-2">
						<select class="form-select" name="largeCatId" id="largeCatId" required="">
							<option value="" selected="selected">대분류 선택</option>
						   <c:forEach items="${lList }" var="largeCat"  varStatus="i">
							<option id="largeCatOpt" value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
				
					<div class="col-md-2">
						<select class="form-select" name="smallCatId" id="smallCatId" required="">
							<option value="" selected>재료선택</option>
   						<c:forEach items="${sList }" var="smallCat"  varStatus="i">
							<option value="${smallCat.smallCatId }" class="${smallCat.largeCatId }">${smallCat.smallCatName }</option>
						</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" name="ingAmount" id="ingAmount" placeholder="예) 300g" required="">
						<div class="invalid-feedback">
							Please enter your shipping address.
						</div>
					</div>
				</div>
				

				</div>
				
				<div id="ing-app" class="ingapp row g-1" >
					<div class="col-md-2">
						<select class="form-select" name="largeCatId" id="largeCatId" required="">
							<option value="" selected="selected">대분류 선택</option>
						   <c:forEach items="${lList }" var="largeCat"  varStatus="i">
							<option id="largeCatOpt" value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
				
					<div class="col-md-2">
						<select class="form-select" name="smallCatId" id="smallCatId" required="">
							<option value="" selected>재료선택</option>
   						<c:forEach items="${sList }" var="smallCat"  varStatus="i">
							<option value="${smallCat.smallCatId }" class="${smallCat.largeCatId }">${smallCat.smallCatName }</option>
						</c:forEach>
						</select>
						<div class="invalid-feedback">
						Please select a valid country.
						</div>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" name="ingAmount" id="ingAmount" placeholder="예) 300g" required="">
						<div class="invalid-feedback">
							Please enter your shipping address.
						</div>
					</div>
				</div>
				

				</div>
				
				<!-- -- -->
				<div class="btn-group col-md-3" role="group" aria-label="Basic radio toggle button group">
					<input type="radio" class="btn-check" name="btnradio" id="ing-add" ></input>
					<label class="btn btn-outline-primary" for="btnradio2" onclick="adding()">추가</label>
					<input type="radio" class="btn-check" name="btnradio" id="ing-del" autocomplete="off">
					<label class="btn btn-outline-primary" for="btnradio3" onclick="deling()">삭제</label>
				</div>	  
					

	
			  <hr class="my-4">
				
			  <!-- 여기서부터  order-->
				<div class="col-12"><p class="fw-bolder "><h4><b>요리순서</b></h4></div>
				<div id="orderDiv">
					<div id="order-app" class="orderapp row g-3" >
						<div class="input-group col-md-4">
							<span class="input-group-text">Step</span>
							<textarea class="form-controls" cols="83" rows="5" aria-label="With textarea" name="recipeContents" placeholder="요리 방법을 적어주세요!"></textarea>
						</div>		
						<div class="col-md-4">
							<label for="orderPhoto" class="form-label"></label>
							<input type="file" class="form-control" id="orderPhoto" name="ouploadFile" accept="image/*">
						</div>
						<hr id="cutline">
					</div>
				</div>
				
				<!-- -- -->
				<div class="btn-group col-md-3" role="group" aria-label="Basic radio toggle button group">
					<input type="radio" class="btn-check" name="btnradio" id="order-add" ></input>
					<label class="btn btn-outline-primary" for="btnradio2" onclick="addorder()">추가</label>
					<input type="radio" class="btn-check" name="btnradio" id="order-del" autocomplete="off">
					<label class="btn btn-outline-primary" for="btnradio3" onclick="delorder()">삭제</label>
				</div>	
			  </div>
	
			  <hr class="my-4">
			  <br>
			  <div class="col-12"><p class="fw-bolder "><h4><b>완성사진등록</b></h4></div>
				<br><br>
				<div class="row g-3">
					<div class="col-md-3">
						<label for="thumbnail1" class="form-label">완성사진1</label>
						<input type="file" class="form-control" id="thumbnail1" name="cuploadFile" accept="image/*">
					</div>
					<div class="col-md-3">
						<label for="thumbnail2" class="form-label">완성사진2</label>
						<input type="file" class="form-control" id="thumbnail2" name="cuploadFile" accept="image/*">
					</div>
					<div class="col-md-3">
						<label for="thumbnail3" class="form-label">완성사진3</label>
						<input type="file" class="form-control" id="thumbnail3" name="cuploadFile" accept="image/*">
					</div>
					<div class="col-md-3">
						<label for="thumbnail4" class="form-label">완성사진4</label>
						<input type="file" class="form-control" id="thumbnail4" name="cuploadFile" accept="image/*">
					</div>
				</div>
				<br>
	
			  <hr class="my-4">
				<div class="row">
					<button class="btn btn-primary btn-lg col-md-6" id="btn-2" type="submit">레시피 저장</button>
					<button class="btn btn-primary btn-lg col-md-6" id="btn-2" type="reset">취소</button>
				</div>
			  
			  <br><br><br>
			</form>
		  </div>
		</div>
	  </main>
	
	</div>
	<footer>
	<jsp:include page="/WEB-INF/views/main/footer.jsp"></jsp:include>
	
	   </footer>
	<script>
		var malls = false;

	function update_selected() {
		$("#smallCatId").val(0);
		$("#smallCatId").find("option[value!=0]").detach();

		$("#smallCatId").append(malls.filter("." + $(this).val()));
		}
		// console.log($(this).val())
	$(function() {
		malls = $("#smallCatId").find("option[value!=0]");
		malls.detach();

		$("#largeCatId").change(update_selected);
		$("#largeCatId").trigger("change");
	});

	var ingNode =document.querySelector('#ing-app');
	function adding(){
		console.log(ingNode)
		mainDiv.appendChild(ingNode.cloneNode(true));
	}
	
	function deling(){
	var ingNodeClass =document.querySelectorAll('.ingapp');
			console.log(ingNodeClass[0])
			ingNodeClass[0].remove();	
	}

	var orderNode =document.querySelector('#order-app');
	function addorder(){
		console.log(orderNode)
		orderDiv.appendChild(orderNode.cloneNode(true));
	}
	
	function delorder(){
	var orderNodeClass =document.querySelectorAll('.orderapp');
			console.log(orderNodeClass[0])	
			orderNodeClass[0].remove();
	}
	$(document).ready(function() {
	
	});
	
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