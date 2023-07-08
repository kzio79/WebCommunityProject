
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<main class="form-signin w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 11%">		    
	        <div class="col-lg-12 mt-0" style="width: 100%"> 
                <h3>회원 탈퇴를 위한 비밀번호를 입력하세요</h3><br>
	            <form action="delete_result" name="deleteForm" method="post">
	                <div class="form-floating">
	                    <input type="id" class="form-control" id="floatingInput" name="id" value="${sessionScope.id}" placeholder="Id" required="required" readonly><br>
	                    <input type="password" class="form-control" id="floatingPassword" name="pw" autocomplete="current-password" placeholder="Password" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"><br>
		                <button type="submit" class="w-100 btn btn-lg btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="deleteok()">회원탈퇴</button>
		                &nbsp
	                </div>
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
	
	function deleteok(){
		if(document.deleteForm.pw.value == '') {
			return;
		}else if (confirm("회원 탈퇴를 하시겠습니까?")) {			
				document.deleteForm.submit();			 
		}
 	}

	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>	
