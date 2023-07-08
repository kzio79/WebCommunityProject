<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	 <div id="colorlib-main">
	   <article class="container" style="margin-top: 2%; margin-left:5%;" >
				  <div align="center"  class="card col-lg-12" style="margin-top: 5%;">
				    <form  action="freeregister?pageNum=${pageNum }" name="regform" style="margin-bottom: 5%; margin-top: 2%" method="post">
				      <h2><em>Freeboard write</em></h2>
				      <hr>
				      <table style= "width:80%;">
				         <tr>
				          <td style="color: black; font-weight: bolder;">
				          	작성자&nbsp;<input type="text" name="writer" value="${sessionScope.nickname }" ${sessionScope.nickname != null ? "readonly" :""} readonly></td>
				        </tr>
				        <tr>
				          <td style="color: black; font-weight: bolder;">
				          	글제목&nbsp;<input type="text" name="title"  style="width: 90%;" class="click"></td>
				        </tr>
				        <tr>
				          <td style="color: black; font-weight: bolder;">
				            글내용<textarea rows="12" style="width:100%;" name="content" class="click">${dto.content}</textarea>
				          </td>
				        </tr>
				        <tr style="margin-bottom: 5%">
				          <!-- 글 수정 메뉴 -->
				          <td colspan="2" align="center" style="margin-bottom: 5%">
				            <input type="button" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" value="등록" onclick="registCheck();">
				            <input type="button" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" value="목록" onclick="location.href='freelist?pageNum=${pageNum}'">
				          </td>
				        </tr>
				      </table>
				    </form>
				  </div>
				</article>

	 <script>
	 	function registCheck(){
	 		if(document.regform.writer.value == ""){
	 			alert("작성자를 입력하세요");
	 			return;
	 		}else if(document.regform.title.value == ""){
	 			alert("제목을 입력하세요");
	 			return;
	 		}else if(document.regform.content.value == "" || document.regform.content.value.trim() == ""){
	 			alert("글을 입력하세요");
	 			return;
	 		}else if(confirm("게시글을 등록하겠습니까?")){
	 			document.regform.submit();
	 		}
	 	}
	 </script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>	

