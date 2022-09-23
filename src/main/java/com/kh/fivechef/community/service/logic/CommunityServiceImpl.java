package com.kh.fivechef.community.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.community.domain.CReply;
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
	public int getTotalFCount(String searchCondition, String searchValue) {
		int totalCount = cStore.selectTotalFCount(session, searchCondition, searchValue);
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

	@Override
	public List<Community> printAllByValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit) {
		List<Community> cList = cStore.selectAllByValue(session, searchCondition, searchValue, currentPage, communityLimit);
		return cList;
	}

	@Override
	public int registReply(CReply cReply) {
		int result = cStore.insertReply(session, cReply);
		return result;
	}

	@Override
	public int modifyReply(CReply cReply) {
		int result = cStore.updateReply(session, cReply);
		return result;
	}

	@Override
	public int removeReply(Integer replyNo) {
		int result = cStore.deleteReply(session, replyNo);
		return result;
	}

	@Override
	public List<CReply> printAllReply(Integer refCommunityNo) {
		List<CReply> rList = cStore.selectAllReply(session, refCommunityNo);
		return rList;
	}

	@Override
	public List<Community> printAllSaleBoard(int currentPage, int communityLimit) {
		List<Community> cList = cStore.selectAllSaleBoard(session, currentPage, communityLimit);
		return cList;
	}

	@Override
	public int getTotalSCount(String searchCondition, String searchValue) {
		int totalCount = cStore.selectTotalSCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Community> printSaleBoardByValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit) {
		List<Community> cList = cStore.selectSaleBoardByValue(session, searchCondition, searchValue, currentPage, communityLimit);
		return cList;
	}
	
	
}
