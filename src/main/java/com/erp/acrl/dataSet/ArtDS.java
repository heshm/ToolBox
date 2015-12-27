package com.erp.acrl.dataSet;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("art")
public class ArtDS implements Serializable{
	
	private String groupId;
	private String txId;
	private String acrlNo;
	private char seqNo;
	private char debitOrCredit;
	private String glName;
	private String glNo;
	private String account;
	private String amtDscrb;
	private String amtPoint;
	private String glSeqNo;
	private String overRide;
	
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
	public String getAcrlNo() {
		return acrlNo;
	}
	public void setAcrlNo(String acrlNo) {
		this.acrlNo = acrlNo;
	}
	public char getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(char seqNo) {
		this.seqNo = seqNo;
	}
	public char getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(char debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
	public String getGlName() {
		return glName;
	}
	public void setGlName(String glName) {
		this.glName = glName;
	}
	public String getGlNo() {
		return glNo;
	}
	public void setGlNo(String glNo) {
		this.glNo = glNo;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAmtDscrb() {
		return amtDscrb;
	}
	public void setAmtDscrb(String amtDscrb) {
		this.amtDscrb = amtDscrb;
	}
	public String getAmtPoint() {
		return amtPoint;
	}
	public void setAmtPoint(String amtPoint) {
		this.amtPoint = amtPoint;
	}
	public String getGlSeqNo() {
		return glSeqNo;
	}
	public void setGlSeqNo(String glSeqNo) {
		this.glSeqNo = glSeqNo;
	}
	public String getOverRide() {
		return overRide;
	}
	public void setOverRide(String overRide) {
		this.overRide = overRide;
	}
	
	
}
