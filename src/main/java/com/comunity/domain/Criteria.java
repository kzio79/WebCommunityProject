package com.comunity.domain;

public class Criteria {
	//MySQL : select * from board order by num desc limit ?,?;
	private int pageNum;  //페이지 번호
	private int count;    //몇개의 데이터를 묶어 출력할지
	
	public Criteria() {
		//최초 게시판에 진입 할 떄 기본갑 1번 페이지, 10개의 데이터 설정
		this.pageNum = 1;
		this.count = 10;
	}

	public Criteria(int pageNum, int count) {
		//전달받은 매개변수를 이용한 페이지 값 출력
		this.pageNum = pageNum;
		this.count = count;
	}
	
	//limit x, count 에서 x에 전달될 값을 구하는 메서드
	public int getPageStart() {
		return (pageNum - 1)* count;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}
