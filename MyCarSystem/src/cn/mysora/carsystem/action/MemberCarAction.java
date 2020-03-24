package cn.mysora.carsystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.mysora.carsystem.biz.MemberCarBiz;
import cn.mysora.carsystem.biz.impl.MemberCarBizImpl;
import cn.mysora.carsystem.entity.MemberCar;

import com.opensymphony.xwork2.ActionSupport;

public class MemberCarAction extends ActionSupport implements SessionAware {
	
	MemberCarBiz mBiz = new MemberCarBizImpl();
	public Map<String, Object> session;
	
	private MemberCar memberCar;
	private MemberCar memberCarUpdate;
	private int memberCarId;
	
	public MemberCar getMemberCar() {
		return memberCar;
	}
	public void setMemberCar(MemberCar memberCar) {
		this.memberCar = memberCar;
	}
	public MemberCar getMemberCarUpdate() {
		return memberCarUpdate;
	}
	public void setMemberCarUpdate(MemberCar memberCarUpdate) {
		this.memberCarUpdate = memberCarUpdate;
	}
	public int getMemberCarId() {
		return memberCarId;
	}
	public void setMemberCarId(int memberCarId) {
		this.memberCarId = memberCarId;
	}

	
	public String details(){
		MemberCar memberCar = mBiz.getById(memberCarId);
		session.put("memberCar", memberCar);
		return "details";
	}
	
	public String update(){
		mBiz.update(memberCarUpdate);
		common();
		return "update";
	}
	
	
	public String save() {
		mBiz.save(memberCar);
		common();
		System.out.println("MemberCarAction:返回save");
		return "save";
	}
	
	public String delete() {
		MemberCar memberCar = new MemberCar();
		memberCar.setMemberCarId(memberCarId);
		mBiz.delete(memberCar);
		common();
		System.out.println("MemberCarAction:返回delete");
		return "delete";
	}
	
	public void common() {
		List<MemberCar> memberCarList = mBiz.getAll();
		session.put("memberCarList", memberCarList);
		System.out.println("MemberCarAction:刷新memberCarList");
	}
	
	public String show(){
		System.out.println("MemberCarAction:返回show");
		return "show";
	}
	public String input() {
		System.out.println("MemberCarAction:返回input");
		return "input";
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}


}
