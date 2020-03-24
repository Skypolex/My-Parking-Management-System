package cn.mysora.carsystem.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutActoin extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		System.out.println("LogoutAction: execute() 进入");
		session.clear();
		System.out.println("LogoutAction: session.clear() 完成");
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
