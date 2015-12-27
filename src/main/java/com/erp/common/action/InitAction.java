package com.erp.common.action;

import java.util.Map;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import com.erp.common.IService.IUserInfoService;
import com.erp.common.dataSet.UserInfo;
import com.erp.common.util.Const;
import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport{
	
	private UserInfo userinfo;
	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	private IUserInfoService userInfoService;
	
	public String init(){
		return SUCCESS;
	}
	
	public String login(){
		System.out.println("Login action be called");
		char[] password = new Md5Hash(userinfo.getPassWord()).toString().toCharArray();
		//System.out.println(test);
		//char[] password = userinfo.getPassWord().toCharArray();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(userinfo.getUserID());
		token.setPassword(password);
		token.setRememberMe(true);
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			this.addActionError(Const.ERROR_WRONG_USERNAME_OR_PASSWORD);
			return ERROR;
		}
		return SUCCESS;
		/*
		UserInfo dbUserinfo = userInfoService.getOneUserInfo(userinfo);
			if(dbUserinfo != null){
				//System.out.println(MD5Util.digest(password));
				//System.out.println(dbUserinfo.getPassWord());
				if(MD5Util.digest(userinfo.getPassWord()).equals(dbUserinfo.getPassWord())){
					ActionContext actionContext = ActionContext.getContext();
					Map<String,Object> session = actionContext.getSession();
					//actionContext.getSession().put(Const.USERINFO, dbUserinfo);	
					session.put("userID", dbUserinfo.getUserID());
					session.put("userName", dbUserinfo.getUserName());
					session.put("email", dbUserinfo.getEmail());
					session.put("level", dbUserinfo.getLevel());
					session.put("groupId", dbUserinfo.getGroupId());
					return SUCCESS;
				}	
				
			}
			this.addActionError(Const.ERROR_WRONG_USERNAME_OR_PASSWORD);
			return ERROR; */
	}

}
