package com.kh.fivechef.boardManage.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.kh.fivechef.boardManage.service.BoardManageService;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.service.StorageService;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;
import com.kh.fivechef.user.domain.User;

@Controller
public class BoardManageController {
	
	@Autowired
	private BoardManageService pService;
	@Autowired
	private StorageService sService;
	
	// 커뮤니티 관리 코드

	
	// 전체 게시글 리스트
	@RequestMapping(value = "/communitymanage/list.kh", method = RequestMethod.GET)
	public ModelAndView commManageView(
			ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = pService.getPostTotalCount("", "");
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
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("boardmanage/commList");
		return mv;
	}
	
	//글 누르면 상세 조회
	@RequestMapping(value="/communitymanage/detail.kh", method=RequestMethod.GET)
	public ModelAndView printCommDetail(
			ModelAndView mv
			, @RequestParam("communityNo") Integer communityNo
			, @RequestParam("page") Integer page
			, HttpSession session) {
		try {
			Community community = pService.printOneByPostNo(communityNo);
			List<CReply> rList = pService.printAllReply(communityNo);
			session.setAttribute("communityNo", communityNo);
			mv.addObject("rList", rList);
			mv.addObject("community", community);
			mv.addObject("page", page);
			mv.setViewName("boardmanage/commDetail");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}
	
	// 검색 기능
	@RequestMapping(value="/communitymanage/search.kh", method=RequestMethod.GET)
	public ModelAndView commManageSearchList(
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
				mv.setViewName("boardmanage/commList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 수정화면
	@RequestMapping(value="/communitymanage/modifyView.kh", method=RequestMethod.GET)
	public ModelAndView commManageModifyView(ModelAndView mv
			, @RequestParam("communityNo") Integer communityNo, @RequestParam("page") int page) {
		try {
			Community community = pService.printOneByPostNo(communityNo);
			mv.addObject("community", community);
			mv.setViewName("boardmanage/commModify");
			mv.addObject("page", page);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 수정
	@RequestMapping(value="/communitymanage/modify.kh", method=RequestMethod.POST)
	public ModelAndView commManageModify(ModelAndView mv
			, @ModelAttribute Community community, @RequestParam("page")Integer page, HttpServletRequest request) {
		try {
			int result = pService.modifyPost(community);
			if(result > 0) {
				request.setAttribute("msg", "(관리자) 게시글 수정이 완료되었습니다.");
				request.setAttribute("url", "/communitymanage/list.kh");
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
	
	// 삭제
	@RequestMapping(value="/communitymanage/remove.kh", method=RequestMethod.GET)
	public String commmanageRemove(
			HttpSession session
			, Model model
			, HttpServletRequest request
			, @RequestParam("page") Integer page) {
		try {
			int communityNo = (Integer)session.getAttribute("communityNo");
			int result = pService.removeOneByPostNo(communityNo);
			if(result > 0) {
				session.removeAttribute("communityNo");
				request.setAttribute("msg", "(관리자) 게시글 삭제가 완료되었습니다.");
				request.setAttribute("url", "/communitymanage/list.kh?page"+page);
			}
			return "common/alert";
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}

	
	///////////////////////////////////////////////////////////////////////////////
	
	
	// 레시피 관리 코드
	
	// 리스트
		@RequestMapping(value = "/recipemanage/list.kh", method = RequestMethod.GET)
		public ModelAndView recipeManageView(
				ModelAndView mv
				,@RequestParam(value="page",required = false) Integer page) {
			int currentPage = (page != null) ? page : 1;
			int totalCount = pService.countAllRecipe("","");
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
			List<Recipe> rList = pService.printAllRecipe(currentPage,recipeLimit);
			if(!rList.isEmpty()) {
				mv.addObject("urlVal", "list");
				mv.addObject("maxPage", maxPage);
				mv.addObject("currentPage", currentPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.addObject("rList", rList);
			}
			mv.setViewName("boardmanage/recipeList");
			
			return mv;
		}
	
		
		// 상세 페이지 조회
		@RequestMapping(value="/recipemanage/detail.kh",method=RequestMethod.GET)
		public ModelAndView recipeManageDetailView(
				ModelAndView mv
				,
				@RequestParam(value = "category", required = false) String listValue,
				@RequestParam(value = "page", required = false) Integer page, @RequestParam("recipeNo") Integer recipeNo,
				HttpSession session) {
			try {
				User user = (User) session.getAttribute("loginUser");
				System.out.println("레시피 디테일창 진입 글번호: " + recipeNo);
				if (user != null) {
					String likeUser = user.getUserId();
//					System.out.println(likeUser);
					Like like = new Like();
					like.setUserId(likeUser);
					like.setRecipeNo(recipeNo);
//				System.out.println(recipeid.getUserId());
					// 레시피 좋아요 체크
					int result = pService.checkLikeId(like);
					mv.addObject("result", result);
					mv.addObject("like", like);
				}
				// 레시피정보 출력
				Recipe recipe = pService.printOneByNo(recipeNo);
				// 삭지하기위해 보드넘버 저장
				session.setAttribute("recipeNo", recipe.getRecipeNo());
				// 재료출력
				List<Ingradient> iList = pService.printAllIng(recipeNo);
//				System.out.println(iList);
				String bundle = "이름없음";
				// 로그인 구현되면 세션에 있는 아이디로 바꿔줘야함
				if (!iList.isEmpty()) {
					bundle = iList.get(0).getIngBundleName();
				}
				List<Order> oList = pService.printAllOrder(recipeNo);
				List<ComPhoto> cList = pService.printAllComPhoto(recipeNo);
				List<WhatRecipe> wList = pService.printWhat();

				mv.addObject("wList", wList);
				mv.addObject("urlVal", "list");
				mv.addObject("listValue", listValue);
				mv.addObject("page", page);
				mv.addObject("cList", cList);
				mv.addObject("oList", oList);
				mv.addObject("iList", iList);
				mv.addObject("bundle", bundle);
				mv.addObject("recipe", recipe);
				mv.setViewName("boardmanage/recipeDetail");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", "레시피조회 실패").setViewName("common/errorPage");
			}

			return mv;
		}
		
		// 검색 기능
		@RequestMapping(value="/recipemanage/search.kh", method=RequestMethod.GET)
		public ModelAndView recipeManageSearchList(
				ModelAndView mv
				, @RequestParam("searchCondition") String searchCondition
				, @RequestParam("searchValue") String searchValue
				, @RequestParam(value="page", required=false) Integer page) {
			try {
				int currentPage = (page != null) ? page : 1;
				int totalCount = pService.countAllRecipe(searchCondition, searchValue);
				int recipeLimit = 10;
				int naviLimit = 5;
				int maxPage;
				int startNavi;
				int endNavi;
				maxPage = (int)((double)totalCount/recipeLimit + 0.9);
				startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
				endNavi = startNavi + naviLimit - 1;
				if(maxPage < endNavi) {
					endNavi = maxPage;
				}
				List<Recipe> cList = pService.printAllByRecipeValue(
						searchCondition, searchValue, currentPage, recipeLimit);
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
					mv.setViewName("boardmanage/recipeList");
			} catch (Exception e) {
				mv.addObject("msg", e.toString()).setViewName("common/errorPage");
			}
			return mv;
		}
		
		// 수정
		@RequestMapping(value = "/recipemanage/modifyView.kh", method = RequestMethod.GET)
		public ModelAndView recipeModifyView(ModelAndView mv
				, @RequestParam("page") Integer page
				,@RequestParam(value="loginId" ,required =false) String loginId
				, HttpSession session, HttpServletRequest request) {

			try {
				// 비정상적인 접근 체크
				Admin admin = (Admin) session.getAttribute("loginAdmin");
				if (admin == null) {
					System.out.println("수정창 접근 오류");
					request.setAttribute("msg", "정상적인 접근이 아닙니다.");
					request.setAttribute("url", "/");
					mv.setViewName("common/alert");
					return mv;
				}
				int recipeNo = (Integer) session.getAttribute("recipeNo");
				System.out.println("수정페이지 진입 글번호: " + recipeNo);
				Recipe recipe = pService.printRecipeByRNo(recipeNo);
//				System.out.println(rList.get);
				List<Ingradient> iList = pService.printIngByRNo(recipeNo);
				List<Order> oList = pService.printOrderByRNo(recipeNo);
				List<ComPhoto> cList = pService.printComByRNo(recipeNo);
				List<LargeCategory> lList = sService.printLargeCat();
				List<SmallCategory> sList = pService.printSmallCat();
				List<WhatRecipe> wList = pService.printWhat();

//				String bundle = "이름없음";
//				// 로그인 구현되면 세션에 있는 아이디로 바꿔줘야함
//				if (!iList.isEmpty()) {
//					bundle = iList.get(0).getIngBundleName();
//				}
//				System.out.println(iList);
//				System.out.println(oList);
//				mv.addObject("bundle", bundle);
				mv.addObject("wList", wList);
				mv.addObject("lList", lList);
				mv.addObject("sList", sList);
				mv.addObject("recipeNo", recipeNo);
				mv.addObject("recipe", recipe);
				mv.addObject("iList", iList);
				mv.addObject("oList", oList);
				mv.addObject("cList", cList);
				mv.setViewName("/boardmanage/recipeModify");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", "레시피수정페이지 조회 실패").setViewName("common/errorPage");
			}
			return mv;
		}
		
		//레시피수정
		@RequestMapping(value = "/recipemanage/modify.kh", method = RequestMethod.POST)
		public ModelAndView recipeModify(ModelAndView mv,
				@RequestParam(value = "recipeNo", required = false) Integer recipeNo,
				@RequestParam(value = "reuploadFile", required = false) MultipartFile reuploadFile,
				@RequestParam(value = "reouploadFile", required = false) List<MultipartFile> reouploadFile,
				@RequestParam(value = "recuploadFile", required = false) List<MultipartFile> recuploadFile,
				@RequestParam("page") Integer page, @ModelAttribute Recipe recipe, @ModelAttribute Order order,
				@ModelAttribute ComPhoto comPhoto, @ModelAttribute Ingradient ing, @ModelAttribute WhatRecipe what,
				HttpServletRequest request) {
			try {
				// 파일 삭제
				String thumbnailName = reuploadFile.getOriginalFilename();
				if (reuploadFile != null && !thumbnailName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savedPath = root + "\\ruploadFiles";
					File file = new File(savedPath + "\\" + recipe.getThumbnailRename());
					if (file.exists()) {
						file.delete();
					}
					// 파일다시저장
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
					String thumbnailRename = sdf.format(new Date(System.currentTimeMillis())) + "."
							+ thumbnailName.substring(thumbnailName.lastIndexOf(".") + 1);
					String thumbnailpath = savedPath + "\\" + thumbnailRename;
					reuploadFile.transferTo(new File(thumbnailpath));
					recipe.setThumbnailName(thumbnailName);
					recipe.setThumbnailRename(thumbnailRename);
					recipe.setThumbnailpath(thumbnailpath);
				}
				// 레시피저장
				int result = pService.modifyRecipe(recipe);
				// 재료찢기
				List<Ingradient> iList = new ArrayList<Ingradient>();
				for (int i = 0; i < ing.getIngAmount().split(",").length; i++) {
					Ingradient ingredient = new Ingradient();
					ingredient.setRecipeNo(ing.getRecipeNo());
					ingredient.setIngNo(ing.getIngNo().split(",")[i]);
					ingredient.setIngBundleName(ing.getIngBundleName());
					ingredient.setIngAmount(ing.getIngAmount().split(",")[i]);
					ingredient.setLargeCatId(ing.getLargeCatId().split(",")[i]);
					ingredient.setSmallCatId(ing.getSmallCatId().split(",")[i]);
					iList.add(ingredient);
				}
				// 오더찢기
				List<Order> oList = new ArrayList<Order>();
				for (int i = 0; i < order.getRecipeContents().split(",").length; i++) {
					Order ord = new Order();
					ord.setRecipeNo(order.getRecipeNo());
					ord.setOrederNo(order.getOrederNo().split(",")[i]);
					ord.setRecipeContents(order.getRecipeContents().split(",")[i]);
					// 이미지파일삭제
					String orderPhotoName = reouploadFile.get(i).getOriginalFilename();
					if (reouploadFile.get(i) != null && !orderPhotoName.equals("") && !orderPhotoName.equals(" ")) {
						System.out.println(1);
						String root = request.getSession().getServletContext().getRealPath("resources");
						String savedPath = root + "\\ruploadFiles";
//						System.out.println(order.getOrderPhotoRename().split(",")[i]);
//						File file = new File(savedPath + "\\" + order.getOrderPhotoRename().split(",")[i]);
//						if(file.exists()) {
//							file.delete();
//						}
						// 파일 다시저장
						SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
						String orderPhotoRename = sdf.format(new Date(System.currentTimeMillis())) + "ro" + i + "."
								+ orderPhotoName.substring(thumbnailName.lastIndexOf(".") + 1);
						String orderPhotopath = savedPath + "\\" + orderPhotoRename;
						reouploadFile.get(i).transferTo(new File(orderPhotopath));
						ord.setOrderPhotoName(orderPhotoName);
						ord.setOrderPhotoRename(orderPhotoRename);
						ord.setOrderPhotopath(orderPhotopath);
					}
					oList.add(ord);
				}
				// 완성사진찢기
				List<ComPhoto> cList = new ArrayList<ComPhoto>();
				for (int i = 0; i < comPhoto.getComPhotoNo().split(",").length; i++) {
					ComPhoto com = new ComPhoto();
					com.setRecipeNo(comPhoto.getRecipeNo());
					com.setComPhotoNo(comPhoto.getComPhotoNo().split(",")[i]);
					String comPhotoName = recuploadFile.get(i).getOriginalFilename();
					if (recuploadFile.get(i) != null && !comPhotoName.equals("")) {
						String root = request.getSession().getServletContext().getRealPath("resources");
						String savedPath = root + "\\ruploadFiles";
						SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
						String comPhotoRename = sdf.format(new Date(System.currentTimeMillis())) + "rc" + i + "."
								+ comPhotoName.substring(comPhotoName.lastIndexOf(".") + 1);
						String comPhotopath = savedPath + "\\" + comPhotoRename;
						recuploadFile.get(i).transferTo(new File(comPhotopath));
						com.setComPhotoName(comPhotoName);
						com.setComPhotoRename(comPhotoRename);
						com.setComPhotopath(comPhotopath);
					}
					cList.add(com);
				}
				for (int i = 0; i < cList.size(); i++) {
					int cresult = pService.modifyCom(cList.get(i));
				}

//				System.out.println(oList);
				// 재료저장
				for (int i = 0; i < iList.size(); i++) {
					int iresult = pService.modifyIng(iList.get(i));
				}
				// 요리순서 저장
				for (int i = 0; i < oList.size(); i++) {
					int oresult = pService.modifyOrder(oList.get(i));
				}
				mv.setViewName("redirect:/recipemanage/detail.kh?recipeNo=" + recipeNo);
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", "레시피 수정 실패").setViewName("common/errorPage");
			}

			return mv;
		}
		
		
		
		// 삭제
		@RequestMapping(value = "/recipemanage/remove.kh", method = RequestMethod.GET)
		public ModelAndView recipeRemove(ModelAndView mv,
				@RequestParam(value = "recipeNo", required = false) Integer recipeNo, HttpSession session,
				HttpServletRequest request) {

			try {
				String admin = String.valueOf(session.getAttribute("loginAdmin"));
				if (admin == null) {
					System.out.println("삭제창 로그인없이 접근");
					request.setAttribute("msg", "관리자만 삭제할 수 있습니다.");
					request.setAttribute("url", "/recipemanage/detail.kh?recipeNo=" + recipeNo);
					mv.setViewName("common/alert");
					return mv;
				}
				mv.addObject("recipeNo", recipeNo);
				int result = pService.removeRecipe(recipeNo);
				request.setAttribute("msg", "레시피가 삭제 되었습니다.");
				request.setAttribute("url", "/recipemanage/list.kh");
				mv.setViewName("common/alert");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", "레시피 삭제 실패").setViewName("common/errorPage");
			}

			return mv;
		}
		
}
