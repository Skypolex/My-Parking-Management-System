package cn.mysora.carsystem.biz.impl;

import java.util.List;

import cn.mysora.carsystem.biz.AdminBiz;
import cn.mysora.carsystem.dao.AdminDao;
import cn.mysora.carsystem.dao.impl.AdminDaoImpl;
import cn.mysora.carsystem.entity.Admin;

/**
 * 管理员操作 业务层
 * 方法实现
 * @author xarox
 *
 */
public class AdminBizImpl implements AdminBiz {

	AdminDao aDao = new AdminDaoImpl();
	
	@Override
	public List<Admin> getAll() {
		return aDao.getAll();
	}

	@Override
	public Admin getById(int id) {
		return aDao.getById(id);
	}

	@Override
	public Admin getByAdminName(String adminName) {
		return aDao.getByAdminName(adminName);
	}

	@Override
	public int save(Admin admin) {
		return aDao.save(admin);
	}

	@Override
	public int update(Admin admin) {
		return aDao.update(admin);
	}

	@Override
	public int delete(Admin admin) {
		return aDao.delete(admin);
	}

	@Override
	public String login(String adminName, String password) {
		String result = null;
		//test info
		//System.out.println("adminBizimpl:" + "login(" + adminName + "," + password +")");
		System.out.println("adminBizimpl:开始获取admin用户");
		Admin admin = aDao.getByAdminName(adminName);
		System.out.println(admin);
		System.out.println("adminBizimpl:获取到" + admin + "，开始判断");
		if(admin == null){
			result="用户不存在";
		}else{
			if(password.equals(admin.getAdminPassword())){
				if("1".equals(admin.getIsSuperAdmin()))
					result="超级管理员登录";
				else
					result="停车场管理员登录";
			}else{
				result="密码错误";
			}
		}
		return result;
	}

}
