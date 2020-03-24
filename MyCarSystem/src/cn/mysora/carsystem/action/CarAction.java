package cn.mysora.carsystem.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.mysora.carsystem.biz.CarBiz;
import cn.mysora.carsystem.biz.ParkBiz;
import cn.mysora.carsystem.biz.impl.CarBizImpl;
import cn.mysora.carsystem.biz.impl.ParkBizImpl;
import cn.mysora.carsystem.entity.Car;
import cn.mysora.carsystem.entity.Park;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CarAction extends ActionSupport implements SessionAware {

	ParkBiz pBiz = new ParkBizImpl();
	CarBiz cBiz = new CarBizImpl();
	public Map<String, Object> session;
	
	private Car car;
	private Car carUpdate;
	private int carId;

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Car getCarUpdate() {
		return carUpdate;
	}
	public void setCarUpdate(Car carUpdate) {
		this.carUpdate = carUpdate;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	
	public String details(){
		Car car = cBiz.getById(carId);
		session.put("car", car);
		return "details";
	}
	
	public String update(){
		cBiz.update(carUpdate);
		common();
		System.out.println("CarAction:返回update");
		return "update";
	}
	
	//新车辆进入 调用保存，自动查询是否为成员车辆
	public String save() {
		Date date = new Date(System.currentTimeMillis());
		car.setCarInTime(date);
		car.setIsMemberCar(cBiz.isMemberCar(car.getCarNumber()));
		car.setCarDescribe(cBiz.getMemberCarDescribe(car.getCarNumber()));
		pBiz.carInPark(car.getPark().getParkId()); 
		cBiz.save(car);
		common();
		System.out.println("CarAction:返回save");
		return "save";
	}
	
	public String delete() {
		System.out.println("CarAction:delete进入1");
		Car car = new Car();
		//car.setCarId(carId);
		car = cBiz.getById(carId);
		System.out.println("CarAction:delete进入2");
		System.out.println("CarAction:car: " + car);
		System.out.println("CarAction:ParkId: " + car.getPark().getParkId());
		pBiz.carOutPark(car.getPark().getParkId());  //有问题！
		System.out.println("CarAction:delete进入3");
		cBiz.delete(car);//可以正常运行
		System.out.println("CarAction:delete进入4");
		common();
		System.out.println("CarAction:返回deletedeletedeletedelete");
		return "delete";
	}
	
	public String check(){
		Car car = cBiz.getById(carId);
		session.put("car", car);
		double carParkingFee = cBiz.calculateParkingFee(carId);
		String carParkingTime = cBiz.calculateParkingTime(carId);
		if (car.getIsMemberCar().equals("是")) {
			carParkingFee = 0.0;
		}
		session.put("carParkingFee", carParkingFee);
		session.put("carParkingTime", carParkingTime);
		common();
		System.out.println("CarAction:返回check");
		return "check";
	}
	
	public void common() {
		List<Car> carList = cBiz.getAll();
		session.put("carList", carList);
		System.out.println("CarAction:刷新carList");
		List<Park> parkList = pBiz.getAll();
		session.put("parkList", parkList);
		System.out.println("CarAction:刷新parkList");
	}
	public String show(){
		System.out.println("CarAction:返回show");
		return "show";
	}
	public String input() {
		System.out.println("CarAction:返回input");
		return "input";
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}


}
