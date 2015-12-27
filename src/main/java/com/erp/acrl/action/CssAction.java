package com.erp.acrl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.acrl.IService.ICssService;
import com.erp.acrl.dataSet.CssDS;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class CssAction extends CommonAction {
	
	private List<CssDS> cssList;
	private String brhno;
	private String txid;
	
	private ICssService cssService;
	
	public String init(){
		return SUCCESS;
	}
	
	public String search(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		cssList = cssService.getCssList(map);
		return SUCCESS;
	}

	public List<CssDS> getCssList() {
		return cssList;
	}

	public void setCssList(List<CssDS> cssList) {
		this.cssList = cssList;
	}

	public String getBrhno() {
		return brhno;
	}

	public void setBrhno(String brhno) {
		this.brhno = brhno;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public ICssService getCssService() {
		return cssService;
	}

	public void setCssService(ICssService cssService) {
		this.cssService = cssService;
	}

}
