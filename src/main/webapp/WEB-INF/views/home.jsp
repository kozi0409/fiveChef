<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FiveChef</title>
<style>
	.sec {
		height : 600px;
		width : 100%;
	}
	.sec-title {
		height : 50px;
		position : relative;
		top : 30px;
		background-color : #d21853;
	}
	.title {
		position : relative;
		left : 10%;
		font-size : 40px;
		color : white;
	}
	.sec-content {
		float : left;
		position : relative;
		top : 80px;
		left : 5%;
	}
		.sec-content1 {
		float : left;
		position : relative;
		top : 80px;
		left : 30%;
	}
	.content-line {
		float : left;
		position : relative;
		top : 80px;
		width : 5%;
		height : 400px;
	}

</style>
</head>
<body>
<!-- navs bar -->
<jsp:include page="./main/user_navs.jsp"></jsp:include>

<!-- slide image Start -->
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
               <img src="../resources/images/slider/slider-1.jpg" class="d-block w-100" alt="..." >
                  <div class="carousel-caption d-none d-md-block">
                      <h1>First slide label</h1>
                      <p>Some representative placeholder content for the first slide.</p>
                  </div>
            </div>
            <div class="carousel-item">
               <img src="../resources/images/slider/slider-2.jpg" class="d-block w-100" alt="...">
                  <div class="carousel-caption d-none d-md-block">
                      <h1>Second slide label</h1>
                      <p>Some representative placeholder content for the second slide.</p>
                  </div>
            </div>
            <div class="carousel-item">
               <img src="../resources/images/slider/slider-3.jpg" class="d-block w-100" alt="...">
                  <div class="carousel-caption d-none d-md-block">
                      <h1>Third slide label</h1>
                      <p>Some representative placeholder content for the third slide.</p>
                  </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
<!-- slide image End -->


<!-- notice Start -->
	<section class="sec">
		<div class="sec-title">
			<h2 class="title">공지사항</h2>
		</div>
		<div class="sec-content1">
		<table align="center" border="1" class="table table-hover">
		
		<tr align="center">
			<th width="80">번호</th>
			<th>제목</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
			<th width="155">기타</th>
		</tr>
	<c:if test="${!empty nList }">
	<c:forEach items="${nList }" var="notice" varStatus="i">
		<tr align="center">
			<td>${i.count }</td>
			<td><a href="/userNotice/detail.kh?noticeNo=${notice.noticeNo }&page=${currentPage }">${notice.noticeTitle }</a></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.nCreateDate }"/> </td>
			<td>${notice.noticeCount }</td>
			<td>
				<c:if test="${!empty notice.noticeFilename }">
					첨부파일
				</c:if>
				<c:if test="${empty notice.noticeFilename }">
					
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<tr align="center" height="20">
			<td colspan="6">
				<c:if test="${currentPage != 1 }">
					<a href="/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-primary"><</a>
				</c:if>
				<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
					<c:if test="${currentPage eq p }">
						<b class="btn btn-primary">${p }</b>
					</c:if>
					<c:if test="${currentPage ne p }">
						<a href="/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-light">${p }</a>
					</c:if>
				</c:forEach>
				<c:if test="${maxPage > currentPage }">
					<a href="/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}" class="btn btn-primary">></a>
				</c:if>
			</td>
		</tr>
		</c:if>
		<c:if test="${empty nList }">
			<tr>
				<td colspan="6" align="center"><b>데이터가 존재하지 않습니다.</b></td>
			</tr>
		</c:if>
	</table>
		</div>
	</section>
<!-- notice End -->
<!-- cook tip Start -->
	<section class="sec">
		<div class="sec-title">
			<h2 class="title">요리 팁</h2>
		</div>
		<div class="sec-content">
			<iframe class= "video" width="400" height="250" src="https://www.youtube.com/embed/iWxORW_8qxU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>
		<div class= "content-line"></div>
		<div class="sec-content">
			<iframe class="video" width="400" height="250" src="https://www.youtube.com/embed/ypYNiFh3Tqc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>		</div>
		<div class= "content-line"></div>
		<div class= "sec-content">
			<iframe class="video" width="400" height="250" src="https://www.youtube.com/embed/rj_sjvxkNVc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>	
	</section>
<!-- cook tip End -->

<!-- copyright -->
<jsp:include page="./main/footer.jsp"></jsp:include>
</body>
</html>