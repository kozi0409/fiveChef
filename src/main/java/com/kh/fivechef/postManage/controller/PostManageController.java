package com.kh.fivechef.postManage.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.postManage.service.PostManageService;

@Controller
public class PostManageController {
	
	@Autowired
	private PostManageService pService;
//	private RecipeService rService;

	// 전체 게시글 리스트
	@RequestMapping(value = "/postmanage/list.kh", method = RequestMethod.GET)
	public ModelAndView postManageView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = pService.getTotalPostCount("", "");
		int communityLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int) ((double) totalCount / communityLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Community> cList = pService.printAllPost(currentPage, communityLimit);
		if (!cList.isEmpty()) {
			mv.addObject("urlVal", "communityList");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("postmanage/postList");
		return mv;
	}
	
	//글 누르면 상세 조회
	@RequestMapping(value="/postmanage/detail.kh", method=RequestMethod.GET)
	public ModelAndView printPostDetail(
			ModelAndView mv
			, @RequestParam("communityNo")Integer communityNo
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			Community community = pService.printOneByPostNo(communityNo);
			session.setAttribute("communityNo", communityNo);
			mv.addObject("community", community);
			mv.addObject("page", page);
			mv.setViewName("postmanage/postDetail");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	// 검색 기능
	@RequestMapping(value="/postmanage/search.kh", method=RequestMethod.GET)
	public ModelAndView postManageSearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = pService.getPostTotalCount(searchCondition, searchValue);
			int communityLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/communityLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<Community> cList = pService.printAllByPostValue(
					searchCondition, searchValue, currentPage, communityLimit);
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
				mv.setViewName("admin/postManage");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
//	// 수정 화면
//	@RequestMapping(value="/postmanage/modifyView.kh", method=RequestMethod.GET)
//	public ModelAndView postManageModifyView(
//			ModelAndView mv
//			, @RequestParam("communityNo") Integer communityNo
//			, @RequestParam("page") int page) {
//		try {
//			Community community = pService.printOneByPostNo(communityNo);
//			mv.addObject("community", community);
//			mv.addObject("page", page);
//			mv.setViewName("community/modifyForm");
//		} catch (Exception e) {
//			mv.addObject("msg", e.toString());
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
//	
//	// 수정
//	@RequestMapping(value="/postmanage/modify.kh", method=RequestMethod.POST)
//	public ModelAndView postManageModify(
//			@ModelAttribute Community community
//			, ModelAndView mv
//			,@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
//			,@RequestParam("page") Integer page
//			,HttpServletRequest request) {
//		try {
//			String communityFilename = reloadFile.getOriginalFilename();
//			if(reloadFile != null && !communityFilename.equals("")) {
//				String root = request.getSession().getServletContext().getRealPath("resources");
//				String savedPath = root + "\\cuploadFiles";
//				File file = new File(savedPath + "\\" + community.getCommunityFileRename());
//				if(file.exists()) {
//					file.delete();
//				}
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//				String communityFileRename = sdf.format(new Date(System.currentTimeMillis())) + "." 
//				+ communityFilename.substring(communityFilename.lastIndexOf(".")+1);
//				String communityFilepath = savedPath + "\\" + communityFileRename;
//				reloadFile.transferTo(new File(communityFilepath));
//				community.setCommunityFilename(communityFilename);
//				community.setCommunityFileRename(communityFileRename);
//				community.setCommunityFilepath(communityFilepath);
//			}
//			int result = pService.modifyCommunity(community);
//			mv.setViewName("redirect:/notice/list.kh?page="+page);
//		} catch (Exception e) {
//			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
//		}
//		return mv;
//	}
	
	// 삭제
	@RequestMapping(value="/postmanage/remove.kh", method=RequestMethod.GET)
	public String postmanageRemove(
			HttpSession session
			, Model model
			, @RequestParam("page") Integer page) {
		try {
			int communityNo = (Integer)session.getAttribute("communityNo");
			int result = pService.removeOneByPostNo(communityNo);
			if(result > 0) {
				session.removeAttribute("communityNo");
			}
			return "redirect:/postmanage/list.kh?page="+page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
}
