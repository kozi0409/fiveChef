<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	#img-tag {
		width : 300px;
		height :300px;
		border-radius: 100%;
	}
	
	#user {
    		font-size : 20px;
    		padding :30px;
    		text-decoration : none;
			color : rgb(209, 24, 79);	
    	}
    #user:hover {
    	font-size : 24px;
    }
</style>
</head>
<body>

	 <!-- navs bar -->
	<jsp:include page="../main/user_navs.jsp"></jsp:include>
	<br><br><br>
	<h1 align="center">${sessionScope.loginUser.userName}님 환영합니다!</h1>
	<br><br>
	<div align="center">
	<c:if test="${loginUser.userPhotoName != null }">
		<img id="img-tag" alt="본문이미지" src="/resources/userProfile/${user.userPhotoRename }">
	</c:if>
	<c:if test="${loginUser.userPhotoName == null }">
		<img id="img-tag" alt="본문이미지" src="/resources/userProfile/normalProfile.png">
	</c:if>	
	</div>
	<br><br><br>
	<div align="center">
		<a href="/user/modifyView.kh" id="user"> 정보수정</a>
		<a href="/qna/list.kh" id="user">1:1 문의</a>
		<a href="#" id="user">내 레시피</a>
		<a href="/community/myCommunityList.kh" id="user">내 게시글</a>
	</div>
</body>
</html>