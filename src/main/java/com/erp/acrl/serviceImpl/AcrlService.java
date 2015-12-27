package com.erp.acrl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.acrl.IDAO.IAcrlDAO;
import com.erp.acrl.IService.IAcrlService;
import com.erp.acrl.dataSet.AcrlDS;

@Transactional
public class AcrlService implements IAcrlService {
	
	private IAcrlDAO acrlDAO;

	public IAcrlDAO getAcrlDAO() {
		return acrlDAO;
	}

	public void setAcrlDAO(IAcrlDAO acrlDAO) {
		this.acrlDAO = acrlDAO;
	}

	@Override
	public List<AcrlDS> getAcrlList(Map map) {
		// TODO Auto-generated method stub
		return acrlDAO.getAcrlList(map);
	}

	@Override
	public AcrlDS getOneAcrl(AcrlDS acrlDS) {
		// TODO Auto-generated method stub
		return acrlDAO.getOneAcrl(acrlDS);
	}

	@Override
	public int modiAcrl(AcrlDS acrlDS) {
		// TODO Auto-generated method stub
		return acrlDAO.modiAcrl(acrlDS);
	}

}
