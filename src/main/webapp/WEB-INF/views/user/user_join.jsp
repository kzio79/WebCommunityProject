
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	
	<main class="w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 2%">
		    <div >
		        <div > 
       				 <div class="form-floating">
						<h1 align="center"><b>회원가입</b></h1><br>
		    			<form name="regForm" id="Form" action="join" method="post">		    
					     	<div >
					     		<div class="form-group">
			                      <label for="id" style="font-weight: bolder; color: black; ">아이디 </label>
			                      <input type="text" name="id" class="col-lg-7" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" id="id" placeholder="4글자 이상 8글자 이하" required>
			                      <input type="button" name="id" id="id" class="btn btn-default" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="idcheck()" value="중복확인"><br>
			                      <span class="id-check" ></span>
			                     </div>  
			                      
			                     <div class="form-group">			                      
			                      <label for="nickname" style="font-weight: bolder; color: black;">닉네임</label>
			                      <input type="text" name="nickname" id="nickname" class="col-lg-7" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" required>
			                      <input type="button" name="nickname" id="nickname" class="btn btn-default" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="nickcheck()" value="중복확인"><br>
			                      <span class="nick-check"></span>			                      
			                     </div>
			                     
			                     <div class="form-group">			                      
			                      <label for="pw" style="font-weight: bolder; color: black;">비밀번호</label>
				                  <input type="password" name="pw" class="col-lg-12" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
				                 </div>
				                         
			                     <div class="form-group">			                      
			                      <label for="pw" style="font-weight: bolder; color: black;">비밀번호확인</label>
			                      <input type="password" name="pw_check" class="col-lg-12" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
			                     </div>
			                     
			                     <div class="form-group">			                      
			                      <label for="name" style="font-weight: bolder; color: black;">이름</label>
			                      <input type="text" name="name" class="col-lg-12" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
			                     </div>         
			                      
				                 <div class="form-group">				                  
				                  <label for="email" style="font-weight: bolder; color: black;">이메일</label>
				                  <input type="email" name="email" class="col-lg-12" placeholder="you@example.com" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
				                  
				                 </div>           
			                      
			                     <div class="form-group">                   
			                      	<label for="address" style="font-weight: bolder; color: black;">주소</label> <br>             
									<input style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
								    <button type="button" class="btn btn-default" onclick="execPostCode();" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">우편번호 찾기</button>                               
								</div>
								
								<div class="form-group">
									    <input class="col-lg-12"  placeholder="도로명 주소" name="address" id="address" type="text"  readonly="readonly" >
								</div>
								<div class="form-group">
									    <input class="col-lg-12"  placeholder="상세주소" name="address2" id="address2" type="text" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
								</div>			                      
			                      
			                      <div class="form-group">
			                      <label for="gender"  style="font-weight: bolder; color: black;">성별</label>
			                      <input type="radio" id="gender" name="gender" value="남자" class="click">남자
			                      <input type="radio" id="gender" name="gender" value="여자" class="click">여자 <br>
			                 	   </div> 		
			                      </div>                      
			        		
		    				 <input type="button" value="회원가입" class="btn btn-primary col-lg-12" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="check()">
		    		    </form>
                    </div>
                </div>
            </div>   	  
        </article>
    </main>

   	  <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		
		<script>
		function check() {		
			
			// 입력값 유효성 검증
			if($("#id").val() === null || $('#id').val() === ''){
				alert("ID를 입력하세요")
				return;
			}else if($("#nickname").val() === null || $('#nickname').val() === ''){
				alert("닉네임을 입력하세요")
				return;
			}else if(document.regForm.pw.value == '') {
				alert("비밀번호를 입력하세요")
				return;
			}else if(document.regForm.pw.value != document.regForm.pw_check.value){
				alert("비밀번호를 확인하세요")
				return false;
			}else if(document.regForm.name.value == ''){
				alert("이름를 입력하세요")
				return;
			}else  if(document.regForm.email.value == '') {
				alert("이메일을 입력하세요")
				return;
			}else {							
				idcheck(function(idResult) {
				      if (!idResult) {
				    	  alert("ID를 확인하세요")
				        return;
				      }
				      nickcheck(function(nickResult) {
				        if (!nickResult) {
				        	alert("닉네임을 확인하세요")
				          return;
				        }
				        if (confirm("회원 가입을 하시겠습니까?")) {
				          document.regForm.submit();
				        }
				      });
				    });
				  }
				};
				
		    function idcheck(callback){
		      if($("#id").val() === null || $('#id').val() === ''){
		        $(".id-check").text("ID를 입력하세요")
		        $(".id-check").attr("style","color:red")
		        callback(false);
		      }else if($("#id").val().indexOf(' ') != -1){
		    	  $(".id-check").text("공백을 제거하고 입력하세요")
			      $(".id-check").attr("style","color:red")
			      callback(false);
		      } else {
		        $.ajax({
		          async : false,
		          url : "/user/idcheck",
		          type : "get",
		          dataType : "JSON",
		          contentType : "application/json; charset=utf-8",
		          data : {"id" : $("#id").val()},
		          success : function(data){
		            if(data > 0 ){
		              $("#idcheck").attr("value", "N");
		              $(".id-check").text("중복된 ID입니다")
		              $(".id-check").attr("style","color:red")
		              callback(false)
		            } else {
		              $("#idcheck").attr("value", "Y");
		              $(".id-check").text("사용가능한 아이디입니다.")
		              $(".id-check").attr("style","color:blue")
		              callback(true);
		            }
		          }
		        });
		      }
		    }
		    
		    $("#id").on("blur", function() {
		      idcheck();
		    });
		 			
		function nickcheck(callback){
			
			if($("#nickname").val() === null || $('#nickname').val() === ''){
				$(".nick-check").text("닉네임을 입력하세요")
				$(".nick-check").attr("style","color:red")
				callback(false);
			}else if($("#nickname").val().indexOf(' ') != -1){
		    	  $(".nick-check").text("공백을 제거하고 입력하세요")
			      $(".nick-check").attr("style","color:red")
			      callback(false);
			}else{
			$.ajax({
				async : false,
				url : "/user/nicknamecheck",
				type : "get",
				dataType : "json",
				contentType : "text/html; charset=utf-8;",
				data : {"nickname" : $("#nickname").val()},
				success : function(data){
					if(data >0){
						$(".nick-check").text("중복된 닉네임입니다.")
						$(".nick-check").attr("style","color:red")						
						callback(false);
					}else {
						$("#nickcheck").attr("value", "Y");
						$(".nick-check").text("사용가능한 닉네임입니다.")
						$(".nick-check").attr("style","color:blue")
						callback(true);
					 }
		          }
		        });
		      }
		    }
		    
		    $("#nickname").on("blur", function() {
		      nickcheck();
		    });
   	 
		function execPostCode() {
	         new daum.Postcode({
	             oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	 
	                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	 
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	 
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                console.log(data.zonecode);
	                console.log(fullRoadAddr);
	                
	                
	             // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('address').value = fullRoadAddr;

	                
	                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
	                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
	            }
	         }).open();
	     }
	</script>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>