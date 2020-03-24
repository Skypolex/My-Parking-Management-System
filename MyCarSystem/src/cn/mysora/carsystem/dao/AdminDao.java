package cn.mysora.carsystem.dao;

import java.util.List;

import cn.mysora.carsystem.dao.BaseDao;
import cn.mysora.carsystem.entity.Admin;

/**
 * 管理员信息数据库操作
 * 接口方法定义
 * @author xarox
 *
 */
public interface AdminDao extends BaseDao{
	public List<Admin> getAll();
	public Admin getById(int id);
	public Admin getByAdminName(String adminName);
	
	public int save(Admin admin);
	public int update(Admin admin);
	public int delete(Admin admin);

}
