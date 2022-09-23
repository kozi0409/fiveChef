package com.kh.fivechef.admin.controller;

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
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.user.domain.User;

import oracle.sql.DATE;


@Controller
public class AdminController {
	@Autowired
	private AdminService aService;

	
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
	public ModelAndView adminMypage(HttpServletRequest request
			, ModelAndView mv) {
		try {
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("loginAdmin");
			String adminId = admin.getAdminId();
			Admin aOne = aService.printOneById(adminId);
			String aAddr = aOne.getAdminAddr();
			String [] addrInfos = aAddr.split(",");
			mv.addObject("admin", aOne).addObject("addrInfos", addrInfos);
			mv.setViewName("admin/adminMyPage");
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
	public ModelAndView adminModify(
			@ModelAttribute Admin admin
			, @RequestParam("post") String post
			, @RequestParam("address1") String address1
			, @RequestParam("address2") String address2
			, @RequestParam(value="page", required=false) Integer page
			, ModelAndView mv) {
		try {
			admin.setAdminAddr(post + "," + address1 + "," + address2);
			int result = aService.modifyAdmin(admin);
			if(result > 0) {
				if(page != null) {
					mv.setViewName("redirect:/admin/adminlist.kh?page="+page);
				}else {
					mv.setViewName("redirect:/mypage.kh");
				}
				
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
	public ModelAndView adminRemove(HttpSession session
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
	
	
	/**
	 * 전체 관리자 조회
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/adminlist.kh", method=RequestMethod.GET) //관리자 목록 요청
	public ModelAndView adminList(
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
	public String adminDelete(
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

	
	@RequestMapping(value="/admin/adminDetail.kh", method=RequestMethod.GET)
	public ModelAndView adminView(HttpServletRequest request
			, ModelAndView mv
			, @RequestParam("adminId") String adminId
			, @RequestParam("page") Integer page) {
		try {
			Admin aOne = aService.printOneById(adminId);
			String aAddr = aOne.getAdminAddr();
			String [] addrInfos = aAddr.split(",");
			mv.addObject("admin", aOne).addObject("addrInfos", addrInfos).addObject("page", page);
			mv.setViewName("admin/adminDetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;		
	}

	//어드민 회원정보 보기
	@RequestMapping(value="/admin/userDetail.kh", method=RequestMethod.GET)
	public ModelAndView userView(HttpServletRequest request
			, ModelAndView mv
			, @RequestParam("userId") String userId
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			User uOne = aService.printOneByUserId(userId);
			mv.addObject("user", uOne).addObject("page", page);
			mv.setViewName("admin/userDetailView");
			System.out.println(mv.toString());
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;		
	}

	//어드민에서 회원목록 요청
	@RequestMapping(value="/admin/userlist.kh", method=RequestMethod.GET) //회원목록 요청
	public ModelAndView userList(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getTotalUserCount("","");
		int userLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		// 23/5 = 4.8 + 0.9 = 5(.7)
		maxPage = (int)((double)totalCount/userLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
		endNavi = maxPage;
		}
		//////////////////////////////////////////////////////////////////////////		
		
		List<User> uList = aService.printAllUser(currentPage, userLimit);
		if(!uList.isEmpty()) {
			mv.addObject("uList", uList);
			mv.addObject("urlVal", "userlist");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
		}
		mv.setViewName("admin/userlistView");
		return mv;
	}
	
//	관리자 목록에서 회원 삭제하기
	@RequestMapping(value="/admin/deleteUser.kh", method=RequestMethod.GET)
	public String userDelete(
			HttpSession session
			, Model model
			, @RequestParam("page") Integer page
			, @RequestParam("userId") String userId) {
		System.out.println(userId);
		System.out.println(model.toString());
		try {
			User user = (User)session.getAttribute("userId");
			System.out.println(user);
			int result = aService.removeOneByUserId(userId);
			if(result > 0) {
				session.removeAttribute("userId");
			}
			return "redirect:/admin/userlist.kh?page="+page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}

	//마스터 회원정보 수정
	@RequestMapping(value="/admin/userModify.kh", method=RequestMethod.POST)
	public ModelAndView userModify(
			@ModelAttribute User user
			, @RequestParam(value="page", required=false) Integer page
			, ModelAndView mv) {
		 System.out.println(mv.toString());
		try {
			int result = aService.modifyUser(user);
			if(result > 0) {
				mv.setViewName("redirect:/admin/userlist.kh?page="+page);
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
	 * 관리자 검색
	 * @param mv
	 * @param searchCondition
	 * @param searchValue
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/searchAdmin.kh", method=RequestMethod.GET)
	public ModelAndView adminSearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = aService.getTotalCount(searchCondition, searchValue);
			int adminLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/adminLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<Admin> aList = aService.printAllByAdminValue(
					searchCondition, searchValue, currentPage, adminLimit);
			if(!aList.isEmpty()) {
				mv.addObject("aList", aList);
			}else {
				mv.addObject("aList", null);
			}
			mv.addObject("urlVal", "searchadmin");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchValue", searchValue);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("admin/adminlistView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	/**
	 * 회원 검색
	 * @param mv
	 * @param searchCondition
	 * @param searchValue
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/searchUser.kh", method=RequestMethod.GET)
	public ModelAndView userSearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = aService.getTotalUserCount(searchCondition, searchValue);
			int userLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/userLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<User> uList = aService.printAllByUserValue(
					searchCondition, searchValue, currentPage, userLimit);
			if(!uList.isEmpty()) {
				mv.addObject("uList", uList);
			}else {
				mv.addObject("uList", null);
			}
			mv.addObject("urlVal", "searchuser");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchValue", searchValue);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("admin/userlistView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}

	//Qna 목록 출력하기
	@RequestMapping(value="/admin/qnalist.kh", method=RequestMethod.GET) //관리자 목록 요청
	public ModelAndView qnaList(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getTotalQnaCount("","");
		int qnaLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		// 23/5 = 4.8 + 0.9 = 5(.7)
		maxPage = (int)((double)totalCount/qnaLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
		endNavi = maxPage;
		}
		//////////////////////////////////////////////////////////////////////////
		List<QnA> qList = aService.printAllQna(currentPage, qnaLimit);
		if(!qList.isEmpty()) {
			mv.addObject("urlVal", "qnalist");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("qList", qList);
		}
		mv.setViewName("admin/qnalistView");
		return mv;
	}
}
