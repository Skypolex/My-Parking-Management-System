package cn.mysora.carsystem.dao;

import java.util.List;

import cn.mysora.carsystem.dao.BaseDao;
import cn.mysora.carsystem.entity.Car;


/**
 * 车辆信息数据库操作
 * 接口方法定义
 * @author xarox
 *
 */
public interface CarDao extends BaseDao{
	public List<Car> getAll();
	public Car getById(int id);
	public Car getByNumber(String carNumber);
	
	public int save(Car car);
	public int update(Car car);
	public int delete(Car car);


}
