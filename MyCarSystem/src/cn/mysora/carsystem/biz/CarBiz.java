package cn.mysora.carsystem.biz;

import java.util.List;

import cn.mysora.carsystem.entity.Car;

/**
 * 车辆操作 业务层
 * 接口定义
 * @author xarox
 *
 */
public interface CarBiz {
	public List<Car> getAll();
	public Car getById(int id);
	public Car getByNumber(String carNumber);
	
	public int save(Car car);
	public int update(Car car);
	public int delete(Car car);
	
	
	/**
	 * 计算现在离开停车场的 停车费
	 * @param carId 车辆id
	 * @return double 返回停车费用
	 */
	public double calculateParkingFee(int carId);
	
	/**
	 * 计算现在离开停车场的 停车时间
	 * @param carId 车辆id
	 * @return String 返回停车时间
	 */
	public String calculateParkingTime(int carId);
	
	/**
	 * 判断车辆是否是成员车
	 * @param carNumber车牌号
	 * @return String 返回“是”“否”
	 */
	public String isMemberCar(String carNumber);
	
	/**
	 * 得到成员车辆的描述信息
	 * @param carNumber车牌号
	 * @return String 描述信息
	 */
	public String getMemberCarDescribe(String carNumber);
	

}
