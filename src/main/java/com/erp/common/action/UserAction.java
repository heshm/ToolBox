package com.erp.common.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.struts2.ServletActionContext;

import com.erp.common.IService.IUserInfoService;
import com.erp.common.dataSet.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends CommonAction{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//request
    private UserInfo userinfo;
	
	//response
	private List<UserInfo> userList;

	//service
	private IUserInfoService userInfoService;
	
	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public List<UserInfo> getUserList() {
		return userList;
	}
	
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	@RequiresRoles("admin")
	public String user_query(){
		userList = userInfoService.getUserList(null);
		
		//System.out.println(userList.isEmpty());
		//request.setAttribute("userList", userList);
		return SUCCESS;
	}
	
	public String user_delete(){
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String userID = request.getParameter("userId");
		//System.out.println(userID);
		userInfoService.deleteUserInfo(userID);
		userList = userInfoService.getUserList(null);
		return SUCCESS;
	}
}
