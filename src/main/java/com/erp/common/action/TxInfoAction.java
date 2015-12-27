package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.ITXInfoService;
import com.erp.common.dataSet.TXInfo;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class TxInfoAction extends CommonAction{
	
	private ITXInfoService txInfoService;
	private List<TXInfo> txInfoList;
	private TXInfo txInfo;

	public TXInfo getTxInfo() {
		return txInfo;
	}

	public void setTxInfo(TXInfo txInfo) {
		this.txInfo = txInfo;
	}

	public List<TXInfo> getTxInfoList() {
		return txInfoList;
	}

	public ITXInfoService getTxInfoService() {
		return txInfoService;
	}

	public void setTxInfoService(ITXInfoService txInfoService) {
		this.txInfoService = txInfoService;
	}

	public String init(){
		return SUCCESS;
	}
	
	public String txInfo_query(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", txInfo.getTxId());
		map.put("txName", txInfo.getTxName());
		txInfoList = txInfoService.getTXInfoList(map);
		return SUCCESS;
	}
	

}
