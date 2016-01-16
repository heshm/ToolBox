package com.erp.acrl.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erp.acrl.IDAO.IIatDAO;
import com.erp.acrl.IService.IIatService;
import com.erp.acrl.dataSet.IatDS;

@Transactional
public class IatService implements IIatService {
	
	private IIatDAO iatDAO;

	public IIatDAO getIatDAO() {
		return iatDAO;
	}

	public void setIatDAO(IIatDAO iatDAO) {
		this.iatDAO = iatDAO;
	}

	@Override
	public IatDS getOneIat(IatDS iatDS) {
		// TODO Auto-generated method stub
		return iatDAO.getOneIat(iatDS);
	}

	@Override
	public int getIatSeq(String groupId) {
		// TODO Auto-generated method stub
		return iatDAO.getIatSeq(groupId);
	}

	@Override
	public int insertIat(IatDS iatDS) {
		// TODO Auto-generated method stub
		return iatDAO.insertIat(iatDS);
	}

	@Override
	public List<IatDS> getIatList(String groupId) {
		// TODO Auto-generated method stub
		return iatDAO.getIatList(groupId);
	}

}
