package com.comunity.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;

@Mapper
public interface FreeBoardMapper {
	public List<BoardDTO> getListWithPagingFree(Criteria cri); //list보기
	public List<BoardDTO> getListOneFree(String title); //list에서 검색
	public int getListTotalFree();  //게시글 총 갯수
	public int getListSearchCountFree(String title); //제목 입력해서 카운트 
	public List<BoardDTO> getListTotalSearchFree(Map<String, Object> map); //list에서 검색후 페이징
	public int insertBoardFree(BoardDTO dto); //게시글 등록
	public BoardDTO getContentFree(int fnum); //게시글 상세보기
	public int updateBoardFree(BoardDTO dto);
	public void deleteBoardFree(int fnum);
	public int hitFree(int fnum);
	public List<BoardDTO> getListFreeForHome();
}
