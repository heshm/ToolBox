package com.erp.common.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.erp.common.IService.IPageService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class CommonAction<T> extends ActionSupport
		implements SessionAware, ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */

	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected IPageService<T> pageService;
	

	public void setPageService(IPageService<T> pageService) {
		this.pageService = pageService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
