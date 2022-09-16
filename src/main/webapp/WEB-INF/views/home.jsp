<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function add_div(){
			var div = document.createElement('div');
			div.innerHTML = document.getElementById('room_type').innerHTML;
			document.getElementById('field').appendChild(div);
			}
		function remove_div(obj){
			document.getElementById('field').removeChild(obj.parentNode);
			}
	</script>
	
	<header>
		<div align="center">
			<h1>MY 냉장고</h1>
		</div>
	</header>
	<section>
	<fieldset>
		<legend>냉장고</legend>
		<div align="right" >
			<button onclick="add_div()">생성</button>
			<button onclick="remove_div(this)">삭제</button>
		</div>
		<div id="room_type">반복생성</div>
		<div id="field">
		</div>
	</fieldset>
		
	</section>
	
	
	
<!-- 	<input type="button" value="추가" onclick="add_div()"> -->
<!-- 	<br/> -->
<!-- 	<div id="room_type"> -->
<!-- 		<div class="form-group"> -->
<!-- 			<label for="image">제목</label> -->
<!-- 			<input type="text" id="title" name="title" class="form-control" ></input> -->
<!-- 		</div> -->
<!-- 		<input type="button" value="삭제" onclick="remove_div(this)"> -->
<!-- 	</div> -->
<!-- 	<div id="field"></div> -->

		
		
</body>
</html>