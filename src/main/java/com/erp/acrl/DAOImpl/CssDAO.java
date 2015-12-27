package com.erp.acrl.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.ICssDAO;
import com.erp.acrl.dataSet.CssDS;

public class CssDAO implements ICssDAO {
	
	private static final String GET_CSS_LIST = "getCssList";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CssDS> getCssList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_CSS_LIST, map);
	}

}
