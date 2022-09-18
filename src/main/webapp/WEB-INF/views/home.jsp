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
	<script type="text/javascript">
		function makeCard(image, url, title, desc, comment) {
	        let tempHtml = `<div class="card">
	                <img class="card-img-top" src="${image}" alt="Card image cap">
	                <div class="card-body">
	                <a href="${url}" target="_blank" class="card-title">${title}</a>
	                <p class="card-text">${desc}</p>
	                <p class="card-text comment">${comment}</p>
	                </div>
	            </div>`;
	        $("#cards-box").append(tempHtml);
		}
	</script>
	
	<header>
		<div align="center">
			<h1>MY 냉장고</h1>
		</div>
	</header>
	<section>
		
		<div style="margin:20px; border:2px solid black;" >
			<div class="card-body">
				<div align="right">
				냉장고 : 
					<button data-bs-toggle="modal" data-bs-target="#modalSignin">생성</button>
					<button onclick="remove_div(this)">삭제</button>
				</div>
				냉장고
				<c:forEach items="${fList }" var="fridge varStatus="i">
					<div class="row">
						<div class="col">
							<div class="card col-sm-6" style="width: 18rem;">
								<img src=${fList.fridgeFilename } class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">${fList.fridgeNo }</h5>
									<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
									<a href="#" class="btn btn-warning">수정하기</a>
								</div>
							</div>
						</div>	
					</div>
				</c:forEach>
			</div>
		</div>
		
		
		
			<div id="cards-box"></div>
			<div id="field">
			</div>
	</section>
		
		
	
	
	<!-- Modal -->
	<div class="modal fade" id="modalSignin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
		
	
	
</body>
</html>