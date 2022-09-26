<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1 align="center">COMMUNITY</h1>
<br><br>
	<h3 align="center">내가 쓴 게시글</h3>
<br>
<table class="table table-boardered">
    <tr>
       <th>번호</th>
       <th>제목</th>
       <th>분류</th>
       <th>날짜</th>
       <th>조회수</th>
    </tr>
    <c:if test = "${!empty cList}">
        <c:forEach items="${cList}" var="community" varStatus="i">
            <tr>
                <td>${i.count}</td>      
                <td><a href="/community/communityDetail.kh?communityNo=${community.communityNo }&page=${currentPage }">${community.communityTitle}</a></td>
                <td>${community.cBoardCode}</td>
                <td>${community.cEnrollDate}</td>
                <td>${community.boardCount}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty cList}">
        <tr>
            <td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td> <!-- 데이터가 존재하지 않습니다 if문-->
        </tr>
    </c:if>
    <tr align="center" height="20">
        <td colspan="6">
            <c:if test="${currentPage !=1}">
                <a href="/community/${urlVal }.kh?page=${currentPage - 1 }">[이전]</a>
            </c:if>
            <c:forEach var="p"  begin ="${startNavi}" end="${endNavi}">
                 <c:if test="${currentPage eq p}">
                    <b>${p}</b> 
                 </c:if> 
                 <c:if test="${currentPage ne p}">
                    <a href = "/community/${urlVal }.kh?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">${p}</a>
                 </c:if>
             </c:forEach>
           	 <c:if test = "${currentPage < maxPage}">
                <a href = "/community/${urlVal}.kh?page=${currentPage + 1}">[다음]</a>
            </c:if>
        </td>
    </tr>
</table>
    <form action = "/community/myCommunitySearch.kh" method="get"  >
		<div align="center">
			<div style="display : inline-block">
	            <select name = "searchCondition">
	                <option value="all" <c:if test="${searchCondition eq 'all'}">select</c:if>>전체</option>
	                <option value="writer" <c:if test="${searchCondition eq 'all'}">select</c:if>>작성자</option>
	                <option value="title" <c:if test="${searchCondition eq 'all'}">select</c:if>>제목</option>
	                <option value="contents" <c:if test="${searchCondition eq 'all'}">select</c:if>>내용</option>
	            </select>
	        </div>
			<div style="display : inline-block">
            	<input type="text" name="searchValue" value="${searchValue}">
            </div>
            <div style="display : inline-block">
            	<input type="submit" value="검색">
            </div>
	   </div>
    </form>
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	
</body>
</html>