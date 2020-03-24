package cn.mysora.carsystem.entity;

import java.io.Serializable;

/**
 * 管理员类，停车场管理员
 * 包含管理员ID,名称,密码,信息,权限
 * @author xarox
 *
 */
public class Admin implements Serializable{
	private int adminId;
	private String adminName;
	private String adminPassword;
	private String isSuperAdmin;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminName, String adminPassword,
			String isSuperAdmin) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.isSuperAdmin = isSuperAdmin;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result
				+ ((adminPassword == null) ? 0 : adminPassword.hashCode());
		result = prime * result
				+ ((isSuperAdmin == null) ? 0 : isSuperAdmin.hashCode());
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
		Admin other = (Admin) obj;
		if (adminId != other.adminId)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (isSuperAdmin == null) {
			if (other.isSuperAdmin != null)
				return false;
		} else if (!isSuperAdmin.equals(other.isSuperAdmin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", isSuperAdmin="
				+ isSuperAdmin + "]";
	}


	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(String isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
	
	
}
