package com.erp.common.dataSet;

import org.apache.ibatis.type.Alias;

@Alias("group")
public class GroupDS {
	
	private String groupId;
	private String groupName;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}
