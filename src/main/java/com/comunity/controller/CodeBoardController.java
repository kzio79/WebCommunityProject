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
import com.comunity.service.CodeService;
import com.comunity.service.ReplyService;
import com.comunity.service.UserService;




@Controller
@RequestMapping("/codeboard")
public class CodeBoardController {

	@Autowired
	private CodeService codeService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/codelist")
	public String list(@RequestParam(name="pageNum", defaultValue = "1") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		List<BoardDTO> list = codeService.getListWithPagingCode(cri); 
		model.addAttribute("codelist", list);
		
		PageVO vo = new PageVO(codeService.getListTotalCode(), cri);
		model.addAttribute("paging", vo);
		
		return "codeboard/codelist";
	}
	
	
	
	@RequestMapping("/codelistsearch")
	public String listSearchGet(@RequestParam("codesearch") String title,
							 @RequestParam("pageNum") String pageNum, Model model) {
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		Map<String , Object> searchmap = new HashMap<>();
		searchmap.put("title", title);	
		searchmap.put("pageStart", cri.getPageStart());
		searchmap.put("count", cri.getCount());
		List<BoardDTO> listsearch = codeService.getListTotalSearchCode(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("codesearch", title); // 검색 title 전달
		model.addAttribute("codelistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(codeService.getListSearchCountCode(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		return "codeboard/codelistsearch";
	}
	
	
	
	@PostMapping("/codelistsearch")
	public String listSearchPost(@RequestParam("codesearch") String title
						 ,@RequestParam(name="pageNum", defaultValue = "1") String pageNum
						 ,Model model) {
		
		Criteria cri = new Criteria();
		if(pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		Map<String , Object> searchmap = new HashMap<>();
		searchmap.put("title", title); //검색 제목
		searchmap.put("pageStart", cri.getPageStart()); //페이지
		searchmap.put("count", cri.getCount());    //
		List<BoardDTO> listsearch = codeService.getListTotalSearchCode(searchmap); //해당 글자 포함시 가져와서 리스트에 저장
		
		
		model.addAttribute("codesearch", title); // 검색 title 전달
		model.addAttribute("codelistsearch", listsearch); //해당 글자 포함리스트를 가져와서 모델로 전달
		PageVO vo = new PageVO(codeService.getListSearchCountCode(title), cri); //검색한 타이틀 개수, Criteria
		model.addAttribute("paging", vo);
		
		return "codeboard/codelistsearch";
	}
	
	@GetMapping("/coderegister")
	public String register(@RequestParam("pageNum") String pageNum, Model model) {
		System.out.println("pageNum: "+pageNum);
		model.addAttribute("pageNum", pageNum);
		return "codeboard/coderegister";
	}
	
	@PostMapping("/coderegister")
	public String register(@RequestParam("pageNum") String pageNum, BoardDTO dto) {
		codeService.insertBoardCode(dto);
		return "redirect:/codeboard/codelist?pageNum="+pageNum;
	}
	
	
	
//list에서 넘어가는 content	
	@GetMapping("/codecontent")
	public String content(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("cnum") int cnum
			, @RequestParam("pageNum") int pageNum	
			, HttpSession session, Model model) {
	
		BoardDTO dto = codeService.getContentCode(cnum);
		Cookie[] codeCookies = request.getCookies();   //쿠키 생성후 히트값 처리
		boolean codebool = true;
		for(Cookie codec : codeCookies) {
			if(codec.getName().equals("hitcNum"+ cnum)) {
				codebool = false;
				break;
			}
		}
		
		if(codebool) {			
			codeService.updateHitCode(cnum);
		}
		//히트----------------
		//댓글
		String nickname = (String)session.getAttribute("nickname");
		Date create_date = userService.ReplyCheck(nickname);
		
		int board_number = cnum;
		List<ReplyDTO> replylist = replyService.selectReplyCode(board_number);
		model.addAttribute("user_create", create_date);
		model.addAttribute("reply", replylist);
		model.addAttribute("dto", dto);		
		model.addAttribute("pageNum", pageNum);
		Cookie codeCoo = new Cookie("hitcNum"+cnum, Integer.toString(cnum));
		codeCoo.setMaxAge(3600);
		response.addCookie(codeCoo);
		
		return "codeboard/codecontent";
	}
	
	
	@PostMapping("/codecontent")
	public String content(@RequestParam("codesearch") String title, Model model) {
		return "codeboard/codecontent";
	}
	
	
	
	
	
//listsearch에서 넘어가는 content	
	@GetMapping("/codecontentsearch")
	public String contentsearch(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("cnum") int cnum
			, @RequestParam("pageNum") int pageNum
			, @RequestParam("codesearch") String title
			, HttpSession session, Model model) {
		
		BoardDTO dto = codeService.getContentCode(cnum);
		Cookie[] codeCookies = request.getCookies();
		boolean codebool = true;
		for(Cookie codec : codeCookies) {
			if(codec.getName().equals("hitcNum"+ cnum)) {
				codebool = false;
				break;
			}
		}
		
		if(codebool) {			
			codeService.updateHitCode(cnum);
		}
		
		String nickname = (String)session.getAttribute("nickname");
		Date create_date = userService.ReplyCheck(nickname);
		
		
		int board_number = cnum;
		List<ReplyDTO> replylist = replyService.selectReplyCode(board_number);
		
		model.addAttribute("user_create", create_date); //user의 생성날짜를 가져와서 모델로 전달
		model.addAttribute("reply", replylist);
		model.addAttribute("dto", dto);		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("codesearch", title);
		Cookie codeCoo = new Cookie("hitcNum"+cnum, Integer.toString(cnum));
		codeCoo.setMaxAge(3600);
		response.addCookie(codeCoo);
		
		return "codeboard/codecontentsearch";
	}
	
	
	@PostMapping("/codecontentsearch")
	public String contentsearch(@RequestParam("codesearch") String title, Model model) {
		return "codeboard/codecontentsearch";
	}
	
	
	
    
	@PostMapping("/codereplyinsert")
	public String replyinsert(@RequestParam(required = false) int cnum,
							  @RequestParam(required = false) int pageNum,
							  @RequestParam("commentText") String commentText,
							  HttpSession session,
							  Model model){
		
		String nickname = (String)session.getAttribute("nickname");
		BoardDTO dto = codeService.getContentCode(cnum);
		ReplyDTO replyer = ReplyDTO.builder()
						.board_number(cnum)
						.replyer(nickname)
						.replytext(commentText).build();
		
		
		replyService.insertReplyCode(replyer);	
		int board_number = cnum;
		List<ReplyDTO> replylist = replyService.selectReplyCode(board_number);
		model.addAttribute("reply", replylist);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		
			return "redirect:/codeboard/codecontent?pageNum="+pageNum+"&cnum="+cnum;
		
		
		}

	
	

	
	@PostMapping("/codereplydelete")
	public String replyupdatereturn(@RequestParam("cnum") int cnum,
			  					  	@RequestParam("pageNum") int pageNum,
			  					  	@RequestParam("deletereply") int reply_number,
			  					  	@RequestParam(required = false) String replyer,
			  					  	HttpSession session, Model model
			  						) {	
		try {
			String nickname = (String)session.getAttribute("nickname");
			Date create_date = userService.ReplyCheck(nickname);
			
			
			ReplyDTO reply = ReplyDTO.builder()
					.create_date(create_date)
    				.reply_number(reply_number)
    				.board_number(cnum)
    				.build();
			
			ReplyDTO dto = replyService.ReplyAndUserCheckCode(reply);
			if(!dto.equals(null)) {
		        replyService.deleteReplyCode(reply);				
		        return "redirect:/codeboard/codecontent?pageNum="+pageNum+"&cnum="+cnum;
			}
			System.out.println(dto.toString());
		} catch (NullPointerException ne) {
			System.out.println(ne.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return "redirect:/codeboard/codecontent?pageNum="+pageNum+"&cnum="+cnum;
		
	}
	
	
	
	
	@GetMapping("/codemodify")
	public String modify(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("cnum") int cnum
			, @RequestParam("pageNum") String pageNum ,Model model) {
		
		BoardDTO dto = codeService.getContentCode(cnum);
		model.addAttribute("dto", dto);	
		model.addAttribute("pageNum", pageNum);
		
		return "codeboard/codemodify";
	}
	
	//수정
	@PostMapping("/codeupdate")
	public String updateCode(@RequestParam("pageNum") String pageNum,
							 @RequestParam("cnum") int cnum,
			BoardDTO dto, Model model) {
		codeService.updateBoardCode(dto);
		try {
			model.addAttribute("dto", dto);
			model.addAttribute("pageNum", pageNum);
			return "redirect:/codeboard/codecontent?pageNum="+pageNum+"&cnum="+cnum;
		} catch (Exception e) {
			return "redirect:/codeboard/codelist";
		}
	}
	
	//삭제
	@RequestMapping("/codedelete")
	public String deleteCode(@RequestParam(required = false) String pageNum,int cnum) {
		String board_number = Integer.toString(cnum);
		replyService.deleteReplyAllCode(board_number);
		codeService.deleteCode(cnum);		
		return "redirect:/codeboard/codelist?pageNum="+pageNum;
	}
}
