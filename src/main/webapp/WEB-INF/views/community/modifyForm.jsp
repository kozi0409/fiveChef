<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>게시글 수정</title>
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
	<h1 align="center">${community.communityNo }번 게시글 수정</h1>
	<br>
	<div class="container">
	<div class="table-responsive">
	<form action="/community/communityModify.kh" method="post">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" name="communityNo" value="${community.communityNo }">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="communityTitle" value="${community.communityTitle }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3"><input  type="text" name="communityWriter"value="${community.communityWriter }" readonly></td>
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
				<td colspan="3"><textarea cols="140" rows="20" name="communityContents">${community.communityContents }</textarea></td>
			</tr>
		</table>
		<br><br>
			<div style="display : inline-block;">
				<button type="submit" class="btn-1">수정</button>
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
			location.href = "/community/myCommunityList.kh"
		}
	</script>
</body>
</html>