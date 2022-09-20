package com.kh.fivechef.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.community.service.CommunityService;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
	@RequestMapping(value="/community/communityWrite.kh", method=RequestMethod.GET)
	public String showCommunityWrite() {
		return "/community/commWriteForm";
	}
	
	@RequestMapping(value="/community/commRegist.kh", method=RequestMethod.POST)
	public ModelAndView registCommunity(ModelAndView mv, @ModelAttribute Community community, HttpServletRequest request) {
		try {
			int result = cService.registCommunity(community);
			request.setAttribute("msg","게시글 등록이 완료되었습니다.");
			request.setAttribute("url","/community/communityList.kh");
			mv.setViewName("/common/alert");
		} catch (Exception e){
			mv.addObject("msg", "게시글 등록 실패");
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/community/communityList.kh", method=RequestMethod.GET)
	public ModelAndView printCommunityList(ModelAndView mv, @RequestParam(value="page", required=false) Integer page, HttpSession session) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getTotalCount("", "");
		int communityLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/communityLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Community> cList = cService.printAllCommunity(currentPage, communityLimit);
		if(!cList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);  // listView.jsp에서 사용하기위해 작성 ([이전], [다음]을 위해 작성)
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("community/commList");
		return mv;
	}
}
