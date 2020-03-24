package cn.mysora.carsystem.entity;

import java.io.Serializable;

/**
 * 成员车辆信息
 * @author xarox
 *
 */
public class MemberCar implements Serializable{
	private int memberCarId;
	private String carNumber;
	private String carDescribe;
	private Admin admin;
	
	public MemberCar() {
		// TODO Auto-generated constructor stub
	}

	public MemberCar(int memberCarId, String carNumber, String carDescribe,
			Admin admin) {
		super();
		this.memberCarId = memberCarId;
		this.carNumber = carNumber;
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
		result = prime * result
				+ ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result + memberCarId;
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
		MemberCar other = (MemberCar) obj;
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
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (memberCarId != other.memberCarId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberCar [memberCarId=" + memberCarId + ", carNumber="
				+ carNumber + ", carDescribe=" + carDescribe + ", admin="
				+ admin + "]";
	}

	public int getMemberCarId() {
		return memberCarId;
	}

	public void setMemberCarId(int memberCarId) {
		this.memberCarId = memberCarId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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
