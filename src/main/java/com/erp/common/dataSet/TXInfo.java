package com.erp.common.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("TXInfo")
public class TXInfo implements Serializable{
	
	private String groupId;
	private String txId;
	private char txTyp;
	private String txName;
	private short cndSeq;
	private short artSeq;
	
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
	public char getTxTyp() {
		return txTyp;
	}
	public void setTxTyp(char txTyp) {
		this.txTyp = txTyp;
	}
	public String getTxName() {
		return txName;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	public short getCndSeq() {
		return cndSeq;
	}
	public void setCndSeq(short cndSeq) {
		this.cndSeq = cndSeq;
	}
	public short getArtSeq() {
		return artSeq;
	}
	public void setArtSeq(short artSeq) {
		this.artSeq = artSeq;
	}


}
