package com.kh.fivechef.fridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.fivechef.fridge.service.StorageService;

@Controller
public class StorageController {
//	@Autowired
//	private StorageService sService;
	
	@RequestMapping(value="/fridge/storage.kh", method=RequestMethod.GET)
	public String showStoragePage() {
		return "fridge/myStorage";
	}
	
	
	
}
