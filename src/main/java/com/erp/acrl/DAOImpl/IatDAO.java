package com.erp.acrl.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.IIatDAO;
import com.erp.acrl.dataSet.IatDS;

public class IatDAO implements IIatDAO {
	
	private static final String GET_ONE_IAT = "getOneIat";
	private static final String GET_IAT_SEQ = "getIatSeqNo";
	private static final String INSERT_IAT = "insertIat";
	private static final String GET_IAT_LIST = "getIatList";
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public IatDS getOneIat(IatDS iatDS) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(GET_ONE_IAT,iatDS);
	}

	@Override
	public int getIatSeq(String groupId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(GET_IAT_SEQ,groupId);
	}

	@Override
	public int insertIat(IatDS iatDS) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_IAT, iatDS);
	}

	@Override
	public List<IatDS> getIatList(String groupId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_IAT_LIST, groupId);
	}

}
