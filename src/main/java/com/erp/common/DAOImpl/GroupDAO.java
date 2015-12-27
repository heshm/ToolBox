package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IGroupDAO;
import com.erp.common.dataSet.GroupDS;

public class GroupDAO implements IGroupDAO {
	
	private static final String GET_GROUP_LIST = "getGroupList";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<GroupDS> getGroupList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_GROUP_LIST);
	}

}
