package com.kh.fivechef.fridge.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.fridge.domain.Fridge;
import com.kh.fivechef.fridge.service.FridgeService;
import com.kh.fivechef.fridge.store.FridgeStore;

@Service
public class FridgeServiceImpl implements FridgeService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private FridgeStore fStore;
	
	
	@Override
	public int registerFridge(Fridge fridge) {
		int result = fStore.insertFridge(session, fridge);
		return 0;
	}


	@Override
	public List<Fridge> printAllFridge() {
		List<Fridge> fList = fStore.selectAllFridge(session);
		return fList;
	}

}
