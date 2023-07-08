<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<main class="form-signin w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 11%">	       
            <div class="col-lg-12 mt-0" style="width: 100%">             
                <h3>Id와 Email을 입력하세요</h3><br>					
                <form action="searchpw" method="post" name="searchpwForm">
                	<input type="text" name="id" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" placeholder="아이디" required="required">
					<br>
					<input type="email" name="email" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" placeholder="이메일" required="required">
					<br>						
                    <button class="w-100 btn btn-lg btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="search()">검색</button>						
                     &nbsp							
                </form>
            </div>	       
	    </article>
	</main>	
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js" ></script>
	<script>	
		$(document).ready(function(){
	 		var msg = '${msg}';
	 		if(msg != ''){
	 			alert(msg);
	 		}
	 	});
	
		function search(){
			 if (confirm("검색하시겠습니까?")) {			
					document.searchpwForm.submit();					
			}
	 	};

	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>	
