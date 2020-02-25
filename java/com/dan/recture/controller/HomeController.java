package com.dan.recture.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dan.recture.domain.BoardModel;
import com.dan.recture.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	@RequestMapping(value="/test",method=RequestMethod.GET)
//	public String testPOST()throws Exception{
//		return "test";
//	}
	
	@RequestMapping(value = "/test")
	public String index(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		return "test";
	}

	@RequestMapping(value = "/upload.html",method=RequestMethod.POST)
	public void upload(@RequestParam("data") MultipartFile multipartFile, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		File targetFile = new File("/Users/noyeongdan/Downloads/Spring4/AI/src/main/webapp/WEB-INF/views");
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	

	
	
	
//	@Inject
//	private BoardService service;
//	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String home(BoardModel board, Model model) throws Exception{
//		model.addAttribute("list",service.list(board));
//		
//		return "board/list";
//	}
}
