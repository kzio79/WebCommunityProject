package com.comunity.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.domain.PageVO;
import com.comunity.domain.ReplyDTO;
import com.comunity.service.FreeService;
import com.comunity.service.ReplyService;
import com.comunity.service.UserService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	private FreeService freeService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	//리스트 출력
	@RequestMapping("/freelist")
	public String list(@RequestParam(name="pageNum", defaultValue = "1") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		List<BoardDTO> list = freeService.getListWithPagingFree(cri); 
		model.addAttribute("freelist", list);
		
		PageVO vo = new PageVO(freeService.getListTotalFree(), cri);
		model.addAttribute("paging", vo);
		
		return "freeboard/freelist";
	}
	
	
	//검색리스트 출력
	@RequestMapping("/freelistsearch")
	public String listSearchGet(@RequestParam("freesearch") String title,
							 @RequestParam("pageNum") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		Map<String , Object> searchmap = new HashMap<>();
		searchmap.put("title", title);
		searchmap.put("pageStart", cri.getPageStart());
		searchmap.put("count", cri.getCount());
		List<BoardDTO> listsearch = freeService.getListTotalSearchFree(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("freesearch", title); // 검색 title 전달
		model.addAttribute("freelistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(freeService.getListSearchCountFree(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		return "freeboard/freelistsearch";
	}
	
	

	@PostMapping("/freelistsearch")
	public String listSearchPost(@RequestParam("freesearch") String title
						 ,@RequestParam(name="pageNum", defaultValue = "1") String pageNum
						 ,Model model) {
		
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		Map<String , Object> searchmap = new HashMap<>();
		searchmap.put("title", title);
		searchmap.put("pageStart", cri.getPageStart());
		searchmap.put("count", cri.getCount());
		List<BoardDTO> listsearch = freeService.getListTotalSearchFree(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("freesearch", title); // 검색 title 전달
		model.addAttribute("freelistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(freeService.getListSearchCountFree(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		
		return "freeboard/freelistsearch";
	}
	
		//글작성
		@GetMapping("/freeregister")
		public String register(@RequestParam("pageNum") String pageNum, Model model) {
			System.out.println("pageNum: "+pageNum);
			model.addAttribute("pageNum", pageNum);
			return "freeboard/freeregister";
		}
		
		@PostMapping("/freeregister")
		public String register(@RequestParam("pageNum") String pageNum, BoardDTO dto) {
			freeService.insertBoardFree(dto);
			return "redirect:/freeboard/freelist?pageNum="+pageNum;
		}
	
		
		//조회
		//list에서 넘어가는 content	
		@GetMapping("/freecontent")
		public String content(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("fnum") int fnum
				, @RequestParam("pageNum") int pageNum	
				, HttpSession session, Model model) {
			
			BoardDTO dto = freeService.getContentFree(fnum);
			Cookie[] freeCookies = request.getCookies();
			boolean freebool = true;
			for(Cookie freec : freeCookies) {
				if(freec.getName().equals("hitfNum"+ fnum)) {
					freebool = false;
					break;
				}
			}
			
			if(freebool) {			
				freeService.updateHitFree(fnum);
			}
			int board_number = fnum;
			//댓글
			
			
			String nickname = (String)session.getAttribute("nickname");
			Date create_date = userService.ReplyCheck(nickname);
			
			
			List<ReplyDTO> replylist = replyService.selectReplyFree(board_number);
			model.addAttribute("user_create", create_date);
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);		
			model.addAttribute("pageNum", pageNum);
			Cookie freeCoo = new Cookie("hitfNum"+fnum, Integer.toString(fnum));
			freeCoo.setMaxAge(3600);
			response.addCookie(freeCoo);
			
			return "freeboard/freecontent";
		}
		
		
		@PostMapping("/freecontent")
		public String content(@RequestParam("freesearch") String title, Model model) {
			return "freeboard/freecontent";
		}
		
		//댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		@PostMapping("/freereplyinsert")
		public String replyinsert(@RequestParam(required = false) int fnum,
								  @RequestParam(required = false) int pageNum,
								  @RequestParam("commentText") String commentText,
								  HttpSession session,
								  Model model){
			
			String nickname = (String)session.getAttribute("nickname");
			BoardDTO dto = freeService.getContentFree(fnum);
			ReplyDTO replyer = ReplyDTO.builder()
							.board_number(fnum)
							.replyer(nickname)
							.replytext(commentText).build();
			
			replyService.insertReplyFree(replyer);
			int board_number = fnum;
			List<ReplyDTO> replylist = replyService.selectReplyFree(board_number);
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);
			model.addAttribute("pageNum", pageNum);
			return "redirect:/freeboard/freecontent?pageNum="+pageNum+"&fnum="+fnum;
		}

		
		

		
		@PostMapping("/freereplydelete")
		public String replyupdatereturn(@RequestParam("fnum") int fnum,
				  					  	@RequestParam("pageNum") int pageNum,
				  					  	@RequestParam("deletereply") int reply_number,
				  					  	HttpSession session, Model model
				  						) {					
			//댓글 생성날짜와 유저 생성날짜를 비교해서 user생성날짜가
			//더 크면 결과값 없음
			try {
				String nickname = (String)session.getAttribute("nickname");
				Date create_date = userService.ReplyCheck(nickname);
				
				
				ReplyDTO reply = ReplyDTO.builder()
						.create_date(create_date)
        				.reply_number(reply_number)
        				.board_number(fnum)
        				.build();
				
				ReplyDTO dto = replyService.ReplyAndUserCheckFree(reply);
				if(!dto.equals(null)) {
			        replyService.deleteReplyFree(reply);				
			        return "redirect:/freeboard/freecontent?pageNum="+pageNum+"&fnum="+fnum;
				}
				System.out.println(dto.toString());
			} catch (NullPointerException ne) {
				System.out.println(ne.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/freeboard/freecontent?pageNum="+pageNum+"&fnum="+fnum;
			
		}
		
		//댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		
		//listsearch에서 넘어가는 content	
		@GetMapping("/freecontentsearch")
		public String contentsearch(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("fnum") int fnum
				, @RequestParam("pageNum") int pageNum
				, @RequestParam("freesearch") String title
				, HttpSession session, Model model) {
//			System.out.println("제목은?"+title);
			BoardDTO dto = freeService.getContentFree(fnum);
			Cookie[] freeCookies = request.getCookies();
			boolean freebool = true;
			for(Cookie freec : freeCookies) {
				if(freec.getName().equals("hitfNum"+ fnum)) {
					freebool = false;
					break;
				}
			}
			
			if(freebool) {			
				freeService.updateHitFree(fnum);
			}
			
			String nickname = (String)session.getAttribute("nickname");
			Date create_date = userService.ReplyCheck(nickname);
			
			
			int board_number = fnum;
			List<ReplyDTO> replylist = replyService.selectReplyFree(board_number);
			model.addAttribute("user_create", create_date); //user의 생성날짜를 가져와서 모델로 전달
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);		
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("freesearch", title);
			Cookie freeCoo = new Cookie("hitcNum"+fnum, Integer.toString(fnum));
			freeCoo.setMaxAge(3600);
			response.addCookie(freeCoo);
			
			return "freeboard/freecontentsearch";
		}
		
		
		@PostMapping("/freecontentsearch")
		public String contentsearch(@RequestParam("freesearch") String title, Model model) {
			return "freeboard/freecontentsearch";
		}
		
		
		//수정
		@GetMapping("/freemodify")
		public String modify(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("fnum") int fnum
				, @RequestParam("pageNum") String pageNum ,Model model) {
			
			BoardDTO dto = freeService.getContentFree(fnum);
			model.addAttribute("dto", dto);	
			model.addAttribute("dto", dto);
			model.addAttribute("pageNum", pageNum);
			
			return "freeboard/freemodify";
		}
		
		
		//수정
		@PostMapping("/freeupdate")
		public String updateFree(@RequestParam("pageNum") String pageNum,
								 @RequestParam("fnum") int fnum,
				BoardDTO dto, Model model) {
			freeService.updateBoardFree(dto);
			try {
				model.addAttribute("dto", dto);
				model.addAttribute("pageNum", pageNum);
				return "redirect:/freeboard/freecontent?pageNum="+pageNum+"&fnum="+fnum;
			} catch (Exception e) {
				return "redirect:/freeboard/freelist";
			}
		}
		
		//삭제
		@RequestMapping("/freedelete")
		public String deleteCode(@RequestParam(required = false) String pageNum,int fnum) {
			String board_number = Integer.toString(fnum);
			replyService.deleteReplyAllFree(board_number);
			freeService.deleteFree(fnum);		
			return "redirect:/freeboard/freelist?pageNum="+pageNum;
		}
		
}
