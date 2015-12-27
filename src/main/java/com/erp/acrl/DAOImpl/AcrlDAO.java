package com.erp.acrl.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.IAcrlDAO;
import com.erp.acrl.dataSet.AcrlDS;

public class AcrlDAO implements IAcrlDAO {
	
	private static final String GET_ACRL_LIST = "getAcrlList";
	private static final String GET_ONE_ACRL = "getOneAcrl";
	private static final String INSERT_ACRL = "insertAcrl";

	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<AcrlDS> getAcrlList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_ACRL_LIST, map);
	}
	@Override
	public AcrlDS getOneAcrl(AcrlDS acrlDS) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(GET_ONE_ACRL, acrlDS);
	}
	@Override
	public int modiAcrl(AcrlDS acrlDS) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_ACRL, acrlDS);
	}

}
