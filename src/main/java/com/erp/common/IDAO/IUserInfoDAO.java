package com.erp.common.IDAO;

import java.util.List;

import com.erp.common.dataSet.UserInfo;

public interface IUserInfoDAO {
	
	public abstract UserInfo getOneUserInfo(UserInfo userinfo);
	
	public abstract List<UserInfo> getUserList(UserInfo userinfo);
	
	public abstract int addOneUserInfo(UserInfo userinfo);
	
	public abstract int deleteUserInfo(String userID);

}
