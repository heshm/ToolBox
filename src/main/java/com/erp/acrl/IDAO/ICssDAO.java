package com.erp.acrl.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.CssDS;

public interface ICssDAO {
	
	public abstract List<CssDS> getCssList(Map<String,String> map);

}
