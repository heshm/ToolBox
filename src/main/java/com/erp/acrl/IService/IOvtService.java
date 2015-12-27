package com.erp.acrl.IService;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.OvtDS;

public interface IOvtService {

	public abstract List<OvtDS> getOvtList(Map<String,Object> map);
	
	public int deleteOvt(Map<String,Object> map);

	public int getOvtSeqNo(String groupId);
	
	public OvtDS getOneOvt(OvtDS ovtDS);
	
	public int insertOvt(OvtDS ovtDS);
}
