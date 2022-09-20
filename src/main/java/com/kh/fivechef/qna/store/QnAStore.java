package com.kh.fivechef.qna.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.qna.domain.QnA;

public interface QnAStore {
	
	public int insertQnA(SqlSessionTemplate session, QnA qnA);

	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue);

	public List<QnA> selectMyQnA(SqlSessionTemplate session, String questionWriter, int currentPage, int qnaLimit);

	public QnA selectOneByNo(SqlSessionTemplate session, Integer questionNo);
}
