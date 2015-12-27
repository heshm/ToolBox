package com.erp.acrl.action;

import java.util.HashMap;
import java.util.Map;
import com.erp.acrl.IService.IOvtService;
import com.erp.acrl.dataSet.OvtDS;
import com.erp.common.action.CommonAction;
import com.erp.common.dataSet.PageDataSet;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;


public class OvtAction extends CommonAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OvtDS ovtDS;
	private PageDataSet<OvtDS> pageDataSet;
	private IOvtService ovtService;
	


	public String init(){
		return SUCCESS;
	}
	
	public String ovt_query(){
		this.clearMessages();
		int pageIndex = 1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupId", CommonUtil.getGroupId(session));
		if (ovtDS != null){
		    map.put("cnd1", ovtDS.getCnd1());
		    map.put("cnd2", ovtDS.getCnd2());
		    map.put("glNo", ovtDS.getGlNo());
		}
		PageDataSet<OvtDS> pageData = new PageDataSet<OvtDS>();
		pageData.setPageSize(Const.OVT_PAGE_SIZE);
		map.put("pageName", "Ovt");
		//System.out.println("AAAAAAAAAA" + request);
		if(request.getParameter("pageIndex")!= null && request.getParameter("pageIndex")!=""){
		    pageIndex = Integer.parseInt((request.getParameter("pageIndex")));
		}
		if (pageIndex==1){
		    pageDataSet = pageService.getFirstPage(pageData, map);
		}else{
			pageDataSet = pageService.getIndexPage(pageIndex, pageData, map);
		}
		return SUCCESS;
	}
	
	public String ovt_query_next(){
	
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupId", CommonUtil.getGroupId(session));
		map.put("pageName", "Ovt");
		if (ovtDS != null){
		    map.put("cnd1", ovtDS.getCnd1());
		    map.put("cnd2", ovtDS.getCnd2());
		    map.put("glNo", ovtDS.getGlNo());
		}
		pageService.getNextPage(pageDataSet, map);
		//System.out.println(pageDataSet.isHasNextPage());
		return SUCCESS;
	}
	
	public String ovt_query_pre(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupId", CommonUtil.getGroupId(session));
		map.put("pageName", "Ovt");
		if (ovtDS != null){
		    map.put("cnd1", ovtDS.getCnd1());
		    map.put("cnd2", ovtDS.getCnd2());
		    map.put("glNo", ovtDS.getGlNo());
		}
		pageService.getPrePage(pageDataSet, map);
		//System.out.println(pageDataSet.isHasNextPage());
		return SUCCESS;
	}
	
	public String ovt_delete(){
		
		//System.out.println(ovtDS.getCnd1());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupId", CommonUtil.getGroupId(session));
		int seqNo = Integer.parseInt((request.getParameter("seqNo")));
		map.put("seqNo", seqNo);
		ovtService.deleteOvt(map);
		ovt_query();
		return SUCCESS;
	}
	
	public String ovt_modi(){
		this.clearMessages();
		int seqNo = 0;
		if(request.getParameter("seqNo")!= "" && request.getParameter("seqNo")!= null){
			seqNo = Integer.parseInt((request.getParameter("seqNo")));
			OvtDS ovt = new OvtDS();
			ovt.setGroupId(CommonUtil.getGroupId(session));
			ovt.setSeqNo(seqNo);
			ovtDS = ovtService.getOneOvt(ovt);
		}else{
			seqNo = ovtService.getOvtSeqNo(CommonUtil.getGroupId(session));
			ovtDS.setSeqNo(seqNo);
		}
		return SUCCESS;
	}
	
	public String ovt_update(){
		
		ovtDS.setGroupId(CommonUtil.getGroupId(session));
		ovtDS.setStat('1');
		ovtService.insertOvt(ovtDS);
		ovt_query();
		return SUCCESS;
	}

	public IOvtService getOvtService() {
		return ovtService;
	}

	public void setOvtService(IOvtService ovtService) {
		this.ovtService = ovtService;
	}

	public OvtDS getOvtDS() {
		return ovtDS;
	}

	public void setOvtDS(OvtDS ovtDS) {
		this.ovtDS = ovtDS;
	}

	public PageDataSet<OvtDS> getPageDataSet() {
		return pageDataSet;
	}

	public void setPageDataSet(PageDataSet<OvtDS> pageDataSet) {
		this.pageDataSet = pageDataSet;
	}

}
