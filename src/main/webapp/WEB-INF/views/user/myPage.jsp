<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 본인인증</title>
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
        color: rgb(209, 24, 79);
        background-color:  white;
        border-radius : 10px;
		height : 50px;
		width : 150px;
      }
    </style>

    
    <!-- Custom styles for this template -->
  </head>
  <body class="bg-light">
  <!-- navs bar -->
<jsp:include page="../main/user_navs.jsp"></jsp:include>
    
<div class="container">
  <main>
    <div class="py-5 text-center">
    <br><br><br>
      <h2>${sessionScope.loginUser.userName}님의 회원정보</h2>
    </div>
      <div class="col-md-6 col-md-12">
        <h4 class="mb-3 ">My Information</h4>
        <form name="userInfo" method="post" action="/user/register.kh">
          <div class="row g-3">
            <div class="col-12 col-md-5">
              <label for="username" class="form-label">아이디</label>
              <input type="text" class="form-control" name="userId" id="userId" value="${user.userId}" readonly>
            </div>
           </div>
            <br>
            <div class="col-12 col-md-5">
              <label for="userpwd" class="form-label">비밀번호</label>
                <input type="password" class="form-control" name="userPwd" id="userpwd" value="${user.userPwd}">
            </div>

            <div class="col-md-5">
              <label for="username" class="form-label">이름</label>
              <input type="text" class="form-control" name="userName" id="username" value="${user.userName}" readonly>
            </div>

            <div class="col-md-5">
              <label for="uesrphone" class="form-label">전화번호</label>
              <input type="text" class="form-control" name="userPhone" id="userphone" value="${user.userPhone}">
            </div>

            <div class="col-md-5">
                <label for="useremail" class="form-label">이메일</label>
                <input type="text" class="form-control" name="userEmail" id="useremail" value="${user.userEmail}" readonly>
              </div>

            <div class="col-12 col-md-5" >
                <label for="userpwd" class="form-label">생년월일</label>
                  <input type="text" class="form-control" name="userBirth" id="userbirth"value="${user.userBirth}" readonly>
              </div>

            
				<span>
                  <input type="submit"  class="btn-1" value="수정하기">
                </span>
                <span>
                  <button type="button" id="btn-2" onclick="removeMember()">탈퇴하기</button>
                  <!--  button에 type을 적어줘야 오류가 나지 않음!! -->
                </span>


          
          <p class="mt-5 mb-3 text-muted" align="center">&copy; Copyright 2022- All right Reserved - 팀 요리조리</p>
        </form>
      </div>
  </main>
</div>

<script>
  function removeMember() {
    if(confirm("탈퇴 하시겠습니까?")) {
      location.href = "/user/remove.kh";
    }
  }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  
</body>
</html>