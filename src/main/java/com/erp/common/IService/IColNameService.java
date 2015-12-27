package com.erp.common.IService;

import java.util.List;
import java.util.Map;

import com.erp.common.dataSet.ColName;

public interface IColNameService {
	
	public abstract List<ColName> getColNameList(Map<String,String> map);

}
