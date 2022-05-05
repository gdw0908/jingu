package com.jingu.boot.findpw.word.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class WordController {
	Logger log = LoggerFactory.getLogger(WordController.class);
	
	@RequestMapping(value = "/jingu/findPw")
	public ModelAndView adminList(@RequestParam HashMap<String,Object> reqMap,  HttpServletRequest req, HttpSession session) {
		log.debug("jingu findPw page");
		log.debug("세션 ID : "+session.getId());
		ModelAndView mav = new ModelAndView();
		
		//List<HashMap<String, Object>> resultList =adminService.selectAdminList(reqMap);
		/*
		 * PageUtil pagination = new PageUtil(resultList.size(),
		 * Integer.parseInt(StringUtil.nvl((String)reqMap.get("page"),"1")) );
		 * 
		 * reqMap.put("page",
		 * (Integer.parseInt(StringUtil.nvl((String)reqMap.get("page"),"1"))-1)*10);
		 * reqMap.put("row", pagination.getPageSize()); resultList
		 * =adminService.selectAdminList(reqMap);
		 * 
		 * mav.addObject("list", resultList); mav.addObject("param", reqMap);
		 * mav.addObject("pagination", pagination);
		 */		
		mav.setViewName("/jingu/findPw");
		return mav;
	}
}
