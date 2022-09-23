package com.kh.fivechef.replyManage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.replyManage.service.ReplyManageService;
import com.kh.fivechef.user.domain.User;

//@Controller
public class ReplyManageController {
//
//	
//	@Autowired
//	private ReplyManageService rService;
//	
//	@RequestMapping(value="replymanage/addReply.kh", method= RequestMethod.POST)
//	public ModelAndView addCommunityReply(ModelAndView mv, @ModelAttribute CReply cReply, @RequestParam("page")int page, HttpSession session, HttpServletRequest request) {
//		User user = (User)session.getAttribute("loginUser");
//		String replyWriter = user.getUserId();
//		cReply.setReplyWriter(replyWriter);
//		int communityNo = cReply.getRefCommunityNo();
//		int result = rService.registReply(cReply);
//		if (result > 0) {
//			mv.setViewName("redirect:/community/communityDetail.kh?communityNo=" + communityNo + "&page=" + page);
//		}
//		return mv;
//	}
//	
//	@RequestMapping(value="/replymanage/modifyReply.kh", method=RequestMethod.POST)
//	public String modifyCommunityReply(@ModelAttribute CReply cReply) {
//		int result = rService.modifyReply(cReply);
//		return "redirect:/community/communityList.kh";
//	}
//	
//	@RequestMapping(value="/replymanage/removeReply.kh", method=RequestMethod.POST)
//	public String removeReply(@RequestParam("replyNo") Integer replyNo) {
//		int result = rService.removeReply(replyNo);
//		return "redirect:/community/communityList.kh";
//	}	
}
