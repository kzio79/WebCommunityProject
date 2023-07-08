<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

		<div id="colorlib-main">
			<div class="hero-wrap js-fullheight" style="background-image: url(${pageContext.request.contextPath }/images/a.jpg);" data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				<div class="js-fullheight d-flex justify-content-center align-items-center">
					<div class="col-md-8 text text-center">
						<div class="img mb-4" style="background-image: url(${pageContext.request.contextPath }/images/b.jpg);" ></div>
						<div class="desc">
							<h2 class="subheading">환영합니다.</h2>
							<h1 class="mb-4">웹 개발 커뮤니티</h1>
							<p class="mb-4">웹 개발을 위한 소통 및 공유를 위한 커뮤니티입니다.</p>
						</div>
					</div>
				</div>
			</div>
<section class="ftco-section">
	<div class="container">
    	<div class="row justify-content-center mb-5 pb-2">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2 class="mb-4">인기 게시물</h2><br>
          </div>
          
           <div class="col-md-7 heading-section text-center ftco-animate">
            <h5>코드 게시판</h5>
           </div> 
           
          		<table class="table table-boardered" style="margin-left: 5%">
			<!-- 게시글...  -->
			<thead>
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성 날짜</th>
				</tr>
			</thead>
			<tbody>
			  
				<c:forEach var="codeList" items="${codeList }" end="2">
					<tr>
						<td>${codeList.cnum }</td>
						<td><a href="codeboard/codecontent?pageNum=${paging }&cnum=${codeList.cnum }" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"/>${codeList.title }</td>
						<td>${codeList.writer }</td>
						<td>${codeList.hit }</td>
						<td>${codeList.newdate}</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
        </div>
        
        <div class="row justify-content-center mb-5 pb-2">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h5>자유 게시판</h5>
          </div>
          
          		<table class="table table-boardered" style="margin-left: 5%">
			<!-- 게시글...  -->
			<thead>
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성 날짜</th>
				</tr>
			</thead>
			<tbody>
			  
				<c:forEach var="freeList" items="${freeList }" end="2">
					<tr>
						<td>${freeList.fnum }</td>
						<td><a href="freeboard/freecontent?pageNum=${paging }&fnum=${freeList.fnum }" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"/>${freeList.title }</td>
						<td>${freeList.writer }</td>
						<td>${freeList.hit }</td>
						<td>${freeList.newdate}</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
        </div>
        
        <div class="row justify-content-center mb-5 pb-2">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h5>질문 게시판</h5>
          </div>
          
          		<table class="table table-boardered" style="margin-left: 5%">
			<!-- 게시글...  -->
			<thead>
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성 날짜</th>
				</tr>
			</thead>
			<tbody>
			  
				<c:forEach var="qnaList" items="${qnaList }" end="2">
					<tr>
						<td>${qnaList.qnum }</td>
						<td><a href="qnaboard/qnacontent?pageNum=${paging }&qnum=${qnaList.qnum }" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"/>${qnaList.title }</td>
						<td>${qnaList.writer }</td>
						<td>${qnaList.hit }</td>
						<td>${qnaList.newdate}</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
        </div>
        
   <div class="row">
    <div class="container">
    	<div class="row justify-content-center mb-5 pb-2">
          <div class="col-md-7 heading-section text-center ftco-animate" style="margin-top: 25%">
            <h2 class="mb-4">웹 개발을 위한 입문 가이드</h2>
            <p>Java, MySQL, Spring, HTML, CSS, JavaScript</p>
          </div>
        </div>
        
    		<div class="row">
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate" >
							<a href="https://www.oracle.com/java/" target="_blank" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/java.jpg);  background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://www.oracle.com/java/" target="_blank" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;">Java</a></h3>
	              <p class="mb-4">Java는 1995년 Sun Microsystems에서 처음 출시한 프로그래밍 언어 및 컴퓨팅 플랫폼입니다.</p>
	              
					<a href="https://www.w3schools.com/java/default.asp" target="_blank" class="click">Learn</a><br>
					<a href="https://www.w3schools.com/java/java_examples.asp" target="_blank" class="click">Examples</a><br>
					<a href="https://www.oracle.com/java/technologies/downloads/" target="_blank" class="click">JDK Download</a><br>
		              	<span id="down" style="cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer; color: #f05d23;" onclick="if(IDE.style.display == 'none')
		              	{IDE.style.display=''; down.innerText = 'IDE Downloads ▼'}else {IDE.style.display = 'none'; down.innerText = 'IDE Downloads'}">
		              	IDE Downloads
		              	</span>
	              	<div id="IDE" style="display: none">
			            <a href="https://www.eclipse.org/downloads/" target="_blank" class="click">Download - Eclipse</a><br>	              		           	              	
		              	<a href="https://code.visualstudio.com/Download" target="_blank" class="click">Download - Visual Studio Code</a>            
		            </div>
	            			</div>
					</div>					
    			</div>
    			
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate">
							<a href="https://www.mysql.com/" target="_blnak" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/mysql.jpg); background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://www.mysql.com/" target="_blnak" class="click">MySQL</a></h3>
	              <p class="mb-4">MySQL은 가장 널리 사용되고 있는 관계형 데이터베이스 관리 시스템(RDBMS: Relational DBMS)입니다. </p>
	              <a href="https://www.w3schools.com/mysql/default.asp" target="_blank" class="click">Learn</a><br>
	              <a href="https://www.w3schools.com/mysql/mysql_examples.asp" target="_blank" class="click">Examples</a><br>
	              <a href="https://www.mysql.com/downloads/" target="_blank" class="click">Download</a>
	            </div>
						</div>
    			</div>
    			
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate">
							<a href="https://spring.io" target="_blank" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/spring.jpg); background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://spring.io" target="_blank" class="click">Spring</a></h3>
	              <p class="mb-4">Spring은 Java 애플리케이션 개발을 위한 인프라 지원을 제공하는 오픈 소스 애플리케이션 프레임워크입니다. </p>
	              <a href="https://spring.academy/" target="_blank" class="click">Learn</a><br>
	              <a href="https://spring.io/tools" target="_blank" class="click">Download</a>	              
	            </div>
					</div>
    			</div>
    			
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate">
							<a href="https://html.spec.whatwg.org/multipage/" target="_blnak" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/html.jpg); background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://html.spec.whatwg.org/multipage/" target="_blnak" class="click">HTML</a></h3>
	              <p class="mb-4">HyperText Markup Language 또는 HTML은 웹 브라우저에 표시되도록 설계된 문서의 표준 마크업 언어입니다. 종종 CSS(Cascading Style Sheets)와 같은 기술과 JavaScript와 같은 스크립팅 언어의 지원을 받습니다..</p>
	               <a href="https://www.w3schools.com/html/default.asp" target="_blank" class="click">Learn</a><br>
	               <a href="https://www.w3schools.com/html/html_examples.asp" target="_blank" class="click">Examples</a>
	            </div>
					</div>
    			</div>
    			
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate">
							<a href="https://www.w3.org/TR/CSS/#css" target="_blank" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/css.jpg); background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://www.w3.org/TR/CSS/#css" target="_blank" class="click">CSS</a></h3>
	              <p class="mb-4">CSS는 Cascading Style Sheets 언어를 나타내며 HTML과 같은 마크업 언어로 작성된 요소를 스타일화하는 데 사용됩니다.</p>
	              <a href="https://www.w3schools.com/css/default.asp" target="_blank" class="click">Learn</a><br>
	              <a href="https://www.w3schools.com/css/css_examples.asp" target="_blank" class="click">Examples</a>
	            </div>
					</div>
    			</div>
    			
    			<div class="col-md-4">
    				<div class="blog-entry ftco-animate">
							<a href="https://www.javascript.com/" target="_blank" class="img img-2" style="background-image: url(${pageContext.request.contextPath }/images/javascript\.jpg); background-size:contain; cursor: url(${pageContext.request.contextPath }/images/click.png) 8 0, pointer;"></a>
							<div class="text text-2 pt-2 mt-3">
	              <h3 class="mb-4"><a href="https://www.javascript.com/" target="_blank" class="click">JavaScript</a></h3>
	              <p class="mb-4">JavaScript는 개발자가 대화형 웹 페이지를 만드는 데 사용하는 프로그래밍 언어입니다. 클라이언트 측 스크립팅 언어로서 World Wide Web의 핵심 기술 중 하나입니다.</p>
	              <a href="https://www.w3schools.com/js/default.asp" target="_blank" class="click">Learn</a><br>
	              <a href="https://www.w3schools.com/js/js_examples.asp" target="_blank" class="click">Examples</a>
	            </div>
					</div>

    		</div>
    	    </div>
  	  </div>
	</div>
   </div>	
    </section>	            	

    <%@ include file="/WEB-INF/views/include/footer.jsp" %>