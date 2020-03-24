package cn.mysora.carsystem.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 车辆信息，进入停车场所有车辆信息
 * 
 * @author xarox
 *
 */
public class Car implements Serializable{
	private int carId;
	private String carNumber;
	private Park park; //车辆进入哪个停车场
	private Date carInTime;
	//private Date carOutTime;
	private String isMemberCar;
	private String carDescribe;
	private Admin admin;//哪个停车场管理员操作
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int carId, String carNumber, Park park, Date carInTime,
			String isMemberCar, String carDescribe, Admin admin) {
		super();
		this.carId = carId;
		this.carNumber = carNumber;
		this.park = park;
		this.carInTime = carInTime;
		this.isMemberCar = isMemberCar;
		this.carDescribe = carDescribe;
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result
				+ ((carDescribe == null) ? 0 : carDescribe.hashCode());
		result = prime * result + carId;
		result = prime * result
				+ ((carInTime == null) ? 0 : carInTime.hashCode());
		result = prime * result
				+ ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result
				+ ((isMemberCar == null) ? 0 : isMemberCar.hashCode());
		result = prime * result + ((park == null) ? 0 : park.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (carDescribe == null) {
			if (other.carDescribe != null)
				return false;
		} else if (!carDescribe.equals(other.carDescribe))
			return false;
		if (carId != other.carId)
			return false;
		if (carInTime == null) {
			if (other.carInTime != null)
				return false;
		} else if (!carInTime.equals(other.carInTime))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (isMemberCar == null) {
			if (other.isMemberCar != null)
				return false;
		} else if (!isMemberCar.equals(other.isMemberCar))
			return false;
		if (park == null) {
			if (other.park != null)
				return false;
		} else if (!park.equals(other.park))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNumber=" + carNumber + ", park="
				+ park + ", carInTime=" + carInTime + ", isMemberCar="
				+ isMemberCar + ", carDescribe=" + carDescribe + ", admin="
				+ admin + "]";
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public Date getCarInTime() {
		return carInTime;
	}

	public void setCarInTime(Date carInTime) {
		this.carInTime = carInTime;
	}

	public String getIsMemberCar() {
		return isMemberCar;
	}

	public void setIsMemberCar(String isMemberCar) {
		this.isMemberCar = isMemberCar;
	}

	public String getCarDescribe() {
		return carDescribe;
	}

	public void setCarDescribe(String carDescribe) {
		this.carDescribe = carDescribe;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	
	
	
	
}
