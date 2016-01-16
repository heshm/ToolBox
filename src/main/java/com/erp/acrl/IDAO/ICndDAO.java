package com.erp.acrl.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.CndDS;

public interface ICndDAO {
	
	public abstract List<CndDS> getCndList(Map map);
	
	public abstract int deleteCnd(Map map);
	
	public abstract int insertCndList(Map map);
	
	public abstract List<CndDS> getVwCnd(String string);

}
