package cn.mysora.carsystem.biz;

import java.util.List;

import cn.mysora.carsystem.entity.MemberCar;

/**
 * 成员车辆信息 操作 业务层
 * 接口定义
 * @author xarox
 *
 */
public interface MemberCarBiz {
	public List<MemberCar> getAll();
	public MemberCar getById(int id);
	public MemberCar getBycarNumber(String carNumber);
	
	public int save(MemberCar memberCar);
	public int update(MemberCar memberCar);
	public int delete(MemberCar memberCar);
	
	/**
	 * 判断是否是成员车辆
	 * @param carNumber车牌号
	 * @return 返回boolean
	 */
	public boolean isMember(String carNumber);
}
