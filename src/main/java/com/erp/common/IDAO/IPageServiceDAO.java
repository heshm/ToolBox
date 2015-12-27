package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

public interface IPageServiceDAO<T> {
	
	public abstract List<T> getPageData(Map<String,Object> parm);
	
	public abstract int getRecordCnt(Map<String,Object> parm);

}
