package cn.mysora.carsystem.biz;

import java.util.List;

import cn.mysora.carsystem.entity.Admin;
/**
 * 管理员操作 业务层
 * 接口定义
 * @author xarox
 *
 */
public interface AdminBiz {
	public List<Admin> getAll();
	public Admin getById(int id);
	public Admin getByAdminName(String adminName);
	
	public int save(Admin admin);
	public int update(Admin admin);
	public int delete(Admin admin);
	
	
	/**
	 * 登录验证
	 * @param adminName 管理员用户名
	 * @param adminPassword 管理员密码
	 * @return String直接存储 登录验证成功不成功
	 */
	public String login(String adminName,String password);
}
