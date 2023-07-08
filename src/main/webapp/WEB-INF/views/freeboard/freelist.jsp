<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	 <div id="colorlib-main">
	  <div class="container" style="margin-top: 50px">
		<h3>자유 게시판</h3>
		
			<table class="table table-hover">
			<!-- 게시글...  -->
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
			  
				<c:forEach var="dto" items="${freelist }">
					<tr>
						<td>${dto.fnum }</td>
						<td>${dto.writer }</td>
						<td><a href="freecontent?pageNum=${paging.pageNum }&fnum=${dto.fnum}" class="click" />${dto.title }</td>
						<td>${dto.regdate }</td>
						<td>${dto.hit }</td>
						<td>${dto.regdate}</td>
					</tr>
				</c:forEach>	
			</tbody>
			<tbody>
				<!-- 작성글 검색 및 글작성하기 메뉴 -->
				<tr>
					<td colspan="5" align="right">
						<form action="freelistsearch" class="form-inline" method="post">
							<div class="form-group">
								<input type="text" name="freesearch" placeholder="제목검색" class="form-control" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
								<input type="submit" value="검색" class="btn btn-default" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
								<input type="button" value="글 작성" class="btn btn-primary" onclick="regitry()" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
							</div>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		
		<script type="text/javascript">
			function regitry(){
				<%if(session.getAttribute("id") == null){%>
					alert("로그인 후 작성하세요");
					
				<%}else{%>
					location.href="/freeboard/freeregister?pageNum="+${paging.pageNum};
				<%}%>
			}
		
		</script>
		
		
		
		<!-- 페이지 작업하는 공간 -->
		<div>
			<nav class="navbar" >
				 <!-- 2. 이전 버튼 활성여부  -->
				<c:if test="${paging.prev }">
					<a href="freelist?pageNum=${paging.startPage -1 }" class="click">이전</a>
				</c:if> 
				<!-- 1. 페이지 번호 처리 -->
				<c:forEach var="fnum" begin="${paging.startPage }" end="${paging.endPage }">
				    <button class="btn btn-default${paging.pageNum == fnum ? 'btn btn-primary pull' : '' }" onclick="location.href='freelist?pageNum=${fnum }'"
				    style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; ">
				    ${fnum }
				    </button>
				</c:forEach>
				<c:if test="${paging.next }">
					<a href="freelist?pageNum=${paging.endPage +1 }" class="click">다음</a>
				</c:if> 
			</nav>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	