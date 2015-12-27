package com.erp.common.IService;

import java.util.List;

import com.erp.common.dataSet.UserInfo;

public interface IUserInfoService {
	
	public abstract UserInfo getOneUserInfo(UserInfo userinfo);
	
	public abstract int addOneUserInfo(UserInfo userinfo);
	
	public abstract List<UserInfo> getUserList(UserInfo userinfo);
	
	public abstract int deleteUserInfo(String userID);

}
