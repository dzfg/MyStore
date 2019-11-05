package com.iscc.store.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类
 */
public class myDBConnection {

	// 既然是工具类,首先必须要私有化构造方法
	private myDBConnection() {

	}

	/**
	 * 获取到连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取到数据源对象
	 */
	public static DataSource getDataSource() {

		ComboPooledDataSource source = new ComboPooledDataSource();

		return source;
	}

}
