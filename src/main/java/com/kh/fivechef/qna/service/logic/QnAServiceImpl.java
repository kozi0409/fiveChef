package com.kh.fivechef.qna.service.logic;

import java.util.List;

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

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = qStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<QnA> printMyQnA(String questionWriter, int currentPage, int qnaLimit) {
		List<QnA> qList = qStore.selectMyQnA(session, questionWriter, currentPage, qnaLimit);
		return qList;
	}

	@Override
	public QnA printOneByNo(Integer questionNo) {
		QnA qna = qStore.selectOneByNo(session, questionNo);
		return qna;
	}

}
