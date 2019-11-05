package com.iscc.store.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iscc.store.domain.User;
import com.iscc.store.service.Service;
import com.iscc.store.service.impl.IUserService;
import com.iscc.store.util.Md5Utils;
import com.iscc.store.util.UUIDUtils;

/**
 * 用户的注册功能
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和相应的编码,先设置在这里便于测试,后期采用过滤器进行处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uid = UUIDUtils.getNewUUID();
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		// 采用md5对密码进行加密
		String newPassword = null;
		try {
			newPassword = Md5Utils.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");

		// 用UUIDUtils工具类做为用户的code
		String code = UUIDUtils.getNewUUID();

		User user = new User(uid, username, newPassword, email, code);

		Service service = new IUserService();
		Integer line = service.register(user);

		if (line > 0) {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("注册成功, 1s后将跳转至登录页面");
			response.setHeader("refresh", "1;url=/myStore/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
