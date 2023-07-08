<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<main class="form-signin w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 11%">		   
	        <div class="col-lg-12 mt-0" style="width: 100%">             
				<h3>이름을 입력하세요</h3><br>					
	            <form action="searchid" method="post" name="searchIdForm">
					<input type="text" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" id="floatingName" name="name" placeholder="이름" required>
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
		console.log('${msg}');
 		if(msg != ''){
 			alert(msg);
 		}
 	});
	
	function search(){
		if(document.searchIdForm.name.value == ''){
			
			return;
		}else if (confirm("검색하시겠습니까?")) {			
				document.searchIdForm.submit();			 
		}
 	}

	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
