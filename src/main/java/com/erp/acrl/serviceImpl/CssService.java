package com.erp.acrl.serviceImpl;

import java.util.List;
import java.util.Map;

import com.erp.acrl.IDAO.ICssDAO;
import com.erp.acrl.IService.ICssService;
import com.erp.acrl.dataSet.CssDS;

public class CssService implements ICssService {
	
	private ICssDAO cssDAO;

	public ICssDAO getCssDAO() {
		return cssDAO;
	}

	public void setCssDAO(ICssDAO cssDAO) {
		this.cssDAO = cssDAO;
	}

	@Override
	public List<CssDS> getCssList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return cssDAO.getCssList(map);
	}

}
