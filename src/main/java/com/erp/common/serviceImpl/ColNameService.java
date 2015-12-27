package com.erp.common.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IColNameDAO;
import com.erp.common.IService.IColNameService;
import com.erp.common.dataSet.ColName;

@Transactional
public class ColNameService implements IColNameService {
    
	private IColNameDAO colNameDAO;
	
	public IColNameDAO getColNameDAO() {
		return colNameDAO;
	}

	public void setColNameDAO(IColNameDAO colNameDAO) {
		this.colNameDAO = colNameDAO;
	}

	@Override
	public List<ColName> getColNameList(Map<String, String> map) {
		return colNameDAO.getColNameList(map);
	}

}
