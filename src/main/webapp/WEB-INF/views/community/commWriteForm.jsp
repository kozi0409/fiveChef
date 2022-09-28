<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../main/user_navs.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
    .btn-1 {
    	margin : left;
        border: 0;
		background-color : rgb(209, 24, 79);
		color : white;
		border-radius : 10px;
		height : 50px;
		width : 100px;
    }
    .btn-2 {
        border: 0;
		color : rgb(209, 24, 79);
		background-color : rgb(217, 209, 209);
		border-radius : 10px;
		height : 50px;
		width : 100px;
    }

</style>
</head>
<body>
	<h1 align="center">게시글 등록 페이지</h1>
	<br><br>
	<div class="container">
	<div class="table-responsive">
	<form action="/community/commRegist.kh" method="post">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="communityTitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3"><input type="text" name="communityWriter" value="${loginUser.userId }" readonly></td>
			</tr>
			<tr>
				<td>게시판 유형</td>
				<td colspan="3">
					<select name="cBoardCode" class="code-select" onchange="handleOnchange(this)">
						<option value="free">자유게시판</option>
						<option value="sale">할인정보게시판</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="sale_text">할인가격</td>
				<td>
					<input class="sale_text" type="text" name="communityPrice">
				</td>
				<td class="sale_text">판매 사이트</td>
				<td class="sale_text"><input  class="sale_text" type="text" name="communitySalePage"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" ><textarea cols="140" rows="20" name="communityContents"></textarea></td>
			</tr>
		</table>
			<div style="display : inline-block;">
				<button type="submit" class="btn-1">등록</button>
			</div>
			<div style="display : inline-block;">
				<button onclick="back()" class="btn-2">취소</button>
			</div>
	</form>
	</div>
	</div>
	<script>
		$(".sale_text").css('display','none');
		function handleOnchange(e) {
			if(e.value == "sale") {
				$(".sale_text").css('display', 'inline-block');
			} else {
				$(".sale_text").css('display', 'none');
			}
		}
		function back() {
			
		}
	</script>
</body>
</html>