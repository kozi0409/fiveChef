<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<c:if test="${not empty loginAdmin}">
<br>
<div class="container" style="aligen:center";>
 	<div class="container">
 
  <div class="row g-4">
    <div class="col-6">
      <div class="p-3 border bg-light">
      	공지사항
      	<hr>
      	<div>

      	</div>
      </div>
    </div>
    
    <div class="col-6">
      <div class="p-3 border bg-light">
      	게시판 관리
      	<hr>
	      <div>
	      	
	      </div>
      </div>
    </div>
    
    <div class="col-6">
      <div class="p-3 border bg-light">
	      회원
	      <hr>
	      <div>
	      	
	      </div>
      </div>
    </div>
    
    <div class="col-6">
     <div class="p-3 border bg-light">
     	QNA
		<hr>
	      <div>
	      	
	      </div>
      </div>
    </div>
    
  </div>
</div>
</div>
<br>
</c:if>

</body>
</html>