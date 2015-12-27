package com.erp.common.action;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import com.erp.common.util.Const;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5812885382142367935L;
	private String userName;
	private String passWord;
	private boolean rememberMe;
	
	public String init(){
		return SUCCESS;
	}
	
	public String login(){
		//System.out.println("Login action be called");
		char[] password = new Md5Hash(passWord).toString().toCharArray();
		//System.out.println(test);

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken();
		//subject.
		//System.out.println(rememberMe);
		token.setUsername(userName);
		token.setPassword(password);
		token.setRememberMe(rememberMe);
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			this.addActionError(Const.ERROR_WRONG_USERNAME_OR_PASSWORD);
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}
