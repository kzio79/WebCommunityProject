<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<main class="form-signin w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
        <article class="col-md-5 " style="margin-top: 11%" >
	        <div align="center">				
		        <div class="col-lg-10 " style="width: 100%" align="center">             
					<br><br><br>		
					<h2>${dto.name }님의 아이디는 (${dto.id}) 입니다.</h2><br>
					<button class="w-auto btn btn-lg btn-primary" onclick="location.href='/user/searchpw'" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">비밀번호 검색</button>
				</div>				
			</div>
		</article>
	</main>
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>	

