package cn.mysora.carsystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mysora.carsystem.dao.AdminDao;
import cn.mysora.carsystem.entity.Admin;
/**
 * 管理员数据库操作
 * 具体实现类
 * @author xarox
 *
 */
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

	@Override
	public List<Admin> getAll() {
		List<Admin> adminList = new ArrayList<Admin>();
		
		//从数据库得到所有管理员信息
		String sql = "select * from ADMINS";
		rs = super.executeQuery(sql , null);
		//遍历结果集，将数据封装在adminList中
		try {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setAdminPassword(rs.getString("ADMIN_PASSWORD"));
				admin.setIsSuperAdmin(rs.getString("IS_SUPER"));
				adminList.add(admin);
			}
		} catch (SQLException e) {
			System.out.println("AdminDaoImpl:getAll() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return adminList;
	}

	@Override
	public Admin getById(int id) {
		//需要返回Admin对象，在此声明
		Admin admin = null;
		
		String sql="select * from ADMINS where ADMIN_ID=?";
		//用来存放与条件“？”匹配的值的集合
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		
		rs = super.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setAdminPassword(rs.getString("ADMIN_PASSWORD"));
				admin.setIsSuperAdmin(rs.getString("IS_SUPER"));
			}
		} catch (SQLException e) {
			System.out.println("AdminDaoImpl:getById(int id) 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return admin;
		
	}

	@Override
	public Admin getByAdminName(String adminName) {
		Admin admin = null;
		String sql="select * from ADMINS where ADMIN_NAME=?";
		//用来存放与条件“？”匹配的值的集合
		List<Object> objs = new ArrayList<Object>();
		objs.add(adminName);
		
		rs = super.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				admin.setAdminPassword(rs.getString("ADMIN_PASSWORD"));
				admin.setIsSuperAdmin(rs.getString("IS_SUPER"));
			}
		} catch (SQLException e) {
			System.out.println("AdminDaoImpl:getByAdminName() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return admin;
	}

	@Override
	public int save(Admin admin) {
		String sql="insert into ADMINS values (admins_id.nextval,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(admin.getAdminName());
		objs.add(admin.getAdminPassword());
		objs.add(admin.getIsSuperAdmin());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int update(Admin admin) {
		String sql="update ADMINS set ADMIN_NAME=?,ADMIN_PASSWORD=?,IS_SUPER=? where ADMIN_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(admin.getAdminName());
		objs.add(admin.getAdminPassword());
		objs.add(admin.getIsSuperAdmin());
		objs.add(admin.getAdminId());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int delete(Admin admin) {
		String sql="delete from ADMINS where ADMIN_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(admin.getAdminId());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

}
