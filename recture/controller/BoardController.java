package com.dan.recture.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dan.recture.domain.BoardModel;
import com.dan.recture.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	//submit이 눌려서 POST가 작동됨.
	public String registerPOST(BoardModel board)throws Exception{
		service.regist(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardModel board)throws Exception{
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listGET(BoardModel board, Model model)throws Exception{
		model.addAttribute("list", service.list(board));
	}
	
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void readGET(BoardModel board , Model model)throws Exception{
		model.addAttribute("info",service.selectlist(board));	
	}
	
	@RequestMapping(value="/read",method=RequestMethod.POST)
	public void readPOST(BoardModel board)throws Exception{
	}
	
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(BoardModel board, Model model)throws Exception{
		model.addAttribute("info",service.selectlist(board));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardModel board, Model model)throws Exception{
		service.regist(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/delete")
	public String deletePOST(BoardModel board, Model model)throws Exception{
		service.delete(board);
		return "redirect:/board/list";
	}
	
	
	
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String testPOST()throws Exception{
		return "redirect:/test";
	}
	
	
//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
//	public String register(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "board/register";
//	}
//	
//	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
//	public String list(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "board/list";
//	}
}
