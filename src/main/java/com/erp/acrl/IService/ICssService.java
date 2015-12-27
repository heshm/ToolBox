package com.erp.acrl.IService;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.CssDS;

public interface ICssService {
	
	public abstract List<CssDS> getCssList(Map<String, String> map);

}
