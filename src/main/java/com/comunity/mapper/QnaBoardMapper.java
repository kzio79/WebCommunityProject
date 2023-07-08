package com.comunity.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

@Mapper
public interface QnaBoardMapper {

	public List<BoardDTO> getListWithPagingQna(Criteria cri); //list보기
	public List<BoardDTO> getListOneQna(String title); //list에서 검색
	public int getListTotalQna();  //게시글 총 갯수
	public int getListSearchCountQna(String title); //제목 입력해서 카운트 
	public List<BoardDTO> getListTotalSearchQna(Map<String, Object> map); //list에서 검색후 페이징
	public int insertBoardQna(BoardDTO dto); //게시글 등록
	public BoardDTO getContentQna(int qnum); //게시글 상세보기
	public int updateBoardQna(BoardDTO dto);
	public void deleteBoardQna(int qnum);
	public int hitQna(int qnum);
	public List<BoardDTO> getListQnaForHome(); //홈에 인기 게시글 list보기
}
