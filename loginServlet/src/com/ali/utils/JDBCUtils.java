package com.ali.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * JDBC�����࣬ʹ��Druid���ӳ�
 *
 */
public class JDBCUtils {
	private static DataSource ds;
	static {
		try {
			//1.���������ļ�
			Properties pro = new Properties();
			//2.ClassLoader���������ļ�
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			//3.���ص�����Դ��
			pro.load(is);
			//4.��ʼ�����ӳض���
			ds = DruidDataSourceFactory.createDataSource(pro);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	 * ��ȡ���ӳض���
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	
	/*
	 * ��ÿ���״̬�����Ӷ���
	 */
	public static Connection getConection() throws SQLException{
		return ds.getConnection();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}