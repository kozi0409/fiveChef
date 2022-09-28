<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 가입페이지</title>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
    <script>
        $(function() {
            $("#admin-regist").on("submit", function() {
                var idTag = $("#adminId");
                var pwTag = $("#adminPwd");
                var pwchTag =$("#adminPwdCk");
                var nameTag = $("#adminName");
                var emailTag = $("#adminEmail");
                var telTag = $("#adminPhone");
                var postTag = $("#post");
                var addr1Tag = $("#address1");
                var addr2Tag = $("#address2");
                
                
                // 정규표현식
                // 아이디는 영소문자로 시작하고 나머지는 모두 숫자인데 4~12자리가 되도록 해라.
                var idRegEx = /^[a-zA-Z0-9]{3,11}$/;
                // 비밀번호는 최소 6글자 이상, 최대 18글자이고 영문자,숫자,특수문자(!@#$*)만 허용됩니다.
                var pwRegEx = /^[a-zA-Z0-9!@#$*]{6,18}$/;
                // 이름은 한글, 최소 2글자에서 4글자를 입력해야합니다.
                var nameRegEx = /^[가-힣]{2,4}$/;
                //이메일 체크
                var emailRegEx = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
                // 010/011/016/017/019 중 입력해주세요
                var telRegEx = /^01[0-9]{8,9}$/;
              

                if(idTag.val() == "") {
                    alert("ID를 입력해주세요.");
                    idTag.focus();
                    return false;
                }
                if(!idRegEx.test(idTag.val())) {
                    alert("아이디는 영소문자로 시작하고 나머지는 모두 숫자4~12자리로 적어주세요.");
                    idTag.focus();
                    return false;
                }
                if(pwTag.val() == ""){
                    alert("비밀번호를 입력해주세요.")
                    pwTag.focus();
                    return false;
                }
                if(!pwRegEx.test(pwTag.val())) {
                    alert("비밀번호는 최소 6글자 이상, 최대 18글자이고 영문자,숫자,특수문자(!@#$*)만 적어주세요.");
                    pwTag.focus();
                    return false;
                }
                if(pwTag.val() == idTag.val()) {
                    alert("비밀번호는 아이디와 다르게 입력하세요.");
                    pwTag.focus();
                    return false;
                }
                if(pwchTag.val() == ""){
                    alert("비밀번호 확인을 입력해주세요.")
                    pwchTag.focus();
                    return false;
                }
                console.log(pwchTag);
                if(pwchTag.val() != pwTag.val()){
                    alert("비밀번호가 같지 않습니다.")
                    pwchTag.focus();
                    return false;
                }
                if(nameTag.val() == ""){
                    alert("이름을 입력해주세요.")
                    nameTag.focus();
                    return false;
                }
                if(!nameRegEx.test(nameTag.val())) {
                    alert("이름은 한글, 최소 2글자에서 4글자를 입력해주세요.");
                    nameTag.focus();
                    return false;
                }
                if(emailTag.val() == ""){
                    alert("이메일을 입력해주세요.")
                    emailTag.focus();
                    return false;
                }
                if(!emailRegEx.test(emailTag.val())) {
                    alert("이메일을 정확하게 입력해주세요.");
                    emailTag.focus();
                    return false;
                }
                if(telTag.val() == ""){
                    alert("전화번호를 입력해주세요.")
                    telTag.focus();
                    return false;
                }
                if(!telRegEx.test(telTag.val())) {
                    alert("양식에 맞게 입력해주세요.");
                    telTag.focus();
                    return false;
                }
                if(postTag.val() == ""){
                    alert("우편번호를 입력해주세요.")
                    postTag.focus();
                    return false;
                }
                if(addr1Tag.val() == ""){
                    alert("주소를 입력해주세요.")
                    addr1Tag.focus();
                    return false;
                }
                if(addr2Tag.val() == ""){
                    alert("상세주소를 입력해주세요.")
                    addr2Tag.focus();
                    return false;
                }

            });

        });
        
    </script>
<jsp:include page="../main/admin_navs.jsp"></jsp:include>
<br>
<div class="container" style="width: 600px; ">
	<div class="row">
		<div class="col-sm-12 text-center" >
		    <h2>관리자 가입</h2>
            <form action="/admin/adminRegister.kh" method="post"  id="admin-regist" enctype="multipart/form-data">
                <table class="table table-boardered">
                    <tr>
                        <th>아이디</th>
                        <td align="left">
                            <div style= "display: inline-block">
                            <input type="text" class="form-control" name="adminId" id="adminId" placeholder="id를 넣으세요">
                            </div>
                            <!-- <div style= "display: inline-block">
                            <button type="button" id="idCheck">중복체크</button>
                            </div> -->
                        </td>		
                    </tr>
                    <tr>
                        <th>패스워드</th>
                        <td><input type="password" class="form-control" name="adminPwd" id="adminPwd" placeholder="비밀번호는 영문만 넣어주세요"></td>		
                    </tr>
                    <tr>
                        <th>패스워드확인</th>
                        <td><input type="password" class="form-control" name="adminPwdCk" id="adminPwdCk"></td>		
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" class="form-control" name="adminName" id="adminName"></td>		
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="email" class="form-control" name="adminEmail" id="adminEmail"></td>		
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input type="tel" class="form-control" name="adminPhone" id="adminPhone"></td>		
                    </tr>
					
					<tr>
						<th>우편번호</th>
						<td align="left">
							<div style= "display: inline-block">
							<input type="text" name="post" class="form-control postcodify_postcode5" id="post">
							</div>
							<div style= "display: inline-block">
							<button type="button" id="postcodify_search_button">검색</button>
							</div>
						</td>		
					</tr>
					<tr>
						<th>도로명 주소</th>
						<td>
							<input type="text" name="address1" id="address1" class="form-control postcodify_address">
						</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td>
							<input type="text" name="address2" id="address2" class="form-control postcodify_details">
						</td>
					</tr>
		
					
					<tr>
						<td colspan="2">
						<input type="submit" class="btn btn-primary" value="전송">
						<input type="reset" class="btn btn-danger" value="취소">
						</td>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>
</div>
<br><br>
<!-- copyright -->
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