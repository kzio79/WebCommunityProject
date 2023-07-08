package com.comunity.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

@Mapper
public interface CodeBoardMapper {

	public List<BoardDTO> getListWithPagingCode(Criteria cri); //list보기
	public List<BoardDTO> getListOneCode(String title); //list에서 검색
	public int getListTotalCode();  //게시글 총 갯수
	public int getListSearchCountCode(String title); //제목 입력해서 카운트 
	public List<BoardDTO> getListTotalSearchCode(Map<String, Object> map); //list에서 검색후 페이징
	public int insertBoardCode(BoardDTO dto); //게시글 등록
	public BoardDTO getContentCode(int cnum); //게시글 상세보기
	public int updateBoardCode(BoardDTO dto);
	public void deleteBoardCode(int cnum);
	public int hitCode(int cnum);
	public List<BoardDTO> getListCodeForHome();	//홈 페이지 list

}
