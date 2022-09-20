package com.kh.fivechef.fridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.fridge.service.StorageService;

@Controller
public class StorageController {
//	@Autowired
//	private StorageService sService;
	
	@RequestMapping(value="/fridge/storage.kh", method=RequestMethod.GET)
	public ModelAndView showStoragePage(ModelAndView mv
			,@RequestParam("fridgeNo") Integer fridgeNo
			,@RequestParam("fridgeName") String fridgeName) {
		mv.addObject("fridgeNo", fridgeNo);
		mv.addObject("fridgeName", fridgeName);
		mv.setViewName("fridge/myMain");
		return mv;
	}
	
	
	
}
