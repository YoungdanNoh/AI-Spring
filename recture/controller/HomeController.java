package com.dan.recture.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
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
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String testPOST()throws Exception{
		return "test";
	}
	
	@RequestMapping(value="/fileupload",method=RequestMethod.GET)
	public String fileuploadGET()throws Exception{
		return "fileupload";
	}
	@RequestMapping(value = "/fileupload",method = RequestMethod.POST)
	public void upload(MultipartFile uploadfile, Model model){
	    logger.info("upload() POST 호출");
	    logger.info("파일 이름: {}", uploadfile.getOriginalFilename());
	    logger.info("파일 크기: {}", uploadfile.getSize());

	    String Name = saveFile(uploadfile);
	    model.addAttribute("fileName", Name);
	}
	

	private String saveFile(MultipartFile file){
	    // 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    //String RealName = uuid + "_" + file.getOriginalFilename();
	    String RealName = file.getOriginalFilename();
	    String saveName = "uploadFile.csv";

	    logger.info("saveName: {}",saveName);

	    // 저장할 File 객체를 생성(껍데기 파일)ㄴ
	    String UPLOAD_PATH="/Users/noyeongdan/Downloads/Spring4/AI/src/main/webapp/WEB-INF/views";
	    File saveFile = new File(UPLOAD_PATH, saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return RealName;
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
