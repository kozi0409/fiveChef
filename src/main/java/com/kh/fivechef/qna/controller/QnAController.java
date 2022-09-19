package com.kh.fivechef.qna.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.qna.service.QnAService;

@Controller
public class QnAController {

	@Autowired
	private QnAService qService;
	
	@RequestMapping(value="/qna/qnaWriteView.kh", method=RequestMethod.GET)
	public String showQnAWrite() {
		return "qna/writeForm";
	}
	
	@RequestMapping(value="/qna/qnaRegist.kh", method=RequestMethod.POST)
	public ModelAndView RegistQnA(
				ModelAndView mv
//				,@RequestParam("questionTitle") String questionTitle
//				,@RequestParam("questionWriter") String questionWriter
//				,@RequestParam("questionContents") String questionContents
				,@ModelAttribute QnA qna
				,HttpServletRequest request) {
		try {
			int result = qService.registQnA(qna);
			
			mv.setViewName("redirect:/qna/list.kh");
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
}
