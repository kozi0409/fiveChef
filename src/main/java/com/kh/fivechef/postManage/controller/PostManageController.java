package com.kh.fivechef.postManage.controller;

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

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.postManage.service.PostManageService;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

@Controller
public class PostManageController {
	
	@Autowired
	private PostManageService pService;

	
	// community 에 대한 코드 먼저
	
	
//	@RequestMapping(value="/postmanage/regist.kh", method=RequestMethod.POST)
//	public ModelAndView registCommunity(
//			ModelAndView mv,
//			@ModelAttribute Community community, HttpServletRequest request) {
//		try {
//			int result = pService.registPost(community);
//			request.setAttribute("msg","게시글 등록이 완료되었습니다.");
//			request.setAttribute("url","/postmanage/list.kh");
//			mv.setViewName("/common/alert");
//		} catch (Exception e){
//			mv.addObject("msg", "게시글 등록 실패");
//			mv.setViewName("/common/errorPage");
//		}
//		return mv;
//	}
	
	// 전체 게시글 리스트
	@RequestMapping(value = "/postmanage/list.kh", method = RequestMethod.GET)
	public ModelAndView postManageView(
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
		mv.setViewName("postmanage/postList");
		return mv;
	}
	
	//글 누르면 상세 조회
	@RequestMapping(value="/postmanage/detail.kh", method=RequestMethod.GET)
	public ModelAndView printPostDetail(
			ModelAndView mv
			, @RequestParam("communityNo") Integer communityNo
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
				mv.setViewName("postmanage/postList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 수정화면
	@RequestMapping(value="/postmanage/modifyView.kh", method=RequestMethod.GET)
	public ModelAndView postManageModifyView(ModelAndView mv
			, @RequestParam("communityNo") Integer communityNo, @RequestParam("page") int page) {
		try {
			Community community = pService.printOneByPostNo(communityNo);
			mv.addObject("community", community);
			mv.setViewName("postmanage/postModify");
			mv.addObject("page", page);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 수정
	@RequestMapping(value="/postmanage/modify.kh", method=RequestMethod.POST)
	public ModelAndView postManageModify(ModelAndView mv
			, @ModelAttribute Community community, @RequestParam("page")Integer page, HttpServletRequest request) {
		try {
			int result = pService.modifyPost(community);
			if(result > 0) {
				request.setAttribute("msg", "(관리자) 게시글 수정이 완료되었습니다.");
				request.setAttribute("url", "/postmanage/postlist.kh");
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
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	
	// 레시피에 대한 코드
	
	// 리스트
		@RequestMapping(value = "/recipemanage/list.kh", method = RequestMethod.GET)
		public ModelAndView recipeManageView(
				ModelAndView mv
				,@RequestParam(value="category" , required=false) String listValue
				,@RequestParam(value="page",required = false) Integer page 
				) {
			int currentPage = (page != null) ? page : 1;
			int totalCount = pService.countAllRecipe();
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
			List<Recipe> rList = pService.printAllRecipe(listValue,currentPage,recipeLimit);
			if(!rList.isEmpty()) {
				mv.addObject("rList",rList);
			}
			mv.addObject("startNavi",startNavi);
			mv.addObject("endNavi",endNavi);
			mv.addObject("maxPage",maxPage);
			mv.addObject("currentPage",currentPage);
			mv.addObject("urlVal","list");
			mv.addObject("listValue",listValue);
			mv.addObject("totalCount",totalCount);
			mv.setViewName("postmanage/recipeList");
			
			return mv;
		}
	
		
		// 상세 페이지 조회
		@RequestMapping(value="/recipemanage/detail.kh",method=RequestMethod.GET)
		public ModelAndView recipeManageDetailView(
				ModelAndView mv
				,@RequestParam(value="category" , required=false) String listValue
				,@RequestParam(value="page" ,required = false) Integer page
				,@RequestParam("recipeNo") Integer recipeNo
				,@ModelAttribute Recipe recipeid
				,@ModelAttribute Order order
				,@ModelAttribute ComPhoto comPhoto
				,@ModelAttribute Ingradient ing
				,HttpSession session) {
			try {
				Like like = new Like();
				like.setUserId(recipeid.getUserId());
				like.setRecipeNo(recipeNo);
//				System.out.println(recipeid.getUserId());
				//레시피 좋아요 카운트
				int result = pService.checkLikeId(like);
				//레시피정보 출력
				Recipe recipe = pService.printOneByNo(recipeNo);
				session.setAttribute("recipeNo",recipe.getRecipeNo());
				
				//재료출력
				List<Ingradient> iList = pService.printAllIng(recipeNo);
				String bundle = "재료없음";
				//로그인 구현되면 세션에 있는 아이디로 바꿔줘야함
				
				
				
				if(!iList.isEmpty()) {
					bundle = iList.get(0).getIngBundleName();
				}
				//요리순서 출력
				List<Order> oList = pService.printAllOrder(recipeNo);
				//완성사진 출력
				List<ComPhoto> cList = pService.printAllComPhoto(recipeNo);
				
				mv.addObject("result",result);
				mv.addObject("like",like);
				mv.addObject("urlVal","detail");
				mv.addObject("listValue",listValue);
				mv.addObject("page", page);
				mv.addObject("cList",cList);
				mv.addObject("oList",oList);
				mv.addObject("iList",iList);
				mv.addObject("bundle",bundle);
				mv.addObject("recipe",recipe);
				mv.setViewName("postmanage/recipeDetail");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg","레시피조회 실패").setViewName("common/errorPage");
			}
			
			
			return mv;
		}
		
		
		
		
		
		
		
		
		///////수정사항 반영
		
		
}
