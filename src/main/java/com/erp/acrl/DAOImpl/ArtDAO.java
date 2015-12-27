package com.erp.acrl.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.acrl.IDAO.IArtDAO;
import com.erp.acrl.dataSet.ArtDS;

public class ArtDAO implements IArtDAO {

private SqlSession sqlSession;

    private static final String GET_ART_LIST = "getArtList";
    
    private static final String DELETE_ART = "deleteArt";
	private static final String INSERT_ART_LIST = "insertArtList";
	
	private static final String GEN_ART_LIST = "genArtList";
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ArtDS> getArtList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GET_ART_LIST, map);
	}
	@Override
	public int deleteArt(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(DELETE_ART, map);
	}
	@Override
	public int insertArtList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(INSERT_ART_LIST, map);
	}
	@Override
	public List<ArtDS> getVwArt(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(GEN_ART_LIST, map);
	}

}
