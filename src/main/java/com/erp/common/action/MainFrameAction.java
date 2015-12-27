package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.IColNameService;
import com.erp.common.IService.IGroupService;
import com.erp.common.dataSet.ColName;
import com.erp.common.dataSet.GroupDS;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class MainFrameAction extends CommonAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IColNameService colNameService;
	
	private IGroupService groupService;
	
	private String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public IColNameService getColNameService() {
		return colNameService;
	}

	public void setColNameService(IColNameService colNameService) {
		this.colNameService = colNameService;
	}

	public IGroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public String init(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("tbName", Const.CND);
		List<ColName> cndColName = colNameService.getColNameList(map);
		List<GroupDS> groupList = groupService.getGroupList();
		session.put(Const.CND_COL_NAME, cndColName);
		session.put(Const.GROUP_LIST, groupList);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String groupChg(){
		session.replace("groupId", group);
		this.addActionMessage("组别修改成功!");
		return SUCCESS;
	}
	
	public String unauth(){
		return SUCCESS;
	}

}
