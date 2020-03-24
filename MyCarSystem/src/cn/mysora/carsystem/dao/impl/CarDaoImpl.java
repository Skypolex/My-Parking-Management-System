package cn.mysora.carsystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mysora.carsystem.dao.AdminDao;
import cn.mysora.carsystem.dao.CarDao;
import cn.mysora.carsystem.dao.ParkDao;
import cn.mysora.carsystem.entity.Car;

/**
 * 车辆数据库操作
 * 具体实现类
 * @author xarox
 *
 */
public class CarDaoImpl extends BaseDaoImpl implements CarDao {

	AdminDao adao = new AdminDaoImpl();
	ParkDao pdao = new ParkDaoImpl();
	
	@Override
	public List<Car> getAll() {
		List<Car> carList = new ArrayList<Car>();
		
		String sql = "select * from CAR order by CAR_IN_TIME desc";
		rs = super.executeQuery(sql , null);
		try {
			while (rs.next()) {
				Car car = new Car();
				car.setCarId(rs.getInt("CAR_ID"));
				car.setCarNumber(rs.getString("CAR_NUMBER"));
				car.setPark(pdao.getById(rs.getInt("PARK_ID")));
				car.setCarInTime(rs.getDate("CAR_IN_TIME"));
				car.setIsMemberCar(rs.getString("IS_MEMBER_CAR"));
				car.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				car.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
				carList.add(car);
			}
		} catch (SQLException e) {
			System.out.println("CarDaoImpl:getAll() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return carList;
		
	}

	@Override
	public Car getById(int id) {
		Car car = null;
		String sql= "select * from CAR where CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {		
				car = new Car();
				car.setCarId(rs.getInt("CAR_ID"));
				car.setCarNumber(rs.getString("CAR_NUMBER"));
				car.setPark(pdao.getById(rs.getInt("PARK_ID")));
				car.setCarInTime(rs.getDate("CAR_IN_TIME"));
				car.setIsMemberCar(rs.getString("IS_MEMBER_CAR"));
				car.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				car.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
			}
		} catch (SQLException e) {
			System.out.println("CarDaoImpl:getById() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return car;
	}

	@Override
	public Car getByNumber(String carNumber) {
		Car car = null;
		String sql= "select * from CAR where CAR_NUMBER=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(carNumber);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {		
				car = new Car();
				car.setCarId(rs.getInt("CAR_ID"));
				car.setCarNumber(rs.getString("CAR_NUMBER"));
				car.setPark(pdao.getById(rs.getInt("PARK_ID")));
				car.setCarInTime(rs.getDate("CAR_IN_TIME"));
				car.setIsMemberCar(rs.getString("IS_MEMBER_CAR"));
				car.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				car.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
			}
		} catch (SQLException e) {
			System.out.println("CarDaoImpl:getById() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return car;
	}

	@Override
	public int save(Car car) {
		String sql="insert into CAR values (cars_id.nextval,?,?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(car.getCarNumber());	//1
		objs.add(car.getPark().getParkId());	//2
		objs.add(car.getCarInTime());	//3
		objs.add(car.getIsMemberCar());		//4
		objs.add(car.getCarDescribe());		//5
		objs.add(car.getAdmin().getAdminId());	//6
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int update(Car car) {
		String sql="update CAR set CAR_NUMBER=?,PARK_ID=?,CAR_IN_TIME=?,IS_MEMBER_CAR=?,CAR_DESCRIBE=?,ADMIN_ID=? where CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		
		objs.add(car.getCarNumber());	//1
		objs.add(car.getPark().getParkId());	//2
		objs.add(car.getCarInTime());	//3
		objs.add(car.getIsMemberCar());		//4
		objs.add(car.getCarDescribe());		//5
		objs.add(car.getAdmin().getAdminId());	//6
		objs.add(car.getCarId());	//7
		flag = super.executeUpdate(sql, objs);
		
		return flag;
	}

	@Override
	public int delete(Car car) {
		String sql="delete from CAR where CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(car.getCarId());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

}
