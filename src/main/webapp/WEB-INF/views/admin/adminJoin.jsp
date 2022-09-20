<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/admin.kh"></jsp:include>
<body>
    <div class="container">
	    <div class="row">
		    <div class="col-sm-12 text-center" >
			    <div class="col-sm-3"></div>
			     
				    <div class="col-sm-6">
				    <h1>회원가입</h1>
				    <form action="/admin/adminRegister.kh" method="post">
				        <table class="table table-boardered">
				            <tr>
				                <th>아이디</th>
				                <td><input type="text" id="adminId" name="adminId" placeholder="ID를 넣으세요"></td>        
				            </tr>
				            <tr>
				                <th>패스워드</th>
				                <td><input type="password" name="adminPwd" placeholder="비밀번호를 넣으세요"></td>      
				            </tr>
				             
				          <!--   <tr>
				                <th>패스워드확인</th>
				                <td><input type="password"  name=""></td>        
				            </tr> -->
				            <tr>
				                <th>이름</th>
				                <td><input type="text"  name="adminName"></td>       
				            </tr>
				            <tr>
				                <th>이메일</th>
				                <td><input type="email"  name="adminEmail"></td>       
				            </tr>
				             
				            <tr>
				                <th>전화번호</th>
				                <td><input type="tel"  name="adminPhone"></td>       
				            </tr>
				            <tr>
								<th>우편번호</th>
								<td>
									<input type="text" name="post" class="postcodify_postcode5" value="">
									<button type="button" id="postcodify_search_button">검색</button><br />
								</td>
							</tr>
							<tr>
								<th>도로명 주소</th>
								<td>
									<input type="text" name="address1" class="postcodify_address" value="">
								</td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td>
									<input type="text" name="address2" class="postcodify_details" value="">
								</td>
							</tr>
				            <tr>
				                <td colspan="2" align="center">
				                <input type="submit" value="전송">
				                <input type="reset" value="취소">
				                </td>
				            </tr>
				        </table>
				    </form>
			    </div>
		    </div>
	    </div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- 실제 데이터가 들어있는 라이브러리 -->
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script> 
		$(function() { 
			$("#postcodify_search_button").postcodifyPopUp(); 
		}); 
	</script>
</body>
</html>