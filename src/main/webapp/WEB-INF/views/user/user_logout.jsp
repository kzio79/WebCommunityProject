<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
	<body>
		<section>
			<div align="center">
			<form action="mypage" method="get"></form>
				<h2>MyPage</h2>
				<hr>
				<h3>${dto.id }(${dto.name })님의 회원정보를 관리합니다.</h3>
				<input type="button" value="회원정보 변경" class="btn btn-primary" onclick="location.href='modify'">
				<input type="button" value="회원탈퇴" class="btn btn-info" onclick="location.href='delete'">
				<input type="button" value="로그아웃" class="btn btn-info" onclick="location.href='logout'">
			</div>
		</section>
	</body>
</html>
		
