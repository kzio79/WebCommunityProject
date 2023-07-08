package com.comunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.mapper.FreeBoardMapper;

@Service("freeservice")
public class FreeServiceImpl implements FreeService{

	@Autowired
	private FreeBoardMapper freemapper;
	
	@Override
		public List<BoardDTO> getListWithPagingFree(Criteria cri) {
			List<BoardDTO> freelist = freemapper.getListWithPagingFree(cri);
			return freelist;
		}	
	
	@Override
	public List<BoardDTO> getListOneFree(String title) {
		List<BoardDTO> freelistone = freemapper.getListOneFree(title);
		return freelistone;
	}
	
	@Override
	public List<BoardDTO> getListTotalSearchFree(Map<String, Object> map) {
		List<BoardDTO> searchlist = freemapper.getListTotalSearchFree(map);
		return searchlist;
		}
	
	@Override
	public int getListTotalFree() {
		int total = freemapper.getListTotalFree();
		return total;
	}
	
	@Override
	public int getListSearchCountFree(String title) {
		int total = freemapper.getListSearchCountFree(title);
		return total;
	}
	
	@Override
	public BoardDTO getContentFree(int fnum) {
		BoardDTO dto = freemapper.getContentFree(fnum);
		return dto;
	}
	
	@Override
	public void insertBoardFree(BoardDTO dto) {
		freemapper.insertBoardFree(dto);
	}
	
	@Override
	public void updateBoardFree(BoardDTO dto) {
		freemapper.updateBoardFree(dto);
	}
	
	@Override
	public void deleteFree(int fnum) {
		freemapper.deleteBoardFree(fnum);
		
	}
	@Override
		public void updateHitFree(int fnum) {
			freemapper.hitFree(fnum);
			
		}
	
	@Override
	public List<BoardDTO> getListFreeForHome() {
		List<BoardDTO> freeList = freemapper.getListFreeForHome();
		
		return freeList;
	}	
	
}
