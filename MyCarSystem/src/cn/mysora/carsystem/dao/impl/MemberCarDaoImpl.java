package cn.mysora.carsystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mysora.carsystem.dao.AdminDao;
import cn.mysora.carsystem.dao.MemberCarDao;
import cn.mysora.carsystem.entity.MemberCar;

public class MemberCarDaoImpl extends BaseDaoImpl implements MemberCarDao {

	AdminDao adao = new AdminDaoImpl();
	
	@Override
	public List<MemberCar> getAll() {
		List<MemberCar> memberCarList = new ArrayList<MemberCar>();
		String sql="select * from MEMBERCAR order by MEMBER_CAR_ID desc";
		rs = super.executeQuery(sql , null);
		try {
			while (rs.next()) {
				MemberCar memberCar = new MemberCar();
				memberCar.setMemberCarId(rs.getInt("MEMBER_CAR_ID"));
				memberCar.setCarNumber(rs.getString("CAR_NUMBER"));
				memberCar.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				memberCar.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
				memberCarList.add(memberCar);
			}
		} catch (SQLException e) {
			System.out.println("MemberCarDaoImpl:getAll() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return memberCarList;
	}

	@Override
	public MemberCar getById(int id) {
		MemberCar memberCar = null;
		String sql= "select * from MEMBERCAR where MEMBER_CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {
				memberCar = new MemberCar();
				memberCar.setMemberCarId(rs.getInt("MEMBER_CAR_ID"));
				memberCar.setCarNumber(rs.getString("CAR_NUMBER"));
				memberCar.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				memberCar.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
			}
		} catch (SQLException e) {
			System.out.println("MemberCarDaoImpl:getById() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return memberCar;
	}

	@Override
	public MemberCar getBycarNumber(String carNumber) {
		MemberCar memberCar = null;
		String sql= "select * from MEMBERCAR where CAR_NUMBER=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(carNumber);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {
				memberCar = new MemberCar();
				memberCar.setMemberCarId(rs.getInt("MEMBER_CAR_ID"));
				memberCar.setCarNumber(rs.getString("CAR_NUMBER"));
				memberCar.setCarDescribe(rs.getString("CAR_DESCRIBE"));
				memberCar.setAdmin(adao.getById(rs.getInt("ADMIN_ID")));
			}
		} catch (SQLException e) {
			System.out.println("MemberCarDaoImpl:getBycarNumber() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return memberCar;
	}

	@Override
	public int save(MemberCar memberCar) {
		String sql="insert into MEMBERCAR values (members_car_id.nextval,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(memberCar.getCarNumber());		//1
		objs.add(memberCar.getCarDescribe());		//2
		objs.add(memberCar.getAdmin().getAdminId());	//3
		flag = super.executeUpdate(sql, objs);
		return flag;
		
	}

	@Override
	public int update(MemberCar memberCar) {
		String sql="update MEMBERCAR set CAR_NUMBER=?,CAR_DESCRIBE=?,ADMIN_ID=? where MEMBER_CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(memberCar.getCarNumber());		//1
		objs.add(memberCar.getCarDescribe());		//2
		objs.add(memberCar.getAdmin().getAdminId());	//3
		objs.add(memberCar.getMemberCarId());	//4
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int delete(MemberCar memberCar) {
		String sql="delete from MEMBERCAR where MEMBER_CAR_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(memberCar.getMemberCarId());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

}
