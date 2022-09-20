<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
	<div class="container">
	<header>
		<hr style="border-width:2px;">
		<div class="mt-5" align="center">
			<h1 align="center" >${fridgeName } 페이지</h1>
		</div>
	</header>
		<div class="row">
			<div class="col" align="left">
				<button class="btn btn-info" onclick="#">검색</button>
			</div>
			<div class="col" align="right">
				<button class="btn btn-primary" onclick="#">칸 생성</button><button class="btn btn-danger" onclick="#">칸 삭제</button>
			</div>
		</div>
		<div class="card-body" style="height: 500px; background-color:gold; padding: 30px;">
			<div class="col">
				<div class="row text-center">
					<div class="col" align="left">
						<input type="checkbox">
					</div>
					<div class="col" align="left">
						<div>
							칸 이름
						</div>
					</div>
					<div class="col">
						대분류
					</div>
					<div class="col">
						소분류
					</div>
					<div class="col">
						재료 검색
					</div>
					<div class="col">
						재료삭제
					</div>
				</div>
				<div class="row">
					<div style="height:300px; background-color: gray; padding:20px;">
						재료 칸
					</div>
				</div>
				<div class="row">
					3번 칸
				</div>
			</div>
		</div>
	</div>

</body>
</html>


