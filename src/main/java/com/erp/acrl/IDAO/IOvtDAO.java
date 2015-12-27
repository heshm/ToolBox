package com.erp.acrl.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.OvtDS;

public interface IOvtDAO {
	
	public abstract List<OvtDS> getOvtList(Map<String,Object> map);
	public abstract int deleteOvt(Map<String,Object> map);
	public abstract int selectSeqNo(String groupId);
	public abstract OvtDS getOneOvt(OvtDS ovtDS);
	public abstract int insertOvt(OvtDS ovtDS);
}
