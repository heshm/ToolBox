package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.dataSet.TXInfo;

public interface ITXInfoDAO {
	
	public abstract List<TXInfo> getTXInfoList(Map<String,String> map);
	public abstract TXInfo getOneTXInfo(Map<String,String> map);
	public int updateTXInfo(TXInfo txInfo);
	public int insertTXInfo(TXInfo txInfo);

}
