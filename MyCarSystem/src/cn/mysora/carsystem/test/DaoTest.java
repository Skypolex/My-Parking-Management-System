package cn.mysora.carsystem.test;

import java.util.List;

import java.util.Map;

import org.junit.Test;

import cn.mysora.carsystem.action.LoginAction;
import cn.mysora.carsystem.biz.AdminBiz;
import cn.mysora.carsystem.biz.impl.AdminBizImpl;
import cn.mysora.carsystem.dao.*;
import cn.mysora.carsystem.dao.impl.*;
import cn.mysora.carsystem.entity.Admin;

public class DaoTest {
	AdminDao adminDao = new AdminDaoImpl();
	CarDao carDao = new CarDaoImpl();
	ParkDao parkDao = new ParkDaoImpl();
	MemberCarDao memberCarDao = new MemberCarDaoImpl();

	
	AdminBiz aBiz = new AdminBizImpl();
	
	
	
//	@Test
	public void testAdminSave(){
		Admin admin = new Admin(2222, "admin", "admin", "1");
		adminDao.save(admin);
		Admin admin2 = new Admin(2222, "admin2", "admin2", "1");
		adminDao.save(admin2);
		Admin admin3 = new Admin(2222, "admin3", "admin3", "1");
		adminDao.save(admin3);
	}
	
	@Test
	public void testAdminGetAll() {
		List<Admin> adminsList = adminDao.getAll();
		for (Admin admin : adminsList) {
			System.out.println(admin);
		}
		
		LoginAction loginAction = new LoginAction();
		String reString = null;
		Map<String, Object> session = null;
		try {
			loginAction.setAdminName("park1");
			loginAction.setPassword("park1");
			loginAction.setSession(session);
			reString = loginAction.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(reString);
		System.out.println(loginAction.getLoginResultPage());
		
		
	}
	
	
	
//	//@Test
//	public void testAdminDelete() {
//		Admin admin2 = new Admin(5, "jjjj", "kkkkk", "1");
//		adminDao.delete(admin2);
//
//	}

}
