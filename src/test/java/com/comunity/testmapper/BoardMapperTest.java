package com.comunity.testmapper;

import static org.mockito.ArgumentMatchers.booleanThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.domain.PageVO;
import com.comunity.domain.ReplyDTO;
import com.comunity.mapper.CodeBoardMapper;
import com.comunity.mapper.CodeReplyMapper;
import com.comunity.mapper.FreeBoardMapper;
import com.comunity.mapper.FreeReplyMapper;




@SpringBootTest
public class BoardMapperTest {
	
	@Autowired
	CodeBoardMapper codeBoardMapper;
	
	@Autowired
	FreeBoardMapper freeBoardMapper;
	
	@Autowired
	CodeReplyMapper codeReplyMapper;
	

	
	
	@Test
	public void testBoard() {
		System.out.println("mapper 객체 : "+codeBoardMapper);
	}
	
	
	@Test
	public void testReply() {
		System.out.println("reply 객체 : "+ codeReplyMapper);

//		String replyer="test";
//		codeReplyMapper.deleteReplyCode(r);
	}
	
	
	@Test
	public void testReply2() {
		ReplyDTO reply = ReplyDTO.builder()
				.board_number(5)
				.replyer("test")
				.replytext("test입니다.")
				.build();
		
				codeReplyMapper.insertReplyCode(reply);
				
				
	}
	
	@Test
	public void testRplList() {
		List<ReplyDTO> replylist = codeReplyMapper.selectReplyCode(7);
		for(ReplyDTO reply : replylist) {
			System.out.println(reply.toString());
		}
	}
	

	
//	@Test
//	public void list() {
////		List<BoardDTO> list = codeBoardMapper.getListCode();
//		
//		for(BoardDTO dto : list) {
//			
//			System.out.println("게시글 번호 : "+dto.getCnum());
//		}
//		System.out.println("결과 : "+list.toString());
//	}
	
	@Test
	public void listone() {
		String title = "테스트";
		List<BoardDTO> listone = freeBoardMapper.getListOneFree(title);
		
		for(BoardDTO dto : listone) {
			System.out.println("결과 : "+listone.toString());
		}
		
	}
	
	@Test  //검색 옵션 테스트
	public void pagingsearch() {
		Map<String , Object> map = new HashMap<>();
		Criteria cri = new Criteria();
		PageVO vo = new PageVO(10, cri);
		map.put("title", "수");
		map.put("pageStart", cri.getPageStart());
		map.put("count", cri.getCount());
		
//		List<BoardDTO> list = codeBoardMapper.getListTotalSearchCode(map);
//		for(BoardDTO dto : list) {
//		System.out.println(dto.toString());
		
		//검색한 리스트 개수 카운트
		int result = codeBoardMapper.getListSearchCountCode("te");
		System.out.println(result);
			
		}
	
//	@Test
//	public void listOne() {
//		List<BoardDTO> list = codeBoardMapper.getListOneCode(1);
//		
//		
//		for(BoardDTO dto : list) {
//			
//			System.out.println("게시글 번호 : "+dto.getCnum());
//		}
//		System.out.println("결과 : "+list.toString());
//	}
//	@Test
//	public void insetTest() {
//		BoardDTO dto = BoardDTO.builder().writer("test1").title("testtest").content("testpage")
//						.build();
//		int result = codeBoardMapper.insertBoardCode(dto);
//		System.out.println("결과 : "+result);
//	}
	
//	@Test
//	public void getTest() {
//		BoardDTO dto =  codeBoardMapper.getContentCode(1);
//		System.out.println("번호 : "+dto.getNum());
//		System.out.println("제목 : "+dto.getTitle());
//		System.out.println("작성자 : "+dto.getWriter());
//		System.out.println("내용 : "+dto.getContent());
//		System.out.println("등록날짜 : "+dto.getRegdate());
//		System.out.println("조회수 : "+dto.getHit());
//		
//		
//	}
	
//	@Test
//	public void update() {
//		BoardDTO dto = 
//				BoardDTO.builder().title("title").content("modify").num(2).build();
//		int result = codeBoardMapper.updateBoardCode(dto);
//		System.out.println("결과 : "+result);
//	}
	
//	@Test
//	public void delete() {
//		codeBoardMapper.deleteBoardCode(1);
//	}
}
