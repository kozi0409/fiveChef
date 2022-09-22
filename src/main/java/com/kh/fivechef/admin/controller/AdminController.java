package com.kh.fivechef.admin.controller;

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

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.service.UserService;

import oracle.sql.DATE;


@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/admin.kh", method=RequestMethod.GET)
	private String adminpage() {
		
		return "admin";
		// /WEB-INF/views/admin/adminJoin.jsp
		
	}
	
	/**
	 * 회원가입
	 * @return
	 */
	@RequestMapping(value="/admin/adminJoinView.kh", method=RequestMethod.GET)
	private String adminJoinView() {
		return "admin/adminJoin";
		// /WEB-INF/views/admin/adminJoin.jsp
	}

	/**
	 * 회원정보 입력
	 * @param admin
	 * @param post
	 * @param address1
	 * @param address2
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/adminRegister.kh", method=RequestMethod.POST)
	public ModelAndView adminJoin(
			@ModelAttribute Admin admin
			, @RequestParam("post") String post
			, @RequestParam("address1") String address1
			, @RequestParam("address2") String address2
			, ModelAndView mv) {
		try {
			admin.setAdminAddr(post + "," + address1 + "," + address2);
			int result = aService.registerAdmin(admin);
			if(result > 0) {
				mv.setViewName("redirect:/admin.kh");
			}else {
				mv.addObject("msg", "회원가입을 실패했습니다.");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	/**
	 * 로그인
	 * @param admin
	 * @param model
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/admin/login.kh", method=RequestMethod.POST)
	public ModelAndView adminLogin(
			@ModelAttribute Admin admin
			, ModelAndView mv
			, HttpServletRequest request) {
		
		try {
			Admin loginAdmin = aService.loginAdmin(admin);
			if(loginAdmin != null) {
				System.out.println(loginAdmin.toString());;
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				mv.setViewName("redirect:/admin.kh");
				System.out.println("로그인성공");
			}else {
				mv.addObject("msg", "회원정보를 찾을 수 없습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
		
	}
	/**
	 * 로그아웃
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/logout.kh", method=RequestMethod.GET)
	public ModelAndView adminLogout(
			HttpServletRequest request
			, ModelAndView mv) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			mv.setViewName("redirect:/admin.kh");
		}else {
			mv.addObject("msg", "로그아웃 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	/**
	 * 회원정보
	 * @param request
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/myPage.kh", method=RequestMethod.GET)
	public ModelAndView showMypage(HttpServletRequest request
			, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("loginAdmin");
			String adminId = admin.getAdminId();
			Admin aOne = aService.printOneById(adminId);
			String aAddr = aOne.getAdminAddr();
			String [] addrInfos = aAddr.split(",");
			mv.addObject("admin", aOne).addObject("addrInfos", addrInfos);
			mv.setViewName("admin/myPage");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;		
	}
	
	/**
	 * 회원정보 수정
	 * @param admin
	 * @param post
	 * @param address1
	 * @param address2
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/modify.kh", method=RequestMethod.POST)
	public ModelAndView modifyAdmin(
			@ModelAttribute Admin admin
			, @RequestParam("post") String post
			, @RequestParam("address1") String address1
			, @RequestParam("address2") String address2
	//		, @RequestParam(value="page", required=false) Integer page)
			, ModelAndView mv) {
		try {
			admin.setAdminAddr(post + "," + address1 + "," + address2);
			int result = aService.modifyAdmin(admin);
			if(result > 0) {
				mv.setViewName("redirect:/admin.kh");
			}else {
				mv.addObject("msg", "회원 정보 수정 실패!");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	/**
	 * 회원삭제
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin/remove.kh", method=RequestMethod.GET)
	public ModelAndView removeMember(HttpSession session
			, ModelAndView mv) {
		try {
			Admin admin = (Admin)session.getAttribute("loginAdmin");
			String adminId = admin.getAdminId();
			int result = aService.removeAdmin(adminId);
			mv.setViewName("redirect:/admin/logout.kh");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	

	//관리자 목록 출력하기
//	@RequestMapping(value="/admin/adminlist.kh", method=RequestMethod.GET) //관리자 목록 요청
//	public ModelAndView adminListView(ModelAndView mv) {
//		List<Admin> aList = aService.printAllAdmin();
//		if(!aList.isEmpty()) {
//			mv.addObject("aList", aList);
//		}
//		mv.setViewName("admin/adminlistView");
//		return mv;
//	}
	
	//어드민에서 회원목록 요청합니다.
	@RequestMapping(value="/admin/userlist.kh", method=RequestMethod.GET) //회원목록 요청
	public ModelAndView userListView(ModelAndView mv) {
		List<User> uList = aService.printAllUser();
		if(!uList.isEmpty()) {
			mv.addObject("uList", uList);
		}
		mv.setViewName("admin/userlistView");
		return mv;
	}
	
	//관리자 목록 출력하기
	@RequestMapping(value="/admin/adminlist.kh", method=RequestMethod.GET) //관리자 목록 요청
	public ModelAndView adminListView(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getTotalCount("","");
		int adminLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		// 23/5 = 4.8 + 0.9 = 5(.7)
		maxPage = (int)((double)totalCount/adminLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
		endNavi = maxPage;
		}
		//////////////////////////////////////////////////////////////////////////
		List<Admin> aList = aService.printAllAdmin(currentPage, adminLimit);
		if(!aList.isEmpty()) {
			mv.addObject("urlVal", "adminlist");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("aList", aList);
		}
		mv.setViewName("admin/adminlistView");
		return mv;
	}
	
//	관리자 목록에서 삭제하기
	@RequestMapping(value="/admin/delete.kh", method=RequestMethod.GET)
	public String adminRemove(
			HttpSession session
			, Model model
			, @RequestParam("page") Integer page
			, @RequestParam("adminId") String adminId) {
		try {
			Admin admin = (Admin)session.getAttribute("adminId");
			int result = aService.removeOneById(adminId);
			if(result > 0) {
				session.removeAttribute("adminId");
			}
			return "redirect:/admin/adminlist.kh?page="+page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	/*
	 * //관리자정보 수정
	 * 
	 * @RequestMapping(value="/admin/adminModify.kh", method=RequestMethod.POST)
	 * public ModelAndView boardModify( HttpSession session , @ModelAttribute Admin
	 * admin , ModelAndView mv ,@RequestParam("adminId") String adminId
	 * ,@RequestParam("page") Integer page ,HttpServletRequest request) { try {
	 * Admin admin = (Admin)session.getAttribute("adminId"); int result =
	 * aService.modifyAdmin(adminId);
	 * mv.setViewName("redirect:/board/list.kh?page="+page); } catch (Exception e) {
	 * mv.addObject("msg", e.toString()).setViewName("common/errorPage"); } return
	 * mv; }
	 */
	
	@RequestMapping(value="/admin/detail.kh", method=RequestMethod.GET)
	public ModelAndView masterView(HttpServletRequest request
			, ModelAndView mv
			, @RequestParam("adminId") String adminId
			, @RequestParam("page") Integer page) {
		try {
			Admin aOne = aService.printOneById(adminId);
			String aAddr = aOne.getAdminAddr();
			String [] addrInfos = aAddr.split(",");
			mv.addObject("admin", aOne).addObject("addrInfos", addrInfos);
			mv.setViewName("admin/masterView");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;		
	}
	
//	@RequestMapping(value="/admin/MasterModify.kh", method=RequestMethod.POST)
//	public ModelAndView modifyAdminFin(
//			@ModelAttribute Admin admin
//			, @RequestParam("post") String post
//			, @RequestParam("address1") String address1
//			, @RequestParam("address2") String address2
//			, @RequestParam("adminId") String adminId
//			, @RequestParam("page") Integer page
//			, ModelAndView mv
//			,HttpServletRequest request) {
//		try {
//			admin.setAdminAddr(post + "," + address1 + "," + address2);
//			int result = aService.modifyAdminMaster(admin);
////			mv.addObject("adminId", adminId);
////			mv.addObject("page", page);
//			if(result > 0) {
//				mv.setViewName("redirect:/admin/adminlist.kh?page="+page);
//			}else {
//				mv.addObject("msg", "회원 정보 수정 실패!");
//				mv.setViewName("common/errorPage");
//			}
//		} catch (Exception e) {
//			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
//		}
//		return mv;
//	}
}
