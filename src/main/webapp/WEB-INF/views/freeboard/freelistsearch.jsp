<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div id="colorlib-main"> 
	 <div class="container" style="margin-top: 50px">
		<c:if test="${not empty freesearch}"><h3>자유 게시판 "${freesearch}" 검색결과</h3></c:if>
	    <c:if test="${empty freesearch}"><h3>자유 게시판 "검색어"가 없습니다.</h3></c:if> 
		
		<table class="table table-boardered">
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
			  <c:if test="${not empty freesearch}">
				<c:forEach var="dto" items="${freelistsearch }">
					<tr>
						<td>${dto.fnum }</td>
						<td>${dto.writer }</td>
						<td><a href="freecontentsearch?pageNum=${paging.pageNum }&fnum=${dto.fnum }&freesearch=${freesearch}" class="click"/>${dto.title }</td>
						<td>${dto.regdate }</td>
						<td>${dto.hit }</td>
						<td>${dto.regdate}</td>
					</tr>
				</c:forEach>
			  </c:if>	
			</tbody>
			<tbody>
				<!-- 작성글 검색 및 글작성하기 메뉴 -->
				<tr>
					<td colspan="5" align="right">
						<form action="freeregister" class="form-inline">
							<div class="form-group">
								<input type="button" value="글작성" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="regitry()">
								<input type="button" value="목록" class="btn btn-primary" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;" onclick="location.href='freelist'">
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
			<nav class="navbar">
				 <!-- 2. 이전 버튼 활성호 ㅏ여부  -->
				<c:if test="${paging.prev }">
					<a href="freelistsearch?pageNum=${paging.startPage -1 }&freesearch=${freesearch }" class="click">이전</a>
				</c:if> 
				<!-- 1. 페이지 번호 처리 -->
				<c:forEach var="fnum" begin="${paging.startPage }" end="${paging.endPage }">
					<button class="btn btn-default${paging.pageNum == fnum ? 'btn btn-primary pull' : '' }"	onclick="location.href='freelistsearch?pageNum=${fnum }&freesearch=${freesearch }'"
					style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">
					${fnum }
					</button>
				</c:forEach>
				<c:if test="${paging.next }">
					<a href="freelistsearch?pageNum=${paging.endPage +1 }&freesearch=${freesearch }" class="click">다음</a>
				</c:if> 
			</nav>>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

	