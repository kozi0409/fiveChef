<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<script src="../../../resources/js/jquery-3.6.1.min.js"></script>
	<title>냉장고 칸 페이지</title>
</head>


<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

	
	

	
	<div class="container">
	<header>
		<hr style="border-width:2px;">
		<div class="mt-5" align="center">
			<h1 align="center" >${fridgeName } 페이지</h1>
		</div>
	</header>
		<div class="card-body" style="height: 530px; background-color:gold; padding: 30px;">
		<div class="row">
			<div class="col" align="left">
				<button class="btn btn-secondary" onclick="location.href='/'">이전 페이지</button>
				<button class="btn btn-info" onclick="#">검색</button>
			</div>
			<div class="col" align="right">
				<button class="btn btn-primary" onclick="createStorage();">칸 생성</button><button class="btn btn-danger" onclick="deleteStorage();">칸 삭제</button>
			</div>
		</div>
		<hr style="border-width:2px;">
			<div class="row">
				<div class="col-3 justify-content-center">
					<input type="checkbox">
					<br>
					<div class="row">
						칸 이름
					</div>
					<br>
					<div class="row">
						대분류
						<select id="selLarge" style="width: 150px;" onchange="selectLargeBox(this.value, ${fridgeNo}, '${fridgeName }');">
							<c:forEach items="${lList }" var="largeCat"  varStatus="i">
								<option value="${largeCat.largeCatId }" <c:if test="${largeCat.largeCatId eq largeCatId }">selected</c:if>>${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class="row">
						소분류
						<select id="selSmall" style="width: 150px; height:100px;" multiple onchange="list_selected(this);">
							<c:forEach items="${sList }" var="smallCat"  varStatus="i">
								<option value="${smallCat.smallCatId }">${smallCat.smallCatName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="row" id="customInput" style="display:none;">
						<input type="text" placeholder="재료 검색">
					</div>
					<div class="row justify-content-center">
						<div class="col-5">
							<button class="btn btn-primary">재료 저장</button>
						</div>
						<div class="col-5">
							<button class="btn btn-danger">재료 삭제</button>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="row row-cols-2" id="gridDiv">
						<div class="col mt-3 mb-3">
							<div style="height:400px; background-color: gray; padding:20px;">
								<input type="checkbox" id="storage">
								<label for="storage">재료 칸</label>
								<hr style="border-width:2px;">
								<input type="hidden" value="values" name="values">
								<input type="hidden" value="texts" name="texts">
								<div id="values"></div>
								<div id="texts"></div>
							</div>
						</div>
<!-- 						<div class="col mt-3 mb-3"> -->
<!-- 							<div style="height:400px; background-color: gray; padding:20px;"> -->
<!-- 								<input type="checkbox">재료 칸 -->
<!-- 								<hr style="border-width:2px;"> -->
<!-- 								<input type="hidden" value="values" name="values"> -->
<!-- 								<input type="hidden" value="texts" name="texts"> -->
<!-- 								<div id="values"></div> -->
<!-- 								<div id="texts"></div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="col mt-3 mb-3"> -->
<!-- 							<div style="height:400px; background-color: gray; padding:20px;"> -->
<!-- 								<input type="checkbox">재료 칸 -->
<!-- 								<hr style="border-width:2px;"> -->
<!-- 								<input type="hidden" value="values" name="values"> -->
<!-- 								<input type="hidden" value="texts" name="texts"> -->
<!-- 								<div id="values"></div> -->
<!-- 								<div id="texts"></div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	
		var selectLargeBox = function(value, fNo, fName){
			event.preventDefault();
			var $form = $("<form>"); // <>꺽쇠를 적어야 태그 생성
			$form.attr("action", "/fridge/changeSmall.kh");
			$form.attr("method", "get");
			$form.append("<input type='hidden' value='"+value+"'name='largeCatId''>");
			$form.append("<input type='hidden' value='"+fNo+"' name='fridgeNo''>");
			$form.append("<input type='hidden' value='"+fName+"' name='fridgeName''>");
			$form.appendTo("body");
			$form.submit();
		}
		
		
		function list_selected(e) {
			const values = [];
			const texts = [];
			
			// options에서 selected 된 element 찾기
			for(let i=0; i < e.options.length; i++) {
				const option = e.options[i];
			  	if(option.selected) {
				    values.push(option.value);
				    texts.push(option.text);
			  	}
			}
			// 선택된 데이터 출력
			document.getElementById('values').innerText = values;
			document.getElementById('texts').innerText = texts;
		}
		
		var i = 1;
		function createStorage(){
			var $form = $("<form>");
// 			$form.attr("action", "/fridge/changeSmall.kh");
// 			$form.attr("method", "get");
			$form.append("<div class='col mt-3 mb-3'>");
			$form.append("<div style='height:400px; background-color: gray; padding:20px;'><input type='checkbox"+i+"' id='storage'><label for='storage'>재료 칸</label><hr style='border-width:2px;'></div>");
			$form.append("<input type='hidden' value='values' name='values'>");
			$form.append("<input type='hidden' value='texts' name='texts'>");
			$form.append("<input type='hidden' value='texts' name='texts'>");
			$form.append("<div id='values"+i+"'></div>");
			$form.append("<div id='texts"+i+'></div>");
			$form.appendTo("#gridDiv");
// 			$form.submit();
			i++;
			
		}
		
// 		<div class="col mt-3 mb-3">
// 			<div style="height:400px; background-color: gray; padding:20px;">
// 				<input type="checkbox" id="storage">
// 				<label for="storage">재료 칸</label>
// 				<hr style="border-width:2px;">
// 				<input type="hidden" value="values" name="values">
// 				<input type="hidden" value="texts" name="texts">
// 				<div id="values"></div>
// 				<div id="texts"></div>
// 			</div>
// 		</div>
		
		function deleteStorage(){
			 $("#boxWrap").append("<p class='original'>등장"+i+"</p>");
		}
		
		
// 		$.ajax({
// 		    url: "전송 페이지",
// 		    type: "POST",
// 		    data : "전송할 데이터",
// 		    dataType : "요청한 데이터 형식"(html/xml/json/text/jsonp),
// 		    success : (data)=>{
// 		        // 전송에 성공했을 때 실행될 함수 정의
// 		    }
// 		    error : ()=>{
// 		        // 전송에 실패했을 때 실행될 함수 정의
// 		    }
// 		})
	</script>
</body>
</html>


