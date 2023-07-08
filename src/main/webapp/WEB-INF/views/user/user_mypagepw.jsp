<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<main class="form-signin w-100 m-auto " style="display: flex;  justify-content: center; align-items: center; height: auto;">
        <article class="col-md-4 " style="margin-top: 11%">
			<div>
		        <div  style="width: 100%" align="center">             
					<br><br><br>	
	            	<h3>${dto2.nickname }님의 비밀번호는 (${dto2.pw}) 입니다.</h3><br>	            			
					<button class="w-auto btn btn-lg btn-primary" onclick="location.href='login'" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">로그인</button>						
				</div>
			</div>
		</article>
	</main>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>	
















