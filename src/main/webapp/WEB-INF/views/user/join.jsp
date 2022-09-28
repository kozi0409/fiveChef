<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 본인인증</title>
 <script src="/resources/js/jquery-3.6.1.min.js"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">    

    <!-- Favicons -->



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-1 {
        border : 0;
        color: white;
        background-color:  rgb(209, 24, 79);
        border-radius : 10px;
		height : 50px;
		width : 150px;
      }

      #btn-2 {
        border : 0;
        color: white;
        background-color:  rgb(209, 24, 79);
        border-radius : 10px;
		height : 50px;
		width : 150px;
      }
    </style>

    
    <!-- Custom styles for this template -->
  </head>
  <body class="bg-light">
	<script>
	$(function() {
		$("#user-regist").on("submit", function() {
			var inputID = $("#userid").val();
		  	  var inputPW = $("#userpwd").val();
		  	  var inputPW_Re = $("#userpwdcheck").val();
		  	  var inputName = $("#username").val();
		  	  var inputPhone = $("#userphone").val();
		  	  var inputEmail = $("#useremail").val();
		  	  var inputBirth = $("#userbirth").val();
		  	  
		  	  var regID = /[a-z0-9]/;
		  	  var regPW = /[a-z0-9!@#$]{8,20}$/;
		  	  var regPW_RE = inputPW;
		  	  var regName = /^[ㄱ-힣]{2,4}$/;
		  	  var regPhone = /^01[0-9]{8,9}$/;
		  	  var regEmail = /[@]/;
		  	  var regBirth = /[0-9]{8}/;
		  	  
		  	  if(inputID == "") {
		  		  alert("ID를 입력해주세요.");
		  		  return false;
		  	  };
		  	  if(!regID.test(inputID)) {
		  		  alert("양식에 맞게 ID를 다시 입력해주세요.");
		  		  return false;
		  	  }
		  	  if(inputPW == "") {
		  		  alert("PW를 입력해주세요.");
		  		  return false;
		  	  }
		  	  if(!regPW.test(inputPW)) {
		  		  alert("양식에 맞게 PW를 다시 입력해주세요.");
		  		  return false;
		  	  }
		  	  if(inputName =="") {
		  		  alert("이름을 입력해주세요.");
		  		  return false;
		  	  }
		  	  if(!regName.test(inputName)) {
		  		  alert("이름은 한글만 입력 가능합니다.");
		  		  return false;
		  	  }
		  	  if(!regPhone.test(inputPhone)) {
		  		  alert("전화번호는 숫자만 입력 가능합니다.");
		  		  return false;
		  	  }
		  	  if(inputEmail == "") {
		  		  alert("이메일을 입력해주세요.");
		  		return false;
		  	  }
		  	  if(!regEmail.test(inputEmail)) {
		  		  alert("정확한 이메일이 아닙니다.");
		  		return false;
		  	  }
		  	  if(inputBirth == "") {
		  		  alert("생년월일을 입력해주세요.");
		  		return false;
		  	  }
		  	  
		  	 if(!regBirth.test(inputBirth)) {
		  		  alert("양식에 맞게 생년월일을 입력해주세요.");
		  		return false;
		  	  }	 
	    });
	})
	
	</script>
    
<div class="container">
  <main>
    <div class="py-5 text-center">
    <a href="/home.kh"><img class="mb-4" src="../../../resources/images/logo1.png" alt="" width="200" height="160"></a>
    <br><br><br>
      <h2>회원가입</h2>
    </div>
      <div class="col-md-6 col-md-12" align="center">
        <h4 class="mb-3 ">회원정보를 입력해주세요</h4>
        <form  id="user-regist" name="userInfo" method="post" action="/user/register.kh" enctype="multipart/form-data"> 
            <div class="col-12 col-md-5" >
              <label for="username" class="form-label">아이디</label>
              <input type="text" class="form-control" name="userId" id="userid" placeholder="영문 숫자 조합 6~20자" maxlength="20">
           </div>
            <br>
            <div class="col-12 col-md-5">
              <label for="userpwd" class="form-label">비밀번호</label>
                <input type="password" class="form-control" name="userPwd" id="userpwd" placeholder="영문 숫자 특수문자(!,@,#,$) 조합 8~20자" maxlength="20"d>
            </div>
            <br>
			<div class="col-12 col-md-5">
              <label for="userpwdcheck" class="form-label">비밀번호 확인</label>
                <input type="password" class="form-control" name="userPwdRe" id="userpwdcheck" maxlength="20">
            </div>
            <br>
            <div class="col-md-5">
              <label for="username" class="form-label">이름</label>
              <input type="text" class="form-control" name="userName" id="username" placeholder="ex)홍길동">
            </div>
			<br>
            <div class="col-md-5">
              <label for="uesrphone" class="form-label">전화번호</label>
              <input type="text" class="form-control" name="userPhone" id="userphone" placeholder="숫자만 입력하세요. ex)01011111111">
            </div>
			<br>
            <div class="col-md-5">
                <label for="useremail" class="form-label">이메일</label>
                
                	<input type="text" class="form-control" name="userEmail" id="useremail" placeholder="ex)khuser01@iei.or.kr">
               
               	<div style= "display : inline-block">
                	<a href="#" class="btn" role="button">
              			<!-- <button type="button" class="btn-1">인증번호 받기</button>  -->
              		</a>
              	</div>
              </div>
			<br>
            <div class="col-12 col-md-5" >
                <label for="userBirth" class="form-label">생년월일</label>
                  <input type="text" class="form-control" name="userBirth" id="userbirth" placeholder="숫자만 입력해주세요. ex)20000101">
              </div>
			<div class="col-12 col-md-5" >
			<br>
                <label for="userPhotoName" class="form-label">프로필사진</label>
                  <input type="file" class="form-control" name="uploadFile">
              </div>
          	<br><br>


          <button class="" id="btn-2" type="submit">회원가입</button>
          
          <p class="mt-5 mb-3 text-muted" align="center">&copy; Copyright 2022- All right Reserved - 팀 요리조리</p>
        </form>
      </div>
  </main>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  
</body>
</html>