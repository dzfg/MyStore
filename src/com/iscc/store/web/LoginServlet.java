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

/**
 * 登录校验
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String newPassword = null;
		try {
			newPassword = Md5Utils.EncoderByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Service service = new IUserService();
		User user = service.login(username,newPassword);
		
		//用户不存在
		if(user==null) {
			//将用户存进request域对象中
			request.setAttribute("username", username);
			//将错误信息存入到usernameMsg中
			request.setAttribute("usernameMsg", "用户名或密码错误哦..");
			//请求转发到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			return;
		}
		
		//用户存在
		//将用户存进request域对象中
		request.getSession().setAttribute("user",user);
		// 然后重定向到主页面
		response.getWriter().write("登录成功,系统将在1S后自动调转到主页面");
		response.setHeader("refresh", "1;url=/myStore/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
