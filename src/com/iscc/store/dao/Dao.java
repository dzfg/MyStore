package com.iscc.store.dao;

import com.iscc.store.domain.User;

/**
 * dao层接口
 */
public interface Dao {

	/**
	 * 用户注册功能
	 * 
	 * @param user
	 * @return
	 */
	Integer register(User user);

	/**
	 * 根据用户名来查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);

	/**
	 * 登录功能
	 * @param password 
	 * @param username 
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 通过邮箱链接激活用户
	 * @param code
	 * @return
	 */
	int activateUserByCode(String code);

}
