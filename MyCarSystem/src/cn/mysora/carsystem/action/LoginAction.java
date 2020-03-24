package cn.mysora.carsystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.mysora.carsystem.biz.AdminBiz;
import cn.mysora.carsystem.biz.CarBiz;
import cn.mysora.carsystem.biz.MemberCarBiz;
import cn.mysora.carsystem.biz.ParkBiz;
import cn.mysora.carsystem.biz.impl.AdminBizImpl;
import cn.mysora.carsystem.biz.impl.CarBizImpl;
import cn.mysora.carsystem.biz.impl.MemberCarBizImpl;
import cn.mysora.carsystem.biz.impl.ParkBizImpl;
import cn.mysora.carsystem.entity.Admin;
import cn.mysora.carsystem.entity.Car;
import cn.mysora.carsystem.entity.MemberCar;
import cn.mysora.carsystem.entity.Park;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private AdminBiz aBiz = new AdminBizImpl();
	private ParkBiz pBiz = new ParkBizImpl();
	private MemberCarBiz mBiz = new MemberCarBizImpl();
	private CarBiz cBiz = new CarBizImpl();
	
	private Map<String, Object> session;
	
	private String adminName;
	private String password;
	private String loginResultPage;
	

	
	@Override
	public String execute() throws Exception {
		System.out.println("LoginAction: execute() 进入");
		String loginResult = aBiz.login(adminName, password);
		//取出登录用户的信息
		System.out.println("LoginAction: 取得登陆结果：" + loginResult);
		Admin loginAdmin = aBiz.getByAdminName(adminName);
		session.put("loginAdmin", loginAdmin); 
		List<Car> carList = cBiz.getAll();
		List<MemberCar> memberCarList = mBiz.getAll();
		List<Park> parkList = pBiz.getAll();
		session.put("carList", carList);
		session.put("memberCarList", memberCarList);
		session.put("parkList", parkList);
		System.out.println("LoginAction: execute() 开始判断");
		if ("用户不存在".equals(loginResult) || "密码错误".equals(loginResult)) {
			this.addActionError(loginResult);
			loginResultPage = "login.jsp";
			
		} else if ("超级管理员登录".equals(loginResult)) {
			List<Admin> adminList = aBiz.getAll();
			session.put("adminList", adminList);
			loginResultPage = "superadmin/superadmin.jsp";
			
		} else if ("停车场管理员登录".equals(loginResult)) {
			loginResultPage = "admin/admin.jsp";
		} else {
			this.addActionError("参数错误");
			loginResultPage = "login.jsp";
		}
		return SUCCESS;
	}
	
	
	

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginResultPage() {
		return loginResultPage;
	}
	public void setLoginResultPage(String loginResultPage) {
		this.loginResultPage = loginResultPage;
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
