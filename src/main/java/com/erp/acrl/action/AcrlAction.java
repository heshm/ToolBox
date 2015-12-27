package com.erp.acrl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.AcrlDS;
import com.erp.acrl.IService.IAcrlService;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class AcrlAction extends CommonAction{
	
	private String acrlId;
	private String acrlName;
	private IAcrlService acrlService;
	private List<AcrlDS> acrlList;
	
	public String getAcrlId() {
		return acrlId;
	}
	public void setAcrlId(String acrlId) {
		this.acrlId = acrlId;
	}
	public String getAcrlName() {
		return acrlName;
	}
	public void setAcrlName(String acrlName) {
		this.acrlName = acrlName;
	}

	public void setAcrlService(IAcrlService acrlService) {
		this.acrlService = acrlService;
	}
	public List<AcrlDS> getAcrlList() {
		return acrlList;
	}
	public void setAcrlList(List<AcrlDS> acrlList) {
		this.acrlList = acrlList;
	}
	public String init(){
		if(session.get("searchMap")!=null){
			Map<String,Object> map = (Map<String, Object>) session.get("searchMap");
			acrlId = (String) map.get("txId");
			acrlName = (String) map.get("dscrb");
			acrlList = acrlService.getAcrlList(map);
		}
		return SUCCESS;
	}
	
	public String search(){                                                                                                                                                                                    
		Map map = new HashMap();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", acrlId);
		map.put("dscrb", acrlName);
		session.put("searchMap", map);
		acrlList = acrlService.getAcrlList(map);
		return SUCCESS;
	}
	
	public String goBack(){
		if(session.get("searchMap")!=null)
		    session.remove("searchMap");
		return SUCCESS;
	}

}
