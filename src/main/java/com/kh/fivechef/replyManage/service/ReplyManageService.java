package com.kh.fivechef.replyManage.service;

import java.util.List;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;

public interface ReplyManageService {

	// 목록, 검색
	public int getTotalCommCount(String searchCondition, String searchValue);
	// 목록
	public List<CReply> printAllCommReply(int currentPage, int replyLimit);
	// 검색
	public List<CReply> printAllByCReplyValue(String searchCondition, String searchValue, int currentPage,
			int replyLimit);
	// 디테일
	public Community printOneByCReplyNo(Integer communityNo);
	

	public List<CReply> printAllCReply(int refCommunityNo);
	
	public int registCommunityReply(CReply cReply);

	public int modifyCommunityReply(CReply cReply);

	public int deleteCommunityReply(Integer replyNo);
}
