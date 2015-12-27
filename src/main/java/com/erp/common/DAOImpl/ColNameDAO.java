package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IColNameDAO;
import com.erp.common.dataSet.ColName;

public class ColNameDAO implements IColNameDAO {
	
	private static final String GET_COL_NAME_LIST = "getColNameList";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ColName> getColNameList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_COL_NAME_LIST, map);
	}

}
