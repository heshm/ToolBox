package com.erp.acrl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.acrl.IDAO.ICndDAO;
import com.erp.acrl.IService.ICndService;
import com.erp.acrl.dataSet.CndDS;

@Transactional
public class CndService implements ICndService {
	
	private ICndDAO cndDAO;

	public ICndDAO getCndDAO() {
		return cndDAO;
	}

	public void setCndDAO(ICndDAO cndDAO) {
		this.cndDAO = cndDAO;
	}

	@Override
	public List<CndDS> getCndList(Map map) {
		// TODO Auto-generated method stub
		return cndDAO.getCndList(map);
	}

	@Override
	public int modiCnd(Map map) {
		// TODO Auto-generated method stub
		cndDAO.deleteCnd(map);
		return cndDAO.insertCndList(map);
	}

}
