package com.kh.fivechef.postManage.service;

import java.util.List;

import com.kh.fivechef.community.domain.Community;

public interface PostManageService {

	public int getTotalPostCount(String searchCondition, String searchValue);

	public List<Community> printAllPost(int currentPage, int communityLimit);

	public Community printOneByPostNo(Integer communityNo);

	public int removeOneByPostNo(int communityNo);

	// 검색
	public int getPostTotalCount(String searchCondition, String searchValue);
	
	// 검색
	public List<Community> printAllByPostValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit);


}
