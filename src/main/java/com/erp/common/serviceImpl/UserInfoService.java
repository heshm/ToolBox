package com.erp.common.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IUserInfoDAO;
import com.erp.common.IService.IUserInfoService;
import com.erp.common.dataSet.UserInfo;

@Transactional
public class UserInfoService implements IUserInfoService {
	
	private IUserInfoDAO userInfoDAO;
	
	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	@Override
	public UserInfo getOneUserInfo(UserInfo userinfo) {
		return userInfoDAO.getOneUserInfo(userinfo);
	}

	@Override
	public int addOneUserInfo(UserInfo userinfo) {
		//userInfoDAO.addOneUserInfo(userinfo);
		return userInfoDAO.addOneUserInfo(userinfo);
	}

	@Override
	public List<UserInfo> getUserList(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoDAO.getUserList(userinfo);
	}

	@Override
	public int deleteUserInfo(String userID) {
		// TODO Auto-generated method stub
		return userInfoDAO.deleteUserInfo(userID);
	}

}
