package com.erp.acrl.IService;

import java.util.List;

import com.erp.acrl.dataSet.IatDS;

public interface IIatService {
	
	public abstract IatDS getOneIat(IatDS iatDS);
	
	public abstract int getIatSeq(String groupId);
	
	public abstract int insertIat(IatDS iatDS);
	
	public abstract List<IatDS> getIatList(String groupId);

}
