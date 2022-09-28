package com.kh.fivechef.fridge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SelectBox;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.domain.Storage;
import com.kh.fivechef.fridge.service.StorageService;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;
import com.kh.fivechef.recipe.service.RecipeService;

@Controller
public class StorageController {
	@Autowired
	private StorageService sService;
	@Autowired
	private RecipeService rService;
	
	// 민석님 공유
	// 칸 페이지
	@RequestMapping(value="/fridge/storage.kh", method=RequestMethod.GET)
	public ModelAndView showStoragePage(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName){
		try {
			List<LargeCategory> lList = sService.printLargeCat();
			List<SmallCategory> sList = sService.printSmallCat("A1");
			List<Storage> stList = sService.printStorage(fridgeNo);
//			String [] searching = new String[100];
//			for(int i = 0; i < stList.size(); i++) {
////				System.out.println(i);
//				String subIngred = stList.get(i).getIngredBundle();
////				System.out.println(subIngred);
//				if (subIngred != null || subIngred != "") {
//					subIngred.substring(0);
//					searching = subIngred.split(",");
//					
//				}
//			}
////			System.out.println(searching);
//			for(int i = 0; i < searching.length; i++) {
////				System.out.println(searching[i]);
//			}
			
			mv.addObject("fridgeNo", fridgeNo);
			mv.addObject("fridgeName", fridgeName);
			mv.addObject("lList", lList);
			mv.addObject("sList", sList);
			mv.addObject("stList", stList);
			mv.setViewName("fridge/myMain");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("fridge/errorPage");
		}
		return mv;
	}
	// 민석님 공유
	// 칸 페이지 소분류
	@RequestMapping(value="/fridge/changeSmall.kh", method=RequestMethod.GET)
	public ModelAndView showSmallCat(ModelAndView mv
			,@RequestParam("largeCatId") String largeCatId
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("selectBoxNo") Integer selectBoxNo
			,@RequestParam("storageNo") Integer storageNo){
		List<LargeCategory> lList = sService.printLargeCat();
		List<SmallCategory> sList = sService.printSmallCat(largeCatId);
		SelectBox selectBox = new SelectBox(storageNo, largeCatId, selectBoxNo);
		int result = sService.registSelectValue(selectBox);
		List<Storage> stList = sService.printStorage(fridgeNo);
		
		
		mv.addObject("sList", sList);
		mv.addObject("lList", lList);
		mv.addObject("stList", stList);
		mv.addObject("largeCatId", largeCatId);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("selectBoxNo", selectBoxNo);
		mv.addObject("selectBox", selectBox);
		mv.setViewName("fridge/myMain");
		return mv;
	}
	
	//칸 생성
	@RequestMapping(value="/fridge/createStorage.kh", method=RequestMethod.POST)
	public ModelAndView storageCreate(ModelAndView mv
			,@ModelAttribute Storage storage
			,@RequestParam("largeCatId") String largeCatId
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName) {
		int result = sService.registStorage(storage);
		List<LargeCategory> lList = sService.printLargeCat();
		List<SmallCategory> sList = sService.printSmallCat(largeCatId);
		mv.addObject("sList", sList);
		mv.addObject("lList", lList);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("largeCatId", largeCatId);
		mv.setViewName("redirect:/fridge/storage.kh");
		return mv;
	}
	
	//칸 이름 수정
	@RequestMapping(value="/fridge/modifyStorage.kh", method=RequestMethod.POST)
	public ModelAndView storageModify(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("storageNo") Integer storageNo
			,@RequestParam("storageName") String storageName) {
		Storage storage = new Storage(storageNo, storageName);
		int result = sService.modifyStorage(storage);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.setViewName("redirect:/fridge/storage.kh");
		return mv;
	}
	
	//칸 삭제
	@RequestMapping(value="/fridge/deleteStorage.kh", method=RequestMethod.POST)
	public ModelAndView storageRemove(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("stSelectNo") Integer stSelectNo
			) {
		List<LargeCategory> lList = sService.printLargeCat();
		int result = sService.removeStorage(fridgeNo, stSelectNo);
		mv.addObject("lList", lList);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("stSelectNo", stSelectNo);
		mv.setViewName("redirect:/fridge/storage.kh");
		return mv;
	}
	
	//재료 등록
	@RequestMapping(value="/fridge/registIngred.kh", method=RequestMethod.POST)
	public ModelAndView IngredRegist(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("stSelectNo") Integer stSelectNo
			,@RequestParam("storageNo") Integer storageNo
			,@RequestParam("ingredBundle") String ingredBundle) {
		try {
			Storage storage = new Storage(storageNo, fridgeNo, stSelectNo, ingredBundle);
			int result = sService.registIngred(storage);
			mv.addObject("fridgeNo", fridgeNo);
			mv.addObject("fridgeName", fridgeName);
			mv.addObject("stSelectNo", stSelectNo);
			mv.addObject("storageNo", storageNo);
			mv.addObject("ingredBundle", ingredBundle);
			mv.setViewName("redirect:/fridge/storage.kh");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("fridge/errorPage");
		}  
		return mv;
		
	}
	
	// 재료 삭제
	@RequestMapping(value="/fridge/deleteIngred.kh", method=RequestMethod.POST)
	public ModelAndView IngredRemove(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("stSelectNo") Integer stSelectNo
			,@RequestParam("storageNo") Integer storageNo) {
		Storage storage = new Storage(storageNo, fridgeNo, stSelectNo);
		int result = sService.deleteIngred(storage);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("stSelectNo", stSelectNo);
		mv.addObject("storageNo", storageNo);
		mv.setViewName("redirect:/fridge/storage.kh");
		return mv;
	}
	
	//재료 검색
	@RequestMapping(value = "/recipe/searchIngMyFridge.kh", method = RequestMethod.POST)
	public ModelAndView searchIngred(ModelAndView mv,
			@RequestParam(value = "ingredBundle", required = false) String ingredBundle,
			@RequestParam(value = "category", required = false) String listValue,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "whatRecipe", required = false) String whatRecipe, 
			HttpServletRequest request,
			HttpSession session) {
		try {
			
			//지호님 레시피 검색 참고
			
			//재료목록 null 체크
			String subIngred = ingredBundle;
			subIngred.substring(0);
//			System.out.println(ingredBundle);
//			System.out.println(1);
			if (ingredBundle == "") {
				request.setAttribute("msg", "입력값이 없습니다.");
				request.setAttribute("url", "/recipe/recipeList.kh");
				mv.setViewName("common/alert");
				return mv;
			}
			
//			System.out.println(2);
			String[] searching = subIngred.split(",");
//			System.out.println(3);
			session.setAttribute("postingid", ingredBundle);
//			if(session.getAttribute("postingid") == null) {
//				System.out.println(4);
//			}
			int currentPage = (page != null) ? page : 1;
			int totalCount = rService.countAllRecipe(searching, whatRecipe, listValue);
			int recipeLimit = 18;
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
			// 요리방법종류인원난이도시간출력
			List<WhatRecipe> wList = rService.printWhat();
			// 재료 카테고리 출력
			List<LargeCategory> lList = sService.printLargeCat();
			List<SmallCategory> sList = rService.printSmallCat();
			List<Recipe> rList = rService.printAllRecipe(searching,whatRecipe, listValue, currentPage, recipeLimit);
			
			if (!rList.isEmpty()) {
				mv.addObject("rList", rList);
			}
			mv.addObject("searching",searching);
			mv.addObject("whatRecipe", whatRecipe);
			mv.addObject("lList", lList);
			mv.addObject("sList", sList);
			mv.addObject("wList", wList);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("urlVal", "recipeList");
			mv.addObject("listValue", listValue);
			mv.addObject("totalCount", totalCount);
			mv.setViewName("recipe/listView");

		} catch (Exception e) {
			// TODO: handle exception
		}

		return mv;
	}
	
	
}
