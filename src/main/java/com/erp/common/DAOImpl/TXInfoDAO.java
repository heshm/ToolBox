package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.ITXInfoDAO;
import com.erp.common.dataSet.TXInfo;

public class TXInfoDAO implements ITXInfoDAO{
	
	private static final String GET_TX_INFO_LIST = "getTXInfoList";
	private static final String GET_ONE_TX_INFO = "getOneTXInfo";
	private static final String UPDATE_TX_INFO = "updateTXInfo";
	private static final String INSERT_TX_INFO = "insertTxInfo";
    
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<TXInfo> getTXInfoList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_TX_INFO_LIST, map);
	}
	@Override
	public TXInfo getOneTXInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(GET_ONE_TX_INFO,map);
	}
	@Override
	public int updateTXInfo(TXInfo txInfo) {
		// TODO Auto-generated method stub
		return sqlSession.update(UPDATE_TX_INFO, txInfo);
	}
	@Override
	public int insertTXInfo(TXInfo txInfo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_TX_INFO, txInfo);
	}

}
