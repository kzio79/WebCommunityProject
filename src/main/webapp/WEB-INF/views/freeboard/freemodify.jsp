<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	 <div id="colorlib-main">
		<article class="container" style="margin-top: 2%; margin-left:5%;" >
				  <div align="center"  class="card col-lg-12" style="margin-top: 5%;">
				    <form  action="freeupdate?pageNum=${pageNum}&fnum=${dto.fnum}" name="regform" style="margin-bottom: 5%; margin-top:2%;" method="post">
				      <h2><em>Freeboard modify</em></h2>
				      <hr>
				      <table style= "width:80%;">
				        <tr>
				           <td style="color: black; font-weight: bolder;">
				           	 글번호&nbsp;<input type="text" name="fnum"  value="${dto.fnum}" readonly></td>
				        </tr>
				        <tr>
				          <td style="color: black; font-weight: bolder;">
				          	작성자&nbsp;<input type="text" name="writer" value="${dto.writer}" readonly></td>
				        </tr>
				        <tr>
				          <td style="color: black; font-weight: bolder;">
				          		글제목&nbsp;<input type="text" name="title" value="${dto.title}" style="width: 90%;" class="click"></td>
				        </tr>
				        <tr>
				          <td style="color: black; font-weight: bolder;">
				            글내용<textarea rows="12" style="width:100%;" name="content" class="click">${dto.content}</textarea>
				          </td>
				        </tr>
				        <tr style="margin-bottom: 5%">
				          <!-- 글 수정 메뉴 -->
				          <td colspan="2" align="center" style="margin-bottom: 5%">
				            <input type="button" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" value="수정" onclick="modifyCheck();">
				            <button type="button" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="location.href='freelist?pageNum=${pageNum}'">목록</button>
				            <button type="button" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="deleteCheck();">삭제하기</button>
				          </td>
				        </tr>
				      </table>
				    </form>
				  </div>
			</article>
	<!-- 
		registCheck() 구현 ...
		작성자 , 글제목에 공백을 확인하고, 공백이 아니라면 submit()처리 
		
	 -->
	 <script>
	 	function modifyCheck(){
	 		if(document.regform.title.value == ""){
	 			alert("제목을 입력하세요");
	 			return;
	 		}else if(confirm("게시글을 수정하겠습니까?")){
	 			document.regform.submit();	 		
	 		}
	 	}
 		function deleteCheck() {
			if(confirm("게시글을 삭제 하겠습니까?")){
				location.href="freedelete?pageNum=${pageNum}&fnum=${dto.fnum}";
			}				
	 	}
	 </script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
	
