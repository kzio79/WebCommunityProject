package com.comunity.domain;

public class PageVO {

	//화면에 그려질 버튼의 개수를 개산하는 클래스
	private int startPage;    //시작번호
	private int endPage;      //끝번호
	private int total;        //전체게시글 수
	
	private int pageNum;      //현재 조회하는 페이지
	
	private boolean next;     //다음 버튼 활성화 여부
	private boolean prev;     //이전 버튼 활성화 여부
	
	private Criteria cri;     //페이지 기준

	//생성자는 기본 생성자를 생성하지 못함 . total과 Criteria를 받아서 계산하도록 처리...
	public PageVO(int total, Criteria cri) {
		//전달되는 매개변수에서 초기값을 저장
		this.total = total;
		this.cri = cri;
		
		this.pageNum = cri.getPageNum();
		
		//끝페이지 계산
		//계산식 = (int)Math.ceil(조회하는 페이지 번호 / (double)10) * 10(표시할 페이지번호 개수)
		this.endPage = (int)Math.ceil(cri.getPageNum()/(double)10)*10;
		
		//시작페이지 계산
		//계산신 = 끝페이지 - 한번에 보여질 페이지 번호(표시할 페이번호 개수) +1
		this.startPage = (endPage - 10) + 1; // - 9와 같음 
		
		//real페이지 번호 : realEnd는 표시될 페이지 번호의 끝번호 보다 작을 때 나타나는 진짜 끝번호.
		int realEnd = (int)Math.ceil(this.total/(double)cri.getCount());
		
		//마지막 페이지 설정에서 보여줘야 할 번호
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		//이전페이지 버튼 활성화 여부
		this.prev = startPage > 1;
		
		//다음페이지 버튼 활성화 여부
		this.next = realEnd > this.endPage;		
	}
		
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
	
	
}
