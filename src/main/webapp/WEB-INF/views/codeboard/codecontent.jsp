<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	   <main class="w-100 m-auto" style="display: flex;  justify-content: center; align-items: center;">
   		 <article class="col-lg-6" style="margin-top: 2%; margin-left: 5%">       
        	 <div align="center">
                <h1 class="container"><em>Code Board Content</em></h1>  
                	<div align="left" style="margin: 1%; font-weight: bolder;">
                  	  <label > NO.  ${dto.cnum }</label>
                  	</div>
                  <div class="card" align="left" style="margin: 1%">
                      <label >제목 : ${dto.title}</label>
                      <label >작성자 : ${dto.writer}</label>
                      <label >작성일 : ${dto.regdate},  조회수 : ${dto.hit }</label> 
                  </div>
                  <div class="card" align="left" style="margin: 1%">
                      <label ><pre>${dto.content}</pre></label>
                  </div>
       		 </div><br>
  			<!-- 글 등록 메뉴 -->	
	 			<div align="center">				
					<input type="button" value="목록" class="btn btn-primary" onclick="location.href='codelist?pageNum=${pageNum}'" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
					<input type="button" value="수정" class="btn btn-primary" ${sessionScope.nickname != dto.writer ? 'hidden' : '' } ${dto.regdate < user_create ? 'hidden' : ''}  onclick="location.href='codemodify?pageNum=${pageNum }&cnum=${dto.cnum}'"
					style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">					
				</div>	 
					<br>		 
		 <!--댓글 작성 -->
				<div> 
				 	<div class="form-group" align="center" style="margin: 2%;">
							<form name="replyinsert" action="codereplyinsert?pageNum=${pageNum }&cnum=${dto.cnum}" method="post" encType = "multipart/form-data" >
								<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
									<tr>
										<td style="border-bottom:none;" valign="middle"></td>
										<td><input name = "commentText" type="Text" style="height:20%; width:100%;	cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; " class="form-control"  ${sessionScope.nickname == null ? 'placeholder="로그인 후 이용해주세요." disabled' : 'placeholder="댓글 작성"' } ></td>
										<td><input type="button" class="btn btn-primary pull" ${sessionScope.nickname == null ? 'disabled' : '' } value="댓글 작성" onclick="replytry()" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; "></td>
									</tr>
								</table>
							</form>
				  </div>
		
		
				 <!--댓글리스트, 삭제 -->
		  <div id="reply">
						<oi class="replyList" wdith="700px">
							<c:forEach var="reply" items="${reply}" >
							    <oi>
							      <p>
							      작성자 : ${reply.replyer}<br />
							      작성 날짜 :  <fmt:formatDate value="${reply.create_date}" pattern="yyyy-MM-dd HH:mm:ss" />
					              </p>
					                  <p>${reply.replytext}</p>
						              <form action="codereplydelete?pageNum=${pageNum }&cnum=${dto.cnum}&deletereply=${reply.reply_number}" method="post" >
										  <input type="submit" name="delete"  class="btn btn-default" ${sessionScope.nickname != reply.replyer ? 'hidden' : '' } ${reply.create_date < user_create ? 'hidden' : ''} value="삭제" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
							     	  </form>
							     	  <hr>
							     </oi>
							 </c:forEach>   
						</oi>
					</div>
				 </div>
				 
				 
				 
				
		<!-- 로그인 안하면 댓글 작성 x, 엔터키 입력 x -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>		
		  <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>	
			  <script type="text/javascript">
				
				
			  		
			  		//로그인을 하지 않고 댓글 작성시 
			  		function replytry(){
					<%if(session.getAttribute("id") == null){%>
						alert("로그인 후 작성하세요");
						
					<%}else{%>
					  	document.replyinsert.submit();
					  <%}%>
					}
			  	//엔터키 값
					document.addEventListener('keydown', function(event) {
						  if (event.keyCode === 13) {
						    event.preventDefault();
						  };
						}, true);		
				//	
			</script>
			
	</article>
  </main> 		
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

