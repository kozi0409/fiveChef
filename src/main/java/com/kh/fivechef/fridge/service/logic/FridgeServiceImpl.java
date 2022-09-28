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
		return result;
	}

	@Override
	public int modifyFridge(Fridge fridge) {
		int result = fStore.updateFridge(session, fridge);
		return result;
	}

	@Override
	public List<Fridge> printAllFridge(String userId) {
		List<Fridge> fList = fStore.selectAllFridge(session, userId);
		return fList;
	}


	@Override
	public int removeOneByNo(Integer fridgeNo) {
		int result = fStore.deleteOneByNo(session, fridgeNo);
		return result;
	}


	@Override
	public Fridge printOneByNo(Integer fridgeNo) {
		Fridge fridge = fStore.selectOneByNo(session, fridgeNo);
		return fridge;
	}



	
}
