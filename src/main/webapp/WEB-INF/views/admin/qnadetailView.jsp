<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 문의 내용</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<c:if test="${not empty loginAdmin}">
<div class="container" style="width: 700px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		    <h2 style="color: #8ba525;">${qna.questionNo }번 문의글 상세 보기</h2>
			<input type="hidden" name="page" value="${page }">
			<table class="table table-boardered" border="1">
 				<tr>
					<td width="100px">제목</td>
					<td><input type="text" class="form-control" id="questionTitle" name="questionTitle" value="${qna.questionTitle }"  readonly></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" class="form-control" id="questionWriter" name="questionWriter" value="${qna.questionWriter }"  readonly></td>
				</tr>
				<tr>
					<td>작성날짜</td>
					<td><input type="text" class="form-control" id="qEnrollDate" name="qEnrollDate" value="${qna.qEnrollDate }"  readonly></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
					<div class="form-floating">
					  <textarea class="form-control" id="questionContents" style="height: 150px" readonly></textarea>
					  <label for="floatingTextarea2">${qna.questionContents }</label>
					</div>
					<%-- <img alt="본문이미지" src="/resources/buploadFiles/${board.boardFileRename }"> --%>
					</td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td>
					<c:if test="${!empty qna.qFileReName }">
						<a href=""  onclick="fnImgPop(this.src)"><img alt="본문이미지" 
						src="/resources/quploadFiles/${qna.qFileReName }" 
						style="width:200px; height:200px;" onclick="fnImgPop(this.src)"></a>
					</c:if>
					<c:if test="${empty qna.qFileReName }">
						<a href="" onclick="fnImgPop(this.src)"><img alt="본문이미지" src="/resources/quploadFiles/${qna.qFileName }" style="width:200px; height:200px;"></a>
					</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-dark" style="background-color: #8ba525;" onclick="location.href='/admin/qnalist.kh?page=${page}'">목록</button>
					</td>
				</tr>
				<tr>
		<!-- 	답변 등록   -->
					<td colspan="2">
						<form action="/admin/qnaAnswer.kh" method="post">
							<input type="hidden" name="page" value="${page }">
							<input type="hidden" name="questionNo" value="${qna.questionNo }">
							<input type="hidden" name="answerStatus" value="N">
							<table class="table table-boardered" border="0" width="100%">
							<tr>
								<td width="100px">작성자</td>
								<td>					
									<input type="text" name="answerWriter" class="form-control"  value="${loginAdmin.adminId}" readonly>
								</td>
							</tr>
							<tr>
								<td>답변</td>
								<c:if test="${empty qna.answerContents }">
								<td>
									<textarea class="form-control" name="answerContents" style="height: 150px" placeholder="${qna.questionContents }"></textarea>
								</td>
								</c:if>
								<c:if test="${not empty qna.answerContents }">
								<td>
									<textarea class="form-control" name="answerContents" style="height: 150px" placeholder="${qna.answerContents }"></textarea>
								</td>
								</c:if>
							</tr>
							<tr>
								<td colspan="2">
								<c:if test="${qna.answerStatus eq 'Y' }">
									<button type="submit" class="btn btn-danger" style="background-color: #ff9900;" onclick="location.href='/admin/qnalist.kh?page=${page}'">답변등록</button>
								</c:if>
								<c:if test="${qna.answerStatus eq 'N' }">
									<button type="submit" class="btn btn-danger" style="background-color: #ff9900;" onclick="location.href='/admin/qnalist.kh?page=${page}'">답변수정</button>
								</c:if>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
		<!-- 	답변 등록   -->
			</table>
		<br>
		</div>
	</div>
</div>
</c:if>
<script type="text/javascript">
	function fnImgPop(url){
		var img = new Image();
		img.src = url;
		var img_width = img.width;
		var win_width = img.width+25;
		var img_height = img.height;
		var win = img.height+30;
		var OpenWindow = window.open('','_blank', 'width = '+img_width+', height = '+img_height+', menubars = no, scrollbars = auto');
		OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+url+"' width='"+win_width+"'>");
	 }
</script>

<!-- copyright -->
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>