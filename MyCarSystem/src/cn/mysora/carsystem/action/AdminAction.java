package cn.mysora.carsystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.mysora.carsystem.biz.AdminBiz;
import cn.mysora.carsystem.biz.impl.AdminBizImpl;
import cn.mysora.carsystem.entity.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {

	AdminBiz aBiz = new AdminBizImpl();
	public Map<String, Object> session;
	
	private Admin admin;
	private Admin adminUpdate;
	private int adminId;

	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdminUpdate() {
		return adminUpdate;
	}
	public void setAdminUpdate(Admin adminUpdate) {
		this.adminUpdate = adminUpdate;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	
	public String details(){
		Admin admin = aBiz.getById(adminId);
		session.put("admin", admin);
		return "details";
	}
	
	public String update(){
		aBiz.update(adminUpdate);
		common();
		return "update";
	}
	
	public String save() {
		aBiz.save(admin);
		common();
		System.out.println("AdminAction:返回save");
		return "save";
	}
	
	public String delete() {
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		aBiz.delete(admin);
		common();
		System.out.println("AdminAction:返回delete");
		return "delete";
	}
	
	
	public void common() {
		List<Admin> adminList = aBiz.getAll();
		session.put("adminList", adminList);
		
		System.out.println("AdminAction:刷新AdminList");
	}
	
	
	
	public String show(){
		System.out.println("AdminAction:返回show");
		return "show";
	}
	public String input() {
		System.out.println("AdminAction:返回input");
		return "input";
	}
	
	public String exit() {
		System.out.println("AdminAction:返回exit");
		return " exit";
	}
		
		
}
