package com.erp.common.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.erp.acrl.dataSet.ArtDS;
import com.erp.acrl.dataSet.CndDS;
import com.erp.acrl.dataSet.CssDS;
import com.erp.acrl.dataSet.IatDS;
import com.erp.acrl.dataSet.OvtDS;
import com.erp.common.dataSet.ColName;


public class CommonUtil {
	
	public static String getGroupId(Map<String, Object> session){
		String groupId = (String)session.get("groupId");
		//UserInfo userInfo = (UserInfo)session.get(Const.USERINFO);
		return groupId;
	}
	
	public static String genArt(ArtDS artDS){
		String result = "",temp = "";int i;
		temp = artDS.getTxId().trim();
		if(temp.length()==6){
			temp = artDS.getGroupId().trim() + temp;
		}
		result = StringUtils.rightPad(temp, 9);
		result += artDS.getAcrlNo().trim();
		//System.out.println(artDS.getSeqNo());
		result += artDS.getSeqNo();
		result += artDS.getDebitOrCredit();
		temp = artDS.getGlNo().trim();
		result += StringUtils.rightPad(temp, 8);
		result += artDS.getAccount();
		temp = artDS.getAmtPoint().trim();
		i = temp.length();
		if (i <= 2){
			if(i==0){
				temp = "00";
			}
			if(i == 1){
				temp = "0" + temp;
			}
			temp = temp + " 00";
		}
		if(i == 3){
			temp = "0" + temp.substring(0, 2) + "0" + temp.substring(2);
		}
		if(i == 4){
			if(temp.substring(1, 2).equals("+")||temp.substring(1, 2).equals("-")||temp.substring(1, 2).equals("*")){
				temp = "0" + temp;
			}else if(temp.substring(2, 3).equals("+")||temp.substring(2, 3).equals("-")||temp.substring(2, 3).equals("*")){
				temp = temp.substring(0,3) + "0" + temp.substring(3);
			}
				
		}
		
		result += temp;
		temp = artDS.getGlSeqNo().trim();
		if(temp.length()==0){
			temp = "000000";
		}
		result += temp;
		temp = artDS.getOverRide().trim();
		if (temp.length() == 0){
			temp = "N";
		}
		result += temp;
		result = StringUtils.rightPad(result, 80);
		return result;
	}
	
	public static String genOvt(OvtDS ovt){
		String result = "";
		String temp;
		result += ovt.getGroupId();
		result += ovt.getTyp().trim();
		temp = ovt.getCnd1().trim();
		result += StringUtils.rightPad(temp, 16);
		temp = ovt.getCnd2().trim();
		result += StringUtils.rightPad(temp, 16);
		result += ovt.getGlNo().trim();
		result = StringUtils.rightPad(result, 80);
		return result;
	}
	
	public static String genIat(IatDS iat){
		String result = "";
		result += iat.getGlNo().trim();
		result += StringUtils.rightPad(iat.getCnd1().trim(), 16);
		result += StringUtils.rightPad(iat.getCnd2().trim(), 16);
		result += iat.getGlSeqNo().trim();
		result = StringUtils.rightPad(result, 80);
		return result;
	}
	
	public static String genCss(CssDS css){
		String result = "";
		result += css.getBrhno().trim();
		result += css.getGroupId().trim();
		String temp = css.getTxid().trim();
		if(temp.length() == 6){
			temp = css.getGroupId().trim() + temp;
		}else{
			temp = StringUtils.rightPad(result, 9);
		}
		result += temp;
		result += css.getOldCnd().trim();
		result += css.getNewCnd().trim();
		result = StringUtils.rightPad(result, 80);
		return result;
	}
	
	public static String[] getFirstTwoCndRow(List<ColName> colname){
		String result[] = new String[2];
		int len = colname.size();
		result[0] = "$$";
		ColName col = colname.get(0);
		result[0] += col.getGroupId();
		if(len < 10){
			result[0] += "0" + colname.size();
		}else{
			result[0] += colname.size();
		}
		for(ColName colName : colname){
			if (colName.getCndLen() < 10){
				result[0] += "C0" + colName.getCndLen();
			}else{
				result[0] += "C" + colName.getCndLen();
			}
		}
	    for(int i = len ; i < 16 ; i++){
	    	result[0] += " 00";
	    }
	    result[0] = StringUtils.rightPad(result[0], 256);
	    
	    result[1] = "$$";
	    result[1] += col.getGroupId();
	    for(ColName colName : colname){
	    	if(null != colName.getCndSource() && colName.getCndSource().trim().length() != 0){
	    		result[1] += colName.getCndSource().trim();
	    	}else{
	    		result[1] += " ";
	    	}
	    	if(null != colName.getCndSourceNo() && colName.getCndSourceNo().trim().length() != 0){
	    		result[1] += colName.getCndSourceNo().trim();
	    	}else{
	    		result[1] += "  ";
	    	}
	    }
	    result[1] = StringUtils.rightPad(result[1], 256);
		return result;
	}
	
	public static short[] getCndLen(List<ColName> colname){
		int size = colname.size();
		short[] result = new short[size];
		short i = 0;
		for(ColName colName : colname){
			result[i] = colName.getCndLen();
			i++;
		}
		return result;
	}
	
	public static String genCnd(CndDS cnd , short len , short[] cndlen){
		String result = "";String temp = "";
		temp = cnd.getTxId().trim();
		if(temp.length() == 6){
			temp = cnd.getGroupId().trim() + temp;
		}else{
			temp = StringUtils.rightPad(temp, 9);
		}
		result += temp;
		result += cnd.getCndNo().trim();
		result += getCnd(cnd.getCnd1(),cndlen[0]);
		result += getCnd(cnd.getCnd2(),cndlen[1]);
		result += getCnd(cnd.getCnd3(),cndlen[2]);
		result += getCnd(cnd.getCnd4(),cndlen[3]);
		result += getCnd(cnd.getCnd5(),cndlen[4]);
		result += getCnd(cnd.getCnd6(),cndlen[5]);
		result += getCnd(cnd.getCnd7(),cndlen[6]);
		result += getCnd(cnd.getCnd8(),cndlen[7]);
		result += getCnd(cnd.getCnd9(),cndlen[8]);
		result += getCnd(cnd.getCnd10(),cndlen[9]);
		result += getCnd(cnd.getCnd11(),cndlen[10]);
		result += getCnd(cnd.getCnd12(),cndlen[11]);
		result += getCnd(cnd.getCnd13(),cndlen[12]);
		result += getCnd(cnd.getCnd14(),cndlen[13]);
		result += getCnd(cnd.getCnd15(),cndlen[14]);
		result += getCnd(cnd.getCnd16(),cndlen[15]);
		result = StringUtils.rightPad(result, 256);
		return result;
		
	}
	
	private static String getCnd(String s,int slen){
		String cnd = s.trim();;
		if (cnd == null){
			cnd = "";
		}
		int i = cnd.length();
		if(i > 0){
			if (i >= 2){
				if(cnd.charAt(1)=='='||cnd.charAt(1)=='>'){
					if(cnd.substring(0,2).equals(">="))
						cnd = "5" + cnd.substring(2);
					if(cnd.substring(0,2).equals("<="))
						cnd = "3" + cnd.substring(2);
					if(cnd.substring(0,2).equals("<>"))
						cnd = "6" + cnd.substring(2);
				}else if(cnd.charAt(0)=='='||cnd.charAt(0)=='>'||cnd.charAt(0)=='<'){
					if(cnd.charAt(0)=='=')
						cnd = "1" + cnd.substring(1);
					if(cnd.charAt(0)=='>')
						cnd = "4" + cnd.substring(1);
					if(cnd.charAt(0)=='<')
						cnd = "2" + cnd.substring(1);
				}else{
					cnd = "1" + cnd;;
				}
			}else{
				cnd = "1" + cnd;
			}
			return StringUtils.rightPad(cnd,1 + slen);
		}else{
			
			return StringUtils.rightPad(cnd,1 + slen);
		}
	}

	
	public static void main(String[] args){
		
		System.out.println(getCnd("1",1));
		
		ArtDS a = new ArtDS();
		a.setOverRide("");
		a.setTxId("KLNLNP1");
		a.setAcrlNo("0001");
		a.setSeqNo('A');
		a.setDebitOrCredit(' ');
		a.setGlNo("9015");
		a.setAccount("2222");
		a.setAmtPoint("1+22");
		a.setGlSeqNo("");
		a.setOverRide("");
		System.out.println(genArt(a));
		OvtDS ovt = new OvtDS();
		ovt.setGroupId("LN0");
		ovt.setTyp("01");
		ovt.setCnd1("111");
		ovt.setCnd2("Y");
		ovt.setGlNo("60110501");
		System.out.println(genOvt(ovt));
		
		IatDS iat = new IatDS();
		iat.setGroupId("LN0");
		iat.setGlNo("60110501");
		iat.setCnd1("153");
		iat.setCnd2("LN0");
		iat.setGlSeqNo("000001");
		System.out.println(genIat(iat));
		
		CndDS cnd = new CndDS();
		cnd.setGroupId("LN0");
		cnd.setCndNo("0001");
		//cnd.setCnd1(cnd1);
		
		
	
	}


}
