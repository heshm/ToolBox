package com.erp.acrl.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.erp.common.dataSet.GlaDS;

@Alias("iat")
public class IatDS implements Serializable{
	
	private String groupId;
	private int seqNo;
	private String glNo;
	private String cnd1;
	private String cnd2;
	private String glSeqNo;
	private char stat;
	private GlaDS glaDS;
	
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
	public String getGlNo() {
		return glNo;
	}
	public void setGlNo(String glNo) {
		this.glNo = glNo;
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
	public String getGlSeqNo() {
		return glSeqNo;
	}
	public void setGlSeqNo(String glSeqNo) {
		this.glSeqNo = glSeqNo;
	}
	public char getStat() {
		return stat;
	}
	public void setStat(char stat) {
		this.stat = stat;
	}
	public GlaDS getGlaDS() {
		return glaDS;
	}
	public void setGlaDS(GlaDS glaDS) {
		this.glaDS = glaDS;
	}

}
