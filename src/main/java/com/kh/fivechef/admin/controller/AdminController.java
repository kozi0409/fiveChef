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
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.user.domain.User;


@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	
	@RequestMapping(value="/home.kh", method=RequestMethod.GET)
	private String adminHome() {
		return "/admin/adminHome";
	}
	
	@RequestMapping(value="/admin.kh", method=RequestMethod.GET)
	private String adminLogCheck(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("loginAdmin");
			if(admin != null) {
				return "redirect:/admin/adminHome.kh";
			}else {
				return "redirect:/admin/loginView.kh";
			}
			
		}catch (Exception e) {
			return "common/errorPage";
		}
	}
	
	/**
	 * 회원가입폼으로 이동
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
	@RequestMapping(value="admin/a_findIdView.kh", method=RequestMethod.GET)
	public String findAdminIdView() {
		return "admin/adminfindID";
	}
	@RequestMapping(value="admin/a_findId.kh", method=RequestMethod.POST)
	public ModelAndView findAdminId (ModelAndView mv, @RequestParam("adminEmail") String adminEmail, HttpServletRequest request) {
		Admin searchId = aService.findAdminId(adminEmail);
		System.out.println(searchId);
		if(searchId == null) {
			request.setAttribute("msg", "가입된 정보가 없습니다.");
			request.setAttribute("url", "/admin/loginView.kh");
			mv.setViewName("common/alert");
		} else {
			String findId = searchId.getAdminId();
			request.setAttribute("msg", "회원님의 아이디는 " + findId + " 입니다.");
			request.setAttribute("url", "/admin/loginView.kh");
			mv.setViewName("common/alert");
		}
		return mv;
	}
	
	@RequestMapping(value="admin/a_findPwdView.kh", method=RequestMethod.GET)
	public String findPwdView() {
		return "admin/adminfindPW";
	}
	
	@RequestMapping(value="admin/a_findPW.kh", method=RequestMethod.POST)
	public ModelAndView findAdminPwd(ModelAndView mv, @RequestParam("adminId")String adminId, @RequestParam("adminEmail")String adminEmail, HttpServletRequest request) {
		Admin searchPwd = aService.findAdminPwd(adminId, adminEmail);
		if(searchPwd == null) {
			request.setAttribute("msg", "가입된 정보가 없습니다.");
			request.setAttribute("url", "/admin/loginView.kh");
			mv.setViewName("common/alert");
		} else {
			String findPwd = searchPwd.getAdminPwd();
			request.setAttribute("msg", "회원님의 비밀번호는 " + findPwd + " 입니다.");
			request.setAttribute("url", "/admin/loginView.kh");
			mv.setViewName("common/alert");
		}
		return mv;
	}
	
	//로그인 페이지로 이동
	@RequestMapping(value="/admin/loginView.kh", method=RequestMethod.GET) //로그인 페이지 이동
	public String adminLoginView() {
		return "/admin/adminLog";
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
//			@ModelAttribute Admin admin
			ModelAndView mv
			, @RequestParam(value="adminId", required=false) String adminId
			, @RequestParam(value="adminPwd", required=false) String adminPwd
			, HttpServletRequest request) {
		
		try {
			Admin admin = new Admin(adminId, adminPwd);
			Admin loginAdmin = aService.loginAdmin(admin);
			if(loginAdmin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", loginAdmin);
				mv.setViewName("/admin/adminHome");
				System.out.println("로그인성공");
			}else {
				mv.addObject("msg", "회원정보를 찾을 수 없습니다.");
				request.setAttribute("url", "/admin/loginView.kh");
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
	 * 전체 관리자 조회
	 * @param mv
	 * @param page
	 * @return
	 */
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
		// 23/5 = 4.8 + 0.9 = 5(.7) 페이지 나누는 계산법
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
	/**
	 * 관리자 상세뷰
	 * @param request
	 * @param mv
	 * @param adminId
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/adminDetail.kh", method=RequestMethod.GET)
	public ModelAndView adminDetailView(HttpServletRequest request
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

	/**
	 * 관리자 조건검색
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
			mv.addObject("urlVal", "searchAdmin");
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
	
	//Id check
//	@RequestMapping(value="/admin/adminIdCheck.kh", method=RequestMethod.GET)
//	public String JoinIdCheck() {
//		return null;
//		
//	}
//	
	
	
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
	 * 관리자 삭제하기
	 * @param session
	 * @param model
	 * @param page
	 * @param adminId
	 * @return
	 */
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
	/**
	 * 관리자 정보뷰
	 * @param request
	 * @param mv
	 * @param userId
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/admin/userDetail.kh", method=RequestMethod.GET)
	public ModelAndView userDetailView(HttpServletRequest request
			, ModelAndView mv
			, @RequestParam("userId") String userId
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			User uOne = aService.printOneByUserId(userId);
			mv.addObject("user", uOne).addObject("page", page);
			mv.setViewName("admin/userDetailView");
//			System.out.println(mv.toString());
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;		
	}
	/**
	 * 유저 리스트
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/userlist.kh", method=RequestMethod.GET) //회원목록 요청
	public ModelAndView userListView(
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
	/**
	 * 관리자 삭제
	 * @param session
	 * @param model
	 * @param page
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/admin/deleteUser.kh", method=RequestMethod.GET)
	public String userDelete(
			HttpSession session
			, Model model
			, @RequestParam("page") Integer page
			, @RequestParam("userId") String userId) {
//		System.out.println(userId);
//		System.out.println(model.toString());
		try {
			User user = (User)session.getAttribute("userId");
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
//		 System.out.println(mv.toString());
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
	 * 회원 조건별 검색
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
			mv.addObject("urlVal", "searchUser");
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
	/**
	 * QNA글 전체 조회
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/admin/qnalist.kh", method=RequestMethod.GET)
	public ModelAndView qnaListView(
			ModelAndView mv
			,@RequestParam(value="page", required=false) Integer page) {
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
		// /board/list.kh?page=${currentPage }
		List<QnA> qList = aService.printAllQna(currentPage, qnaLimit);
		if(!qList.isEmpty()) {
			mv.addObject("urlVal", "qnalist");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("qList", qList);
		}
//		System.out.println(mv.toString());
		mv.setViewName("admin/qnalistView");
		return mv;
	}
	
	//QNA글 상세 조회
	@RequestMapping(value="/admin/qnaDetail.kh", method=RequestMethod.GET)
	public ModelAndView qnaDetailView(
			ModelAndView mv
			, @RequestParam("questionNo") Integer questionNo
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			QnA qOne = aService.printOneByQna(questionNo);
			session.setAttribute("questionNo", qOne.getQuestionNo());
			// 세션에 getQuestionNo 저장 -> 삭제하기 위해서
			mv.addObject("qna", qOne);
			mv.addObject("page", page);
			mv.setViewName("admin/qnadetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/admin/qnaAnswer.kh", method=RequestMethod.POST)
	public ModelAndView qnaAnswer(
			ModelAndView mv
			, @ModelAttribute QnA qna
			, @RequestParam("page") int page
			, HttpSession session) {
		Admin admin = (Admin)session.getAttribute("loginAdmin");
		String answerWriter = admin.getAdminId();
		int questionNo = qna.getQuestionNo();
		qna.setAnswerWriter(answerWriter);
		int result = aService.answerQna(qna);
		if(result > 0) {
			mv.setViewName(
			"redirect:/admin/qnaDetail.kh?questionNo="+questionNo+"&page="+page);
		}
		return mv;
	}

	@RequestMapping(value="/admin/searchQna.kh", method=RequestMethod.GET)
	public ModelAndView qnaSearchList(
			ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchValue") String searchValue
			, @RequestParam(value="page", required=false) Integer page) {
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = aService.getTotalQnaCount(searchCondition, searchValue);
			int QnaLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/QnaLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<QnA> qList = aService.printAllByQnaValue(
					searchCondition, searchValue, currentPage, QnaLimit);
			if(!qList.isEmpty()) {
				mv.addObject("qList", qList);
			}else {
				mv.addObject("qList", null);
			}
			mv.addObject("urlVal", "searchQna");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchValue", searchValue);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("admin/qnalistView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/adminHome.kh", method=RequestMethod.GET)
	public ModelAndView adminMainview(
			ModelAndView mv) {
		
		List<User> uList = aService.printNewUser();
		List<Community> cList = aService.printNewCommunity();
		List<QnA> qList = aService.printNewQna();
		List<Recipe> rList = aService.printNewRecipe();
		if(!uList.isEmpty()|| !cList.isEmpty()||!qList.isEmpty()||!rList.isEmpty()) {
			mv.addObject("uList", uList);
			mv.addObject("cList", cList);
			mv.addObject("qList", qList);
			mv.addObject("rList", rList);
		}
		mv.setViewName("admin/adminHome");
		return mv;
		
	}
	
}
