package com.erp.common.serviceImpl;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IPageServiceDAO;
import com.erp.common.IService.IPageService;
import com.erp.common.dataSet.PageDataSet;

@Transactional
public class PageService<T> implements IPageService<T> {
	
	private IPageServiceDAO<T> pageServiceDAO;

	public IPageServiceDAO<T> getPageServiceDAO() {
		return pageServiceDAO;
	}

	public void setPageServiceDAO(IPageServiceDAO<T> pageServiceDAO) {
		this.pageServiceDAO = pageServiceDAO;
	}

	@Override
	public PageDataSet<T> getFirstPage(PageDataSet<T> pageDataSet, Map<String, Object> parm) {
		int pageSize = pageDataSet.getPageSize();
		pageDataSet.setCurrentPage(1);
		parm.put("startIndex", 0);
		parm.put("pageSize", pageSize);
		pageDataSet.setPageData(pageServiceDAO.getPageData(parm));
		int recordCnt = pageServiceDAO.getRecordCnt(parm);
		if (pageSize >= recordCnt){
			pageDataSet.setPageCnt(1);
			pageDataSet.setHasNextPage(false);
		}else{
			pageDataSet.setHasNextPage(true);
			if (recordCnt%pageSize == 0){
				pageDataSet.setPageCnt(recordCnt/pageSize);
			}else{
				pageDataSet.setPageCnt(recordCnt/pageSize + 1);
			}
		}
		pageDataSet.setRecordCnt(recordCnt);
		return pageDataSet;
		
	}

	@Override
	public PageDataSet<T> getIndexPage(int pageIndex, PageDataSet<T> pageDataSet, Map<String, Object> parm) {
		pageDataSet.setCurrentPage(pageIndex);
		//int currentPage = pageDataSet.getCurrentPage();
		int pageSize = pageDataSet.getPageSize();
		int startIndex = pageSize * (pageIndex - 1);
		parm.put("startIndex", startIndex);
		parm.put("pageSize", pageSize);
		pageDataSet.setPageData(pageServiceDAO.getPageData(parm));
		int recordCnt = 0 ;
		
		if (pageDataSet.getRecordCnt() > 0){
			recordCnt = pageDataSet.getRecordCnt();
		}else{
		    recordCnt = pageServiceDAO.getRecordCnt(parm);
		}
		if ((startIndex + pageSize) >= recordCnt){
			pageDataSet.setHasNextPage(false);
		}else{
			pageDataSet.setHasNextPage(true);
		}
		if (recordCnt%pageSize == 0){
			pageDataSet.setPageCnt(recordCnt/pageSize);
		}else{
			pageDataSet.setPageCnt(recordCnt/pageSize + 1);
		}
		pageDataSet.setRecordCnt(recordCnt);
		return pageDataSet;
	}
	
	@Override
	public PageDataSet<T> getNextPage(PageDataSet<T> pageDataSet, Map<String, Object> parm) {
		int currentPage = pageDataSet.getCurrentPage();
		return getIndexPage(currentPage + 1,pageDataSet,parm);
	}

	@Override
	public PageDataSet<T> getPrePage(PageDataSet<T> pageDataSet, Map<String, Object> parm) {
		int currentPage = pageDataSet.getCurrentPage();
		return getIndexPage(currentPage - 1,pageDataSet,parm);
	}
	
	
}
