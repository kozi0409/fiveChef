<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

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

</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	

<body>
<!-- navs bar -->
<jsp:include page="../main/user_navs.jsp"></jsp:include>
	
	<header>
	</header>
	<section>
		<div class="container" >
		<hr>
		<div class="mt-3" align="center">
			<h1>MY 냉장고</h1>
		</div>
			<div class="card-body" style="width:100%; background-color:rgb(255, 198, 198); padding: 20px; border-radius: 10px;">
				<div align="right">
					<div class="row">
						<div class="col">
						</div>
						<div class="col">
						</div>
						<div class="col">
							<div class="row">
								<div class="col">
									 
								</div>
								<div class="col">
									<button class="w-100 mb-2 btn btn-lg btn-primary" data-bs-toggle="modal" data-bs-target="#createFridge" id="btn-2" <c:if test="${checkYn == false }">disabled</c:if> >냉장고 생성</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<c:if test="${not empty fList }">
					<div class="row">
						<c:forEach items="${fList }" var="fridge" varStatus="i">
								<div class="col">
									<div class="card col-sm-4" style="width: 18rem;" >
										<div style="cursor : pointer;" onclick="location.href='/fridge/storage.kh?fridgeNo=${fridge.fridgeNo}&fridgeName=${fridge.fridgeName }'">
											<img src=<c:if test="${not empty fridge.fridgeFileRename }">"/resources/fuploadFiles/${fridge.fridgeFileRename }"</c:if><c:if test="${empty fridge.fridgeFileRename }">"/resources/images/defaultImages.jpg"</c:if> class="card-img-top" alt="...">
											<hr style="border-width:1px;">
										</div>
										<div class="card-body text-center">
											<h5 class="card-title">${fridge.fridgeName }</h5>
<!-- 											<p class="card-text"></p> -->
											<button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modifyFridge${i.index }">수정하기</button>
											<button class="btn btn-danger" onclick="removeFridge(${fridge.fridgeNo });">삭제하기</button>										
										</div>
									</div>
								</div>
								<!--modify Modal -->
								<div class="modal fade" id="modifyFridge${i.index }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered">
										<div class="modal-content">
										 	<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">냉장고 수정</h5>
												<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											    <div class="modal-body">
												    <div class="modal-body p-5 pt-0">
														<form action="/fridge/modify.kh" method="post" enctype="multipart/form-data">
															<input type="hidden" name="fridgeNo" value="${fridge.fridgeNo }" required>
															<br>
															<div class="form-floating mb-3">
															<input type="text" class="form-control rounded-4" id="fridgeName" placeholder="냉장고 이름 입력" name="fridgeName" value="${fridge.fridgeName }">
															<label for="floatingInput">냉장고 이름</label>
															</div>
															<div class="mb-3">
															프로필 사진 등록
															<c:if test="${not empty fridge.fridgeFilename }">
																<div>
																	기존 파일 : ${fridge.fridgeFilename }
																</div>
															</c:if>
															<input class="form-control mt-1" type="file" id="formProfile" name="reloadFile">
															</div>
															<button class="w-100 mb-2 btn btn-lg btn-primary" type="submit">수정 완료</button>
														</form>
													</div>
										    	</div>
										</div>
									</div>
								</div>	
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${empty fList }">
					<div>
						<div colspan="6" align="center"><h3><b>냉장고를 생성해 주세요.</b></h3></div>
					</div>
				</c:if>
			</div>
		</div>
		
		
		
			<div id="cards-box"></div>
			<div id="field">
			</div>
	</section>
		
		
	<!--resist Modal -->
	<div class="modal fade" id="createFridge" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">냉장고 생성</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <div class="modal-body p-5 pt-0">
		        <form action="/fridge/register.kh" method="post" enctype="multipart/form-data">
		        <br>
		          <div class="form-floating mb-3">
		            <input type="text" class="form-control rounded-4" id="fridgeName" placeholder="냉장고 이름 입력" name="fridgeName" required>
		            <label for="floatingInput">냉장고 이름</label>
		          </div>
		          <div class="mb-3">
					  프로필 사진 등록
					  <input class="form-control" type="file" id="formProfile" name="uploadProfile">
				  </div>
		          <button class="w-100 mb-2 btn btn-lg btn-primary" type="submit">냉장고 생성</button>
		        </form>
		      </div>
	        </div>
	     </div>
	  </div>
	</div>
	

	
	<script>
		function removeFridge(fNo){
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("다시 복원 할 수 없습니다.\n정말 삭제하시겠습니까?")){
				location.href="/fridge/removeFridge.kh?fridgeNo="+fNo;
			}
		}
	</script>
	
	<!-- copyright -->
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>