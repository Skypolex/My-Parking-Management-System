package cn.mysora.carsystem.entity;

import java.io.Serializable;

/**
 * 停车场类，描述停车场，停车价格，车辆数等信息
 * @author xarox
 *
 */
public class Park implements Serializable{
	private int parkId;
	private String parkName;
	private int maxCarValue;
	private int carValue;
	private double pricePreHour;
	private double priceDay;
	
	public Park() {
		// TODO Auto-generated constructor stub
	}

	public Park(int parkId, String parkName, int maxCarValue, int carValue,
			double pricePreHour, double priceDay) {
		super();
		this.parkId = parkId;
		this.parkName = parkName;
		this.maxCarValue = maxCarValue;
		this.carValue = carValue;
		this.pricePreHour = pricePreHour;
		this.priceDay = priceDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carValue;
		result = prime * result + maxCarValue;
		result = prime * result + parkId;
		result = prime * result
				+ ((parkName == null) ? 0 : parkName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceDay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pricePreHour);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Park other = (Park) obj;
		if (carValue != other.carValue)
			return false;
		if (maxCarValue != other.maxCarValue)
			return false;
		if (parkId != other.parkId)
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		if (Double.doubleToLongBits(priceDay) != Double
				.doubleToLongBits(other.priceDay))
			return false;
		if (Double.doubleToLongBits(pricePreHour) != Double
				.doubleToLongBits(other.pricePreHour))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Park [parkId=" + parkId + ", parkName=" + parkName
				+ ", maxCarValue=" + maxCarValue + ", carValue=" + carValue
				+ ", pricePreHour=" + pricePreHour + ", priceDay=" + priceDay
				+ "]";
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public int getMaxCarValue() {
		return maxCarValue;
	}

	public void setMaxCarValue(int maxCarValue) {
		this.maxCarValue = maxCarValue;
	}

	public int getCarValue() {
		return carValue;
	}

	public void setCarValue(int carValue) {
		this.carValue = carValue;
	}

	public double getPricePreHour() {
		return pricePreHour;
	}

	public void setPricePreHour(double pricePreHour) {
		this.pricePreHour = pricePreHour;
	}

	public double getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(double priceDay) {
		this.priceDay = priceDay;
	}

	
	
	

}
