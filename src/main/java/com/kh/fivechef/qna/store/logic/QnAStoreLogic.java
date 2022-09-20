package com.kh.fivechef.qna.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("QnAMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<QnA> selectMyQnA(SqlSessionTemplate session, int currentPage, int qnaLimit) {
		int offset = (currentPage - 1) * qnaLimit;
		RowBounds rowBounds = new RowBounds(offset, qnaLimit);
		List<QnA> qList = session.selectList("QnAMapper.selectMyQnA", null, rowBounds);
		return qList;
	}

	@Override
	public QnA selectOneByNo(SqlSessionTemplate session, Integer questionNo) {
		QnA qna = session.selectOne("QnAMapper.selectOneByNo", questionNo);
		return qna;
	}
	
}
