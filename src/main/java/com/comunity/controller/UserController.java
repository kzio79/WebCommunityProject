package com.comunity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comunity.domain.UserDTO;
import com.comunity.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	
	@GetMapping("/home")
	public String home() {
		return "/user/home";
	}
	
	// 회원가입	
		@GetMapping("/join")
		public String join_go() {
			return "/user/user_join";
		}
		
		@PostMapping("/join")
		public String join(UserDTO dto, RedirectAttributes rttr) {
				
//			int result = 0;		
//			result = service.idCheck(dto.getId());		
//			if(result == 1) {
//				// 아이디 중복
//				rttr.addFlashAttribute("msg", "중복된 아이디 입니다.");
//				
//				return "redirect:/user/join";
//			} else {		

				int result2 = 0;			
				result2 = service.join(dto);			
				if(result2 == 1) {
					return "redirect:/user/login";
				}else {
					return "redirect:/user/user_join";
				}			
			}
//		}
	@ResponseBody
	@RequestMapping("/idcheck")
	public int idCheck(UserDTO dto, @RequestParam(required = false) String id) {
		System.out.println("id : "+id);
		int result = 0;		
		result = service.idCheck(dto.getId());
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/nicknamecheck")
	public int nicknameCheck(UserDTO dto, @RequestParam(required = false) String nickname) {
		int result = 0;		
		result = service.nicknameCheck(dto.getNickname());		
		return result;
	}
	
	@GetMapping("/login")
	public String login_go() {
		return "/user/user_login";
	}

	@PostMapping("/login")
	public String login_result(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session,
			RedirectAttributes rttr
			) {		

		UserDTO dto = new UserDTO();		
		
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO user_dto = service.login(dto);		
		
		if(user_dto != null) {			
			session.setAttribute("id", user_dto.getId());
			session.setAttribute("nickname", user_dto.getNickname());
			// 성공하면 기본페이지로 이동
			return "redirect:/";			
		}else {		
			rttr.addFlashAttribute("msg", "아이디와 비밀번호를 확인해주세요");
			return "redirect:/user/login";
		}		
	}
	
// 정보 수정
	@GetMapping("/modify")
	public String modify(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		
		UserDTO udto = service.info(id);
		model.addAttribute("dto", udto);
		
		return "/user/user_modify";
	}
	
	@PostMapping("/modify_result")
	public String modify_result(Model model,
			HttpSession session,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("nickname") String nickname,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
			@RequestParam("addr1") String addr1,
			@RequestParam("address2") String address2) {
		UserDTO dto = service.info(id);
		dto.setPw(pw);
		dto.setNickname(nickname);
		dto.setEmail(email);
		dto.setAddress(address);
		dto.setAddr1(addr1);
		dto.setAddress2(address2);
		
		
		int result = 0;
		
		result = service.modify(dto);
		
		if(result == 1) {
			session.setAttribute("nickname", dto.getNickname());
			model.addAttribute("dto",dto);
			return "redirect:/";
		}else {
			return "redirect:/user/modify";
		}
	
	}
	
	// 회원 탈퇴
		@GetMapping("/delete")
		public String delete(HttpSession session) {
			String id = (String)session.getAttribute("id");
			session.setAttribute("id", id);
			
			return "/user/user_delete";
		}
		
		@PostMapping("/delete_result")	
		public String delete_result(UserDTO dto
				, HttpSession session, RedirectAttributes rttr) {
						
			int result = service.delete(dto);
			
			if(result == 0) {
				rttr.addFlashAttribute("msg", "아이디와 비밀번호를 확인해주세요");
				return "redirect:/user/delete";
			}else {
				
				session.invalidate();
				return "redirect:/";		
			}
			
			
		}	
	
// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
//	회원검색 : Id
	@GetMapping("/searchid")
	public String seachid(){
		
		return "/user/user_searchid";
		
		
	}
	
	@PostMapping("/searchid")
	public String searchid_result(@RequestParam("name") String name
									,RedirectAttributes rttr
									,UserDTO dto
									,Model model) {
		try {

			service.searchId(name);
			dto = service.selectId(name);
			
			if(service.searchId(name) == null) {
				
				rttr.addFlashAttribute("msg", "이름을 확인해 주세요");
				return "redirect:/user/searchid";		
			}else {
				model.addAttribute("dto", dto);
				return "/user/user_mypageid";
			}		
			
		} catch (NullPointerException e) {
			rttr.addFlashAttribute("msg", "이름을 확인해 주세요");
			return "redirect:/user/searchid";
		}
		
	}	
	
//	회원검색 : pw
	@GetMapping("/searchpw")
	public String seachpw(){
		
		return "/user/user_searchpw";
		
		
	}
	
	@PostMapping("/searchpw")
	public String searchid_result(@RequestParam("id") String id
									,@RequestParam("email") String email
									,RedirectAttributes rttr
									,UserDTO dto
									,Model model) {
		try {
			
			dto.setId(id);
			dto.setEmail(email);
			
			UserDTO dto2 = new UserDTO();
			service.searchPw(dto);
			dto2 = service.selectPw(dto);
									
			if(dto2.getId() == null || !dto2.getId().equals(dto.getId()) || !dto2.getEmail().equals(dto.getEmail())) {
				rttr.addFlashAttribute("msg", "아이디와 이메일을 확인해 주세요");
				return "redirect:/user/searchpw";		
			}else {
				model.addAttribute("dto2", dto2);
				return "/user/user_mypagepw";
			}		
			
		} catch (NullPointerException e) {
			rttr.addFlashAttribute("msg", "아이디와 이메일을 확인해 주세요");
			return "redirect:/user/searchpw";
		}
		
	}
}
