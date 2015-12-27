package com.erp.acrl.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("ovtDS")
public class OvtDS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupId;
	private int seqNo;
	private String typ;
	private String cnd1;
	private String cnd2;
	private String glNo;
	private String glName;
	private char stat;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getCnd1() {
		return cnd1;
	}
	public void setCnd1(String cnd1) {
		this.cnd1 = cnd1;
	}
	public String getCnd2() {
		return cnd2;
	}
	public void setCnd2(String cnd2) {
		this.cnd2 = cnd2;
	}
	public String getGlNo() {
		return glNo;
	}
	public void setGlNo(String glNo) {
		this.glNo = glNo;
	}
	public String getGlName() {
		return glName;
	}
	public void setGlName(String glName) {
		this.glName = glName;
	}
	public char getStat() {
		return stat;
	}
	public void setStat(char stat) {
		this.stat = stat;
	}
}
