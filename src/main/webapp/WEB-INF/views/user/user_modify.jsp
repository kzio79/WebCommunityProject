
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
	<main class="w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
	    <article class="col-lg-4" style="margin-top: 2%">
	        <div >
	            <div style="width: 100%"> 
	                <div class="form-floating">
                        <h2 align="center">${sessionScope.nickname}님의 회원정보</h2>		    
	                    <form name="regForm2" id="Form2" action="modify_result" method="post">
	                        <div class="col-lg-12">
	                        	<div class="form-group">
	                            <label for="id" style="font-weight: bolder; color: black;">아이디</label>
	                            <input type="text" id="id" name="id" class="col-lg-12" value="${dto.id }" readonly>	                            
	                            </div>
	                            
	                            <div class="form-group">             
	                            <label for="pw" style="font-weight: bolder; color: black;">비밀번호</label>
	                            <input type="password" id="pw" name="pw" class="col-lg-12" value="${dto.pw }" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
                            	</div>
                            	
	                            <div class="form-group">
	                            <label for="name" style="font-weight: bolder; color: black;">이름</label>
	                            <input type="text" id="name" name="name" class="col-lg-12" value="${dto.name }" readonly>
	                            </div>
	                            
	                            <div class="form-group">	                                           
	                            <label for="nickname" style="font-weight: bolder; color: black;">닉네임</label>
	                            <input type="text" id="nickname" name="nickname" class="col-lg-12" value="${dto.nickname }" readonly>
	                            </div>
	                            
	                            <div class="form-group">
	                            <label for="email" style="font-weight: bolder; color: black;">이메일</label>
	                            <input type="email" id="email" name="email" class="col-lg-12" value="${dto.email }" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"><br>
	                            </div>
	                            
	                            <div class="form-group">                   
		                      	<label for="address" style="font-weight: bolder; color: black;">주소</label> <br>             
								<input style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" value="${dto.addr1 }" type="text" readonly="readonly">
							    <button type="button" class="btn btn-default" onclick="execPostCode();" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">우편번호 찾기</button>                               
								</div>
								<div class="form-group">
								    <input class="col-lg-12"  placeholder="도로명 주소" name="address" id="address" value="${dto.address }" type="text" readonly="readonly">
								</div>
								<div class="form-group">
								    <input class="col-lg-12"  placeholder="상세주소" name="address2" id="address2" value="${dto.address2 }" type="text" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
								</div>
								
								<div class="form-group">	
	                            <label for="gender" style="font-weight: bolder; color: black;">성별</label>
	                            <input type="text" name="gender" class="col-lg-12" value="${dto.gender }" readonly>
	                            </div>                   
	                        </div>
	                        <div align="center">  
	                        <br>  
	                            <button type="submit" class="btn btn-primary col-lg-3"  onclick="check()" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">정보 수정</button>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </article>  
	</main>
   	  <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js">	</script>
   	  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
     	<script>
     	function check() {
		  if(confirm("회원 정보를 수정하시겠습니까?")){
				document.regForm2.submit();//자바스크립트의 submit()는 form태그 submit기능과 동일
				}
			}	
	     	
	     function deletecheck() {
		  if(confirm("회원 탈퇴를 하시겠습니까?")){
			  location.href='delete';
				}
			}	
	     
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
    			


   	  




