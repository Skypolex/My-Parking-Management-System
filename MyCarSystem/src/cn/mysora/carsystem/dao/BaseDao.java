package cn.mysora.carsystem.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * 数据库基础操作 
 * 接口方法定义
 * @author xarox
 *
 */
public interface BaseDao {

	public void openCon();
	public void closeAll();
	
	public ResultSet executeQuery(String sql,List<Object> objs);
	public int executeUpdate(String sql,List<Object> objs);
}
