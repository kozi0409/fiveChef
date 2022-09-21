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
<!-- <link href="../../resources/css/maincss.css" rel="stylesheet"> -->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"  integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> -->

</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	
	<header>
		<hr style="border-width:2px;">
		<div class="mt-5" align="center">
			<h1>MY 냉장고</h1>
		</div>
	</header>
	<section>
		<div class="container" >
			<div class="card-body" style="width:100%; background-color:gray; padding: 20px; border-radius: 10px;">
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
								<c:if test="${checkYn == true }">
									<button class="w-100 mb-2 btn btn-lg btn-primary" data-bs-toggle="modal" data-bs-target="#createFridge">냉장고 생성</button>
								</c:if>
								<c:if test="${checkYn == false }">
									<button class="w-100 mb-2 btn btn-lg btn-primary" data-bs-toggle="modal" data-bs-target="#createFridge" disabled>냉장고 생성</button>
								</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
				<c:if test="${not empty fList }">
					<div class="row">
						<c:forEach items="${fList }" var="fridge" varStatus="i">
								<div class="col">
									<div class="card col-sm-4" style="width: 18rem; cursor : pointer;" onclick="location.href='/fridge/storage.kh'">
										<img src=<c:if test="${not empty fridge.fridgeFileRename }">"/resources/fuploadFiles/${fridge.fridgeFileRename }"</c:if><c:if test="${empty fridge.fridgeFileRename }">"/resources/images/defaultImages.jpg"</c:if> class="card-img-top" alt="...">
										<hr style="border-width:3px;">
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
<%-- 															<input type="hidden" name="page" value="${page }"> --%>
															<input type="hidden" name="fridgeNo" value="${fridge.fridgeNo }">
<%-- 															<input type="hidden" name="boardFilename" value="${board.boardFilename }"> --%>
<%-- 															<input type="hidden" name="boardFileRename" value="${board.boardFileRename }"> --%>
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
					<tr>
						<td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td>
					</tr>
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
		            <input type="text" class="form-control rounded-4" id="fridgeName" placeholder="냉장고 이름 입력" name="fridgeName">
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
	
<!-- 	<!--modify Modal -->
<!-- 	<div class="modal fade" id="modifyFridge" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!-- 	  <div class="modal-dialog modal-dialog-centered"> -->
<!-- 	    <div class="modal-content"> -->
<!-- 	      <div class="modal-header"> -->
<!-- 	        <h5 class="modal-title" id="exampleModalLabel">냉장고 수정111</h5> -->
<!-- 	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
<!-- 	      </div> -->
<!-- 	      <div class="modal-body"> -->
<!-- 	        <div class="modal-body p-5 pt-0"> -->
<!-- 		        <form action="/fridge/modify.kh" method="post" enctype="multipart/form-data"> -->
<%-- 		        <input type="hidden" name="fridgeNo" value="${fridge.fridgeNo }"> --%>
<!-- 		        <br> -->
<!-- 		          <div class="form-floating mb-3"> -->
<%-- 		            <input type="text" class="form-control rounded-4" id="fridgeName" placeholder="냉장고 이름 입력" name="modifyFridgeName" value="${mFridge.fridgeName }"> --%>
<!-- 		            <label for="floatingInput">냉장고 이름</label> -->
		            
<!-- 		          </div> -->
<!-- 		          <div class="mb-3"> -->
<!-- 					  프로필 사진 등록 -->
<%-- 					  <input class="form-control" type="file" id="formProfile" name="uploadProfile" value="${mFridge.fridgeFilename }"> --%>
<!-- 				  </div> -->
<!-- 		          <button class="w-100 mb-2 btn btn-lg btn-primary" type="submit">수정 완료</button> -->
<!-- 		        </form> -->
<!-- 		      </div> -->
<!-- 	        </div> -->
<!-- 	     </div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
	
	<script>
		function removeFridge(fNo){
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("다시 복원 할 수 없습니다.\\n정말 삭제하시겠습니까?")){
				location.href="/fridge/removeFridge.kh?fridgeNo="+fNo;
			}
		}
	</script>
	
	
</body>
</html>