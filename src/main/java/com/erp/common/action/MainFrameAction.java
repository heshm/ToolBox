package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.IColNameService;
import com.erp.common.dataSet.ColName;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class MainFrameAction extends CommonAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IColNameService colNameService;

	public IColNameService getColNameService() {
		return colNameService;
	}

	public void setColNameService(IColNameService colNameService) {
		this.colNameService = colNameService;
	}

	public String init(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("tbName", Const.CND);
		List<ColName> cndColName = colNameService.getColNameList(map);
		session.put(Const.CND_COL_NAME, cndColName);
		return SUCCESS;
	}
	
	public String unauth(){
		return SUCCESS;
	}

}
