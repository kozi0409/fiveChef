package com.kh.fivechef.userNotice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.userNotice.service.UserNoticeService;

@Controller
public class UserNoticeController {

	@Autowired
	private UserNoticeService unService;
	
	@RequestMapping(value="/home.kh", method=RequestMethod.GET)
	public ModelAndView MainNoticeView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = unService.getTotalCount("","");
		int noticeLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/noticeLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Notice> nList = unService.printAllNotice(currentPage, noticeLimit);
		if(!nList.isEmpty()) {
			mv.addObject("urlVal", "home");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("nList", nList);
		}
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/userNotice/detail.kh", method=RequestMethod.GET)
	public ModelAndView noticeDetailView(
			ModelAndView mv
			, @RequestParam("noticeNo") Integer noticeNo
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			Notice notice = unService.printOneByNo(noticeNo);
			session.setAttribute("noticeNo", notice.getNoticeNo());
			mv.addObject("notice", notice);
			mv.addObject("page", page);
			mv.setViewName("userNotice/detailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
		}
}
