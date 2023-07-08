package com.comunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.mapper.CodeBoardMapper;

@Service("codeservice")
public class CodeServiceImpl implements CodeService{

	@Autowired
	private CodeBoardMapper codemapper;
	
	@Override
	public List<BoardDTO> getListWithPagingCode(Criteria cri) {
		List<BoardDTO> codelist = codemapper.getListWithPagingCode(cri);
		
		return codelist;
	}	
	
	@Override
	public List<BoardDTO> getListOneCode(String title) {
		List<BoardDTO> codelistone = codemapper.getListOneCode(title);
		return codelistone;
	}
	
	@Override
	public List<BoardDTO> getListTotalSearchCode(Map<String, Object> map) {
		List<BoardDTO> searchlist = codemapper.getListTotalSearchCode(map);
		return searchlist;
	}
	
	
	@Override
	public int getListTotalCode() {
		int total = codemapper.getListTotalCode();
		return total;
	}
	
	@Override
	public int getListSearchCountCode(String title) {
		int total = codemapper.getListSearchCountCode(title);
		return total;
	}
	
	
	@Override
	public BoardDTO getContentCode(int cnum) {
		BoardDTO dto = codemapper.getContentCode(cnum);
		return dto;
	}
	
	@Override
	public void insertBoardCode(BoardDTO dto) {
		codemapper.insertBoardCode(dto);
		
	}
	
	@Override
	public void updateBoardCode(BoardDTO dto) {
		codemapper.updateBoardCode(dto);
	}
	
	@Override
	public void deleteCode(int cnum) {
		codemapper.deleteBoardCode(cnum);
		
	}
	@Override
		public void updateHitCode(int cnum) {
			codemapper.hitCode(cnum);
			
		}
	
	@Override
	public List<BoardDTO> getListCodeForHome() {
		List<BoardDTO> codeList = codemapper.getListCodeForHome();
		
		return codeList;
	}
	
}
