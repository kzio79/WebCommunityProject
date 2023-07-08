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
import com.comunity.service.QnAService;
import com.comunity.service.ReplyService;
import com.comunity.service.UserService;

@Controller
@RequestMapping("/qnaboard")
public class QnaBoardController {

	@Autowired
	private QnAService qnaService;
	
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/qnalist")
	public String list(@RequestParam(name="pageNum", defaultValue = "1") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		List<BoardDTO> list = qnaService.getListWithPagingQna(cri); 
		model.addAttribute("qnalist", list);
		
		PageVO vo = new PageVO(qnaService.getListTotalQna(), cri);
		model.addAttribute("paging", vo);
		
		return "qnaboard/qnalist";
	}
	
	
	@RequestMapping("/qnalistsearch")
	public String listSearchGet(@RequestParam("qnasearch") String title,
							 @RequestParam("pageNum") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		Map<String , Object> searchmap = new HashMap<>();
		searchmap.put("title", title);
		searchmap.put("pageStart", cri.getPageStart());
		searchmap.put("count", cri.getCount());
		List<BoardDTO> listsearch = qnaService.getListTotalSearchQna(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("qnasearch", title); // 검색 title 전달
		model.addAttribute("qnalistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(qnaService.getListSearchCountQna(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		return "qnaboard/qnalistsearch";
	}
	
	
	
	@PostMapping("/qnalistsearch")
	public String listSearchPost(@RequestParam("qnasearch") String title
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
		List<BoardDTO> listsearch = qnaService.getListTotalSearchQna(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("qnasearch", title); // 검색 title 전달
		model.addAttribute("qnalistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(qnaService.getListSearchCountQna(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		
		return "qnaboard/qnalistsearch";
	}
	
	
	
	@GetMapping("/qnaregister")
	public String register(@RequestParam("pageNum") String pageNum, Model model) {
		System.out.println("pageNum: "+pageNum);
		model.addAttribute("pageNum", pageNum);
		return "qnaboard/qnaregister";
	}
	
	@PostMapping("/qnaregister")
	public String register(@RequestParam("pageNum") String pageNum, BoardDTO dto) {
		qnaService.insertBoardQna(dto);
		return "redirect:/qnaboard/qnalist?pageNum="+pageNum;
	}
	
	
	
	//list에서 넘어가는 content	
		@GetMapping("/qnacontent")
		public String content(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("qnum") int qnum
				, @RequestParam("pageNum") int pageNum	
				, HttpSession session, Model model) {
			BoardDTO dto = qnaService.getContentQna(qnum);
			model.addAttribute("dto", dto);
			Cookie[] qnaCookies = request.getCookies();
			boolean qnabool = true;
			for(Cookie qnac : qnaCookies) {
				if(qnac.getName().equals("hitqNum"+ qnum)) {
					qnabool = false;
					break;
				}
			}
			
			if(qnabool) {			
				qnaService.updateHitQna(qnum);
			}
			
			String nickname = (String)session.getAttribute("nickname");
			Date create_date = userService.ReplyCheck(nickname);
			
			int board_number = qnum;
			List<ReplyDTO> replylist = replyService.selectReplyQna(board_number);
			model.addAttribute("user_create", create_date);
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);		
			model.addAttribute("pageNum", pageNum);
			Cookie codeCoo = new Cookie("hitqNum"+qnum, Integer.toString(qnum));
			codeCoo.setMaxAge(3600);
			response.addCookie(codeCoo);
			
			return "qnaboard/qnacontent";
		}
		
		
		@PostMapping("/qnacontent")
		public String content(@RequestParam("qnasearch") String title, Model model) {
			return "qnaboard/qnacontent";
		}
		
		
		//댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//댓글 작성
		@PostMapping("/qnareplyinsert")
		public String replyinsert(@RequestParam(required = false) int qnum,
								  @RequestParam(required = false) int pageNum,
								  @RequestParam("commentText") String commentText,
								  HttpSession session,
								  Model model){
			
			String nickname = (String)session.getAttribute("nickname");
			BoardDTO dto = qnaService.getContentQna(qnum);
			ReplyDTO replyer = ReplyDTO.builder()
							.board_number(qnum)
							.replyer(nickname)
							.replytext(commentText).build();
			
			replyService.insertReplyQna(replyer);
			int board_number = qnum;
			List<ReplyDTO> replylist = replyService.selectReplyQna(board_number);
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);
			model.addAttribute("pageNum", pageNum);
			return "redirect:/qnaboard/qnacontent?pageNum="+pageNum+"&qnum="+qnum;
		}

		
		

		//댓글 삭제
		@PostMapping("/qnareplydelete")
		public String replyupdatereturn(@RequestParam("qnum") int qnum,
				  					  	@RequestParam("pageNum") int pageNum,
				  					  	@RequestParam("deletereply") int reply_number,
				  					  	HttpSession session, Model model
				  						) {	
			try {
				String nickname = (String)session.getAttribute("nickname");
				Date create_date = userService.ReplyCheck(nickname);
				
				
				ReplyDTO reply = ReplyDTO.builder()
						.create_date(create_date)
	    				.reply_number(reply_number)
	    				.board_number(qnum)
	    				.build();
				
				ReplyDTO dto = replyService.ReplyAndUserCheckQna(reply);
				if(!dto.equals(null)) {
			        replyService.deleteReplyQna(reply);		
			        return "redirect:/qnaboard/qnacontent?pageNum="+pageNum+"&qnum="+qnum;
				}
				System.out.println(dto.toString());
			} catch (NullPointerException ne) {
				System.out.println(ne.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/qnaboard/qnacontent?pageNum="+pageNum+"&qnum="+qnum;
		}
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글
		
		
		
		//listsearch에서 넘어가는 content	
		@GetMapping("/qnacontentsearch")
		public String contentsearch(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("qnum") int qnum
				, @RequestParam("pageNum") int pageNum
				, @RequestParam("qnasearch") String title
				, HttpSession session, Model model) {
			BoardDTO dto = qnaService.getContentQna(qnum);
			model.addAttribute("dto", dto);
			Cookie[] qnaCookies = request.getCookies();
			boolean qnabool = true;
			for(Cookie qnac : qnaCookies) {
				if(qnac.getName().equals("hitqNum"+ qnum)) {
					qnabool = false;
					break;
				}
			}
			
			if(qnabool) {			
				qnaService.updateHitQna(qnum);
			}
			
			
			String nickname = (String)session.getAttribute("nickname");
			Date create_date = userService.ReplyCheck(nickname);
			
			int board_number = qnum;
			List<ReplyDTO> replylist = replyService.selectReplyQna(board_number);
			model.addAttribute("user_create", create_date); //user의 생성날짜를 가져와서 모델로 전달
			model.addAttribute("reply", replylist);
			model.addAttribute("dto", dto);		
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("qnasearch", title);
			Cookie qnaCoo = new Cookie("hitqNum"+qnum, Integer.toString(qnum));
			qnaCoo.setMaxAge(3600);
			response.addCookie(qnaCoo);
			
			return "qnaboard/qnacontentsearch";
		}
		
		
		@PostMapping("/qnacontentsearch")
		public String contentsearch(@RequestParam("qnasearch") String title, Model model) {
			return "qnaboard/qnacontentsearch";
		}
		
		
		@GetMapping("/qnamodify")
		public String modify(HttpServletRequest request
				, HttpServletResponse response
				, @RequestParam("qnum") int qnum
				, @RequestParam("pageNum") String pageNum ,Model model) {
			
			BoardDTO dto = qnaService.getContentQna(qnum);
			model.addAttribute("dto", dto);	
			model.addAttribute("dto", dto);
			model.addAttribute("pageNum", pageNum);
			
			return "qnaboard/qnamodify";
		}
		
		
		
		//수정
		@PostMapping("/qnaupdate")
		public String updateCode(@RequestParam("pageNum") String pageNum,
								 @RequestParam("qnum") int qnum,
				BoardDTO dto, Model model) {
			qnaService.updateBoardQna(dto);
			try {
				model.addAttribute("dto", dto);
				model.addAttribute("pageNum", pageNum);
				return "redirect:/qnaboard/qnacontent?pageNum="+pageNum+"&qnum="+qnum;
			} catch (Exception e) {
				return "redirect:/qnaboard/qnalist";
			}
		}
		
		//삭제
		@RequestMapping("/qnadelete")
		public String deleteCode(@RequestParam(required = false) String pageNum,int qnum) {
			String board_number = Integer.toString(qnum);
			replyService.deleteReplyAllQna(board_number);
			qnaService.deleteQna(qnum);		
			return "redirect:/qnaboard/qnalist?pageNum="+pageNum;
		}
	
}
