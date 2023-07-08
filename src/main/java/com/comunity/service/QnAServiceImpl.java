package com.comunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.mapper.QnaBoardMapper;

@Service("qnaservice")
public class QnAServiceImpl implements QnAService{

	@Autowired
	private QnaBoardMapper qnamapper;
	
	@Override
	public List<BoardDTO> getListWithPagingQna(Criteria cri) {
		List<BoardDTO> qnalist = qnamapper.getListWithPagingQna(cri);
		return qnalist;
	}
	
	@Override
	public List<BoardDTO> getListOneQna(String title) {
		List<BoardDTO> qnalistone = qnamapper.getListOneQna(title);
		return qnalistone;
	}
	
	@Override
	public int getListSearchCountQna(String title) {
		int total = qnamapper.getListSearchCountQna(title);
		return total;
	}
	
	@Override
	public List<BoardDTO> getListTotalSearchQna(Map<String, Object> map) {
		List<BoardDTO> searchlist = qnamapper.getListTotalSearchQna(map);
		return searchlist;
	}
	
	@Override
	public int getListTotalQna() {
		int total = qnamapper.getListTotalQna();
		return total;
	}
	
	
	@Override
	public BoardDTO getContentQna(int qnum) {
		BoardDTO dto = qnamapper.getContentQna(qnum);
		return dto;
	}
	
	@Override
	public void insertBoardQna(BoardDTO dto) {
		qnamapper.insertBoardQna(dto);
	}
	
	@Override
	public void updateBoardQna(BoardDTO dto) {
		qnamapper.updateBoardQna(dto);
	}
	
	@Override
	public void deleteQna(int qnum) {
		qnamapper.deleteBoardQna(qnum);
	}
	
	@Override
	public void updateHitQna(int qnum) {
		qnamapper.hitQna(qnum);
		
	}

	@Override
	public List<BoardDTO> getListQnaForHome() {
		List<BoardDTO> qnaList = qnamapper.getListQnaForHome();
		
		return qnaList;
	}	
	
}
