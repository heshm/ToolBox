package com.erp.acrl.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.acrl.IDAO.IOvtDAO;
import com.erp.acrl.IService.IOvtService;
import com.erp.acrl.dataSet.OvtDS;

@Transactional
public class OvtService implements IOvtService {
	
	private IOvtDAO ovtDAO;

	public IOvtDAO getOvtDAO() {
		return ovtDAO;
	}

	public void setOvtDAO(IOvtDAO ovtDAO) {
		this.ovtDAO = ovtDAO;
	}

	public List<OvtDS> getOvtList(Map<String, Object> map) {
		return ovtDAO.getOvtList(map);
		
	}

	@Override
	public int deleteOvt(Map<String, Object> map) {
	    return ovtDAO.deleteOvt(map);
	}

	@Override
	public int getOvtSeqNo(String groupId) {
		return ovtDAO.selectSeqNo(groupId);
	}

	@Override
	public OvtDS getOneOvt(OvtDS ovtDS) {
		return ovtDAO.getOneOvt(ovtDS);
	}

	@Override
	public int insertOvt(OvtDS ovtDS) {
		// TODO Auto-generated method stub
		return ovtDAO.insertOvt(ovtDS);
	}

}
