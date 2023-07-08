package com.comunity.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comunity.domain.BoardDTO;
import com.comunity.domain.Criteria;
import com.comunity.domain.PageVO;
import com.comunity.service.CodeService;
import com.comunity.service.FreeService;
import com.comunity.service.QnAService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private FreeService freeService;
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private QnAService qnaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(name="pageNum", defaultValue = "1") String pageNum, Model model) {
		
		
		int pageNum2 = Integer.parseInt(pageNum);
		

		model.addAttribute("paging", pageNum2);
		model.addAttribute("freeList", freeService.getListFreeForHome());
		model.addAttribute("codeList", codeService.getListCodeForHome());
		model.addAttribute("qnaList", qnaService.getListQnaForHome());
		
		
		return "index";
	}
	
}
