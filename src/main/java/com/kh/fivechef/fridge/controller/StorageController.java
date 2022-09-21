package com.kh.fivechef.fridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.service.StorageService;

@Controller
public class StorageController {
	@Autowired
	private StorageService sService;
	
	@RequestMapping(value="/fridge/storage.kh", method=RequestMethod.GET)
	public ModelAndView showStoragePage(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName) {
		List<LargeCategory> lList = sService.printLargeCat();
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.addObject("lList", lList);
		mv.setViewName("fridge/myMain");
		return mv;
	}
	
	@RequestMapping(value="/fridge/changeSmall.kh", method=RequestMethod.GET)
	public ModelAndView showSmallCat(ModelAndView mv
			,@RequestParam("largeCatId") String largeCatId
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") Integer fridgeName){
		System.out.println(largeCatId);
		List<SmallCategory> sList = sService.printSmallCat(largeCatId);
		System.out.println(sList);
		mv.addObject("sList", sList);
		mv.setViewName("redirect:/fridge/storage.kh?fridgeNo="+fridgeNo+"&fridgeName="+fridgeName);
		return mv;
	}
	
}
