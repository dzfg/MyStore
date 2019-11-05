package com.iscc.store.service;

import com.iscc.store.domain.User;

/**
 *服务层接口
 */
public interface Service {

	/**
	 * 用户注册功能
	 * @param user
	 * @return
	 */
	Integer register(User user);

	/**
	 * 根据用户名来查看是否有此用户
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
