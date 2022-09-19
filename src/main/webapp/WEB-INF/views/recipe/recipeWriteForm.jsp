<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>냉장고 셰프 레시피 작성</title>
</head>
<body>
<h2 align="center">레시피 등록</h2>
	<form action="/recipe/recipeRegister.kh" method="post">
		<table align="center" border="1"  width="900">
			<tr>
				<td>제목</td>
				<td>
				<input type="text" name="recipeTitle">
				</td>
				<td rowspan="3"  width="200" height="200" align="center"><a href="#">썸네일</a></td>
			</tr>	
			<tr>
				<td>작성자</td>
				<td><input type="text" name="userId"></td>
			</tr>	
			<tr>
				<td>요리소개</td>
				<td><textarea rows="7" cols="30" name="recipeIntro"></textarea></td>
			</tr>	
			<tr>
				<td>카테고리</td>
				<td colspan="2">
					<select name="typeCategory">
						<option value="" selected>종류별</option>
						<option value="1">일식</option>
						<option value="2">중식</option>
						<option value="3">한식</option>
						<option value="4">양식</option>
					</select>
					<select name="wayCategory">
						<option value="" selected>방법별</option>
						<option value="5">볶음</option>
						<option value="6">찜</option>
						<option value="7">끓이기</option>
						<option value="8">기타</option>
					</select>
				</td>
			</tr>	
			<tr>
				<td>요리정보</td>
				<td colspan="2">
					<select name="recipePerson" >
						<option value="" selected>인원</option>
						<option value="1">1인분</option>
						<option value="2">2인분</option>
						<option value="3">3인분</option>
						<option value="4">4인분</option>
						<option value="4">5인분</option>
						<option value="4">6인분</option>
						<option value="4">6인분이상</option>
					</select>
					<select name="recipeTime">
						<option value="" selected>시간</option>
						<option value="5">5분이내</option>
						<option value="5">10분이내</option>
						<option value="5">30분이내</option>
						<option value="5">60분이내</option>
						<option value="5">90분이내</option>
						<option value="5">2시간이내</option>
						<option value="5">2시간이상</option>
					</select>
					<select name="recipeLevel">
						<option value="" selected>난이도</option>
						<option value="5">★☆☆☆☆</option>
						<option value="5">★★☆☆☆</option>
						<option value="5">★★★☆☆</option>
						<option value="5">★★★★☆</option>
						<option value="5">★★★★★</option>
					</select>
				</td>
			</tr>	
		</table>
		<br>
		<table align="center" border="1" width="900">
			<tr>
				<td><input type="text" name="ingBundleName" placeholder="요리명"></td>
				<td align="center">
				<input type="text" name="largeCatId" placeholder="재료대분류" value="야채"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="감자"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="1개">
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="야채"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="양파"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="1개">     
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="육류"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="돼지고기"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="300g"> 
				
				<input type="text" name="largeCatId" placeholder="재료대분류" value="육류"> 
				<input type="text" name="smallCatId" placeholder="재료명" value="소고기"> 
				<input type="text" name="ingAmount" placeholder="재료양" value="400g">   
				</td>
			</tr>	
			<tr><td colspan="2"align="center"><button type="button" >재료추가</button></td></tr>
		</table>		
		<br>
		<table align="center" border="1" height="" width="900">
			<tr>
				<td><b>Step1</b></td>
				<td><textarea rows="11" cols="45"></textarea></td>
				<td align="center" width="200" height="200"><a href="#">요리사진</a></td>
			</tr>	
		</table>	
		<br>
		<div align="center">
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		</div>
	</form>

</body>
</html>