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
		<hr style="border-width:1px;">
		<div class="mt-3" align="center">
			<h1 align="center" >${fridgeName } 페이지</h1>
		</div>
	</header>
		${stList }
		<div class="card-body" style="background-color:gold; padding: 30px;">
		<div class="row">
			<div class="col" align="left">
				<button class="btn btn-secondary" onclick="location.href='/'">이전 페이지</button>
				<button class="btn btn-info" onclick="console.log('검색');">검색</button>
			</div>
			<div class="col" align="right">
				<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createStorage">칸 생성</button>
				<button class="btn btn-danger" onclick="deleteStorage();">칸 삭제</button>
			</div>
		</div>
			<c:if test="${not empty stList }">
				<c:forEach items="${stList }" var="storage" varStatus="j">
					<hr style="border-width:2px;">
					<div class="row mb-2 mt-2">
						<div class="col-3" style="background-color:green;">
							<br>
							<div class="row">
								<div class="col-2">
									<input type="checkbox" name="storageBoxCheck" id="storageCheck${j.index }">
								</div>
								<div class="col">
									<h3>${storage.storageName }</h3>
								</div>
								<div class="col">
									<button class="btn btn-warning" onclick="#">이름 수정</button>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3 text-centered">
									<h6><b>대분류</b></h6>
								</div>
								<div class="col">
									<select id="selLarge" style="width: 150px;" onchange="selectLargeBox(this.value, ${fridgeNo}, '${fridgeName }',${j.index }, ${storage.storageNo });">
										<c:forEach items="${lList }" var="largeCat"  varStatus="i">
											<option id="largeCatOpt" value="${largeCat.largeCatId }" <c:if test="${largeCat.largeCatId  eq storage.largeCatId }">selected</c:if>>${largeCat.largeCatName }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<br>
							<div class="row">
							${storage.largeCatId }
								${storage.storageSelectNo}
								${j.index }
								${selectBoxNo }
								${selectBox.selectBoxNo }
								<div class="col-3 text-centered">
									<h6><b>소분류</b></h6>
								</div>
								<div class="col">
									<select id="selSmall" style="width: 150px; height:100px;" multiple onchange="list_selected(this);" >
										<c:forEach items="${sList }" var="smallCat"  varStatus="i">
											<option id="smallCatOpt" value="${smallCat.smallCatId }" ><c:if test="${smallCat.largeCatId eq storage.largeCatId }">${j.index},${selectBoxNo},${smallCat.smallCatName }</c:if></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row" id="customInput" style="display:none;">
								<input type="text" placeholder="재료 검색">
							</div>
							<br>
							<div class="row justify-content-center">
								<div class="col-5">
									<button class="btn btn-primary">재료 저장</button>
								</div>
								<div class="col-5">
									<button class="btn btn-danger">재료 삭제</button>
								</div>
							</div>
						</div>
						<div class="col" style="background-color:blue; padding:20px">
							<div class="row row-cols-6">
								<c:forEach var="i" begin="0" end="50">
									<div class="col">
										<div class="row">
											<div class="col-1">
												<input type="checkbox" id="ingredCheck${i }">
											</div>
											<div class="col">
												<label for="ingredCheck${i }">${i }재료명</label>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
		<c:if test="${empty stList }">
			<div>
				<div colspan="6" align="center"><h3><b>칸을 생성해 주세요.</b></h3></div>
			</div>
		</c:if>
		
		
		
		
		
		
		<!--Create Storage Modal -->
		<div class="modal fade" id="createStorage" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
				 	<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">칸 생성</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					    <div class="modal-body">
						    <div class="modal-body p-5 pt-0">
								<form action="/fridge/createStorage.kh?fridgeNo=${fridgeNo}&fridgeName=${fridgeName}" method="post">
									<br>
									<div class="form-floating mb-3">
										<input type="hidden" name="fridgeNo" value="${fridgeNo}">
										<input type="hidden" name="largeCatId" value="${largeCatId }">
										<input type="text" class="form-control rounded-4" id="storageName" placeholder="칸 이름 입력" name="storageName" required>
										<label for="floatingInput">칸 이름</label>
									</div>
									<button class="w-100 mb-2 btn btn-lg btn-primary" type="submit">생성 완료</button>
								</form>
							</div>
				    	</div>
				</div>
			</div>
		</div>	
		
		
		
	<script>
		function selectLargeBox(value, fNo, fName, jNo, sNo){
// 			value.preventDefault();
			var $form = $("<form>"); // <>꺽쇠를 적어야 태그 생성
			$form.attr("action", "/fridge/changeSmall.kh");
			$form.attr("method", "get");
			$form.append("<input type='hidden' value='"+value+"'name='largeCatId''>");
			$form.append("<input type='hidden' value='"+fNo+"' name='fridgeNo''>");
			$form.append("<input type='hidden' value='"+fName+"' name='fridgeName''>");
			$form.append("<input type='hidden' value='"+jNo+"' name='selectBoxNo'>");
			$form.append("<input type='hidden' value='"+sNo+"' name='storageNo''>");
			$form.appendTo("body");
			$form.submit();
		}
		
		
		function deleteStorage(val){
			if ($('input:checkbox[name="storageBoxCheck"]').is(':checked') == true){
				console.log($('input:checkbox[name="storageBoxCheck"]').attr("id"));
				var $form = $("<form>"); // <>꺽쇠를 적어야 태그 생성
				$form.attr("action", "/fridge/deleteStorage.kh");
				$form.attr("method", "post");
// 				$form.append("<input type='hidden' value='"+sNo+"'name='storageNo'>");
				$form.appendTo("body");
// 				$form.submit();
			} else {
				alert("아무것도 없음");
			}
			
// 			var $form = $("<form>"); // <>꺽쇠를 적어야 태그 생성
// 			$form.attr("action", "/fridge/deleteStorage.kh");
// 			$form.attr("method", "post");
// 			$form.append("<input type='hidden' value='"+value+"'name='largeCatId''>");
// 			$form.append("<input type='hidden' value='"+fNo+"' name='fridgeNo''>");
// 			$form.append("<input type='hidden' value='"+fName+"' name='fridgeName''>");
// 			$form.append("<input type='hidden' value='"+jNo+"' name='jNo''>");
// 			$form.appendTo("body");
// 			$form.submit();
			
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
		
		
		
		
		
		
		
// 		$(document).ready(function() {
// 		    $('#submit').click(function() {
// 		        if ($('#storageCheck${j.index }').is(":checked")) {
// 		            alert(storageCheck${j.index }+"선택");
// 		        } else {
// 		            alert("선택하지 않음");
// 		        }
// 		    })
// 		});
		
		
		
// 		var i = 1;
// 		function createStorage(){
// 			var $form = $("<form>");
// // 			$form.attr("action", "/fridge/changeSmall.kh");
// // 			$form.attr("method", "get");
// 			$form.append("<div class='col mt-3 mb-3'>");
// 			$form.append("<div style='height:400px; background-color: gray; padding:20px;'><input type='checkbox"+i+"' id='storage'><label for='storage'>재료 칸</label><hr style='border-width:2px;'></div>");
// 			$form.append("<input type='hidden' value='values' name='values'>");
// 			$form.append("<input type='hidden' value='texts' name='texts'>");
// 			$form.append("<input type='hidden' value='texts' name='texts'>");
// 			$form.append("<div id='values"+i+"'></div>");
// 			$form.append("<div id='texts"+i+'></div>");
// 			$form.appendTo("#gridDiv");
// // 			$form.submit();
// 			i++;
			
// 		}
		
		
		
		
		
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


