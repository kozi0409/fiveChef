package com.kh.fivechef.postManage.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.community.domain.Community;

public interface PostManageStore {

	public	int selectTotalPostCount(SqlSessionTemplate session, String searchCondition, String searchValue);

	public	List<Community> selectAllPost(SqlSessionTemplate session, int currentPage, int communityLimit);

	public	Community selectOneByPostNo(SqlSessionTemplate session, Integer communityNo);

	public	int updatePostCount(SqlSessionTemplate session, Integer communityNo);

	public	int deleteOneByPostNo(SqlSessionTemplate session, int communityNo);

}
