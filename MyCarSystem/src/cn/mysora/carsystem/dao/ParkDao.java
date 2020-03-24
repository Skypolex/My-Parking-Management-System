package cn.mysora.carsystem.dao;

import java.util.List;

import cn.mysora.carsystem.dao.BaseDao;
import cn.mysora.carsystem.entity.Park;

/**
 * 停车场数据库操作
 * 接口方法定义
 * @author xarox
 *
 */
public interface ParkDao extends BaseDao{
	public List<Park> getAll();
	public Park getById(int id);
	public Park getByName(String parkName);
	
	public int save(Park park);
	public int update(Park park);
	public int delete(Park park);
}
