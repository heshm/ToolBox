package com.erp.common.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IUserInfoDAO;
import com.erp.common.dataSet.UserInfo;

public class UserInfoDAO implements IUserInfoDAO{
	
	private final String GET_USER_INFO = "getUserInfo";
	private final String INSERT_ONE_USER_INFO = "insertOneUserInfo";
	private final String GET_USER_LIST = "getUserList";
	private final String DELETE_USERINFO = "deleteUserInfo";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public UserInfo getOneUserInfo(UserInfo userinfo){
		return (UserInfo)sqlSession.selectOne(GET_USER_INFO,userinfo);
	}

	@Override
	public int addOneUserInfo(UserInfo userinfo) {
		
		return sqlSession.insert(INSERT_ONE_USER_INFO,userinfo);
	}

	@Override
	public List<UserInfo> getUserList(UserInfo userinfo) {
		return sqlSession.selectList(GET_USER_LIST,userinfo);
	}

	@Override
	public int deleteUserInfo(String userID) {
		return sqlSession.delete(DELETE_USERINFO, userID);
	}
}
