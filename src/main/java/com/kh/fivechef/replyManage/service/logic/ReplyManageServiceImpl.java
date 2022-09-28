package com.kh.fivechef.replyManage.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.boardManage.store.BoardManageStore;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.replyManage.service.ReplyManageService;
import com.kh.fivechef.replyManage.store.ReplyManageStore;

@Service
public class ReplyManageServiceImpl implements ReplyManageService{
	
	@Autowired
	private ReplyManageStore rStore;
	
	@Autowired
	private SqlSession session;
	
	
	@Override
	public int getTotalCommCount(String searchCondition, String searchValue) {
		int totalCount = rStore.selectTotalCommCount(session, searchCondition, searchValue);
		return totalCount;
	}
	
	@Override
	public List<CReply> printAllCommReply(int currentPage, int replyLimit) {
		List<CReply> cList = rStore.selectAllCommReply(session, currentPage, replyLimit);
		return cList;
	}

	@Override
	public List<CReply> printAllByCReplyValue(String searchCondition, String searchValue, int currentPage,
			int replyLimit) {
		List<CReply> cList = rStore.selectAllByCReplyValue(session, searchCondition, searchValue, currentPage, replyLimit);
		return cList;
	}

	@Override
	public Community printOneByCReplyNo(Integer communityNo) {
		Community community = rStore.selectOneByCReplyNo(session, communityNo);
		int result = 0;
		if(community != null) {
			result = rStore.updatePostCount(session, communityNo);
		}
		return community;
	}

	@Override
	public List<CReply> printAllCReply(int refCommunityNo) {
		List<CReply> rList = rStore.selectAllCReply(session, refCommunityNo);
		return rList;
	}

	@Override
	public int registCommunityReply(CReply cReply) {
		int result = rStore.insertCReply(session, cReply);
		return result;
	}

	@Override
	public int modifyCommunityReply(CReply cReply) {
		int result = rStore.modifyCReply(session, cReply);
		return result;
	}

	@Override
	public int deleteCommunityReply(Integer replyNo) {
		int result = rStore.deleteCReply(session, replyNo);
		return result;
	}
	
}
