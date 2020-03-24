package cn.mysora.carsystem.biz.impl;

import java.util.List;

import cn.mysora.carsystem.biz.MemberCarBiz;
import cn.mysora.carsystem.dao.MemberCarDao;
import cn.mysora.carsystem.dao.impl.MemberCarDaoImpl;
import cn.mysora.carsystem.entity.MemberCar;

/**
 * 成员车辆信息 操作 业务层
 * 方法实现
 * @author xarox
 *
 */
public class MemberCarBizImpl implements MemberCarBiz {

	MemberCarDao mDao = new MemberCarDaoImpl();
	
	@Override
	public List<MemberCar> getAll() {
		return mDao.getAll();
	}

	@Override
	public MemberCar getById(int id) {
		return mDao.getById(id);
	}

	@Override
	public MemberCar getBycarNumber(String carNumber) {
		return mDao.getBycarNumber(carNumber);
	}

	@Override
	public int save(MemberCar memberCar) {
		return mDao.save(memberCar);
	}

	@Override
	public int update(MemberCar memberCar) {
		return mDao.update(memberCar);
	}

	@Override
	public int delete(MemberCar memberCar) {
		return mDao.delete(memberCar);
	}

	@Override
	public boolean isMember(String carNumber) {
		
		MemberCar memberCar = mDao.getBycarNumber(carNumber);
		
		if (memberCar == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	

}
