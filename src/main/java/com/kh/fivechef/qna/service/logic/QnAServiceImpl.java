package com.kh.fivechef.qna.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.qna.service.QnAService;
import com.kh.fivechef.qna.store.QnAStore;

@Service
public class QnAServiceImpl implements QnAService{
	
	@Autowired
	private QnAStore qStore;
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int registQnA(QnA QnA) {
		int result = qStore.insertQnA(session, QnA);
		return result;
	}

}
