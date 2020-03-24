package cn.mysora.carsystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.mysora.carsystem.biz.ParkBiz;
import cn.mysora.carsystem.biz.impl.ParkBizImpl;
import cn.mysora.carsystem.entity.Park;

import com.opensymphony.xwork2.ActionSupport;

public class ParkAction extends ActionSupport implements SessionAware {

	ParkBiz pBiz = new ParkBizImpl();
	public Map<String, Object> session;
	
	private Park park;
	private Park parkUpdate;
	private int parkId;
	
	public Park getPark() {
		return park;
	}
	public void setPark(Park park) {
		this.park = park;
	}
	public Park getParkUpdate() {
		return parkUpdate;
	}
	public void setParkUpdate(Park parkUpdate) {
		this.parkUpdate = parkUpdate;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	
	
	public String details(){
		Park park = pBiz.getById(parkId);
		session.put("park", park);
		return "details";
	}
	
	public String update(){
		pBiz.update(parkUpdate);
		common();
		return "update";
	}
	
	
	public String save() {
		pBiz.save(park);
		common();
		System.out.println("ParkAction:返回save");
		return "save";
	}
	
	public String delete() {
		Park park = new Park();
		park.setParkId(parkId);
		pBiz.delete(park);
		common();
		System.out.println("ParkAction:返回delete");
		return "delete";
	}
	
	public void common() {
		List<Park> parkList = pBiz.getAll();
		session.put("parkList", parkList);
		System.out.println("ParkAction:刷新parkList");
	}
	
	
	public String show(){
		System.out.println("ParkAction:返回show");
		return "show";
	}
	public String input() {
		System.out.println("ParkAction:返回input");
		return "input";
	}
	
	
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

}
