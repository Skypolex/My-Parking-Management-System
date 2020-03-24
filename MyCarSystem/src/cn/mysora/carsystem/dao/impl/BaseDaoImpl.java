package cn.mysora.carsystem.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import cn.mysora.carsystem.dao.BaseDao;

/**
 * 数据库基础操作实现类
 * @author xarox
 *
 */

public class BaseDaoImpl implements BaseDao {

	public static String DRIVER;
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;
	
	public Connection con = null;
	public PreparedStatement pstm = null;
	public ResultSet rs = null;
	public int flag = -1; //执行Flag
	
	
	@Override
	public void openCon() {
		try {
			
	        //读取类路径下的 jdbc.properties 文件  
	        InputStream in =   
	                getClass().getClassLoader().getResourceAsStream("/jdbc.properties");  
	        Properties properties = new Properties();  
	        properties.load(in);  
	        DRIVER = properties.getProperty("driverClassName");  
	        URL = properties.getProperty("url");  
	        USERNAME = properties.getProperty("username");  
	        PASSWORD = properties.getProperty("password");  
	          
	        Driver driver =   
	                (Driver) Class.forName(DRIVER).newInstance();  
	          
	        Properties info = new Properties();  
	        info.put("user", USERNAME);  
	        info.put("password", PASSWORD);  
	          
	        //通过 Driver 的 connect 方法获取数据库连接.   
	        con = driver.connect(URL, info);  
			

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BaseDaoImpl：openCon()已连接到数据库");
	}


	@Override
	public void closeAll() {
		try {
			if(rs!=null)
				rs.close();
			if(pstm!=null)
				pstm.close();
			if(con!=null &&!con.isClosed())
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BaseDaoImpl：closeAll() 数据库连接已关闭");

	}

	@Override
	public ResultSet executeQuery(String sql, List<Object> objs) {
		//1.打开数据库连接
		this.openCon();
		//2.创建prepareStatement
		try {
			System.out.println("BaseDaoImpl：创建prepareStatement,准备执行sql");
			pstm = con.prepareStatement(sql);
			System.out.println("BaseDaoImpl：已发送sql语句");
			if(objs != null){
				for(int i = 0; i < objs.size(); i++){
					pstm.setObject(i + 1, objs.get(i));
				}
			}		
			//3.完成数据库中的操作
			rs = pstm.executeQuery();

		} catch (SQLException e) {
			System.out.println("BaseDaoImpl：executeQuery 数据库异常");
			e.printStackTrace();
		}
		
		//4.关闭所有数据库操作对象
		//this.closeAll();
		//要返回结果集rs不能关闭连接
		
		
		System.out.println("BaseDaoImpl：已得到结果集rs，返回");
		return rs;
	}

	@Override
	public int executeUpdate(String sql, List<Object> objs) {
		this.openCon();
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("BaseDaoImpl：已发送sql语句");
			if(objs != null){
				for(int i = 0 ; i < objs.size(); i++){
					pstm.setObject(i + 1, objs.get(i));
				}
			}
			System.out.println("BaseDaoImpl：发送执行完毕");
			flag = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BaseDaoImpl：executeUpdate数据库异常");
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag; //返回执行标记
	}

}


