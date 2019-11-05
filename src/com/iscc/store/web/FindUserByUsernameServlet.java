package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iscc.store.domain.User;
import com.iscc.store.service.Service;
import com.iscc.store.service.impl.IUserService;

/**
 * 根据用户名字来查看是否存在此用户
 */
@WebServlet("/findUserByUsernameServlet")
public class FindUserByUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindUserByUsernameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		Service service = new IUserService();
		User user = service.findUserByUsername(username);

		// 0表示不存在
		if (user == null) {
			response.getWriter().write("0");
		} else {
			response.getWriter().write("1");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
