package com.comunity.service;

import java.util.List;
import java.util.Map;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

public interface CodeService {

	public List<BoardDTO> getListWithPagingCode(Criteria cri);			//전체 게시물 리스트 보기
	public List<BoardDTO> getListOneCode(String title);					
	public List<BoardDTO> getListTotalSearchCode(Map<String, Object> map); //검색 리스트 불러와서 저장
	public int getListSearchCountCode(String title);	//제목 입력 후 검색한 제목의 게시물 카운트
	public int getListTotalCode();					//게시물 전체 개수 카운트
	public void insertBoardCode(BoardDTO dto);		//게시물 작성
	public BoardDTO getContentCode(int cnum);		//게시물 보기
	public void updateBoardCode(BoardDTO dto);		//게시물 수정
	public void deleteCode(int cnum);				//게시물 삭제
	public void updateHitCode(int cnum);			//게시물 조회수
	public List<BoardDTO> getListCodeForHome();
}
