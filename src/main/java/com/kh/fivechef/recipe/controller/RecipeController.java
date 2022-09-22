package com.kh.fivechef.recipe.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.service.RecipeService;
import com.kh.fivechef.user.domain.User;
//hms2dd
@Controller
public class RecipeController {
	@Autowired
	private RecipeService rService;
	
	@RequestMapping(value="/recipe/writeView.kh", method = RequestMethod.GET)
	public String showRecipeWrite() {
		return "recipe/recipeWriteFormcopy";
	}
	
	//레시피 등록
	@RequestMapping(value="/recipe/recipeRegister.kh" , method= RequestMethod.POST)
	public ModelAndView recipeRegist(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Ingradient ing
			,@ModelAttribute Order order
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,@RequestParam(value="ouploadFile", required=false) List<MultipartFile> ouploadFile
			,@RequestParam(value="cuploadFile", required=false) List<MultipartFile> cuploadFile
			,HttpServletRequest request) {
			System.out.println(recipe.getUserId());
			
			//썸네일용 사진 업로드
			//사진업로드 구문을 객체로 만들어서 사용해보자
		try {
			String thumbnailName = uploadFile.getOriginalFilename();
			///////////////////////////경로,파일이름 설정
			if(!thumbnailName.equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\ruploadFiles";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhss");
				String thumbnailRename = sdf.format(new Date(System.currentTimeMillis()))+"." //시간
						+thumbnailName.substring(thumbnailName.lastIndexOf(".")+1); //확장자명
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				uploadFile.transferTo(new File(savePath+"\\"+thumbnailRename));//저장할때는 rename으로 저장 실제경로에 저장
				String thumbnailpath = savePath+"\\"+thumbnailRename;
				//파일을 ruploadFile경로에 저장하는 메소드
				recipe.setThumbnailName(thumbnailName);
				recipe.setThumbnailRename(thumbnailRename);
				recipe.setThumbnailpath(thumbnailpath);
			}
			
			//레시피 저장
			int result = rService.registerRecipe(recipe);
			
			
			//재료저장 INGRADIENT_TBL
			//list는 stream으로 사용해서 코드 단축 시킬 수 있음
			List<Ingradient> iList = new ArrayList<Ingradient>();
			for(int i = 0; i<ing.getIngAmount().split(",").length;i++) {
				Ingradient ingredient = new Ingradient();
				ingredient.setIngBundleName(ing.getIngBundleName());
				ingredient.setIngAmount(ing.getIngAmount().split(",")[i]);
				ingredient.setLargeCatId(ing.getLargeCatId().split(",")[i]);
				ingredient.setSmallCatId(ing.getSmallCatId().split(",")[i]);
				iList.add(ingredient);
			}
//			System.out.println(iList.get(0));
			for(int i = 0; i<iList.size();i++) {
				int result2=rService.registerIngradient(iList.get(i));
			}
			
			//order저장 ORDER_TBL
			List<Order> oList = new ArrayList<Order>();
			for(int i = 0; i<order.getRecipeContents().split(",").length;i++) {
				Order ord = new Order();
				ord.setRecipeContents(order.getRecipeContents().split(",")[i]);
				String orderPhotoName = ouploadFile.get(i).getOriginalFilename();
				if(!orderPhotoName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\ruploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhss");
					String orderPhotoRename = sdf.format(new Date(System.currentTimeMillis()))+"o"+i+"." //시간
							+orderPhotoName.substring(orderPhotoName.lastIndexOf(".")+1); //확장자명
					File file = new File(savePath);
					if(!file.exists()) {
						file.mkdir();
					}
					ouploadFile.get(i).transferTo(new File(savePath+"\\"+orderPhotoRename));//저장할때는 rename으로 저장 실제경로에 저장
					String orderPhotopath = savePath+"\\"+orderPhotoRename;
					//파일을 ruploadFile경로에 저장하는 메소드
					ord.setOrderPhotoName(orderPhotoName);
					ord.setorderPhotoRename(orderPhotoRename);
					ord.setOrderPhotopath(orderPhotopath);
				}
				oList.add(ord);
			}
			for(int i = 0; i<oList.size();i++) {
				int result3 = rService.registerOrder(oList.get(i));
			}
			
			// 완성사진저장 COM_PHOTO_TBL
			List<ComPhoto> cList = new ArrayList<ComPhoto>();
//			System.out.println(cuploadFile.size());
			for(int i = 0; i<cuploadFile.size();i++) {
				ComPhoto cPhoto = new ComPhoto();
				String comPhotoName = cuploadFile.get(i).getOriginalFilename();
				if(!comPhotoName.equals("")) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\ruploadFiles";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhss");
					String comPhotoRename = sdf.format(new Date(System.currentTimeMillis()))+"c"+i+"." //시간
							+comPhotoName.substring(comPhotoName.lastIndexOf(".")+1); //확장자명
					File file = new File(savePath);
					if(!file.exists()) {
						file.mkdir();
					}
					cuploadFile.get(i).transferTo(new File(savePath+"\\"+comPhotoRename));//저장할때는 rename으로 저장 실제경로에 저장
					String comPhotopath = savePath+"\\"+comPhotoRename;
					//파일을 ruploadFile경로에 저장하는 메소드
					cPhoto.setComPhotoName(comPhotoName);
					cPhoto.setComPhotoRename(comPhotoRename);
					cPhoto.setComPhotopath(comPhotopath);
				}
				cList.add(cPhoto);
			}
			for(int i = 0; i<cList.size();i++) {
				int result4 = rService.registerComPhoto(cList.get(i));
			}
			
			request.setAttribute("msg", "레시피 등록이 완료되었습니다.");
			//성공시 메인페이지로 이동하도록 변경
			request.setAttribute("url", "/");
			mv.setViewName("common/alert");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("msg","레시피등록 실패").setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	//레시피 리스트
	@RequestMapping(value="/recipe/recipeList.kh",method = RequestMethod.GET)
	public ModelAndView recipeAllListView(
			ModelAndView mv
			,@RequestParam(value="category" , required=false) String listValue
			,@RequestParam(value="page",required = false) Integer page 
			) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = rService.countAllRecipe(); 
		int recipeLimit=18;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/recipeLimit +0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit+1;
		endNavi = startNavi + naviLimit -1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Recipe> rList = rService.printAllRecipe(listValue,currentPage,recipeLimit);
		//store에서 hashmap사용하면 데이터 정상 반영됨
//		System.out.println(totalCount);
		if(!rList.isEmpty()) {
			mv.addObject("rList",rList);
		}
		mv.addObject("startNavi",startNavi);
		mv.addObject("endNavi",endNavi);
		mv.addObject("maxPage",maxPage);
		mv.addObject("currentPage",currentPage);
		mv.addObject("urlVal","recipeList");
		mv.addObject("listValue",listValue);
		mv.addObject("totalCount",totalCount);
		mv.setViewName("recipe/listView");
		
		return mv;
	}
	
	//레시피 뷰어
	@RequestMapping(value="/recipe/recipeDetailView.kh",method =RequestMethod.GET)
	public ModelAndView recipeDetailView(
			ModelAndView mv
			,@RequestParam(value="category" , required=false) String listValue
			,@RequestParam(value="page" ,required = false) Integer page
			,@RequestParam("recipeNo") Integer recipeNo
//			,@ModelAttribute User user
			,@ModelAttribute Order order
			,@ModelAttribute ComPhoto comPhoto
			,@ModelAttribute Ingradient ing
			,HttpSession session) {
		try {
			User user =(User) (session.getAttribute("loginUser"));
			System.out.println(user);
//			Like like = new Like();
//			like.setUserId(user.getUserId());
//			like.setRecipeNo(recipeNo);
//			System.out.println(recipeid.getUserId());
			//레시피 좋아요 카운트
//			int result = rService.checkLikeId(like);
			//레시피정보 출력
			Recipe recipe = rService.printOneByNo(recipeNo);
			//삭지하기위해 보드넘버 저장
//			session.setAttribute("recipeNo",recipe.getRecipeNo());
			//재료출력
			List<Ingradient> iList = rService.printAllIng(recipeNo);
			String bundle = "재료없음";
			//로그인 구현되면 세션에 있는 아이디로 바꿔줘야함
			if(!iList.isEmpty()) {
				bundle = iList.get(0).getIngBundleName();
			}
			//요리순서 출력
			List<Order> oList = rService.printAllOrder(recipeNo);
			//완성사진 출력
			List<ComPhoto> cList = rService.printAllComPhoto(recipeNo);
//			mv.addObject("result",result);
//			mv.addObject("like",like);
			mv.addObject("urlVal","recipeList");
			mv.addObject("listValue",listValue);
			mv.addObject("page", page);
			mv.addObject("cList",cList);
			mv.addObject("oList",oList);
			mv.addObject("iList",iList);
			mv.addObject("bundle",bundle);
			mv.addObject("recipe",recipe);
			mv.setViewName("recipe/recipeDetailView");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg","레시피조회 실패").setViewName("common/errorPage");
		}
		
		
		return mv;
	}
	
	//좋아요 등록
	@RequestMapping(value="/recipe/recipeLike.kh",method =RequestMethod.POST)
	public String recipeLikeUpdate(
			ModelAndView mv
			,@RequestParam(value="userId", required = false) String userId
			,@RequestParam(value="recipeNo",required=false) Integer recipeNo
			,@RequestParam(value="category" , required=false) String listValue
			,@RequestParam(value="page" ,required = false) Integer page
			,HttpServletRequest request) {
		try {
			Like like = new Like();
			like.setUserId(userId);
			like.setRecipeNo(recipeNo);
			int result = rService.likeUp(like);
			return "redirect:/recipe/recipeDetailView.kh?recipeNo="+recipeNo+"&page="+page+"&category="+listValue+"&userId="+userId;
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg", "로그인을 해주세요");
			request.setAttribute("url", "/recipe/recipeDetailView.kh?recipeNo="+recipeNo+"&page="+page+"&category="+listValue+"&userId="+userId);
			return "common/alert";
		}
	}
	
	//좋아요 삭제
	@RequestMapping(value="/recipe/recipeLikeDel.kh",method =RequestMethod.POST)
	public String recipeLikeRemove(
			ModelAndView mv
			,@RequestParam(value="userId", required = false) String userId
			,@RequestParam(value="recipeNo",required=false) Integer recipeNo
			,@RequestParam(value="category" , required=false) String listValue
			,@RequestParam(value="page" ,required = false) Integer page
			,HttpServletRequest request) {
		try {
			Like like = new Like();
			like.setUserId(userId);
			like.setRecipeNo(recipeNo);
			int result = rService.likeDown(like);
			return "redirect:/recipe/recipeDetailView.kh?recipeNo="+recipeNo+"&page="+page+"&category="+listValue+"&userId="+userId;
		} catch (Exception e) {
			request.setAttribute("msg", "로그인을 해주세요");
			request.setAttribute("url", "/recipe/recipeDetailView.kh?recipeNo="+recipeNo+"&page="+page+"&category="+listValue+"&userId="+userId);
			return "common/alert";
		}
	}
	
	@RequestMapping(value="/recipe/recipeModifyView.kh",method =RequestMethod.GET)
	public ModelAndView recipeModifyView(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Order order
			,@ModelAttribute ComPhoto comPhoto
			,@ModelAttribute Ingradient ing) {
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/recipe/recipeModify.kh",method =RequestMethod.GET)
	public ModelAndView recipeModify(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Order order
			,@ModelAttribute ComPhoto comPhoto
			,@ModelAttribute Ingradient ing) {
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/recipe/recipeRemove.kh",method =RequestMethod.POST)
	public ModelAndView recipeRemove(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Order order
			,@ModelAttribute ComPhoto comPhoto
			,@ModelAttribute Ingradient ing) {
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/recipe/addRecipe.kh",method =RequestMethod.POST)
	public ModelAndView addRecipeReply(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Order order
			,@ModelAttribute ComPhoto comPhoto
			,@ModelAttribute Ingradient ing) {
		
		
		
		return mv;
	}
}
