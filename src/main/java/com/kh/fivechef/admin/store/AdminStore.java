package com.kh.fivechef.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.user.domain.User;

public interface AdminStore {   
	//selectLoginAdmin
	public Admin selectLoginAdmin(SqlSession session, Admin admin);
	//selectOneById
	public Admin selectOneById(SqlSession session, String adminId);
	//insertAdmin
	public int insertAdmin(SqlSession session, Admin admin);
	//updateAdmin
	public int updateAdmin(SqlSession session, Admin admin);
	//deleteAdmin
	public int deleteAdmin(SqlSession session, String adminId);
	
	//관리자 리스트출력
	public List<Admin> selectAllAdmin(SqlSession session, int currentPage, int adminLimit);
	//관리자 
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue);
	//관리자 삭제
	public int deleteOneById(SqlSession session, String adminId);
	//관리자 아이디찾기
	public Admin selectAdminId(SqlSession session, String adminEmail);
	//관리자 비밀번호찾기
	public Admin selectAdminPwd(SqlSession session, String adminId, String adminEmail);
	
	//회원관리
	//회원 리스트 출력
	public List<User> selectAllUser(SqlSession session, int currentPage, int userLimit);
	public User printOneByUserId(SqlSession session, String userId);
	public int removeOneByUserId(SqlSession session, String userId);
	public int modifyUser(SqlSession session, User user);
	public List<Admin> selectAllByAdminValue(
			SqlSession session
			, String searchCondition
			, String searchValue
			, int currentPage
			, int adminLimit);
	public List<User> selectAllByUserValue(
			SqlSession session
			, String searchCondition
			, String searchValue
			, int currentPage
			, int userLimit);
	public int selectTotalUserCount(SqlSession session
			, String searchUCondition
			, String searchUValue);
	
	
	//관리자 1:1문의관리
	//qna 게시판 관의
	public List<QnA> selectAllQna(SqlSession session, int currentPage, int qnaLimit);
	public QnA selectOneByQnaNo(SqlSession session, Integer questionNo);
	public int insertAnswer(SqlSession session, QnA qna);
	public List<QnA> selectAllbyQnaValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int qnaLimit);
	public int selectTotalQnaCount(SqlSession session, String searchCondition, String searchValue);
	
	//관리자 메인페이지에 게시판 4개 출력
	public List<User> selectNewUser(SqlSession session);
	public List<Community> selectNewComm(SqlSession session);
	public List<QnA> selectNewQna(SqlSession session);
	public List<Recipe> selectNewRecipe(SqlSession session);

}
