package cn.mysora.carsystem.biz;

import java.util.List;

import cn.mysora.carsystem.entity.Park;
/**
 * 停车场信息 操作 业务层
 * 接口定义
 * @author xarox
 *
 */
public interface ParkBiz {
	public List<Park> getAll();
	public Park getById(int id);
	public Park getByName(String parkName);
	
	public int save(Park park);
	public int update(Park park);
	public int delete(Park park);
	
	/**
	 * 车辆离开停车场，车位增加
	 * @param int parkId 停车场id
	 * @return void
	 */
	public void carOutPark(int parkId);
	
	/**
	 * 车辆进入停车场，车位减少
	 * @param int parkId 停车场id
	 * @return void
	 */
	public void carInPark(int parkId);
	
	/**
	 * 当前剩余 停车位
	 * @param int parkId 停车场id
	 * @return int 停车位 数量
	 */
	public int parkSpaceNum(int parkId);
}
