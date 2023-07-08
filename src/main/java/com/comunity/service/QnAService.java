package com.comunity.service;

import java.util.List;
import java.util.Map;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

public interface QnAService {

	public List<BoardDTO> getListWithPagingQna(Criteria cri);			//전체 게시물 리스트 보기
	public List<BoardDTO> getListOneQna(String title);					
	public List<BoardDTO> getListTotalSearchQna(Map<String, Object> map); //검색 리스트 불러와서 저장
	public int getListSearchCountQna(String title);	//제목 입력 후 검색한 제목의 게시물 카운트
	public int getListTotalQna();					//게시물 전체 개수 카운트
	public void insertBoardQna(BoardDTO dto);		//게시물 작성
	public BoardDTO getContentQna(int qnum);		//게시물 보기
	public void updateBoardQna(BoardDTO dto);		//게시물 수정
	public void deleteQna(int qnum);				//게시물 삭제
	public void updateHitQna(int qnum);			//게시물 조회수
	public List<BoardDTO> getListQnaForHome();
}
