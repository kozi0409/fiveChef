<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
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
				<button class="btn btn-info" onclick="#">검색</button>
			</div>
			<div class="col" align="right">
				<button class="btn btn-primary" onclick="#">칸 생성</button><button class="btn btn-danger" onclick="#">칸 삭제</button>
			</div>
		</div>
		<hr style="border-width:2px;">
			<div class="col">
				<div class="row mb-3 mt-3 text-center"  >
					<div class="col" align="left" >
						<input type="checkbox">
					</div>
					<div class="col" align="left" >
						<div>
							칸 이름
						</div>
					</div>
					<div class="col">
						대분류	
						<select id="selLarge" onchange="selectBoxChange(this.value, ${fridgeNo }, ${fridgeName })">
							<c:forEach items="${lList }" var="largeCat"  varStatus="i">
								<option value="${largeCat.largeCatId }">${largeCat.largeCatName }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="col" id="smallCatDiv">
						소분류
						<select>
							<c:forEach items="${sList }" var="smallCat"  varStatus="i">
								<c:if test="${smallCat.largeCatId  eq 'A1'}">
									<option value="${smallCat.smallCatId }" selected>${smallCat.smallCatName }</option>
								</c:if>
								<c:if test="${smallCat.largeCatId  ne 'A1'}">
									<option value="${smallCat.smallCatId }">${smallCat.smallCatName }</option>
								</c:if>
<%-- 								<c:if test="${largeCat.largeCatName eq '기타' }"> --%>
									
<%-- 								</c:if> --%>
							</c:forEach>
						</select>
					</div>
					<div class="col" id="customInput" style="display:none;">
						<input type="text" placeholder="재료 검색">
					</div>
					<div class="col">
						<button class="btn btn-danger">재료 삭제</button>
					</div>
				</div>
				<div class="row">
					<div style="height:300px; background-color: gray; padding:20px;">
						재료 칸
						<hr style="border-width:2px;">
					</div>
				</div>
				<div class="row">
					<div class="col mt-2 text-center">
						<button class="btn btn-primary">재료 저장</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	
	var selectBoxChange = function(value, fNo, fName){
		console.log(value);
		var $form = $("<form>"); // <>꺽쇠를 적어야 태그 생성
		$form.attr("action", "/fridge/changeSmall.kh");
		$form.attr("method", "get");
		$form.append("<input type='hidden' value='"+value+"'name='largeCatId''>");
		$form.append("<input type='hidden' value='"+fNo+"' name='fridgeNo'>");
		$form.append("<input type='hidden' value='"+fName+"' name='fridgeName'>");
		$form.appendTo("body");
		$form.submit();
	}
// 		function viewInput(){
// 			if(document.QuerySelector("#smallCatDiv")))
// 		}
// 		var largeCatId = 
		
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


