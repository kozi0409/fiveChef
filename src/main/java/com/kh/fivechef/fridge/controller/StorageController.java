package com.kh.fivechef.fridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.domain.Storage;
import com.kh.fivechef.fridge.service.StorageService;

@Controller
public class StorageController {
	@Autowired
	private StorageService sService;
	// 민석님 공유
	@RequestMapping(value="/fridge/storage.kh", method=RequestMethod.GET)
	public ModelAndView showStoragePage(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName) {
		List<LargeCategory> lList = sService.printLargeCat();
		List<SmallCategory> sList = sService.printSmallCat("A1");
		List<Storage> stList = sService.printStorage(fridgeNo);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("lList", lList);
		mv.addObject("sList", sList);
		mv.addObject("stList", stList);
		mv.setViewName("fridge/myMain");
		return mv;
	}
	// 민석님 공유
	@RequestMapping(value="/fridge/changeSmall.kh", method=RequestMethod.GET)
	public ModelAndView showSmallCat(ModelAndView mv
			,@RequestParam("largeCatId") String largeCatId
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("jNo") Integer jNo){
		List<LargeCategory> lList = sService.printLargeCat();
		List<SmallCategory> sList = sService.printSmallCat(largeCatId);
		List<Storage> stList = sService.printStorage(fridgeNo);
		mv.addObject("sList", sList);
		mv.addObject("lList", lList);
		mv.addObject("stList", stList);
		mv.addObject("largeCatId", largeCatId);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("jNo", jNo);
		mv.setViewName("fridge/myMain");
		return mv;
	}
	
	@RequestMapping(value="/fridge/createStorage.kh", method=RequestMethod.POST)
	public ModelAndView createStorage(ModelAndView mv
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
	
	@RequestMapping(value="/fridge/deleteStorage.kh", method=RequestMethod.POST)
	public ModelAndView listStorageView(ModelAndView mv
			,@RequestParam("largeCatId") String largeCatId
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName
			,@RequestParam("jNo") Integer jNo) {
		List<LargeCategory> lList = sService.printLargeCat();
		List<SmallCategory> sList = sService.printSmallCat(largeCatId);
		List<Storage> stList = sService.printStorage(fridgeNo);
		int result = sService.removeStorage(stList);
		mv.addObject("sList", sList);
		mv.addObject("lList", lList);
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("largeCatId", largeCatId);
		mv.addObject("jNo", jNo);
		mv.setViewName("redirect:/fridge/storage.kh");
		return mv;
	}
}
