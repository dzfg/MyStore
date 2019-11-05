package com.iscc.store.service.impl;

import com.iscc.store.dao.Dao;
import com.iscc.store.dao.impl.IUserDao;
import com.iscc.store.domain.User;
import com.iscc.store.service.Service;

public class IUserService implements Service {
	
	private Dao dao = new IUserDao();
	
	@Override
	public Integer register(User user) {
		return dao.register(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.login(username,password);
	}

	@Override
	public int activateUserByCode(String code) {
		return dao.activateUserByCode(code);
	}


}
