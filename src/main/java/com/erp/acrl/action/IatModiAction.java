package com.erp.acrl.action;

import com.erp.acrl.IService.IIatService;
import com.erp.acrl.dataSet.IatDS;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class IatModiAction extends CommonAction {
	
	private String seqNo;
	private IatDS iatDS;
	private IIatService iatService;
	//private String pageIndex;
	private String cnd1;
	private String cnd2;
	private String glNo;
	
	//public AbstractPdfView a;
	
	public String init(){
		System.out.println("+++++++++++++++++=" + seqNo);
		if(!"".equals(seqNo) && null != seqNo){
			IatDS iat = new IatDS();
			iat.setGroupId(CommonUtil.getGroupId(session));
			iat.setSeqNo(Integer.parseInt(seqNo));
			iatDS = iatService.getOneIat(iat);
			request.setAttribute("isUpdate", true);
		}else{
			//iatDS.setSeqNo(seqNo);
			seqNo = "" + iatService.getIatSeq(CommonUtil.getGroupId(session));
			request.setAttribute("isUpdate", false);
		}
		return SUCCESS;
	}
	
	public String modi(){
		iatDS.setGroupId(CommonUtil.getGroupId(session));
		if(iatDS.getStat() != Const.invalid){
			iatDS.setStat(Const.valid);
		}
		iatService.insertIat(iatDS);
		return SUCCESS;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public IatDS getIatDS() {
		return iatDS;
	}

	public void setIatDS(IatDS iatDS) {
		this.iatDS = iatDS;
	}

	public IIatService getIatService() {
		return iatService;
	}

	public void setIatService(IIatService iatService) {
		this.iatService = iatService;
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

}
