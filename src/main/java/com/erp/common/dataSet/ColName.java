package com.erp.common.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("colName")
public class ColName implements Serializable {
	
	private String groupId;
	private String tbName;
	private String colId;
	private String name;
	private Short cndLen;
	private String cndSource;
	private String cndSourceNo;
	
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
	public Short getCndLen() {
		return cndLen;
	}
	public void setCndLen(Short cndLen) {
		this.cndLen = cndLen;
	}
	public String getCndSource() {
		return cndSource;
	}
	public void setCndSource(String cndSource) {
		this.cndSource = cndSource;
	}
	public String getCndSourceNo() {
		return cndSourceNo;
	}
	public void setCndSourceNo(String cndSourceNo) {
		this.cndSourceNo = cndSourceNo;
	}
	
}
