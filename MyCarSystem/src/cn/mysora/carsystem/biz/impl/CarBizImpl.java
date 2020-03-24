package cn.mysora.carsystem.biz.impl;

import java.sql.Date;
import java.util.List;

import cn.mysora.carsystem.biz.CarBiz;
import cn.mysora.carsystem.dao.CarDao;
import cn.mysora.carsystem.dao.MemberCarDao;
import cn.mysora.carsystem.dao.ParkDao;
import cn.mysora.carsystem.dao.impl.CarDaoImpl;
import cn.mysora.carsystem.dao.impl.MemberCarDaoImpl;
import cn.mysora.carsystem.dao.impl.ParkDaoImpl;
import cn.mysora.carsystem.entity.Car;
import cn.mysora.carsystem.entity.MemberCar;
import cn.mysora.carsystem.entity.Park;

/**
 * 管理员操作 业务层
 * 方法实现
 * @author xarox
 *
 */
public class CarBizImpl implements CarBiz {

	CarDao cDao = new CarDaoImpl();
	ParkDao pDao = new ParkDaoImpl();
	MemberCarDao mDao = new MemberCarDaoImpl();
	
	@Override
	public List<Car> getAll() {
		return cDao.getAll();
	}

	@Override
	public Car getById(int id) {
		return cDao.getById(id);
	}

	@Override
	public Car getByNumber(String carNumber) {
		return cDao.getByNumber(carNumber);
	}

	@Override
	public int save(Car car) {
		return cDao.save(car);
	}

	@Override
	public int update(Car car) {
		return cDao.update(car);
	}

	@Override
	public int delete(Car car) {
		return cDao.delete(car);
	}


	@Override
	public double calculateParkingFee(int carId) {
		double parkinFee;
		Date inDate;
		Date outDate;
		Car car = cDao.getById(carId);
		inDate = car.getCarInTime();
		outDate = new Date(System.currentTimeMillis()); 
		
		Park park = car.getPark();
		Double feePreHour = park.getPricePreHour();
        
		if(outDate == null || inDate == null){
            return 0;
        }
        //停车时间,单位毫秒
        long time = outDate.getTime() - inDate.getTime();
        long hour = 60*60*1000;
        if(time < hour){
        	parkinFee = feePreHour;
        }else if(time%hour == 0){
        	parkinFee = (int)(time/hour * feePreHour);
        }else{
        	parkinFee = (int)((time/hour+1) * feePreHour);
        }
        return parkinFee;
    }

	@Override
	public String calculateParkingTime(int carId) {
		String stopTimeString;
		Car car = cDao.getById(carId);
		long inTime = car.getCarInTime().getTime();
		long outTime = System.currentTimeMillis(); ;
		long stopTime = outTime - inTime;;
		
        long day = stopTime / (24 * 60 * 60 * 1000);  
        long hour = (stopTime / (60 * 60 * 1000) - day * 24);  
        long min = ((stopTime / (60 * 1000)) - day * 24 * 60 - hour * 60);  
		
        stopTimeString = day + "天" + hour + "小时" + min + "分钟";
        
		return stopTimeString;
	}

	@Override
	public String isMemberCar(String carNumber) {
		MemberCar memberCar = null;
		memberCar = mDao.getBycarNumber(carNumber);
		if (memberCar != null) {
			return "是";
		} else {
			return "否";
		}
	}

	@Override
	public String getMemberCarDescribe(String carNumber) {
		MemberCar memberCar = null;
		memberCar = mDao.getBycarNumber(carNumber);
		if (memberCar != null) {
			return memberCar.getCarDescribe();
		} else {
			return "临时车辆";
		}
	}


}
