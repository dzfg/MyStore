package com.iscc.store.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iscc.store.dao.Dao;
import com.iscc.store.domain.User;
import com.iscc.store.util.myDBConnection;

public class IUserDao implements Dao {

	// dao会频繁的操作数据库,所以我们将数据库工具类定义为成员变量
	private QueryRunner runner = new QueryRunner(myDBConnection.getDataSource());

	@Override
	public Integer register(User user) {

		String sql = "insert into user(uid,username,password,email,code) values (?,?,?,?,?)";

		try {
			return runner.update(sql, new Object[] { user.getUid(), user.getUsername(), user.getPassword(),
					user.getEmail(), user.getCode() });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 为了编译通过.
		return null;
	}

	@Override
	public User findUserByUsername(String username) {

		String sql = "select uid from user where username = ?";

		try {
			return runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User login(String username, String password) {

		String sql = "select * from user where username=? and password=?";

		// 调用数据库工具类
		try {
			return runner.query(sql, new BeanHandler<User>(User.class), new Object[] { username, password });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int activateUserByCode(String code) {
		
		String sql = "update user set state = 1 where code = ?";
		
		try {
			return runner.update(sql, code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
