package com.erp.acrl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.acrl.IDAO.IArtDAO;
import com.erp.acrl.IService.IArtService;
import com.erp.acrl.dataSet.ArtDS;

@Transactional
public class ArtService implements IArtService {
	
	private IArtDAO artDAO;

	public IArtDAO getArtDAO() {
		return artDAO;
	}

	public void setArtDAO(IArtDAO artDAO) {
		this.artDAO = artDAO;
	}

	@Override
	public List<ArtDS> getArtList(Map map) {
		// TODO Auto-generated method stub
		return artDAO.getArtList(map);
	}

	@Override
	public int modiArt(Map map) {
		// TODO Auto-generated method stub
		artDAO.deleteArt(map);
		return artDAO.insertArtList(map);
	}

	@Override
	public List<ArtDS> getVwArt(Map map) {
		// TODO Auto-generated method stub
		return artDAO.getVwArt(map);
	}

}
