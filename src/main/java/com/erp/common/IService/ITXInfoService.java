package com.erp.common.IService;

import java.util.List;
import java.util.Map;

import com.erp.common.dataSet.TXInfo;

public interface ITXInfoService {
	
	public abstract List<TXInfo> getTXInfoList(Map<String, String> map);
	
	public abstract TXInfo getOneTXInfo(Map<String, String> map);
	
	public abstract int updateTXInfo(TXInfo txInfo);
	
	public int insertTXInfo(TXInfo txInfo);

}
