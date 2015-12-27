package com.erp.common.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("colName")
public class ColName implements Serializable {
	
	private String groupId;
	private String tbName;
	private String colId;
	private String name;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getTbName() {
		return tbName;
	}
	public void setTbName(String tbName) {
		this.tbName = tbName;
	}
	public String getColId() {
		return colId;
	}
	public void setColId(String colId) {
		this.colId = colId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
