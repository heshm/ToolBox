package com.erp.acrl.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.IOvtDAO;
import com.erp.acrl.dataSet.OvtDS;

public class OvtDAO implements IOvtDAO{
    
	private SqlSession sqlSession;
	
	private static final String GET_OVT_LIST = "getOvtList";
	private static final String DELETE_OVT = "deleteOvt";
	private static final String GET_SEQ_NO = "getOvtSeqNo";
	private static final String GET_ONE_OVT = "getOneOvt";
	private static final String INSERT_ONE_OVT = "inserOvt";
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<OvtDS> getOvtList(Map<String, Object> map) {
		return sqlSession.selectList(GET_OVT_LIST, map);
	}

	@Override
	public int deleteOvt(Map<String,Object> map) {
		return sqlSession.update(DELETE_OVT, map);
	}

	@Override
	public int selectSeqNo(String groupId) {
		return sqlSession.selectOne(GET_SEQ_NO,groupId);
	}

	@Override
	public OvtDS getOneOvt(OvtDS ovtDS) {
		return sqlSession.selectOne(GET_ONE_OVT, ovtDS);
	}

	@Override
	public int insertOvt(OvtDS ovtDS) {
		return sqlSession.insert(INSERT_ONE_OVT, ovtDS);
	}

}
