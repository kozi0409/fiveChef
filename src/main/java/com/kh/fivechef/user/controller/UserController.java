package com.kh.fivechef.user.controller;

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

import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/user/userJoinView.kh", method=RequestMethod.GET) //회원가입창 이동
	public String userJoinView() {
		return "user/join";
	}
	
	@RequestMapping(value="/user/myPage.kh", method=RequestMethod.GET)
	public ModelAndView userMyPageView(ModelAndView mv, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("loginUser");
			if(user != null) {
				String userId = user.getUserId();
				User uOne = uService.printOneUser(userId);
				mv.addObject("user", uOne);
				mv.setViewName("user/myPageMain");
			} else {
				request.setAttribute("msg", "로그인후 이용 가능한 서비스입니다.");
				request.setAttribute("url", "/user/loginView.kh");
				mv.setViewName("common/alert");
			}
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/register.kh", method=RequestMethod.POST) //회원가입
	public ModelAndView userJoin(ModelAndView mv,
			@ModelAttribute User user,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
			HttpServletRequest request) {
		try {
			String userPhotoName = uploadFile.getOriginalFilename();
			if(!uploadFile.getOriginalFilename().equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "//userProfile";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDHHmmss");
				String userPhotoRename = sdf.format(new Date(System.currentTimeMillis())) + "." + userPhotoName.substring(userPhotoName.lastIndexOf(".") + 1);
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				uploadFile.transferTo(new File(savePath + "\\" + userPhotoRename));
				String userPhotoPath = savePath + "\\" + userPhotoRename;
				user.setUserPhotoName(userPhotoName);
				user.setUserPhotoRename(userPhotoRename);
				user.setUserPhotoPath(userPhotoPath);
			}
			int result = uService.registerUser(user);
			if(result > 0) {
				mv.setViewName("/user/login");
			} else {
				mv.addObject("msg", "회원가입에 실패했습니다.").setViewName("common/errorPage");
			}
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/loginView.kh", method=RequestMethod.GET) //로그인 페이지 이동
	public String userLoginView() {
		return "/user/login";
	}
	
	@RequestMapping(value="/user/login.kh", method=RequestMethod.POST) //회원 로그인
	public ModelAndView userLogin(ModelAndView mv, @RequestParam("user-id") String userId, @RequestParam("user-pwd") String userPwd, HttpServletRequest request) {
		try {
			User user = new User(userId, userPwd);
			User loginUser = uService.loginUser(user);
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				mv.setViewName("redirect:/home.kh");
			} else {
				request.setAttribute("msg", "로그인 실패");
				request.setAttribute("url", "/user/loginView.kh");
				mv.setViewName("/common/alert");
			}
			
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/logout.kh", method=RequestMethod.GET) //로그아웃 -> 메인페이지 이동
	public ModelAndView userLogout(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			request.setAttribute("msg", "로그아웃이 완료되었습니다.");
			request.setAttribute("url", "/home.kh");
			mv.setViewName("/common/alert");
		} else {
			mv.addObject("msg", "로그아웃 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/modifyView.kh", method=RequestMethod.GET) //회원정보 보기
	public ModelAndView showMyPage(ModelAndView mv, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
				User user = (User)session.getAttribute("loginUser");
				if(user != null) {
				String userId = user.getUserId();
				User uOne = uService.printOneUser(userId);
				mv.addObject("user", uOne);
				mv.setViewName("user/myPage");	
			} else {
				request.setAttribute("msg", "로그인후 이용 가능한 서비스입니다.");
				request.setAttribute("url", "/user/loginView.kh");
				mv.setViewName("common/alert");
			}
		} catch (Exception e){
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/remove.kh", method=RequestMethod.GET) //회원탈퇴
	public ModelAndView removeUser(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		try {	
			User user = (User)session.getAttribute("loginUser");
			String userId = user.getUserId();
			int result = uService.removeUser(userId);
			if (result > 0) {
				request.setAttribute("msg", "회원탈퇴가 완료되었습니다.");
				request.setAttribute("url", "/user/logout.kh");
				mv.setViewName("/common/alert");	
			} else {
				request.setAttribute("msg", "회원탈퇴가 정상적으로 이루어지지 않았습니다.");
				request.setAttribute("url", "user/myPage.kh");
				mv.setViewName("/common/alert");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/modify.kh", method=RequestMethod.POST) //회원 정보 수정
	public ModelAndView modifyUser(ModelAndView mv,
			@ModelAttribute User user,
			HttpServletRequest request,
			@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		try {
			String userPhotoName = reloadFile.getOriginalFilename();
			if(reloadFile != null && !userPhotoName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\userProfile";
				File file = new File(savePath + "\\" + user.getUserPhotoRename());
				if(file.exists()) {
					file.delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String userPhotoRename = sdf.format(new Date(System.currentTimeMillis())) + "." + userPhotoName.substring(userPhotoName.lastIndexOf(".")+1);
				String userPhotoPath = savePath + "\\" + userPhotoRename;
				reloadFile.transferTo(new File(userPhotoPath));
				user.setUserPhotoName(userPhotoName);
				user.setUserPhotoRename(userPhotoRename);
				user.setUserPhotoPath(userPhotoPath);
			}
			int result = uService.modifyUser(user);
			if(result > 0) {
				request.setAttribute("msg", "회원님의 정보가 수정되었습니다.");
				request.setAttribute("url", "/user/myPage.kh");
				mv.setViewName("common/alert");
			} else {
				mv.addObject("msg", "정보 수정 실패").setViewName("common/errorPage");
			}
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	@RequestMapping(value="user/findIdView.kh", method=RequestMethod.GET)
	public String findIdView() {
		return "user/findId";
	}
	
	@RequestMapping(value="user/findId.kh", method=RequestMethod.POST)
	public ModelAndView findUserId (ModelAndView mv, @RequestParam("userEmail")String userEmail, HttpServletRequest request) {
		User searchId = uService.findUserId(userEmail);
		if(searchId == null) {
			request.setAttribute("msg", "가입된 정보가 없습니다.");
			request.setAttribute("url", "/user/loginView.kh");
			mv.setViewName("common/alert");
		} else {
			String findId = searchId.getUserId();
			request.setAttribute("msg", "회원님의 아이디는 " + findId + " 입니다.");
			request.setAttribute("url", "/user/loginView.kh");
			mv.setViewName("common/alert");
		}
		return mv;
	}
	
	@RequestMapping(value="user/findPwdView.kh", method=RequestMethod.GET)
	public String findPwdView() {
		return "user/findPwd";
	}
	
	@RequestMapping(value="user/findPwd.kh", method=RequestMethod.POST)
	public ModelAndView findUserPwd(ModelAndView mv, @RequestParam("userId")String userId, @RequestParam("userEmail")String userEmail, HttpServletRequest request) {
		User searchPwd = uService.findUserPwd(userId, userEmail);
		if(searchPwd == null) {
			request.setAttribute("msg", "가입된 정보가 없습니다.");
			request.setAttribute("url", "/user/loginView.kh");
			mv.setViewName("common/alert");
		} else {
			String findPwd = searchPwd.getUserPwd();
			request.setAttribute("msg", "회원님의 비밀번호는 " + findPwd + " 입니다.");
			request.setAttribute("url", "/user/loginView.kh");
			mv.setViewName("common/alert");
		}
		return mv;
	}
	
	@RequestMapping(value = "/recipe/myRecipeList.kh", method = RequestMethod.GET)
	public ModelAndView MyRecipeView(
			ModelAndView mv
			,@RequestParam(value="category" , required=false) String listValue
			,@RequestParam(value="page",required = false) Integer page
			,HttpSession session) {
		User user =(User)session.getAttribute("loginUser");
		String userId = user.getUserId();
		int currentPage = (page != null) ? page : 1;
		int totalCount = uService.countMyRecipe();
		int recipeLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int) ((double) totalCount / recipeLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Recipe> rList = uService.printMyRecipe(userId, listValue, currentPage, recipeLimit);
		if(!rList.isEmpty()) {
			mv.addObject("rList",rList);
		}
		mv.addObject("userId", userId);
		mv.addObject("startNavi",startNavi);
		mv.addObject("endNavi",endNavi);
		mv.addObject("maxPage",maxPage);
		mv.addObject("currentPage",currentPage);
		mv.addObject("urlVal","myRecipeList");
		mv.addObject("listValue",listValue);
		mv.addObject("totalCount",totalCount);
		mv.setViewName("user/myRecipeList");
		
		return mv;
	}
}
