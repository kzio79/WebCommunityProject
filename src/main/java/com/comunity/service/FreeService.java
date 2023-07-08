package com.comunity.service;

import java.util.List;
import java.util.Map;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

public interface FreeService {

	public List<BoardDTO> getListWithPagingFree(Criteria cri);			//전체 게시물 리스트 보기
	public List<BoardDTO> getListOneFree(String title);					
	public List<BoardDTO> getListTotalSearchFree(Map<String, Object> map); //검색 리스트 불러와서 저장
	public int getListSearchCountFree(String title);	//제목 입력 후 검색한 제목의 게시물 카운트
	public int getListTotalFree();					//게시물 전체 개수 카운트
	public void insertBoardFree(BoardDTO dto);		//게시물 작성
	public BoardDTO getContentFree(int fnum);		//게시물 보기
	public void updateBoardFree(BoardDTO dto);		//게시물 수정
	public void deleteFree(int fnum);				//게시물 삭제
	public void updateHitFree(int fnum);			//게시물 조회수
	public List<BoardDTO> getListFreeForHome();	    //home에서 조회수 높은 3개의 글 출력

}
