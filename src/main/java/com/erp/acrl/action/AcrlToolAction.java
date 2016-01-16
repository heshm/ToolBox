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

import com.erp.acrl.IService.IArtService;
import com.erp.acrl.IService.ICndService;
import com.erp.acrl.IService.ICssService;
import com.erp.acrl.IService.IIatService;
import com.erp.acrl.IService.IOvtService;
import com.erp.acrl.dataSet.ArtDS;
import com.erp.acrl.dataSet.CndDS;
import com.erp.acrl.dataSet.CssDS;
import com.erp.acrl.dataSet.IatDS;
import com.erp.acrl.dataSet.OvtDS;
import com.erp.common.action.CommonAction;
import com.erp.common.dataSet.ColName;
import static com.erp.common.util.CommonUtil.*;
import com.erp.common.util.Const;

public class AcrlToolAction extends CommonAction{
	
	private String fileName;
	private String typ;
	
	public InputStream getInputStream() throws Exception{
		InputStream inputStream = new FileInputStream("D:\\Github\\temp\\acrl\\tmpfile");
		if ("ART".equals(typ)){
			//使用绝对路径
			//InputStream inputStream = new FileInputStream("D:\\Github\\temp\\acrl\\tmpfile");
			fileName = getGroupId(session) + "ART";
			//System.out.println(ServletActionContext.getServletContext().getResourceAsStream("D:\\Github\\temp\\acrl\\LN0ART"));
		    return inputStream;
		}else if("OVT".equals(typ)){
			//InputStream inputStream = new FileInputStream("D:\\Github\\temp\\acrl\\tmpfile");
			fileName = getGroupId(session) + "OVT";
		    return inputStream;
		}else if("IAT".equals(typ)){
			fileName = getGroupId(session) + "IAT";
		    return inputStream;
		}else if("CSS".equals(typ)){
			fileName = getGroupId(session) + "CSS";
		    return inputStream;
		}else if("CND".equals(typ)){
			fileName = getGroupId(session) + "CND";
		    return inputStream;
		}
			
		return null;
	}
	
	public String init(){
		return SUCCESS;
	}
	
	public String genAcrl() throws IOException{
		if ("ART".equals(typ)){
			Map<String,String> map = new HashMap<String,String>();
			map.put(Const.GROUPID, getGroupId(session));
			List<ArtDS> list = artService.getVwArt(map);
			String filePath = "D:\\Github\\temp\\acrl\\tmpfile";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			out.write(StringUtils.rightPad("$$"+ getGroupId(session), 80));
			out.write("\n");
			for(ArtDS art : list){
				//System.out.println(CommonUtil.genArt(art));
			    out.write(genArt(art));
			    out.write("\n");
			}
			out.close();
			return SUCCESS;
		}else if("OVT".equals(typ)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put(Const.GROUPID, getGroupId(session));
			List<OvtDS> list = ovtService.getOvtList(map);
			String filePath = "D:\\Github\\temp\\acrl\\tmpfile";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			for(OvtDS ovt : list){
				out.write(genOvt(ovt));
			    out.write("\n");
			}
			out.close();
			return SUCCESS;
		}else if("IAT".equals(typ)){
			List<IatDS> list = iatService.getIatList(getGroupId(session));
			String filePath = "D:\\Github\\temp\\acrl\\tmpfile";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			for(IatDS iat : list){
				out.write(genIat(iat));
			    out.write("\n");
			}
			out.close();
			return SUCCESS;
		}else if("CSS".equals(typ)){
			Map<String,String> map = new HashMap<String,String>();
			map.put(Const.GROUPID, getGroupId(session));
			List<CssDS> list = cssService.getCssList(map);
			String filePath = "D:\\Github\\temp\\acrl\\tmpfile";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			for(CssDS css : list){
				out.write(genCss(css));
			    out.write("\n");
			}
			out.close();
			return SUCCESS;
		}else if("CND".equals(typ)){
			List<ColName> cndColName = (List<ColName>) session.get(Const.CND_COL_NAME);
			List<CndDS> list = cndService.getVwCnd(getGroupId(session));
			String filePath = "D:\\Github\\temp\\acrl\\tmpfile";
			File file = new File(filePath);
			BufferedWriter out = null;
			if(!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			String firstTwoRow[] = getFirstTwoCndRow(cndColName);
			for(String temp : firstTwoRow){
				out.write(temp);
				out.write("\n");
			}
			short len = (short) cndColName.size();
			short[] cndLen = getCndLen(cndColName);
			for(CndDS cnd : list){
				//System.out.println(CommonUtil.genCnd(cnd,len,cndLen));
				out.write(genCnd(cnd,len,cndLen));
				out.write("\n");
			}
			out.close();
			return SUCCESS;
			
		}
		
		return null;
	}
	
	public String downLoad(){
		if ("ART".equals(typ)||"OVT".equals(typ)||"IAT".equals(typ)||"CSS".equals(typ)||"CND".equals(typ)){
			return SUCCESS;
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
	
	private IOvtService ovtService;
	
	private IIatService iatService;
	
	private ICssService cssService;
	
	private ICndService cndService;

	public void setArtService(IArtService artService) {
		this.artService = artService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setOvtService(IOvtService ovtService) {
		this.ovtService = ovtService;
	}

	public void setIatService(IIatService iatService) {
		this.iatService = iatService;
	}


	public void setCssService(ICssService cssService) {
		this.cssService = cssService;
	}

	public void setCndService(ICndService cndService) {
		this.cndService = cndService;
	}

}
