package com.erp.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.erp.common.IService.IUserInfoService;
import com.erp.common.dataSet.UserInfo;

public class AuthRealm extends AuthorizingRealm{
	
	private IUserInfoService userInfoService;
	
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//System.out.println("Go here 3");
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		//String shiroUser = (String) principals.getPrimaryPrincipal(); 
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		char level = session.getAttribute("level").toString().charAt(0);
		switch(level){
		    case '0' : authorizationInfo.addRole("admin");
		    case '1' : authorizationInfo.addRole("dev");
		    default : authorizationInfo.addRole("guest");
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) 
			throws AuthenticationException {
		//System.out.println("Go here 1");
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String password = String.valueOf(token.getPassword());
		UserInfo info = new UserInfo();
		info.setUserID(token.getUsername());
		UserInfo userInfo = userInfoService.getOneUserInfo(info);
		if(userInfo == null){
			throw new UnknownAccountException();
		}else{
			if(userInfo.getPassWord().equals(password)){
				session.setAttribute("userID", userInfo.getUserID());
				session.setAttribute("userName", userInfo.getUserName());
				session.setAttribute("email", userInfo.getEmail());
				session.setAttribute("level", userInfo.getLevel());
				session.setAttribute("groupId", userInfo.getGroupId());
				return new SimpleAuthenticationInfo(
						userInfo.getUserID(),
						userInfo.getPassWord(),
						userInfo.getUserName());
			}else{
				throw new IncorrectCredentialsException();
			}
		}
	}

}
