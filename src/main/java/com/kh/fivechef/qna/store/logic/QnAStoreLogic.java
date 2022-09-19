package com.kh.fivechef.qna.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.qna.store.QnAStore;

@Repository
public class QnAStoreLogic implements QnAStore{

	@Override
	public int insertQnA(SqlSessionTemplate session, QnA qnA) {
		int result = session.insert("QnAMapper.insertQnA", qnA);
		return result;
	}
	
}
