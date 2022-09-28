<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 문의글</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
  .btn-1 {
        border : 0;
        color: white;
        background-color:  rgb(209, 24, 79);
        border-radius : 10px;
		height : 50px;
		width : 150px;
   }
</style>

</head>
<body>

<!-- navs bar -->
<jsp:include page="../main/user_navs.jsp"></jsp:include>
<br><br><br>
<h1 align="center">MY PAGE</h1>
<br><br>
	<h3 align="center">${loginUser.userId}님의 문의 글</h3>
	<br><br>
	<table align ="center" border="1" class="table table-boardered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>답변상태</th>
		</tr>
		<c:if test="${empty qList }">
			<tr>
				<td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
		<c:if test="${!empty qList }">
			<c:forEach items="${qList }" var="qna" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td><a href="/qna/detail.kh?questionNo=${qna.questionNo }&page=${currentPage }">${qna.questionTitle }</a></td>
					<td>${qna.questionWriter }</td>
					<td>${qna.qEnrollDate }</td>
					<td>
						<c:if test="${qna.answerStatus != 'Y' }">
							답변완료
						</c:if>
						<c:if test="${qna.answerStatus == 'Y' }">
							답변대기
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		 <tr align="center" height="20">
            <td colspan="6">
                <c:if test="${currentPage != 1}">
                    <a href="/qna/${urlVal }.kh?page=${currentPage - 1 }">[이전]</a>
                </c:if>
                <c:forEach var="p" begin = "${startNavi }" end="${endNavi }">
                    <c:if test="${currentPage eq p }">
                        <b>${p}</b> 
                    </c:if>
                    <c:if test="${currentPage ne p }">
                        <a href = "/qna/${urlVal }.kh?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">${p}</a>
                    </c:if>
                </c:forEach>
            <c:if test = "${currentPage < maxPage }">
                <a href = "/qna/${urlVal}.kh?page=${currentPage + 1}">[다음]</a>
            </c:if>
            </td>
        </tr>
	</table>
	<button class="btn-1" onclick="qnaWrite()">글쓰기</button>
	
	<script>
		function qnaWrite() {
			location.href = "/qna/qnaWriteView.kh";
		}
	</script>
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	
</body>
</html>