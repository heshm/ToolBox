package com.erp.common.IService;

import java.util.Map;

import com.erp.common.dataSet.PageDataSet;

public interface IPageService<T> {

	public abstract PageDataSet<T> getFirstPage(PageDataSet<T> pageDataSet,Map<String, Object> parm);
	
	public abstract PageDataSet<T> getIndexPage(int pageIndex,PageDataSet<T> pageDataSet,Map<String, Object> parm);
	
	public abstract PageDataSet<T> getNextPage(PageDataSet<T> pageDataSet,Map<String, Object> parm);
	
	public abstract PageDataSet<T> getPrePage(PageDataSet<T> pageDataSet,Map<String, Object> parm);

	
	
}
