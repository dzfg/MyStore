package com.iscc.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iscc.store.service.Service;
import com.iscc.store.service.impl.IUserService;

@WebServlet("/activateUserServlet2")
public class ActivateUserServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivateUserServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取到前台的激活码
		String code = request.getParameter("code");
		
		//调用服务层
		Service service = new IUserService();
		int line =service.activateUserByCode(code);
		
		if(line == 0) {
			response.getWriter().write("用户激活失败,系统将在1S后自动调转到主页面");
			response.setHeader("refresh", "1;url=/myStore/index.jsp");
			
			return;
		}
		
		response.getWriter().write("用户激活成功,系统将在1S后自动调转到登录界面");
		//用户激活成功,清除session
		request.getSession().invalidate();
		response.setHeader("refresh", "1;url=/myStore/login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
