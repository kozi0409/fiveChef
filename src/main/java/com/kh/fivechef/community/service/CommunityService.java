package com.kh.fivechef.community.service;

import java.util.List;

import com.kh.fivechef.community.domain.Community;

public interface CommunityService {

	int registCommunity(Community community);

	int getTotalCount(String searchCondition, String searchValue);

	List<Community> printAllCommunity(int currentPage, int communityLimit);

}
