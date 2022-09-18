package com.kh.fivechef.fridge.service;

import java.util.List;

import com.kh.fivechef.fridge.domain.Fridge;

public interface FridgeService {
	public int registerFridge(Fridge fridge);
	public List<Fridge> printAllFridge();
}
