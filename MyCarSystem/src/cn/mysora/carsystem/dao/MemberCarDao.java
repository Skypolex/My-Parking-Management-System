package cn.mysora.carsystem.dao;

import java.util.List;

import cn.mysora.carsystem.dao.BaseDao;
import cn.mysora.carsystem.entity.MemberCar;

/**
 * 成员车辆数据库操作
 * 接口方法定义
 * @author xarox
 *
 */
public interface MemberCarDao extends BaseDao{
	public List<MemberCar> getAll();
	public MemberCar getById(int id);
	public MemberCar getBycarNumber(String carNumber);
	
	public int save(MemberCar memberCar);
	public int update(MemberCar memberCar);
	public int delete(MemberCar memberCar);

}
