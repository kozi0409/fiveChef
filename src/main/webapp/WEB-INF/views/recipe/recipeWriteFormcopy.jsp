<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/main/user_navs.jsp"></jsp:include>
<script src="../../../resources/js/jquery-3.6.1.min.js"></script>
<title>냉장고 셰프 레시피 작성</title>
<style>
	
	
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
	
		<div class="row g-5">
		  <div class="col-md-12 col-lg-12">
			<h4 class="mb-3">Billing address</h4>
			<form class="needs-validation" novalidate="">

			  <div class="row g-3" >

				<div class="col-md-5">
				  <label for="firstName" class="form-label">레시피 제목</label>
				  <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
				  <div class="invalid-feedback">
					Valid first name is required.
				  </div>
				</div>
	
				<div class="col-md-3">
				  <label for="lastName" class="form-label">작성자 아이디</label>
				  <input type="text" class="form-control" id="lastName" placeholder="" value="userId" required="" readonly>
				  <div class="invalid-feedback">
					Valid last name is required.
				  </div>
				</div>
				
				<div class="col-md-4">
					<label for="thumbnail" class="form-label">썸네일 사진 선택</label>
					<input type="file" class="form-control" id="thumbnail">
				</div>
				  
				

				<div class="input-group col-md-4">
					<span class="input-group-text">레시피 소개</span>
					<textarea class="form-control" aria-label="With textarea"></textarea>
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
					<input type="text" class="form-control" name="ingBundleName"  id="ingBundleName" placeholder="예) 김치찌개" required="">
					<div class="invalid-feedback">
						Please enter your shipping address.
					</div>
					</div>
				</div>

				<!-- 여기서부터 append -->
				<div class="col-12"><p class="fw-bolder">재료등록</p></div>
				<div id="ing-app">
				<div class="row g-1" >
					<div class="col-md-2">
						<select class="form-select" name="largeCatId" id="largeCatId" required="">
							<option value="" selected>재료카테고리</option>
							
						</select>
						<div class="invalid-feedback">
						  Please select a valid country.
						</div>
					</div>
				
					<div class="col-md-2">
						<select class="form-select" name="smallCatId" id="smallCatId" required="">
							<option value="" selected>재료</option>
							
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
			
					<input type="button" class="btn-check" name="btnradio" id="ing-add1" onclick="" >
					<label class="btn btn-outline-primary" for="btnradio2">추가</label>
					<button id="ing-add">sdf</button>
					<input type="radio" class="btn-check" name="btnradio" id="ing-del" autocomplete="off">
					<label class="btn btn-outline-primary" for="btnradio3">삭제</label>
				  </div>
				  <div id="mainDiv">
					<button id="firstButton">첫 번째 버튼</button>
				</div>

	
			  <hr class="my-4">
	
			  <div class="form-check">
				<input type="checkbox" class="form-check-input" id="same-address">
				<label class="form-check-label" for="same-address">Shipping address is the same as my billing address</label>
			  </div>
	
			  <div class="form-check">
				<input type="checkbox" class="form-check-input" id="save-info">
				<label class="form-check-label" for="save-info">Save this information for next time</label>
			  </div>
	
			  <hr class="my-4">
	
			  <h4 class="mb-3">Payment</h4>
	
			  <div class="my-3">
				<div class="form-check">
				  <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked="" required="">
				  <label class="form-check-label" for="credit">Credit card</label>
				</div>
				<div class="form-check">
				  <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
				  <label class="form-check-label" for="debit">Debit card</label>
				</div>
				<div class="form-check">
				  <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required="">
				  <label class="form-check-label" for="paypal">PayPal</label>
				</div>
			  </div>
	
			  <div class="row gy-3">
				<div class="col-md-6">
				  <label for="cc-name" class="form-label">Name on card</label>
				  <input type="text" class="form-control" id="cc-name" placeholder="" required="">
				  <small class="text-muted">Full name as displayed on card</small>
				  <div class="invalid-feedback">
					Name on card is required
				  </div>
				</div>
	
				<div class="col-md-6">
				  <label for="cc-number" class="form-label">Credit card number</label>
				  <input type="text" class="form-control" id="cc-number" placeholder="" required="">
				  <div class="invalid-feedback">
					Credit card number is required
				  </div>
				</div>
	
				<div class="col-md-3">
				  <label for="cc-expiration" class="form-label">Expiration</label>
				  <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
				  <div class="invalid-feedback">
					Expiration date required
				  </div>
				</div>
	
				<div class="col-md-3">
				  <label for="cc-cvv" class="form-label">CVV</label>
				  <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
				  <div class="invalid-feedback">
					Security code required
				  </div>
				</div>
			  </div>
	
			  <hr class="my-4">
	
			  <button class="w-10 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
			</form>
		  </div>
		</div>
	  </main>
	
	  
	  </footer>
	</div>
	
	  
	
	</body>

<h2 align="center">레시피 등록</h2>
	<form action="/recipe/recipeRegister.kh" method="post" enctype="multipart/form-data">
		<table align="center" border="1"  width="900">
			<tr>
				<td>제목</td>
				<td>
				<input type="text" name="recipeTitle">
				</td>
				<td rowspan="3"  width="200" height="200" align="center">
			<!-- 	<div class="button">
					<label for="chooseFile">
						👉 CLICK HERE! 👈
					</label>
				</div> -->
				<input type="file" id="chooseFile" name="uploadFile" accept="image/*">
				<!-- <div align="left" class="fileInput">
                 <div class="image-show" id="image-show"></div>   
                    <div ><p id="fileName" ></p></div>
                </div> -->
                
				</td>
			</tr>	
			<tr>
				<td>작성자</td>
				<td><input type="text" name="userId" value="user1"></td>
			</tr>	
			<tr>
				<td>요리소개</td>
				<td><textarea rows="7" cols="30" name="recipeIntro"></textarea></td>
			</tr>	
			<tr>
				<td>카테고리</td>
				<td colspan="2">
					<select name="typeCategory">
						<option value="" selected>종류별</option>
						<option value="1">일식</option>
						<option value="2">중식</option>
						<option value="3">한식</option>
						<option value="4">양식</option>
					</select>
					<select name="wayCategory">
						<option value="" selected>방법별</option>
						<option value="5">볶음</option>
						<option value="6">찜</option>
						<option value="7">끓이기</option>
						<option value="8">기타</option>
					</select>
				</td>
			</tr>	
			<tr>
				<td>요리정보</td>
				<td colspan="2">
					<select name="recipePerson" >
						<option value="" selected>인원</option>
						<option value="1">1인분</option>
						<option value="2">2인분</option>
						<option value="3">3인분</option>
						<option value="4">4인분</option>
						<option value="5">5인분</option>
						<option value="6">6인분</option>
						<option value="7">6인분이상</option>
					</select>
					<select name="recipeTime">
						<option value="" selected>시간</option>
						<option value="5">5분이내</option>
						<option value="10">10분이내</option>
						<option value="30">30분이내</option>
						<option value="60">60분이내</option>
						<option value="90">90분이내</option>
						<option value="120">2시간이내</option>
						<option value="150">2시간이상</option>
					</select>
					<select name="recipeLevel">
						<option value="" selected>난이도</option>
						<option value="1">★☆☆☆☆</option>
						<option value="2">★★☆☆☆</option>
						<option value="3">★★★☆☆</option>
						<option value="4">★★★★☆</option>
						<option value="5">★★★★★</option>
					</select>
				</td>
			</tr>	
		</table>
		<br>
		<table align="center" border="1" width="900">
			<tr>
				<td><input type="text" name="ingBundleName" placeholder="요리명" value="김치찌개"></td>
				<td align="center">
				<input type="text" name="largeCatId" placeholder="재료대분류" value="야채"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="감자"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="1개">
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="야채"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="양파"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="1개">     
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="육류"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="돼지고기"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="300g"> 
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="육류"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="소고기"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="400g">   
				</td>
			</tr>	
			<tr><td colspan="2"align="center"><button type="button" >재료추가</button></td></tr>
		</table>		
		<br>
		<table align="center" border="1" height="" width="900">
			<tr>
				<td><b>Step1</b></td>
				<td><textarea rows="11" cols="45" name="recipeContents"></textarea></td>
				<td align="center" width="200" height="200"><input type="file" id="" name="ouploadFile" accept="image/*"></td>
			</tr>	
			<tr>
				<td><b>Step2</b></td>
				<td><textarea rows="11" cols="45" name="recipeContents"></textarea></td>
				<td align="center" width="200" height="200"><input type="file" id="" name="ouploadFile" accept="image/*"></td>
			</tr>	
		</table>	
		<br>
		<table class="comPhoto" align="center" border="1" height="250" width="900">
			<tr>
				<td><input type="file" id="" name="cuploadFile" accept="image/*"></td>
				<td><input type="file" id="" name="cuploadFile" accept="image/*"></td>
				<td><input type="file" id="" name="cuploadFile" accept="image/*"></td>
				<td><input type="file" id="" name="cuploadFile" accept="image/*"></td>
			</tr>
		</table>
		<br>
		<div align="center">
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		</div>
	</form>
	<script>
	function loadFile(input) {
		var file = input.files[0];	//선택된 파일 가져오기

	    //미리 만들어 놓은 div에 text(파일 이름) 추가
	    var name = document.getElementById('fileName');
	    name.textContent = file.name;
	  //새로운 이미지 div 추가
	    var newImage = document.createElement("img");
	    newImage.setAttribute("class", 'img');

	    //이미지 source 가져오기
	    newImage.src = URL.createObjectURL(file);   

	    newImage.style.width = "70%";
	    newImage.style.height = "70%";
	    newImage.style.visibility = "visible";   //버튼을 누르기 전까지는 이미지를 숨긴다
	    newImage.style.objectFit = "contain";

	    //이미지를 image-show div에 추가
	    var container = document.getElementById('image-show');
	    container.appendChild(newImage);
	}

$(document).ready(function() {
	//첫 번째 버튼 이벤트
	// $("#firstButton").on("click", function() {
		// 	var bodyHtml = "<button id='secondButton'>두 번째 버튼</button>";
		// 	$("#mainDiv").append(bodyHtml);
		// });
		$("#ing-add").on("click",function(){
			$("#ing-app").append("<div>아하하</div>");
	});
	
	</script>

</body>
</html>