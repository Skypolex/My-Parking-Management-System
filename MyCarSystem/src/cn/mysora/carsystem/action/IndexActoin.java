package cn.mysora.carsystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.mysora.carsystem.biz.CarBiz;
import cn.mysora.carsystem.biz.ParkBiz;
import cn.mysora.carsystem.biz.impl.CarBizImpl;
import cn.mysora.carsystem.biz.impl.ParkBizImpl;
import cn.mysora.carsystem.entity.Park;

public class IndexActoin extends ActionSupport implements SessionAware {


	public Map<String, Object> session;
	private ParkBiz pBiz = new ParkBizImpl();
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("IndexActoin: execute() 进入");
		List<Park> parkList = pBiz.getAll();
		session.put("parkList", parkList);
		
		return SUCCESS;
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	

}
