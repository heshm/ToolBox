package com.erp.acrl.action;

import java.util.HashMap;
import java.util.Map;

import com.erp.acrl.dataSet.IatDS;
import com.erp.common.action.CommonAction;
import com.erp.common.dataSet.PageDataSet;
import com.erp.common.util.CommonUtil;

public class IatAction extends CommonAction{
	
	private PageDataSet<IatDS> pageDataSet;
	private String pageIndex;
	private String cnd1;
	private String cnd2;
	private String glNo;
	
	
	public String init(){
		return SUCCESS;
	}
	
	public String search(){
		int index = 1;
		if((pageIndex != null) && (!pageIndex.equals(""))){
			index = Integer.parseInt(pageIndex);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupId", CommonUtil.getGroupId(session));
		map.put("pageName", "Iat");
		map.put("cnd1", cnd1);
		map.put("cnd2", cnd2);
		map.put("glNo", glNo);
		//
		if (index == 1){
			PageDataSet<IatDS> pageData = new PageDataSet<IatDS>();
			pageData.setPageSize(50);
		    pageDataSet = pageService.getFirstPage(pageData, map);
		}else{
			pageDataSet = pageService.getIndexPage(index, pageDataSet, map);
		}
		return SUCCESS;
	}

	public PageDataSet<IatDS> getPageDataSet() {
		return pageDataSet;
	}

	public void setPageDataSet(PageDataSet<IatDS> pageDataSet) {
		this.pageDataSet = pageDataSet;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
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
