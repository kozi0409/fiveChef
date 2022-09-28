package com.kh.fivechef.fridge.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.fridge.domain.Fridge;
import com.kh.fivechef.fridge.service.FridgeService;
import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.service.UserService;


@Controller
public class FridgeController {
	@Autowired
	private FridgeService fService;
	@Autowired
	private UserService uService;
	
//	@RequestMapping(value="/fridge/myFridge.kh", method=RequestMethod.GET)
//	public String showMyFridge() {
//		return "fridge/myFridge";
//	}
	
	
	// 냉장고 등록
	@PostMapping("/fridge/register.kh")
	public ModelAndView registFridge(ModelAndView mv
			, @ModelAttribute Fridge fridge
			, @RequestParam(value="uploadProfile", required=false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("loginUser");
			fridge.setUserId(user.getUserId());
			String fridgeFilename = uploadFile.getOriginalFilename();
			if(!fridgeFilename.equals("")) {
				//////////////////////////////////////////////////////////////////////경로, 파일이름 설정
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\fuploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String fridgeFileRename = sdf.format(new Date(System.currentTimeMillis()))+ "." // 시간
						+ fridgeFilename.substring(fridgeFilename.lastIndexOf(".")+1); // 확장자명
				// 1.png, img.png
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				//////////////////////////////////////////////////////////////////////
				uploadFile.transferTo(new File(savePath+"\\"+fridgeFileRename)); // 저장할때는 Rename으로 저장
				// 파일을 buploadFiles 경로에 저장하는 메소드
				String fridgeFilepath = savePath + "\\" + fridgeFileRename;
				fridge.setFridgeFilename(fridgeFilename);
				fridge.setFridgeFileRename(fridgeFileRename);
				fridge.setFridgeFilepath(fridgeFilepath);
			}
			int result = fService.registerFridge(fridge);
			System.out.println(result);
			mv.setViewName("redirect:/fridge/myFridge.kh");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 냉장고 조회
	@RequestMapping(value="/fridge/myFridge.kh", method=RequestMethod.GET)
	public ModelAndView fridgeListView(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(user != null) {
			String userId = user.getUserId();
			User uOne = uService.printOneUser(userId);
			mv.addObject("user", uOne);
			List<Fridge> fList = fService.printAllFridge(userId);
			boolean checkYn = false;
			if(fList.size() <= 3) {
				checkYn = true;
			} else if(fList.size() == 0) {
				checkYn = true;
			}
			if(!fList.isEmpty()) {
				mv.addObject("fList", fList);
				mv.addObject("checkYn", checkYn);
			}
			mv.setViewName("fridge/myFridge");
			
		} else {
			request.setAttribute("msg", "로그인후 이용 가능한 서비스입니다.");
			request.setAttribute("url", "/user/loginView.kh");
			mv.setViewName("common/alert");
		}
		return mv;
	}
	
	// 냉장고 수정
	@RequestMapping(value="/fridge/modify.kh", method=RequestMethod.POST)
	public ModelAndView fridgeModify(@ModelAttribute Fridge fridge, ModelAndView mv
			, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
			, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("loginUser");
			fridge.setUserId(user.getUserId());
			String fridgeFilename = reloadFile.getOriginalFilename();
			if(reloadFile != null && !fridgeFilename.equals("")) {
				// 수정, 1. 대체(replace) / 2. 삭제 후 등록  // 2번이 편함
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\fuploadFiles";
				//Board board = bService.printOneByNo(board.getBoardNo());
				File file = new File(savePath + "\\" + fridge.getFridgeFileRename());
				if(file.exists()) {
					file.delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String fridgeFileRename = sdf.format(new Date(System.currentTimeMillis()))
						+ "." + fridgeFilename.substring(fridgeFilename.lastIndexOf(".")+1);
				String fridgeFilepath = savePath + "\\" + fridgeFileRename;
				reloadFile.transferTo(new File(fridgeFilepath));
				fridge.setFridgeFilename(fridgeFilename);
				fridge.setFridgeFileRename(fridgeFileRename);
				fridge.setFridgeFilepath(fridgeFilepath);
			}
			int result = fService.modifyFridge(fridge);
			mv.setViewName("redirect:/fridge/myFridge.kh");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	// 냉장고 삭제
	@RequestMapping(value="/fridge/removeFridge.kh", method=RequestMethod.GET)
	public ModelAndView fridgeRemove(ModelAndView mv
			, HttpSession session
			, @RequestParam("fridgeNo") Integer fridgeNo) {
		try {
//			int fridgeNo = (int)session.getAttribute("fridgeNo");
			int result = fService.removeOneByNo(fridgeNo);
			if(result > 0) {
				session.removeAttribute("fridgeNo");
				mv.setViewName("redirect:/fridge/myFridge.kh");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage"); 
		}
		return mv;
	}
}
