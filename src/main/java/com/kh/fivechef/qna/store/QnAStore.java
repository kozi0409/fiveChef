package com.kh.fivechef.qna.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.qna.domain.QnA;

public interface QnAStore {
	
	int insertQnA(SqlSessionTemplate session, QnA qnA);
}
