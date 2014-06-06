package com.tencent.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {	
	private static final long serialVersionUID = 9163968110901013309L;

	protected String tip;

	protected Map<String,Object> request;   
	protected Map<String,Object> session;
	protected Map<String,Object> application;

    @Override
    public void setApplication(Map<String, Object> application) {
       this.application=application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
       this.request=request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
       this.session=session;
    }
    

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
