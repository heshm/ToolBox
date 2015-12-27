package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IPageServiceDAO;

public class PageServiceDAO<T> implements IPageServiceDAO<T> {

	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<T> getPageData(Map<String, Object> parm) {
		String sqlID = (String)parm.get("pageName");
		sqlID = "pageSelect" + sqlID;
	    return sqlSession.selectList(sqlID, parm);
	}

	@Override
	public int getRecordCnt(Map<String, Object> parm) {
		String sqlID = (String)parm.get("pageName");
		sqlID = "pageSelect" + sqlID + "Cnt";
		return sqlSession.selectOne(sqlID, parm);
	}

}
