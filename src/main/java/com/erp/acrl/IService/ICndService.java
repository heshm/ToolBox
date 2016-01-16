package com.erp.acrl.IService;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.CndDS;

public interface ICndService {
	
	public abstract List<CndDS> getCndList(Map map);
	
	public abstract int modiCnd(Map map);
	
	public abstract List<CndDS> getVwCnd(String string);

}
