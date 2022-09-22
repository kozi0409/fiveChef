package com.kh.fivechef.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.community.service.CommunityService;
import com.kh.fivechef.user.domain.User;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
	@RequestMapping(value="/community/communityWrite.kh", method=RequestMethod.GET)
	public String showCommunityWrite() {
		return "community/commWriteForm";
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
	public ModelAndView printCommunityList(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
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
			mv.addObject("urlVal", "communityList");
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("community/commList");
		return mv;
	}
	
	@RequestMapping(value="/community/communityDetail.kh", method=RequestMethod.GET)
	public ModelAndView printCommunityDetail(ModelAndView mv, @RequestParam("communityNo")Integer communityNo, @RequestParam("page") Integer page, HttpSession session) {
		try {
			Community community = cService.printOneByNo(communityNo);
			List<CReply> rList = cService.printAllReply(communityNo);
			session.setAttribute("communityNo", community.getCommunityNo());
			mv.addObject("rList", rList);
			mv.addObject("community", community);
			mv.addObject("page", page);
			mv.setViewName("community/commDetail");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/community/communityRemove.kh", method=RequestMethod.GET)
	public String removeCommunity(HttpSession session, HttpServletRequest request, Model model, @RequestParam("page") Integer page) {
		try {
			int communityNo = (Integer)session.getAttribute("communityNo");
			int result = cService.removeCommunity(communityNo);
			if(result > 0) {
				session.removeAttribute("communityNo");
				request.setAttribute("msg", "게시글 삭제가 완료되었습니다.");
				request.setAttribute("url", "/community/communityList.kh?page"+page);
			}
			return "common/alert";
		} catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/community/communityModifyView.kh", method=RequestMethod.GET)
	public ModelAndView showmodifyCommunity(ModelAndView mv, @RequestParam("communityNo")Integer communityNo, @RequestParam("page") int page) {
		try {
			Community community = cService.printOneByNo(communityNo);
			mv.addObject("community", community);
			mv.setViewName("community/modifyForm");
			mv.addObject("page", page);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/community/communityModify.kh", method=RequestMethod.POST)
	public ModelAndView modifyCommunity(ModelAndView mv, @ModelAttribute Community community, @RequestParam("page")Integer page, HttpServletRequest request) {
		try {
			int result = cService.modifyCommunity(community);
			if(result > 0) {
				request.setAttribute("msg", "게시글 수정이 완료되었습니다.");
				request.setAttribute("url", "/community/communityList.kh");
				mv.setViewName("common/alert");	
			} else {
				mv.addObject("msg", "수정 오류");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/community/communitySearch.kh" , method=RequestMethod.GET)
	public ModelAndView communitySearchList(ModelAndView mv, 
			@RequestParam("searchCondition") String searchCondition, 
			@RequestParam("searchValue") String searchValue, 
			@RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = cService.getTotalCount(searchCondition, searchValue);
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
			
			List<Community> cList = cService.printAllByValue(searchCondition, searchValue, currentPage, communityLimit);
			if(!cList.isEmpty()) {
				mv.addObject("cList", cList);
			} else {
				mv.addObject("cList", null);
			}
			mv.addObject("urlVal", "search");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("community/commList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="community/addReply.kh", method= RequestMethod.POST)
	public ModelAndView addCommunityReply(ModelAndView mv, @ModelAttribute CReply cReply, @RequestParam("page")int page, HttpSession session, HttpServletRequest request) {
		User user = (User)session.getAttribute("loginUser");
		String replyWriter = user.getUserId();
		cReply.setReplyWriter(replyWriter);
		int communityNo = cReply.getRefCommunityNo();
		int result = cService.registReply(cReply);
		if (result > 0) {
			mv.setViewName("redirect:/community/communityDetail.kh?communityNo=" + communityNo + "&page=" + page);
		}
		return mv;
	}
	
	@RequestMapping(value="/community/modifyReply.kh", method=RequestMethod.POST)
	public String modifyCommunityReply(@ModelAttribute CReply cReply) {
		int result = cService.modifyReply(cReply);
		return "/community/communityList.kh";
	}
	
	@RequestMapping(value="/community/removeReply.kh", method=RequestMethod.POST)
	public String removeReply(@RequestParam("replyNo") Integer replyNo) {
		int result = cService.removeReply(replyNo);
		return "/community/communityList.kh";
	}
}
