package com.erp.acrl.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.erp.acrl.IService.IArtService;
import com.erp.acrl.dataSet.ArtDS;
import com.erp.common.action.CommonAction;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;

public class AcrlToolAction extends CommonAction{
	
	private String fileName;
	private String typ;
	
	public InputStream getInputStream() throws Exception{
		System.out.println(typ);
		if ("ART".equals(typ)){
			//使用绝对路径
			InputStream inputStream = new FileInputStream("D:\\Github\\temp\\acrl\\LN0ART");
			fileName = CommonUtil.getGroupId(session) + "ART";
			//System.out.println(ServletActionContext.getServletContext().getResourceAsStream("D:\\Github\\temp\\acrl\\LN0ART"));
		    return inputStream;
		}else
			System.out.println("BBBBBBBBBBBBB");
			return null;
	}
	
	public String init(){
		return SUCCESS;
	}
	
	public String genAcrl() throws IOException{
		if ("ART".equals(typ)){
			Map<String,String> map = new HashMap<String,String>();
			map.put(Const.GROUPID, CommonUtil.getGroupId(session));
			List<ArtDS> list = artService.getVwArt(map);
			String filePath = "D:\\Github\\temp\\acrl\\LN0ART";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			out.write(StringUtils.rightPad("$$LN0", 80));
			out.write("\n");
			for(ArtDS art : list){
				//System.out.println(CommonUtil.genArt(art));
			    out.write(CommonUtil.genArt(art));
			    out.write("\n");
			}
			out.close();
			return SUCCESS;
		}
		
		return null;
	}
	
	public String downLoad(){
		if ("ART".equals(typ)){
			return "downLoadArt";
		}else
			return null;
		
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	private IArtService artService;
	public IArtService getArtService() {
		return artService;
	}

	public void setArtService(IArtService artService) {
		this.artService = artService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
