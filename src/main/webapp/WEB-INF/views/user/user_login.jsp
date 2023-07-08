<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	 <main class="form-signin w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 11%">		    
		        <div class="col-lg-12 mt-0" style="width: 100%"> 
		            <h1 >Login</h1><br>
		            <form action="login" method="post">
		                <div class="form-floating">
		                    <input type="id" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" id="floatingInput" name="id" placeholder="Id" required="required"><br>
		                    <input type="password" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" id="floatingPassword" name="pw" autocomplete="current-password" placeholder="Password"><br>
			                <button type="submit" class="w-100 h-100 btn btn-lg btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">Login</button>
			                <a href="/user/searchid" style="color: black;"class="click">아이디 검색</a> / <a href="/user/searchpw" style="color: black;" class="click">비밀번호 검색</a>
		                </div>
		            </form>
		        </div>		    
	    </article>
	</main>	
	
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js">	</script>
     	<script>
     	$(document).ready(function(){
     		var msg = '${msg}';
     		if(msg != ''){
     			alert(msg);
     		}
     	});
     </script>
	


	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
