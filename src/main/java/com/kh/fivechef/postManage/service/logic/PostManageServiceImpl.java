package com.kh.fivechef.postManage.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.postManage.service.PostManageService;
import com.kh.fivechef.postManage.store.PostManageStore;
@Service
public class PostManageServiceImpl implements PostManageService{
	@Autowired
	private PostManageStore pStore;
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int getTotalPostCount(String searchCondition, String searchValue) {
		int totalCount = pStore.selectTotalPostCount(session, searchCondition, searchValue);
		return totalCount;
	}
	
	@Override
	public List<Community> printAllPost(int currentPage, int communityLimit) {
		List<Community> cList = pStore.selectAllPost(session, currentPage, communityLimit);
		return cList;
	}

	@Override
	public Community printOneByPostNo(Integer communityNo) {
		Community community = pStore.selectOneByPostNo(session, communityNo);
		int result = 0;
		if(community != null) {
			result = pStore.updatePostCount(session, communityNo);
		}
		return community;
	}

	@Override
	public int removeOneByPostNo(int communityNo) {
		int result = pStore.deleteOneByPostNo(session, communityNo);
		return result;
	}

	@Override
	public int getPostTotalCount(String searchCondition, String searchValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Community> printAllByPostValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
