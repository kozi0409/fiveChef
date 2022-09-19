package com.kh.fivechef.notice.controller;

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

import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	/**
	 * 공지글 등록 화면
	 * @return
	 */
	@RequestMapping(value="/notice/writeView.kh", method=RequestMethod.GET)
	public String noticeWriteView() {
		return "notice/writeForm";
	}
	
	/**
	 * 공지글 등록 (첨부파일)
	 * @param mv
	 * @param notice
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/notice/register.kh", method=RequestMethod.POST)
	public ModelAndView registNotice(
			ModelAndView mv
			, @ModelAttribute Notice notice
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			String noticeFilename = uploadFile.getOriginalFilename();
			if(!noticeFilename.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\nuploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String noticeFileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+noticeFilename.substring(noticeFilename.lastIndexOf(".")+1);
				File file = new File(savePath);
				if(!file.exists()) { 
					file.mkdir();
				} 
				//위에 파일하나라서.. 멀티파일해주기 for문돌려서
				uploadFile.transferTo(new File(savePath+"\\"+noticeFileRename));
				String noticeFilepath = savePath+"\\"+noticeFileRename;
				notice.setNoticeFilename(noticeFilename);
				notice.setNoticeFileRename(noticeFileRename);
				notice.setNoticeFilepath(noticeFilepath); 
			}
			int result = nService.registerNotice(notice);
			mv.setViewName("redirect:/notice/list.kh");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 공지글 목록 조회
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/notice/list.kh", method=RequestMethod.GET)
	public ModelAndView noticeListView(
			ModelAndView mv
			,@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = nService.getTotalCount("","");
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
		List<Notice> nList = nService.printAllNotice(currentPage, noticeLimit);
		if(!nList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("nList", nList);
		}
		mv.setViewName("notice/listView");
		return mv;
	}
	
	//게시글 상세조회

	
	/**
	 * 공지글 조건별 검색
	 * @param mv
	 * @param searchCondition
	 * @param searchValue
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/notice/search.kh", method=RequestMethod.GET)
	public ModelAndView noticeSearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = nService.getTotalCount(searchCondition, searchValue);
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
			List<Notice> nList = nService.printAllByValue(
					searchCondition, searchValue, currentPage, noticeLimit);
			if(!nList.isEmpty()) {
				mv.addObject("nList", nList);
			}else {
				mv.addObject("nList", null);
			}
				mv.addObject("urlVal", "search");
				mv.addObject("searchCondition", searchCondition);
				mv.addObject("searchValue", searchValue);
				mv.addObject("maxPage", maxPage);
				mv.addObject("currentPage", currentPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.setViewName("notice/listView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 공지글 삭제
	 * @param session
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value="notice/remove.kh", method=RequestMethod.GET)
	public String noticeRemove(
			HttpSession session
			, Model model
			, @RequestParam("page") Integer page) {
		try {
			int noticeNo = (Integer)session.getAttribute("noticeNo");
			int result = nService.removeOneByNo(noticeNo);
			if(result > 0) {
				session.removeAttribute("noticeNo");
			}
			return "redirect:/notice/list.kh?page="+page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	
	
	
	}
