package com.kh.fivechef.replyManage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.replyManage.service.ReplyManageService;

@Controller
public class ReplyManageController {

	@Autowired
	private ReplyManageService rService;
	
	// 댓글 목록
	@RequestMapping(value="/postreplymanage/list.kh", method=RequestMethod.GET)
	public ModelAndView printCommunityReplyList(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = rService.getTotalCommCount("", "");
		int replyLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/replyLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<CReply> cList = rService.printAllCommReply(currentPage, replyLimit);
		if(!cList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("replymanage/postReplyList");
		return mv;
	}
	
	// 댓글 검색
	@RequestMapping(value="/postreplymanage/search.kh", method=RequestMethod.GET)
	public ModelAndView communityReplySearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = rService.getTotalCommCount(searchCondition, searchValue);
			int replyLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/replyLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<CReply> cList = rService.printAllByCReplyValue(
					searchCondition, searchValue, currentPage, replyLimit);
			if(!cList.isEmpty()) {
				mv.addObject("cList", cList);
			}else {
				mv.addObject("cList", null);
			}
				mv.addObject("urlVal", "search");
				mv.addObject("searchCondition", searchCondition);
				mv.addObject("searchValue", searchValue);
				mv.addObject("maxPage", maxPage);
				mv.addObject("currentPage", currentPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.setViewName("replymanage/postReplyList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 댓글 보기(원글 본문과 같이)
	@RequestMapping(value="/postreplymanage/detail.kh", method=RequestMethod.GET)
	public ModelAndView CommunityreplyDetail(
			ModelAndView mv
			, @RequestParam("communityNo") Integer communityNo
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			Community community = rService.printOneByCReplyNo(communityNo);
			List<CReply> cList = rService.printAllCReply(communityNo);
//			session.setAttribute("communityNo", community.getCommunityNo());
			session.setAttribute("communityNo", communityNo);
			mv.addObject("cList", cList);
			mv.addObject("community", community);
			mv.addObject("page", page);
			mv.setViewName("replymanage/postReplyDetail");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	// 댓글
		@RequestMapping(value="postreplymanage/addReply.kh", method= RequestMethod.POST)
		public ModelAndView addCommunityReply(
				ModelAndView mv
				, @ModelAttribute CReply cReply
				, @RequestParam("page")int page
				, HttpSession session) {
			Admin admin = (Admin)session.getAttribute("loginAdmin");
			String replyWriter = admin.getAdminId();
			int communityNo = cReply.getRefCommunityNo();
			cReply.setReplyWriter(replyWriter);
			int result = rService.registCommunityReply(cReply);
			if (result > 0) {
				mv.setViewName("redirect:/postreplymanage/detail.kh?communityNo=" + communityNo + "&page=" + page);
			}
			return mv;
		}
		
		@RequestMapping(value="/postreplymanage/modifyReply.kh", method=RequestMethod.POST)
		public String modifyCommunityReply(@ModelAttribute CReply cReply) {
			int result = rService.modifyCommunityReply(cReply);
			return "redirect:/postreplymanage/list.kh";
		}
		
		@RequestMapping(value="/postreplymanage/removeReply.kh", method=RequestMethod.POST)
		public String removeReplyByManager(@RequestParam("replyNo") Integer replyNo) {
			int result = rService.deleteCommunityReply(replyNo);
			return "redirect:/postreplymanage/list.kh";
		}
}
