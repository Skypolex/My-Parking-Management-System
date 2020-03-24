package cn.mysora.carsystem.biz.impl;

import java.util.List;

import cn.mysora.carsystem.biz.ParkBiz;
import cn.mysora.carsystem.dao.ParkDao;
import cn.mysora.carsystem.dao.impl.ParkDaoImpl;
import cn.mysora.carsystem.entity.Park;
/**
 * 停车场信息 操作 业务层
 * 方法实现
 * @author xarox
 *
 */
public class ParkBizImpl implements ParkBiz {

	ParkDao pDao = new ParkDaoImpl();
	
	@Override
	public List<Park> getAll() {
		return pDao.getAll();
	}

	@Override
	public Park getById(int id) {
		return pDao.getById(id);
	}

	@Override
	public Park getByName(String parkName) {
		return pDao.getByName(parkName);
	}

	@Override
	public int save(Park park) {
		return pDao.save(park);
	}

	@Override
	public int update(Park park) {
		return pDao.update(park);
	}

	@Override
	public int delete(Park park) {
		return pDao.delete(park);
	}

	
	@Override
	public void carOutPark(int parkId) {
		int newCarValue;
		System.out.println("carOutPark1");
		Park udPark = pDao.getById(parkId); 
		System.out.println("carOutPark2 旧的" + udPark);
		newCarValue = ( udPark.getCarValue() - 1 );
		System.out.println("carOutPark3 ewCarValue ：" + newCarValue);
		udPark.setCarValue(newCarValue);
		System.out.println("carOutPark2 新" + udPark);
		pDao.update(udPark);
	}
	
	@Override
	public void carInPark(int parkId) {
		int newCarValue;
		System.out.println("carOutPark1");
		Park udPark = pDao.getById(parkId); 
		System.out.println("carOutPark2 旧的" + udPark);
		newCarValue = ( udPark.getCarValue() + 1 );
		System.out.println("carOutPark3 ewCarValue ：" + newCarValue);
		udPark.setCarValue(newCarValue);
		System.out.println("carOutPark2 新" + udPark);
		pDao.update(udPark);
	}



	@Override
	public int parkSpaceNum(int parkId) {
		int parkSpaceNum;
		Park park = pDao.getById(parkId); 
		parkSpaceNum = park.getMaxCarValue() - park.getCarValue();
		return parkSpaceNum;
		
	}



}
