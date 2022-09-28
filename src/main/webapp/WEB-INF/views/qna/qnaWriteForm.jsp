<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의글 작성</title>
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

<br><br><br>
<h3 align="center">1:1 문의 작성</h3>
<br><br><br>
<div class="container">
<div class="table-responsive">
	<form action="/qna/qnaRegist.kh" method="post" enctype="multipart/form-data">
		<table align="center" border="1" class="table table-bordered">
			<tr>
				<td align="center" width="500">제목</td>
				<td><input type="text" name="questionTitle" style="width:950px; border:none"></td>
			</tr>
			<tr>
				<td align="center" width="500">작성자</td>
				<td><input type="text" name="questionWriter" value="${loginUser.userId }" style="width:950px; border:none" readonly></td>
			</tr>
			<tr>
				<td align="center" width="500">내용</td>
				<td><textarea cols="140" rows="20" name="questionContents" style="border:none"></textarea></td>
			</tr>
			<tr>
				<td align="center" width="500" >첨부파일</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
		</table>
				<span align="right">
					<button type="submit" class="btn-1">등록</button>
				</span>
	</form>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>