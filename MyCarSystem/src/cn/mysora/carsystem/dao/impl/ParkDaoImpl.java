package cn.mysora.carsystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mysora.carsystem.dao.ParkDao;
import cn.mysora.carsystem.entity.Park;

public class ParkDaoImpl extends BaseDaoImpl implements ParkDao {
	
	@Override
	public List<Park> getAll() {
		List<Park> parkList = new ArrayList<Park>();
		String sql="select * from PARK order by PARK_ID";
		rs = super.executeQuery(sql , null);
		try {
			while (rs.next()) {
				Park park = new Park();
				park.setParkId(rs.getInt("PARK_ID"));
				park.setParkName(rs.getString("PARK_NAME"));
				park.setMaxCarValue(rs.getInt("MAX_CAR_VALUE"));
				park.setCarValue(rs.getInt("CAR_VALUE"));
				park.setPricePreHour(rs.getDouble("PRICE_PRE_HOUR"));
				park.setPriceDay(rs.getDouble("PRICE_DAY"));
				parkList.add(park);
			}
		} catch (SQLException e) {
			System.out.println("ParkDaoImpl:getAll() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return parkList;
	}

	@Override
	public Park getById(int id) {
		Park park = null;
		String sql= "select * from PARK where PARK_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {			
				park = new Park();
				park.setParkId(rs.getInt("PARK_ID"));
				park.setParkName(rs.getString("PARK_NAME"));
				park.setMaxCarValue(rs.getInt("MAX_CAR_VALUE"));
				park.setCarValue(rs.getInt("CAR_VALUE"));
				park.setPricePreHour(rs.getDouble("PRICE_PRE_HOUR"));
				park.setPriceDay(rs.getDouble("PRICE_DAY"));
			}
		} catch (SQLException e) {
			System.out.println("ParkDaoImpl:getById() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return park;
	}

	@Override
	public Park getByName(String parkName) {
		Park park = null;
		String sql= "select * from PARK where PARK_NAME=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(parkName);
		rs = super.executeQuery(sql,objs);
		try {
			while (rs.next()) {			
				park = new Park();
				park.setParkId(rs.getInt("PARK_ID"));
				park.setParkName(rs.getString("PARK_NAME"));
				park.setMaxCarValue(rs.getInt("MAX_CAR_VALUE"));
				park.setCarValue(rs.getInt("CAR_VALUE"));
				park.setPricePreHour(rs.getDouble("PRICE_PRE_HOUR"));
				park.setPriceDay(rs.getDouble("PRICE_DAY"));
			}
		} catch (SQLException e) {
			System.out.println("ParkDaoImpl:getByName() 数据库异常");
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return park;
	}

	@Override
	public int save(Park park) {
		String sql="insert into PARK values (parks_id.nextval,?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(park.getParkName());
		objs.add(park.getMaxCarValue());
		objs.add(park.getCarValue());
		objs.add(park.getPricePreHour());
		objs.add(park.getPriceDay());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int update(Park park) {
		String sql="update PARK set PARK_NAME=?,MAX_CAR_VALUE=?,CAR_VALUE=?,PRICE_PRE_HOUR=?,PRICE_DAY=? where PARK_ID=?";
		List<Object> objs = new ArrayList<Object>();
		
		objs.add(park.getParkName());
		objs.add(park.getMaxCarValue());
		objs.add(park.getCarValue());
		objs.add(park.getPricePreHour());
		objs.add(park.getPriceDay());
		objs.add(park.getParkId());
		
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

	@Override
	public int delete(Park park) {
		String sql="delete from PARK where PARK_ID=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(park.getParkId());
		flag = super.executeUpdate(sql, objs);
		return flag;
	}

}
