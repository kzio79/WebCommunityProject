<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
			<head>
			<title>Format Team Project</title>
			<meta charset="UTF-8">
			
			
			<style type="text/css">
				*{
					cursor: url(${pageContext.request.contextPath }/images/cursor.png) -10 0, auto;
				}
				
				.click{
					cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; 
				}
				
			</style>
			
		    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
		    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700" rel="stylesheet">
		
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/open-iconic-bootstrap.min.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.css">
		    
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.carousel.min.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.theme.default.min.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/magnific-popup.css">
		
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/aos.css">
		
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/ionicons.min.css">
		
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-datepicker.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.timepicker.css">
		
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/flaticon.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/icomoon.css">
		    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		</head>
		<body>
	   <div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
	   <aside id="colorlib-aside" role="complementary" class="js-fullheight text-center">
			<h1 id="colorlib-logo"><a href="/" class="click">Format Team Project</a></h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="/" class="click">홈</a></li>
					<li><a href="${pageContext.request.contextPath }/codeboard/codelist" class="click";>코드 게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/freeboard/freelist" class="click">자유 게시판</a></li>
					<li><a href="${pageContext.request.contextPath }/qnaboard/qnalist" class="click">질문 게시판</a></li>
					 <c:choose>
                    	<c:when test="${sessionScope.id == null }">
		                    <li>
		                        <a href="${pageContext.request.contextPath }/user/login" class="click">로그인</a>
		                    </li>
		                    <li>
		                        <a href="${pageContext.request.contextPath }/user/join" class="click">회원가입</a>
		                    </li>
                    	</c:when>
                    	<c:otherwise>
							<li>
		                        <span id="down2" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="if(mypage.style.display == 'none')
				              	{mypage.style.display=''; down2.innerText = '${sessionScope.nickname }님페이지 ▼'}else {mypage.style.display = 'none'; down2.innerText = ' ${sessionScope.nickname }님 환영합니다'}">
				              	${sessionScope.nickname }님 환영합니다
				              	</span>
		                        <div id="mypage" style="display: none">
						            <a href="${pageContext.request.contextPath }/user/modify" class="click" >회원정보변경</a><br>	              		           	              	
					              	<a href="${pageContext.request.contextPath }/user/delete" class="click" >회원탈퇴</a>        
					            </div>		                        
		                    </li>
		                    <li>
		                        <a href="${pageContext.request.contextPath }/user/logout" class="click">로그아웃</a>
		                    </li>
                    	</c:otherwise>
                    </c:choose>		
				
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Format Team Project
			</div>
		</aside> <!-- END COLORLIB-ASIDE -->
		  