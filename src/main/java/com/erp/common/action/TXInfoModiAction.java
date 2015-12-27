package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.ITXInfoService;
import com.erp.common.dataSet.TXInfo;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class TXInfoModiAction extends CommonAction{
	private ITXInfoService txInfoService;
	private String ID;
	private TXInfo txInfo;
	private String searchId;
	private String searchName;
	private List<TXInfo> txInfoList;
	
	public ITXInfoService getTxInfoService() {
		return txInfoService;
	}
	public void setTxInfoService(ITXInfoService txInfoService) {
		this.txInfoService = txInfoService;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public TXInfo getTxInfo() {
		return txInfo;
	}
	public void setTxInfo(TXInfo txInfo) {
		this.txInfo = txInfo;
	}
	
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public List<TXInfo> getTxInfoList() {
		return txInfoList;
	}
	public void setTxInfoList(List<TXInfo> txInfoList) {
		this.txInfoList = txInfoList;
	}
	public String init(){
		if ("" != ID && null != ID){
			request.setAttribute("isUpdate", true);
			Map<String,String> map = new HashMap<String,String>();
			map.put(Const.GROUPID, CommonUtil.getGroupId(session));
			map.put("txId", ID);
			request.setAttribute("searchId", txInfo.getTxId());
			request.setAttribute("searchName", txInfo.getTxName());
			txInfo = txInfoService.getOneTXInfo(map);
		}else{
			request.setAttribute("isUpdate", false);
		}
		return SUCCESS;
	}
	
	public String txInfo_update(){
		txInfo.setGroupId(CommonUtil.getGroupId(session));
		txInfoService.updateTXInfo(txInfo);
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", searchId);
		map.put("txName", searchName);
		txInfoList = txInfoService.getTXInfoList(map);
		txInfo.setTxId(searchId);
		txInfo.setTxName(searchName);
		return SUCCESS;
	}
	
	public String txInfo_insert(){
		txInfo.setGroupId(CommonUtil.getGroupId(session));
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", txInfo.getTxId());
		TXInfo temp = txInfoService.getOneTXInfo(map);
		if(null != temp && null != temp.getTxId() && "" != temp.getGroupId()){
			this.addActionError("该条记录已经存在!");
		}else{
			txInfo.setArtSeq((short) 0);
			txInfo.setCndSeq((short) 0);
			txInfoService.insertTXInfo(txInfo);
			this.addActionMessage("数据插入成功!");
		}
		return SUCCESS;
	}

}
