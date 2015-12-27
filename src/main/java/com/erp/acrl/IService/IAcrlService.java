package com.erp.acrl.IService;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.AcrlDS;

public interface IAcrlService {
	
	public abstract List<AcrlDS> getAcrlList(Map map);
	
	public abstract AcrlDS getOneAcrl(AcrlDS acrlDS);
	
	public abstract int modiAcrl(AcrlDS acrlDS);

}
