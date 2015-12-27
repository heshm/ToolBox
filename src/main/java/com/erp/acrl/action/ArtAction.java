package com.erp.acrl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.acrl.IService.IArtService;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.acrl.dataSet.ArtDS;

public class ArtAction extends CommonAction{
	
	private String txId;
	private String seqNo;
	private List<ArtDS> artList;
	
	
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

	public List<ArtDS> getArtList() {
		return artList;
	}

	public void setArtList(List<ArtDS> artList) {
		this.artList = artList;
	}

	public String init(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.GROUPID, CommonUtil.getGroupId(session));
		map.put("txId", txId);
		map.put("seqNo", seqNo);
		request.setAttribute("txId", txId);
		request.setAttribute("seqNo", seqNo);
		
		artList = artService.getArtList(map);
		
		request.setAttribute("artCnt", artList.size());
		return SUCCESS;
	}
	
	public String modi(){
		this.clearMessages();
	    Map<String,Object> map = new HashMap<String,Object>();
		String groupId = CommonUtil.getGroupId(session);
	    map.put(Const.GROUPID, groupId);
	    map.put("txId", txId);
		map.put("acrlNo", seqNo);
		request.setAttribute("txId", txId);
		request.setAttribute("seqNo", seqNo);
		
		List<ArtDS> result = new ArrayList<ArtDS>();
		ArtDS artDS = new ArtDS();
		for(int i = 0 ; i < artList.size(); i++ ){
			artDS = artList.get(i);
			if(' ' != artDS.getSeqNo()){
				artDS.setGroupId(groupId);
				artDS.setTxId(txId);
				artDS.setAcrlNo(seqNo);
				result.add(artDS);
				//System.out.println(artDS.getGlNo());
				
				//System.out.println(artDS.getGlNo().length());
			}
			//sif ()
		}
		map.put("artList", result);
		artService.modiArt(map);
		request.setAttribute("artCnt", result.size());
		return SUCCESS;
	}
	
	private IArtService artService;
	public IArtService getArtService() {
		return artService;
	}

	public void setArtService(IArtService artService) {
		this.artService = artService;
	}

}
