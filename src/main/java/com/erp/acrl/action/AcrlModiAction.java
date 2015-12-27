package com.erp.acrl.action;

import com.erp.acrl.IService.IAcrlService;
import com.erp.acrl.dataSet.AcrlDS;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class AcrlModiAction extends CommonAction{
	
	private AcrlDS acrlDS;
	private String txId;
	private String seqNo;
	private boolean isUpdate;
	
	public AcrlDS getAcrlDS() {
		return acrlDS;
	}

	public void setAcrlDS(AcrlDS acrlDS) {
		this.acrlDS = acrlDS;
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

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String init(){
		if ("" != txId && null != txId){
			AcrlDS ds = new AcrlDS();
			ds.setGroupId(CommonUtil.getGroupId(session));
			ds.setTxId(txId);
			ds.setSeqNo(seqNo);
			acrlDS = acrlService.getOneAcrl(ds);
			//System.out.println(acrlDS.getDscrb());
			request.setAttribute("isUpdate", true);
		}else
			request.setAttribute("isUpdate", false);
		return SUCCESS;
	}
	
	public String modi(){
		acrlDS.setGroupId(CommonUtil.getGroupId(session));
		if (acrlDS.getIsValid() != Const.invalid){
			acrlDS.setIsValid(Const.valid);
		}
		acrlService.modiAcrl(acrlDS);
		request.setAttribute("isUpdate", isUpdate);
		if(isUpdate){
		    this.addActionMessage("数据修改成功!");
		}else{
			this.addActionMessage("数据新增成功!");
		}
		return SUCCESS;
	}
	public String goback(){
		return SUCCESS;
	}
	
	private IAcrlService acrlService;

	public IAcrlService getAcrlService() {
		return acrlService;
	}

	public void setAcrlService(IAcrlService acrlService) {
		this.acrlService = acrlService;
	}

}
