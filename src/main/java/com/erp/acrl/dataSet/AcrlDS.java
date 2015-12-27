package com.erp.acrl.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("acrl")
public class AcrlDS implements Serializable{
	
	private String groupId;
	private String txId;
	private String seqNo;
	private String dscrb;
	private char isValid;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getDscrb() {
		return dscrb;
	}
	public void setDscrb(String dscrb) {
		this.dscrb = dscrb;
	}
	public char getIsValid() {
		return isValid;
	}
	public void setIsValid(char isValid) {
		this.isValid = isValid;
	}

}
