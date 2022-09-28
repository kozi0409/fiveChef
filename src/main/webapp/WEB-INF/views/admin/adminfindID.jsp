<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <style>
    	body {
		    height: 100vh;
		    background: url(../resources/images/bgImg.png) no-repeat center;
		    background-size: cover;
		}
		table{
			margin: 10px;
        	padding: 10px;
        	border-spacing: 20px;
    		border-collapse: separate;
			width: 380px;
	        height: 450px;
	        border: 1px solid gray;
	        background-color: white;
	        position: absolute;
	        top: 50%;
	        left: 50%;
	        transform: translate(-50%, -50%);
	        box-shadow:0 5px 20px rgba(0, 0, 0, 0.8);
		}
	    </style>
</head>
<body>
	<div class="wrap">
		<table>
			<tr>
				<td align="center">
					<img src="../resources/images/logo2.png">
                        <p>가입한 이메일을 입력해 주세요.</p>
                        <form action="/admin/a_findId.kh" method="post">
                            <input class="form-control" type="text" name="adminEmail" placeholder="Email" style="width:240px;" required="required">
                            <div class="form-button">
                            	<input type="submit" value="아이디 찾기" style="width:180pt; height:30pt; background-color: #3366ff; border:0; color:white; border-radius : 4px;">
                            </div>
                        </form>
						<br>
                        <div class="page-links">
                            <a href="/admin/a_findPwdView.kh">비밀번호 찾기</a>
                            <a href="/admin/adminJoinView.kh">회원가입</a>
                        </div>
				</td>
			</tr>
		</table>
	</div>
<script src="../resources/js/jquery-3.6.1.min.js"></script>
<script src="../resources/css/bootstrap.min.css"></script>
</body>
</html>