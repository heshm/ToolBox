package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.dataSet.ColName;

public interface IColNameDAO {
	
	public abstract List<ColName> getColNameList(Map<String,String> map);

}
