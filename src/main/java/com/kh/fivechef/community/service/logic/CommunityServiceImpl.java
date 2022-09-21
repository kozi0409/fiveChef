package com.kh.fivechef.community.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.community.service.CommunityService;
import com.kh.fivechef.community.store.CommunityStore;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	private CommunityStore cStore;
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int registCommunity(Community community) {
		int result = cStore.insertCommunity(session, community);
		return result;
	}

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = cStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Community> printAllCommunity(int currentPage, int communityLimit) {
		List<Community> cList = cStore.selectAllCommunity(session, currentPage, communityLimit);
		return cList;
	}

	@Override
	public Community printOneByNo(Integer communityNo) {
		Community community = cStore.selectOneByNo(session, communityNo);
		int result = 0;
		if(community != null) {
			result = cStore.updateCommunityCount(session, communityNo);
		}
		return community;
	}

	@Override
	public int removeCommunity(int communityNo) {
		int result = cStore.deleteCommunity(session, communityNo);
		return result;
	}

	@Override
	public int modifyCommunity(Community community) {
		int result = cStore.updateCommunity(session, community);
		return result;
	}
	
	
}
