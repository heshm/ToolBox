package com.erp.acrl.IService;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.ArtDS;

public interface IArtService {
	
	public abstract List<ArtDS> getArtList(Map map);
	
	public abstract int modiArt(Map map);
	
	public abstract List<ArtDS> getVwArt(Map map);

}
