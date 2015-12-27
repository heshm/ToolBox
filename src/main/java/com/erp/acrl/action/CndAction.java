package com.erp.acrl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.acrl.IService.ICndService;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.acrl.dataSet.CndDS;

public class CndAction extends CommonAction{
	
	private ICndService cndService;
	private String txId;
	private String cndNo;
	private List<CndDS> cndList;
	private int cndCnt;
	
	public ICndService getCndService() {
		return cndService;
	}

	public void setCndService(ICndService cndService) {
		this.cndService = cndService;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public void setCndNo(String cndNo) {
		this.cndNo = cndNo;
	}

	public List<CndDS> getCndList() {
		return cndList;
	}

	public void setCndList(List<CndDS> cndList) {
		this.cndList = cndList;
	}

	public int getCndCnt() {
		return cndCnt;
	}

	public void setCndCnt(int cndCnt) {
		this.cndCnt = cndCnt;
	}

	public String init(){
		//this.clearMessages();
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", txId);
		map.put("cndNo", cndNo);
		request.setAttribute("txId", txId);
		request.setAttribute("cndNo", cndNo);
		cndList = cndService.getCndList(map);
		cndCnt = cndList.size();
		return SUCCESS;
	}
	
	public String cndModi(){
	    this.clearMessages();
	    Map<String,Object> map = new HashMap<String,Object>();
	    String groupId = CommonUtil.getGroupId(session);
		map.put(Const.GROUPID, groupId);
		map.put("txId", txId);
		map.put("cndNo", cndNo);
		request.setAttribute("txId", txId);
		request.setAttribute("cndNo", cndNo);
		List<CndDS> resultList = new ArrayList<CndDS>();
		CndDS cndDS = new CndDS();
		int j = 1;
		for(int i = 0 ;i < cndList.size(); i++){
			cndDS = cndList.get(i);
			if(null != cndDS.getDscrb() &&  (!"".equals(cndDS.getDscrb().trim()))){
				cndDS.setGroupId(groupId);
				cndDS.setTxId(txId);
				cndDS.setCndNo(cndNo);
				cndDS.setSeqNo(j);
				j++;
				resultList.add(cndDS);
			}
		}
		cndCnt = j - 1;
		map.put("cndList", resultList);
		cndService.modiCnd(map);
		this.addActionMessage("CND表修改成功!");
		return SUCCESS;
	}

}
