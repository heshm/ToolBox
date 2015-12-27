package com.erp.common.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.erp.acrl.dataSet.ArtDS;


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

	public static void main(String[] args){
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
	}


}
