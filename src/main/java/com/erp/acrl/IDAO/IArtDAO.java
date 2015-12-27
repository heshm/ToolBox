package com.erp.acrl.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.acrl.dataSet.ArtDS;

public interface IArtDAO {
	
	public abstract List<ArtDS> getArtList(Map map);
	
	public abstract int deleteArt(Map map);
	
	public abstract int insertArtList(Map map);
	
	public abstract List<ArtDS> getVwArt(Map map);

}
