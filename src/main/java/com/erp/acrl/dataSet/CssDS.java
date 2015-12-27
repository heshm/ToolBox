package com.erp.acrl.dataSet;

import org.apache.ibatis.type.Alias;

@Alias("css")
public class CssDS {
	
	private String groupId;
	private Integer seqno;
	private String brhno;
	private String txid;
	private String oldCnd;
	private String newCnd;
	private String stat;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getBrhno() {
		return brhno;
	}
	public void setBrhno(String brhno) {
		this.brhno = brhno;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getOldCnd() {
		return oldCnd;
	}
	public void setOldCnd(String oldCnd) {
		this.oldCnd = oldCnd;
	}
	public String getNewCnd() {
		return newCnd;
	}
	public void setNewCnd(String newCnd) {
		this.newCnd = newCnd;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}

}
