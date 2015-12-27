package com.erp.acrl.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.ICndDAO;
import com.erp.acrl.dataSet.CndDS;

public class CndDAO implements ICndDAO {
	
	private static final String GET_CND_LIST = "getCndList";
	private static final String DELETE_CND = "deleteCnd";
	private static final String INSERT_CND_LIST = "insertCndList";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CndDS> getCndList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_CND_LIST, map);
	}

	@Override
	public int deleteCnd(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(DELETE_CND, map);
	}

	@Override
	public int insertCndList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_CND_LIST, map);
	}

}
